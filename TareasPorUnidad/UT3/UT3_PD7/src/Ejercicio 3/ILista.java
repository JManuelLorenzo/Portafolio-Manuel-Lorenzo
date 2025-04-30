public interface ILista<T> {

    void agregar(T elemento);

    boolean contiene(T elemento);

    int tamanio();

    T obtener(int posicion);
}