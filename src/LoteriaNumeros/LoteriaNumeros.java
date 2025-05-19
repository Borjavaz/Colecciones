package LoteriaNumeros;

import java.util.*;

public class LoteriaNumeros {
    private static Set<Integer> loteria = new HashSet<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("""
                        --- MENÚ ---
                        0. Salir del programa
                        1. Añadir numero jugado
                        2. Mostrar numeros jugados
                        3. Comprobar si un numero ya se jugo
                        4. Eliminar numero
                        5. Borrar todos los numeros jugados
                        Elixe unha opción:
                    """);
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 0 -> System.out.println("Saliendo de tareas");
                case 1 -> añadirNumero(sc);
                case 2 -> mostrarNumeros();
                case 3 -> comprobarNumero(sc);
                case 4 -> eliminarNumero(sc);
                case 5 -> eliminarTodos();
                default -> System.out.println("Opción non válida.");
            }

        } while (opcion != 0);
    }

        private static void añadirNumero (Scanner sc){
            System.out.println("Añade tu numero(1-50): ");
            Integer numero = sc.nextInt();
            sc.nextLine();
            if (numero > 50) {
                System.out.println("Error: numero invalido");
            } else if (numero < 1) {
                System.out.println("Error: numero invalido");
            } else {
                loteria.add(numero);
                System.out.println("Numero añadido correctamente.");
            }

        }

        private static void mostrarNumeros () {
            if (loteria.isEmpty()) {
                System.out.println("Non hai numeros guardados.");
            } else {
                System.out.println("\nLista de numeros:");
                for (Integer numero : loteria) {
                    System.out.println("- " + numero);
                }
            }
        }
        private static void eliminarNumero (Scanner sc){
            if (loteria.isEmpty()) {
                System.out.println("Non hai numeros.");
                return;
            }

            mostrarNumeros(); // Mostramos la lista antes
            try {
                System.out.print("Introduce el numero que queres eliminar: ");
                Integer eliminado = sc.nextInt();
                sc.nextLine();
                if (loteria.remove(eliminado)) {
                    System.out.println("Numero Eliminado.");
                } else {
                    System.out.println("Este numero no esta en la lista.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        private  static void comprobarNumero (Scanner sc){
            if (loteria.isEmpty()) {
                System.out.println("Non hai numeros.");
            }
            else  {
                System.out.print("Introduce el nombre del numero que quieres comprobar: ");
                Integer numeorComprobar = sc.nextInt();
                sc.nextLine();

                if (loteria.contains(numeorComprobar)) {
                    System.out.println("El numero esta en la lista");
                }
                else {
                    System.out.println("El numero no esta en la lista");
                }
            }
        }
        private static void eliminarTodos(){
            if (loteria.isEmpty()) {
                System.out.println("Non hai numeros en la lista.");
            }
            else  {
                loteria.clear();
                System.out.println("Todas los numeros eliminados.");
            }
        }
    }