package tests.lineales;

import java.net.StandardSocketOptions;
import java.util.Scanner;

import lineales.dinamicas.*;

public class TestLineales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lista lista = new Lista();
		Cola cola = new Cola();
		int objetivo, longitud;
		int[] array = {2,7,11,15};
		boolean resultado;
		longitud = array.length-1;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nIngrese un n�mero como objetivo");
		objetivo = sc.nextInt();
		
		resultado = buscarObjetivo(array, longitud, objetivo);
		
		if(resultado) {
			System.out.println("\nSe cumple con el objetivo: " + objetivo);
		}
		else {
			System.out.println("\nNo se cumple con el objetivo: " + objetivo);
		}
				
		
		System.out.println("\n**********SE INSERTAN ELEMENTOS EN LA LISTA**********");
		
		lista.insertar('a', 1);
		lista.insertar('b', 2);
		lista.insertar('c', 3);
		lista.insertar('d', 4);
		lista.insertar('e', 5);
		lista.insertar('f', 6);
		lista.insertar('g', 7);
		lista.insertar('h', 8);
		lista.insertar('i', 9);
		lista.insertar('j', 10);
		
		System.out.println("Se muestra la lista: " + lista.toString());
		
		System.out.println("\nSe ejecuta el metodo listaToCola: ");
		
		System.out.println("\nSe muestra la cola: " + cola.toString());
		
		cola = listaToCola(2, lista);
		
		System.out.println("\nSe muestra la cola: " + cola.toString());
		
	}
public static boolean buscarObjetivo(int[] array, int longitud, int objetivo) {
		/* Algoritmo que dado un arreglo de tipo int, una longitud de tipo int, y un valor de tipo entero, determina
		* si la suma de dos elementos que se encuentran en el arreglo dan como resultado el mismo valor que posee la
		* variable objetivo. Retorna true en caso afirmativo y false en caso contrario.
		 */
		int i, j, aux;
		boolean resultado;
		resultado = false;
		for(i=0; i<=longitud; i++) {
			aux = array[i];
			for(j=0; j<=longitud; j++) {
				if(aux != array[j] && aux+array[j] == objetivo) {
					resultado = true;
				}
			}
		}
		return resultado;
	}
public static Cola listaToCola(int t, Lista lista) {
	/* Algoritmo que recibe por parametro una un numero entero t y una estructura Lista con una sucesion de caracteres
	 * (ingresados como tipo char de Java), y construye una estructura de tipo Cola con el formato
	 * "cadenacadena'cadena'".
	 */
	// Zona de declaraci�n de variables
	Lista clon;
	Cola cola, colaNueva;
	Pila pila, aux;
	int cont;
	Object elem;
	// Zona de inicializaci�n de variables
	clon = lista.clone();
	cola = new Cola();
	colaNueva = new Cola();
	pila = new Pila();
	aux = new Pila();
	cont = 0;
	elem = null;
	
	while(!clon.esVacia()) {
		
		if(cont < t) {
			elem = clon.recuperar(1);
			colaNueva.poner(elem);
			pila.apilar(elem);
			aux.apilar(elem);
			clon.eliminar(1);
			cont++;
		}
		else {
			while(!pila.esVacia()) {
				elem = pila.obtenerTope();
				colaNueva.poner(elem);
				pila.desapilar();
			}
			
			while(!aux.esVacia()) {
				elem = aux.obtenerTope();
				colaNueva.poner(elem);
				aux.desapilar();
			}
			colaNueva.poner('&');
			colaNueva.poner('&');
			cont = 0;
		}
	}
	while(!aux.esVacia()) {	// Saca los �ltimos elementos almacenados en las estructuras de tipo Pila
		if(!pila.esVacia()) {
			elem = pila.obtenerTope();
			colaNueva.poner(elem);
			pila.desapilar();
		}
		else {
			elem = aux.obtenerTope();
			colaNueva.poner(elem);
			aux.desapilar();
		}
	}
	return colaNueva;	
}
}
