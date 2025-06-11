package pd3.ejercicio2;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pd3.ejercicio1.Ejercicio1;

public  class Ejercicio2{
    public static Map<String, String> TomarStringMap(Map<String, String> mapa) throws Exception{
        // Creo otro mapa:
        Map<String, String> mapTemp = new HashMap<String, String>();
        // Crea un set que esta enlazado al Set:
       Set <Map.Entry<String,String>> entry = mapa.entrySet(); 
       Collection<String> lista =  mapa.values();
       Iterator<Map.Entry<String,String>> iterador = entry.iterator();
       while (iterador.hasNext()) {
        Map.Entry<String, String> value = iterador.next();
        mapTemp.put(value.getValue(), value.getKey());
        iterador.remove();
        if (lista.contains(value.getValue())) {
           throw new Exception("Value repetition."); 
        }
        
        if (value.getValue().equals(value.getKey())) {
            throw new Exception("Value and Key are equal");
        } 
       }
       return mapTemp;
    }
    public static void main(String[] args) throws Exception {
        Map<String,String> nMap = new HashMap<>();
         nMap.put("2","3");
         nMap.put("1","5");
         nMap.put("3","6");
         nMap.put("5","12");
         nMap.put("0","13");
         nMap.put("6","2");
         nMap.put("9","4");
        System.out.println(nMap);
        nMap = Ejercicio2.TomarStringMap(nMap);
         System.out.println(nMap);
    }
}
/*
 * Escribe un método que tome como parámetro un Map<String.String> y devuelva un nuevo Map<String.String> en el 
que las claves y los valores estén intercambiados. Genera una excepción si hay valores duplicados en el mapa que se 
pasa como parámetro.
 */
