
package pd3.ejercicio3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


/*
Escribe  un  programa  que  lea  cadenas  de  caracteres  de  entrada  y  las  imprima  ordenadas  según  su  longitud, 
comenzando  por  la  más  corta.  Si  hay  varias  cadenas  con  la  misma  longitud,  éstas  deben  imprimirse  en  orden 
lexicográfico.
 */ 

 // Creo que la solucion es un diccionario de int y AVL? Creando un comparable maybe?
public class Ejercicio3 {
    public static void main(String[] args) {
        
    
   TreeMap<String, Integer> stringMap = new TreeMap<>();
   TreeMap<Integer,String> integerMap = new TreeMap<>();
    boolean flag = true;
    Scanner scanner = new Scanner(System.in);
    while (flag) {
        String palabraPorInsertar = scanner.nextLine();
        if (palabraPorInsertar.equals("-")) {
            flag = false;
            break;
        }
        stringMap.put(palabraPorInsertar, palabraPorInsertar.length());
    }


   
   /// Insertar las palabras en el string map en base a la cantidad de length que tenga cada uno.
   
   // El iterator usa el comparator, por String.
   Set<Entry<String,Integer>>setString = stringMap.entrySet();
   Iterator<Entry<String,Integer>> iteradorString  = setString.iterator();
   while(iteradorString.hasNext()){
       Entry<String, Integer> entrada  = iteradorString.next();
       String str = entrada.getKey();
       Integer num  = entrada.getValue();
       if (integerMap.containsKey(num)) { // En el caso de que esta dentro del otro diccionario.
        String temp = integerMap.get(num) + "\n" + str;
        integerMap.put(num, temp);
       }
       else{
        integerMap.put(num, str); // Sino esta lo ponemos dentro.
       }
   }
   Set<Entry<Integer, String>>setInteger = integerMap.entrySet();
   Iterator<Entry<Integer, String>> iteradorNum  = setInteger.iterator();
   while (iteradorNum.hasNext()) {
    System.out.println(iteradorNum.next().getValue());
   }
}
 
}
