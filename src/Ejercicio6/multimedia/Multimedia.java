package Ejercicio6.multimedia;

import Ejercicio6.personas.Autor;
import Ejercicio6.enumerados.Formato;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.Objects;

public abstract class Multimedia {
    private String titulo;
    private Autor autor;
    private Formato formato;
    private Year ano;

    public Multimedia(String titulo, Autor autor, Year ano, Formato formato) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.formato = formato;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public Year getAno() {
        return ano;
    }

    public void setAno(Year ano) {
        this.ano = ano;
    }

    public int getPrecio(){
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Multimedia that = (Multimedia) o;
        return Objects.equals(titulo, that.titulo) && Objects.equals(autor, that.autor) && formato == that.formato && Objects.equals(ano, that.ano);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, formato, ano);
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", formato=" + formato +
                ", ano=" + ano +
                '}';
    }
}
