package Ejercicio6;

import Ejercicio6.multimedia.Multimedia;
import Ejercicio6.personas.Socio;

import java.time.LocalDateTime;

public class Alquiler {
    private Socio socio;
    private Multimedia multimedia;
    private LocalDateTime fecha;

    public Alquiler(Socio socio, Multimedia multimedia, LocalDateTime fecha){
        this.socio = socio;
        this.multimedia = multimedia;
        this.fecha = fecha;
    }

    public Alquiler(Socio socio, Multimedia multimedia){
        this.socio = socio;
        this.multimedia = multimedia;
        this.fecha = LocalDateTime.now();
    }

    public Socio getSocio() {
        return socio;
    }

    public Multimedia getMultimedia() {
        return multimedia;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
}
