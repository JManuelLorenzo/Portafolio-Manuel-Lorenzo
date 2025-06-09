package pd7;
import java.util.LinkedList;

public class TArbolTrieTelefonos implements IArbolTrieTelefonos {

    private TNodoTrieTelefonos raiz = new TNodoTrieTelefonos();

    @Override
    public void insertar(TAbonado unAbonado) {
        if (unAbonado != null) {
            raiz.insertar(unAbonado);
        }
    }

    @Override
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        String prefijo = pais + area;
        // 1) bajar hasta el nodo del prefijo
        TNodoTrieTelefonos nodo = raiz;
        for (char c : prefijo.toCharArray()) {
            if (!Character.isDigit(c)) return new LinkedList<>();
            int idx = c - '0';
            if (nodo.hijos[idx] == null) return new LinkedList<>();
            nodo = nodo.hijos[idx];
        }
        // 2) recolectar abonados debajo del nodo
        LinkedList<TAbonado> lista = new LinkedList<>();
        nodo.buscarTelefonosOrdenado(prefijo, lista);


        return lista;
    }
}
