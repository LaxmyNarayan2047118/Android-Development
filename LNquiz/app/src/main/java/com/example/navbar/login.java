package com.example.navbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
    EditText uname, registorno;
    Button b1;
    SharedPreferences prefs;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_NAME = "NAME";
    public static final String KEY_REGNO = "REGNO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1 = findViewById( R.id.b1);
        uname = findViewById(R.id.unm);
        registorno = findViewById(R.id.registorno);
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString(KEY_NAME,uname.getText().toString());
                editor.putInt(KEY_REGNO, Integer.parseInt(registorno.getText().toString()));
                editor.apply();
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}