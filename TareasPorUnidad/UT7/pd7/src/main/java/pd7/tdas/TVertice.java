package pd7.tdas;

import java.text.CollationElementIterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class TVertice<T> implements IVertice {

    private final Comparable etiqueta;
    private LinkedList<IAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<IAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    @Override
    public IAdyacencia buscarAdyacencia(IVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public Double obtenerCostoAdyacencia(IVertice verticeDestino) {
        IAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, IVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        IAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public IVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    public IVertice siguienteAdyacente(IVertice w) {
        IAdyacencia adyacente = buscarAdyacencia(w.getEtiqueta());
        int index = adyacentes.indexOf(adyacente);
        if (index + 1 < adyacentes.size()) {
            return adyacentes.get(index + 1).getDestino();
        }
        return null;
    }

    @Override
    public IAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (IAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    /**
     *
     * @return
     */
    public T getDatos() {
        return datos;
    }
   /**
    * Método del vertice para permitir la busqueda por profundidad.
    * Permite no repetir las aristas que ya lleven a un vertice ya visitado.
    * @param YaVisitados
    */
public void bpf(Collection<TVertice> YaVisitados) {
        this.visitado = true; 
        YaVisitados.add(this); 
        for (IAdyacencia adyacente : adyacentes) { 
            TVertice destino = (TVertice) adyacente.getDestino();
            if (!destino.getVisitado()) {
                destino.bpf(YaVisitados);
            }
        }
    }
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
    public boolean tieneCiclo(TCamino camino){
         // linea clave. para mi.
         this.setVisitado(true);
        for (IAdyacencia iAdyacencia : adyacentes) {
            TVertice<T> destino = (TVertice<T>) ((TAdyacencia)iAdyacencia).getDestino();
            camino.agregarAdyacencia(((TAdyacencia)iAdyacencia));
            if (destino.visitado && camino.getOtrosVertices().contains(destino.getEtiqueta())){ 
                return true;
            }
            else{
                if (!destino.getVisitado()) {
                    if (destino.tieneCiclo(camino)) {
                        return true;
                    }
                }
            }
            camino.eliminarAdyacencia(((TAdyacencia)iAdyacencia)); // backtracking.
        }
        setVisitado(false);
        return false;
    }

    
    public void ordenParcial(LinkedList<TVertice> lista) {
        visitado = true;
        for (IAdyacencia arista : adyacentes) {
           TVertice<T> v = ((TVertice<T>)arista.getDestino());
           if (!v.getVisitado()) {
            v.ordenParcial(lista);
           }
        }
        lista.addFirst(this); 
    }

    public void ordenTopologico(LinkedList<TVertice> lista) {
         visitado = true;
        for (IAdyacencia arista : adyacentes) {
           TVertice<T> v = ((TVertice<T>)arista.getDestino());
           if (!v.getVisitado()) {
            v.ordenTopologico(lista);
           }
        }
        lista.addFirst(this); 
    }

} 