public class Resumen {
    /*
    🎒 Tipos de colecciones más comunes:

            1. List (lista ordenada)
            ✅ Guarda elementos en orden.

            ✅ Permite duplicados.

            ✅ Acceso por posición (get(0), get(1), etc.).


List<String> lista = new ArrayList<>();
lista.add("Hola");
lista.add("Adiós");
System.out.println(lista.get(0)); // "Hola"


            2. Set (conjunto sin duplicados)

            ❌ No permite elementos repetidos.

            🔀 No garantiza el orden (en general).


Set<String> conjunto = new HashSet<>();
conjunto.add("Hola");
conjunto.add("Hola"); // No se guarda dos veces

             3. Map (diccionario o clave-valor)
                🗝 Guarda pares: clave → valor.

                📖 Ejemplo: "usuario" → "contraseña".

Map<String, String> mapa = new HashMap<>();
mapa.put("Borja", "Borja1234");
System.out.println(mapa.get("Borja")); // "Borja1234"

            4. TreeSet (conjunto ordenado)
            🔠 No permite duplicados (como Set).
            ✅ Ordena automáticamente los elementos (orden natural o con comparador).
            📏 Ideal si necesitas mantener los datos sin repetir y ordenados.

Set<String> treeSet = new TreeSet<>();
treeSet.add("Banana");
treeSet.add("Manzana");
treeSet.add("Manzana"); // No se guarda dos veces
System.out.println(treeSet); // [Banana, Manzana] (orden alfabético)

/*
    5. TreeMap (mapa ordenado por clave)
            🔠 Non permite claves duplicadas (como Map).
            ✅ Ordena automaticamente segundo as claves (orde natural ou con comparador).
            📏 Ideal se necesitas acceder aos datos en orde segundo as claves.

Map<Character, String> mapa = new TreeMap<>();
mapa.put('C', "Carlos");
mapa.put('A', "Ana");
mapa.put('A', "Antonio"); // Sobrescribe o valor anterior
System.out.println(mapa); // {A=Antonio, C=Carlos}
*/

}
