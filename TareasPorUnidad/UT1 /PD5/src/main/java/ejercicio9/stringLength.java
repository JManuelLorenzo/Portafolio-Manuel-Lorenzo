package ejercicio9;

public class stringLength {
    static String hannah = "Did Hannah see bees? Hannah did";
     static int length = hannah.length();
    static char charPedido = hannah.charAt(12);
    static int indexChar = hannah.indexOf("b");

    public static void main(String[] args) {
        System.out.println("La longitud es: " + length);
        System.out.println(" el char en la posicion es: " + charPedido);
        System.out.println("La 'b' tiene el indice de: " + indexChar);
    }
}
