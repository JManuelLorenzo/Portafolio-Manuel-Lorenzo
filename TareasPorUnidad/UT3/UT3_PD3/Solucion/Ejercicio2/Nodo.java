package Solucion.Ejercicio2;
import Solucion.interfaces.INodo;

public class Nodo<T> implements INodo {
     private final T dato;
    private  Nodo<T>  siguiente;
    private  Comparable etiqueta;
    Nodo(T dato, Comparable etiqueta, Nodo<T> siguiente){
         this.dato =  dato;
         this.etiqueta = etiqueta;
         this.siguiente = siguiente;
    }
    @Override
    public Object getDato() {
        return  dato;
    }

    @Override
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * "engancha" otro nodo a continuacion
     *
     * @param nodo
     */
    @Override
    public void setSiguiente(Nodo nodo) {
        siguiente = nodo;
    }

      @Override
    public void imprimir() {
    System.out.println(dato);
    }

    @Override
    public void imprimirEtiqueta() {
    System.out.println(etiqueta);
    }

    @Override
    public Comparable getEtiqueta() {
        return  etiqueta;
    }
    public void setEtiqueta(Comparable  entrada) {
        etiqueta = entrada;

    }

    @Override
    public int compareTo(Comparable etiqueta) {
        if ((int)this.etiqueta > (int)etiqueta){
            return 1;
        }
        if ((int)this.etiqueta < (int)etiqueta){
            return -1;
        }
        return 0;
    }
}