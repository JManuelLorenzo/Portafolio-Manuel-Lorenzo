package org.example;

/*
* - **Presión Sanguínea:** 0 - 250
- **Frecuencia Cardíaca:** 0 - 226
- **Nivel de Azúcar en Sangre:** 0 - 1000

### Autodiagnóstico
- **Máxima Fuerza a la que fue Expuesto:** 0 - 3,000,000,000
- **Mínimo Tiempo entre Latidos:** 0 - 100 (con decimales)
- **Batería Restante:** % de batería restante (con la mayor precisión posible)
- **Código del Fabricante:** Números y letras (máximo 8 caracteres)*/
public class MarcaPasos {
    short PresionSanguinea = 0; // 2 bytes
    short FrecuenciaCardiaca = 0; // 2 bytes
    short NivelAzucarEnSangre = 0; // 2 bytes
    long MaximaFuerzaExpuesto = 0; // 8 bytes
    float MinTiempo = 0; // 4 bytes
    double BateriaRestante = 0; // 8 bytes
    char codigo0 = ' '; // 2 bytes
    char codigo1 = ' '; // 2 bytes
    char codigo2 = ' '; // 2 bytes
    char codigo3 = ' '; // 2 bytes
    char codigo4 = ' '; // 2 bytes
    char codigo5 = ' '; // 2 bytes
    char codigo6 = ' '; // 2 bytes
    char codigo7 = ' '; // 2 bytes
   /*Calcular el espacio ocupado por su clase únicamente por la
   Únicamente por las variables indicadas.
     2 * 3 + 8 + 4 + 8 + 2 * 8 = 42 Bytes
     42 bytes * 8 = 336 bits de memoria en total.
    */
}
