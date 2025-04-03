package org.example.ejercicio2;

public class PrimeNumber {
    public static boolean isPrime(long n) {
        boolean prime = true;
        for (long i = 3; i <= Math.sqrt(n); i += 2)
            if (n % i == 0) {
                prime = false;
                break;
            }
        return (n % 2 != 0 && prime && n > 2) || n == 2;
    }

    public static int Counter(long n) {
        int count = 0;
        int suma = 0;
        boolean flag = isPrime(n);
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
        System.out.println(PrimeNumber.Counter(6));
    }
}
