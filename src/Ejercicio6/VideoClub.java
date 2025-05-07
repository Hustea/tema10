package Ejercicio6;

import Ejercicio6.enumerados.Formato;
import Ejercicio6.enumerados.Plataforma;
import Ejercicio6.listas.*;
import Ejercicio6.multimedia.Multimedia;
import Ejercicio6.multimedia.Pelicula;
import Ejercicio6.multimedia.Videojuego;
import Ejercicio6.personas.Actor;
import Ejercicio6.personas.Actriz;
import Ejercicio6.personas.Autor;
import Ejercicio6.personas.Socio;

import java.nio.channels.AlreadyBoundException;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

//• Alta de una nueva Película
//• Alta de un nuevo Videojuego
//• Alta de un nuevo socio.
public class VideoClub {
    static Scanner scanner = new Scanner(System.in);
    static Coleccion coleccion = new Coleccion();
    static RegistroSocios socios = new RegistroSocios();
    static HistoricoAlquiler historicoAlquiler = new HistoricoAlquiler();
    static Autores autores = new Autores();
    static Actores actores = new Actores();
    static Actrices actrices = new Actrices();

    public static Autor buscarOCrearAutor() {
        System.out.println("Ingrese el nombre del autor:");
        String nombre = scanner.nextLine();

        for (int i = 0; i < autores.getAutores().size(); i++) {
            if (autores.getAutores().get(i).getNombre().equals(nombre)) {
                return autores.getAutores().get(i);
            }
        }
        Autor autor = new Autor(nombre);
        autores.getAutores().add(autor);
        return autor;
    }

    public static Actor buscarOCrearActores() {
        System.out.println("Ingrese el nombre del actor:");
        String nombre = scanner.nextLine();

        for (int i = 0; i < actores.getActores().size(); i++) {
            if (actores.getActores().get(i).getNombre().equals(nombre)) {
                return actores.getActores().get(i);
            }
        }
        Actor actor = new Actor(nombre);
        actores.getActores().add(actor);
        return actor;
    }

    public static Actriz buscarOCrearActriz() {
        System.out.println("Ingrese el nombre de la actriz:");
        String nombre = scanner.nextLine();

        for (int i = 0; i < actrices.getActrices().size(); i++) {
            if (actrices.getActrices().get(i).getNombre().equals(nombre)) {
                return actrices.getActrices().get(i);
            }
        }
        Actriz actriz = new Actriz(nombre);
        actrices.getActrices().add(actriz);
        return actriz;
    }

    public static void addPelicula() {
        System.out.println("Ingrese el titulo de la pelicula:");
        String nombre = scanner.nextLine();

        Autor autor = buscarOCrearAutor();

        System.out.println("Ingrese el año de publicacion de la pelicula:");
        int ano = Integer.parseInt(scanner.nextLine());
        Year year = Year.of(ano);

        System.out.println("Selecione el formato:");
        for (int i = 0; i < Formato.values().length; i++) {
            System.out.println((i) + ". " + Formato.values()[i]);
        }
        int opcionFormato;
        do {
            opcionFormato = Integer.parseInt(scanner.nextLine());
            if (opcionFormato < 0 || opcionFormato > Formato.values().length - 1) {
                System.out.println("Ese numero no es valido, intentelo denuevo:");
            }
        } while (opcionFormato < 0 || opcionFormato > Formato.values().length - 1);
        Formato formato = Formato.values()[opcionFormato];

        System.out.println("Inserte la duracion en minutos de la pelicula:");
        int duracion = Integer.parseInt(scanner.nextLine());

        Actor actor = buscarOCrearActores();

        Actriz actriz = buscarOCrearActriz();

        coleccion.getColeccion().add(new Pelicula(nombre, autor, year, formato, duracion, actor, actriz));
    }

    public static void addVideoJuego(){
        System.out.println("Ingrese el titulo del videojuego:");
        String nombre = scanner.nextLine();

        Autor autor = buscarOCrearAutor();

        System.out.println("Ingrese el año de publicacion del videojuegos:");
        int ano = Integer.parseInt(scanner.nextLine());
        Year year = Year.of(ano);

        System.out.println("Selecione el formato:");
        for (int i = 0; i < Formato.values().length; i++) {
            System.out.println((i) + ". " + Formato.values()[i]);
        }
        int opcionFormato;
        do {
            opcionFormato = Integer.parseInt(scanner.nextLine());
            if (opcionFormato < 0 || opcionFormato > Formato.values().length - 1) {
                System.out.println("Ese numero no es valido, intentelo denuevo:");
            }
        } while (opcionFormato < 0 || opcionFormato > Formato.values().length - 1);
        Formato formato = Formato.values()[opcionFormato];

        System.out.println("Selecione la plataforma:");
        for (int i = 0; i < Plataforma.values().length; i++) {
            System.out.println((i) + ". " + Plataforma.values()[i]);
        }
        int opcionPlataforma;
        do {
            opcionPlataforma = Integer.parseInt(scanner.nextLine());
            if (opcionPlataforma < 0 || opcionPlataforma > Plataforma.values().length - 1) {
                System.out.println("Ese numero no es valido, intentelo denuevo:");
            }
        } while (opcionPlataforma < 0 || opcionPlataforma > Plataforma.values().length - 1);
        Plataforma plataforma = Plataforma.values()[opcionPlataforma];
        coleccion.getColeccion().add(new Videojuego(nombre, autor, year, formato, plataforma));
    }

    //int nif, String nombre, String poblacion, Date fechaNac
    public static void addSocio(){
        System.out.println("Ingrese el nif del socio");
        int nif = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < socios.getSocios().size(); i++){
            if(socios.getSocios().get(i).getNif() == nif){
                throw new IllegalArgumentException();
            }
        }
        System.out.println("Ingrese el nombre del socio:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la poblacion del socio:");
        String poblacion = scanner.nextLine();

        LocalDate fecha = null;

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (fecha == null) {
            System.out.print("Introduce una fecha (dd/MM/yyyy): ");
            String entrada = scanner.nextLine();

            try {
                fecha = LocalDate.parse(entrada, formato);
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Por favor, usa dd/MM/yyyy (por ejemplo: 07/05/2025).");
            }
        }

        try{
            socios.getSocios().add(new Socio(nif, nombre, poblacion, fecha));
        }catch (IllegalArgumentException iae){
            System.out.println("Eres menos de edad, fuera.");
        }
    }

    public static void alquilarMultimedia() throws ClassNotFoundException{
        System.out.println("Ingrese su NIF:");
        int nif = Integer.parseInt(scanner.nextLine());
        Socio socio = buscarSocioPoNif(nif);

        System.out.println("Ingrese el nombre la obra multimedia que desea alquilar:");
        String nombre = scanner.nextLine();
        Multimedia multimedia = buscarMultimediaPorNombre(nombre);

        int precio = multimedia.getPrecio();

        System.out.println("El aquiler le costara: "+precio+"€");
        System.out.println("Desea continuar con el pago? (true/false)");
        boolean pagar = Boolean.parseBoolean(scanner.nextLine());

        if(pagar == true){
            historicoAlquiler.getHistorico().add(new Alquiler(socio, multimedia));
            System.out.println("Alquiler realizado correctamente");
        }else{
            System.out.println("hasta pronto");
        }
    }

    public static Socio buscarSocioPoNif(int nif) throws ClassNotFoundException{
        for(int i = 0; i < socios.getSocios().size(); i++){
            if(socios.getSocios().get(i).getNif() == nif){
                return socios.getSocios().get(i);
            }
        }
        throw new ClassNotFoundException();
    }

    public static Multimedia buscarMultimediaPorNombre(String nombre) throws ClassNotFoundException{
        for(int i = 0; i < coleccion.getColeccion().size(); i++){
            if(coleccion.getColeccion().get(i).getTitulo().equals(nombre)){
                return coleccion.getColeccion().get(i);
            }
        }
        throw new ClassNotFoundException();
    }

    public static void devolverMultimedia(){

    }
}