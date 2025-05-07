package Ejercicio6.listas;

import Ejercicio6.personas.Autor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Autores {
    private List<Autor> autores;

    public Autores() {
        this.autores = new ArrayList<Autor>();
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autores autores1 = (Autores) o;
        return Objects.equals(autores, autores1.autores);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(autores);
    }

    @Override
    public String toString() {
        return "Autores{" +
                "autores=" + autores +
                '}';
    }
}
