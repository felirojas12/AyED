package tp5.ejercicio5;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import tp1.ejercicio8.Queue;
import tp5.ejercicio1.*;

public class Banco {
    public List<Persona> jubiladosCercanos(Graph<Persona> grafo, Persona empleado, int separacion) {
        List<Persona> resultado = new ArrayList<>();
        if (!grafo.isEmpty()) {
            Vertex<Persona> origen = grafo.search(empleado);
            if (origen != null) {
                jubiladosCercanos(grafo, origen, separacion, new boolean[grafo.getSize()], resultado);
            }
        }
        return resultado;
    }

    private void jubiladosCercanos(Graph<Persona> grafo, Vertex<Persona> origen, int separacion, boolean[] marcas, List<Persona> resultado) {
        Queue<Vertex<Persona>> cola = new Queue<>();
        cola.enqueue(origen);
        marcas[origen.getPosition()] = true;
        int nivel = 0;
        while (!cola.isEmpty() && nivel < separacion && resultado.size() < 40) {
            int cant = cola.size();
            while (cant > 0) {
                Vertex<Persona> v = cola.dequeue();
                for (Edge<Persona> edge : grafo.getEdges(v)) {
                    Vertex<Persona> destino = edge.getTarget();
                    if (!marcas[destino.getPosition()]) {
                        marcas[destino.getPosition()] = true;
                        cola.enqueue(destino);
                        if (destino.getData().esJubilado() && resultado.size() < 40) {
                            resultado.add(destino.getData());
                        }
                    }
                }
                separacion--;
            }
            nivel++;
        }
    }
}
