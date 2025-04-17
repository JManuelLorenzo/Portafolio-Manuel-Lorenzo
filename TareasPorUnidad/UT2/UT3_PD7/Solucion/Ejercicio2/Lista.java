public class Lista<T> implements ILista<T> {

    private class Nodo<T> {

        private final Comparable etiqueta;
        private T dato;
        private Nodo<T> siguiente = null;
    
        public Nodo(Comparable etiqueta, T dato ) {
            this.etiqueta = etiqueta;
            this.dato = dato;
        }
    }

    private Nodo<T> primero;


    public Lista() {
        primero = null;

    }

    @Override
    public void insertar(T dato, Comparable clave) {
        Nodo<T> nuevo = new Nodo<>(clave, dato);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo<T> actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    @Override
    public T buscar(Comparable clave){
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.etiqueta.equals(clave)){
            return actual.dato;
            }
            actual = actual.siguiente;    
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (primero == null) {
            return false;
        }
        if (primero.etiqueta.equals(clave)) {
            primero = primero.siguiente;
            return true;
        }
        Nodo<T> actual = primero;
        while (actual.siguiente != null) {
            if (actual.siguiente.etiqueta.equals(clave)) {
                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    @Override
    public String imprimir() {
        Nodo<T> actual = primero;
        String resultado = "";
        while (actual != null) {
            resultado += actual.dato + "\n";
            actual = actual.siguiente;
        }
        return resultado;
    }

    @Override
    public String imprimir(String separador) {
        Nodo<T> actual = primero;
        String resultado = "";
        while (actual != null) {
            resultado += actual.etiqueta + separador;
            actual = actual.siguiente;
        }
        return resultado;
    }

    @Override
    public int cantElementos() {
        Nodo<T> actual = primero;
        int contador = 0;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }
}
