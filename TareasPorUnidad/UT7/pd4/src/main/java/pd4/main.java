package pd4;

import pd4.tdas.TCamino;
import pd4.tdas.UtilGrafos;

/**
 * Hello world!
 *
 */
public class main 
{
    public static void main( String[] args )
    {
        pd4.tdas.TGrafoDirigido a = UtilGrafos.cargarGrafo("pd4/src/main/java/pd4/tdas/textos/aeropuertos.txt", "pd4/src/main/java/pd4/tdas/textos/conexiones.txt", false, pd4.tdas.TGrafoDirigido.class);
        for(TCamino camino : a.todosLosCaminos("Montevideo", "Curitiba").getCaminos()){
            System.out.println("Un camino es: " + camino.imprimirEtiquetas() + " " + camino.getCostoTotal());
        }
    }
}
