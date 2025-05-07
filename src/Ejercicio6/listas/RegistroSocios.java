package Ejercicio6.listas;

import Ejercicio6.personas.Socio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegistroSocios {
    private List<Socio> socios;

    public RegistroSocios() {
        this.socios = new ArrayList<Socio>();
    }

    public List<Socio> getSocios() {
        return socios;
    }

    public void setSocios(List<Socio> socios) {
        this.socios = socios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistroSocios that = (RegistroSocios) o;
        return Objects.equals(socios, that.socios);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(socios);
    }

    @Override
    public String toString() {
        return "RegistroSocios{" +
                "socios=" + socios +
                '}';
    }
}
