package Ejercicio5;

import java.util.Objects;

public class Item {
    private int apilable;
    private int cant;
    private static final int CANTIDAD_INICIAL = 1;
    private int id;


    public Item(int id, int apilable) {
        this.id = id;
        this.apilable = apilable;
        this.cant = CANTIDAD_INICIAL;
    }

    public int getApilable() {
        return apilable;
    }

    public int getCant() {
        return cant;
    }

    public int getID(){
        return id;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return apilable == item.apilable;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(apilable);
    }

    @Override
    public String toString() {
        return "Item{" +
                "apilable=" + apilable +
                '}';
    }
}
