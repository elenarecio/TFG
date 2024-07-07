package gestionganadera.ubu.tfgg.Controladores;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.util.Log;

import java.util.ArrayList;
import gestionganadera.ubu.tfgg.BD;
import gestionganadera.ubu.tfgg.Modelos.Animal;

public class AnimalesControlador {
    private BD bd;
    private String TABLA_ANIMALES = "t_animales";
    public AnimalesControlador (){
    }
    public void inicializarBD(Context context) {
        bd = new BD(context);
    }

    public int eliminarAnimal(Animal animal) {
        SQLiteDatabase base = bd.getWritableDatabase();
        String[] argumentos = {String.valueOf(animal.getId())};
        return base.delete(TABLA_ANIMALES, "id= ?", argumentos);
    }

    public long nuevoAnimal(Animal animal) {
        SQLiteDatabase base = bd.getWritableDatabase();
        ContentValues insertar = new ContentValues();
        insertar.put("nombre", animal.getNombre());
        insertar.put("crotal", animal.getCrotal());
        insertar.put("crotal_madre", animal.getCrotal_madre());
        insertar.put("crotal_padre", animal.getCrotal_padre());
        insertar.put("sexo", animal.getSexo());
        insertar.put("fecha_nac", animal.getFecha_nac());
        insertar.put("raza", animal.getRaza());

        long result = base.insert(TABLA_ANIMALES, null, insertar);
        if (result == -1) {
            Log.e("DB_ERROR", "Error al insertar animal en la base de datos");
        } else {
            Log.i("DB_SUCCESS", "Animal insertado con ID: " + result);
        }
        return result;
    }

    public int guardar(Animal animalGuardado) {
        SQLiteDatabase base = bd.getWritableDatabase();
        ContentValues actualizar = new ContentValues();
        actualizar.put("nombre", animalGuardado.getNombre());
        actualizar.put("crotal", animalGuardado.getCrotal());
        actualizar.put("crotal_madre", animalGuardado.getCrotal_madre());
        actualizar.put("crotal_padre", animalGuardado.getCrotal_padre());
        actualizar.put("sexo", animalGuardado.getSexo());
        actualizar.put("fecha_nac", animalGuardado.getFecha_nac());
        actualizar.put("raza", animalGuardado.getRaza());

        String campoActualizar = "id = ?";
        String[] campos = {String.valueOf(animalGuardado.getId())};
        return base.update(TABLA_ANIMALES, actualizar, campoActualizar, campos);
    }

    public ArrayList<Animal> listarAnimales() {
        ArrayList<Animal> animales = new ArrayList<>();
        SQLiteDatabase base = bd.getReadableDatabase();
        String[] consulta = {"id", "nombre", "crotal", "crotal_madre", "crotal_padre", "sexo", "fecha_nac", "raza"};
        Cursor cursor = base.query(
                TABLA_ANIMALES,
                consulta,
                null, null, null, null, null
        );

        if (cursor == null) {
            return animales;
        }

        if (!cursor.moveToFirst()) return animales;

        do {
            int id = cursor.getInt(0);
            String nombreAnimal = cursor.getString(1);
            String crotalAnimal = cursor.getString(2);
            String madre = cursor.getString(3);
            String padre = cursor.getString(4);
            String sexoAnimal = cursor.getString(5);
            String fechaNacido = cursor.getString(6);
            String razaAnimal = cursor.getString(7);

            Animal animal = new Animal(id, nombreAnimal, crotalAnimal, madre, padre, sexoAnimal, fechaNacido, razaAnimal);
            animales.add(animal);
        } while (cursor.moveToNext());

        cursor.close();
        return animales;
    }



}
