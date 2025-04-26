public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    @Override
    public void insertar(Nodo<T> nodo) {
        Nodo<T> nuevo = nodo;
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }

    @Override
    public void insertar(Comparable etiqueta, T dato) {
        Nodo<T> temp = primero;

        if (temp == null || temp.getEtiqueta().compareTo(etiqueta) > 0) {
            Nodo<T> nuevo = new Nodo<>(etiqueta, dato);
            nuevo.setSiguiente(primero);
            primero = nuevo;
            return;
        }

        while (temp.getSiguiente() != null && temp.getSiguiente().getEtiqueta().compareTo(etiqueta) < 0) {
            temp = temp.getSiguiente();
        }

        Nodo<T> nuevo = new Nodo<>(etiqueta, dato);
        nuevo.setSiguiente(temp.getSiguiente());
        temp.setSiguiente(nuevo);
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.getEtiqueta().equals(clave)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (primero == null) {
            return false;
        }
        if (primero.getEtiqueta().equals(clave)) {
            primero = primero.getSiguiente();
            return true;
        }
        Nodo<T> actual = primero;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getEtiqueta().equals(clave)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        Nodo<T> actual = primero;
        String resultado = "";
        while (actual != null) {
            resultado += actual.getEtiqueta()+ " " + actual.getDato() + "\n";
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    @Override
    public String imprimir(String separador) {
        Nodo<T> actual = primero;
        String resultado = "";
        while (actual.getSiguiente() != null) {
            resultado += actual.getEtiqueta() +" es " + actual.getDato() +  separador;
            actual = actual.getSiguiente();
        }
        resultado += actual.getEtiqueta() +" es " + actual.getDato() ;
        actual = actual.getSiguiente();
        return resultado;
    }

    @Override
    public int cantElementos() {
        Nodo<T> actual = primero;
        int contador = 0;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        this.primero = unNodo;
    }
}
