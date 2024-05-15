package com.example.tfg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button boton, boton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**setContentView(R.layout.activity_menu);*/
        boton=findViewById(R.id.Boton);
        boton2=findViewById(R.id.Boton2);

        boton2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, Menu.class);
                startActivity(i);
            }
        });



    }

    /**public void botones(View view){
        boton2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, Menu.class));
            }
        });
    }*/

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