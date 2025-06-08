import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        TArbolTrie arbol = new TArbolTrie();

        // Paso 1: cargar palabras del índice
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/PalabrasIndice.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String palabra = linea.toLowerCase().replaceAll("[^a-z]", "");
                if (!palabra.isEmpty()) {
                    arbol.insertar(palabra);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer archivo de índice: " + e.getMessage());
        }

        // Paso 2: indizar solo esas palabras en el libro
        arbol.indizarLibro("src/main/java/libro.txt");

        // Paso 3: imprimir el índice
        arbol.imprimirIndice();
    }
}
