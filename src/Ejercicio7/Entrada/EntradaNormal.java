package Ejercicio7.Entrada;

import Ejercicio7.Estadio.Fila;
import Ejercicio7.Estadio.Zona;
import Ejercicio7.Partido.Partido;

import java.util.Objects;

public class EntradaNormal extends Entrada{
    private static int sorteoIncremental = 1;
    private int sorteo;

    public EntradaNormal(Zona zona, Fila fila, int asiento, Partido partido) {
        super(zona, fila, asiento, partido);
        this.sorteo = asignarNumSorteo();
    }

    private int asignarNumSorteo(){
        return sorteoIncremental++;
    }

    public int getSorteo() {
        return sorteo;
    }

    public void setSorteo(int sorteo) {
        this.sorteo = sorteo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EntradaNormal that = (EntradaNormal) o;
        return sorteo == that.sorteo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sorteo);
    }

    @Override
    public String toString() {
        return "EntradaNormal{" +
                "sorteo=" + sorteo +
                '}';
    }
}
