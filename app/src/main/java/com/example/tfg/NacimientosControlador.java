package com.example.tfg;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.tfg.BaseDatos.BD;
import com.example.tfg.BaseDatos.Nacimiento;

public class NacimientosControlador{
    private BD bd;
    private String TABLA_ANIMALES="t_animales";

    public NacimientosControlador(Context context){
        bd = new BD(context);
    }

    public long nuevoNacimiento(Nacimiento nacimiento){
        SQLiteDatabase base =  bd.getWritableDatabase();
        ContentValues insertar = new ContentValues();

        insertar.put("nombre", nacimiento.getNombre());
        insertar.put("raza", nacimiento.getRaza());
        insertar.put("sexo", nacimiento.getSexo());
        insertar.put("crotal", nacimiento.getCrotal());
        insertar.put("crotal_madre", nacimiento.getCrotal_madre());
        insertar.put("crotal_padre", nacimiento.getCrotal_padre());

        return base.insert(TABLA_ANIMALES, null, insertar);


    }
}













/**
 * import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tfg.BaseDatos.Nacimiento;

public class NacimientosControlador extends AppCompatActivity {
    EditText n_nombre, n_raza, n_crotal, n_madre, n_padre, n_sexo, n_fecha;
    Button bt_registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nacimientos);

        n_nombre = findViewById(R.id.n_nombre);
        n_raza = findViewById(R.id.n_raza);
        n_crotal = findViewById(R.id.n_crotal);
        n_madre = findViewById(R.id.n_madre);
        n_padre = findViewById(R.id.n_padre);
        n_sexo = findViewById(R.id.n_sexo);
        n_fecha = findViewById(R.id.n_fecha);
        bt_registro = findViewById(R.id.bt_registro);

        bt_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nacimiento nacimiento = new Nacimiento(NacimientosControlador.this);

                String nombre = n_nombre.getText().toString();
                String crotal = n_crotal.getText().toString();
                String madre = n_madre.getText().toString();
                String padre = n_padre.getText().toString();
                String sexo = n_sexo.getText().toString();
                String raza = n_raza.getText().toString();

                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); // Ajusta el formato de fecha según tus necesidades
                Date fecha = null;
                try {
                    fecha = formato.parse(n_fecha.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (fecha != null) {
                    long success = nacimiento.insertarNacimiento(nombre, crotal, madre, padre, sexo, raza);
                    if (!success) {
                        Toast.makeText(NacimientosControlador.this, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(NacimientosControlador.this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(NacimientosControlador.this, "Formato de fecha incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
*/