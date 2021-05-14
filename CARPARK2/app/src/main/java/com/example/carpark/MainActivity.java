package com.example.carpark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("lifecycle","MainActivity onCreate invoked");
        b1=(Button)findViewById(R.id.b1);
        e1=(EditText)findViewById(R.id.unm);
        e2=(EditText)findViewById(R.id.pwd);

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), Park.class);
                i.putExtra("log",e1.getText().toString());
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("lifecycle","MainActivity onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("lifecycle","MainActivity onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("lifecycle","MainActivity onPause invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("lifecycle","MainActivity onStop invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("lifecycle","MainActivity onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("lifecycle","MainActivity onDestroy invoked");
    }

}
