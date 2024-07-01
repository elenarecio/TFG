package com.example.tfg.BaseDatos;

import androidx.annotation.NonNull;

public class Nacimiento {
    private long id;
    private String nombre, raza, sexo, crotal, crotal_madre, crotal_padre;


    public Nacimiento(String nombre, String raza, String sexo, String crotal, String crotal_madre, String crotal_padre) {
        this.nombre = nombre;
        this.raza = raza;
        this.sexo = sexo;
        this.crotal = crotal;
        this.crotal_madre = crotal_madre;
        this.crotal_padre = crotal_padre;
    }

    public Nacimiento(long id, String nombre, String raza, String sexo, String crotal, String crotal_madre, String crotal_padre) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.sexo = sexo;
        this.crotal = crotal;
        this.crotal_madre = crotal_madre;
        this.crotal_padre = crotal_padre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCrotal() {
        return crotal;
    }

    public void setCrotal(String crotal) {
        this.crotal = crotal;
    }

    public String getCrotal_madre() {
        return crotal_madre;
    }

    public void setCrotal_madre(String crotal_madre) {
        this.crotal_madre = crotal_madre;
    }

    public String getCrotal_padre() {
        return crotal_padre;
    }

    public void setCrotal_padre(String crotal_padre) {
        this.crotal_padre = crotal_padre;
    }
}














/**import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Date;

public class Nacimiento extends BD {

    Context context;

    public Nacimiento(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarNacimiento(String nombre, String crotal, String crotal_madre, String crotal_padre, String sexo, /*Date fecha_nac,*//** String raza) {
        long id = -1;  // Inicializa id
        SQLiteDatabase base = null;

        try {
            BD bd = new BD(context);
            base = bd.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("crotal", crotal);
            values.put("crotal_madre", crotal_madre);
            values.put("crotal_padre", crotal_padre);
            values.put("sexo", sexo);
            //values.put("fecha_nac", fecha_nac.getTime());
            values.put("raza", raza);

            id = base.insert(TABLA_ANIMALES, null, values);  // Usa base en vez de bd

        } catch (Exception ex) {
            Log.e("Nacimiento", "Error inserting data: " + ex.toString());
        } finally {
            if (base != null) {
                base.close();
            }
        }

        return id;
    }
}
*/