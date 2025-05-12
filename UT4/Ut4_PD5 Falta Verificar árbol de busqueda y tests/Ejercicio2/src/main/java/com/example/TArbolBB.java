package com.example;


public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) { // Enzo
        if (raiz == null) {
            raiz = unElemento;
        } else {
            return raiz.insertar(unElemento);
        }
        return false; // no deberia llegar nunca hasta aqui pero se require un return igualmente.
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) { // Enzo
        if (raiz == null) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    @Override
    public String preOrden() {
        if (raiz == null) {
            return "";
        } else {
            return raiz.preOrden();
        }
    }

    @Override
    public String inOrden() {
        if (raiz == null) {
            return "";
        } else {
            return raiz.inOrden();
        }
    }

    @Override
    public String postOrden() {
        if (raiz == null) {
            return "";
        } else {
            return raiz.postOrden();
        }
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (raiz == null) {

        } else {
            raiz.eliminar(unaEtiqueta);
        }

    }

    @Override
    public int obtenerAltura() {
        if (raiz == null) {
            return 0;
        } else {
           return raiz.obtenerAltura();
        }
    }

    @Override
    public int ObtenerTamanio() {
        if( raiz == null ){
            return 0;
        }
        else{
            return raiz.ObtenerTamanio();
        }
    }

    @Override
    public T ObtenerClaveMenor() {
        if ( raiz == null ){
            return null;
        }
        else{
            return  raiz.ObtenerClaveMenor();
        }
    }

    @Override
    public T ObtenerClaveMayor() {
        if ( raiz == null ){
            return   null;
        }
        else{
            return   raiz.ObtenerClaveMayor();
        }
    }

    @Override
    public int ObtenerSiguienteClave(T dato) {
        if ( raiz == null ){
            return 0;
        }
        else{
            return raiz.ObtenerTamanio();
        }
    }

    @Override
    public int CantidadNodosNivel(int k) {
        if ( raiz == null ){
            return 0;
        }
        else{
            return raiz.ObtenerTamanio();
        }
    }

    @Override
    public String ListarHojas() {
        if ( raiz == null ){
            return null;
        }
        else{
            return null;
        }
    }

    @Override
    public boolean isABB(int max, int min) {
        if ( raiz == null ){
            return false;
        }
        else{
            return true;
        }
    }

}
