import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;public class TestArray {

        public static void main(String[] args) throws IOException {
            firstProblem();
           secondProblem();
            thirdProblem();

        }

        public static void firstProblem() throws IOException {
            BufferedReader br = new BufferedReader(new FileReader("suc1.txt"));
            String abc;

            System.out.println("\n");
            System.out.println("--------------------");
            SurcursalesArray test = new SurcursalesArray();
            while ((abc = br.readLine()) != null && !abc.isEmpty()) {
                test.add(abc);
                           }
            br.close();
            System.out.println("La cantidad de elementos es " + test.quantitySize());
            System.out.println("El primer test da " + test.listAll());

            test.remove(4);
            System.out.println(test.listAll());

        }

       public static void secondProblem() throws IOException {
            BufferedReader br = new BufferedReader(new FileReader("suc2.txt"));

            String abc;
            System.out.println("\n");
            System.out.println("--------------------");

            SurcursalesArray testDos = new SurcursalesArray();
            while ((abc = br.readLine()) != null && !abc.isEmpty()) {
                testDos.add(abc);

            }
            System.out.println(testDos.listAll());
            testDos.remove(0);
           System.out.println("Esta linea rompe el codigo: testDos.remove(1);"); //testDos.remove(1);
            System.out.println(testDos.listAll());
            br.close();
        }
        public static void thirdProblem() throws IOException{
            BufferedReader br = new BufferedReader(new FileReader("suc3.txt"));
            String abc;
            System.out.println("\n");
            System.out.println("--------------------");

            SurcursalesArray testTres = new SurcursalesArray();
            while ((abc = br.readLine()) != null && !abc.isEmpty()) {
                testTres.add(abc);

            }
            br.close();
            System.out.println(testTres.listAll(";_"));

        }
    }
