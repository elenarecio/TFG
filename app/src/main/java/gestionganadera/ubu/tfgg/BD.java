package gestionganadera.ubu.tfgg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BD extends SQLiteOpenHelper {

    private static final int VERSION = 6;
    private static final String BD_NOMBRE = "ganaderia.db";

    // Nombres de las tablas
    public static final String TABLA_ANIMALES = "t_animales";
    public static final String TABLA_ALIMENTO = "t_alimento";
    public static final String TABLA_COMEN = "t_comen";
    public static final String TABLA_COMPOSICION = "t_composicion";
    public static final String TABLA_INGREDIENTES = "t_ingredientes";
    public static final String TABLA_INCIDENCIAS = "t_incidencias";
    public static final String TABLA_UBICACION = "t_ubicacion";
    public static final String TABLA_MUERTES = "t_muertes";
    public static final String TABLA_VENTAS = "t_ventas";
    public static final String TABLA_NACIMIENTOS = "t_nacimientos";
    public static final String TABLA_COMPRAS = "t_compras";
    public static final String TABLA_HISTORIAL_UBICACIONES = "t_historial_ubicaciones";

    public BD(@Nullable Context context) {

        super(context, BD_NOMBRE, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear la tabla de animales
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLA_ANIMALES + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT," +
                "crotal TEXT UNIQUE NOT NULL," +
                "crotal_madre TEXT," +
                "crotal_padre TEXT," +
                "sexo TEXT," +
                "fecha_nac DATE," +
                "raza TEXT)");

        // Crear la tabla de alimento
        db.execSQL("CREATE TABLE " + TABLA_ALIMENTO + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT," +
                "descripcion TEXT)");

        // Crear la tabla de consumo
        db.execSQL("CREATE TABLE " + TABLA_COMEN + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "id_alimento INTEGER," +
                "id_animal INTEGER," +
                "FOREIGN KEY(id_alimento) REFERENCES " + TABLA_ALIMENTO + "(id)," +
                "FOREIGN KEY(id_animal) REFERENCES " + TABLA_ANIMALES + "(id))");

        // Crear la tabla de composición
        db.execSQL("CREATE TABLE " + TABLA_COMPOSICION + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "id_alimento INTEGER," +
                "id_ingrediente INTEGER," +
                "cantidad INTEGER," +
                "FOREIGN KEY(id_alimento) REFERENCES " + TABLA_ALIMENTO + "(id)," +
                "FOREIGN KEY(id_ingrediente) REFERENCES " + TABLA_INGREDIENTES + "(id))");

        // Crear la tabla de ingredientes
        db.execSQL("CREATE TABLE " + TABLA_INGREDIENTES + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT)");

        // Crear la tabla de incidencias
        db.execSQL("CREATE TABLE " + TABLA_INCIDENCIAS + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "id_animal INTEGER," +
                "descripcion TEXT," +
                "FOREIGN KEY(id_animal) REFERENCES " + TABLA_ANIMALES + "(id))");

        db.execSQL("CREATE TABLE " + TABLA_UBICACION + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT)");

        // Crear la tabla de historial de ubicaciones
        db.execSQL("CREATE TABLE " + TABLA_HISTORIAL_UBICACIONES + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "id_animal INTEGER," +
                "id_ubicacion INTEGER," +
                "fecha_ini DATE," +
                "fecha_fin DATE," +
                "FOREIGN KEY (id_animal) REFERENCES " + TABLA_ANIMALES + "(id)," +
                "FOREIGN KEY (id_ubicacion) REFERENCES " + TABLA_UBICACION + "(id))");

        // Crear la tabla de muertes
        db.execSQL("CREATE TABLE " + TABLA_MUERTES + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "causa TEXT," +
                "id_animal INTEGER," +
                "fecha DATE," +
                "FOREIGN KEY(id_animal) REFERENCES " + TABLA_ANIMALES + "(id))");

        // Crear la tabla de ventas
        db.execSQL("CREATE TABLE " + TABLA_VENTAS + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "n_explotacion TEXT," +
                "precio FLOAT," +
                "causa TEXT," +
                "fecha DATE," +
                "id_animal INTEGER," +
                "FOREIGN KEY(id_animal) REFERENCES " + TABLA_ANIMALES + "(id))");

        // Crear la tabla de nacimientos
        db.execSQL("CREATE TABLE " + TABLA_NACIMIENTOS + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "id_animal INTEGER," +
                "problemas INTEGER," +
                "FOREIGN KEY(id_animal) REFERENCES " + TABLA_ANIMALES + "(id))");

        // Crear la tabla de compras
        db.execSQL("CREATE TABLE " + TABLA_COMPRAS + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "n_explotacion TEXT," +
                "precio FLOAT," +
                "fecha DATE," +
                "id_animal INTEGER," +
                "FOREIGN KEY(id_animal) REFERENCES " + TABLA_ANIMALES + "(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /**db.execSQL("DROP TABLE IF EXISTS " + TABLA_ANIMALES);
         db.execSQL("DROP TABLE IF EXISTS " + TABLA_ALIMENTO);
         db.execSQL("DROP TABLE IF EXISTS " + TABLA_COMEN);
         db.execSQL("DROP TABLE IF EXISTS " + TABLA_COMPOSICION);
         db.execSQL("DROP TABLE IF EXISTS " + TABLA_INGREDIENTES);
         db.execSQL("DROP TABLE IF EXISTS " + TABLA_INCIDENCIAS);
         db.execSQL("DROP TABLE IF EXISTS " + TABLA_UBICACION);
         db.execSQL("DROP TABLE IF EXISTS " + TABLA_MUERTES);
         db.execSQL("DROP TABLE IF EXISTS " + TABLA_VENTAS);
         db.execSQL("DROP TABLE IF EXISTS " + TABLA_NACIMIENTOS);
         db.execSQL("DROP TABLE IF EXISTS " + TABLA_COMPRAS);
         db.execSQL("DROP TABLE IF EXISTS " + TABLA_HISTORIAL_UBICACIONES);


         onCreate(db);*/
    }
}
