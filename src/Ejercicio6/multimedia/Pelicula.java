package Ejercicio6.multimedia;

import Ejercicio6.personas.Actor;
import Ejercicio6.personas.Actriz;
import Ejercicio6.personas.Autor;
import Ejercicio6.enumerados.Formato;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.Objects;

public class Pelicula extends Multimedia {
    private int duracion;
    private Autor actro;
    private Actor actor;
    private Actriz actriz;
    private static final Year FECHA_DESCUENTO = Year.of(2012);
    private static final int DESCUENTO = 1;
    private static final int PRECIO_BASE = 4;

    public Pelicula(String titulo, Autor autor, Year ano, Formato formato, int duracion, Actor actor, Actriz actriz) {
        super(titulo, autor, ano, formato);
        this.duracion = duracion;
        this.actor = actor;
        this.actriz = actriz;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Actor getActor() {
        return actor;
    }

    @Override
    public int getPrecio(){
        if(FECHA_DESCUENTO.isAfter(getAno())){
            return PRECIO_BASE - DESCUENTO;
        }else{
            return PRECIO_BASE;
        }
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Actriz getActriz() {
        return actriz;
    }

    public void setActriz(Actriz actriz) {
        this.actriz = actriz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pelicula pelicula = (Pelicula) o;
        return duracion == pelicula.duracion && Objects.equals(actro, pelicula.actro) && Objects.equals(actriz, pelicula.actriz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), duracion, actro, actriz);
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "duracion=" + duracion +
                ", actro=" + actro +
                ", actriz=" + actriz +
                '}';
    }
}
