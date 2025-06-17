package pd5.Ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class AplicacionAutoCompletar {
   public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new FileReader("src/main/java/pd5/texto.txt")); 
String str;
LinkedList<String> lista = new LinkedList<>();
TArbolTrie arbolTrie = new TArbolTrie();

while ((str = br.readLine()) != null) {
   String[] palabras = str.split(" ");
   for (String string : palabras) {
      string = string.toLowerCase().replaceAll("[^\\p{L}]", "");
      arbolTrie.insertar(string);
   }
   
}
lista = arbolTrie.predecir("a");
for (String string : lista) {
   System.out.println(string);
}
   }
   
}

