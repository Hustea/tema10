package Ejercicio7.Partido;

import Ejercicio7.DataGenerator;
import Ejercicio7.Enum.Afluencia;
import Ejercicio7.Estadio.Estadio;
import Ejercicio7.Partido.Partido;

import java.time.LocalDate;
import java.util.Objects;

public class Partido {
    private Ejercicio7.Partido.Equipo equipo1;
    private Ejercicio7.Partido.Equipo equipo2;
    private Afluencia afluencia;
    private LocalDate fecha;
    private Estadio estadio;
    private int recaudacion;

    public Partido(Equipo equipo1, Equipo equipo2, Afluencia afluencia, LocalDate fecha) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.afluencia = afluencia;
        this.fecha = fecha;
        this.estadio = DataGenerator.generarEstadio();
        this.recaudacion = 0;
    }

    public Ejercicio7.Partido.Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Ejercicio7.Partido.Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Ejercicio7.Partido.Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Ejercicio7.Partido.Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public Afluencia getAfluencia() {
        return afluencia;
    }

    public void setAfluencia(Afluencia afluencia) {
        this.afluencia = afluencia;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public int getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(int recaudacion) {
        this.recaudacion = recaudacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partido partido = (Partido) o;
        return Objects.equals(equipo1, partido.equipo1) && Objects.equals(equipo2, partido.equipo2) && afluencia == partido.afluencia && Objects.equals(fecha, partido.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipo1, equipo2, afluencia, fecha);
    }

    @Override
    public String toString() {
        return "Partido{" + equipo1 +" VS "+ equipo2 +" ("+fecha+")}";
    }
}
