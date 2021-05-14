package com.example.hellotoast;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
    }
    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_button_toast, Toast.LENGTH_LONG);
        toast.show();
        TextView t =new TextView(MainActivity.this);
        t.setTextColor(Color.WHITE);
        Typeface t1=Typeface.create("serif",Typeface.BOLD);
        t.setTextSize(18);
        t.setText("LAB1 COMPLETED!.");
        t.setBackgroundColor(Color.GREEN);
        toast.setView(t);
        toast.show();

    }
}