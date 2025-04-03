package org.example;

public class Ejercicio5 {
    public static int recorrer(String cadena) {
    int res = 0;
    for (int i = 1; i <= cadena.length(); i++) { // No toma la primera letra o simbolo.
        if (cadena.charAt(i) != ' ') {
            res++;
        }
    }
    return res;
}

    public static int getValor() {
        int vector[] = { 6, 16, 26, 36, 46, 56, 66, 76 };
        int idx = 7;
        return vector[idx];
    }

    public static char getPrimerCaracter(String palabra) {
         String[] string  = new String[5];
        return (string[1].charAt(1));
    }

    public static String paraAString(int a) {
        return Integer.toString(a);
    }
}

