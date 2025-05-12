package com.example;

import java.util.LinkedList;

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

   
    public int ObtenerTamanio() {
        if( raiz == null ){
            return 0;
        }
        else{
            return raiz.ObtenerTamanio();
        }
    }

    
    public T ObtenerClaveMenor() {
        if ( raiz == null ){
            return null;
        }
        else{
            return  raiz.ObtenerClaveMenor();
        }
    }

    
    public T ObtenerClaveMayor() {
        if ( raiz == null ){
            return   null;
        }
        else{
            return   raiz.ObtenerClaveMayor();
        }
    }

   
    public Comparable ObtenerSiguienteClave(Comparable unaEtiqueta) {
        if ( raiz == null ){
            return 0;
        }
        else{
            return raiz.ObtenerSiguienteClave(unaEtiqueta);
        }
    }

   
    public int CantidadNodosNivel(int k) {
        if ( raiz == null ){
            return 0;
        }
        else{
            return raiz.CantidadNodosNivel(k);
        }
    }

    
    public LinkedList<TElementoAB> ListarHojas(LinkedList<TElementoAB> lista) {
        if ( raiz == null ){
            return null;
        }
        else{
            return raiz.ListarHojas(lista);
        }
    }

    
    public boolean isABB(int max, int min) {
        if ( raiz == null ){
            return false;
        }
        else{
            return true;
        }
    }

}
