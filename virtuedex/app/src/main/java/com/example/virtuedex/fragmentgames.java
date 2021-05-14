package com.example.virtuedex;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragmentgames extends Fragment {

    public fragmentgames() {
        //required empty public constructor.
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        CheckBox c1;
        RadioGroup rg;
        final RadioButton[] rb = new RadioButton[1];
        Button b1;

        View v = inflater.inflate(R.layout.games_fragment, container, false);
        c1 = (CheckBox) v.findViewById(R.id.cod);
        rg = (RadioGroup) v.findViewById(R.id.course);
        b1 = (Button) v.findViewById(R.id.submit);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sid = rg.getCheckedRadioButtonId();
                rb[0] = (RadioButton) v.findViewById(sid);
                String sel;
                if (c1.isChecked())
                    sel = "Yes";
                else
                    sel = "No";
                Toast toast = Toast.makeText(getContext(), "selected: " + rb[0].getText().toString() + " remindMe: " + sel, Toast.LENGTH_SHORT);
                toast.show();


            }
        });
        return v;


    }
}
