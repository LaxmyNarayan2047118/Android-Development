package com.example.carrent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Rent extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener  {

    TextView t1;
    CheckBox c1,c2;
    RadioGroup rg;
    Button b1,b2;
    RadioButton rb;
    String[] types = { "sedan", "suv", "micro", "sport", "Other"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);
        Log.i("lifecycle","Park onCreate invoked");

        t1=(TextView)findViewById(R.id.title);
        Bundle b = getIntent().getExtras();
        String nm=b.getString("log");
        t1.setText("Welcome "+nm);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);


        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,types);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(aa);

        c1=(CheckBox)findViewById(R.id.Handicapped);
        c2=(CheckBox)findViewById(R.id.staff);
        rg=(RadioGroup)findViewById(R.id.size);
        b1=(Button)findViewById(R.id.submit);
        b2=(Button)findViewById(R.id.b2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sid=rg.getCheckedRadioButtonId();
                rb=(RadioButton)findViewById(sid);
                String sel,sel1;
                if(c1.isChecked())
                    sel="Yes";
                else
                    sel="No";
                if(c2.isChecked())
                    sel1="Yes";
                else
                    sel1="No";
                Toast toast=Toast.makeText(getApplicationContext(),"Parked: "+rb.getText().toString()+" Vehicle Handicapped: "+sel+" Staff: "+sel1,Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Rate.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("lifecycle","Park onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("lifecycle","Park onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("lifecycle","Park onPause invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("lifecycle","Park onStop invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("lifecycle","Park onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("lifecycle","Park onDestroy invoked");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),types[position] , Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
