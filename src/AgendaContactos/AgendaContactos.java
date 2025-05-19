package AgendaContactos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class AgendaContactos {

    private static final String FICHEIRO = "agenda.txt";
    private static Map<String, String> agenda = new HashMap<>();

    public static void main(String[] args) {

        cargarAgenda();

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("""
                --- MENÚ ---
                0. Salir de la agenda
                1. Añadir Contacto
                2. Listar Contactos
                3. Eliminar Contacto
                Elixe unha opción:
            """);
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 0 -> System.out.println("Saliendo de la agenda");
                case 1 -> añadirContacto(sc);
                case 2 -> listarContactos();
                case 3 -> borrarContacto(sc);
                default -> System.out.println("Opción non válida.");
            }

        } while (opcion != 0);
    }

    private static void añadirContacto(Scanner sc) {
      try {
          System.out.print("Nombre: ");
          String nombre = sc.nextLine();
          System.out.print("Número de contacto: ");
          String numero = sc.nextLine();

          agenda.put(nombre, numero);
          guardarAgenda();
          System.out.println("Contacto guardado.");
      } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
      }
    }

    private static void listarContactos() {
       try {

           if (agenda.isEmpty()) {
               System.out.println("Non hai contactos.");
           } else {
               System.out.println("\nLista de contactos:");
               for (Map.Entry<String, String> contacto : agenda.entrySet()) {
                   System.out.println("- " + contacto.getKey() + ": " + contacto.getValue());
               }
           }
       }catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
       }
    }

    private static void borrarContacto(Scanner sc) {
       try {

           if (agenda.isEmpty()) {
               System.out.println("Non hai contactos que borrar.");
               return;
           }

           listarContactos();
           System.out.print("Escribe el nombre del contacto que quieres eliminar: ");
           String nombre = sc.nextLine();

           if (agenda.remove(nombre) != null) {
               guardarAgenda();
               System.out.println("Contacto eliminado.");
           } else {
               System.out.println("Ese contacto no existe.");
           }
       }catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
       }
    }
    private static void cargarAgenda() {
        try (BufferedReader br = new BufferedReader(new FileReader(FICHEIRO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length == 2) {
                    agenda.put(partes[0], partes[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Non se puido ler o ficheiro");
        }
    }

    private static void guardarAgenda() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHEIRO))) {
            for (Map.Entry<String, String> contacto : agenda.entrySet()) {
                bw.write(contacto.getKey() + ":" + contacto.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao gardar a agenda.");
        }
    }
}
