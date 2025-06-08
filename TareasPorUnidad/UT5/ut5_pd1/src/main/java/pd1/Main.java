package pd1;
public class Main {
    public static void main(String[] args) {
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
    System.out.println(arbol.buscar("RECTORÍA"));
    System.out.println(arbol.buscar("FACULTAD DE PSICOLOGÍA"));
    System.out.println(arbol.buscar("DEPARTAMENTO DE MATEMÁTICAS"));

    // Punto 6: búsquedas fallidas
    System.out.println(arbol.buscar("DEPARTAMENTO DE FILOSOFÍA"));
    System.out.println(arbol.buscar("DECANATO DE DERECHO"));

    // Punto 7: listado indentado
    String salida = arbol.listarIndentado();
    System.out.println(salida.contains("RECTORÍA"));
    System.out.println(salida.contains("  VICERRECTORÍA ACADÉMICA"));
    System.out.println(salida.contains("    FACULTAD DE INGENIERÍA Y TECNOLOGÍAS"));
    System.out.println(salida.contains("      DEPARTAMENTO DE MATEMÁTICAS"));

    // Si querés ver el resultado:
    System.out.println(salida);
    }
}