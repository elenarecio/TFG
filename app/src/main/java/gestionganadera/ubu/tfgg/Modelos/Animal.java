package gestionganadera.ubu.tfgg.Modelos;
import java.time.LocalDate;

public class Animal {
    private int id;
    private String nombre;
    private String crotal;
    private String crotal_madre;
    private String crotal_padre;
    private String sexo;
    private LocalDate fecha_nac;
    private String raza;

    public Animal(LocalDate fecha_nac, String sexo, String crotal_padre, String crotal_madre, String crotal, String nombre, int id, String raza) {
        this.fecha_nac = fecha_nac;
        this.sexo = sexo;
        this.crotal_padre = crotal_padre;
        this.crotal_madre = crotal_madre;
        this.crotal = crotal;
        this.nombre = nombre;
        this.id = id;
        this.raza = raza;
    }

    public int getId() {
        return id;
    }

    public String getRaza() {
        return raza;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public String getSexo() {
        return sexo;
    }

    public String getCrotal_padre() {
        return crotal_padre;
    }

    public String getCrotal_madre() {
        return crotal_madre;
    }

    public String getCrotal() {
        return crotal;
    }

    public String getNombre() {
        return nombre;
    }
}
