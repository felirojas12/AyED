package tp5.ejercicio5;

import java.util.Objects;

public class Persona {
    private String nombre;
    private String apellido;
    private String profesion;

    public Persona(String nombre, String apellido, String profesion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public boolean esJubilado() {
        return profesion.equals("Jubilado");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Persona persona)) return false;
        return Objects.equals(getNombre(), persona.getNombre()) && Objects.equals(getApellido(), persona.getApellido()) && Objects.equals(getProfesion(), persona.getProfesion());
    }

}
