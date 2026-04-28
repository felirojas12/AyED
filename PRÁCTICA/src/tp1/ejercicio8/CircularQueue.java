package tp1.ejercicio8;

public class CircularQueue<T> extends Queue<T> {
	public T shift() {
		T encolado = this.dequeue();
		this.enqueue(encolado);
		return encolado;
	}
}