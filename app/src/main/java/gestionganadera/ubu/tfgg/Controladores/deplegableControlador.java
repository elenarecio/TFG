package gestionganadera.ubu.tfgg.Controladores;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import gestionganadera.ubu.tfgg.R;

public class deplegableControlador extends AppCompatActivity {
    /**@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.menu.menu);
    }*/
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem opcion){
        int id = opcion.getItemId();
        return super.onOptionsItemSelected(opcion);

    }
}
