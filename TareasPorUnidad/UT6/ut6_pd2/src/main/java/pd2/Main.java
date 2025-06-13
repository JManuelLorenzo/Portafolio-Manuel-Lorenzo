package pd2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

import pd2.Ejercicio3.THash;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] listaLoadfactor = {70, 75, 80, 85, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
        
        for (int i : listaLoadfactor) {
            int loadFactor = i; // test simplemente para un valor inicial.
        // esto deberia actualizarse con varios while o formas diferentes.O utilizando un for each.
        BufferedReader br = new BufferedReader(new FileReader("ut6_pd2/src/main/java/pd2/claves_insertar.txt"));
        ArrayList<Integer> al  = new ArrayList<>(); // Se que no es la mejor forma de manera eficiente pero como es simplemente un checkeo, no es relevante.
        String texto;
        int comparacionesInserciones = 0; // Se debe dividir por la longitud total de la ArrayList.
        int comparacionesExitosas = 0;
        int comparacionesFallidas = 0;
        int busquedaExitosa = 0;
        int busquedaFallia = 0;
        while((texto = br.readLine()) != null){
            al.add(Integer.parseInt(texto));
        }
        br.close();
        
        
        THash th = new THash(al.size(), loadFactor);
        for (Integer entero : al) {
           comparacionesInserciones += th.insertar(entero);
        }
        int tamanoInsertado = al.size();

        br = new BufferedReader(new FileReader("ut6_pd2/src/main/java/pd2/claves_buscar.txt"));
        al  = new ArrayList<Integer>(); // Se que no es la mejor forma de manera eficiente pero como es simplemente un checkeo, no es relevante.
        String textoDos;
         while((textoDos = br.readLine()) != null){
            int valueParsed = Integer.parseInt(textoDos);
            al.add(valueParsed);
        }
        br.close();
        for (Integer integer : al) {
    int resultado = th.buscar(integer);
    if (resultado > 0) {
        busquedaExitosa ++;
        comparacionesExitosas += resultado; 
    } else {
        busquedaFallia++;
        comparacionesFallidas += - resultado;
}
}

        

   
    System.out.println("Factor de carga: " + loadFactor);
    System.out.printf("Promedio de comparaciones por inserción:  %.16f\n", comparacionesInserciones / (double) tamanoInsertado);
System.out.printf("Promedio de búsquedas exitosas: %.16f\n", (double) comparacionesExitosas / busquedaExitosa);
System.out.printf("Promedio de búsquedas fallidas: %.16f\n", (double) comparacionesFallidas / busquedaFallia);

    
    }
        

    }}