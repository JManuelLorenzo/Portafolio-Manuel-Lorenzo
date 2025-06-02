package Ejercicio4;

public class Invertir {

    public  static int[] operacion(int [] lista, int i, int j ){

        if (i < j) {
            int temp = lista[i];
            lista[i] = lista[j];
            lista[j] = temp;
            return operacion(lista, i + 1, j - 1 );
        }
        else{
            return lista;
        }
      

    }
    public static void imprimir(int [] lista){
        if (lista != null) {
            
        String abc = "";
        for (int i = 0; i < lista.length; i++){
            abc = abc + lista[i];
        }
        System.out.println(abc);}
    }
      // Metodo adicional para imprimir listas.
    public static void main(String[] args) {
        int[] listaEjemplo = {1, 2, 3, 4, 5, 6};
        int[] listaEjemplo2 = null;
        int[] listaEjemplo3 = {1};
        Invertir.imprimir(Invertir.operacion(listaEjemplo, 0, 4));
       int [] listaNull = (Invertir.operacion(listaEjemplo2, 2, 2));
       System.out.println(listaNull);
       Invertir.imprimir(Invertir.operacion(listaEjemplo3, 2, 2));
        Invertir.imprimir(Invertir.operacion(listaEjemplo3, 0, 0));
    }
}
