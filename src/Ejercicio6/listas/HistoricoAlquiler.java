package Ejercicio6.listas;

import Ejercicio6.Alquiler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HistoricoAlquiler {
    private List<Alquiler> historico;

    public HistoricoAlquiler(){
        this.historico = new ArrayList<Alquiler>();
    }

    public List<Alquiler> getHistorico() {
        return historico;
    }

    public void setHistorico(List<Alquiler> historico) {
        this.historico = historico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricoAlquiler that = (HistoricoAlquiler) o;
        return Objects.equals(historico, that.historico);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(historico);
    }

    @Override
    public String toString() {
        return "HistoricoAlquiler{" +
                "historico=" + historico +
                '}';
    }
}
