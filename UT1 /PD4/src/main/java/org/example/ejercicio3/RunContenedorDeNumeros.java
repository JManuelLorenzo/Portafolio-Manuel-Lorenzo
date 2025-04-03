package org.example.ejercicio3;

public class RunContenedorDeNumeros {
    public static void main(String[] args) {
        ContenedorDeNumeros contenedorDeNumeros = new ContenedorDeNumeros();
        contenedorDeNumeros.aFloat = 3.14F;
        contenedorDeNumeros.anInt = 9;
        System.out.print("aFloat:\t"+contenedorDeNumeros.aFloat + "\n" + "anInt:\t" + contenedorDeNumeros.anInt );
    }
}
