

import pd1.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class TNodoTrieTest {

    private TNodoTrie trie;

    @BeforeEach
    public void setUp() {
        trie = new TNodoTrie();
    }

    @Test
    public void testInsertarYBuscar() {
        trie.insertar("hola");
        trie.insertar("holanda");
        trie.insertar("hombre");

        assertEquals(4, trie.buscar("hola"));
        assertEquals(7, trie.buscar("holanda"));
        assertEquals(6, trie.buscar("hombre"));
        assertEquals(0, trie.buscar("honesto")); // palabra no insertada
    }

    @Test
    public void testPredecir() {
        trie.insertar("hola");
        trie.insertar("holanda");
        trie.insertar("hombre");
        trie.insertar("hongo");

        LinkedList<String> resultados = new LinkedList<>();
        trie.predecir("ho", resultados);
        System.out.println(resultados);
        assertTrue(resultados.contains("hola"));
        assertTrue(resultados.contains("holanda"));
        assertTrue(resultados.contains("hombre"));
        assertTrue(resultados.contains("hongo"));
        assertFalse(resultados.contains("honesto")); // no fue insertado
    }
}
