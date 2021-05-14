package com.example.lab3;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


public class NewActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void call(View view) {
        Intent i= new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:+917899863930"));
        startActivity(i);

    }

    public void map(View view) {
        Intent a=new Intent(Intent.ACTION_VIEW);
        a.setData(Uri.parse("geo:12.3656489.88.4569875"));
        Intent chooser= Intent.createChooser(a, "Reach us via: ");
        startActivity(chooser);


    }

    public void mail(View view) {
        Intent j=new Intent(Intent.ACTION_SEND);
        j.setData(Uri.parse("email"));
        String[] s={"Laxmy.narayan@cs.christuniversity.in"};
        j.putExtra(Intent.EXTRA_EMAIL,s);
        j.putExtra(Intent.EXTRA_SUBJECT,"Complaint register");
        j.putExtra(Intent.EXTRA_TEXT,"");
        j.setType("message/rfc822");
        Intent chooser = Intent.createChooser(j,"Mail Us Via:");
        startActivity(chooser);

    }

    public void website(View view) {
        String url="https://christuniversity.in/";
        Intent s=new Intent(Intent.ACTION_VIEW);
        s.setData(Uri.parse(url));
        startActivity(s);

    }
}