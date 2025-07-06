package uy.edu.ucu.aed;

import java.util.Collection;
import java.util.LinkedList;


public class TVertice implements IVertice {

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<TAdyacencia> getAdyacentes() {
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
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }


    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }


    @Override
    public void bpf(Collection<TVertice> visitados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        this.setVisitado(true);

        if (this.getEtiqueta().equals(etVertDest)) {
            todosLosCaminos.agregarCamino(caminoPrevio);
        } else {
            for (TAdyacencia ady : this.getAdyacentes()) {
                TVertice destinoVertice = (TVertice) ady.getDestino();
                if (!destinoVertice.getVisitado()) {
                    caminoPrevio.agregarAdyacencia(ady);
                    destinoVertice.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                    caminoPrevio.eliminarAdyacencia(ady);
                }
            }
        }
    
        this.setVisitado(false);
        return todosLosCaminos;
    }

    @Override
    public void bea(Collection<TVertice> visitados) {
        LinkedList<TVertice> cola = new LinkedList<>();
        this.setVisitado(true);
        visitados.add(this);
        cola.add(this);
    
        while (!cola.isEmpty()) {
            TVertice actual = cola.poll();
            for (TAdyacencia ady : actual.getAdyacentes()) {
                TVertice vecino = (TVertice) ady.getDestino();
                if (!vecino.getVisitado()) {
                    vecino.setVisitado(true);
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
    }

    @Override
    public TVertice siguienteAdyacente(TVertice w) {
        boolean devolverSiguiente = false;
        for (TAdyacencia ady : this.getAdyacentes()) {
            TVertice destino = (TVertice) ady.getDestino();
            if (devolverSiguiente) {
                return destino;
            }
            if (destino.getEtiqueta().equals(w.getEtiqueta())) {
                devolverSiguiente = true;
            }
        }
        return null;
    }

    @Override
    public boolean tieneCiclo(LinkedList<Comparable> camino) {
        if (camino.contains(this.getEtiqueta())) {
            return true;
        }
        this.setVisitado(true);
        camino.add(this.getEtiqueta());
        for (TAdyacencia ady : this.getAdyacentes()) {
            TVertice destino = (TVertice) ady.getDestino();
            if (!destino.getVisitado()) {
                if (destino.tieneCiclo(new LinkedList<>(camino))) {
                    return true;
                }
            }
        }
        this.setVisitado(false);
        return false;
    }
}
