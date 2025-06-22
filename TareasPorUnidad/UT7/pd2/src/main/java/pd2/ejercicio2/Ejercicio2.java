package pd2.ejercicio2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import pd2.tdas.IArista;
import pd2.tdas.IVertice;
import pd2.tdas.TArista;
import pd2.tdas.TGrafoDirigido;
import pd2.tdas.UtilGrafos;

public class Ejercicio2 {
   
      public static void main(String[] args) throws IOException {
        Collection<IVertice> vertices = new ArrayList<>();
         Collection<IArista> aristas = new ArrayList<>();
        TGrafoDirigido grafo = new TGrafoDirigido(vertices,aristas);   
        String[] listaComparables = {"Artigas", "Canelones", "Durazno", "Florida", "Montevideo", "Punta del Este",  "Rocha","Colonia"}; // inserta vertices.
        for (String comparable : listaComparables) {
            grafo.insertarVertice(comparable);
        }
        
        
    BufferedReader br = new BufferedReader(new FileReader("pd2/src/aristas.txt"));
    String str;
      while((str = br.readLine()) != null){
       String[] elementosParaArista = str.trim().split("\\s*,\\s*");
        TArista arista = new TArista(elementosParaArista[0], elementosParaArista[1], Integer.parseInt(elementosParaArista[2]));
        grafo.insertarArista(arista);
      }
      UtilGrafos.imprimirMatriz(grafo.floyd(), grafo.getVertices() );
   } 
}
