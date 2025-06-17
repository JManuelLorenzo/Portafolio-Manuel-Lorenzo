package pd5.Ejercicio3;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

import pd5.Ejercicio1.TNodoTrie;
import pd5.Ejercicio3.INodoTrieTelefonos;
import pd5.Ejercicio3.TAbonado;

public class TNodoTrieTelefonos implements INodoTrieTelefonos {
    private   TreeMap<Character, TNodoTrieTelefonos> mapa;
    private TAbonado abonado; // Se inserta posteriormente.

    public TNodoTrieTelefonos() {
        mapa = new TreeMap<>();
    }

    @Override
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrieTelefonos  nodo = this;
        String nombre = nodo.abonado.getNombre();
        String originalPrefijo = primerosDigitos;

    }
    

    @Override
    public void insertar(TAbonado unAbonado) {
        if (unAbonado.getTelefono().isEmpty()) {
            //nodo.esPalabra = true;
            return;
        }
        insertarAux(unAbonado.getTelefono());
        return;
            }
    /**
     * Metodo Auxiliar para poder insertar en base a numeros.
     * @param tel
     */
    public void insertarAux(String tel){
        TNodoTrieTelefonos nodo = this;
        if (tel.isEmpty()) {
            return;
        }
         char caracter = tel.charAt(0);
            if (mapa.get(caracter) == null) {
                TNodoTrieTelefonos nodoHijo = new TNodoTrieTelefonos();
                mapa.put(caracter, nodoHijo);
                nodoHijo.insertarAux(tel.substring(1));
                
            }
            else{
                nodo = mapa.get(caracter);
                nodo.insertarAux(tel.substring(1));

    }

    
     /* @Override
    public void insertar(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            return;
        }
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra); */

    
}}


// Buscar Telefonos:
/*  public void predecir(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrie nodo = this;
        String originalPrefijo = prefijo;
        // Buscar el nodo correspondiente al prefijo
        for (int i = 0; i < prefijo.length(); i++) {
            nodo = nodo.mapa.get(prefijo.charAt(i));
            if (nodo == null) {
                return; // No hay abonados con ese prefijo
            }
        }
        // Desde el nodo encontrado, recolectar todas las abonados
        nodo.auxPredecir(originalPrefijo, abonados, nodo);
    }

    private void auxPredecir(String prefijo, LinkedList<TAbonado> abonados, TNodoTrie nodo) {
        abonados.add(prefijo);
      Set<Entry<Character, TNodoTrie>> set = nodo.mapa.entrySet();
      for (Entry<Character,TNodoTrie> entry : set) {
        auxPredecir(prefijo + entry.getKey(), palabras, entry.getValue());
      }
    } */