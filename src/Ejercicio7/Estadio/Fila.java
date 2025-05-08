package Ejercicio7.Estadio;

import java.util.Arrays;
import java.util.Objects;

public class Fila {
    private boolean[] fila;
    private char nombre;

    public Fila(char nombre) {
        this.fila = new boolean[]{false, false, false, false, false};
        this.nombre = nombre;
    }

    public int getAsientosDisponibles(){
        int disponible = 0;
        for(boolean asiento : fila){
            if(asiento == false){
                disponible++;
            }
        }
        return disponible;
    }

    public boolean[] getFila() {
        return fila;
    }

    public void setFila(boolean[] fila) {
        this.fila = fila;
    }

    public char getNombre() {
        return nombre;
    }

    public void setNombre(char nombre) {
        this.nombre = nombre;
    }

    public boolean isFull(){
        for(boolean asiento : fila){
            if(asiento == false){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fila fila1 = (Fila) o;
        return nombre == fila1.nombre && Objects.deepEquals(fila, fila1.fila);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(fila), nombre);
    }

    @Override
    public String toString() {
        return "Fila{"+ nombre +'}';
    }
}
