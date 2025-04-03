package org.example;

public class ContadorWhileDo {
    int MAX_CONT = 50;
    int incremento = 1;
    int contador = 1;
    public void displayCount(){ // Version con while
        do{
            System.out.println("El valor actual es: " + contador);
            contador += incremento;
        }while (MAX_CONT >= contador);}
}
