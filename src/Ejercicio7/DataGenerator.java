package Ejercicio7;

import Ejercicio7.Estadio.Estadio;
import Ejercicio7.Estadio.Fila;
import Ejercicio7.Estadio.Zona;
import Ejercicio7.Partido.Equipo;

import java.util.ArrayList;

public class DataGenerator {

    public static ArrayList<Equipo> generarListaConEquipos(){
        ArrayList<Equipo> equipos = new ArrayList<Equipo>();
        Equipo e1 = new Equipo("Barça");
        Equipo e2 = new Equipo("Madrid");
        Equipo e3 = new Equipo("Beti");
        Equipo e4 = new Equipo("LosPeruanos");
        Equipo e5 = new Equipo("BatmanY10Mas");

        equipos.add(e1);
        equipos.add(e2);
        equipos.add(e3);
        equipos.add(e4);
        equipos.add(e5);

        return equipos;
    }

    public static Estadio generarEstadio(){
        Zona z1 = generarZona("Zona Este", false, 20);
        Zona z2 = generarZona("Zona Oeste", false, 25);
        Zona z3 = generarZona("Zona Norte", false, 30);
        Zona z4 = generarZona("Zona VIP", true, 100);

        return new Estadio(new Zona[]{z1, z2, z3, z4});
    }

    public static Zona generarZona(String nombre, boolean vip, int precioBase){
        Fila f1 = new Fila('A');
        Fila f2 = new Fila('B');
        Fila f3 = new Fila('C');
        Fila f4 = new Fila('D');
        Fila f5 = new Fila('E');

        Fila[] filas ={f1, f2, f3, f4, f5};

        return new Zona(filas, nombre, vip, precioBase);
    }


}
