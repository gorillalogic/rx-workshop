package com.example.gorilla.rxworkshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.jakewharton.rxbinding3.view.RxView;

import java.util.Objects;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity {

    private CompositeDisposable compositeDisposable;

    private Button starred_btn;
    private Button filterByLanguage_btn;
    private Button rxValidate_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compositeDisposable = new CompositeDisposable();

        starred_btn = findViewById(R.id.starred_btn);
        filterByLanguage_btn = findViewById(R.id.filter_btn);
        rxValidate_btn = findViewById(R.id.rx_validate_btn);

        compositeDisposable.addAll(
                RxView.clicks(starred_btn)
                        .subscribe(view -> startActivity(new Intent(this, StarredReposActivity.class))),

                RxView.clicks(filterByLanguage_btn)
                        .subscribe(view -> startActivity(new Intent(this, FilteredByLanguageActivity.class))),

                RxView.clicks(rxValidate_btn)
                        .subscribe(btn -> startActivity(new Intent(this, RXValidationsActivity.class))));

    }

    @Override
    protected void onDestroy() {
        if (Objects.nonNull(compositeDisposable) && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
        super.onDestroy();
    }
}
