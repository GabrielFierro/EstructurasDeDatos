package testJerarquicas;

import jerarquicas.*;
import lineales.dinamicas.Lista;

public class TestArbolBin {

	public static void main(String[] args) {
		// Zona de declaración de variables
		ArbolBin arbol, clon;
		char lugarI;
		char lugarD;
		int res;
		// Zona de inicialización de variables
		arbol = new ArbolBin();
		clon = new ArbolBin();
		lugarI = 'I';
		lugarD = 'D';
		
		Lista l1 = new Lista();
		Lista l2 = new Lista();
		
		System.out.println("Se agregará la raíz 1: " + arbol.insertar(1, null, lugarI));
		
		System.out.println("Se agregará el elemento 2 como hijo izquierdo de 1: " + arbol.insertar(2, 1, lugarI));
		
		System.out.println("Se agregará el elemento 3 como hijo izquierdo de 2: " + arbol.insertar(3, 2, lugarI));
		
		System.out.println("Se agregará el elemento 4 como hijo derecho de 1: " + arbol.insertar(4, 1, lugarD));
		
		System.out.println("Se agregará el elemento 5 como hijo izquierdo de 4: " + arbol.insertar(5, 4, lugarI));
	
		System.out.println("Se agregará el elemento 6 como hijo derecho de 4: " + arbol.insertar(6, 4, lugarD));
		
		System.out.println("Se agregará el elemento 7 como hijo izquierdo de 5: " + arbol.insertar(7, 5, lugarI));
		
		System.out.println("Se agregará el elemento 8 como hijo derecho de 5: " + arbol.insertar(8, 5, lugarD));
		
		
		
		/*
		
		System.out.println("Se muestran los elementos de la estructura en preorden\n");
		arbol.preorden();
		
		clon = arbol.clone();
		
		System.out.println("Se muestran los elementos de la estructura en preorden\n");
		
		clon.preorden();
		
		System.out.println("\nListar elementos de un arbol: \n" + arbol.toString());
		
		System.out.println("Se ejecuta el método padre: \n" + "\nElemento: 1" + "\tPadre: " + arbol.padre(1));
		System.out.println("\nSe ejecuta el método padre: \n" + "Elemento: 2" + "\tPadre: " + arbol.padre(2));
		System.out.println("\nSe ejecuta el método padre: \n" + "Elemento: 3" + "\tPadre: " + arbol.padre(3));
		System.out.println("\nSe ejecuta el método padre: \n" + "Elemento: 4" + "\tPadre: " + arbol.padre(4));
		System.out.println("\nSe ejecuta el método padre: \n" + "Elemento: 0" + "\tPadre: " + arbol.padre(0));
		System.out.println("\nSe ejecuta el método padre: \n" + "Elemento: 6" + "\tPadre: " + arbol.padre(6));
		*/
		//System.out.println("\nListar elementos de un arbol en preOrden: \n" + arbol.listarPreorden().toString());
		
		
		/*System.out.println("\nSe ejecuta el método vaciar(): ");
		
		arbol.vaciar();
		
		System.out.println("\nSe ejecuta el método altura sobre arbol: ");
		
		res = arbol.altura();
		
		System.out.println("\nLa altura del arbol es: " + res);
		
		*/
		//System.out.println("\nListar los elementos de un arbol en posOrden: \n" + arbol.listarPosorden().toString());
		
		
		
		System.out.println("\nListar elementos de un arbol en InOrden: \n" + arbol.listarInorden().toString());
		
		System.out.println("\nListar elementos de un arbol en PosOrden: \n" + arbol.listarPosorden().toString());
		
		System.out.println("\nListar elementos de un arbol por niveles: \n" + arbol.listarPorNiveles().toString());
		
	}
}
