package tp3.ejercicio1;
import java.util.LinkedList;
import java.util.List;
import tp1.ejercicio8.Queue;


public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {
		return (!this.isEmpty()) ? alturaRecursion() : -1;
	} 
		    
	private int alturaRecursion() {
		if(this.isLeaf()) return 0;
		else {
			int alturaMax = -1;
		    List<GeneralTree<T>> children = this.getChildren();
		    for(GeneralTree<T> child: children) {
		    	alturaMax = Math.max(alturaMax, child.alturaRecursion());
		    }
		        return alturaMax + 1;
		}
	}
	
	public int nivel(T dato) {
	    if (!this.isEmpty()) { //cuando instancio un objeto nunca puede valer null. solo se chequea si esta vacio
		    Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		    cola.enqueue(this);
		    int nivel = 0;
		    while (!cola.isEmpty()) {
		        int size = cola.size(); // cantidad de nodos en este nivel
		        for (int i = 0; i < size; i++) {
		            GeneralTree<T> nodo = cola.dequeue();
		            if (nodo.getData().equals(dato)) {
		                return nivel;
		            }
		            for (GeneralTree<T> hijo : nodo.getChildren()) {
		                cola.enqueue(hijo);
		            }
		        }
		        nivel++;
		    }
	    }
	    return -1; // no lo encontró
	}

	public int ancho(){
	    int max = -1;
		if (!this.isEmpty()) { ////cuando instancio un objeto nunca puede valer null. solo se chequea si esta vacio
		    Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		    cola.enqueue(this);
		    while (!cola.isEmpty()) {
		        int size = cola.size();
		        max = Math.max(max, size);
		        for (int i = 0; i < size; i++) {
		            GeneralTree<T> nodo = cola.dequeue();
		            for (GeneralTree<T> hijo : nodo.getChildren()) {
		                cola.enqueue(hijo);
		            }
		        }
		    }
	    }
		return max;
	}
	
	public boolean esAncestro(T a, T b) {
		GeneralTree<T> subArbol = encontrarNodo(this,a);
		return encontre(subArbol, b);
	}
	
	private GeneralTree<T> encontrarNodo(GeneralTree<T> arbol, T a) {
		if ((arbol == null) || (arbol.isEmpty())) return null;
		if (arbol.getData().equals(a)) return arbol;
		else {
			for (GeneralTree<T> child : arbol.getChildren()) {
				GeneralTree<T> aux = encontrarNodo(child,a);
				if (aux != null) return aux;
			}	
		}
		return null;
	}
	
	private boolean encontre(GeneralTree<T> arbol, T b) {
		if (arbol == null) return false;
		if (arbol.getData().equals(b)) return true;
		else {
			for (GeneralTree<T> child : arbol.getChildren())
				if (encontre(child,b)) return true;
		}
		return false;
	}
}