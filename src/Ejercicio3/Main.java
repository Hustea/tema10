package Ejercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Coche coche;
        int[] numeroMarchas = {15,30,50,70,90,120};
        System.out.println("Ingrese la matricula del coche:");
        String matricula = scanner.nextLine();
        System.out.println("Es automatico? (true/false)");
        boolean automatico = scanner.nextBoolean();

        if (automatico){
            coche = new CocheCambioAutomatico(numeroMarchas,matricula);
        } else {
            coche = new CocheCambioManual(numeroMarchas, matricula);
            coche.cambiarMarcha(3);
        }
        System.out.println("\nDatos del coche recien creado:");
        System.out.println("Matrícula: " + coche.getMatricula());
        System.out.println("Velocidad actual: " + coche.getVelocidadActual());
        System.out.println("Marcha actual: " + coche.getMarchaActual());
        coche.acelerar(60);
        System.out.println("\nDatos del coche tras acelerar:");
        System.out.println("Matrícula: " + coche.getMatricula());
        System.out.println("Velocidad actual: " + coche.getVelocidadActual());
        System.out.println("Marcha actual: " + coche.getMarchaActual());
    }
}