package ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.example.TArbolBB;
import com.example.TElementoAB;

public class Ejercicio3 {
    public static  <T> void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new FileReader("claves1.txt"));
        String linea;
        //Parte A
        TArbolBB arbol = new TArbolBB<>();

      //Parte B
         while (( (linea = br.readLine()) != null && !linea.isEmpty())){
            TElementoAB elemento = new TElementoAB<String>(linea, linea);
            arbol.insertar(elemento);
           
            
            
    
        } 
        br.close();
        
        //Parte C 10635 , 4567, 12, 8978
        arbol.existe("10635");
        arbol.existe("4567");
        arbol.existe("12");
        arbol.existe("8978");

    

        //Parte D para poder ver los valores.
        String abc = arbol.imprimirPreorden();
        String[] nums = abc.split("-");
        System.out.println(nums[9] + " es el decimo elemento");
        //Respuesta en respuestas.txt. por si acaso.
        BufferedWriter wr = new BufferedWriter(new FileWriter("ejercicio3/resultados.txt"));
        wr.write("Pre " + arbol.preOrden());
        wr.newLine();
         wr.write("In " + arbol.inOrden());
        wr.newLine();
         wr.write("Post " + arbol.postOrden());
        wr.newLine();
        wr.close();
}
    
}
