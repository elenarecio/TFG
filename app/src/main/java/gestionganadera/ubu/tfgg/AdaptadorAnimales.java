package gestionganadera.ubu.tfgg;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gestionganadera.ubu.tfgg.Modelos.Animal;
import gestionganadera.ubu.tfgg.R;

public class AdaptadorAnimales extends RecyclerView.Adapter<AdaptadorAnimales.MyViewHolder> {

    private List<Animal> listaDeAnimales;

    public void setListaDeAnimales(List<Animal> listaDeAnimales) {
        this.listaDeAnimales = listaDeAnimales;
    }

    public AdaptadorAnimales(List<Animal> listaDeAnimales) {
        this.listaDeAnimales = listaDeAnimales;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View fila_animal = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fila_animal, viewGroup, false);
        return new MyViewHolder(fila_animal);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Animal animal = listaDeAnimales.get(i);

        myViewHolder.nombre.setText(animal.getNombre());
        myViewHolder.crotal.setText(animal.getCrotal());
        myViewHolder.crotal_madre.setText(animal.getCrotal_madre());
        myViewHolder.crotal_padre.setText(animal.getCrotal_padre());
        myViewHolder.sexo.setText(animal.getSexo());
        myViewHolder.raza.setText(animal.getRaza());
        myViewHolder.fech_nac.setText(animal.getFecha_nac());

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetalleActivity.class);
                intent.putExtra("NOMBRE", animal.getNombre());
                intent.putExtra("CROTAL", animal.getCrotal());
                intent.putExtra("CROTAL_MADRE", animal.getCrotal_madre());
                intent.putExtra("CROTAL_PADRE", animal.getCrotal_padre());
                intent.putExtra("SEXO", animal.getSexo());
                intent.putExtra("RAZA", animal.getRaza());
                intent.putExtra("FECHA_NAC", animal.getFecha_nac());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaDeAnimales.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, crotal, crotal_madre, crotal_padre, sexo, raza, fech_nac;

        MyViewHolder(View itemView) {
            super(itemView);
            this.nombre = itemView.findViewById(R.id.tvNombre);
            this.crotal = itemView.findViewById(R.id.tvCrotal);
            this.crotal_madre = itemView.findViewById(R.id.tvCrotalMadre);
            this.crotal_padre = itemView.findViewById(R.id.tvCrotalPadre);
            this.sexo = itemView.findViewById(R.id.tvSexo);
            this.raza = itemView.findViewById(R.id.tvRaza);
            this.fech_nac = itemView.findViewById(R.id.tvFechaNac);
        }
    }
}
