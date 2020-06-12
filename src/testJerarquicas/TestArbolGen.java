package testJerarquicas;

import jerarquicas.*;
import lineales.dinamicas.Lista;

public class TestArbolGen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolGen arbol, a;
		Lista l;
		boolean valor;
		
		valor = false;
		arbol = new ArbolGen();
		a = new ArbolGen();
		l = new Lista();
		
		System.out.println("\nSe agregará la raíz 1: " + arbol.insertar(1, null));
		
		System.out.println("\nSe agregará el elemento 2 como hijo izquierdo de 1: " + arbol.insertar(2, 1));
		
		System.out.println("\nSe agregará el elemento 3 como hermano de 2: " + arbol.insertar(3, 1));
		
		System.out.println("\nSe agregará el elemento 4 como hermano de 2: " + arbol.insertar(4, 1));
		
		System.out.println("\nSe agregará el elemento 5 como hijo izquierdo de 2: " + arbol.insertar(5, 2));
		
		System.out.println("\nSe agregará el elemento 6 como hermano de 5: " + arbol.insertar(6, 2));
		
		System.out.println("\nSe agregará el elemento 7 como hermano de 6: " + arbol.insertar(7, 2));
		
		System.out.println("\nSe agregará al elemento 8 como hijo izquierdo de 4: " + arbol.insertar(8, 4));
		
		System.out.println("\nSe agregará el elemento 9 como hijo izquierdo de 8: " + arbol.insertar(9, 8));
		
		System.out.println("\nSe agregará el elemento 10 como hijo izquierdo de 9: " + arbol.insertar(10, 9));
		
	/*	System.out.println("\nSe muestran los elementos del árbol generico:\n" + arbol.toString());
		
		System.out.println("\nSe ejecutará el método pertenece con el elemento 3: " + arbol.pertenece(3));
		
		System.out.println("\nSe ejecuta el método altura: " + arbol.altura());
		
		System.out.println("\nSe ejecuta el método nivel con el elemento 10: " + arbol.nivel(10));
		
		System.out.println("\nSe ejecuta el método obtenerPadre del elemento 10: " + arbol.padre(10));
	
		System.out.println("\nSe ejecuta el método ancestros con el elemento 8");
		
		l = arbol.ancestros(8);
		
		System.out.println("\nSe muestran los elementos de la lista: " + l.toString());
		
		System.out.println("\nSe ejecuta el método listarPreorden: " + arbol.listarPreorden());
		
		System.out.println("\nSe ejecuta el método listarInorden: " + arbol.listarInorden());
		
		System.out.println("\nSe ejecuta el método listarPosorden: " + arbol.listarPosorden());
		
		System.out.println("\nSe ejecuta el metodo listarNiveles: " + arbol.listarNiveles());
		
		System.out.println("\nSe ejecuta el método nivel con el elemento 2: " + arbol.nivel(2) + "=1");
		System.out.println("\nSe ejecuta el método nivel con el elemento 3: " + arbol.nivel(3) + "=1");
		System.out.println("\nSe ejecuta el método nivel con el elemento 4: " + arbol.nivel(4) + "=1");
		System.out.println("\nSe ejecuta el método nivel con el elemento 5: " + arbol.nivel(5) + "=2");
		System.out.println("\nSe ejecuta el método nivel con el elemento 6: " + arbol.nivel(6) + "=2");
		System.out.println("\nSe ejecuta el método nivel con el elemento 7: " + arbol.nivel(7) + "=2");
		System.out.println("\nSe ejecuta el método nivel con el elemento 8: " + arbol.nivel(8) + "=2");
		System.out.println("\nSe ejecuta el método nivel con el elemento 9: " + arbol.nivel(9) + "=3");
		System.out.println("\nSe ejecuta el metodo nivel con el elemento 10: " + arbol.nivel(10) + "=4");
		
		System.out.println("\n\t\tCASO ESPECIAL: RAIZ");
		System.out.println("Se ejecuta el método nivel con el elemento raiz 1: " + arbol.nivel(1) + "=0");
		System.out.println("\n\t\tCASO ESPECIAL: Elemento que no pertenece");
		System.out.println("Se ejecuta el metodo nivel con el elemento inexistente 0: " + arbol.nivel(0) + "=-1");
		*/
		
		System.out.println("\nSe ejecuta el metodo clonar: ");
		
		a = arbol.clone();
		
		System.out.println("\nArbol original: " + arbol.toString());
		
		System.out.println("\nClon: " + a.toString());
	
		
		
		System.out.println("\nSe ejecuta el metodo ancestros: " + arbol.ancestros(5));
		
		
		
	}


}
