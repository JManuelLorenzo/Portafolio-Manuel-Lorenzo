import pd1.*;
import java.util.LinkedList;
import java.util.List;


public class TestMedicionTrie {

    public static void main(String[] args) {
        // Palabras de ejemplo
        String[] palabras = {"casa", "caso", "casual", "casilla", "cascada", "cascabel", "carta", "carro", "caracol"};

        // Trie con HashMap
        TNodoTrie trieHash = new TNodoTrie();
        for (String palabra : palabras) {
            trieHash.insertar(palabra);
        }

        // Trie con TreeMap o lista
        TNodoTrieNormal trieLista = new TNodoTrieNormal();
        for (String palabra : palabras) {
            trieLista.insertar(palabra);
        }

        // Palabras a buscar
        String[] busquedas = {"casa", "caso", "cascada", "carro", "caracol", "noexiste"};

        // Medición en TrieHash usando predecir
        Medicion medicionTrieHash = medirPredecirTrie(trieHash, busquedas, 100000);

        // Medición en TrieLista usando predecir
        Medicion medicionTrieLista = medirPredecirTrie(trieLista, busquedas, 100000);

        System.out.println(medicionTrieHash);
        System.out.println(medicionTrieLista);
    }

    private static Medicion medirPredecirTrie(Object trie, String[] prefijos, int repeticiones) {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();
        long tiempoInicio = System.nanoTime();
        for (int i = 0; i < repeticiones; i++) {
            for (String prefijo : prefijos) {
                LinkedList<String> palabras = new LinkedList<>();
                // Llama a predecir según el tipo de trie
                if (trie instanceof TNodoTrie) {
                    ((TNodoTrie) trie).predecir(prefijo, palabras);
                } else if (trie instanceof TNodoTrieNormal) {
                    ((TNodoTrieNormal) trie).predecir(prefijo, palabras);
                }
            }
        }
        long tiempoFin = System.nanoTime();
        long memoriaDespues = runtime.totalMemory() - runtime.freeMemory();
        String tipo = (trie instanceof TNodoTrie) ? "TrieHash" : "TrieLista";
        return new Medicion("Predecir en " + tipo, (memoriaDespues - memoriaAntes), (tiempoFin - tiempoInicio));
    }
}
