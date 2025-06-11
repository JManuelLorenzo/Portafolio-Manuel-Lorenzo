package pd3.ejercicio1;

import java.security.Key;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Ejercicio1 {
   public static <K,V> void elimnarNullOnMap(Map<K,V> map){
      Set<Map.Entry<K,V>> mapset =  map.entrySet();
      Iterator<Map.Entry<K,V>> iterator = mapset.iterator();
      while (iterator.hasNext()) {
         Map.Entry<K,V> value = iterator.next();
         if (value.getValue() == null ) {
            iterator.remove();
         }
      }
   }
   public static void main(String[] args) {
      Map nMap = new HashMap<>();
         nMap.put(2,null);
         nMap.put(1,null);
         nMap.put(3,null);
         nMap.put(5,3);
         nMap.put(0,null);
         nMap.put(6,2);
         nMap.put(9,null);
        System.out.println(nMap);
        Ejercicio1.elimnarNullOnMap(nMap);
         System.out.println(nMap);
      };
   }

