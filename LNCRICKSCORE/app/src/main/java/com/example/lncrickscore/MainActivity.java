package com.example.lncrickscore;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText main_team2,main_team1;
    String score1,score2,over1,over2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_team1 = findViewById(R.id.main_team1);
        main_team2 = findViewById(R.id.main_team2);

    }

    public void add(View view) {
        String team1 = main_team1.getText().toString();
        String team2 = main_team2.getText().toString();
        String score1 = "0/0";
        String score2 = "0/0";
        String over1 = "0";
        String over2 = "0";
        if (team1.length() <=0 || team2.length() <=0){
            Toast.makeText(this,"Add Data",Toast.LENGTH_SHORT).show();
        }else {
            databaseHelperClass databaseHelperClass = new databaseHelperClass(this);
            ScorecardModelClass scorecardModelClass = new ScorecardModelClass(team1,team2,score1,score2,over1,over2);
            databaseHelperClass.addScorecard(scorecardModelClass);
            Toast.makeText(this,"Added Data",Toast.LENGTH_SHORT).show();
            main_team1.setText("");
            main_team2.setText("");
            Intent intent = new Intent(this,view_scorecard.class);
            startActivity(intent);
            //finish();
            //startActivity(getIntent());
        }
    }

    public void read(View view) {
        Intent intent = new Intent(this,view_scorecard.class);
        startActivity(intent);
    }
}