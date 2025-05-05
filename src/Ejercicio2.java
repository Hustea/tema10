import java.util.ArrayList;

public class Ejercicio2 {
    public static void main(String[] args) {
        Punto p1 = new Punto(0, 0);
        Punto p2 = new Punto(2, 0);
        Punto p3 = new Punto(2, 2);
        Punto p4 = new Punto(0, 2);

        ArrayList<Punto> listaPuntos = new ArrayList<>();
        listaPuntos.add(p1);
        listaPuntos.add(p2);
        listaPuntos.add(p3);
        listaPuntos.add(p4);

        Poligono poligono = new Poligono(listaPuntos);

        System.out.println("Polígono original:");
        System.out.println(poligono);
        System.out.println("Perímetro: " + poligono.perimetro());

        poligono.traslada(4, -3);

        System.out.println("\nPolígono trasladado:");
        System.out.println(poligono);
        System.out.println("Perímetro: " + poligono.perimetro());
    }
}

