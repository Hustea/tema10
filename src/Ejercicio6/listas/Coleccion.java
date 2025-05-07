package Ejercicio6.listas;

import Ejercicio6.multimedia.Multimedia;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coleccion {
    private List<Multimedia> Coleccion;

    public Coleccion() {
        Coleccion = new ArrayList<Multimedia>();
    }

    public List<Multimedia> getColeccion() {
        return Coleccion;
    }

    public void setColeccion(List<Multimedia> coleccion) {
        Coleccion = coleccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coleccion coleccion = (Coleccion) o;
        return Objects.equals(Coleccion, coleccion.Coleccion);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Coleccion);
    }

    @Override
    public String toString() {
        return "Coleccion{" +
                "Coleccion=" + Coleccion +
                '}';
    }
}
