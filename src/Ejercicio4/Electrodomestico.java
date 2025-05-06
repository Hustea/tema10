package Ejercicio4;

public class Electrodomestico {
    enum Color{
        BLANCO, NEGRO, ROJO, AZUL, GRIS
    }
    enum Consumo{
        A('A',100), B('B', 80), C('C',60), D('D',50), E('E',30), F('F',10);

        private final char letra;
        private final double incrementoPrecio;

        Consumo(char letra, double incrementoPrecio) {
            this.letra = letra;
            this.incrementoPrecio = incrementoPrecio;
        }

        public char getLetra() {
            return letra;
        }

        public double getIncrementoPrecio() {
            return incrementoPrecio;
        }
    }
    double precioBase;
    Color color;
    Consumo consumo;
    double peso;

    public Electrodomestico(){
        this.precioBase = 100;
        this.color = Color.BLANCO;
        this.consumo = Consumo.F;
        this.peso = 5;
    }

    public Electrodomestico(double precio, double peso){
        this.precioBase = precio;
        this.color = Color.BLANCO;
        this.consumo = Consumo.F;
        this.peso = peso;
    }

    public Electrodomestico(double precio, Color color, Consumo consumo, double peso){
        this.precioBase = precio;
        this.color = color;
        this.consumo = consumo;
        this.peso = peso;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public Color getColor() {
        return color;
    }

    public double getPeso() {
        return peso;
    }

    public Consumo getConsumo() {
        return consumo;
    }

    private Consumo comprobarConsumoEnergetico(char letra){
        for(int i = 0; i < Consumo.values().length; i++){
            if(Consumo.values()[i].getLetra() == letra){
                return Consumo.values()[i];
            }
        }
        return Consumo.F;
    }

    private Color comprobarColor(String color){
        return Color.BLANCO;
    }

    double precioFinal(){
        double precio = this.consumo.incrementoPrecio;
        precio += precioPorPeso();
        return this.precioBase + precio;
    }


    double precioPorPeso(){
        double precio = 0;
        if(peso < 20){
            precio = 10;
        }else if(peso < 50){
            precio = 50;
        }else if(peso < 80){
            precio = 80;
        }else{
            precio = 100;
        }
        return precio;
    }
}
