package Ejercicio6;

import java.util.Scanner;

public class Ejercicio6 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void verMenuPrincipal(){
        System.out.println("******************MENU******************\n" +
                "1.Altas\n" +
                "2.Alquilar multimedia a socio.\n" +
                "3.Alta de un nuevo Videojuego\n" +
                "4.Listados\n" +
                "--------------------------------\n" +
                "0.Salir\n");
    }

    public static void verMenuAltas(){
        System.out.println("******************ALTAS*****************\n" +
                "1.Alta de una nueva Película\n" +
                "2.Alta de un nuevo Videojuego\n" +
                "3.Alta de un nuevo socio.\n" +
                "--------------------------------\n" +
                "0.Salir\n");
    }

    public static void verMenuListados(){
        System.out.println("****************LISTADOS****************\n" +
                "1.Listado de todos los objetos multimedia\n" +
                "2.Listado de todas las películas ordenadas por título\n" +
                "3.Listado de todos los videojuegos ordenados por año\n" +
                "4.Listado del histórico de alquileres de un socio ordenados por fecha de alquiler\n" +
                "5.Listado de los alquileres actuales de un socio\n" +
                "6.Listado de los socios con recargos pendientes\n" +
                "------------------------------------------------------------------------------------" +
                "0.Salir\n");
    }

    public static void menuPrincipal(){
        int opcion;
        do{
            do{
                verMenuPrincipal();
                opcion = Integer.parseInt(scanner.nextLine());
            }while (opcion < 0 || opcion > 4);

            switch (opcion){
                case 1 ->menuAltas();
                case 2 ->{
                    try{
                        VideoClub.alquilarMultimedia();
                    }catch (ClassNotFoundException cnfe){
                        System.out.println("Ese elemento no existe, debes crearlo primero.");
                    }
                }

                case 3 ->;
                case 4 ->;
            }
        }while (opcion != 0);
    }

    public static void menuAltas(){
        int opcion;
        do{
            do{
                verMenuPrincipal();
                opcion = Integer.parseInt(scanner.nextLine());
            }while (opcion < 0 || opcion > 3);

            switch (opcion){
                case 1 ->VideoClub.addPelicula();
                case 2 ->VideoClub.addVideoJuego();
                case 3 ->VideoClub.addSocio();
            }
        }while (opcion != 0);
    }

    public static void menuListados(){
        int opcion;
        do{
            do{
                verMenuPrincipal();
                opcion = Integer.parseInt(scanner.nextLine());
            }while (opcion < 0 || opcion > 4);

            switch (opcion){
                case 1 ->;
                case 2 ->;
                case 3 ->;
                case 4 ->;
                case 5 ->;
                case 6 ->;
            }
        }while (opcion != 0);
    }

}
