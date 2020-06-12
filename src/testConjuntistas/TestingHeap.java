package testConjuntistas;

import conjuntistas.Heap;

public class TestingHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Heap arbol, clon;
		arbol = new Heap();
		clon = new Heap();
		
		/*	SE INSERTAN ELEMENTOS EN LA ESTRUCTURA	*/
		System.out.println("\nSe inserta el elemento 1: " + arbol.insertar(1));
		System.out.println("\nSe inserta el elemento 2: " + arbol.insertar(2));
		System.out.println("\nSe inserta el elemento 3: " + arbol.insertar(3));
		System.out.println("\nSe inserta el elemento 4: " + arbol.insertar(4));
		System.out.println("\nSe inserta el elemento 5: " + arbol.insertar(5));
		System.out.println("\nSe inserta el elemento 6: " + arbol.insertar(6));
		System.out.println("\nSe inserta el elemento 7: " + arbol.insertar(7));
		System.out.println("\nSe inserta el elemento 8: " + arbol.insertar(8));
		System.out.println("\nSe inserta el elemento 9: " + arbol.insertar(9));
		System.out.println("\nSe inserta el elemento 10: " + arbol.insertar(10));
		System.out.println("\nSe inserta el elemento 11: " + arbol.insertar(11));
		System.out.println("\nSe inserta el elemento 12: " + arbol.insertar(12));
		
		System.out.println("\nSe muestran los elementos de la estructura árbol heap mínimo: " + arbol.toString());
		
		/* SE ELIMINAN ELEMENTOS DE LA CIMA	*/
		System.out.println("\nSe recupera el elemento de la cima: " + arbol.recuperarCima());
		
		System.out.println("\nSe muestran los elementos de la estructura árbol heap mínimo: " + arbol.toString());
		
		System.out.println("\nSe ejecuta el método clone: ");
		
		clon = arbol.clone();
		
		System.out.println("\nArbol original: " + arbol.toString());
		
		System.out.println("\nArbol clon: " + clon.toString());
		
		System.out.println("\nSe elimina el elemento de la cima: " + arbol.eliminarCima());
		
		System.out.println("\nSe muestra la estructura del arbol: " + arbol.toString());
		
		
	}
	
}
