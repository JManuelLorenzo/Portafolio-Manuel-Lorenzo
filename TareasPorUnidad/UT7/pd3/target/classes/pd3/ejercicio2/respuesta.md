### Grafo
public boolean todosLosCaminos(String string, String string2) {
        TVertice origen = (TVertice)vertices.get(string);
        TCamino nuevaListaCamino = new TCamino(origen);
        TCaminos caminos = new TCaminos();
     return  origen.todosLosCaminos(string2, nuevaListaCamino, caminos);

### Vertice
 public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
    this.setVisitado(true);
    if (this.getEtiqueta().compareTo(etVertDest) == 0) {
        return true; // existe al menos un camino.
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
    return false;
}
