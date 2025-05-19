package ListaInvitados;

import java.util.*;

public class ListaInvitados {
    private static Set<String> lista = new HashSet<String>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("""
                --- MENÚ ---
                0. Salir del programa
                1. Añadir invitado
                2. Eliminar invitado
                3. Mostrar invitados
                4. Comprobar si un invitado esta en la lista
                Elixe unha opción:
            """);
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 0 -> System.out.println("Saliendo de la lista  de invitados");
                case 1 -> añadirInvitado(sc);
                case 2 -> eliminarInvitado(sc);
                case 3 -> mostrarInvitados();
                case 4 -> buscarInvitado(sc);
                default -> System.out.println("Opción non válida.");
            }

        } while (opcion != 0);
    }

    private static void añadirInvitado(Scanner sc) {
        System.out.println("Nombre del invitado: ");
        String invitado = sc.nextLine();
        lista.add(invitado);
    }
    private static void mostrarInvitados() {
        if (lista.isEmpty()) {
            System.out.println("Non hai invitados.");
        } else {
            System.out.println("\nLista de invitados:");
            for (String invitado : lista) {
                System.out.println("- " + invitado);
            }
        }
    }
    private static void eliminarInvitado(Scanner sc) {
        if (lista.isEmpty()) {
            System.out.println("Non hai invitados.");
            return;
        }

        mostrarInvitados(); // Mostramos la lista antes
        try {
            System.out.print("Introduce el nombre del invitado que queres eliminar: ");
            String eliminado = sc.nextLine();
            if (lista.remove(eliminado)) {
                System.out.println("Invitado Eliminado.");
            } else {
                System.out.println("Este invitado no esta en la lista.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static void buscarInvitado(Scanner sc) {
        if (lista.isEmpty()) {
            System.out.println("Non hai invitados.");
        }
        else  {
            System.out.print("Introduce el nombre del invitado que quieres buscar: ");
            String invitadoBuscar = sc.nextLine();

            if (lista.contains(invitadoBuscar)) {
                System.out.println("El invitado ya esta en la lista");
            }
            else {
                System.out.println("El invitado no esta en la lista");
            }
        }
    }
}
