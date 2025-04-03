package TA2;

public class UtilMath {
    public static long factorial(long n) {
        if (n < 0) { // Condicion de borde de numero menor que cero, es decir no entero.
            throw new RuntimeException(new IllegalArgumentException("Number less than zero, it is only for integers."));
        }

        long result = 1; // Permite que si se introduce 0 devuelva 1.
        for (long i = 1; i <= n; i++) {

            result = Math.multiplyExact(result, i); // Usando este metodo de la libreria math, detecta overflows.
        }
        return result;
    }



    public static int Counter(long n) {
        class Primo {
            public static boolean isPrime(long n) {
                boolean prime = true;
                for (long i = 3; i <= Math.sqrt(n); i += 2)
                    if (n % i == 0) {
                        prime = false;
                        break;
                    }
                return (n % 2 != 0 && prime && n > 2) || n == 2;
            }
        }
        int count = 0;
        int suma = 0;

        boolean flag = Primo.isPrime(n);
        if (flag) {
            System.out.println("El numero es primo");
        } else {
            System.out.println("El numero no es primo");
        }
        while (count < n) {
            count++;
            if (count % 2 == 0 && flag) {
                suma += count;
            }
            if (count % 2 != 0 && !flag) {
                suma += count;
            }
        }
        return suma;
    }

    public static void main(String[] args) {
       System.out.println(UtilMath.Counter(12));
    }
}
