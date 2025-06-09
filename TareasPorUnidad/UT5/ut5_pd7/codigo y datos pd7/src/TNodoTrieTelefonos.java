
import java.util.LinkedList;

public class TNodoTrieTelefonos implements INodoTrieTelefonos {

    private static final int CANT_DIGITOS = 10;
    TNodoTrieTelefonos[] hijos = new TNodoTrieTelefonos[CANT_DIGITOS];
    private boolean esPalabra;
    public TAbonado abonado;

    public TNodoTrieTelefonos() {
        esPalabra = false;
        abonado = null;
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        String numero = unAbonado.getTelefono();
        TNodoTrieTelefonos nodo = this;
        for (int i = 0; i < numero.length(); i++) {
            char caracter = numero.charAt(i);
            if (!Character.isDigit(caracter)) {
                continue; // ignorar cualquier carácter no numérico
            }
            int indice = caracter - '0';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrieTelefonos();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
        nodo.abonado = unAbonado;
    }

    @Override
    public void buscarTelefonos(String prefijoActual, LinkedList<TAbonado> abonados) {
        if (this.esPalabra && this.abonado != null) {
            abonados.add(this.abonado);
        }
        for (int i = 0; i < CANT_DIGITOS; i++) {
            if (this.hijos[i] != null) {
                this.hijos[i].buscarTelefonos(prefijoActual + i, abonados);
            }
        }
    }

    public void imprimir() {
        imprimir("", this);
    }

    private void imprimir(String s, TNodoTrieTelefonos nodo) {
        if (nodo != null) {
            if (nodo.esPalabra && nodo.abonado != null) {
                System.out.println(s + " -> " + nodo.abonado.getNombre());
            }
            for (int c = 0; c < CANT_DIGITOS; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s + c, nodo.hijos[c]);
                }
            }
        }
    }

    public int buscar(String s) {
        TNodoTrieTelefonos nodo = this;
        int comparaciones = 0;

        for (int c = 0; c < s.length(); c++) {
            char caracter = s.charAt(c);
            if (!Character.isDigit(caracter)) {
                return 0;
            }
            int indice = caracter - '0';
            comparaciones++;
            if (nodo.hijos[indice] == null) {
                return 0; // número no encontrado
            }
            nodo = nodo.hijos[indice];
        }

        return nodo.esPalabra ? comparaciones : 0;
    }
    public void buscarTelefonosOrdenado(String prefijoActual, LinkedList<TAbonado> abonados) {
    if (this.esPalabra && this.abonado != null) {
        // Inserción ordenada en la lista (por nombre)
        int i = 0;
        while (i < abonados.size() && abonados.get(i).getNombre().compareTo(this.abonado.getNombre()) < 0) {
            i++;
        }
        abonados.add(i, this.abonado);
    }

    for (int i = 0; i < hijos.length; i++) {
        if (hijos[i] != null) {
            hijos[i].buscarTelefonosOrdenado(prefijoActual + i, abonados);
        }
    }
}

}

