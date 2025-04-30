public class Main {

    public static void main(String[] args) {
        IConjunto<Integer> conjunto1 = new Conjunto<>();
        IConjunto<Integer> conjunto2 = new Conjunto<>();

        conjunto1.agregar(1);
        conjunto1.agregar(2);
        conjunto1.agregar(3);

        conjunto2.agregar(2);
        conjunto2.agregar(3);
        conjunto2.agregar(4);

        IConjunto<Integer> union = conjunto1.union(conjunto2);
        IConjunto<Integer> interseccion = conjunto1.interseccion(conjunto2);

        System.out.println("Union:");
        for (int i = 0; i < union.tamanio(); i++) {
            System.out.print(union.obtener(i) + " ");
        }

        System.out.println("\nInterseccion:");
        for (int i = 0; i < interseccion.tamanio(); i++) {
            System.out.print(interseccion.obtener(i) + " ");
        }
    }
}