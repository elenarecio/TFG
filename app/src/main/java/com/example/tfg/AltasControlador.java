package com.example.tfg;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AltasControlador extends AppCompatActivity {
    Button boton11, boton10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_altas);
        super.onCreate(savedInstanceState);
        boton11 = findViewById(R.id.boton11);
        boton10 = findViewById(R.id.boton10);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        boton11.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(AltasControlador.this, NacimientosControlador.class);
                startActivity(i);
            }
        });

        boton10.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(AltasControlador.this, ComprasControlador.class);
                startActivity(i);
            }
        });
    }
}