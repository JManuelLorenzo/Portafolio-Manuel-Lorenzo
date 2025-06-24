package pd3.ejercicio1;

import pd3.tdas.TGrafoDirigido;
import pd3.tdas.UtilGrafos;

public class Ejercicio1 {
   public static void main(String[] args) {
    TGrafoDirigido grafo = UtilGrafos.cargarGrafo("textos/aeropuertos.txt", "textos/conexiones.txt", false, TGrafoDirigido.class);
    UtilGrafos.imprimirMatrizMejorado(grafo.floyd(), grafo.getVertices(), "Floyd");
    System.out.println(grafo.centroDelGrafo());
   } 
}
