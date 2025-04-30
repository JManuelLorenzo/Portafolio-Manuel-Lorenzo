import java.util.Stack;

public class Expresion {
    Stack stack = new Stack();

    public boolean controlCorchetes (char[] listaDeEntrada) {

        for (int i = 0; i < listaDeEntrada.length; i++) {
            if (listaDeEntrada[i] == '{') {
                stack.push(listaDeEntrada[i]);
            } else {

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()){
        return false;}
        return true;
    }
    }
