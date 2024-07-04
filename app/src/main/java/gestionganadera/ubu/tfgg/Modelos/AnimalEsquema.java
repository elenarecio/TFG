package gestionganadera.ubu.tfgg.Modelos;

import android.os.Build;
import android.provider.BaseColumns;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;

public class AnimalEsquema {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static abstract class AnimalE implements BaseColumns{
        public static final int ID = Integer.parseInt("id");
        public static final String NOMBRE="nombre";
        public static final String CROTAL="crotal";
        public static final String CROTAL_MADRE="crotal_madre";
        public static final String CROTAL_PADRE="crotal_padre";
        public static final String SEXO ="sexo";
        public static final LocalDate FECHA_NAC = LocalDate.parse("fecha_nac");
        public static final String RAZA = "raza";
    }
}
