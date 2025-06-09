package pd7;
import java.util.LinkedList;
import java.util.List;

public class Main {




    public static void main(String[] args) {

        /* -------- 1. Crear el trie -------- */
        TArbolTrieTelefonos trieAbonados = new TArbolTrieTelefonos();

        /* -------- 2. Leer el archivo --------
           - Pon el archivo abonados.txt en la raíz del proyecto,
           - o cambia la ruta aquí si lo tienes en otra carpeta.          */
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("ut5_pd7/src/main/java/pd7/abonados.txt");
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
        String[] lineasCodigo = ManejadorArchivosGenerico.leerArchivo("ut5_pd7/src/main/java/pd7/codigos1.txt");
        String pais = lineasCodigo[0].split(" ")[2];
        String area = lineasCodigo[1].split(" ")[2];
        /* -------- 5. Búsquedas por prefijo -------- */
        System.out.println("\nBúsqueda por prefijos:");
        var test = trieAbonados.buscarTelefonos(pais, area);;
        ManejadorArchivosGenerico.escribirArchivo("ut5_pd7/src/main/java/pd7/salida.txt", lineas);
        }
    
}



