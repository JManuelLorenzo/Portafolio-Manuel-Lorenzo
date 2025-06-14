package ut6_pd4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> hashMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("pd4/src/main/java/ut6_pd4/libro.txt"));
        String texto; 
        while ((texto = br.readLine()) !=  null) {
            String [] palabras = texto.split(" ");
            for (String string : palabras) {
                if (!string.isEmpty()) {
                    
        
                string = string.toLowerCase().replaceAll("[^a-z]", "");
              Integer clave =  hashMap.get(string);
                if (clave == null) {
                hashMap.put(string, 1);
            }
            else{
                // no es necesario eliminar, se sobreescribe.  
                hashMap.put(string, clave + 1);
            }}
            }
        
        }
        br.close();
        Set<Entry<String, Integer>> set = hashMap.entrySet();
        ArrayList<Entry<String,Integer>> arrayList = new ArrayList<>(set);
        arrayList.sort(Map.Entry.<String, Integer> comparingByValue().reversed());
        for (int i = 0; i < 10 && i < arrayList.size(); i++)  { // la comparacion con el size, se da por si hay menos de 10 palabras. 
            System.out.println(arrayList.get(i));
        }
        
    }
}