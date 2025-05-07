package Ejercicio6.personas;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Socio {
    private int nif;
    private String nombre;
    private LocalDate fechaNac;
    private String poblacion;
    private int recargoPendiente;

    public Socio(int nif, String nombre, String poblacion, LocalDate fechaNac) {
        this.nif = nif;
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.fechaNac = isMayorDeEdad(fechaNac);
        this.recargoPendiente = 0;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getRecargoPendiente() {
        return recargoPendiente;
    }

    public void setRecargoPendiente(int recargoPendiente) {
        this.recargoPendiente = recargoPendiente;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public LocalDate isMayorDeEdad(LocalDate date) throws IllegalArgumentException{
        Period edad = Period.between(date, LocalDate.now());
        int años = edad.getYears();

        if (años < 18) {
            throw new IllegalArgumentException();
        }
        return date;
    }
}
