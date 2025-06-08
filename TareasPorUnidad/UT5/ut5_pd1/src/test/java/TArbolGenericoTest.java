import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pd1.TArbolGenerico;
import pd1.TNodoGenerico;

import static org.junit.jupiter.api.Assertions.*;

public class TArbolGenericoTest {

    private TArbolGenerico<String> arbol;

    @BeforeEach
    public void setUp() {
        arbol = new TArbolGenerico<>();
    }

    @Test
    public void testInsertarRaiz() {
        assertTrue(arbol.insertar("RECTORIA", ""));
        assertEquals("RECTORIA", arbol.getRaiz().getEtiqueta());
    }

    @Test
    public void testInsertarNuevaRaizEnArbolNoVacio() {
        arbol.insertar("RECTORIA", "");
        assertFalse(arbol.insertar("NUEVA_RAIZ", ""));
    }

    @Test
    public void testInsertarConEtiquetaNula() {
        assertFalse(arbol.insertar(null, ""));
    }

    @Test
    public void testInsertarConPadreNoExistente() {
        arbol.insertar("RECTORIA", "");
        assertFalse(arbol.insertar("FACULTAD", "NO_EXISTE"));
    }

    @Test
    public void testInsertarHijoCorrectamente() {
        arbol.insertar("RECTORIA", "");
        assertTrue(arbol.insertar("FACULTAD", "RECTORIA"));
        TNodoGenerico<String> hijo = arbol.getRaiz().getPrimerHijo();
        assertEquals("FACULTAD", hijo.getEtiqueta());
    }

    @Test
    public void testBuscarRaiz() {
        arbol.insertar("RECTORIA", "");
        assertNotNull(arbol.buscar("RECTORIA"));
    }

    @Test
    public void testBuscarNodoEnProfundidad() {
        arbol.insertar("RECTORIA", "");
        arbol.insertar("FACULTAD", "RECTORIA");
        arbol.insertar("DEPARTAMENTO", "FACULTAD");
        assertNotNull(arbol.buscar("DEPARTAMENTO"));
    }

    @Test
    public void testBuscarEtiquetaNoExistente() {
        arbol.insertar("RECTORIA", "");
        assertNull(arbol.buscar("INEXISTENTE"));
    }

    @Test
    public void testBuscarEtiquetaNula() {
        arbol.insertar("RECTORIA", "");
        assertNull(arbol.buscar(null));
    }

    @Test
    public void testListarIndentadoArbolVacio() {
        assertEquals("", arbol.listarIndentado());
    }

    @Test
    public void testListarIndentadoUnSoloNodo() {
        arbol.insertar("RECTORIA", "");
        String esperado = "RECTORIA\n";
        assertEquals(esperado, arbol.listarIndentado());
    }

    @Test
    public void testListarIndentadoConHijos() {
        arbol.insertar("RECTORIA", "");
        arbol.insertar("FACULTAD", "RECTORIA");
        arbol.insertar("DEPARTAMENTO", "FACULTAD");

        String esperado = "RECTORIA\n  FACULTAD\n    DEPARTAMENTO\n";
        assertEquals(esperado, arbol.listarIndentado());
    }
}
