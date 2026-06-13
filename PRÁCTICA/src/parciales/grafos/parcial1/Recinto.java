package parciales.grafos.parcial1;

import java.util.Objects;

public class Recinto {
    private String nombre;
    private int tiempoDeVisita;

    public Recinto(String nombre, int tiempoDeVisita) {
        this.nombre = nombre;
        this.tiempoDeVisita = tiempoDeVisita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoDeVisita() {
        return tiempoDeVisita;
    }

    public void setTiempoDeVisita(int tiempoDeVisita) {
        this.tiempoDeVisita = tiempoDeVisita;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Recinto recinto)) return false;
        return Objects.equals(getNombre(), recinto.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNombre());
    }
}
