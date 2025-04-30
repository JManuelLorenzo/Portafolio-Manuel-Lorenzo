
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

    // Buscar si ya existe un dato
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

    // Insertar solo si no existe
    public void insertar(int dato) {
        if (!contiene(dato)) {
            Nodo nuevo = new Nodo(dato);
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        }
    }

    // Obtener cantidad de elementos
    public int contar() {
        int contador = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    // Mostrar conjunto
    public void imprimir() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}

public class FusionConjuntos {

    public static Conjunto fusionar(Conjunto conjuntoA, Conjunto conjuntoB) {
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

        while (nodoMenor != null && nodoMayor != null) {
            if (nodoMayor.dato == nodoMenor.dato) {
                if (!conjuntoC.contiene(nodoMayor.dato)) {
                    conjuntoC.insertar(nodoMayor.dato);
                }
            } else if (nodoMayor.dato > nodoMenor.dato) {
                if (!conjuntoC.contiene(nodoMenor.dato)) {
                    conjuntoC.insertar(nodoMenor.dato);
                }
                if (!conjuntoC.contiene(nodoMayor.dato)) {
                    conjuntoC.insertar(nodoMayor.dato);
                }
            } else {
                if (!conjuntoC.contiene(nodoMayor.dato)) {
                    conjuntoC.insertar(nodoMayor.dato);
                }
                if (!conjuntoC.contiene(nodoMenor.dato)) {
                    conjuntoC.insertar(nodoMenor.dato);
                }
            }

            nodoMayor = nodoMayor.siguiente;
            nodoMenor = nodoMenor.siguiente;
        }

        while (nodoMayor != null) {
            if (!conjuntoC.contiene(nodoMayor.dato)) {
                conjuntoC.insertar(nodoMayor.dato);
            }
            nodoMayor = nodoMayor.siguiente;
        }

        return conjuntoC;
    }

    public static void main(String[] args) {
        Conjunto conjuntoA = new Conjunto();
        conjuntoA.insertar(5);
        conjuntoA.insertar(3);
        conjuntoA.insertar(1);

        Conjunto conjuntoB = new Conjunto();
        conjuntoB.insertar(6);
        conjuntoB.insertar(3);
        conjuntoB.insertar(2);

        Conjunto conjuntoC = fusionar(conjuntoA, conjuntoB);
        System.out.print("Resultado conjuntoC: ");
        conjuntoC.imprimir();
    }
}
