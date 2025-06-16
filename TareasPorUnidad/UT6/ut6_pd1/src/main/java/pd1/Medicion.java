package pd1; 

/**
 * Clase que representa una medición de tiempo y memoria.
 * Esta clase almacena el consumo de memoria, el tiempo de ejecución y un texto descriptivo.
 */
public class Medicion {

    // Atributos de la clase Medicion
    private Long memoria;
    private Long tiempoEjecucion;
    private String texto;

    /**
     * Constructor de la clase Medicion.
     *
     * @param texto           Descripción de la medición.
     * @param memoria         Consumo de memoria en bytes.
     * @param tiempoEjecucion Tiempo de ejecución en nanosegundos.
     */
    public Medicion(String texto, Long memoria, Long tiempoEjecucion) {
        this.texto = texto;
        this.memoria = memoria;
        this.tiempoEjecucion = tiempoEjecucion;
    }

    /**
     * Obtiene el consumo de memoria.
     *
     * @return Consumo de memoria en bytes.
     */
    public Long getMemoria() {
        return memoria;
    }

    /**
     * Obtiene el tiempo de ejecución.
     *
     * @return Tiempo de ejecución en nanosegundos.
     */
    public Long getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    /**
     * Obtiene el texto descriptivo de la medición.
     *
     * @return Texto descriptivo de la medición.
     */
    public String getTexto() {
        return texto;
    }

    @Override
    public String toString() {
        return "Medicion: " + texto + " - " + "Consumo de memoria=" + memoria + " Bytes , tiempo de ejecución ="
                + tiempoEjecucion + " nanosecs ";
    }
}
