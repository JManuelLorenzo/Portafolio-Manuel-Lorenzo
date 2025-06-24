package pd3.ejercicio2;

import pd3.tdas.TCaminos;
import pd3.tdas.TGrafoDirigido;
import pd3.tdas.UtilGrafos;

/* Ejecutando esta funcionalidad del programa desarrollado, responde (y verifica manualmente!!!!): 
• ¿Existen conexión(es) entre Montevideo y Curitiba? 
• ¿Existen conexión(es) entre Porto Alegre y Santos?  */

public class Ejercicio2 {
   // Para solucionar este problema, voy a implementar TodosLosCaminos con 2 if. Aunque se podria implementar
   // de manera directa en el Metodo de TGrafoDirigido, prefiero evitar modificaciones ahi. 
   public static void main(String[] args) {
    TGrafoDirigido grafo = UtilGrafos.cargarGrafo("textos/aeropuertos.txt", "textos/conexiones.txt", false, TGrafoDirigido.class);
    TCaminos montevideoCuritiba =  grafo.todosLosCaminos("Montevideo", "Curitiba");
    TCaminos portoAlegreSantos =  grafo.todosLosCaminos("Porto_Alegre", "Santos");
    if (montevideoCuritiba.getCaminos().isEmpty()) {
        System.out.println("No hay Caminos desde Montevideo a Curitiba");
    }
    else{
       System.out.println("Hay Caminos desde Montevideo a Curitiba"); 
    }
    if (portoAlegreSantos.getCaminos().isEmpty()) {
        System.out.println("No hay Porto Alegre desde Montevideo a Santos");
    }
    else{
       System.out.println("Hay Caminos desde Porto Alegre a Santos"); 
    }
    
   }

}
