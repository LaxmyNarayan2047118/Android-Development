package com.example.lncrickscore;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScorecardAdapterClass extends RecyclerView.Adapter<ScorecardAdapterClass.ViewHolder>{

    List<ScorecardModelClass> card;
    Context context;
    databaseHelperClass databaseHelperClass;

    public ScorecardAdapterClass(List<ScorecardModelClass> card, Context context) {
        this.card = card;
        this.context = context;
        databaseHelperClass = new databaseHelperClass(context);
    }

    @NonNull
    @Override
    public ScorecardAdapterClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.scorecard,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ScorecardAdapterClass.ViewHolder holder, int position) {
        final ScorecardModelClass scorecardModelClass = card.get(position);
        holder.et_team1.setText(scorecardModelClass.getTeam1());
        holder.et_team2.setText(scorecardModelClass.getTeam2());
        holder.et_score1.setText(scorecardModelClass.getScore1());
        holder.et_score2.setText(scorecardModelClass.getScore2());
        holder.et_over1.setText(scorecardModelClass.getOver1());
        holder.et_over2.setText(scorecardModelClass.getOver2());

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Stringteam1 = holder.et_team1.getText().toString();
                String Stringteam2 = holder.et_team2.getText().toString();
                String Stringscore1 = holder.et_score1.getText().toString();
                String Stringscore2 = holder.et_score2.getText().toString();
                String Stringover1 = holder.et_over1.getText().toString();
                String Stringover2 = holder.et_over2.getText().toString();

                databaseHelperClass.updateScorecard(new ScorecardModelClass(scorecardModelClass.getId(),Stringteam1,Stringteam2,
                        Stringscore1,Stringscore2,Stringover1,Stringover2));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deleteScorecard(scorecardModelClass.getId());
                card.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return card.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        EditText et_team1,et_team2,et_score1,et_score2,et_over1,et_over2;
        Button edit,delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            et_team1 = itemView.findViewById(R.id.et_team1);
            et_team2 = itemView.findViewById(R.id.et_team2);
            et_score1 = itemView.findViewById(R.id.et_score1);
            et_score2 = itemView.findViewById(R.id.et_score2);
            et_over1 = itemView.findViewById(R.id.et_over1);
            et_over2 = itemView.findViewById(R.id.et_over2);
            edit = itemView.findViewById(R.id.edit);
            delete = itemView.findViewById(R.id.delete);


        }
    }

}
