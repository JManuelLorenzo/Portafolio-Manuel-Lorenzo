package Ejercicio2;

class SumaLinea {
  public  static int Operacion(int [] lista, int n){
    if (n == 0) { // Caso base 
        return lista[0];
    }
    else{
        return lista[n] + Operacion(lista, n-1);
    }
  }
  public static void main(String[] args) {
    int[] lista = {4, 3, 6, 2, 5};
    System.out.println(SumaLinea.Operacion(lista, 4));
  }
    /* Respuestas a la Parte 3.
    Si el numero es negativo el programa se rompe y esta bien lo que haga
    puesto que seguira infinitamente ya que nunca llegara a el caso base. 
    Si el Vector esta vacio tambíen se rompera puesto que el programa no espere que llegue eso. 
       */
     
}