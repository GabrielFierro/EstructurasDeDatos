package test.dinamicas;

import lineales.dinamicas.*;;

public class TestCola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cola unaCola = new Cola();
		Cola clon = new Cola();
		
		System.out.println("Agregar el elemento 1: " + unaCola.poner(1));
		System.out.println("Agregar el elemento 2: " + unaCola.poner(2));
		System.out.println("Agregar el elemento 3: " + unaCola.poner(3));
		
		mostrar(unaCola);
		
		//System.out.println("\nSe ejecuta el método vaciar: ");
		
		//unaCola.vaciar();
		
		//mostrar(unaCola);
		
		System.out.println("\nSacar un elemento: " + unaCola.sacar());
		
		mostrar(unaCola);
		
		System.out.println("\nSe ejecuta el metodo esVacia: " + unaCola.esVacia());
		
		mostrar(unaCola);
		
		System.out.println("\nSe ejecuta el metodo clonar: ");
		
		clon = unaCola.clone();
		
		System.out.println("\nCola original: ");
		mostrar(unaCola);
		System.out.println("\nClon");
		mostrar(clon);
		
	}
	public static void mostrar(Cola unaCola) {
		System.out.println(unaCola.toString());
	}
}
