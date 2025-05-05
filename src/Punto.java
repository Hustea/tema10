import java.util.Objects;

public class Punto {
    double x;
    double y;

    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Punto(){
        this.x = 0;
        this.y = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distancia(Punto punto){
        double cateto1 = this.x - punto.x;
        double cateto2 = this.y - punto.y;

        return Math.sqrt((cateto1 * cateto1) + (cateto2 * cateto2));
    }

    @Override
    public String toString() {
        return "Punto{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Punto punto = (Punto) o;
        return Double.compare(x, punto.x) == 0 && Double.compare(y, punto.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
