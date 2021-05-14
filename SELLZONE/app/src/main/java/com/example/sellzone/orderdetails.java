package com.example.sellzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class orderdetails extends AppCompatActivity {
    TextView cour,categ,nam;
    Button bk;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME ="mypref";
    private static final String KEY_COURSE = "course";
    private static final String KEY_CATEGORIES = "category";
    private static final String KEY_name= "NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderdetails);
        cour = findViewById(R.id.course1);
        categ = findViewById(R.id.categories);
        nam = findViewById(R.id.name);
        bk = findViewById(R.id.back);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String courses1 = sharedPreferences.getString(KEY_COURSE, null);
        String category = sharedPreferences.getString(KEY_CATEGORIES,null);
        String name1 = sharedPreferences.getString(KEY_name,null);

        if (name1 != null || courses1 !=null || category !=null) {
            nam.setText("NAME:" +name1);
            cour.setText("COURSES:" +courses1);
            categ.setText("CATEGORY:" +category);

        }

        bk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Intent intent = new Intent(orderdetails.this,sell.class);
                startActivity(intent);
            }
        });
    }
}