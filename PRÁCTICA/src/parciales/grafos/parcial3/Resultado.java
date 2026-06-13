package parciales.grafos.parcial3;

import java.util.List;

public class Resultado {
    private List<String> lista;
    private int tiempoRecorrido;

    public Resultado(List<String> lista, int tiempoRecorrido) {
        this.lista = lista;
        this.tiempoRecorrido = tiempoRecorrido;
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }

    public int getTiempoRecorrido() {
        return tiempoRecorrido;
    }

    public void setTiempoRecorrido(int tiempoRecorrido) {
        this.tiempoRecorrido = tiempoRecorrido;
    }

    @Override
    public String toString() {
        return "Resultado {" +
                "Lista = " + lista +
                ", Tarda = " + tiempoRecorrido +
                '}';
    }
}
