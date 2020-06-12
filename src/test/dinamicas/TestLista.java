package test.dinamicas;

import lineales.dinamicas.*;

public class TestLista {

	public static void main(String[] args) {
		// Zona de declaración de variables
		Nodo unNodo = new Nodo();
		Lista unaLista = new Lista();
		Lista nuevaLista = new Lista();
		int longitud;
		

		System.out.println("Agregar el elemento 1 en la posicion 1: " + unaLista.insertar(1, 1));
		System.out.println("Agregar el elemento 2 en la posicion 2: " + unaLista.insertar(2, 2));
		System.out.println("Agregar el elemento 3 en la posicion 3: " + unaLista.insertar(3, 3));
		System.out.println("Agregar el elemento 4 en la posicion 4: " + unaLista.insertar(4, 4) + "\n");
		//System.out.println("Agregar el elemento 3 en la posicion 3: " + unaLista.insertar(5, 3));
		//System.out.println("\nLa longitud de la lita es: " + unaLista.longitud());
		
		System.out.println("\nSe ejecuta el método localizar buscando el elemento 4: " + unaLista.localizar(4));
		mostrar(unaLista);
		
		System.out.println("\nSe ejecuta el método localizar buscando el elemento 1: " + unaLista.localizar(1));
		mostrar(unaLista);
		/*
		System.out.println("\nSe ejecuta el método vaciar: ");
		unaLista.vaciar();
		mostrar(unaLista);
		
		
		System.out.println("\nSe ejecuta el metodo clonar: ");
		nuevaLista = unaLista.clone();
		System.out.println("Lista original: ");
		mostrar(unaLista);
		System.out.println("Lista clone: " );
		mostrar(nuevaLista);
		
		/*
		System.out.println("\nSe ejecuta el método recuperar (elemento 4, posicion 4): " + unaLista.recuperar(4));
		mostrar(unaLista);
		
		System.out.println("\nSe ejecuta el método recuperar (elemento 1, posicion 1): " + unaLista.recuperar(1));
		mostrar(unaLista);
		
		System.out.println("\nSe ejecuta el método recuperar (elemento 0, posicion 0): " + unaLista.recuperar(0));
		mostrar(unaLista);
		
		System.out.println("\nEliminar el elemento de la posicion 4: " + unaLista.eliminar(4) + "\n");
		mostrar(unaLista);
		System.out.println("\nLa longitud de la lita es: " + unaLista.longitud());
		System.out.println("\nEliminar el elemento de la posicion 1: " + unaLista.eliminar(1));
		mostrar(unaLista);
		System.out.println("\nEliminar el elemento de la posicion 4: " + unaLista.eliminar(4));
		System.out.println("Eliminar el elemento de la posicion 0: " + unaLista.eliminar(0) + "\n");
		mostrar(unaLista);
		System.out.println("\nEliminar el elemento de la posicion 1: " + unaLista.eliminar(1) + "\n");
		mostrar(unaLista);
		System.out.println("\nEliminar el elemento de la posicion 1: " + unaLista.eliminar(1)+ "\n");
		mostrar(unaLista);
		System.out.println("\nEliminar el elemento de la posicion 1: " + unaLista.eliminar(1));
		mostrar(unaLista);
		
		System.out.println("\nLa longitud de la lita es: " + unaLista.longitud());
		
		*/
		
		System.out.println("\nSe ejecuta el método invertirLista: " + unaLista.invertir());
		
		//System.out.println(unaLista.toString());
		
		
	}
public static void mostrar(Lista unaLista) {
	System.out.println(unaLista.toString());
}
}
