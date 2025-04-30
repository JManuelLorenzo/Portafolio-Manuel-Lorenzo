
import java.util.Objects;

public class TAlumno {

    private String cedula;
    private String nombre;
    private String apellido;

    public TAlumno(String cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + cedula + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TAlumno)) {
            return false;
        }
        TAlumno tAlumno = (TAlumno) o;
        return Objects.equals(cedula, tAlumno.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }
}
