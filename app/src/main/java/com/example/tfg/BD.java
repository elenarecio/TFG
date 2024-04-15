package com.example.tfg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BD extends SQLiteOpenHelper {
    private static final int version=1;
    private static final String name="TFG";

    public BD(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE animales" +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        "crotal TEXT UNIQUE NOT NULL,"+
                        "raza TEXT NOT NULL);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}















