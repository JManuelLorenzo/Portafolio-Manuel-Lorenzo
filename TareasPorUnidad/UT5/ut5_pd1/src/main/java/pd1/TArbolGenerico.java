package pd1;
public class TArbolGenerico<T> {

    private TNodoGenerico<T> raiz;

    public TArbolGenerico() {
        this.raiz = null;
    }

    public TArbolGenerico(T etiquetaRaiz) {
        if (etiquetaRaiz != null) {
            this.raiz = new TNodoGenerico<>(etiquetaRaiz);
        }
    }

    public boolean insertar(T unaEtiqueta, T etiquetaPadre) {
        if (unaEtiqueta == null) {
            return false;
        }

        if (raiz == null) {
            if (etiquetaPadre == null || etiquetaPadre.equals("")) {
                raiz = new TNodoGenerico<>(unaEtiqueta);
                return true;
            } else {
                return false;
            }
        }

        if (etiquetaPadre == null || etiquetaPadre.equals("")) {
            return false;
        }

        TNodoGenerico<T> nodoPadre = buscar(etiquetaPadre);
        if (nodoPadre == null) {
            return false;
        }

        return nodoPadre.agregarHijo(new TNodoGenerico<>(unaEtiqueta));
    }

    public TNodoGenerico<T> buscar(T etiqueta) {
        return (raiz == null) ? null : raiz.buscar(etiqueta);
    }

    public String listarIndentado() {
        if (raiz == null) return "";
        StringBuilder sb = new StringBuilder();
        raiz.listarIndentado(sb, 0);
        return sb.toString();
    }

    public TNodoGenerico<T> getRaiz() {
        return raiz;
    }
}