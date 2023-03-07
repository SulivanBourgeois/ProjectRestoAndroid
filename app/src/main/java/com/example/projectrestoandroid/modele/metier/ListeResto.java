package com.example.projectrestoandroid.modele.metier;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ThemedSpinnerAdapter;

import com.example.projectrestoandroid.R;

public class ListeResto extends AppCompatActivity{

    ListView ls;
    ThemedSpinnerAdapter.Helper h=new ThemedSpinnerAdapter.Helper(ListeResto.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ls=findViewById(R.id.Lst);

        Cursor c=h.getAllResto();

        SimpleCursorAdapter adapter=new SimpleCursorAdapter(ListeResto.this, R.layout.activity_main,c,
                String[]{c.getColumnName(0),c.getColumnName(1),c.getColumnName(2)},
        new int[]{R.id.id,R.id.nom,R.id.ville}, 1);
        ls.setOnItemClickListener
    }
}
