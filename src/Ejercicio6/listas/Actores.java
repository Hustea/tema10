package Ejercicio6.listas;

import Ejercicio6.personas.Actor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Actores {
    private List<Actor> actores;

    public Actores() {
        this.actores = new ArrayList<Actor>();
    }

    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actores actores1 = (Actores) o;
        return Objects.equals(actores, actores1.actores);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(actores);
    }

    @Override
    public String toString() {
        return "Actores{" +
                "actores=" + actores +
                '}';
    }
}
