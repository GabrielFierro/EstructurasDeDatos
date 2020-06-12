package lineales.dinamicas;

import lineales.dinamicas.Pila;

public class Pila {
	/* Creación de la clase Pila de tipo dinámica de tamaño dinámico
	 */
	// Zona de declaración de atributos
	private Nodo tope;
	
	// Método Constructor
	public Pila() {
		this.tope = null;
	}
	
	public boolean apilar(Object unElemento) {
		/* Metodo que recibe un elemento de tipo Object por parámetro, evalúa si puede colocar en el tope
		 * dicho elemento. En caso de ser posible, retorna true, caso contrario donde la pila esta llena retorna false.
		 */
		
		// Crea un nuevo nodo delante de la antigua cabecera
		Nodo unNodo = new Nodo(unElemento, this.tope);
		
		// Actualiza el tope para que apunte al nuevo nodo
		this.tope = unNodo;	
		
		// Nunca hay error de pila llena, entonces devuelve true
		return true;
	}
	
	public boolean desapilar() {
		/* A
		 * 
		 */
		// Zona de declaración de variables
		boolean exito;
		// Zona de inicialización de variables
		exito = false;
		
		if(this.tope != null) {
			
			Nodo aux = this.tope;			
			if(aux != null) {
				this.tope = this.tope.getEnlace();
				exito = true;
			}
		}
		return exito;
	}
		
	public Object obtenerTope() {
		
		// Zona de declaración de variables
		Object aux;
		// Zona de inicialización de variables
		aux = new Object();
		
		if(this.tope != null) {
			aux = this.tope.getElemento(); 
		}
		else {
			aux = null;
		}
		return aux;
	}
	
	public boolean esVacia() {
		
		boolean exito;
		
		exito = false;
		
		if(this.tope == null) {
			exito = true;
		}
		
		return exito;
	}
	
	public void vaciar() {
		//
		if(this.tope != null) {
			this.tope = null;
		}
		
	}
	
	public Pila clone() {
		/* Algoritmo que crea un nodo por cada elemento de la estructura de tipo Pila original
		 * 
		 */
		// Zona de declaración de variables
		Pila nuevaPila;
		Nodo aux;
		// Zona de inicialización de variables
		aux = new Nodo();
		nuevaPila = new Pila();
		
		if(this.tope != null) {
			if(this.tope.getEnlace() == null) {
				nuevaPila = new Pila();
				nuevaPila.tope = this.tope;
			}
			else {
				nuevaPila = new Pila();
				aux = this.tope.getEnlace();
				nuevaPila.tope = aux;
				nuevaPila.clone();
				nuevaPila.tope = this.tope;
			}
		}
		return nuevaPila;
	}
	
	@Override
	public String toString() {
		// Zona de declaración de variables
		String s = "";
		
		if(this.tope == null) {
			s = "Pila vacia";
		}
		else {
			// Se ubica para recorrer la pila
			Nodo aux = this.tope;
			
			while(aux != null) {
				
				// Agrega el texto del elemento y avanza
				s = aux.getElemento() + s;
				aux = aux.getEnlace();
				if(aux != null) {
					s = "," + s;
				}
			}			
		}
		return s;		
	}
	
}
