public class Main {

    public static void main(String[] args) {
        System.out.println("=== PRUEBAS DE UNION ===");
        System.out.println("Caso: Iguales A{1,2} B{1,2}");
        Conjunto a1 = crearConjunto(1, 2);
        Conjunto b1 = crearConjunto(1, 2);
        Conjunto c1 = FusionConjuntos.fusionar(a1, b1);
        c1.imprimir();

        System.out.println("Caso: Diferentes A{1,3,4} B{1,5,6}");
        Conjunto a2 = crearConjunto(1, 3, 4);
        Conjunto b2 = crearConjunto(1, 5, 6);
        Conjunto c2 = FusionConjuntos.fusionar(a2, b2);
        c2.imprimir();

        System.out.println("Caso: Disjuntos A{1} B{2}");
        Conjunto a3 = crearConjunto(1);
        Conjunto b3 = crearConjunto(2);
        Conjunto c3 = FusionConjuntos.fusionar(a3, b3);
        c3.imprimir();

        System.out.println("\n=== PRUEBAS DE INTERSECCIÓN ===");
        System.out.println("Caso: Igual tamaño A{1,3,5} B{3,5,7}");
        Conjunto a4 = crearConjunto(1, 3, 5);
        Conjunto b4 = crearConjunto(3, 5, 7);
        Conjunto c4 = InterseccionConjuntos.interseccion(a4, b4);
        c4.imprimir();

        System.out.println("Caso: Diferente tamaño A{1,3} B{3,5,7,9}");
        Conjunto a5 = crearConjunto(1, 3);
        Conjunto b5 = crearConjunto(3, 5, 7, 9);
        Conjunto c5 = InterseccionConjuntos.interseccion(a5, b5);
        c5.imprimir();

        System.out.println("Caso: Valores lejanos A{1,2,3} B{5,12}");
        Conjunto a6 = crearConjunto(1, 2, 3);
        Conjunto b6 = crearConjunto(5, 12);
        Conjunto c6 = InterseccionConjuntos.interseccion(a6, b6);
        c6.imprimir();

        System.out.println("Caso: Valores lejanos pero algunos se repiten A{1,2,3} B{5,2,12,45,3}");
        Conjunto a7 = crearConjunto(1, 2, 3);
        Conjunto b7 = crearConjunto(5, 2, 12, 45, 3);
        Conjunto c7 = InterseccionConjuntos.interseccion(a7, b7);
        c7.imprimir();
    }

    // Función auxiliar para crear conjuntos fácilmente
    public static Conjunto crearConjunto(int... elementos) {
        Conjunto conjunto = new Conjunto();
        // Insertamos en orden inverso para simular que la lista está ordenada al insertar por cabeza
        for (int i = elementos.length - 1; i >= 0; i--) {
            conjunto.insertar(elementos[i]);
        }
        return conjunto;
    }
}