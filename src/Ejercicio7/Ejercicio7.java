package Ejercicio7;

import Ejercicio6.VideoClub;

import java.util.Scanner;

public class Ejercicio7 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void verMenuPrincipal(){
        System.out.println("******************MENU******************\n" +
                "1.Nuevo Partido\n" +
                "2.Gestion de entradas\n" +
                "--------------------------------\n" +
                "0.Salir");
    }

    public static void verMenuGestion(){
        System.out.println("******************MENU******************\n" +
                "1.Venta de entradas\n" +
                "2.Devolver una entrada\n" +
                "3.Visualizar localidades libres\n" +
                "4.Mostrar recaudación del partido\n" +
                "--------------------------------\n" +
                "0.Salir");
    }

    public static void menuPrincipal(){
        int opcion;
        do{
            do{
                verMenuPrincipal();
                opcion = Integer.parseInt(scanner.nextLine());
            }while (opcion < 0 || opcion > 2);

            switch (opcion){
                case 1 ->Gestion.addPartido();
                case 2 ->menuGestion();
            }
        }while (opcion != 0);
    }

    public static void menuGestion(){
        int opcion;
        do{
            do{
                verMenuGestion();
                opcion = Integer.parseInt(scanner.nextLine());
            }while (opcion < 0 || opcion > 4);

            switch (opcion){
                case 1 -> Gestion.comprobarEstadioYVenderEntrada();
                case 2 ->Gestion.devolverEntrada();
                case 3 ->Gestion.mostrarAsientosDisponibles();
                case 4 ->Gestion.mostrarRecaudacionPartido();
            }
        }while (opcion != 0);
    }
}
