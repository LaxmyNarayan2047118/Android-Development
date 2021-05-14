package com.example.lab3;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {
    TextView nam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nam = findViewById(R.id.name);
        nam.setText(getIntent().getExtras().getString("value"));
    }

    public void next(View view) {
        Intent intent=new Intent(NewActivity.this,NewActivity2.class);
        startActivity(intent);
        finish();
    }


}


