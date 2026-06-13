package parciales.grafos.parcial2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tp2.ejercicio1_2.Queue;
import tp5.ejercicio1.*;

public class Parcial {
    public List<Usuario> invitacionMasterClass(Graph<String> red, String usuario, int distancia, int limite) {
        List<Usuario> usuarios = new ArrayList<>();
        if (!red.isEmpty()) {
            Vertex<String> origen = null;
            for (Vertex<String> vertice: red.getVertices()) {
                if (vertice.getData().equals(usuario))
                    origen = vertice;
            }
            if (origen != null) {
                boolean[] marcas = new boolean[red.getSize()];
                boolean encontre = false;
                Queue<Vertex<String>> cola = new Queue<>();
                marcas[origen.getPosition()] = true;
                cola.enqueue(origen);
                int nivel = 0;
                while (!cola.isEmpty() && !encontre) {
                    int cant = cola.size();
                    for (int i = 0; i < cant; i++) {
                        Vertex<String> v = cola.dequeue();
                        for (Edge<String> arista: red.getEdges(v)) {
                            Vertex<String> destino = arista.getTarget();
                            if (!marcas[destino.getPosition()]) {
                                marcas[destino.getPosition()] = true;
                                cola.enqueue(destino);
                                if (limite > 0 && nivel < distancia) {
                                    Usuario u = new Usuario(destino.getData(), nivel + 1);
                                    usuarios.add(u);
                                    limite--;
                                } else {
                                    encontre = true;
                                    break;
                                }
                            }
                        }
                    }
                    nivel++;
                }
            }
        }
        return usuarios;
    }
}
