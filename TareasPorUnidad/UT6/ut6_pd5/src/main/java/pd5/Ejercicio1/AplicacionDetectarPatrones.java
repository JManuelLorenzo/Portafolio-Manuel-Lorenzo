package pd5.Ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class AplicacionDetectarPatrones {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("ut6_pd5/src/main/java/pd5/texto.txt"));
        String str;
        LinkedList<String> lista = new LinkedList<>();
        TArbolTrie arbolTrie = new TArbolTrie();
        int posGlobal = 0;
        int temp = 0;
        while ((str = br.readLine()) != null) {
            String[] palabras = str.split(" ");

            for (String string : palabras) {
                temp = str.indexOf(string);
                string = string.toLowerCase().replaceAll("[^\\p{L}]", "");
                arbolTrie.insertarPosicion(str, temp + posGlobal);
            }
            posGlobal += temp;
        }
        arbolTrie.imprimir("abuel");
    }

}
