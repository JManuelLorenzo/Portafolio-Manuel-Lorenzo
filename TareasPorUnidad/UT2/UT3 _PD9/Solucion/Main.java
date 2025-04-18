import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Expresion ejemplo = new Expresion();
        char [] listaUno = { '{','}'};
        char [] listaDos = {  '{','}','{','{','}','}'};
        char [] listaTres = {   '{','{','}','{','{','}'};
        char [] listaCuatro = { };
        char [] listaCinco = { '{'};
        System.out.println(ejemplo.controlCorchetes(listaUno));
        System.out.println(ejemplo.controlCorchetes(listaDos));
        System.out.println(ejemplo.controlCorchetes(listaTres));
        System.out.println(ejemplo.controlCorchetes(listaCuatro));
        System.out.println(ejemplo.controlCorchetes(listaCinco));

    }

}
