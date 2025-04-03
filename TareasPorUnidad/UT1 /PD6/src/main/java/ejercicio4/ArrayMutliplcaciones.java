package ejercicio4;
/* La multiplicacion de array solamente es posible cuando se dan ciertas condiciones, estas son
* que los dos vectores tengan la misma cantidad de componentes, es decir la misma cantidad de elementos. */
public class ArrayMutliplcaciones {
    public static int multiplacionArrayEscalar(int[] vectorA, int[] vectorB) {
        int counter = 0;
        if (vectorA.length == vectorB.length) {
            int[] vectorResultado = new int[vectorA.length];
            for (int i = 0; i < vectorA.length; i++) {
                counter += vectorA[i] * vectorB[i];
            }
            return counter;
        }
        else {
            return 0;
        }

    }}
