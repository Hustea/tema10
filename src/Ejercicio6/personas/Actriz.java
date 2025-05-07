package Ejercicio6.personas;

import java.util.Objects;

public class Actriz {
    private String nombre;

    public Actriz(String nombre) {
        this.nombre = nombre;
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
        Actriz actriz = (Actriz) o;
        return Objects.equals(nombre, actriz.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    @Override
    public String toString() {
        return "Actriz{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
