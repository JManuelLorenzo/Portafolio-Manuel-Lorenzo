package Ejercicio1;


public class Factorial {
   public static int operacion(int k ){
    if  (k == 0) {
        return k+1;
    }
    if ( k > 0) {
        return k * operacion(k - 1);
    }
    else{
        return 0;
    }
    
   } 
}
