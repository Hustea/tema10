import java.util.ArrayList;
import java.util.Objects;

public class Poligono {
    ArrayList<Punto> puntos;

    public Poligono(ArrayList puntos){
        this.puntos = puntos;
    }

    /**
     * Mover un poligono
     * @param x
     * @param y
     */
    public void traslada(double x, double y){
        for(Punto punto : puntos){
            punto.setX(punto.getX() + x);
            punto.setY(punto.getY() + y);
        }
    }

    /**
     * Calcular el diametro de un poligono
     * @return el diametro
     */
    public double perimetro(){
        double perimetro = 0;
        double cateto1;
        double cateto2;
        for(int i = 0; i < puntos.size()-1; i++){
            cateto1 = puntos.get(i).getX() - puntos.get(i+1).getX();
            cateto2 = puntos.get(i).getY() - puntos.get(i+1).getY();
            perimetro += Math.sqrt((cateto1 * cateto1) + (cateto2 * cateto2));
        }
        cateto1 = puntos.get(puntos.size()-1).getX() - puntos.get(0).getX();
        cateto2 = puntos.get(puntos.size()-1).getY() - puntos.get(0).getY();
        perimetro += Math.sqrt((cateto1 * cateto1) + (cateto2 * cateto2));
        return perimetro;
    }

    public int numVertices(){
        return puntos.size();
    }

    public ArrayList<Punto> getPuntos() {
        return puntos;
    }

    public void setPuntos(ArrayList<Punto> puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Poligono{" +
                "puntos=" + puntos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Poligono poligono = (Poligono) o;
        return Objects.equals(puntos, poligono.puntos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(puntos);
    }

}
