package com.example.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

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
                sp.setTag(R.id.col,j);
                sp.setTag(R.id.fila,i);
                sp.setTag("bug init");

                sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int k, long l) {
                        // la posició del spinner és 'i', però també es pot buscar amb
                        int fila = (int) adapterView.getTag(R.id.fila);
                        int col = (int) adapterView.getTag(R.id.col);
                        if (sp.getTag().equals("bug init")){
                            sp.setTag("guay");
                            return;
                        }
                        Toast.makeText(MainActivity.this, "fila: "+fila+" columna: "+col+" nuevo valor: "+k, Toast.LENGTH_SHORT).show();

                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                        // Another interface callback
                    }
                });


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