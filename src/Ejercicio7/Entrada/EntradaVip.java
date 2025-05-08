package Ejercicio7.Entrada;

import Ejercicio7.Estadio.Fila;
import Ejercicio7.Estadio.Zona;
import Ejercicio7.Partido.Partido;

import java.util.Objects;
import java.util.Random;

public class EntradaVip extends Entrada{
    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
    private static final int LONGITUD = 8;
    private String codigo;

    public EntradaVip(Zona zona, Fila fila, int asiento, Partido partido) {
        super(zona, fila, asiento, partido);
        this.codigo = generarContrasena();
    }

    public static String generarContrasena() {
        Random random = new Random();
        StringBuilder contrasena = new StringBuilder();

        for (int i = 0; i < LONGITUD; i++) {
            int indice = random.nextInt(CARACTERES.length());
            contrasena.append(CARACTERES.charAt(indice));
        }

        return contrasena.toString();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EntradaVip that = (EntradaVip) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), codigo);
    }

    @Override
    public String toString() {
        return "EntradaVip{" +
                "codigo='" + codigo + '\'' +
                '}';
    }
}
