package ejercicio1;

public class EjemploEnum {
    public enum Colores{
        ROJO, AZUl, VERDE, AMARILLO // NEGRO, ETC
    }

    public static void main(String[] args) {
       for(Colores a: Colores.values()){ // Recorre una array.
           System.out.println(a);
       }

    }
}
