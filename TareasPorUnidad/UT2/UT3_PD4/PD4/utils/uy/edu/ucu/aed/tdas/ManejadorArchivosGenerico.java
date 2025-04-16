package uy.edu.ucu.aed.tdas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que proporciona métodos estáticos para leer y escribir archivos de texto.
 */
public class ManejadorArchivosGenerico {

	/**
	 * Escribe un archivo de texto con las líneas proporcionadas.
	 * Si el archivo ya existe, las nuevas líneas se añadirán al final.
	 *
	 * @param nombreCompletoArchivo El nombre y ruta del archivo a escribir.
	 * @param listaLineasArchivo Un array de strings, cada uno de los cuales se escribirá como una línea en el archivo.
	 * @throws IOException Si ocurre un error de entrada/salida al escribir en el archivo.
	 */
	public static void escribirArchivo(String nombreCompletoArchivo, String[] listaLineasArchivo) {
		FileWriter fw;
		try {
			fw = new FileWriter(nombreCompletoArchivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < listaLineasArchivo.length; i++) {
				String lineaActual = listaLineasArchivo[i];
				bw.write(lineaActual);
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Error al escribir el archivo " + nombreCompletoArchivo);
			e.printStackTrace();
		}
	}

	/**
	 * Lee un archivo de texto y devuelve su contenido como un array de strings.
	 *
	 * @param nombreCompletoArchivo El nombre y ruta del archivo a leer.
	 * @return Un array de strings, cada uno de los cuales contiene una línea del archivo.
	 * @throws FileNotFoundException Si el archivo no se encuentra en la ruta especificada.
	 * @throws IOException Si ocurre un error de entrada/salida al leer el archivo.
	 */
	public static String[] leerArchivo(String nombreCompletoArchivo) {
		FileReader fr;
		ArrayList<String> listaLineasArchivo = new ArrayList<String>();
		try {
			fr = new FileReader(nombreCompletoArchivo);
			BufferedReader br = new BufferedReader(fr);
			String lineaActual = br.readLine();
			while (lineaActual != null) {
				listaLineasArchivo.add(lineaActual);
				lineaActual = br.readLine();
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error al leer el archivo " + nombreCompletoArchivo);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo " + nombreCompletoArchivo);
			e.printStackTrace();
		}
		System.out.println("Archivo leido satisfactoriamente");

		return listaLineasArchivo.toArray(new String[0]);
	}
}