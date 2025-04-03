import java.util.Arrays;
/*
* Se me ocurrio la idea de resolverlo a través de la implementacion de una string con un split y además de esto
* utilizar una terna para agilizar las comparaciones, además de recorrer las Strings[] con un bucle for anidado,
* debe haber una forma más eficiente, estuve pensandole y no llegue a nada a que me permitiera afirmar algo asi pero
* tengo mis dudas sobre esa parte. La parte C no la pude hacer, porque no tengo un archivo de texto de entrada.
* */
public class ContadorDePalabras { // Decidi hacerlo en una clase sin metodos para trabajar más claro

    String[] palabrasComunes(String[] palabras1, String[] palabras2){
      String[] mayor = palabras1.length >= palabras2.length ? palabras1 : palabras2;
      String[] menor = mayor == palabras1 ? palabras2 : palabras1;
      String temp = "";


      for (int i = 0; i < mayor.length;i++){
          for (int j = 0; j < menor.length; j++){
              if (mayor[i] == menor[j]){
                temp += mayor[i] + " ";
              }


          }
      }

      String[] resultado = temp.split(" ");


      return  resultado;
    }

    public static void main(String[] args) {
       String[] Ar1={"Hola", "mundo", "de", "los", "algoritmos"};
        String[] Ar2={"Hola", "mundo", "de", "la", "informatica"};
        ContadorDePalabras contadorDePalabras = new ContadorDePalabras();
        System.out.print(Arrays.toString(contadorDePalabras.palabrasComunes(Ar1,Ar2))  + "\n");
        System.out.println("Siguiente:");
        System.out.print(Arrays.toString(contadorDePalabras.palabrasComunes(Ar2,Ar1)));
    }
}

