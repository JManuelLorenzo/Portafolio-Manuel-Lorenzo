package org.example;
/*
EJERCICIO 3
Muchos cálculos pueden ser expresados de manera concisa usando la operación “multsuma”,
que toma tres operandos y computa a*b + c. Algunos procesadores incluso proveen una
implementación de hardware para esta operación para números de punto flotante.
Crear un nuevo programa llamado Multsuma.java. Escribir un método llamado multsuma que
toma tres doubles como parámetros y que imprime el resultado de multisumarlo.
Escribir un método main que testee multsuma invocándolo con unos pocos parámetros
simples, como por ejemplo 1.0, 2.0, 3.0, y después imprima por consola el resultado, que en
ese caso debería ser 5.0
 */
public class Multsuma {
    public void multsuma(double a, double b, double c){
        System.out.println(a * b + c);
    }

    public static void main(String[] args) {

        Multsuma multisuma = new Multsuma();
        System.out.println("Ejemplo 1:");
        multisuma.multsuma(1.0, 2.0, 3.0);
        System.out.println("Ejemplo 2:");
        multisuma.multsuma(2.0, 5.0, 2.3);
        System.out.println("Ejemplo 3:");
        multisuma.multsuma(6.0, 5.0, 10.5);
    }
}
