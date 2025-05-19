package Diccionario;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Diccionario {
    private static Map<String, String> diccionario = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("""
                --- MENÚ ---
                0. Salir del diccionario
                1. Añadir palabra
                2. Traducir palabra
                3. Eliminar palabra
                4. Ver todas las palabras
                Elixe unha opción:
            """);
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 0 -> System.out.println("Saliendo del diccionario");
                case 1 -> añadirPalabra(sc);
                case 2 -> traducirPalabra(sc);
                case 3 -> borrarPalabra(sc);
                case 4 -> verPalabras();
                default -> System.out.println("Opción non válida.");
            }

        } while (opcion != 0);
    }

    private static void añadirPalabra(Scanner sc) {
        System.out.print("Introduce la palabra en español: ");
        String español = sc.nextLine();
        System.out.print("Traducción al inglés: ");
        String ingles = sc.nextLine();

        diccionario.put(español, ingles);
        System.out.println("Palabra guardada.");
    }

    private static void traducirPalabra(Scanner sc) {
        if (diccionario.isEmpty()) {
            System.out.println("Non hai palabras.");
        } else {
            System.out.print("Escribe la palabra que quieres traducir: ");
            String palabra = sc.nextLine();
            if(diccionario.containsKey(palabra)) {
                String traduccion = diccionario.get(palabra);
                System.out.println("Traduccion: " + traduccion);
            }
            else {
                System.out.println("Esa palabra no esta en el diccionario.");
            }
        }
    }

    private static void borrarPalabra(Scanner sc) {
        if (diccionario.isEmpty()) {
            System.out.println("Non hai contactos que borrar.");
            return;
        }

        verPalabras();
        System.out.print("Escribe la palabra que quieres eliminar: ");
        String palabra = sc.nextLine();

        if (diccionario.remove(palabra) != null) {
            System.out.println("Palabra eliminada.");
        } else {
            System.out.println("Esa palabra no esta en el diccionario.");
        }
    }
    private static void verPalabras() {
        if (diccionario.isEmpty()) {
            System.out.println("Non hai palabras.");
        } else {
            System.out.println("\nLista de palabras:");
            for (Map.Entry<String, String> palabras : diccionario.entrySet()) {
                System.out.println("- " + palabras.getKey() + ": " + palabras.getValue());
            }
        }
    }
}
