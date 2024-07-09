package gestionganadera.ubu.tfgg.Controladores;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import gestionganadera.ubu.tfgg.R;
import gestionganadera.ubu.tfgg.RegistroExplotacionControlador;

public class AltasControlador extends AppCompatActivity {
    Button boton11, boton10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_altas);
        super.onCreate(savedInstanceState);
        boton11 = findViewById(R.id.boton11);
        boton10 = findViewById(R.id.boton10);
        EdgeToEdge.enable(this);

        boton11.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(AltasControlador.this, RegistroExplotacionControlador.class);
                startActivity(i);
            }
        });

        boton10.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(AltasControlador.this, RegistroExplotacionControlador.class);
                startActivity(i);
            }
        });
    }
}