package com.example;

import java.util.LinkedList;

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
        int comparacion =  etiqueta.compareTo(unaEtiqueta); // Es importante recordar que compareTo da 0 si son iguales, 1 si es mayor el que usa el método o -1 si es menor.
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
        int comparacion = etiqueta.compareTo(elemento.etiqueta);  // Se compara etiqueta con la etiqueta. 
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

    @Override
    public T getDatos() { //
        return datos;
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {

        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public int obtenerAltura() {
        int a = -1;
        int b = -1;
        if (hijoIzq != null) {
            a = hijoIzq.obtenerAltura();
        }
        if (hijoDer != null){
            b = hijoDer.obtenerAltura();
        }
        return Math.max(a,b) + 1; 
    }
    
    public int ObtenerTamanio() {
        int contador = 1;
        if ((getHijoDer()) != null) {
            contador +=  getHijoDer().ObtenerTamanio();
       }
       if ((getHijoIzq()) != null) {
            contador +=  getHijoIzq().ObtenerTamanio();
       }
       return contador;
    }
    public T ObtenerClaveMenor() {
        if(hijoIzq != null){
            return   (T) hijoIzq.ObtenerClaveMenor();
        }
        else{
            return (T) datos;
        }
    }

    public T ObtenerClaveMayor() {
        if(hijoDer != null){
            return   (T) hijoDer.ObtenerClaveMayor();
        }
        else{
            return (T) datos;
        }
        }
    

   
    @SuppressWarnings("unchecked")
    public Comparable ObtenerSiguienteClave(Comparable etiquetaNoActual) {
        int comparacion = etiqueta.compareTo(etiquetaNoActual);
       if( hijoIzq != null && comparacion > 0){
        if (hijoIzq.getEtiqueta().compareTo(etiquetaNoActual) == 0) {
            return etiqueta;
        }
        else{
            return hijoIzq.ObtenerSiguienteClave(etiquetaNoActual);
        }}
        if( hijoDer != null && comparacion < 0){
        if (hijoDer.getEtiqueta().compareTo(etiquetaNoActual) == 0) {
            return etiqueta;
        }
        else{
            return hijoDer.ObtenerSiguienteClave(etiquetaNoActual);
        }}
       return null;
    }

    public int CantidadNodosNivel(int k) {
       int contador = 0;
       if (k == 0){
        contador ++;
        return contador;
       } 
       if (hijoDer != null) {
            contador = contador + hijoDer.CantidadNodosNivel(k-1);
       }
       if (hijoIzq != null) {
            contador = contador + hijoIzq.CantidadNodosNivel(k-1);
       }
       return contador;
    }

    public LinkedList<TElementoAB> ListarHojas( LinkedList<TElementoAB> lista) {
        if (hijoIzq == null && hijoDer == null){
            TElementoAB nodo = new TElementoAB<T>(etiqueta, datos);
            lista.addLast(nodo);
        }
        if (hijoIzq != null ){
            hijoIzq.ListarHojas(lista);
        }
        if (hijoDer != null ){
            hijoDer.ListarHojas(lista);
        }
        return lista;
    }

    public boolean isABB(int max, int min) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isABB'");
    }

    

}
