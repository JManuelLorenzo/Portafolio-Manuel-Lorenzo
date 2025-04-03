package org.example.ejercicio1;

import javax.management.OperationsException;

public class FactorialNumber { // Preferi utilizar long por su mayor capacidad.
        public static long factorial(long n) {
            if (n < 0){ // Condicion de borde de numero menor que cero, es decir no entero.
                throw new RuntimeException(new IllegalArgumentException("Number less than zero, it is only for integers."));
            }

            long result = 1; // Permite que si se introduce 0 devuelva 1.
            for (long i = 1; i <= n; i++) {

                result = Math.multiplyExact(result, i); // Usando este metodo de la libreria math, detecta overflows.
            }
            return result;
    }

    public static void main(String[] args) {
       System.out.println(FactorialNumber.factorial(-5));
    }
}

