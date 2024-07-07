package gestionganadera.ubu.tfgg.Modelos;
import java.time.LocalDate;

public class Animal {
    private long id;
    private String nombre;
    private String crotal;
    private String crotal_madre;
    private String crotal_padre;
    private String sexo;
    private String fecha_nac;
    private String raza;

    public Animal(String nombre, String crotal, String crotal_madre, String crotal_padre, String sexo, String fecha_nac, String raza) {
        this.nombre = nombre;
        this.crotal = crotal;
        this.crotal_madre = crotal_madre;
        this.crotal_padre = crotal_padre;
        this.sexo = sexo;
        this.fecha_nac = fecha_nac;
        this.raza = raza;
    }

    public Animal(long id, String nombre, String crotal, String crotal_madre, String crotal_padre, String sexo, String fecha_nac, String raza) {
        this.id = id;
        this.nombre = nombre;
        this.crotal = crotal;
        this.crotal_madre = crotal_madre;
        this.crotal_padre = crotal_padre;
        this.sexo = sexo;
        this.fecha_nac = fecha_nac;
        this.raza = raza;
    }

    public long getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCrotal(String crotal) {
        this.crotal = crotal;
    }

    public void setCrotal_madre(String crotal_madre) {
        this.crotal_madre = crotal_madre;
    }

    public void setCrotal_padre(String crotal_padre) {
        this.crotal_padre = crotal_padre;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setId(long id){
        this.id = id;
    }
    public String getRaza() {
        return raza;
    }

    public String getFecha_nac() {
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
