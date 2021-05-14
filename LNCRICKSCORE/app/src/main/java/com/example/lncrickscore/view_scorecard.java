package com.example.lncrickscore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class view_scorecard extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_scorecard);

        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);

        databaseHelperClass databaseHelperClass = new databaseHelperClass(this);
        List<ScorecardModelClass> scorecardModelClasses = databaseHelperClass.getScorecardList();
        if (scorecardModelClasses.size() > 0){
            ScorecardAdapterClass scorecardAdapterClass = new ScorecardAdapterClass(scorecardModelClasses,this);
            rv.setAdapter(scorecardAdapterClass);
        }else{
            Toast.makeText(this,"No DATA",Toast.LENGTH_SHORT).show();
        }

    }
}