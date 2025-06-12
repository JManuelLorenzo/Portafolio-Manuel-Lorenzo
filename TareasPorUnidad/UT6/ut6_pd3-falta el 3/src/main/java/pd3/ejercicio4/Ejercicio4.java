package pd3.ejercicio4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Ejercicio4 {
   /**
 * @param fileR
 * @return int , el tamaño de la lista idealˇ
 * @throws IOException 
 */
public static int auxObtenerSize(String fileR) throws IOException{
    BufferedReader br = new BufferedReader(new FileReader(fileR));
    String linea;
    int totalDeLineas = 0;
    while ((linea = br.readLine()) != null) {
        totalDeLineas ++;
    }
    br.close();
    int promedio = (totalDeLineas ) ; // +1 por si acaso.
    return promedio;
   } 
public static void principal(String direccion,int nLineasPrint) throws IOException{
   int sizeLista = auxObtenerSize(direccion);
   ArrayList<String> lista = new ArrayList<String>(sizeLista); // uso el otro constructor.
    BufferedReader br = new BufferedReader(new FileReader(direccion));
    String linea;
    while ((linea = br.readLine()) != null) {
        lista.add(linea);
    }
    br.close();
    //Creo el random.
   Random random = new Random();
   for (int i = 0; i < nLineasPrint; i++) {
    System.out.print(lista.get((random.nextInt(sizeLista))));
   }  
}
public static void main(String[] args) throws IOException {
   String fileR = args[0];
   int nLineasPrint = Integer.parseInt(args[1]);
   principal(fileR, nLineasPrint);
}
}
