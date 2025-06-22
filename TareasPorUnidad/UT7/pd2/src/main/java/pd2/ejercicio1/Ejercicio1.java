
package pd2.ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import pd2.tdas.IAdyacencia;
import pd2.tdas.IArista;
import pd2.tdas.IVertice;
import pd2.tdas.ManejadorArchivosGenerico;
import pd2.tdas.TArista;
import pd2.tdas.TGrafoDirigido;
import pd2.tdas.TVertice;
import pd2.tdas.UtilGrafos;

public class Ejercicio1 {
    /* 
    Una vez completado el código: 
a) Crear una instancia de TGrafoDirigido 
b) Insertar los siguientes vértices: 
Artigas, Canelones, Durazno, Florida, Montevideo, Punta del Este y Rocha. 
c) Insertar las siguientes aristas:  
Artigas,  Rocha,  400; Canelones,  Artigas,  500;  Canelones,  Colonia,  200;  Canelones,  Durazno, 170;  Canelones, 
Punta  del  Este,  90;  Colonia,  Montevideo,  180;  Florida,  Durazno,  60;  Montevideo,  Artigas,  700;  Montevideo, 
Canelones, 30; Montevideo, Punta del Este, 130; Punta del Este, Rocha, 90; Rocha, Montevideo, 270; Florida, 
Durazno, 60 
d) Utilizando la clase provista “UtilGrafos”, a partir de la instancia del Grafo Dirigido creado, producir la matriz 
de adyacencias e imprimirla en pantalla. Verificar que es correcta de acuerdo al Grafo planteado. 
  

    */ 
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


// Utilizando el mapa.
      Integer[][] retorno = new Integer[grafo.getVertices().size()][grafo.getVertices().size()];
      Object[] etiquetas = grafo.getEtiquetasOrdenado();
      for(int i = 0; i < retorno.length; i ++){
        for (int j = 0; j < retorno.length; j++) {
            if (grafo.existeArista((String)etiquetas[i], (String)etiquetas[j])) {
                retorno[i][j] = 1;
            }
            else{
                retorno[i][j] = 0;
            }
        }
      }

     
     
     UtilGrafos.imprimirMatrizMejorado(retorno, grafo.getVertices(), "Adyacencia");

        }
    
}
