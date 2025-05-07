package Ejercicio6;

import Ejercicio6.enumerados.Formato;
import Ejercicio6.enumerados.Plataforma;
import Ejercicio6.multimedia.Multimedia;
import Ejercicio6.multimedia.Pelicula;
import Ejercicio6.multimedia.Videojuego;
import Ejercicio6.personas.Actor;
import Ejercicio6.personas.Actriz;
import Ejercicio6.personas.Autor;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;

public class DataGenerator {
    public void generacionPrueba(ArrayList<Multimedia> coleccion){
        Autor au1 = new Autor("Cervantes");
        Actor ac1 = new Actor("LaPedra");
        Actriz az1 = new Actriz("Ellen");
        Plataforma xbox = Plataforma.X_BOX;
        Year fecha = Year.now();

        Pelicula p1 = new Pelicula("Batman2", au1, fecha, Formato.BLU_RAY, 130, ac1, az1);
        Pelicula p2 = new Pelicula("Batman3", au1, fecha, Formato.BLU_RAY, 100, ac1, az1);

        Videojuego v1 = new Videojuego("Sekiro2", au1, fecha, Formato.CD, xbox);
        Videojuego v2 = new Videojuego("Sekiro3", au1, fecha, Formato.CD, xbox);

        coleccion.add(p1);
        coleccion.add(p2);
        coleccion.add(v1);
        coleccion.add(v2);
    }



}
