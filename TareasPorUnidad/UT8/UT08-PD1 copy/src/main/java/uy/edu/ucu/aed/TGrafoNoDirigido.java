package uy.edu.ucu.aed;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {
    protected TAristas lasAristas = new TAristas();

    /**
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }


    @Override
    public TGrafoNoDirigido Prim() {
        LinkedList<Comparable> u = new LinkedList<>();
        LinkedList<Comparable> v = new LinkedList<>(getVertices().keySet());
        TAristas aristas = new TAristas();
        Comparable temp = v.getFirst();
        float costoPrim = 0;
        u.addFirst(temp);
        v.remove(temp);
        while(!v.isEmpty()){
            TArista temporal = aristas.buscarMin(u, v);
            aristas.add(temporal);
            v.remove(temporal.getEtiquetaDestino());
            u.add(temporal.getEtiquetaDestino());
            costoPrim += temporal.getCosto();
        }
        return new TGrafoNoDirigido(getVertices().values(), aristas);

         
             
        
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
