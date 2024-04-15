package com.example.tfg;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton=this.findViewById(R.id.Boton);
    }

    public void crear(View view){
        try{
            BD obj=new BD(this);
            SQLiteDatabase db=obj.getWritableDatabase();
            if(db!=null){
                Toast.makeText(this, "La base de datos ha sido creada", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "La base de datos no se ha creado", Toast.LENGTH_LONG).show();
            }


        }catch(Exception e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }
    }
}