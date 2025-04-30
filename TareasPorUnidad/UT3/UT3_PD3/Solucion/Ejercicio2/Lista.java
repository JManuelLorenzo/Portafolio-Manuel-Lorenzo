package Solucion.Ejercicio2;
import Solucion.interfaces.ILista;
import Solucion.interfaces.INodo;

public class Lista implements ILista {
    Nodo cabeza = null;
    /**
     * Metodo encargado de agregar un nodo al final de la lista.
     *
     * @param nodo - Nodo a agregar
     */
    @Override
    public void insertar(Nodo nodo) {
        if (cabeza == null){
            cabeza = nodo;
            return;
        }
        Nodo temp = cabeza;
        while (temp.getSiguiente() != null) {
            temp = temp.getSiguiente();
        }
        temp.setSiguiente(nodo);
    }

    @Override
    //Se Asume que siempre va a ser interger porque los nodos tienen etiqueta entero.
    public void insertar(Comparable etiqueta, Object dato) {
        Nodo temp = cabeza;
        Comparable valueOfNext = temp.getSiguiente().getEtiqueta();
        while (valueOfNext.compareTo(etiqueta) < 1 ){
                temp = temp.getSiguiente();
                valueOfNext = temp.getSiguiente().getEtiqueta();

        }
        if (valueOfNext.compareTo(etiqueta) == 1){
            Nodo temporal = temp.getSiguiente();
            temp.setSiguiente(new Nodo<>(dato,etiqueta,temporal));
            while (temp.getSiguiente() != null ){
                temp = temp.getSiguiente();
                temp.setEtiqueta((int)temp.getEtiqueta()+1);
            }

        }
        if (valueOfNext.compareTo(etiqueta) > 1){
        Nodo temporal = temp.getSiguiente();
        temp.setSiguiente(new Nodo(dato,etiqueta,temporal));
        }

    }

    /**
     * Metodo encargado de buscar un nodo cuya clave es la indicada.
     *
     * @param clave - Clave del nodo a buscar.
     * @return El nodo encontrado. En caso de no encontrarlo, retornar null.
     */
    @Override
    public Nodo buscar(Comparable clave) {
        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.getEtiqueta() == clave) {
                return temp;
            }
            temp = temp.getSiguiente();
        }
        return null;
    }

    /**
     * Metodo encargado de eliminar un nodo cuya clave es la indicada.
     *
     * @param clave Clave del nodo a eliminar.
     * @return True en caso de que la eliminaci�n haya sido efectuada con �xito.
     */
    @Override
    public boolean eliminar(Comparable clave) {
        if(cabeza.getEtiqueta() == clave){
            cabeza = cabeza.getSiguiente();
            return true;
        }
        Nodo temp = cabeza;

       while (temp != null && temp.getSiguiente() != null){
           if (temp.getSiguiente().getEtiqueta() == clave) {
           temp.setSiguiente(temp.getSiguiente().getSiguiente());
           }
           temp = temp.getSiguiente();
           return true;

       }
        return false;
    }

    /**
     * Metodo encargado de imprimir en consola las claves de los nodos
     * contenidos en la lista.
     *
     * @return
     */
    @Override
    public String imprimir() {
        String str = " ";
        Nodo temp = cabeza;
        while(temp != null){
            str = str + temp.getDato() + " ";
            temp = temp.getSiguiente();
        }
        System.out.println(str);
        return str;
    }

    /**
     * Retorna un String con las claves separadas por el separador pasado por
     * par�metro.
     *
     * @param separador Separa las claves
     * @return
     */
    @Override
    public String imprimir(String separador) {
       String str = separador;
        Nodo temp = cabeza;
        while(temp != null) {
            str = str + temp.getDato() + separador;
            temp = temp.getSiguiente();

        }
        return str;
    }

    /**
     * Retorna la cantidad de elementos de la lista. En caso de que la lista
     * este vac�a, retornar 0.
     *
     * @return Cantidad de elementos de la lista.
     */
    @Override
    public int cantElementos() {
        Nodo temp = cabeza;
        int counter = 0;
        while (temp != null){
           temp = temp.getSiguiente();
            counter++;
        }
        return counter;
    }

    /**
     * Indica si la lista contiene o no elementos.
     *
     * @return Si tiene elementos o no.
     */
    @Override
    public boolean esVacia() {
        return cabeza == null;
    }

    @Override
    public void setPrimero(Nodo unNodo) {
    Nodo temp = cabeza.getSiguiente();
    cabeza = unNodo;
    cabeza.setSiguiente(temp);
    }
}
