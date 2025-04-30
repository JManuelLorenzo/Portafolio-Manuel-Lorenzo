package src;

import java.io.*;

public class ProgramaPD12 {

    public static void main(String[] args) throws IOException {

        // instanciar curso BasicoIng...
        Conjunto<Alumno> BasicoIng = new Conjunto<>();
        BufferedReader br = new BufferedReader(new FileReader("src/basico-ing.txt"));
        String text;

        while ((text = br.readLine()) != null && !text.trim().isEmpty()){
            String[] lista = text.split(",");
            Integer id = Integer.parseInt(lista[0].trim());
            Alumno temp = new Alumno(id, lista[1]);
            BasicoIng.insertar(new Nodo<>(id, temp)); // Asegurarse de que sea Integer



        }
        br.close();
      //  Conjunto.imprimirConjunto(BasicoIng);
        // instanciar curso BasicoEmp...
        Conjunto<Alumno> BasicoEmp = new Conjunto<>();
        // cargar alumnos del curso BasicoEmp desde el archivo “basico-emp.txt”
         br = new BufferedReader(new FileReader("src/basico-emp.txt"));
        while ((text = br.readLine()) != null && !text.trim().isEmpty()){
            String[] lista = text.split(",");
            Integer id = Integer.parseInt(lista[0].trim());
            Alumno temp = new Alumno(id, lista[1]);
            BasicoEmp.insertar(new Nodo<>(id, temp)); // Asegurarse de que sea Integer

        }
        br.close();
        //Conjunto.imprimirConjunto(BasicoEmp);

        // generar el curso "integrador101" con los alumnos que están en condiciones de cursarlo
        Conjunto integrador101 = BasicoIng.union(BasicoEmp);



        // guardar en un archivo "integrador101.txt"  - IDEALMENTE ordenados por código de alumno -
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/integrador101.txt"));
        Nodo tempNodo = integrador101.getPrimero();
        while (tempNodo != null) {
            writer.write(tempNodo.getEtiqueta() + "\n");  // Escribe el ID de cada alumno
            tempNodo = tempNodo.getSiguiente();
        }
        writer.close();
        
        // generar el curso "exigente102" con los alumnos que están en condiciones de cursarlo 
        Conjunto exigente102 = BasicoIng.interseccion(BasicoEmp);
         writer = new BufferedWriter(new FileWriter("src/exigente102.txt"));
         tempNodo = exigente102.getPrimero();
        while (tempNodo != null) {
            writer.write(tempNodo.getEtiqueta() + "\n");  // Escribe el ID de cada alumno
            tempNodo = tempNodo.getSiguiente();
        }
        writer.close();
        // guardar en un archivo "exigente102.txt" - IDEALMENTE ordenados por código de alumno -
    }

}
