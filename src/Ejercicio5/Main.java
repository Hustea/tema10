package Ejercicio5;

import java.util.ArrayList;

public class Main {
    static ArrayList<Item> Inventario = new ArrayList<>();
    static final int TAMANIO_INVENTARIO = 7;

    public static void anadirObjeto(Item item){
        boolean anadido = false;

        for(Item objeto : Inventario){
            if(objeto.getID() == item.getID()){
                if(objeto.getCant() < objeto.getApilable()){
                    objeto.setCant(objeto.getCant()+1);
                    anadido = true;
                    break;
                }
            }
        }

        if(anadido = false && Inventario.size() < TAMANIO_INVENTARIO){
            Inventario.add(item);
        }else{
            System.out.println("No hay espacio en el inventario");
        }
    }
}
