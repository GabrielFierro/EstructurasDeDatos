package tests.lineales;

import lineales.estaticas.*;

public class TestingCola {

	public static void main(String[] args) {
		// Zona de declaración de variables
		Cola unaCola, otraCola;
		// Zona de inicialización de variables
		unaCola = new Cola();
		otraCola = new Cola();
		
		System.out.println("Agregar el elemento 1: " + unaCola.poner(1));
		System.out.println("Agregar el elemento 2: " + unaCola.poner(2));
		System.out.println("Agregar el elemento 3: " + unaCola.poner(3));
		System.out.println("Agregar el elemento 4: " + unaCola.poner(4));
		
		System.out.println("Recupera frente con 1: " + unaCola.obtenerFrente());
		
		System.out.println("\nSe ejecuta el método esVacia: " + unaCola.esVacia());
		mostrar(unaCola);
		
		System.out.println("\nSacar el elemento 1: " + unaCola.sacar());
		mostrar(unaCola);
		
		System.out.println("\nAgregar elemento 5: " + unaCola.poner(5));
		mostrar(unaCola);
		System.out.println("\nAgregar elemento 6: " + unaCola.poner(6));
		mostrar(unaCola);
		System.out.println("\nAgregar elemento 7: " + unaCola.poner(7));
		
		mostrar(unaCola);
		
		/*System.out.println("\nSe ejecuta el método vaciar");
		unaCola.vaciar();
		
		System.out.println("\nSe ejecuta el método esVacia: " + unaCola.esVacia());
		
		mostrar(unaCola);
		*/
		
		System.out.println("\nSe ejecuta el método clonar");
		otraCola = unaCola.clone();
		System.out.println("Cola original");
		mostrar(unaCola);
		System.out.println("Cola clonada");
		mostrar(otraCola);
		
		System.out.println("\nSe ejecuta el método vaciar"); 
		unaCola.vaciar();
		
		System.out.println("Se ejecuta el método esVacia: " + unaCola.esVacia());
		
		mostrar(unaCola);
		
		System.out.println("\nSe ejecuta el método vaciar"); 
		unaCola.vaciar();
		
		mostrar(unaCola);
		
	}
public static void mostrar(Cola unaCola) {
	/*
	 * 
	 */
	System.out.println("\n"+unaCola.toString());
	
}
}
