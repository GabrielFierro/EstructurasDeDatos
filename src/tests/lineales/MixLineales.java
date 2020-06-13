package tests.lineales;

import lineales.dinamicas.*;

public class MixLineales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Zona de declaración de variables
		Lista lista = new Lista();
		Lista l1 = new Lista();
		
		System.out.println("************COMIENZA LA CARGA DE LA LISTA************\n");
		System.out.println("Insertar el elemento A: " + lista.insertar('A', 1));
		System.out.println("Insertar el elemento B: " + lista.insertar('B', 2));
		System.out.println("Insertar el elemento *: " + lista.insertar('*', 3));
		System.out.println("Insertar el elemento C: " + lista.insertar('C', 4));
		System.out.println("Insertar el elemento *: " + lista.insertar('*', 5));
		System.out.println("Insertar el elemento D: " + lista.insertar('D', 6));
		System.out.println("Insertar el elemento E: " + lista.insertar('E', 7));
		System.out.println("Insertar el elemento E: " + lista.insertar('F', 8));
		
		
		l1 = generarLista(lista);
		
		System.out.println("\nMuestro la lista original: " + lista.toString());
		
		System.out.println("\nMuestro la lista generada: " + l1.toString());
		
		
	}
	public static Lista generarLista(Lista lis) {
	    /* Algoritmo que recibe una estructura de tipo Lista por par�metro con elementos de tipo Char
	     * de la forma "caracter*caracter" y retorna una lista de la forma "Caracter Caracter CaracterInvertido".
	     * En caso de que la lista sea más extensa, el formato es separado por el caracter '*'.
	     */
	    // Zona de declaraci�n de variables
	    Lista clon, nuevaLista;
	    Pila nuevaPila;
	    Cola nuevaCola;
	    Object elemento;
		int i;
	    // Zona de inicializaci�n de variables
	    clon = lis.clone();
	    nuevaLista = new Lista();
	    nuevaPila = new Pila();
	    nuevaCola = new Cola();
		i = 1;

	    while(!clon.esVacia()) {

	        elemento = clon.recuperar(1); // Recupero el primer elemento de la estructura de tipo lista

	        if(!elemento.equals('*')) {	// Si no encuentro el caracter '*' que separa cadenas
	        	nuevaPila.apilar(elemento);
	            nuevaCola.poner(elemento);
	            nuevaLista.insertar(elemento,i);
	           	clon.eliminar(1);
	           	i++;
	        }
	        else {    // Si me encuentro con el caracter '*'
				clon.eliminar(1);    // Elimino el caracter '*'
				while (!nuevaPila.esVacia()) {    // Mientras la pila no este vacia, inserto sus elementos en la lista
					elemento = nuevaPila.obtenerTope();
					nuevaLista.insertar(elemento, i);
					nuevaPila.desapilar();
					i++;
				}
				while (!nuevaCola.esVacia()) {    // Mientras la cola no este vacia, inserto sus elementos en la lista
					elemento = nuevaCola.obtenerFrente();
					nuevaLista.insertar(elemento, i);
					nuevaCola.sacar();
					i++;
				}
				nuevaLista.insertar('*', i);
				i++;
			}
	    }
	    while(!nuevaCola.esVacia()) {
	        if(!nuevaPila.esVacia()) {
				elemento = nuevaPila.obtenerTope();
				nuevaLista.insertar(elemento, i);
				nuevaPila.desapilar();
				i++;
	        }
	        else {
				elemento = nuevaCola.obtenerFrente();
				nuevaLista.insertar(elemento, i);
				nuevaCola.sacar();
				i++;
	        }
	    }
	    return nuevaLista;
	    //return nuevaLista.invertir();
	}
	public static void testGenerarLista(Lista l1){
		/* Algoritmo que recibe por parámetro una estructura de tipo Lista, y realiza pruebas para determinar
		 * si es correcta su conformación.
		 */
		// Zona de declaración de variables




	}
}
