package src;

public interface INodo<T> {

    
    /**
     * devuelve el dato del nodo
     * @return 
     */
    T getDato();
    
    /**
     * devuelve el siguiente del nodo
     * @return 
     */
    Nodo<T> getSiguiente();
    
    
    /**
     * "engancha" otro nodo a continuacion
     * 
     */
    void setSiguiente(Nodo<T> nodo);
    
    /**
     * Imprime los datos del nodo
     */


    void imprimir();

    /**
     * Imprime la etiqueta del nodo
     */

    void imprimirEtiqueta();

    
    /**
     * Retorna la etiqueta del nodo
     *
     * @return etiqueta del nodo
     */
    Comparable getEtiqueta();
//	/**
//	 *
//	 * @param unNodo
//	 * @return devueve -1 si this tiene una clave menor, 0 si son iguales, 1 si es mayor
//	 */
//	public int compareTo(INodo<E> unNodo);

    /**
     *
     * @param etiqueta
     * @return devueve -1 si this tiene una etiqueta menor, 0 si son iguales, 1
     * si es mayor
     */
    int compareTo(Comparable etiqueta);
}
