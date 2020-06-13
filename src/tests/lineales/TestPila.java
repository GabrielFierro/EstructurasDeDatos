package tests.lineales;

import lineales.dinamicas.*;

public class TestPila {

	public static void main(String[] args) {
		// Zona de declaración de variables
		Pila unaPila, otraPila; // Declaración de un objeto de tipo Pila
		boolean resultado;
		
		unaPila = new Pila(); // Creación de un objeto de tipo Pila
		otraPila = new Pila(); // Creación de un objeto de tipo Pila
		
		System.out.println("Apilar elemento 1: " + unaPila.apilar(1));
		System.out.println("Apilar elemento 2: " + unaPila.apilar(2));
		System.out.println("Apilar elemento 3: " + unaPila.apilar(3));
		System.out.println("Apilar elemento 4: " + unaPila.apilar(4));
		System.out.println("Apilar elemento 5: " + unaPila.apilar(5));
		System.out.println("Apilar elemento 6: " + unaPila.apilar(6));
		System.out.println("Se ejecuta el metodo toString: " + unaPila.toString());
		
		System.out.println("\nObtiene tope: " + unaPila.obtenerTope());
		
		System.out.println("\nDesapilar un elemento: " + unaPila.desapilar());
		
		System.out.println("Se ejecuta el metodo toString: " + unaPila.toString());
		System.out.println("\nPila vacia: " + unaPila.esVacia());
		
		System.out.println("Apilar elemento 6: " + unaPila.apilar(6));
		
		System.out.println("\nObtiene tope: " + unaPila.obtenerTope());
		
		System.out.println("\nDesapilar un elemento: " + unaPila.desapilar());
		System.out.println("Se ejecuta el metodo toString: " + unaPila.toString());
		//System.out.println("\nSe ejecuta el metodo vaciarPila");
		
		//unaPila.vaciar();
		
		//System.out.println("\nPila vacia: " + unaPila.esVacia());
		System.out.println("Se ejecuta el metodo clonar");
		otraPila = unaPila.clone();
		
		System.out.println("Se ejecuta el metodo toString: " + otraPila.toString());
		//System.out.println("Apilar elemento 6: " + otraPila.apilar(6));
		
		System.out.println("\nObtiene tope: " + otraPila.obtenerTope());
		
		//System.out.println("\nDesapilar un elemento: " + otraPila.desapilar());
		
		//System.out.println("\nSe ejecuta el metodo vaciarPila");
		
		//otraPila.vaciar();
		
		System.out.println("\nPila vacia: " + otraPila.esVacia());
		
		System.out.println("Pila a cadena: " + otraPila.toString());
		
		resultado = verificarSecuencia(unaPila);
		
		if(resultado) {
			System.out.println("La secuencia es capicua");
		}
		else {
			System.out.println("La secuencia no es capicua");
		}
		
		
	}
public static boolean verificarSecuencia(Pila unaPila) {
	/* Algoritmo que recibe un objeto de tipo Pila por parametro, crea una pila auxiliar de tipo Pila a partir de la misma, 
	 * verifica que la misma no este vacia y luego apila en la pila auxiliar los elementos del objeto recibido por parametro.
	 * Entonces, convierte los valores de ambos objetos de tipo Pila, el recibido por parametro y el que fue creado a cadena.
	 * Por lo que compara si los valores de ambas cadenas son iguales, si son iguales la secuencia es capicua y retorna true, 
	 * en caso contrario, retorna false ya que la secuencia no es capicua.   
	 */
	// Zona de declaración de variables
	Pila nuevaPila;
	String unaPilaO, newPila;
	boolean exito;
	// Zona de inicialización de variables
	nuevaPila = new Pila();
	exito = false;
	unaPilaO = unaPila.toString();
	
	if(unaPila.esVacia()==false) {

		do {
			nuevaPila.apilar(unaPila.obtenerTope());
		}while(unaPila.desapilar());
		
	}
	newPila = nuevaPila.toString();
	
	if(unaPilaO.equals(newPila)) {
		exito = true;
	}
	return exito;
}
}
