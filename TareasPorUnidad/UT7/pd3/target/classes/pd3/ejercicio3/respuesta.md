
1. Utiliza  el  algoritmo  de  búsqueda  en  profundidad  para implementar un método en el TDA grafo (“bpf”), que 
realice  el  recorrido  exhaustivo  del  grafo  del  Ejercicio  1,  mostrando  en  consola  las  etiquetas  de  los  vértices 
visitados, en el orden en que se visitan.  

Se encuentra en ejercicio3.java


2. ¿Cuál es el orden del tiempo de ejecución de este algoritmo? 

O(V+E) siendo V los vertices y E siendo la cantidad de "edges" o aristas en español.


3. Ejecutando el algoritmo a partir del vértice “Montevideo”, muestra por consola todos los vértices visitados. ¿Se 
han  visitado  todos  los  vértices  del  grafo?  Si  no  es  así,  ¿cómo  harías  para  que,  usando  el  mismo  método,  se 
complete la visita de los vértices que aún no han sido visitados? 

Solucion en Ejercicio 3.java
Lo que utilizaria es cambiar el BPF para que realiza una iteracion sobre los nodos que no tengan la flag puesta de visitados, lo que permitiria solucionar este problema, asegurando asi la visita de todos los nodos. 

4. ¿Cómo  harías  para,  dado  un  cierto  vértice  origen,  obtener  todos  posibles  desde  ese  vértice  hasta  un  cierto 
vértice  destino?  Procura  desarrollar  un  algoritmo  que  haga  esto.    Usando  este  algoritmo  sobre  el  grafo  del 
Ejercicio 1, ¿cuáles serían todos los itinerarios posibles para ir desde Montevideo hasta Rio de Janeiro? 

Para desarollar este algortimo, se trata del algoritmo de todos los caminos, la version estandar, lo que implica es utilizar backtracking e ir recorriendo los nodos, marcandolos como visitados e ir quitando las aristas correspondientes en los casos en que sea necesario.


O sea este código:
### Grafo
public TCaminos todosLosCaminos(String string, String string2) {
        TVertice origen = (TVertice)vertices.get(string);
        TCamino nuevaListaCamino = new TCamino(origen);
        TCaminos caminos = new TCaminos();
     return  origen.todosLosCaminos(string2, nuevaListaCamino, caminos);

### Vertice
 public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
    this.setVisitado(true);
    if (this.getEtiqueta().compareTo(etVertDest) == 0) {
        TCamino copia = caminoPrevio.copiar();
        todosLosCaminos.getCaminos().add(copia);
    } else {
        for (IAdyacencia adyacencia : this.getAdyacentes()) {
            TAdyacencia elemento = (TAdyacencia) adyacencia;
            TVertice destino = (TVertice) elemento.getDestino();
            if (!destino.getVisitado()) {
                caminoPrevio.agregarAdyacencia(elemento); // Agrega la arista antes de la recursión
                destino.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                caminoPrevio.eliminarAdyacencia(elemento);
            }
        }
    }
    this.setVisitado(false);
    return todosLosCaminos;
}

