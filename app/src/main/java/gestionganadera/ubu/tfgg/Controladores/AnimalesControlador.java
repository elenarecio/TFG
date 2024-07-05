package gestionganadera.ubu.tfgg.Controladores;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

import gestionganadera.ubu.tfgg.BD;
import gestionganadera.ubu.tfgg.Modelos.Animal;
import gestionganadera.ubu.tfgg.R;
public class AnimalesControlador extends AppCompatActivity {
    private BD bd;
    private String TABLA_ANIMALES="t_animales";
    Button Boton23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animales);

        Boton23 = findViewById(R.id.Boton23);

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Boton23.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(AnimalesControlador.this, RegistroExplotacionControlador.class);
                startActivity(i);
            }
        });

    }

    public int eliminarAnimal(Animal animal){
        SQLiteDatabase base = bd.getWritableDatabase();
        String[] argumentos ={String.valueOf(animal.getId())};
        return base.delete(TABLA_ANIMALES, "id= ?", argumentos);
    }

    public long nuevoAnimal(Animal animal){
        SQLiteDatabase base = bd.getWritableDatabase();
        ContentValues insertar=new ContentValues();
        insertar.put("nombre", animal.getNombre());
        insertar.put("crotal", animal.getCrotal());
        insertar.put("crotal_madre", animal.getCrotal_madre());
        insertar.put("crotal_padre", animal.getCrotal_padre());
        insertar.put("sexo",animal.getSexo());
        insertar.put("fecha_nac", String.valueOf(animal.getFecha_nac()));
        insertar.put("raza", animal.getRaza());

        return base.insert(TABLA_ANIMALES, null, insertar);
    }

    public int guardar(Animal animalGuardado){
        SQLiteDatabase base = bd.getWritableDatabase();
        ContentValues actualizar = new ContentValues();
        actualizar.put("nombre", animalGuardado.getNombre());
        actualizar.put("crotal", animalGuardado.getCrotal());
        actualizar.put("crotal_madre", animalGuardado.getCrotal_madre());
        actualizar.put("crotal_padre", animalGuardado.getCrotal_padre());
        actualizar.put("sexo",animalGuardado.getSexo());
        actualizar.put("fecha_nac", String.valueOf(animalGuardado.getFecha_nac()));
        actualizar.put("raza", animalGuardado.getRaza());

        String campoActualizar = "id = ?";
        String[] campos = {String.valueOf(animalGuardado.getId())};
        return base.update(TABLA_ANIMALES, actualizar, campoActualizar, campos);
    }

    public ArrayList<Animal> listarAnimales(){
        ArrayList<Animal> animales = new ArrayList<>();
        SQLiteDatabase base =bd.getReadableDatabase();
        String[] consulta={"nombre","crotal", "crotal_madre", "crotal_padre", "sexo", "fecha_nac", "raza"};
        Cursor cursor = base.query(
                TABLA_ANIMALES,
                consulta,
                null,null,null,null,null,null
        );
        if (cursor == null){
            return animales;
        }

        if(!cursor.moveToFirst()) return animales;

        do{
            String nombreAnimal= cursor.getString(1);
            String crotalAnimal= cursor.getString(2);
            String madre = cursor.getString(3);
            String padre = cursor.getString(4);
            String sexoAnimal = cursor.getString(5);
            String fechaNacido = cursor.getString(6);
            String razaAnimal = cursor.getString(7);
        } while(cursor.moveToNext());

        cursor.close();
        return animales;
    }
}
