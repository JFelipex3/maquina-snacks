package com.cursoudemy.java.maquina_snack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {

    public static void main(String[] args) {
        MaquinaSnacks();
    }

    public static void MaquinaSnacks() {
        var salir = false;
        var consola = new Scanner(System.in);

        // Creamos la lista de productos de tipo snacks
        List<Snack> productos = new ArrayList<>();
        System.out.println("*** Bienvenido a la Maquina de Snacks ***");
        Snacks.mostrarSnacks();

        while (!salir) {
            try {
                var opcion = mostraMenu(consola);
                salir = ejecutarOpciones(opcion, consola, productos);
                
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            finally {
                System.out.println(); // Imprime un salto de línea con cada iteración
            }
        }

    }
    
    private static int mostraMenu(Scanner consola) {
        System.out.println("""
                Menu:
                1. Comprar snack
                2. Mostrar ticket
                3. Agregar Nuevo Snack
                4. Salir
                Elige una opcion:\s""");
        
        // Leemos y retornamos la opción seleccionada
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack> productos) {
        
        boolean salir = false;

        switch (opcion) {
            case 1 -> comprarSnack(consola, productos);
            case 2 -> mostrarTicket(productos);
            case 3 -> agregarNuevoSnack(consola);
            case 4 -> {
                System.out.println("Gracias por usar la Maquina de Snacks. ¡Hasta luego!");
                salir = true;
            }
            default -> System.out.println("Opción no válida. Por favor, elige una opción del menú.");
        }

        return salir;
    }

    private static void comprarSnack(Scanner consola, List<Snack> productos) {
        
        System.out.print("Que snack quiere comprar (id)? ");
        var idSnack = Integer.parseInt(consola.nextLine());

        var snackEncontrado = false;
        for (Snack snack : Snacks.getSnacks()) {
            if (snack.getIdSnack() == idSnack) {
                productos.add(snack);
                snackEncontrado = true;
                System.out.println("Snack agregado: " + snack);
                break;
            }
        }

        if (!snackEncontrado) {
            System.out.println("Snack no encontrado con id: " + idSnack);
        }
    }

    private static void mostrarTicket(List<Snack> productos) {

        var ticket = "*** Ticket de venta ***";
        var total = 0.0;
        
        if (productos.isEmpty()) {
            ticket = "No hay productos en el ticket.";
        } else {
            for (Snack snack : productos) {
                ticket += "\n\t- " + snack.getNombre() + " - $" + snack.getPrecio();
                total += snack.getPrecio();
            }

            ticket += "\n\tTotal -> $" + total;
        }

        System.out.println(ticket);
    }

    private static void agregarNuevoSnack(Scanner consola) {
        
        System.out.print("Nombre Nuevo Snack: ");
        var nombre = consola.nextLine();

        System.out.print("Precio Nuevo Snack: ");
        var precio = Double.parseDouble(consola.nextLine());

        var nuevoSnack = new Snack(nombre, precio);
        Snacks.agregarSnack(nuevoSnack);

        System.out.println("Nuevo Snack Agregado: " + nuevoSnack);
        Snacks.mostrarSnacks();
    }
}