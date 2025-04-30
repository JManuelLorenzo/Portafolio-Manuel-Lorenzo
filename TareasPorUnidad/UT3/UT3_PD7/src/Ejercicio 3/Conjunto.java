
import java.util.LinkedList;

public class Conjunto<T> implements IConjunto<T> {

    private LinkedList<T> elementos;

    public Conjunto() {
        this.elementos = new LinkedList<>();
    }

    @Override
    public void agregar(T elemento) {
        if (!contiene(elemento)) {
            elementos.add(elemento);
        }
    }

    @Override
    public boolean contiene(T elemento) {
        return elementos.contains(elemento);
    }

    @Override
    public int tamanio() {
        return elementos.size();
    }

    @Override
    public T obtener(int posicion) {
        return elementos.get(posicion);
    }

    @Override
    public IConjunto<T> union(IConjunto<T> otro) {
        IConjunto<T> resultado = new Conjunto<>();
        for (int i = 0; i < this.tamanio(); i++) {
            resultado.agregar(this.obtener(i));
        }
        for (int i = 0; i < otro.tamanio(); i++) {
            resultado.agregar(otro.obtener(i));
        }
        return resultado;
    }

    @Override
    public IConjunto<T> interseccion(IConjunto<T> otro) {
        IConjunto<T> resultado = new Conjunto<>();
        for (int i = 0; i < this.tamanio(); i++) {
            T elem = this.obtener(i);
            if (otro.contiene(elem)) {
                resultado.agregar(elem);
            }
        }
        return resultado;
    }
}
