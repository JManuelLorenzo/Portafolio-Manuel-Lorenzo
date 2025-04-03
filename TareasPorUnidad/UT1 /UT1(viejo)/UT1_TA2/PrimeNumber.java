public class PrimeNumber {

    public static boolean isPrime(long n) {
        boolean prime = true;
        for (long i = 3; i <= Math.sqrt(n); i += 2)
            if (n % i == 0) {
                prime = false;
                break;
            }
        if ((n % 2 != 0 && prime && n > 2) || n == 2) {
            return true;
        } else {
            return false;
        }

    }

    public static int Counter(long n) {
        int count = 0;
        int suma = 0;
        boolean flag = isPrime(n);
        while (count < n) {
            count++;
            if (count % 2 == 0 && flag) {
            suma += count;
            if (count % 2 != 0 && flag == false) {
                suma += count;
            }
        }
        }
    return suma;}

    public static void main(String[] args) {
        System.out.println(PrimeNumber.Counter(11));
    }}