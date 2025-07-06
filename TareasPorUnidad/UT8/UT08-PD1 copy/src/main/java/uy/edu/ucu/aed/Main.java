package uy.edu.ucu.aed;

import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        // Crear vértices
        TVertice A = new TVertice("A");
        TVertice B = new TVertice("B");
        TVertice C = new TVertice("C");
        TVertice D = new TVertice("D");

        // Crear aristas (grafo fuertemente conexo)
        TArista AB = new TArista("A", "B", 1);
        TArista AC = new TArista("A", "C", 4);
        TArista AD = new TArista("A", "D", 7);
        TArista BD = new TArista("B", "D", 2);
        TArista CB = new TArista("C", "B", 1);
        TArista CD = new TArista("C", "D", 1);
        TArista DA = new TArista("D", "A", 3);

        Collection<TVertice> vertices = Arrays.asList(A, B, C, D);
        Collection<TArista> aristas = Arrays.asList(AB, AC, AD, BD, CB, CD, DA);
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);

        // Matriz de costos (Floyd)
        Double[][] matrizCostos = grafo.floyd();
        System.out.println("\n--- Matriz de Costos (Floyd) ---");
        UtilGrafos.imprimirMatrizMejorado(matrizCostos, grafo.getVertices(), "Matriz de Costos");

        // Matriz de adyacencias (Warshall)
        boolean[][] warshall = grafo.warshall();
        System.out.println("\n--- Matriz de Adyacencia (Warshall) ---");
        Object[] etiquetas = grafo.getEtiquetasOrdenado();
        System.out.print("   ");
        for (Object et : etiquetas) {
            System.out.print(et + " ");
        }
        System.out.println();
        for (int i = 0; i < warshall.length; i++) {
            System.out.print(etiquetas[i] + ": ");
            for (int j = 0; j < warshall.length; j++) {
                System.out.print(warshall[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }

        System.out.println("\n--- Conectividad Warshall ---");
        for (int i = 0; i < warshall.length; i++) {
            for (int j = 0; j < warshall[i].length; j++) {
                if (!warshall[i][j]) {
                    System.out.println("No hay camino desde " + etiquetas[i] + " hasta " + etiquetas[j]);
                }
            }
        }

        // Todos los caminos entre A y D
        System.out.println("\n--- Caminos de A a D ---");
        TCaminos caminos = grafo.todosLosCaminos("A", "D");
        for (TCamino c : caminos.getCaminos()) {
            System.out.println("→ Origen: " + c.imprimirEtiquetas());
        }

        // Excentricidades
        System.out.println("\n--- Excentricidades ---");
        for (Object et : etiquetas) {
            double exc = grafo.obtenerExcentricidad((Comparable) et);
            System.out.printf("%s: %.1f\n", et, exc);
        }

        // Centro del grafo
        System.out.println("\n--- Centro del Grafo ---");
        System.out.println("Centro: " + grafo.centroDelGrafo());

        // Ciclos
        System.out.println("\n--- Ciclos ---");
        System.out.println("¿Tiene ciclo el grafo?: " + grafo.tieneCiclo());
    }
}
