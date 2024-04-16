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

        sqLiteDatabase.execSQL("CREATE TABLE nacimientos" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "crotal_madre TEXT UNIQUE NOT NULL,"+
                "ubicacion TEXT );");

        sqLiteDatabase.execSQL("CREATE TABLE muertes" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "causa TEXT,"+
                "ubicacion TEXT);");

        sqLiteDatabase.execSQL("CREATE TABLE compras" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "explotacion_procedente TEXT UNIQUE NOT NULL,"+
                "crotal TEXT );");

        sqLiteDatabase.execSQL("CREATE TABLE venta" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "explotacion_destino TEXT UNIQUE NOT NULL,"+
                "crotal TEXT );");

        sqLiteDatabase.execSQL("CREATE TABLE saneamientos_privados" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "prueba TEXT UNIQUE NOT NULL,"+
                "ubicacion TEXT );");

        sqLiteDatabase.execSQL("CREATE TABLE saneamientos_obligatorios" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "prueba TEXT UNIQUE NOT NULL,"+
                "ubicacion TEXT );");

        sqLiteDatabase.execSQL("CREATE TABLE ubicacion" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "nombre TEXT UNIQUE NOT NULL,"+
                "tipo TEXT );");

        sqLiteDatabase.execSQL("CREATE TABLE saneamientos_privados" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "prueba TEXT UNIQUE NOT NULL,"+
                "ubicacion TEXT );");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}















