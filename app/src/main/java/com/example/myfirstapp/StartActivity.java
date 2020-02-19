package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    // Called when the user taps the 'Let's Start' button
    public void SendName(View view)
    {
        EditText editText = findViewById(R.id.editTextEnterName);
        String name = editText.getText().toString();
        if( name.isEmpty() )
        {
            Toast.makeText( this, R.string.toast_error, Toast.LENGTH_LONG ).show();
            return;
        }
        Intent intent = new Intent(this, ListImageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, name);
        startActivity(intent);
    }
}
