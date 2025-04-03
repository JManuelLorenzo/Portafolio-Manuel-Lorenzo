package org.example;

import ejercicio4.ArrayMutliplcaciones;

import java.io.*;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;



public  class Main {
    // El PDF asignado pide resolver todos los problemas aca, en la "principal"
    // Ejercicio1
    public static void imprimirTablero(int largo, int ancho) {

        String text = "";
        for (int i = 0; i < ancho; i++) {
            if (i != ancho - 1) {
                text = text + "# ";
            } else {
                text = text + "#";
            }
        }
        for (int j = 0; j < largo; j++) {
            if (j % 2 != 0) {
                System.out.println(" " + text);
            } else {
                System.out.println(text);
            }
        }
    }

    // Ejercicio 2
    public static void leerEntradaArchivo(String rutaArchivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        int entero = Integer.parseInt(br.readLine()); // No sé hacer un tryparse en java todavia.
        float decimal = Float.parseFloat(br.readLine());
        String nombre = br.readLine();
        int divisionEntera = (int) ((entero > decimal) ? (entero / decimal) : (decimal / entero)); // Usar una terna para ver cual es mayor.
        float restoDivisionEntera = ((entero > decimal) ? (entero % decimal) : (decimal % entero));

        System.out.println("El entero leido es: " + entero);
        System.out.println("El número de punto flotante es: " + decimal);
        System.out.println("La cadena leída es: " + nombre);
        System.out.println("¡Hola " + nombre + " !La suma de " + entero + " y " + decimal + " es " + (decimal + entero));
        System.out.println("La division entera de " + decimal + " y " + entero + " es " + divisionEntera + " y su resto es " + restoDivisionEntera);

    }

    //parteb
    public static void leerEntradaStdin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el valor del radio del circulo:");
        int radio = Integer.parseInt(scanner.nextLine());
        System.out.println("Area: " + Math.PI * Math.pow(radio, 2));
        System.out.println("Perimetro " + Math.PI * 2 * radio);
    }


    /**
     * @param rutaArchivo
    Ejercicio3 me surgió un problema con este ejercicio, no explica
    si una letra es siempre el mismo número O sea si A B C son todos 2 o si son
    respectivamente 2, 22, 222. Asumi que quiere esto último y, por lo tanto, voy a usar
    un espacio como separador, si no resulta imposible releer los caracteres, puesto que 2222 es imposible
    saber si es 2, 222 o 22, etc.* @throws IOException
     */
    public static void transformarTextoT9(String rutaArchivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        BufferedWriter wr = new BufferedWriter(new FileWriter("src/main/java/ejercicio3/salida.txt"));
        int counter = 0;
        int index = 0;

        String text = "- -.-ABC-DEF-GHI-JKL-MNO-PQRS-TUV-WYXZ";
        String[] textList = text.split("-");
        String line = ".";
        while((line = br.readLine()) != null && !line.isEmpty()  ) { // Compara si no quedan mas lineas.
            line = line.toUpperCase();

            StringBuilder lineoutput = new StringBuilder();
            char[] character = line.toCharArray();
          for (char characterIten: character){
              for (int i = 0; i < textList.length; i ++ ){
                  if (textList[i].contains(String.valueOf(characterIten))){
                    counter = textList[i].indexOf(characterIten) + 1;
                    index = i-1;
                  }
              }
              while (counter > 0){
                  counter--;
                  lineoutput.append(index+"");
              }
          lineoutput.append(" ");
          }
          wr.write(String.valueOf(lineoutput));
          wr.newLine();

        }

        wr.close();

    }

   /*
   Parte b, tome la decision de  hacerlo con maps o hashmaps, creo que va a hacer más eficiente que la version anterior.
   * Nuevamente este programa requiere que la entrada este separada por espacios, porque sino no se entiende
   * si por ejemplo 2222 es 22~B 22~B o ~C 222 y ~A 2.*/

    public static  void transformarT9Texto(String rutaArchivo) throws IOException {
        Map<String, String> mapa = new HashMap();
        mapa.put("0", " "); // Hecho con Maps
        mapa.put("1", "."); // Entiendo que al referise considere Minusculas y mayusculas asumo que son iguales.
        mapa.put("2", "ABC");
        mapa.put("3", "DEF");
        mapa.put("4", "GHI");
        mapa.put("5", "JKL");
        mapa.put("6", "MNO");
        mapa.put("7", "PQRS");
        mapa.put("8", "TUV");
        mapa.put("9", "WYXZ");

        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        BufferedWriter wre = new BufferedWriter(new FileWriter("src/main/java/ejercicio3b/salida.txt"));
        wre.flush();
        String line = br.readLine();
        while ( line != "" && line != null){
           String [] lines = line.split(" ");
        for (String txt : lines) {
            if (!txt.isEmpty()){
            String key = String.valueOf(txt.charAt(0));
            int index = txt.length() - 1;
            String letra = mapa.get(key);
            letra = String.valueOf(letra.charAt(index));
            wre.write(letra);}

        }
        line = br.readLine();
        wre.newLine();
     }
        wre.close();
}



    public static void main(String[] args) throws IOException {
        //imprimirTablero(7,7);
        // leerEntradaArchivo("src/main/java/org/example/entrada.txt");
        // leerEntradaStdin();
      //  transformarTextoT9("src/main/java/ejercicio3/entrada.txt");
        // transformarT9Texto("src/main/java/ejercicio3b/entrada.txt");
       System.out.println(ArrayMutliplcaciones.multiplacionArrayEscalar(new int[]{2, 3, 4}, new int[]{2, 3,4}));
    }
}
