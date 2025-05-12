package com.example;


 
    
    public interface IElementoAB<T> {

        /**
         * Obtiene el valor de la etiqueta del nodo.
         *
         * @return Etiqueta del nodo.
         */
        public Comparable getEtiqueta();

        /**
         * Obtiene el hijo izquierdo del nodo.
         *
         * @return Hijo Izquierdo del nodo.
         */
        public TElementoAB<T> getHijoIzq();

        /**
         * Obtiene el hijo derecho del nodo.
         *
         * @return Hijo derecho del nodo.
         */
        public TElementoAB<T> getHijoDer();

        /**
         * Asigna el hijo izquierdo del nodo.
         *
         * @return Elemento a ser asignado como hijo izquierdo.
         */
        public void setHijoIzq(TElementoAB<T> elemento);

        /**
         * Asigna el hijo derecho del nodo.
         *
         * @return Elemento a ser asignado como hijo derecho.
         */
        public void setHijoDer(TElementoAB<T> elemento);

        /**
         * Busca un elemento dentro del arbol con la etiqueta indicada.
         *
         * @param unaEtiqueta del nodo a buscar
         * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
         */
        public TElementoAB<T> buscar(Comparable unaEtiqueta);

    

        /**
         * Inserta un elemento dentro del arbol.
         *
         * @param elemento Elemento a insertar.
         * @return Exito de la operaci�n.
         */
        public boolean insertar(TElementoAB<T> elemento);

        /**
         * Imprime en preorden el arbol separado por guiones.
         *
         * @return String conteniendo el PreOrden
         */
        public String preOrden();

        /**
         * Imprime en inorden el arbol separado por guiones.
         *
         * @return String conteniendo el InOrden
         */
        public String inOrden();

        /**
         * Imprime en postorden el arbol separado por guiones.
         *
         * @return String conteniendo el PostOrden
         */
        public String postOrden();

        /**
         * Retorna los datos contenidos en el elemento.
         *
         * @return
         */
        public T getDatos();
        
        /**
         * Elimina un elemento dada una etiqueta.
         * @param unaEtiqueta
         * @return 
         */
        public TElementoAB eliminar(Comparable unaEtiqueta);
        
        /**
         * Devuelve la altura del árbol.
         *
         * @return altura del árbol.
         */
        public int obtenerAltura();
        
        /**
         * Devuelve el Tamaño del árbol.
         *
         * @return El Tamaño del árbol.
         */
        public int ObtenerTamanio();

        public T ObtenerClaveMenor();

        public T ObtenerClaveMayor();

        public int ObtenerSiguienteClave(T dato);

        public int CantidadNodosNivel(int k);

        public String ListarHojas();

        public boolean isABB(int max, int min);


    }
