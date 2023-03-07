package com.example.projectrestoandroid.modele.dao;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import static com.example.projectrestoandroid.modele.dao.StructureBDD.*;

import com.example.projectrestoandroid.modele.metier.Resto;

public class DaoResto extends SQLiteOpenHelper {

    public DaoResto(Context context) {
        super(context, "Restaurant", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Resto(_id INTEGER PRIMARY KEY, nom TEXT, ville TEXT");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS Resto ");
        onCreate(db);
    }

    public void insertResto(Resto p)
    {

    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues cv = new ContentValues();
    cv.put("nom",p.getNom());
    cv.put("ville",p.getVille());

    db.insert("resto", null, cv);
    db.close();
    }

    public void updateProduct(Resto r)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("nom",r.getNom());
        cv.put("ville",r.getVille());

        db.update("resto", cv, "_id=?", new String[]{String.valueOf(r.getId())});
        db.close();
    }
}
