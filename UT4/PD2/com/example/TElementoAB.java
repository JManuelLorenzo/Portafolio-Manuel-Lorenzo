package com.example;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     * @return
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;

    }

    @Override
    public TElementoAB<T> getHijoIzq() {
       return hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        hijoDer = elemento;
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
       int comparacion = 0;
        String thisEtiqueta = etiqueta.toString();
        String otherEtiqueta = unaEtiqueta.toString();
        try {
            comparacion = Integer.compare(Integer.parseInt(thisEtiqueta), Integer.parseInt(otherEtiqueta));
        } catch (NumberFormatException e) {
            comparacion = etiqueta.compareTo(unaEtiqueta);
        }// Es importante recordar que compareTo da 0 si son iguales, 1 si es mayor el que usa el método o -1 si es menor.
        if (comparacion == 0){ // Si el nodo actual tiene la etiqueta identica, entonces se devuelve el nodo actual.
            return this; // Caso Base.
        }
        if (comparacion > 0) { // Si el nodo tiene la etiqueta mayor a la que buscamos, intentamos ir a la izquierda.
            if(getHijoIzq() == null){ // Si ya estamos en una hoja, no hay nodo siguiente, entonces no existe ese nodo.
                return null; // No existe el nodo.
            }
            else{
              return  getHijoIzq().buscar(unaEtiqueta); // Se llama  recursivamente a otro buscar con el hijo izquierdo.
            }}
        if (comparacion < 0) { // En el caso opuesto se da la misma logica.

            if (getHijoDer() == null) { // Si el hijoDerecho es nulo estamos al final, por lo tanto no existe en el árbol.
                return  null;
            }
            else {
              return  getHijoDer().buscar(unaEtiqueta); // Se llama recursivamente a el método.
            }
        }
        return null; // nunca deberia llegar aca pero el método necesita que devuelva algo porque no es void.
    }

    @Override
    public boolean insertar(TElementoAB<T> elemento) {
        int comparacion = 0;
        String thisEtiqueta = etiqueta.toString();
        String otherEtiqueta = elemento.getEtiqueta().toString();
        try {
            comparacion = Integer.compare(Integer.parseInt(thisEtiqueta), Integer.parseInt(otherEtiqueta));
        } catch (NumberFormatException e) {
            comparacion = etiqueta.compareTo(elemento.getEtiqueta());
        }
         // Se compara etiqueta con la etiqueta. 

        if (comparacion > 0) { // Si el nodo actual es mayor que el que el que estamos buscando, va hacia la izquierda.
            if (getHijoIzq() == null) { // Si el hijo Izquierdo esta vacio. Se deberia asignar ahi a el elemento
                setHijoIzq(elemento); // Se utiliza un setter para colocar a el elemento de Hijo izq del nodo actual.
                return true; // se realizo la insercion.
            } else { //Sino
                return getHijoIzq().insertar(elemento); // Se hace la llamada recursiva.
            }
        } else if (comparacion < 0) { // Si es menor que el actual, debe ir a la derecha.
            if (getHijoDer() == null) { // Si el hijo Derecho esta vacio, se le asigna el elemento que usamos de parametro.
                setHijoDer(elemento); // Se utiliza setter
                return true; // se realizo la insercion.
            } else {
                return getHijoDer().insertar(elemento); // lamada recursiva.
            }
        }
            return false; // nunca deberia llegar aqui pero es necesario asegurar una salida booleana.

    }

    @Override
    public String preOrden() {
        String resultado = this.getEtiqueta().toString();
        if (this.hijoIzq != null) {
        resultado += "-" + this.hijoIzq.preOrden();
        }
        if (this.hijoDer != null) {
        resultado += "-" + this.hijoDer.preOrden();
        }
        return resultado;
    }

    @Override
    public String inOrden() {
        String resultado = "";
        if (this.hijoIzq != null) {
            resultado += this.hijoIzq.inOrden() + "-";
        }
        resultado += this.getEtiqueta().toString();
        if (this.hijoDer != null) {
            resultado += "-" + this.hijoDer.inOrden();
        }
        return resultado;
    }

    @Override
    public String postOrden() {
        String resultado = "";
        if (this.hijoIzq != null) {
            resultado += this.hijoIzq.postOrden() + "-";
        }
        if (this.hijoDer != null) {
            resultado += this.hijoDer.postOrden() + "-";
        }
        resultado += this.getEtiqueta().toString();
        return resultado;
    }

    
    public T getDatos() { //
        return datos;
    }

    
    public TElementoAB eliminar(Comparable unaEtiqueta) {

        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }
 
}

