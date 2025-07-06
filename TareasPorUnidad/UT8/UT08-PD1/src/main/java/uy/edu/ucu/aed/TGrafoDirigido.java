package uy.edu.ucu.aed;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private final Map<Comparable, TVertice> vertices; //lista de vertices del grafo.-


    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     * @param nomVerticeOrigen
     * @param nomVerticeDestino
     * @return
     */
    @Override
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de eliminar un vertice en el grafo. En caso de no
     * existir el v�rtice, retorna falso. En caso de que la etiqueta sea
     * inv�lida, retorna false.
     *
     * @param nombreVertice
     * @return
     */
    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        if (nombreVertice != null) {
            getVertices().remove(nombreVertice);
            return getVertices().containsKey(nombreVertice);
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @return True si existe la adyacencia, false en caso contrario
     */
    @Override
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     * <p>
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    @Override
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     * <p>
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Matodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @param arista
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            tempbool = (vertOrigen != null) && (vertDestino != null);
            if (tempbool) {
                //getLasAristas().add(arista);
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }

        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     * <p>
     * No pueden ingresarse v�rtices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override
    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }


    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    @Override
    public void desvisitarVertices() {
        for (TVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }
    }

    /**
     * @return the vertices
     */
    @Override
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Collection<TVertice> bpf(TVertice vertice) {
        Collection<TVertice> visitados = new LinkedList<>();
        vertice.bpf(visitados);
        this.desvisitarVertices();
        return visitados;
    }


    @Override
    public boolean tieneCiclo(TCamino camino) {
        Set<Comparable> visitados = new HashSet<>();
        if (!visitados.add(camino.getOrigen().getEtiqueta())) {
            return true;
        }
        for (Comparable etiqueta : camino.getOtrosVertices()) {
            if (!visitados.add(etiqueta)) {
                return true;
            }
        }
    
        return false; 
    }

    @Override
    public Collection<TVertice> bpf() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<TVertice> bpf(Comparable etiquetaOrigen) {
        Collection<TVertice> visitados = new LinkedList<>();
        for (TVertice vertice : vertices.values()) {
            if (!vertice.getVisitado()) {
                vertice.bpf(visitados);
            }
        }
        this.desvisitarVertices();
        return visitados;
    }

    @Override
    public Comparable centroDelGrafo() {
        Object[] etiquetas = getEtiquetasOrdenado();
        Double[][] matrizFloyd = floyd();
        Double minExcentricidad = Double.POSITIVE_INFINITY;
        Comparable<?> centro = null;
    
        for (int i = 0; i < etiquetas.length; i++) {
            Double excentricidad = 0.0;
            boolean desconectado = false;
    
            for (int j = 0; j < etiquetas.length; j++) {
                if (i == j) continue;
                Double distancia = matrizFloyd[i][j];
                if (distancia.equals(Double.POSITIVE_INFINITY)) {
                    desconectado = true;
                    break;
                }
                if (distancia > excentricidad) {
                    excentricidad = distancia;
                }
            }
    
            if (!desconectado && excentricidad < minExcentricidad) {
                minExcentricidad = excentricidad;
                centro = (Comparable<?>) etiquetas[i];
            }
        }
    
        return centro;
    }

    @Override
    public Double[][] floyd() {
    Object[] etiquetas = getEtiquetasOrdenado();
    int n = etiquetas.length;
    Double[][] costos = UtilGrafos.obtenerMatrizCostos(vertices);

    for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (costos[i][k] + costos[k][j] < costos[i][j]) {
                    costos[i][j] = costos[i][k] + costos[k][j];
                }
            }
        }
    }

    return costos;
    }    
    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        Object[] etiquetas = getEtiquetasOrdenado();
        Double[][] matriz = floyd();
        int idx = -1;
    
        for (int i = 0; i < etiquetas.length; i++) {
            if (etiquetas[i].equals(etiquetaVertice)) {
                idx = i;
                break;
            }
        }
    
        if (idx == -1) return Double.POSITIVE_INFINITY;
    
        double max = 0;
        for (int j = 0; j < matriz.length; j++) {
            if (idx == j) continue;
            double valor = matriz[idx][j];
            if (valor == Double.POSITIVE_INFINITY) {
                return Double.POSITIVE_INFINITY;
            }
            if (valor > max) {
                max = valor;
            }
        }
    
        return max;
    }

    @Override
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

    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice verticeOrigen = (TVertice) vertices.get(etiquetaOrigen);
        TCaminos caminos = new TCaminos();
        TCamino caminoActual = new TCamino(verticeOrigen);
        TVertice verticeDestino = (TVertice) vertices.get(etiquetaDestino);
        verticeOrigen.todosLosCaminos(verticeDestino.getEtiqueta(), caminoActual, caminos);
        return caminos;
    }

    @Override
    public boolean tieneCiclo(Comparable etiquetaOrigen) {
        TVertice vertice = (TVertice) vertices.get(etiquetaOrigen);
        if (vertice == null) return false;
        LinkedList<Comparable> visitados = new LinkedList<>();
        return vertice.tieneCiclo(visitados);
    }
    
    @Override
    public boolean tieneCiclo() {
        for (TVertice vertice : vertices.values()) {
            LinkedList<Comparable> visitados = new LinkedList<>();
            if (vertice.tieneCiclo(visitados)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<TVertice> bea() {
        Collection<TVertice> visitados = new LinkedList<>();
        for (TVertice vertice : vertices.values()) {
            if (!vertice.getVisitado()) {
                vertice.bea(visitados);
            }
        }
        this.desvisitarVertices();
        return visitados;
    }


}
