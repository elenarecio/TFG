package gestionganadera.ubu.tfgg;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import gestionganadera.ubu.tfgg.Controladores.AnimalesControlador;
import gestionganadera.ubu.tfgg.Modelos.Animal;

public class MainAnimales extends AppCompatActivity {
    private List<Animal> listaDeAnimales;
    private RecyclerView recyclerView;
    private AdaptadorAnimales adaptadorAnimales;
    private AnimalesControlador animalesControlador;
    private Button Boton23;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animales);

        animalesControlador = new AnimalesControlador();
        animalesControlador.inicializarBD(this);
        recyclerView=findViewById(R.id.listaAnimales);
        Boton23 = findViewById(R.id.Boton23);

        listaDeAnimales = new ArrayList<>();
        adaptadorAnimales = new AdaptadorAnimales(listaDeAnimales);
        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adaptadorAnimales);

        refrescarLista();

        Boton23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainAnimales.this, RegistroExplotacionControlador.class);
                startActivity(intent);
            }
        });
    }
    protected void onResume(){
        super.onResume();
        refrescarLista();
    }
    public void refrescarLista(){
        if(adaptadorAnimales == null) return;
        listaDeAnimales =  animalesControlador.listarAnimales();
        adaptadorAnimales.setListaDeMascotas(listaDeAnimales);
        adaptadorAnimales.notifyDataSetChanged();
    }
}
