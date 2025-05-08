package Ejercicio7.Partido;

import java.util.Objects;

public class Equipo {
    private int id;
    private String nombre;
    private static int idIncremental = 1;

    public Equipo(String nombre) {
        this.id = asignarId();
        this.nombre = nombre;
    }

    private int asignarId(){
        idIncremental++;
        return idIncremental;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return id == equipo.id && Objects.equals(nombre, equipo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
