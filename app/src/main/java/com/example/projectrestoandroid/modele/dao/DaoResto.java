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

        db.execSQL("CREATE TABLE Resto(_id INTEGER PRIMARY KEY, nom TEXT, ville TEXT)");
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

    public void deleteResto(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        db.delete("resto", "_id=?", new String[]{String.valueOf(id)});
    }

    public Cursor getAllResto()
    {
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor c=db.rawQuery("SELECT * FROM resto", null);

        return c;
    }

    public Resto getOneResto(int id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.query("resto",new String[]{"_id","nom","ville"},"_id=?",
                new String[]{String.valueOf(id)}, null, null, null);

        c.moveToFirst();
        Resto r=new Resto(c.getInt(0),c.getString(1),c.getString(2));

        return r;
    }

}
