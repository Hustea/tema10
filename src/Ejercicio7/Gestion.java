package Ejercicio7;

import Ejercicio7.Entrada.Entrada;
import Ejercicio7.Entrada.EntradaNormal;
import Ejercicio7.Entrada.EntradaVip;
import Ejercicio7.Enum.Afluencia;
import Ejercicio7.Estadio.Estadio;
import Ejercicio7.Estadio.Fila;
import Ejercicio7.Estadio.Zona;
import Ejercicio7.Partido.Equipo;
import Ejercicio7.Partido.Partido;
import Ejercicio7.Validaciones.Validacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Gestion {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Equipo> equipos = DataGenerator.generarListaConEquipos();
    static ArrayList<Partido> historicoPartidos = new ArrayList<Partido>();
    static ArrayList<Entrada> entradasVendidas = new ArrayList<Entrada>();

    public static void addPartido(){
        System.out.println("Cual de estos es el equipo local:");
        Equipo e1 = selecionarEquipo();

        System.out.println("Cual de estos es el equipo visitante:");
        Equipo e2 = selecionarEquipo(e1);

        System.out.println("Cual es la afiliacion del partido");
        Afluencia afluencia = selecionarAfluencia();

        System.out.println("Cual es la fecha del partido");
        LocalDate fecha = Validacion.validarFecha(historicoPartidos);

        historicoPartidos.add(new Partido(e1, e2, afluencia, fecha));
    }

    public static void comprobarEstadioYVenderEntrada(){
        System.out.println("De que partido quieres la entrada:");
        Partido partido = seleccionarPartido();

        if(partido.getEstadio().isFull() == true){
            System.out.println("Ya se han vendido todas las entradas");
        }else{
            ventaEntradas(partido);
        }

    }

    public static void ventaEntradas(Partido partido){


        System.out.println("En que zona del estadio se quiere sentar:");
        Zona zona = seleccionarZona(partido);

        System.out.println("En que fila de la zona se quiere sentar:");
        Fila fila = seleccionarFila(zona);

        System.out.println("En que asiento se desea sentar:");
        int asiento = seleccionarAsiento(fila);

        if(zona.isVip() == true){
            entradasVendidas.add(new EntradaVip(zona, fila, asiento, partido));
        }else{
            entradasVendidas.add(new EntradaNormal(zona, fila, asiento, partido));
        }

        //Asignar como ocupado el asiento
        fila.getFila()[asiento] = true;

        //Asignar el dinero recaudado
        partido.setRecaudacion((int) (partido.getRecaudacion() + (partido.getAfluencia().getValor() * zona.getPrecioBase())));
    }

    public static void devolverEntrada(){
        System.out.println("Introduce el id de tu entrada:");
        int id = Validacion.solicitarEnteroValido();

        for(Entrada entrada : entradasVendidas){
            if(entrada.getId() == id){
                entradasVendidas.remove(entrada);
                entrada.getFila().getFila()[entrada.getAsiento()] = false;
                entrada.getPartido().setRecaudacion((int) (entrada.getPartido().getRecaudacion() - (entrada.getPartido().getAfluencia().getValor() * entrada.getZona().getPrecioBase())));
                return;
            }
        }
        System.out.println("No hay ninguna entrada con ese id");
    }

    public static void mostrarAsientosDisponibles(){
        Partido partido = seleccionarPartido();
        String VERDE = "\u001B[32m";
        String ROJO = "\u001B[31m";
        String RESET = "\u001B[0m";

        for(int i = 0; i < partido.getEstadio().getZonas().length; i++){
            System.out.println(partido.getEstadio().getZonas()[i].toString());
            for(int j = 0; j < partido.getEstadio().getZonas()[i].getFilas().length; j++){
                System.out.print(partido.getEstadio().getZonas()[i].getFilas()[j].toString());
                for(int k = 0; k < partido.getEstadio().getZonas()[i].getFilas()[j].getFila().length; k++){
                    if(partido.getEstadio().getZonas()[i].getFilas()[j].getFila()[k] == false){
                        System.out.printf("%s ["+k+".O]%s", VERDE, RESET);
                    }else{
                        System.out.printf("%s ["+k+".X]%s", ROJO, RESET);
                    }

                }
                System.out.println();
            }
        }
    }

    public static void mostrarRecaudacionPartido(){
        Partido partido = seleccionarPartido();
        System.out.println("Este partido ha recaudado: "+partido.getRecaudacion()+"€");
    }

    //############################### SELECIONAR DATOS ###############################

    public static int seleccionarAsiento(Fila fila){
        int opcion = -1;
        do{
            mostrarAsiento(fila);
            opcion = Validacion.solicitarEnteroValido();
            if(fila.getFila()[opcion] == true){
                System.out.println("Este numero no es valido, intentelo denuevo");
            }
        }while (fila.getFila()[opcion] == true);
        return opcion;
    }

    public static Fila seleccionarFila(Zona zona){
        int opcion = -1;
        do{
            mostrarFila(zona);
            opcion = Validacion.solicitarEnteroValido();
            if(zona.getFilas()[opcion-1].isFull() != false){
                System.out.println("Este numero no es valido, intentelo denuevo");
            }
        }while (zona.getFilas()[opcion-1].isFull() != false);
        return zona.getFilas()[opcion-1];
    }

    public static Zona seleccionarZona(Partido partido){
        int opcion = -1;
        do{
            mostrarZona(partido);
            opcion = Validacion.solicitarEnteroValido();
            if(opcion < 1 && opcion > partido.getEstadio().getZonas().length){
                System.out.println("Este numero no es valido, intentelo denuevo");
            }
        }while (opcion < 1 && opcion > partido.getEstadio().getZonas().length);
        return partido.getEstadio().getZonas()[opcion-1];
    }

    public static Partido seleccionarPartido(){
        int opcion = -1;
        do{
            mostrarPartidos();
            opcion = Validacion.solicitarEnteroValido();
            if(opcion < 1 && opcion > historicoPartidos.size()){
                System.out.println("Este numero no es valido, intentelo denuevo");
            }
        }while (opcion < 1 && opcion > historicoPartidos.size());
        return historicoPartidos.get(opcion-1);
    }

    public static Equipo selecionarEquipo(){
        int opcion = -1;
        do{
            mostrarEquipos();
            opcion = Validacion.solicitarEnteroValido();
            if(opcion < 1 && opcion > equipos.size()){
                System.out.println("Este numero no es valido, intentelo denuevo");
            }
        }while (opcion < 1 && opcion > equipos.size());
        return equipos.get(opcion-1);
    }

    public static Equipo selecionarEquipo(Equipo equipo){
        int opcion = -1;
        do{
            mostrarEquipos();
            opcion = Validacion.solicitarEnteroValido();
            if(opcion < 1 && opcion > equipos.size()){
                System.out.println("Este numero no es valido, intentelo denuevo");
            }
            if(equipos.get(opcion-1).getId() == equipo.getId()){
                System.out.println("No puedes seleccionar el mismo equipo");
            }
        }while (opcion < 1 && opcion > equipos.size() || equipos.get(opcion-1).getId() == equipo.getId());
        return equipos.get(opcion-1);
    }

    public static Afluencia selecionarAfluencia(){
        int opcion = -1;
        do{
            mostrarAfluencia();
            opcion = Validacion.solicitarEnteroValido();
            if(opcion < 1 && opcion > Afluencia.values().length){
                System.out.println("Este numero no es valido, intentelo denuevo");
            }
        }while (opcion < 1 && opcion > Afluencia.values().length);
        return Afluencia.values()[opcion-1];
    }

    //############################### MOSTRAR DATOS ###############################

    public static void mostrarAsiento(Fila fila){
        for(int i = 0; i < fila.getFila().length; i++){
            if(fila.getFila()[i] == false){
                System.out.println("Asiento "+(i));
            }
        }
    }

    public static void mostrarFila(Zona zona){
        for(int i = 0; i < zona.getFilas().length; i++){
            if(zona.getFilas()[i].isFull() == false){
                System.out.println((i+1)+". "+zona.getFilas()[i].getNombre());
            }
        }
    }

    public static void mostrarZona(Partido partido){
        for(int i = 0; i < partido.getEstadio().getZonas().length; i++){
            System.out.println((i+1)+". "+partido.getEstadio().getZonas()[i].getNombre()+" "+
                    (partido.getEstadio().getZonas()[i].getPrecioBase() * partido.getAfluencia().getValor())+"€");
        }
    }

    public static void mostrarPartidos(){
        for(int i = 0; i < historicoPartidos.size(); i++){
            System.out.println((i+1)+". "+historicoPartidos.get(i).toString());
        }
    }

    public static void mostrarEquipos(){
        for(int i = 0; i < equipos.size(); i++){
            System.out.println((i+1)+". "+equipos.get(i).getNombre());
        }
    }

    public static void mostrarAfluencia(){
        for(int i = 0; i < Afluencia.values().length; i++){
            System.out.println((i+1)+". "+Afluencia.values()[i].toString());
        }
    }
}
