package pd7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import pd7.tdas.ManejadorArchivosGenerico;
import pd7.tdas.TArista;
import pd7.tdas.TGrafoDirigido;
import pd7.tdas.TVertice;
import pd7.tdas.UtilGrafos;

public class Proyecto {

    public static void main(String[] args) throws IOException {
      String[] nodos = ManejadorArchivosGenerico.leerArchivo("pd7/src/main/java/pd7/nodos.txt", true);
      LinkedList<TVertice> vertices = new LinkedList<>();
      for (String str : nodos) {
        vertices.addLast(new TVertice<>(str));
      }
      String[] textoAristas =  ManejadorArchivosGenerico.leerArchivo("pd7/src/main/java/pd7/aristas.txt", true);
      LinkedList<TArista> aristas  = new LinkedList<>();
      for (String str : textoAristas) {
        String[] tempStr = str.split(",");
        aristas.addLast(new TArista(tempStr[0], tempStr[1], Double.parseDouble(tempStr[2])) );
      }
      TGrafoDirigido g = new TGrafoDirigido(vertices, aristas);
      LinkedList<TVertice> temp = g.ordenTopologico();
        g.imprimirListas(temp);
        BufferedWriter bw =  new BufferedWriter(new FileWriter("pd7/src/main/java/pd7/salida.txt"));
      for (int i = 0; i < temp.size(); i++) {
        bw.write(temp.get(i).getEtiqueta().toString());
      }
      bw.close();
    }
}