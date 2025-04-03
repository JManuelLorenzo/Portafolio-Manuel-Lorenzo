public class Ejercicio1 {
    public static int enRango (int[] a, int bajo, int alto) {
        int contador = 0; // O(1)
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= bajo && a[i] < alto)//O(1)
                contador++; //O(1) // Dentro del bloque se trata de multilpicar  lo de dentro del for O(n * ( 1 +1 ))

        }
        return contador; // O(1)
    }
    }
