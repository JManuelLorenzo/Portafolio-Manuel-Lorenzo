package Ejercicio2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Desarrolla un programa JAVA que implemente el ejercicio 1, usando un contador para contar 
cuántas veces se va a invocar la sentencia “si”) 
Leer de un archivo “numeros.txt” (adjunto) cuya primera línea será la cantidad de números a 
leer (sea “N”) y las siguientes N líneas contendrán los elementos de entrada del algoritmo, uno 
por cada línea. 
Mostrar por consola el largo N, el contenido del contador, y los números que quedaron en la 
primera y en la última posición del arreglo.
 */
public class ejercicio2 {
    
    public static int[] miFuncion() throws NumberFormatException, IOException{
       BufferedReader br =  new BufferedReader(new FileReader("UT2_PD1/numeros.txt"));
       int N = Integer.parseInt(br.readLine()) - 1;
       int [] container = new int[N + 1];
       int counterArray = 0;
       for(String line = br.readLine(); line != null; line = br.readLine()){
        container[counterArray] = Integer.parseInt(line);
        counterArray++;
       }
      
       
     
        int counter = 0;
        System.out.println("la longitud inicial es: " + container.length );
        for(int i = 1; i < N-1; i ++){
          
            for(int j = N; j >= i; j-- ){ // Adapte el código porque no estaba tomado en cuenta que arranca desde 0 el indice, lo que hacia que se rompiera el codigo.
                // Sino el bubble sort no se cumplia. 
                counter++;
                if( container[j] < container[j-1]){
                    int temp = container [j];
                    container[j] = container [j-1];
                    container[j-1] = temp;
                }
            }
        }
        System.out.println("La cantidad del contador es " + counter);
        System.out.println("El primer elemento es " + container[0]);
        System.out.println("El ultimo elemento es " +  container[N]);
        return container;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
    int [] array = miFuncion();
    for (int i = 0; i < array.length; i++) {
   //     System.out.println(array[i]);
    }
    }
}