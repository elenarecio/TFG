package gestionganadera.ubu.tfgg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import gestionganadera.ubu.tfgg.Controladores.AnimalesControlador;
import gestionganadera.ubu.tfgg.Modelos.Animal;

public class RegistroExplotacionControlador extends AppCompatActivity {

    private Button BotonGuardar, BotonCancelar;
    private AnimalesControlador animales;
    private EditText editNombre, editCrotal, editMadre, editPadre, editSexo, editRaza, editFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro_explotacion);

        editNombre = findViewById(R.id.editNombre);
        editCrotal = findViewById(R.id.editCrotal);
        editMadre = findViewById(R.id.editMadre);
        editPadre = findViewById(R.id.editPadre);
        editSexo = findViewById(R.id.editSexo);
        editRaza = findViewById(R.id.editRaza);
        editFecha = findViewById(R.id.editFecha);
        BotonGuardar = findViewById(R.id.BotonGuardar);
        //BotonCancelar = findViewById(R.id.BotonCancelar);

        animales = new AnimalesControlador();
        animales.inicializarBD(this);
        //animales.setBd(bd); // Asigna la base de datos a la instancia de AnimalesControlador

        BotonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editNombre.setError(null);
                editCrotal.setError(null);
                editMadre.setError(null);
                editPadre.setError(null);
                editSexo.setError(null);
                editRaza.setError(null);
                editFecha.setError(null);
                String nombre = editNombre.getText().toString(),
                        crotal = editCrotal.getText().toString(),
                        madre = editMadre.getText().toString(),
                        padre = editPadre.getText().toString(),
                        sexo = editSexo.getText().toString(),
                        raza = editRaza.getText().toString(),
                        fecha = editFecha.getText().toString();
                Animal nuevoAnimal = new Animal(nombre, crotal, madre, padre, sexo, raza,fecha);
                long id = animales.nuevoAnimal(nuevoAnimal);
                if (id == -1) {
                    Toast.makeText(RegistroExplotacionControlador.this, "Se ha producido un error, inténtelo de nuevo.", Toast.LENGTH_SHORT).show();
                } else {
                   // Intent intent = new Intent(RegistroExplotacionControlador.this, AnimalesControlador.class);
                    //startActivity(intent);
                    finish();
                }
            }
        });

        /**ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
    }
}
