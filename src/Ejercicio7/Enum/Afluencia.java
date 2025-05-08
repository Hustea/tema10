package Ejercicio7.Enum;

public enum Afluencia {
    BAJA(0.75), MEDIA(1), ALTA(1.3);

    private double valor;
    Afluencia(double valor){
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
