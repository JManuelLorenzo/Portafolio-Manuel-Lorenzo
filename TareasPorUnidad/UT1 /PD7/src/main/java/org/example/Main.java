package org.example;

import java.nio.charset.StandardCharsets;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Solucion correcta el ejercicio1
        String s1 = "Hola";
        String s2 = "Hola";
        if ( s1.equals(s2) ) { // se utiliza el equals y no ==
            System.out.println( "True" );
        } else {
            System.out.println( "False" );
        }
    }
}