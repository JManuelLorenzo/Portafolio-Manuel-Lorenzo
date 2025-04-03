package org.example;

public class ContadorFor {
    int MAX_CONT = 50;
    int contador = 1;
    int incremento = 1;
    public void displayCount(){ // Version con while
        for (int i = 1; i<=MAX_CONT; i++){
            System.out.println("El valor actual es: " + contador);
            contador += incremento;
        }}

}
