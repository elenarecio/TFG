package gestionganadera.ubu.tfgg;
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

    public void setListaDeMascotas(List<Animal> listaDeAnimales) {
        this.listaDeAnimales = listaDeAnimales;
    }

    public AdaptadorAnimales(List<Animal> mascotas) {
        this.listaDeAnimales = mascotas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View fila_animal = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fila_animal, viewGroup, false);
        return new MyViewHolder(fila_animal);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        // Obtener la mascota de nuestra lista gracias al índice i
        Animal animal = listaDeAnimales.get(i);

        // Obtener los datos de la lista
        String nombre = animal.getNombre();
        String crotal = animal.getCrotal();
        String crotal_madre = animal.getCrotal_madre();
        String crotal_padre = animal.getCrotal_padre();
        String sexo = animal.getSexo();
        String raza = animal.getRaza();
        String fech_nac = animal.getFecha_nac();
        // Y poner a los TextView los datos con setText
        myViewHolder.nombre.setText(nombre);
        myViewHolder.crotal.setText(crotal);
        myViewHolder.crotal_madre.setText(crotal_madre);
        myViewHolder.crotal_padre.setText(crotal_padre);
        myViewHolder.sexo.setText(sexo);
        myViewHolder.raza.setText(raza);
        myViewHolder.fech_nac.setText(fech_nac);



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
            /**this.crotal_madre = itemView.findViewById(R.id.tvCrotalMadre);
            this.crotal_padre = itemView.findViewById(R.id.tvCrotalPadre);
            this.sexo = itemView.findViewById(R.id.tvSexo);
            this.raza = itemView.findViewById(R.id.tvRaza);
            this.fech_nac = itemView.findViewById(R.id.tvFechaNac);*/

        }
    }
}
