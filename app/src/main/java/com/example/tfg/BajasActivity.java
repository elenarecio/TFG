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

public class BajasActivity extends AppCompatActivity {
    Button boton12, boton13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bajas);
        boton13 = findViewById(R.id.boton13);
        boton12 = findViewById(R.id.boton12);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        boton13.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(BajasActivity.this, Muertes.class);
                startActivity(i);
            }
        });
        boton12.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(BajasActivity.this, Ventas.class);
                startActivity(i);
            }
        });
    }
}