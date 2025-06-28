package pd5.tdas;

import java.nio.channels.NetworkChannel;
import java.util.*;
import java.util.concurrent.CancellationException;

public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, IVertice> vertices;

    public TGrafoDirigido(Collection<IVertice> vertices, Collection<IArista> aristas) {
        this.vertices = new HashMap<>();
        for (IVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (IArista arista : aristas) {
            insertarArista(arista);
        }
    }

    public boolean eliminarArista(Comparable origen, Comparable destino) {
        IVertice v = buscarVertice(origen);
        return (v != null) && v.eliminarAdyacencia(destino);
    }

    public boolean existeArista(Comparable origen, Comparable destino) {
        IVertice vo = buscarVertice(origen);
        IVertice vd = buscarVertice(destino);
        return (vo != null && vd != null) && vo.buscarAdyacencia(vd) != null;
    }

    public boolean existeVertice(Comparable etiqueta) {
        return vertices.get(etiqueta) != null;
    }

    private IVertice buscarVertice(Comparable etiqueta) {
        return vertices.get(etiqueta);
    }

    public boolean insertarArista(IArista arista) {
        IVertice vo = buscarVertice(arista.getEtiquetaOrigen());
        IVertice vd = buscarVertice(arista.getEtiquetaDestino());
        return (vo != null && vd != null) && vo.insertarAdyacencia(arista.getCosto(), vd);
    }

    public boolean insertarVertice(Comparable etiqueta) {
        if (!existeVertice(etiqueta)) {
            vertices.put(etiqueta, new TVertice(etiqueta));
            return true;
        }
        return false;
    }

    public boolean insertarVertice(IVertice v) {
        Comparable e = v.getEtiqueta();
        if (!existeVertice(e)) {
            vertices.put(e, v);
            return true;
        }
        return false;
    }

    public Map<Comparable, IVertice> getVertices() {
        return vertices;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, IVertice> ordenado = new TreeMap<>(vertices);
        return ordenado.keySet().toArray();
    }

   public Double[][] floyd(Object[] etiquetas) {
    Double[][] C = UtilGrafos.obtenerMatrizCostos(vertices);
    Double[][] A = new Double[C.length][C.length];
    int n = C.length;
    for (int i = 0; i < n; i++)
        System.arraycopy(C[i], 0, A[i], 0, n);
    for (int k = 0; k < n; k++)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (A[i][k] != Double.MAX_VALUE && A[k][j] != Double.MAX_VALUE) {
                    double nuevoCosto = A[i][k] + A[k][j];
                    if (nuevoCosto < A[i][j])
                        A[i][j] = nuevoCosto;
                }
    return A;
}

  public Double obtenerExcentricidad(Comparable etiquetaVertice) {
    Object[] etiquetas = getEtiquetasOrdenado();
    Double[][] floyd = floyd();

    int idx = -1;
    for (int i = 0; i < etiquetas.length; i++) {
        if (etiquetas[i].equals(etiquetaVertice)) {
            idx = i;
            break;
        }
    }

    if (idx == -1) return -1.0; // vértice no existe

    double max = 0;

    
    for (int j = 0; j < floyd.length; j++) {
        if (idx == j) continue; // saltar diagonal
        
        double valor = floyd[idx][j];
        
       
        if (valor == Double.MAX_VALUE) {
            return -1.0;
        }
        
        
        if (valor > max) {
            max = valor;
        }
    }

    return max;
}



    public Comparable centroDelGrafo() {
        Object[] etiquetas = getEtiquetasOrdenado();
        Double[][] floyd = floyd(etiquetas);
        Double min = Double.MAX_VALUE;
        Comparable etiquetaCentro = null;

        for (int i = 0; i < etiquetas.length; i++) {
            Double excentricidad = 0.0;
            boolean desconectado = false;
            for (int j = 0; j < etiquetas.length; j++) {
                if (i == j) continue;
                Double valor = floyd[i][j];
                if (valor.equals(Double.MAX_VALUE)) {
                    desconectado = true;
                    break;
                }
                if (valor > excentricidad) {
                    excentricidad = valor;
                }
            }
            if (!desconectado && excentricidad < min) {
                min = excentricidad;
                etiquetaCentro = (Comparable) etiquetas[i];
            }
        }

        return etiquetaCentro;
    }

    public boolean eliminarVertice(Comparable etiqueta) {
        return vertices.remove(etiqueta) != null;
    }

    public boolean[][] warshall() {
        int n = vertices.size();
        boolean[][] W = new boolean[n][n];
        Double[][] C = UtilGrafos.obtenerMatrizCostos(vertices);

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                W[i][j] = !C[i][j].equals(Double.MAX_VALUE);

        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    W[i][j] = W[i][j] || (W[i][k] && W[k][j]);

        return W;
    }

    public void desvisitarVertices() {
        for (IVertice v : vertices.values()) {
            v.setVisitado(false);
        }
    }

     /**
      * Permite utilizar la busqueda por profundidad en grafos dirigidos.
     * @return
     */
    public Collection<TVertice> bpf() {
        Collection<TVertice> visitados = new LinkedList<>();
        for (IVertice verticeActual : vertices.values()) {
            if (!verticeActual.getVisitado()) {
                ((TVertice) verticeActual).bpf(visitados);
            }
        }
        this.desvisitarVertices();
        return visitados;
    }
    public Collection<TVertice> bpf(Comparable comparable){
       Collection<TVertice> visitados = new LinkedList<>();
       TVertice verticeEntrada = (TVertice) vertices.get(comparable); 
        verticeEntrada.bpf(visitados); 
        this.desvisitarVertices();
        return visitados;

    }

    public Double[][] floyd() {
    Object[] etiquetas = getEtiquetasOrdenado();
    return floyd(etiquetas);
}

    public TCaminos todosLosCaminos(String string, String string2) {
        TVertice origen = (TVertice)vertices.get(string);
        TCamino nuevaListaCamino = new TCamino(origen);
        TCaminos caminos = new TCaminos();
     return  origen.todosLosCaminos(string2, nuevaListaCamino, caminos);

        
    }
    public boolean tieneCiclo(){
         for (IVertice verticeActual : vertices.values()) {
            if (!verticeActual.getVisitado()) {
            TCamino camino = new TCamino((TVertice) verticeActual);
            if(((TVertice)verticeActual).tieneCiclo(camino)){ 
                return true;
            }}
            
         }
       desvisitarVertices(); 
        return false;
    } 
    /**
     * Metodo privado que permite encontrar el caminoCritico entre dos vertices basandose en la etiqueta.
     * @return
     */
    private TCamino caminoCritico (Comparable origen, Comparable destino){
        //Falta checkear si el grafo es ciclico antes. 
        int counter = 0; 
        TCamino caminoCritico = null;
        TVertice verticeOrigen = ((TVertice)getVertices().get(origen));
        TCamino camino = new TCamino(verticeOrigen);
        TCaminos todosLosCaminos = new TCaminos();
        TCaminos caminosPosibles = verticeOrigen.todosLosCaminos(destino, camino, todosLosCaminos);
        LinkedList<TCamino> listaCaminos = new LinkedList<>(caminosPosibles.getCaminos());
        for (TCamino tCamino : listaCaminos) {
            if(tCamino.getCostoTotal() > counter ){
                caminoCritico = tCamino;
            } // Necesito calcular la holgura, de esto. 
        } 
        return caminoCritico;
    }
     // Implmentacion del método obtener orden Topologico
    public  LinkedList<TVertice> ordenTopologico(){
        if(tieneCiclo()) return null;
        desvisitarVertices();
            HashSet<IVertice> posiblesOrigenes = new HashSet<>(vertices.values());
            for (IVertice iVertice : vertices.values()) {
                for (IAdyacencia arista : iVertice.getAdyacentes()) {
                    posiblesOrigenes.remove(arista.getDestino());
                }}
            LinkedList<TVertice> lista = new LinkedList<>();
            for (IVertice vertice : posiblesOrigenes) {
                TVertice tVertice = (TVertice)vertice;
               if (tVertice.getAdyacentes() != null) {
                tVertice.ordenTopologico(lista); 
               }
            }
            desvisitarVertices();
            return lista;}

}

