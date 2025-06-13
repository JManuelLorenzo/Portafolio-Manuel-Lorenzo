package pd2.Ejercicio3;

public class THash {
    private Integer[] tabla;
    private int tamaño;
    private int loadFactor;
    private int slotsOcupados;
    private boolean flagRedimensionar = false;

    public THash(int tamaño, int loadFactor) {
        this.tamaño = tamaño;
        this.loadFactor = loadFactor;
        this.tabla = new Integer[tamaño];
        this.slotsOcupados = 0;
    }

    public int funcionHashing(int clave) {
        return clave % tabla.length;
    }

    public int insertar(int clave) {
        if (!flagRedimensionar && ((double)slotsOcupados / tabla.length) > (((double)loadFactor/100))) {
            // llama a redimensiona, se duplica
            flagRedimensionar = true;
            Integer[] temp = tabla;
            tabla = new Integer[tabla.length * 2];
            tamaño = tabla.length; // actualizar tamaño

            slotsOcupados = 0;
            for (Integer integer : temp) {
                if (integer != null) {
                    insertar(integer);
                }
            }
            flagRedimensionar = false;

        }
        int pos = funcionHashing(clave);
        int comparaciones = 1;

        while (tabla[pos] != null) {
    if (tabla[pos].equals(clave)) // ✅ compara valor
        return comparaciones;
    pos = (pos + 1) % tamaño;
    comparaciones++;
}


        tabla[pos] = clave;
        slotsOcupados++;
        return comparaciones;
    }

   
    public int buscar(int clave) {
    int pos = funcionHashing(clave);
    int comparaciones = 1;

    while (tabla[pos] != null && comparaciones  < tabla.length) {
        if (tabla[pos].equals(clave)) return comparaciones;
        pos = (pos + 1) % tabla.length;
        comparaciones++;
        
    }
    return comparaciones*-1;
}

}