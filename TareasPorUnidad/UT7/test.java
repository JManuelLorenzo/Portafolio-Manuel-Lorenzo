import tdas.IGrafoDirigido;
import tdas.TGrafoDirigido;
import tdas.UtilGrafos;

public class test {
   public static void main(String[] args) {
TGrafoDirigido grafo = UtilGrafos.cargarGrafo("aeropuertos.txt", "conexiones.txt", false, TGrafoDirigido.class);
   Double[][] floydMatrix = grafo.floyd();
   String[][] predecesores = grafo.predeStrings();
   UtilGrafos.imprimirMatriz(floydMatrix, grafo.getVertices());
   System.out.println(grafo.centroDelGrafo());
   // UtilGrafos.imprimirMatriz(predecesores, grafo.getVertices()); Arreglar esto.

   }
}
