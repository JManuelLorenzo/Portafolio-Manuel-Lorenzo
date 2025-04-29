package Ejercicio3;

public class FuncionPotencia {
   public static int Operacion(int a, int b){
    if (b == 0) {
        return 1;
    }
    if (b > 0){
        return a * Operacion(a, b - 1);
    
    }
    else{
        return a * Operacion(a, b + 1);
    }
   }
   public static void main(String[] args) {
    System.out.println(FuncionPotencia.Operacion(0, 4));
   }
   // Respuestas 3:
   // Soporta unicamente Enteros porque lo diseñe con esa precondicion.
   // Funciona de igual forma, porque lo diseñe para que aguantara esa condicion.
}
