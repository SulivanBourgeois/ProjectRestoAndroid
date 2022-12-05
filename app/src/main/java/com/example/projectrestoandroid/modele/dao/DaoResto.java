package com.example.projectrestoandroid.modele.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import static com.example.projectrestoandroid.modele.dao.StructureBDD.*;

import com.example.projectrestoandroid.modele.metier.Resto;

public class DaoResto extends DAOModele{

    public DaoResto(Context context) {super(context);}

    public static long insererResto(Resto unResto) {
        ContentValues values = new ContentValues();

        values.put(COL_NOM_RESTO, unResto.getNomResto());
        values.put(COL_VILLE, unResto.getVille());

        return db.insert(TABLE_RESTO, null, values);
    }
}
