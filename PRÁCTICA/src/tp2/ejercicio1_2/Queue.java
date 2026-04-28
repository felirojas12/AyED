package tp2.ejercicio1_2;
import java.util.*;

public class Queue<T> extends Sequence {
	List <T> data;
	public Queue() {
		data = new LinkedList<T>();
	}
	public void enqueue(T dato) {
		data.add(dato);
	}
	public T dequeue() {
		return data.removeFirst();
	}
	public T head() {
		return data.getFirst();
	}
	public int size() {
		return data.size();
	}
	public boolean isEmpty() {
		return data.size() == 0;
	}
	public String toString() {
		String str = "[";
		for(T d: data)
			str = str + d +", ";
		str = str.substring(0, str.length()-2)+"]";
		return str;
	}
}