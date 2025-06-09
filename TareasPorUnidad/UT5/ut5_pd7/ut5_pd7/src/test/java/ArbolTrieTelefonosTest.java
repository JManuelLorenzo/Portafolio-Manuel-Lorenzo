import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pd7.TAbonado;
import pd7.TArbolTrieTelefonos;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class TArbolTrieTelefonosTest {

    private TArbolTrieTelefonos trie;

    @BeforeEach
    void setUp() {
        trie = new TArbolTrieTelefonos();
    }

    @Test
    void insertarYBuscarUnAbonado() {
        trie.insertar(new TAbonado("Ana", "5981234"));
        LinkedList<TAbonado> resultado = trie.buscarTelefonos("598", "");
        assertEquals(1, resultado.size());
        assertEquals("Ana", resultado.get(0).getNombre());
    }

    @Test
    void insertarMultiplesAbonadosYBuscarTodos() {
        trie.insertar(new TAbonado("Ana", "5981234"));
        trie.insertar(new TAbonado("Bruno", "5985678"));
        trie.insertar(new TAbonado("Carlos", "5989123"));

        LinkedList<TAbonado> resultado = trie.buscarTelefonos("598", "");
        assertEquals(3, resultado.size());
        assertEquals("Ana", resultado.get(0).getNombre());
        assertEquals("Bruno", resultado.get(1).getNombre());
        assertEquals("Carlos", resultado.get(2).getNombre());
    }

    @Test
    void buscarPrefijoInexistenteDevuelveVacio() {
        trie.insertar(new TAbonado("Ana", "5981234"));
        LinkedList<TAbonado> resultado = trie.buscarTelefonos("123", "");
        assertTrue(resultado.isEmpty());
    }

    @Test
    void noSeSobrescribeAbonadoSiNumeroYaExiste() {
        trie.insertar(new TAbonado("Ana", "5981234"));
        trie.insertar(new TAbonado("Reemplazo", "5981234")); // no debería sobrescribir

        LinkedList<TAbonado> resultado = trie.buscarTelefonos("598", "");
        assertEquals(1, resultado.size());
        assertEquals("Ana", resultado.get(0).getNombre());
    }

    @Test
    void ordenAlfabeticoSeMantieneAlInsertar() {
        trie.insertar(new TAbonado("Zoe", "5981000"));
        trie.insertar(new TAbonado("Aaron", "5981001"));
        trie.insertar(new TAbonado("Bruno", "5981002"));

        LinkedList<TAbonado> resultado = trie.buscarTelefonos("598", "");
        assertEquals(3, resultado.size());
        assertEquals("Aaron", resultado.get(0).getNombre());
        assertEquals("Bruno", resultado.get(1).getNombre());
        assertEquals("Zoe", resultado.get(2).getNombre());
    }
}
