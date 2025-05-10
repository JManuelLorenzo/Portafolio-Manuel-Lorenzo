package ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.example.TArbolBB;
import com.example.TElementoAB;

public class Ejercicio2 {
    public static  <T> void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new FileReader("clavesPrueba.txt"));
        String linea;
        TArbolBB arbol = new TArbolBB<>();

      
         while (( (linea = br.readLine()) != null && !linea.isEmpty())){
            TElementoAB elemento = new TElementoAB<String>(linea, linea);
            arbol.insertar(elemento);
            System.out.println(linea);
            
            
    
        } 
        br.close();
    
        BufferedWriter wr = new BufferedWriter(new FileWriter("ejercicio2/resultados.txt"));
        wr.write("Pre " + arbol.preOrden());
        wr.newLine();
         wr.write("In " + arbol.inOrden());
        wr.newLine();
         wr.write("Post " + arbol.postOrden());
        wr.newLine();
        wr.close();
}

}