package pd5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TNodoTrie implements INodoTrie {

    private   TreeMap<Character, TNodoTrie> mapa;
    private boolean esPalabra;
    

    public TNodoTrie() {
        mapa = new TreeMap<>();
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        if (unaPalabra.isEmpty()) {
            nodo.esPalabra = true;
            return;
        } 
        
        
        char caracter = unaPalabra.charAt(0);
            if (mapa.get(caracter) == null) {
                TNodoTrie nodoHijo = new TNodoTrie();
                mapa.put(caracter, nodoHijo);
                nodoHijo.insertar(unaPalabra.substring(1));
                
            }
            else{
                nodo = mapa.get(caracter);
                nodo.insertar(unaPalabra.substring(1));

            }
       
        }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
            }
            Set<Entry<Character, TNodoTrie>> valores = nodo.mapa.entrySet();
            for (Entry<Character,TNodoTrie> entry : valores) {
                entry.getValue().imprimir(s + entry.getKey(), entry.getValue() );
            }
        }
    }

    @Override
    public void imprimir() {
        imprimir("", this);
    }

    public TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        if (s.isEmpty()) {
            return nodo;
        }
       {
            TNodoTrie next  = nodo.mapa.get(s.charAt(0)); 
            if (next != null){
                return next.buscarNodoTrie(s.substring(1));
            }
            return null;
        }
    }

    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie nodo = this;
        String originalPrefijo = prefijo;
        // Buscar el nodo correspondiente al prefijo
        for (int i = 0; i < prefijo.length(); i++) {
            nodo = nodo.mapa.get(prefijo.charAt(i));
            if (nodo == null) {
                return; // No hay palabras con ese prefijo
            }
        }
        // Desde el nodo encontrado, recolectar todas las palabras
        nodo.auxPredecir(originalPrefijo, palabras, nodo);
    }

    private void auxPredecir(String prefijo, LinkedList<String> palabras, TNodoTrie nodo) {
       if(nodo.esPalabra){
        palabras.add(prefijo);
       } 
      Set<Entry<Character, TNodoTrie>> set = nodo.mapa.entrySet();
      for (Entry<Character,TNodoTrie> entry : set) {
        auxPredecir(prefijo + entry.getKey(), palabras, entry.getValue());
      }
    }

    @Override
public int buscar(String s) {
    TNodoTrie nodo = this;
    int comparaciones = 0;
    while (!s.isEmpty()) {
        TNodoTrie next = nodo.mapa.get(s.charAt(0));
        if ( next != null) {
        nodo = next;
        comparaciones++;
        s = s.substring(1);}
        else{
            return 0;
        }
    }
    return nodo.esPalabra ? comparaciones : 0; // Asegura que estemos al final de algo con sentido. 
}

}
