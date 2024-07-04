package gestionganadera.ubu.tfgg.Controladores;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import gestionganadera.ubu.tfgg.BD;
import gestionganadera.ubu.tfgg.R;

public class InicioControlador extends AppCompatActivity {
    Button boton, boton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton=findViewById(R.id.Boton);
        boton2=findViewById(R.id.Boton2);

        /**boton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                BD bd = new BD(InicioControlador.this);
                SQLiteDatabase db = bd.getWritableDatabase();
                if(db != null){
                    Toast.makeText(InicioControlador.this, "BASE DE DATOS CREADA CORRECTAMENTE", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(InicioControlador.this, "NO SE HA PODIDO CREAR LA BASE DE DATOS", Toast.LENGTH_LONG).show();
                }
            }
        });*/



    }

    public void botones(View view){
        boton2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(InicioControlador.this, MenuControlador.class));
                BD bd = new BD(InicioControlador.this);
                SQLiteDatabase base=bd.getWritableDatabase();
                if(base!=null){
                    Toast.makeText(InicioControlador.this, "La base de datos ha sido creada", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(InicioControlador.this, "La base de datos no se ha creado", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

   /** public void crear(View view){
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
    }*/
}