package src;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 * @param <T>
 */
public class Conjunto<T> extends Lista<T> implements IConjunto {
// MEJOR: public class Conjunto<T> extends ListaOrdenada<T> implements IConjunto {
    @Override
    public Conjunto union(Conjunto otroConjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conjunto interseccion(Conjunto otroConjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
