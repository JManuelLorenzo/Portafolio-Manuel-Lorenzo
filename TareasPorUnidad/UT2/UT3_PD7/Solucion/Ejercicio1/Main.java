public class Main {

    static class Nodo {
        int dato;
        Nodo siguiente;

        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    static class ListaEnlazada {
        Nodo cabeza;

        public ListaEnlazada() {
            this.cabeza = null;
        }

        // Inserta al final
        public void insertar(int dato) {
            Nodo nuevo = new Nodo(dato);
            if (cabeza == null) {
                cabeza = nuevo;
            } else {
                Nodo temp = cabeza;
                while (temp.siguiente != null) {
                    temp = temp.siguiente;
                }
                temp.siguiente = nuevo;
            }
        }

        public Nodo getCabeza() {
            return cabeza;
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

    public static ListaEnlazada unirConjuntos(ListaEnlazada conjuntoA, ListaEnlazada conjuntoB) {
        Nodo nodoTemp;
        ListaEnlazada conjuntoC = new ListaEnlazada();

        Nodo nodoMayor = conjuntoA.getCabeza();
        Nodo nodoMenor = conjuntoB.getCabeza();
        Nodo nodoLastAdded = null;

        while (nodoMayor != null && nodoMenor != null) {
            if (nodoMayor.dato == nodoMenor.dato) {
                if (nodoLastAdded == null || nodoMayor.dato != nodoLastAdded.dato) {
                    conjuntoC.insertar(nodoMayor.dato);
                    nodoLastAdded = new Nodo(nodoMayor.dato);
                }
                nodoMayor = nodoMayor.siguiente;
                nodoMenor = nodoMenor.siguiente;
            } else if (nodoMayor.dato > nodoMenor.dato) {
                if (nodoLastAdded == null || nodoMenor.dato != nodoLastAdded.dato) {
                    conjuntoC.insertar(nodoMenor.dato);
                    nodoLastAdded = new Nodo(nodoMenor.dato);
                }
                nodoMenor = nodoMenor.siguiente;
            } else {
                if (nodoLastAdded == null || nodoMayor.dato != nodoLastAdded.dato) {
                    conjuntoC.insertar(nodoMayor.dato);
                    nodoLastAdded = new Nodo(nodoMayor.dato);
                }
                nodoMayor = nodoMayor.siguiente;
            }
        }

        while (nodoMayor != null) {
            if (nodoLastAdded == null || nodoMayor.dato != nodoLastAdded.dato) {
                conjuntoC.insertar(nodoMayor.dato);
                nodoLastAdded = new Nodo(nodoMayor.dato);
            }
            nodoMayor = nodoMayor.siguiente;
        }

        while (nodoMenor != null) {
            if (nodoLastAdded == null || nodoMenor.dato != nodoLastAdded.dato) {
                conjuntoC.insertar(nodoMenor.dato);
                nodoLastAdded = new Nodo(nodoMenor.dato);
            }
            nodoMenor = nodoMenor.siguiente;
        }

        return conjuntoC;
    }

    public static void main(String[] args) {
        // Caso 1: A y B sin elementos repetidos ni comunes
        ListaEnlazada A = new ListaEnlazada();
        A.insertar(1);
        A.insertar(3);
        A.insertar(5);

        ListaEnlazada B = new ListaEnlazada();
        B.insertar(2);
        B.insertar(4);
        B.insertar(6);

        System.out.print("Caso 1: ");
        unirConjuntos(A, B).imprimir(); // Esperado: 1 2 3 4 5 6

        // Caso 2: A y B con algunos elementos en común
        A = new ListaEnlazada();
        A.insertar(1);
        A.insertar(2);
        A.insertar(3);

        B = new ListaEnlazada();
        B.insertar(2);
        B.insertar(3);
        B.insertar(4);

        System.out.print("Caso 2: ");
        unirConjuntos(A, B).imprimir(); // Esperado: 1 2 3 4

        // Caso 3: Uno vacío, otro con elementos
        A = new ListaEnlazada();
        B = new ListaEnlazada();
        B.insertar(10);
        B.insertar(20);
        B.insertar(30);

        System.out.print("Caso 3: ");
        unirConjuntos(A, B).imprimir(); // Esperado: 10 20 30

        // Caso 4: Ambos iguales
        A = new ListaEnlazada();
        B = new ListaEnlazada();
        A.insertar(5);
        A.insertar(6);
        A.insertar(7);
        B.insertar(5);
        B.insertar(6);
        B.insertar(7);

        System.out.print("Caso 4: ");
        unirConjuntos(A, B).imprimir(); // Esperado: 5 6 7

        // Caso 5: Ambos vacíos
        A = new ListaEnlazada();
        B = new ListaEnlazada();
        A.insertar(2);
        A.insertar(1);
        B.insertar(1);
        A.insertar(2);

        System.out.print("Caso 5: ");
        unirConjuntos(A, B).imprimir(); // Esperado: (nada)
    }
}
