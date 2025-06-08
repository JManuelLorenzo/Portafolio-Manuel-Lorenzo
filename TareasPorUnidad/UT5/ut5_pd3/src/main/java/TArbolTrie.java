import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;
    TArbolTrie(){
        raiz = new TNodoTrie(); 
    }

    @Override
    public void insertar(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            return;
        }
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    @Override
    public int buscar(String palabra) {
        if (raiz == null) {
            return 0;
        }
        return raiz.buscar(palabra);
    }
    public void imprimirIndice() {
    if (raiz != null) {
        raiz.imprimirIndice(""); // el prefijo empieza vacío
    }
    }


    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> palabras = new LinkedList<>();
        if (raiz != null) {
            raiz.predecir(prefijo, palabras);
        }
        return palabras;
    }
        public void indizarLibro(String rutaArchivo) {
        int lineaActual = 0;
        int paginaActual = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                lineaActual++;

                // Actualizar número de página
                if (lineaActual % 50 == 0) {
                    paginaActual++;
                }

                // Eliminar puntuación y pasar a minúsculas
                String lineaLimpia = linea.replaceAll("[^a-zA-Z ]", "").toLowerCase();
                String[] palabras = lineaLimpia.split("\\s+");

                for (String palabra : palabras) {
                    if (buscar(palabra) != 0 ) {
                    palabra =  palabra.toLowerCase().replaceAll("[^a-z]", "");
                    if (!palabra.isEmpty()) {
                        raiz.insertar(palabra + "," + paginaActual);
                    }
                }}
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        
    }

    // Otros métodos del Trie, como imprimir, buscar, etc.
}

