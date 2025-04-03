package org.example;

public class Alumno {
    private String nombre;
    public Alumno(String nombre) { // El constructor no cumple con su función.
        this.nombre = nombre;
    }
    public String getNombreAdmiracion() { // Lo que provocaba que el metódo tampoco lo hiciera.
        return nombre.concat("!");
    }
    public static void main(String[] args) {
        Alumno alumno = new Alumno("ejemplo");
        System.out.println(alumno.getNombreAdmiracion());
    }
}