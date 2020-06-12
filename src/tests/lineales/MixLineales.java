package tests.lineales;

import lineales.dinamicas.*;

public class MixLineales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	     * uno al lado del otro y retorna una lista de la forma "CaracterCaracterInvertidoCaracter".
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
	       
	    while(!clon.esVacia()) {
	       
	        elemento = clon.recuperar(1);
	       
	        if(!elemento.equals('*')) {
	            nuevaPila.apilar(elemento);
	            nuevaCola.poner(elemento);
	            nuevaLista.insertar(elemento,1);
	            clon.eliminar(1);
	        }
	        else {
	            clon.eliminar(1);
	            while(!nuevaPila.esVacia()) {
	                nuevaLista.insertar(nuevaPila.obtenerTope(), 1);
	                nuevaPila.desapilar();
	            }
	            while(!nuevaCola.esVacia()) {
	                nuevaLista.insertar(nuevaCola.obtenerFrente(),1);
	                nuevaCola.sacar();
	            }
	            nuevaLista.insertar('*',1);
	        }
	    }
	    while(!nuevaCola.esVacia()) {
	        if(!nuevaPila.esVacia()) {
	            elemento = nuevaPila.obtenerTope();
	            nuevaLista.insertar(elemento, 1);
	            nuevaPila.desapilar();
	        }
	        else {
	            elemento = nuevaCola.obtenerFrente();
	            nuevaLista.insertar(elemento, 1);
	            nuevaCola.sacar();
	        }
	    }
	    return nuevaLista.invertir();
	}
}
