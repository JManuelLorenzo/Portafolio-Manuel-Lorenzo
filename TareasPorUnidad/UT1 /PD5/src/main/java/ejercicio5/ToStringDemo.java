package ejercicio5;

public class ToStringDemo {
    public static void main(String[] args) {
        double d = 2.11111;
        String s = Double.toString(d);
        int dot = s.indexOf('.');
        System.out.println(dot + " digits " + "before decimal point. ");
                System.out.println( (s.length() - dot - 1) + " digits after decimal point. ");
    }
}
