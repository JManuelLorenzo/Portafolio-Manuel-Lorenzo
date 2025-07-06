package uy.edu.ucu.aed;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TGrafoDirigidoTest {

    TGrafoDirigido grafo;

    @BeforeEach
    public void setUp() {
        List<TVertice> vertices = Arrays.asList(
            new TVertice("A"),
            new TVertice("B"),
            new TVertice("C"),
            new TVertice("D")
        );

        List<TArista> aristas = Arrays.asList(
            new TArista("A", "B", 1),
            new TArista("B", "C", 2),
            new TArista("C", "D", 3),
            new TArista("A", "D", 10)
        );

        grafo = new TGrafoDirigido(vertices, aristas);
    }

    @Test
    public void testFloyd() {
        Double[][] matriz = grafo.floyd();

        // A -> B
        assertEquals(1.0, matriz[0][1]);
        // A -> C = A->B->C = 1+2 = 3
        assertEquals(3.0, matriz[0][2]);
        // A -> D (mejor camino es A->B->C->D = 1+2+3 = 6)
        assertEquals(6.0, matriz[0][3]);
    }

    @Test
    public void testCentroDelGrafo() {
        Comparable centro = grafo.centroDelGrafo();
        assertEquals("C", centro);  
    }

    @Test
    public void testExcentricidad() {
        Comparable excentricidad = grafo.obtenerExcentricidad("A");
        assertEquals(6.0, excentricidad);
    }

    @Test
    public void testWarshall() {
        boolean[][] matriz = grafo.warshall();

        assertTrue(matriz[0][1]); // A -> B
        assertTrue(matriz[0][2]); // A -> C
        assertTrue(matriz[0][3]); // A -> D
        assertFalse(matriz[3][0]); // D -> A (no existe)
    }
}
