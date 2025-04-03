package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Linea del Contador While:\n");
        Contador contadorWhile = new Contador();
        //contador.displayCount();
        System.out.println("Linea del Contador For:\n");
        ContadorFor contadorFor = new ContadorFor();
//       contadorFor.displayCount();
        System.out.println("Linea del Contador While-Do:\n");
        ContadorWhileDo contadorWhileDo = new ContadorWhileDo();
        contadorWhileDo.displayCount();

    }
}
