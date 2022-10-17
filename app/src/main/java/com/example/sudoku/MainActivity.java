package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TableLayout tablita= findViewById(R.id.table);
        CharSequence[] nombres = {"♠","1","2","3","4","5","6","7","8","9"};

        for(int i=0;i<9;i++){
            TableRow rowy=new TableRow(this);
            for(int j=0;j<9;j++){
                Spinner sp=new Spinner(this);
                sp.setBackground(null);
                sp.setPadding(5, 5, 5, 5);
                ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                        android.R.layout.simple_spinner_item, nombres);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp.setAdapter(adapter);
                rowy.addView(sp);

            }
            tablita.addView(rowy);
        }
    }
}