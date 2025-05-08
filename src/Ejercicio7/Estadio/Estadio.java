package Ejercicio7.Estadio;

import java.util.Arrays;
import java.util.Objects;

public class Estadio {
    private Zona[] zonas;

    public Estadio(Zona[] zonas) {
        this.zonas = zonas;
    }

    public Zona[] getZonas() {
        return zonas;
    }

    public void setZonas(Zona[] zonas) {
        this.zonas = zonas;
    }

    public boolean isFull(){
        for (Zona zona : zonas){
            if(zona.isFull() == false){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estadio estadio = (Estadio) o;
        return Objects.deepEquals(zonas, estadio.zonas);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(zonas);
    }

    @Override
    public String toString() {
        return "Estadio{" +
                "zonas=" + Arrays.toString(zonas) +
                '}';
    }
}
