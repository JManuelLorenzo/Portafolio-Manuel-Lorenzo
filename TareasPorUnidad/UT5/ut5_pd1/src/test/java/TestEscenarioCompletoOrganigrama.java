import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pd1.TArbolGenerico;
import pd1.TNodoGenerico;

import static org.junit.jupiter.api.Assertions.*;

public class TestEscenarioCompletoOrganigrama {

    // Aquí se define el test del escenario completo del organigrama.
@Test
public void test() {
    TArbolGenerico<String> arbol = new TArbolGenerico<>();

    // Punto 5: inserciones
    arbol.insertar("RECTORÍA", "");
    arbol.insertar("VICERRECTORÍA ADMINISTRATIVA", "RECTORÍA");
    arbol.insertar("VICERRECTORÍA ACADÉMICA", "RECTORÍA");
    arbol.insertar("VICERRECTORÍA DEL MEDIO UNIVERSITARIO", "RECTORÍA");

    arbol.insertar("FACULTAD DE CIENCIAS HUMANAS", "VICERRECTORÍA ACADÉMICA");
    arbol.insertar("FACULTAD DE CIENCIAS EMPRESARIALES", "VICERRECTORÍA ACADÉMICA");
    arbol.insertar("FACULTAD DE INGENIERÍA Y TECNOLOGÍAS", "VICERRECTORÍA ACADÉMICA");
    arbol.insertar("FACULTAD DE PSICOLOGÍA", "VICERRECTORÍA ACADÉMICA");

    arbol.insertar("DEPARTAMENTO DE INFORMÁTICA Y CIENCIAS DE LA COMPUTACIÓN", "FACULTAD DE INGENIERÍA Y TECNOLOGÍAS");
    arbol.insertar("DEPARTAMENTO DE INGENIERÍA ELÉCTRICA", "FACULTAD DE INGENIERÍA Y TECNOLOGÍAS");
    arbol.insertar("DEPARTAMENTO DE MATEMÁTICAS", "FACULTAD DE INGENIERÍA Y TECNOLOGÍAS");

    // Punto 6: búsquedas exitosas
    assertNotNull(arbol.buscar("RECTORÍA"));
    assertNotNull(arbol.buscar("FACULTAD DE PSICOLOGÍA"));
    assertNotNull(arbol.buscar("DEPARTAMENTO DE MATEMÁTICAS"));

    // Punto 6: búsquedas fallidas
    assertNull(arbol.buscar("DEPARTAMENTO DE FILOSOFÍA"));
    assertNull(arbol.buscar("DECANATO DE DERECHO"));

    // Punto 7: listado indentado
    String salida = arbol.listarIndentado();
    assertTrue(salida.contains("RECTORÍA"));
    assertTrue(salida.contains("  VICERRECTORÍA ACADÉMICA"));
    assertTrue(salida.contains("    FACULTAD DE INGENIERÍA Y TECNOLOGÍAS"));
    assertTrue(salida.contains("      DEPARTAMENTO DE MATEMÁTICAS"));

    // Si querés ver el resultado:
    System.out.println(salida);
}}