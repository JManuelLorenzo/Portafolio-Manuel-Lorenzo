public interface IConjunto<T> extends ILista<T> {

    IConjunto<T> union(IConjunto<T> otroConjunto);

    IConjunto<T> interseccion(IConjunto<T> otroConjunto);
}