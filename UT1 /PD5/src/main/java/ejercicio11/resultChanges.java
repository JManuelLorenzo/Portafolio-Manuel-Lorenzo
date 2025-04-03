package ejercicio11;

public class resultChanges {
    public static void main(String[] args) {
        String original = "este es el curso de Programación 2";
        StringBuilder result = new StringBuilder("hola");
        int index = original.indexOf('a');

        /*1*/ result.setCharAt(0, original.charAt(0));
       // System.out.println("1 texto:" + result );
        /*2*/ result.setCharAt(1, original.charAt(original.length()-1));
       // System.out.println("2 texto: " + result );
        /*3*/ result.insert(1, original.charAt(4));
       //  System.out.println("3 texto: " + result );
        /*4*/ result.append(original.substring(1,4));
       // System.out.println("4 texto: " + result);
        /*5*/ result.insert(3, (original.substring(index, index+2) + " "));
       // System.out.println("5 texto: " + result);
        System.out.println(result);
    }
}