package com.example.menu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import static com.example.menu.R.id;
import static com.example.menu.R.layout;
import static com.example.menu.R.menu;

public class popupmenu extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_popupmenu);
        Button b3 = (Button) findViewById(id.b3);
        b3.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(popupmenu.this, v);
            popup.setOnMenuItemClickListener(popupmenu.this);
            popup.inflate(menu.main);
            popup.show();
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case id.search_item:
            case id.upload_item:
            case id.copy_item:
            case id.print_item:
            case id.share_item:
            case id.bookmark_item:
                // do your code
                return true;
            default:
                return false;
        }

    }
}