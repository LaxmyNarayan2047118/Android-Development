package com.example.sellzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class sell extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView t1;
    CheckBox c1,c2;
    RadioGroup rg;
    Button b1,b2;
    RadioButton rb;
    private String cou;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME ="mypref";
    private static final String KEY_COURSE = "course";
    private static final String KEY_CATEGORIES = "category";
    private static final String KEY_COD = "cod";
    private static final String KEY_EPAY = "epay";



    String[] categories = { "BOOKS", "LAPTOPS", "ELECTRONIC GADGETS", "Others"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        Log.i("lifecycle","Park onCreate invoked");

        t1=(TextView)findViewById(R.id.title);
        Bundle b = getIntent().getExtras();
        String nm=b.getString("log");
        t1.setText("Welcome "+nm);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);


        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,categories);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(aa);

        c1=(CheckBox)findViewById(R.id.cod);
        c2=(CheckBox)findViewById(R.id.epay);
        rg=(RadioGroup)findViewById(R.id.course);
        b1=(Button)findViewById(R.id.submit);
        b2=(Button)findViewById(R.id.b2);

        String op = sharedPreferences.getString(KEY_COURSE,null);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sid=rg.getCheckedRadioButtonId();
                rb=(RadioButton)rg.findViewById(sid);
                cou = rb.getText().toString();

                String sel,sel1;
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_COURSE, cou);
                editor.putString(KEY_CATEGORIES,spin.getSelectedItem().toString());
                editor.apply();
                if(c1.isChecked()) {
                    editor.putBoolean(KEY_COD,true);
                    editor.apply();
                    sel="Yes";
                }
                else {
                    sel = "No";
                    editor.putBoolean(KEY_COD, false);
                    editor.apply();
                }
                if(c2.isChecked()) {
                    editor.putBoolean(KEY_EPAY,true);
                    editor.apply();
                    sel1 = "Yes";
                }
                else
                    { editor.putBoolean(KEY_EPAY,false);
                    editor.apply();
                       sel1="No";
                    }
                Toast toast=Toast.makeText(getApplicationContext(),"Sold: "+rb.getText().toString()+" item sold: "+sel+" mode : "+sel1,Toast.LENGTH_SHORT);
                toast.show();
                if( op != null ){
                    Intent intent = new Intent(sell.this,orderdetails.class);
                    startActivity(intent);
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),experience.class);
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
        Toast.makeText(getApplicationContext(),categories[position] , Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}