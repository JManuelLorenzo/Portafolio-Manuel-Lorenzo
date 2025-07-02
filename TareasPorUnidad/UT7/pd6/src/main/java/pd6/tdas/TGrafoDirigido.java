package pd6.tdas;

import java.nio.channels.NetworkChannel;
import java.util.*;
import java.util.concurrent.CancellationException;
import pd7.tdas.TCamino;
import pd7.tdas.TVertice;

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
     * Algoritmo de Dijkstra para grafos dirigidos.
     * @param etiquetaOrigen Etiqueta del vértice de origen
     * @return Mapa con las distancias mínimas desde el origen a cada vértice
     */
    public Map<Comparable, Double> dijkstra(Comparable etiquetaOrigen) {
        Map<Comparable, Double> distancia = new HashMap<>();
        Map<Comparable, Boolean> visitados = new HashMap<>();

        // Inicializar distancias y visitados
        for (IVertice v : vertices.values()) {
            distancia.put(v.getEtiqueta(), Double.MAX_VALUE);
            visitados.put(v.getEtiqueta(), false);
        }

        distancia.put(etiquetaOrigen, 0.0);

        while (visitados.containsValue(false)) {
            // Seleccionar el vértice no visitado con menor distancia
            Comparable seleccion = null;
            double minDist = Double.MAX_VALUE;
            for (Comparable etiqueta : vertices.keySet()) {
                if (!visitados.get(etiqueta) && distancia.get(etiqueta) < minDist) {
                    minDist = distancia.get(etiqueta);
                    seleccion = etiqueta;
                }
            }
            if (seleccion == null) break; // No hay más alcanzables

            visitados.put(seleccion, true);

            IVertice verticeSeleccionado = vertices.get(seleccion);
            for (IAdyacencia ady : verticeSeleccionado.getAdyacentes()) {
                Comparable vecino = ady.getDestino().getEtiqueta();
                if (!visitados.get(vecino)) {
                    double nuevaDist = distancia.get(seleccion) + ady.getCosto();
                    if (nuevaDist < distancia.get(vecino)) {
                        distancia.put(vecino, nuevaDist);
                    }
                }
            }
        }
        return distancia;
    }

    /**
 * Dijkstra que devuelve predecesores y distancias.
 * @param g grafo dirigido
 * @param s vértice origen
 * @return Un mapa con distancias y otro con predecesores
 */
public static Map<String, Map<IVertice, ?>> dijkstraConPredecesores(TGrafoDirigido g, TVertice s) {
    HashMap<IVertice, Double> distancia = new HashMap<>();
    HashMap<IVertice, Boolean> visitados = new HashMap<>();
    HashMap<IVertice, IVertice> predecesores = new HashMap<>();

    for (IVertice v : g.vertices.values()) {
        distancia.put(v, Double.MAX_VALUE);
        visitados.put(v, false);
        predecesores.put(v, null);
    }
    distancia.put(s, 0.0);

    while (visitados.containsValue(false)) {
        // Seleccionar el vértice no visitado con menor distancia
        IVertice seleccion = null;
        double minDist = Double.MAX_VALUE;
        for (IVertice v : g.vertices.values()) {
            if (!visitados.get(v) && distancia.get(v) < minDist) {
                minDist = distancia.get(v);
                seleccion = v;
            }
        }
        if (seleccion == null) break; // No quedan alcanzables

        visitados.put(seleccion, true);

        for (IAdyacencia ady : seleccion.getAdyacentes()) {
            IVertice vecino = ady.getDestino();
            if (!visitados.get(vecino)) {
                double nuevaDist = distancia.get(seleccion) + ady.getCosto();
                if (nuevaDist < distancia.get(vecino)) {
                    distancia.put(vecino, nuevaDist);
                    predecesores.put(vecino, seleccion);
                }
            }
        }
    }
    Map<String, Map<IVertice, ?>> resultado = new HashMap<>();
    resultado.put("distancia", distancia);
    resultado.put("predecesores", predecesores);
    return resultado;
}
public List<Comparable> reconstruirCamino(Comparable origen, Comparable destino, Map<Comparable, Comparable> predecesor) {
    LinkedList<Comparable> camino = new LinkedList<>();
    Comparable actual = destino;
    while (actual != null) {
        camino.addFirst(actual);
        if (actual.equals(origen)) break;
        actual = predecesor.get(actual);
    }
    if (!camino.getFirst().equals(origen)) {
        // No hay camino
        return Collections.emptyList();
    }
    return camino;
}

/**
 * Reconstruye el camino más corto como un TCamino usando el mapa de predecesores.
 * @param origen etiqueta del vértice origen
 * @param destino etiqueta del vértice destino
 * @param predecesor mapa de predecesores (etiqueta -> etiqueta)
 * @return TCamino con el camino más corto, o null si no hay camino
 */
public TCamino reconstruirTCamino(Comparable origen, Comparable destino, Map<Comparable, Comparable> predecesor) {
    LinkedList<Comparable> etiquetas = new LinkedList<>();
    Comparable actual = destino;
    while (actual != null) {
        etiquetas.addFirst(actual);
        if (actual.equals(origen)) break;
        actual = predecesor.get(actual);
    }
    if (!etiquetas.getFirst().equals(origen)) {
        // No hay camino
        return null;
    }
    TVertice vOrigen = (TVertice) vertices.get(origen);
    TCamino camino = new TCamino(vOrigen);
    Iterator<Comparable> it = etiquetas.iterator();
    if (it.hasNext()) it.next(); // saltar el origen, ya está en TCamino
    while (it.hasNext()) {
        camino.getOtrosVertices().add(it.next());
    }
    return camino;
}
}