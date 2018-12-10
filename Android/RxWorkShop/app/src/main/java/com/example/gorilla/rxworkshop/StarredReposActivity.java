package com.example.gorilla.rxworkshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.gorilla.rxworkshop.UI.GitHubRepoAdapter;
import com.example.gorilla.rxworkshop.networking.GitHubClient;
import com.jakewharton.rxbinding3.view.RxView;


import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class StarredReposActivity extends AppCompatActivity {

    private static final String TAG = StarredReposActivity.class.getSimpleName();
    private GitHubRepoAdapter adapter = new GitHubRepoAdapter();

    private CompositeDisposable compositeDisposable;
    private ListView listView;
    private EditText editTextUsername;
    private Button buttonSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starred_repos);

        compositeDisposable = new CompositeDisposable();

        listView = findViewById(R.id.list_view_repos);

        listView.setAdapter(adapter);

        editTextUsername = findViewById(R.id.edit_text_username);
        buttonSearch = findViewById(R.id.button_search);

        compositeDisposable.add(
                RxView.clicks(buttonSearch)
                        .subscribe(click -> {
                            final String username = editTextUsername.getText().toString();
                            if (!TextUtils.isEmpty(username)) {
                                getStarredRepos(username);
                            }
                        }));

    }


    private void getStarredRepos(String username) {

        compositeDisposable.add(
                GitHubClient.getInstance()
                        .getStarredRepos(username)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(gitHubRepos -> {
                                    Log.d(TAG, "In onNext()");
                                    adapter.setGitHubRepos(gitHubRepos);
                                },
                                error -> {
                                    error.printStackTrace();
                                    Log.d(TAG, "In onError()");
                                },
                                () -> Log.d(TAG, "In onCompleted()")));
    }

    @Override
    protected void onDestroy() {
        if (Objects.nonNull(compositeDisposable) && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
        super.onDestroy();
    }
}
