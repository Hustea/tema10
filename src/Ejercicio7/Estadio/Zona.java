package Ejercicio7.Estadio;

import java.util.Arrays;
import java.util.Objects;

public class Zona {
    private Fila[] filas;
    private String nombre;
    private boolean vip;
    private int precioBase;

    public Zona(Fila[] filas, String nombre, boolean vip, int precioBase) {
        this.filas = filas;
        this.nombre = nombre;
        this.vip = vip;
        this.precioBase = precioBase;
    }

    public Fila[] getFilas() {
        return filas;
    }

    public void setFilas(Fila[] filas) {
        this.filas = filas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }

    public boolean isFull(){
        for(Fila fila : filas){
            if(fila.isFull() == false){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zona zona = (Zona) o;
        return vip == zona.vip && Objects.deepEquals(filas, zona.filas) && Objects.equals(nombre, zona.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(filas), nombre, vip);
    }

    @Override
    public String toString() {
        String AMARILLO = "\u001B[33m";
        String RESET = "\u001B[0m";
        if(vip == true){
            return "#{" +
                    "nombre="+AMARILLO+"'" + nombre + '\'' +
                    RESET+
                    ", precioBase=" + precioBase +
                    "}#";
        }else{
            return "#{" +
                    "nombre='" + nombre + '\'' +
                    ", precioBase=" + precioBase +
                    "}#";
        }
    }
}
