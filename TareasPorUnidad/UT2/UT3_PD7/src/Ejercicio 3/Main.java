
public class Main {

    public static void main(String[] args) {
        IConjunto<TAlumno> cursoAED1 = new Conjunto<>();
        IConjunto<TAlumno> cursoPF = new Conjunto<>();

        // Crear alumnos
        TAlumno a1 = new TAlumno("1234", "Ana", "Pérez");
        TAlumno a2 = new TAlumno("2345", "Luis", "Martínez");
        TAlumno a3 = new TAlumno("3456", "María", "Gómez");
        TAlumno a4 = new TAlumno("4567", "Carlos", "Ruiz");
        TAlumno a5 = new TAlumno("5678", "Laura", "Fernández");

        // Asignar alumnos a cursos
        cursoAED1.agregar(a1);
        cursoAED1.agregar(a2);
        cursoAED1.agregar(a3);

        cursoPF.agregar(a3); // alumno en ambos cursos
        cursoPF.agregar(a4);
        cursoPF.agregar(a5);

        // Unión
        IConjunto<TAlumno> union = cursoAED1.union(cursoPF);
        System.out.println("Alumnos en AED1 o PF:");
        for (int i = 0; i < union.tamanio(); i++) {
            System.out.println(union.obtener(i));
        }

        // Intersección
        IConjunto<TAlumno> interseccion = cursoAED1.interseccion(cursoPF);
        System.out.println("\nAlumnos en AED1 y PF:");
        for (int i = 0; i < interseccion.tamanio(); i++) {
            System.out.println(interseccion.obtener(i));
        }
    }
}