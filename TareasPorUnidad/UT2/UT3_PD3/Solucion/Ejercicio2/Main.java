package Solucion.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();

        System.out.println("¿La lista está vacía?: " + lista.esVacia());

        // Insertar nodos
        Nodo nodo1 = new Nodo<>("Montevideo", 1, null);
        Nodo nodo2 = new Nodo<>("Buenos Aires", 2, null);
        Nodo nodo3 = new Nodo<>("Santiago", 3, null);

        lista.insertar(nodo1);
        lista.insertar(nodo2);
        lista.insertar(nodo3);

        System.out.println("Luego de insertar 3 nodos:");
        lista.imprimir();

        // Insertar con etiqueta y dato en orden
        lista.insertar(2, "Asunción");
        System.out.println("Luego de insertar Asunción (etiqueta 2.5):");
        lista.imprimir();

        // Buscar nodo
        System.out.println("Buscar etiqueta 2: " + (lista.buscar(2) != null ? "Encontrado" : "No encontrado"));
        System.out.println("Buscar etiqueta 99: " + (lista.buscar(99) != null ? "Encontrado" : "No encontrado"));

        // Eliminar nodo
        System.out.println("Eliminar etiqueta 2: " + (lista.eliminar(2) ? "Eliminado" : "No encontrado"));
        lista.imprimir();

        // Cantidad de elementos
        System.out.println("Cantidad de elementos: " + lista.cantElementos());

        // Imprimir con separador
        System.out.println("Lista con separador: " + lista.imprimir(" | "));

        // Insertar al principio con setPrimero
        Nodo nodo0 = new Nodo<>("Lima", 0, null);
        lista.setPrimero(nodo0);
        System.out.println("Después de usar setPrimero con 'Lima':");
        lista.imprimir();
    }
}
