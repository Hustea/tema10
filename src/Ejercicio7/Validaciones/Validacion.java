package Ejercicio7.Validaciones;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validacion {
    static Scanner scanner = new Scanner(System.in);

    public static LocalDate validarFecha(){
        LocalDate fecha = null;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (fecha == null) {
            System.out.print("Introduce una fecha (formato dd/MM/yyyy): ");
            String entrada = scanner.nextLine();

            try {
                fecha = LocalDate.parse(entrada, formato);
                System.out.println("Fecha válida: " + fecha);
            } catch (DateTimeParseException dtpe) {
                System.out.println("Formato de fecha incorrecto. Inténtalo de nuevo.");
            }
        }
        return fecha;
    }

    public static int solicitarEnteroValido() {
        int numero = 0;
        boolean valido = false;

        do{
            String entrada = scanner.nextLine();

            try {
                numero = Integer.parseInt(entrada.trim());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, introduce un número entero dentro del rango válido (-2.147.483.648 a 2.147.483.647).");
            }
        }while (valido != true);

        return numero;
    }
}
