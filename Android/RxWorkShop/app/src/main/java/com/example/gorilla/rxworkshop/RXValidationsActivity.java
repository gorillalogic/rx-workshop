package com.example.gorilla.rxworkshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ListView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RXValidationsActivity extends AppCompatActivity {

    private Pattern pattern = android.util.Patterns.EMAIL_ADDRESS;
    private Matcher matcher;
    private EditText editTextCount;
    private EditText editTextUsername;
    private ListView list_view_repos;
    private EditText editTextLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_validations);
        editTextCount = findViewById(R.id.edit_text_count);
        editTextUsername = findViewById(R.id.edit_text_username);
        list_view_repos = findViewById(R.id.list_view_repos);
        editTextLanguage = findViewById(R.id.edit_text_language);
    }


    private boolean validateEmail(String email) {
        if (TextUtils.isEmpty(email))
            return false;

        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
