
class Nodo {

    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

class Conjunto {

    Nodo cabeza;

    public Conjunto() {
        this.cabeza = null;
    }

    public boolean contiene(int clave) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato == clave) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public void insertar(int dato) {
        if (!contiene(dato)) {
            Nodo nuevo = new Nodo(dato);
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        }
    }

    public int contar() {
        int contador = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    public void imprimir() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}

public class InterseccionConjuntos {

    public static Conjunto interseccion(Conjunto conjuntoA, Conjunto conjuntoB) {
        Conjunto conjuntoC = new Conjunto();

        Conjunto conjuntoMayor, conjuntoMenor;
        if (conjuntoA.contar() >= conjuntoB.contar()) {
            conjuntoMayor = conjuntoA;
            conjuntoMenor = conjuntoB;
        } else {
            conjuntoMayor = conjuntoB;
            conjuntoMenor = conjuntoA;
        }

        Nodo nodoMayor = conjuntoMayor.cabeza;
        Nodo nodoMenor = conjuntoMenor.cabeza;

        while (nodoMayor != null && nodoMenor != null) {
            if (nodoMayor.dato == nodoMenor.dato) {
                conjuntoC.insertar(nodoMayor.dato);
                nodoMayor = nodoMayor.siguiente;
                nodoMenor = nodoMenor.siguiente;
            } else if (nodoMayor.dato < nodoMenor.dato) {
                nodoMayor = nodoMayor.siguiente;
            } else {
                nodoMenor = nodoMenor.siguiente;
            }
        }

        return conjuntoC;
    }

    public static void main(String[] args) {
        Conjunto conjuntoA = new Conjunto();
        conjuntoA.insertar(7);
        conjuntoA.insertar(5);
        conjuntoA.insertar(3);
        conjuntoA.insertar(1);

        Conjunto conjuntoB = new Conjunto();
        conjuntoB.insertar(6);
        conjuntoB.insertar(5);
        conjuntoB.insertar(2);
        conjuntoB.insertar(1);

        Conjunto conjuntoC = interseccion(conjuntoA, conjuntoB);
        System.out.print("Intersección conjuntoC: ");
        conjuntoC.imprimir();
    }
}
