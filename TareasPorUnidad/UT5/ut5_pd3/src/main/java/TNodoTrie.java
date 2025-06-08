
import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private LinkedList<String> paginas;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
        paginas = new LinkedList<String>();
    }

    @Override
    public void insertar(String texto) {
         String[] temp = texto.split(",");
         String unaPalabra = temp[0];
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
       for (int i = 1; i < temp.length; i++) {
        String pagina = temp[i];
        if (!nodo.paginas.contains(pagina)) {
        nodo.paginas.add(pagina);
         }
}

        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {
        imprimir("", this);
    }

    private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                return null;
            }
            nodo = nodo.hijos[indice];
        }
        return nodo;
    }

    private void predecir(String prefijo, LinkedList<String> palabras, TNodoTrie nodo) {
        if (nodo.esPalabra) {
            palabras.add(prefijo);
        }
        for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
            if (nodo.hijos[c] != null) {
                predecir(prefijo + (char) (c + 'a'), palabras, nodo.hijos[c]);
            }
        }
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie nodoPrefijo = buscarNodoTrie(prefijo);
        if (nodoPrefijo != null) {
            predecir(prefijo, palabras, nodoPrefijo);
        }
    }

    @Override
public int buscar(String s) {
    TNodoTrie nodo = this;
    int comparaciones = 0;

    for (int c = 0; c < s.length(); c++) {
        int indice = s.charAt(c) - 'a';
        comparaciones++;
        if (nodo.hijos[indice] == null) {
            return 0; // palabra no encontrada
        }
        nodo = nodo.hijos[indice];
    }

    return nodo.esPalabra ? comparaciones : 0;
}

public void imprimirIndice(String prefijo) {
    if (esPalabra) {
        // Imprimir palabra + páginas en la misma línea
        System.out.print(prefijo + ": ");
        for (String pagina : paginas) {
            System.out.print(pagina + " ");
        }
        System.out.println(); // salto de línea
    }

    // Recorrer los hijos en orden alfabético
    for (int i = 0; i < hijos.length; i++) {
        if (hijos[i] != null) {
            char letra = (char) ('a' + i);
            hijos[i].imprimirIndice(prefijo + letra);
        }
    }
}

}
