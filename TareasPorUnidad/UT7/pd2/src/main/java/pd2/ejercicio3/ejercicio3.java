package pd2.ejercicio3;

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

public class ejercicio3 {
     public static void main(String[] args) throws IOException {
   TGrafoDirigido a = UtilGrafos.cargarGrafo("pd2/src/main/java/pd2/ejercicio3/nodos.txt", "pd2/src/aristas.txt", false, TGrafoDirigido.class);
    System.out.println(a.obtenerExcentricidad("Colonia"));  
    System.out.println(a.centroDelGrafo());
      

    
   } 
}
