package Ejercicio4;

import java.util.Objects;

public class Television extends Electrodomestico{
    private int resolucion;
    private static final int RESOLUCION_POR_DEFECTO = 20;
    private boolean smartTV;
    private static final boolean SMART_TV_POR_DEFECTO = false;

    public Television() {
        this.resolucion = RESOLUCION_POR_DEFECTO;
        this.smartTV = SMART_TV_POR_DEFECTO;
    }

    public Television(double precio, double peso) {
        super(precio, peso);
        this.resolucion = RESOLUCION_POR_DEFECTO;
        this.smartTV = SMART_TV_POR_DEFECTO;
    }

    public Television(double precio, Color color, Consumo consumo, double peso, int resolucion, boolean smartTV) {
        super(precio, color, consumo, peso);
        this.resolucion = resolucion;
        this.smartTV = smartTV;
    }

    public int getResolucion() {
        return resolucion;
    }

    public boolean isSmartTV() {
        return smartTV;
    }

    @Override
    double precioFinal(){
        double aux = super.precioFinal();
        if(smartTV == true){
            aux += 50;
        }
        if(resolucion > 40){
            aux += (aux * 0.3);
        }
        return aux;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;
        return resolucion == that.resolucion && smartTV == that.smartTV;
    }

    @Override
    public int hashCode() {
        return Objects.hash(resolucion, smartTV);
    }

    @Override
    public String toString() {
        return "Television{" +
                "resolucion=" + resolucion +
                ", smartTV=" + smartTV +
                '}';
    }
}
