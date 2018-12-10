package com.example.gorilla.rxworkshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class FilteredByLanguageActivity extends AppCompatActivity {

    private EditText editTextLanguageProgramming;
    private EditText editTextUserName;
    private Button   buttonSearch;
    private EditText editTextCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_filter_by_language);
        editTextLanguageProgramming = findViewById(R.id.edit_text_language);
        editTextUserName = findViewById(R.id.edit_text_username);
        buttonSearch = findViewById(R.id.button_search);
        editTextCount = findViewById(R.id.edit_text_count);

        //Consider to use RxTextView.textChanges()
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
