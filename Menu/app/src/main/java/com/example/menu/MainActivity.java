package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton image = (ImageButton) findViewById(R.id.imageButton);
        image.setOnCreateContextMenuListener(this);
        Button b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),popupmenu.class);
                startActivity(i);
                finish();
            }
        });

        
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu);
        CreateMenu(menu);
        return true;
}
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        super.onCreateContextMenu(menu, v, menuInfo);
        CreateMenu(menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        // return super.onContextItemSelected(item);
        return MenuChoice(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        return MenuChoice(item);
    }

    private boolean MenuChoice(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                Toast.makeText(this, "Item 1 is clicked", Toast.LENGTH_LONG).show();
                return true;
            case 1:
                Toast.makeText(this, "Item 2 is clicked", Toast.LENGTH_LONG).show();
                return true;
            case 2:
                Toast.makeText(this, "Item 3 is clicked", Toast.LENGTH_LONG).show();
                return true;
            case 3:
                Toast.makeText(this, "Item 4 is clicked", Toast.LENGTH_LONG).show();
                return true;
            case 4:
                Toast.makeText(this, "Item 5 is clicked", Toast.LENGTH_LONG).show();
                return true;
            case 5:
                Toast.makeText(this, "Item 6 is clicked", Toast.LENGTH_LONG).show();
                return true;
            case 6:
                Toast.makeText(this, "Item 7 is clicked", Toast.LENGTH_LONG).show();
                return true;
            case 7:
                Toast.makeText(this, "Item 8 is clicked", Toast.LENGTH_LONG).show();
                return true;
            case 8:
                Toast.makeText(this, "Item 9 is clicked", Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }


    private void CreateMenu(Menu menu) {
        MenuItem menu1 = menu.add(0, 0, 0, "Item 1");
        {
            menu1.setAlphabeticShortcut('d');
            menu1.setIcon(R.drawable.ic_launcher_background);
        }
        MenuItem menu2 = menu.add(0, 1, 1, "Item 2");
        {
            menu2.setAlphabeticShortcut('w');
            menu2.setIcon(R.drawable.ic_launcher_background);
        }
        MenuItem menu3 = menu.add(0, 2, 2, "Item 3");
        {
            menu3.setAlphabeticShortcut('m');
            menu3.setIcon(R.drawable.ic_launcher_background);
        }
        MenuItem menu4 = menu.add(0, 3, 3, "Item 4");
        {
            menu4.setAlphabeticShortcut('u');
            menu4.setIcon(R.drawable.ic_launcher_background);
        }
        MenuItem menu5 = menu.add(0, 4, 4, "Item 5");
        {
            menu5.setAlphabeticShortcut('o');
            menu5.setIcon(R.drawable.ic_launcher_background);
        }
        MenuItem menu6 = menu.add(0, 5, 5, "Item 6");
        {
            menu6.setAlphabeticShortcut('b');
            menu6.setIcon(R.drawable.ic_launcher_background);
        }
        MenuItem menu7 = menu.add(0, 6, 6, "Item 7");
        {
            menu7.setAlphabeticShortcut('c');
            menu7.setIcon(R.drawable.ic_launcher_background);
        }
        MenuItem menu8 = menu.add(0, 8, 8, "Item 8");
        {
            menu8.setNumericShortcut('8');
            menu8.setIcon(R.drawable.ic_launcher_background);
        }
        MenuItem menu9 = menu.add(0, 9, 9, "Item 9");
        {
            menu9.setNumericShortcut('9');
            menu9.setIcon(R.drawable.ic_launcher_background);
        }
    }
    }
