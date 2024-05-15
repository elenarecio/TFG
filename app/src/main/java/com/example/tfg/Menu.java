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

public class Menu extends AppCompatActivity {
    Button boton3, boton4, boton5, boton6, boton7, boton8, boton9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        boton3 = findViewById(R.id.boton3);
        boton4 = findViewById(R.id.boton4);
        boton5 = findViewById(R.id.boton5);
        EdgeToEdge.enable(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        boton3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(Menu.this, Animales.class);
                startActivity(i);
            }
        });

        boton4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(Menu.this, AltasActivity.class);
                startActivity(i);
            }
        });

        boton5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(Menu.this, BajasActivity.class);
                startActivity(i);
            }
        });

    }
}