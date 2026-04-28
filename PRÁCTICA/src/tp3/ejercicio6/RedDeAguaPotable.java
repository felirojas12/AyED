package tp3.ejercicio6;
import tp3.ejercicio1.GeneralTree;
import java.util.*;

public class RedDeAguaPotable {
	private GeneralTree<Character> RedAguaPotable;
	
	public RedDeAguaPotable() {
		RedAguaPotable = new GeneralTree<Character>();
	}
	
	public RedDeAguaPotable(GeneralTree<Character> RedAguaPotable) {
		this.RedAguaPotable = RedAguaPotable;
	}
	public double minimoCaudal(double caudal) {
		if ((this.RedAguaPotable == null) || (this.RedAguaPotable.isEmpty())) return 0;
		return recursion(this.RedAguaPotable,caudal);
	}
	
	private double recursion(GeneralTree<Character> arbol, double caudal) {
		if (arbol.isLeaf()) return caudal;
		List<GeneralTree<Character>> children = arbol.getChildren();
		int size = children.size();
		double min = Double.MAX_VALUE;
		for (GeneralTree<Character> child : children)
			min = Math.min(recursion(child,caudal/size), min);
		return min;
	}
	
	public static GeneralTree<Character> crearArbolEjemplo() {
		// Nivel hojas
		GeneralTree<Character> B = new GeneralTree<>('B');
		GeneralTree<Character> F = new GeneralTree<>('F');
		GeneralTree<Character> L = new GeneralTree<>('L');
		GeneralTree<Character> H = new GeneralTree<>('H');
		GeneralTree<Character> I = new GeneralTree<>('I');
		GeneralTree<Character> K = new GeneralTree<>('K');
		GeneralTree<Character> P = new GeneralTree<>('P');
		GeneralTree<Character> M = new GeneralTree<>('M');
		GeneralTree<Character> N = new GeneralTree<>('N');

		List<GeneralTree<Character>> hijosG = new LinkedList<>();
		hijosG.add(L);
		GeneralTree<Character> G = new GeneralTree<>('G', hijosG);

		List<GeneralTree<Character>> hijosC = new LinkedList<>();
		hijosC.add(F);
		hijosC.add(G);
		GeneralTree<Character> C = new GeneralTree<>('C', hijosC);

		List<GeneralTree<Character>> hijosJ = new LinkedList<>();
		hijosJ.add(M);
		hijosJ.add(N);
		GeneralTree<Character> J = new GeneralTree<>('J', hijosJ);

		List<GeneralTree<Character>> hijosD = new LinkedList<>();
		hijosD.add(H);
		hijosD.add(I);
		hijosD.add(J);
		hijosD.add(K);
		hijosD.add(P);
		GeneralTree<Character> D = new GeneralTree<>('D', hijosD);

		GeneralTree<Character> E = new GeneralTree<>('E');

		List<GeneralTree<Character>> hijosA = new LinkedList<>();
		hijosA.add(B);
		hijosA.add(C);
		hijosA.add(D);
		hijosA.add(E);
		GeneralTree<Character> A = new GeneralTree<>('A', hijosA);

		return A;
	}
}
