package src;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 * @param <T>
 */
public class Conjunto<T> extends Lista<T> implements IConjunto {
// MEJOR: public class Conjunto<T> extends ListaOrdenada<T> implements IConjunto {

    @Override
    public Conjunto interseccion(Conjunto otroConjunto) {
        Conjunto resultado = new Conjunto();
        Nodo<T> nodoA = this.getPrimero();
        Nodo<T> nodoB = otroConjunto.getPrimero();

        while (nodoA != null && nodoB != null) {
            int comparacion = nodoA.getEtiqueta().compareTo(nodoB.getEtiqueta());

            if (comparacion == 0) {
                // Coincidencia encontrada: agregar al resultado (¡CREAR NODO NUEVO!)
                resultado.insertar(new Nodo<>(nodoA.getEtiqueta(), nodoA.getDato()));
                nodoA = nodoA.getSiguiente();
                nodoB = nodoB.getSiguiente();
            } else if (comparacion < 0) {
                // Avanzar en el conjunto A (su etiqueta es menor)
                nodoA = nodoA.getSiguiente();
            } else {
                // Avanzar en el conjunto B (su etiqueta es mayor)
                nodoB = nodoB.getSiguiente();
            }
        }
        return resultado;
    }




    @Override
    public Conjunto union(Conjunto otroConjunto) {
        Conjunto resultado = new Conjunto();

        // Copiar todos los elementos del primer conjunto
        Nodo<T> actual = this.getPrimero();
        while (actual != null) {
            resultado.insertar(new Nodo<>(actual.getEtiqueta(), actual.getDato()));
            actual = actual.getSiguiente();
        }

        // Agregar elementos del segundo conjunto que no existan
        actual = otroConjunto.getPrimero();
        while (actual != null) {
            if (resultado.buscar(actual.getEtiqueta()) == null) {
                resultado.insertar(new Nodo<>(actual.getEtiqueta(), actual.getDato()));
            }
            actual = actual.getSiguiente();
        }

        return resultado;
    }


}







