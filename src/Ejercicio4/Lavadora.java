package Ejercicio4;

import java.util.Objects;

public class Lavadora extends Electrodomestico{
    private double carga;
    private static final double CARGA_POR_DEFECTO = 5;

    public Lavadora() {
        this.carga = CARGA_POR_DEFECTO;
    }

    public Lavadora(double precio, double peso){
        super(precio, peso);
        this.carga = CARGA_POR_DEFECTO;
    }

    public Lavadora(double precio, Color color, Consumo consumo, double peso, double carga) {
        super(precio, color, consumo, peso);
        this.carga = carga;
    }

    public double getCarga() {
        return carga;
    }

    @Override
    double precioFinal(){
        double aux = super.precioFinal();
        if(carga > 30){
            aux += 50;
        }
        return aux;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lavadora lavadora = (Lavadora) o;
        return Double.compare(carga, lavadora.carga) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(carga);
    }

    @Override
    public String toString() {
        return "Lavadora{" +
                "carga=" + carga +
                '}';
    }
}
