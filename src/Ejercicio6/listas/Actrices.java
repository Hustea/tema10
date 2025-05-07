package Ejercicio6.listas;

import Ejercicio6.personas.Actriz;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Actrices {
    private List<Actriz> actrices;

    public Actrices() {
        this.actrices = new ArrayList<Actriz>();
    }

    public List<Actriz> getActrices() {
        return actrices;
    }

    public void setActrices(List<Actriz> actrices) {
        this.actrices = actrices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actrices actrices1 = (Actrices) o;
        return Objects.equals(actrices, actrices1.actrices);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(actrices);
    }

    @Override
    public String toString() {
        return "Actrices{" +
                "actrices=" + actrices +
                '}';
    }
}
