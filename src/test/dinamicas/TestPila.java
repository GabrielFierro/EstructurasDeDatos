package test.dinamicas;

import lineales.dinamicas.Pila;

public class TestPila {

	public static void main(String[] args) {
		// Zona de declaración de variables
		Object elem1 = 1;
		Object elem2 = 2;
		Object elem3 = 3;
		Pila unaPila = new Pila();
		Object unElemento;
		Pila otraPila = new Pila();
		
		unaPila.apilar(elem1);
		unaPila.apilar(elem2);
		unaPila.apilar(elem3);
		
		mostrar(unaPila);
		/*
		unaPila.desapilar();
		
		mostrar(unaPila);
		
		unElemento = unaPila.obtenerTope();
		
		System.out.println("Elemento: " + unElemento.toString()); 
		
		unaPila.desapilar();
		
		mostrar(unaPila);
		
		unElemento = unaPila.obtenerTope();
		
		System.out.println("Elemento: " + unElemento.toString()); 
		
		unaPila.vaciar(); // Invocación del metodo vaciar pila
		
		mostrar(unaPila);
		*/
		System.out.println("Se ejecuta el metodo clonar");
		otraPila = unaPila.clone();
		
		mostrar(otraPila);
		
	}
	public static void mostrar(Pila unaPila) {
		System.out.println(unaPila.toString());
	}
}
