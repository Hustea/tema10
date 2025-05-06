package Ejercicio4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Electrodomestico e1 = new Electrodomestico(50, Electrodomestico.Color.AZUL, Electrodomestico.Consumo.C, 20);
        Lavadora e2 = new Lavadora(80, Electrodomestico.Color.NEGRO, Electrodomestico.Consumo.F, 100, 50);
        Television e3 = new Television(500, Electrodomestico.Color.GRIS, Electrodomestico.Consumo.B, 70, 30, true);
        Electrodomestico e4 = new Electrodomestico(300, Electrodomestico.Color.ROJO, Electrodomestico.Consumo.A, 230);
        Lavadora e5 = new Lavadora(200, Electrodomestico.Color.BLANCO, Electrodomestico.Consumo.D, 70, 4);
        Television e6 = new Television(450, Electrodomestico.Color.AZUL, Electrodomestico.Consumo.A, 90, 50, false);
        Television e7 = new Television(500, Electrodomestico.Color.GRIS, Electrodomestico.Consumo.B, 70, 30, true);
        Electrodomestico e8 = new Electrodomestico(300, Electrodomestico.Color.ROJO, Electrodomestico.Consumo.A, 230);
        Lavadora e9 = new Lavadora(150, Electrodomestico.Color.BLANCO, Electrodomestico.Consumo.D, 70, 4);
        Television e10 = new Television(600, Electrodomestico.Color.AZUL, Electrodomestico.Consumo.A, 70, 50, true);

        ArrayList<Electrodomestico> listaElectro = new ArrayList<>();
        listaElectro.add(e1);
        listaElectro.add(e2);
        listaElectro.add(e3);
        listaElectro.add(e4);
        listaElectro.add(e5);
        listaElectro.add(e6);
        listaElectro.add(e7);
        listaElectro.add(e8);
        listaElectro.add(e9);
        listaElectro.add(e10);

        mostrarPreciosConjunto(listaElectro);

    }

    public static void mostrarPreciosConjunto(ArrayList<Electrodomestico> listaElectro){
        double precioTotal = 0;
        double precioTeles = 0;
        double precioLavadoras = 0;
        for(Electrodomestico electrodomestico : listaElectro){
            precioTotal += electrodomestico.precioFinal();

            if(electrodomestico instanceof Television){
                precioTeles += electrodomestico.precioFinal();
            }

            if(electrodomestico instanceof Lavadora){
                precioLavadoras += electrodomestico.precioFinal();
            }
        }

        System.out.println("Precio de los electrodomesticos: "+precioTotal);
        System.out.println("Precio de las televisiones: "+precioTeles);
        System.out.println("Precio de las lavadors: "+precioLavadoras);
    }
}
