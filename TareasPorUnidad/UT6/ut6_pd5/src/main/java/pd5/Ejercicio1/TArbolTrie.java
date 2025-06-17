package pd5.Ejercicio1;

import java.util.LinkedList;

public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;

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
public void insertarPosicion(String palabra, Integer entero) {
        if (palabra == null || palabra.isEmpty()) {
            return;
        }
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertarPosicion(palabra, entero); // El entero es la posicion de la palabra en el texto, se puede implemntar con un contador.
    }


    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
    public LinkedList<String> imprimir(String patron){
        LinkedList<String> palabras = new LinkedList<>();
        if(raiz != null){
            raiz.imprimir(patron, palabras);
        }
        return palabras;
    }

    @Override
    public int buscar(String palabra) {
        if (raiz == null) {
            return 0;
        }
        return raiz.buscar(palabra);
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> palabras = new LinkedList<>();
        if (raiz != null) {
            raiz.predecir(prefijo, palabras);
        }
        return palabras;
    }
}
