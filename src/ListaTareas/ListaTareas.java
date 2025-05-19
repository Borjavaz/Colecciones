package ListaTareas;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaTareas {

    private static List<String> lista = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("""
                --- MENÚ ---
                0. Salir del programa
                1. Engadir nova tarea
                2. Listar todas as tareas
                3. Eliminar una tarea
                Elixe unha opción:
            """);
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 0 -> System.out.println("Saliendo de tareas");
                case 1 -> engadirTarea(sc);
                case 2 -> listarTareas();
                case 3 -> borrarTarea();
                default -> System.out.println("Opción non válida.");
            }

        } while (opcion != 0);
    }

    private static void engadirTarea(Scanner sc) {
        System.out.println("Engade a túa tarea: ");
        String tarea = sc.nextLine();
        lista.add(tarea);

    }
    private static void listarTareas() {
        if (lista.isEmpty()) {
            System.out.println("Non hai notas gardadas.");
        } else {
            System.out.println("\nLista de notas:");
            for (String tarea : lista) {
                System.out.println("- " + tarea);
            }
        }
    }
    private static void borrarTarea() {
        if (lista.isEmpty()) {
            System.out.println("Non hai tarefas que borrar.");
            return;
        }

        listarTareas(); // Mostramos la lista antes
        try {

            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce o número da tarefa que queres eliminar (empezando por 1): ");
            int indice = sc.nextInt();
            String eliminada = lista.remove(indice - 1); // Restamos 1 para el índice real
            System.out.println("Tarefa eliminada: " + eliminada);

        }catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
