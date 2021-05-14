package com.example.navbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class info extends AppCompatActivity {

TextView name , regno, score;

    SharedPreferences prefs;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_NAME = "NAME";
    public static final String KEY_REGNO = "REGNO";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        name = findViewById(R.id.textView5);
        regno = findViewById( R.id.textView6);
        score = findViewById( R.id.textView7);
        prefs = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        String name1 = prefs.getString(KEY_NAME, null);
        int regn= prefs.getInt(KEY_REGNO,0);
        int scr = prefs.getInt(KEY_HIGHSCORE,0);


        if (name1 != null) {
            name.setText("NAME:" +name1);
            regno.setText("REGNO:" +regn);
            score.setText("SCORE(AS there are only 1 question):" +scr);

        }
    }
}