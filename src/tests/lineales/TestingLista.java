package tests.lineales;

import lineales.dinamicas.*;

public class TestingLista {

	public static void main(String[] args) {
		// Zona de declaraci�n de variables
		Lista lista1, lista2;
		Lista nuevaLista;
		boolean valor;
		int longitud;
		String resultado;
		// Zona de inicializaci�n de variables
		lista1 = new Lista();
		lista2 = new Lista();
		nuevaLista = new Lista();
		longitud = 0;
		resultado = "";
		valor = false;
		
		System.out.println("Se insertar�n elementos en la lista 1\n");
		
		System.out.println("Insertar el elemento 2 en la posici�n 1: " + lista1.insertar(2,1));
		System.out.println("Insertar el elemento 4 en la posici�n 2: " + lista1.insertar(4,2));
		System.out.println("Insertar el elemento 6 en la posici�n 3: " + lista1.insertar(6,3));
		
		System.out.println("\nSe insertar�n elementos en la lista 2\n");
		
		System.out.println("Insertar el elemento 5 en la posici�n 1: " + lista2.insertar(5,1));
		System.out.println("Insertar el elemento 1 en la posici�n 2: " + lista2.insertar(1,2));
		System.out.println("Insertar el elemento 6 en la posici�n 3: " + lista2.insertar(6,3));
		System.out.println("Insertar el elemento 7 en la posici�n 4: " + lista2.insertar(7,4));
		
		System.out.println("\nMostrar elementos de lista1: " + lista1.toString());
		System.out.println("\nMostrar elementos de lista2: " + lista2.toString());
		
		System.out.println("Se ejecuta el m�todo concatenar");
		nuevaLista = concatenar(lista1,lista2);
		System.out.println("\nSe muestra la concatenaci�n de dos listas: 2,4,6,5,1,6,7" );
		System.out.println(nuevaLista.toString());
		
		System.out.println("Se ejecutar� el m�todo vaciar sobre la lista1: ");
		lista1.vaciar();
		
		System.out.println("\nSe insertar�n elementos en la lista 1");
		
		System.out.println("Insertar el elemento 9 en la posici�n 1: " + lista1.insertar(9,1));
		System.out.println("Insertar el elemento 6 en la posici�n 2: " + lista1.insertar(6,2));
		System.out.println("Insertar el elemento 5 en la posici�n 3: " + lista1.insertar(5,3));
		System.out.println("Insertar el elemento 0 en la posici�n 4: " + lista1.insertar(0,4));
		System.out.println("Insertar el elemento 9 en la posici�n 5: " + lista1.insertar(9,5));
		System.out.println("Insertar el elemento 6 en la posici�n 6: " + lista1.insertar(6,6));
		System.out.println("Insertar el elemento 5 en la posici�n 7: " + lista1.insertar(5,7));
		System.out.println("Insertar el elemento 0 en la posici�n 8: " + lista1.insertar(0,8));
		System.out.println("Insertar el elemento 5 en la posici�n 9: " + lista1.insertar(5,9));
		System.out.println("Insertar el elemento 6 en la posici�n 10: " + lista1.insertar(6,10));
		System.out.println("Insertar el elemento 9 en la posici�n 11: " + lista1.insertar(9,11));
		
		System.out.println(lista1.toString());
		
		valor = comprobar(lista1);
		
		System.out.println("Se ejecutar� el m�todo vaciar sobre la lista1: ");
		lista1.vaciar();
		
		System.out.println("\nSe insertar�n elementos en la lista1: ");
		System.out.println("Insertar el elemento 2 en la posici�n 1: " + lista1.insertar(2,1));
		System.out.println("Insertar el elemento 4 en la posici�n 2: " + lista1.insertar(4,2));
		System.out.println("Insertar el elemento 6 en la posici�n 3: " + lista1.insertar(6,3));
		
		longitud = lista1.longitud();
		nuevaLista = invertir(lista1, longitud);
		
		System.out.println("Mostrar lista invertida: 6,4,2 " + nuevaLista.toString());
		
		
	}
	public static Lista concatenar(Lista lista1, Lista lista2) {
		/* Algoritmo que recibe por par�metro dos listas de tipo Lista junto a la longitud total de ambas listas, y en forma recursiva,
		 * concatena los valores de la lista1 y la lista2, y retorna el resultado.
		 */
		// Zona de declaraci�n de variables
		int i, longitud1, longitud2, aux;
		Lista nuevaLista;
		Object elem;
		// Zona de declaraci�n de variables
		nuevaLista = new Lista();
		i = 1;
		aux = 1;
		longitud1 = lista1.longitud();
		longitud2 = lista2.longitud();
		
		// Concatena los valores de lista1
		while(i<=longitud1) {
			elem = lista1.recuperar(i);
			nuevaLista.insertar(elem, i);
			i++;
		}
		// Concatena los valores de lista2
		while(aux<=longitud2) {
			elem = lista2.recuperar(aux);
			nuevaLista.insertar(elem, i);
			i++;
			aux++;
		}
		
		return nuevaLista;
	}
	public static boolean comprobar(Lista unaLista) {
		/* Algoritmo que recibe una estructura de tipo lista por par�metro y comprueba si la misma posee cadenas de valores,
		 * junto a su cadena inversa dentro de la misma estructura.
		 */
		// Zona de declaraci�n de variables 
		String cadena, cadenaInv;
		boolean valor;
		int longitud, i;
		Pila nuevaPila;
		Cola nuevaCola;
		Object num;
		// Zona de declaraci�n de variables
		cadena = "";
		cadenaInv = "";
		valor = false;
		longitud = unaLista.longitud();
		i = 1;
		nuevaPila = new Pila();
		nuevaCola = new Cola();
		num = 0;
		
		while(i <= longitud) {
			nuevaPila.apilar(unaLista.recuperar(i));
			nuevaCola.poner(unaLista.recuperar(i));
			i++;
		}
		i = 1;
		while(unaLista.recuperar(i) != num) {
			cadena = cadena + unaLista.recuperar(i);
			i++;
		}
		System.out.println("Cadena: " + cadena);
		return valor;
		
		
	}
	public static Lista invertir(Lista unaLista, int longitud) {
		/* Algoritmo que recibe una estructura de tipo Lista por par�metro, crea una lista nueva y le asigna los elementos
		 * de la lista recibida por par�metro en orden inverso. Por lo que retorna una lista con los valores invertidos con respecto
		 * a la recibida por par�metro
		 */
		// Zona de declaraci�n de variables
		Lista nuevaLista;
		Object elem;
		// Zona de inicializaci�n de variables
		nuevaLista = new Lista();
		elem = new Object();
		
		if(longitud == 1) {
			elem = unaLista.recuperar(longitud);
			nuevaLista.insertar(elem, longitud);
		}
		else {
			nuevaLista = invertir(unaLista, longitud-1);
			elem = unaLista.recuperar(longitud); 
			nuevaLista.insertar(elem, longitud);
		}
		return nuevaLista;	
	}
	
}
