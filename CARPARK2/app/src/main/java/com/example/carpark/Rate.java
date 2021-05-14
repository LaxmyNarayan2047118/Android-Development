package com.example.carpark;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;



import com.google.android.material.snackbar.Snackbar;


public class Rate extends AppCompatActivity {

    Button b1,b2;
    RatingBar rb;
    String totalStars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        Log.i("lifecycle","Rate onCreate invoked");

        b1=(Button)findViewById(R.id.r);
        b2=(Button)findViewById(R.id.ex);
        rb=(RatingBar)findViewById(R.id.rated);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalStars="Rating: "+rb.getRating();
                Snackbar snackbar = Snackbar.make(view, totalStars,Snackbar.LENGTH_LONG);
                snackbar.show();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("lifecycle","Rate onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("lifecycle","Rate onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("lifecycle","Rate onPause invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("lifecycle","Rate onStop invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("lifecycle","Rate onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("lifecycle","Rate onDestroy invoked");
    }
}
