package Ejercicio6.multimedia;

import Ejercicio6.personas.Autor;
import Ejercicio6.enumerados.Formato;
import Ejercicio6.enumerados.Plataforma;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.Objects;

public class Videojuego extends Multimedia {
    private Plataforma plataforma;
    private static final Year FECHA_DESCUENTO = Year.of(2010);
    private static final int DESCUENTO = 1;
    private static final int PRECIO_BASE = 4;

    public Videojuego(String titulo, Autor autor, Year ano, Formato formato, Plataforma plataforma) {
        super(titulo, autor, ano, formato);
        this.plataforma = plataforma;
    }

    @Override
    public int getPrecio(){
        if(FECHA_DESCUENTO.isAfter(getAno())){
            return PRECIO_BASE - DESCUENTO;
        }else{
            return PRECIO_BASE;
        }
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Videojuego that = (Videojuego) o;
        return plataforma == that.plataforma;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), plataforma);
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "plataforma=" + plataforma +
                '}';
    }
}
