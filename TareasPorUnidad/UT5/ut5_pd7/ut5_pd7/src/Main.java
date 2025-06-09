import java.util.LinkedList;
import java.util.List;

public class Main {




    public static void main(String[] args) {

        /* -------- 1. Crear el trie -------- */
        TArbolTrieTelefonos trieAbonados = new TArbolTrieTelefonos();

        /* -------- 2. Leer el archivo --------
           - Pon el archivo abonados.txt en la raíz del proyecto,
           - o cambia la ruta aquí si lo tienes en otra carpeta.          */
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("codigo y datos pd7/src/abonados.txt");
        System.out.println("Cantidad de líneas leídas: " + lineas.length);

        /* -------- 3. Insertar abonados -------- */
        int insertados = 0;
        for (String linea : lineas) {
            String[] partes = linea.split(",");
            if (partes.length == 2) {
                TAbonado ab = new TAbonado(partes[1].trim(), partes[0].trim());
                trieAbonados.insertar(ab);
                insertados++;
            }
        }
        System.out.println("✔️  Abonados insertados en el trie: " + insertados);

        /* -------- 4. Mostrar todo el contenido -------- */
        LinkedList<TAbonado> todos = trieAbonados.buscarTelefonos("", "");
        System.out.println("\nTOTAL en el trie = " + todos.size());
        for (TAbonado a : todos) {
            System.out.println(a);
        }

        /* -------- 5. Búsquedas por prefijo -------- */
        System.out.println("\nBúsqueda por prefijos:");
        var test = trieAbonados.buscarTelefonos("598", "999");
            for (TAbonado a : test) {
                System.out.println("  " + a);
            }
        }
    
}



