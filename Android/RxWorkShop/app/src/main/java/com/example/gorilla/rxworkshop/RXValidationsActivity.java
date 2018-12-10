package com.example.gorilla.rxworkshop;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RXValidationsActivity extends AppCompatActivity {

    private Pattern pattern = android.util.Patterns.EMAIL_ADDRESS;
    private Matcher matcher;
    private EditText editTextCount;
    private EditText editTextUsername;
    private ListView list_view_repos;
    private EditText editTextPassword;
    private TextInputLayout textInputLayoutUser;
    private TextInputLayout textInputLayoutPassword;
    private LinearLayout linearLayoutSignIn;
    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_validations);

        editTextCount = findViewById(R.id.edit_text_count);
        editTextUsername = findViewById(R.id.email_et);
        editTextPassword = findViewById(R.id.password_et);
        list_view_repos = findViewById(R.id.list_view_repos);
        textInputLayoutUser = findViewById(R.id.email_til);
        textInputLayoutPassword = findViewById(R.id.password_til);
        linearLayoutSignIn = findViewById(R.id.sign_in_ll);
        btnSignIn = findViewById(R.id.sign_in_btn);
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
