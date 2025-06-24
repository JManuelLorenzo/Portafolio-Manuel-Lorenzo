package pd3.ejercicio3;

import java.lang.management.MonitorInfo;

import pd3.tdas.TCaminos;
import pd3.tdas.TGrafoDirigido;
import pd3.tdas.UtilGrafos;


public class Ejercicio3 {
    public static void main(String[] args) {
    TGrafoDirigido grafo = UtilGrafos.cargarGrafo("textos/aeropuertos.txt", "textos/conexiones.txt", false, TGrafoDirigido.class);
// Parte 1.
System.out.println("---Desde el Grafo: ---");
    grafo.bpf(); 
// Parte 2.
    System.out.println("--- Desde  Montevideo: ---");
    grafo.bpf("Montevideo");
// Parte 3:
System.out.println("--- Desde  Montevideo a Rio de Janeiro: ---");
    TCaminos montevideoCaminosARios = grafo.todosLosCaminos("Montevideo", "Rio_de_Janeiro");
    montevideoCaminosARios.imprimirCaminosConsola();
    }

}

/*
 * Un grafo puede ser recorrido (o sea, visitar sistemáticamente todos los vértices alcanzables a partir de un cierto vértice 
inicial) de dos maneras: haciendo una “búsqueda en profundidad“ o una “búsqueda en amplitud. 
1. Utiliza  el  algoritmo  de  búsqueda  en  profundidad  para implementar un método en el TDA grafo (“bpf”), que 
realice  el  recorrido  exhaustivo  del  grafo  del  Ejercicio  1,  mostrando  en  consola  las  etiquetas  de  los  vértices 
visitados, en el orden en que se visitan.  
2. ¿Cuál es el orden del tiempo de ejecución de este algoritmo? 
3. Ejecutando el algoritmo a partir del vértice “Montevideo”, muestra por consola todos los vértices visitados. ¿Se 
han  visitado  todos  los  vértices  del  grafo?  Si  no  es  así,  ¿cómo  harías  para  que,  usando  el  mismo  método,  se 
complete la visita de los vértices que aún no han sido visitados? 
4. ¿Cómo  harías  para,  dado  un  cierto  vértice  origen,  obtener  todos  posibles  desde  ese  vértice  hasta  un  cierto 
vértice  destino?  Procura  desarrollar  un  algoritmo  que  haga  esto.    Usando  este  algoritmo  sobre  el  grafo  del 
Ejercicio 1, ¿cuáles serían todos los itinerarios posibles para ir desde Montevideo hasta Rio de Janeiro? 
 
 */