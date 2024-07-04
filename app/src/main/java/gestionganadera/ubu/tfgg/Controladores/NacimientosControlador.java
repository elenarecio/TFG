package gestionganadera.ubu.tfgg.Controladores;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import gestionganadera.ubu.tfgg.BD;
import gestionganadera.ubu.tfgg.Modelos.Nacimiento;
import gestionganadera.ubu.tfgg.R;

public class NacimientosControlador extends AppCompatActivity {
    private EditText n_nombre, n_raza, n_crotal, n_madre, n_padre, n_sexo, n_fecha;
    private Button bt_registro;
    private BD bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nacimientos);

        n_nombre = findViewById(R.id.n_nombre);
        n_raza = findViewById(R.id.n_raza);
        n_crotal = findViewById(R.id.n_crotal);
        n_madre = findViewById(R.id.n_madre);
        n_padre = findViewById(R.id.n_padre);
        n_sexo = findViewById(R.id.n_sexo);
        n_fecha = findViewById(R.id.n_fecha);
        bt_registro = findViewById(R.id.bt_registro);

        bd = new BD(this);

        bt_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarNacimiento();
            }
        });
    }

    private void registrarNacimiento() {
        String nombre = n_nombre.getText().toString();
        String raza = n_raza.getText().toString();
        String sexo = n_sexo.getText().toString();
        String crotal = n_crotal.getText().toString();
        String madre = n_madre.getText().toString();
        String padre = n_padre.getText().toString();
        String fechaStr = n_fecha.getText().toString();

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = formato.parse(fechaStr);
        } catch (ParseException e) {
            e.printStackTrace();
            Toast.makeText(this, "Formato de fecha incorrecto", Toast.LENGTH_SHORT).show();
            return;
        }

        Nacimiento nacimiento = new Nacimiento(nombre, raza, sexo, crotal, madre, padre);
        NacimientosControlador controller = new NacimientosControlador(this);
        long result = controller.nuevoNacimiento(nacimiento);

        if (result == -1) {
            Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();
            limpiarCampos();
        }
    }

    private void limpiarCampos() {
        n_nombre.setText("");
        n_raza.setText("");
        n_crotal.setText("");
        n_madre.setText("");
        n_padre.setText("");
        n_sexo.setText("");
        n_fecha.setText("");
    }

    public long nuevoNacimiento(Nacimiento nacimiento) {
        SQLiteDatabase base = bd.getWritableDatabase();
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
