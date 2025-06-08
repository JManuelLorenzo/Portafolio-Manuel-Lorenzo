package pd1;

public class TNodoGenerico<T> {

    private final T etiqueta;
    private TNodoGenerico<T> primerHijo;
    private TNodoGenerico<T> hermanoDerecho;

    public TNodoGenerico(T etiqueta) {
        this.etiqueta = etiqueta;
        this.primerHijo = null;
        this.hermanoDerecho = null;
    }

    public T getEtiqueta() {
        return etiqueta;
    }

    public TNodoGenerico<T> getPrimerHijo() {
        return primerHijo;
    }

    public TNodoGenerico<T> getHermanoDerecho() {
        return hermanoDerecho;
    }

    public void setPrimerHijo(TNodoGenerico<T> hijo) {
        this.primerHijo = hijo;
    }

    public void setHermanoDerecho(TNodoGenerico<T> hermano) {
        this.hermanoDerecho = hermano;
    }

    public TNodoGenerico<T> buscar(T etiquetaBuscada) {
        if (etiquetaBuscada == null) {
            return null;
        }
        if (etiqueta.equals(etiquetaBuscada)) {
            return this;
        }
        TNodoGenerico<T> unHijo = primerHijo;
        while (unHijo != null) {
            TNodoGenerico<T> resultado = unHijo.buscar(etiquetaBuscada);
            if (resultado != null) {
                return resultado;
            }
            unHijo = unHijo.hermanoDerecho;
        }
        return null;
    }

    public boolean agregarHijo(TNodoGenerico<T> nuevoHijo) {
        if (nuevoHijo == null) return false;
        if (primerHijo == null) {
            primerHijo = nuevoHijo;
        } else {
            TNodoGenerico<T> actual = primerHijo;
            while (actual.hermanoDerecho != null) {
                actual = actual.hermanoDerecho;
            }
            actual.hermanoDerecho = nuevoHijo;
        }
        return true;
    }

    public void listarIndentado(StringBuilder sb, int nivel) {
        sb.append("  ".repeat(nivel)).append(etiqueta).append('\n');
        TNodoGenerico<T> hijo = primerHijo;
        while (hijo != null) {
            hijo.listarIndentado(sb, nivel + 1);
            hijo = hijo.hermanoDerecho;
        }
    }
}