package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    EditText user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            setContentView(R.layout.activity_main);

            user = findViewById(R.id.username);
            pass = findViewById(R.id.pass);

        }

        public void login (View view){
            Intent intent = new Intent(MainActivity.this, NewActivity.class);
            intent.putExtra("value", user.getText().toString());
            startActivity(intent);
            finish();
        }


    }
