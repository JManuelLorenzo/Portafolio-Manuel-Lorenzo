import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        firstProblem();
        secondProblem();
        thirdProblem();

    }

    public static void firstProblem() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("suc1.txt"));
        String abc;
        int counter = 0;
        System.out.println("\n");
        System.out.println("--------------------");
        Lista test = new Lista<>();
        while ((abc = br.readLine()) != null && !abc.isEmpty()) {
            test.insertar(new Nodo(counter, abc));
            counter++;

        }
        br.close();
        System.out.println("El primer test da " + test.cantElementos());
        System.out.println(test.imprimir());
        test.eliminar(4);
        System.out.println(test.imprimir());

    }

    public static void secondProblem() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("suc2.txt"));
        String abc;
        System.out.println("\n");
        System.out.println("--------------------");
        int counter = 0;
        Lista test = new Lista<>();
        while ((abc = br.readLine()) != null && !abc.isEmpty()) {
            test.insertar(new Nodo(counter, abc));
            counter++;
        }
        System.out.println(test.imprimir());
        test.eliminar(0);
        test.eliminar(1);
        System.out.println(test.imprimir());
    }
    public static void thirdProblem() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("suc3.txt"));
        String abc;
        System.out.println("\n");
        System.out.println("--------------------");
        int counter = 0;
        Lista test = new Lista<>();
        while ((abc = br.readLine()) != null && !abc.isEmpty()) {
            test.insertar(new Nodo(counter, abc));
            counter++;
        }
        System.out.println(test.imprimir(";_"));
    }
}