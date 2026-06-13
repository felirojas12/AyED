package tp5.ejercicio2;
import tp2.ejercicio1_2.Queue;
import tp5.ejercicio1.*;

import java.util.ArrayList;
import java.util.List;

public class Recorridos<T> {

    public Recorridos() {
    }

    public List<T> dfs(Graph<T> grafo) {
        List<T> resultado = new ArrayList<>();
        boolean[] visitados = new boolean[grafo.getSize()];
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!visitados[i])
                dfs(grafo, i, visitados, resultado);
        }
        return resultado;
    }

    private void dfs(Graph<T> grafo, int i, boolean[] visitados, List<T> resultado) {
        visitados[i] = true;
        Vertex<T> vertice = grafo.getVertex(i);
        resultado.add(vertice.getData());
        List<Edge<T>> adyacentes = grafo.getEdges(vertice);
        for (Edge<T> arista: adyacentes) {
            int j = arista.getTarget().getPosition();
            if (!visitados[j]) dfs(grafo, j, visitados, resultado);
        }
    }
    public List<T> bfs(Graph<T> grafo) {
        boolean[] visitados = new boolean[grafo.getSize()];
        List<T> resultado = new ArrayList<>();
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!visitados[i]) {
                this.bfs(grafo, i, visitados, resultado);
            }
        }
        return resultado;
    }
    private void bfs(Graph<T> grafo, int i, boolean[] visitados, List<T> resultado) {
        Queue<Vertex<T>> cola = new Queue<Vertex<T>>();
        cola.enqueue(grafo.getVertex(i));
        visitados[i] = true;
        while (!cola.isEmpty()) {
            Vertex<T> v = cola.dequeue();
            resultado.add(v.getData());
            List<Edge<T>> adyacentes = grafo.getEdges(v);
            for (Edge<T> arista: adyacentes) {
                int j = arista.getTarget().getPosition();
                if (!visitados[j]){
                    visitados[j] = true;
                    cola.enqueue(arista.getTarget());
                }
            }
        }
    }
}
