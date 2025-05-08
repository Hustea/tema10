package Ejercicio7.Entrada;

import Ejercicio7.Estadio.Fila;
import Ejercicio7.Estadio.Zona;
import Ejercicio7.Partido.Partido;

import java.util.Objects;

public abstract class Entrada {
    private static int IdIncremental = 1;
    private final int id;
    private Zona zona;
    private Fila fila;
    private int asiento;
    private Partido partido;

    public Entrada(Zona zona, Fila fila, int asiento, Partido partido) {
        this.id = asignarId();
        this.zona = zona;
        this.fila = fila;
        this.asiento = asiento;
        this.partido = partido;
    }

    private int asignarId(){
        return IdIncremental++;
    }

    public int getId() {
        return id;
    }


    public Zona getZona() {
        return zona;
    }


    public Fila getFila() {
        return fila;
    }


    public int getAsiento() {
        return asiento;
    }


    public Partido getPartido() {
        return partido;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrada entrada = (Entrada) o;
        return id == entrada.id && asiento == entrada.asiento && Objects.equals(zona, entrada.zona) && Objects.equals(fila, entrada.fila) && Objects.equals(partido, entrada.partido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, zona, fila, asiento, partido);
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "id=" + id +
                ", zona=" + zona +
                ", fila=" + fila +
                ", asiento=" + asiento +
                ", partido=" + partido +
                '}';
    }
}
