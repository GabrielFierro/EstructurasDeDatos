package lineales.dinamicas;

public class Cola {
	/* Algoritmo perteneciente a la estructura Cola din�mica
	 * 
	 */
	// Zona de declaraci�n de Atributos
	private Nodo fin;
	private Nodo frente;
	
	// Constructor
	
	public Cola() {
		this.frente = null;
		this.fin = null;
	}
	
	// Modificadores
	
	public boolean poner(Object unElemento) {
		/* Algoritmo que recibe un elemento de tipo Object por par�metro y coloca el mismo,
		 * por detras de la estructura. Retorna el valor booleano true porque en la estructura de tipo cola
		 * dinamica siempre es posible agregar un nuevo elemento
		 */
		// Zona de declaraci�n de variables
		Nodo nuevoNodo;
		boolean exito;
		// Zona de inicializaci�n de variables
		exito = true;
		
		nuevoNodo = new Nodo(unElemento, null);
		
		if(this.fin == null) 
			this.frente = nuevoNodo;
		
		else 
			this.fin.setEnlace(nuevoNodo);
			this.fin = nuevoNodo;
		
		return exito;
	}

	public boolean sacar() {
		/* Algoritmo que saca el primer elemento de la estructura Cola dinamica, retornando un valor booleano.
		 * Para ello, si la pila est� vac�a retorna false, en caso contrario retorna true.
		*/ 
		// Zona de declaraci�n de variables
		boolean exito;
		// Zona de inicializaci�n de variables
		exito = false;
		
		if(this.frente != null) {
			this.frente = this.frente.getEnlace();
			if(this.frente == null) 
				this.fin = null;
				exito = true;
			
		}
		return exito;
	}

	// Observadores
	
	public Object obtenerFrente() {
		/* Algoritmo que retorna el primer elemento de la estructura cola. En caso de que la misma
		 * posea un elemento lo retorna, en caso de que no halle ninguno retorna el valor null.
		 */
		Object elemento;
		elemento = null;
		if(this.frente != null) {
			elemento = this.frente.getElemento();
		}
		return elemento;
	}
	
	public boolean esVacia() {
		/* Algoritmo que determina si la estructura de tipo cola se encuentra vacia.
		 * Si dicha estructura posea elementos retorna false, en caso contrario, es decir que la 
		 * estructura cola no posea elementos retorna true.
		 */
		// Zona de declaraci�n de variables
		boolean exito;
		// Zona de inicializaci�n de variables
		exito = false;
		
		if(this.frente == null) {
			exito = true;
		}
		return exito;
	}
	
	public void vaciar() {
		/* Algoritmo que elimina los elementos de una estructura de tipo Cola.
		 */
		
		while(this.frente!=null) {
			this.frente = this.frente.getEnlace();
		}
	}
	
	public Cola clone() {
		/* Algoritmo recursivo que copia exactamente los valores de una estructura de tipo Cola en otra.
		 */
		// Zona de declaraci�n de variables
		Cola clon;
		Nodo aux;
		// Zona de inicializaci�n de variables
		clon = new Cola(); 
		aux = new Nodo();
		if(this.frente != null){
			aux = this.frente;
			clon.frente = aux;
			clon.fin = aux;
			aux = aux.getEnlace();
			
			while(aux != null) {
				clon.fin = aux;
				aux = aux.getEnlace();
			}
		}
		return clon;
		}

	public String toString() {
		// Zona de declaraci�n de variables
		String s = "Cola vacia";
		if(this.frente != null) {
			// Se ubica para recorrer la pila
			Nodo aux = this.frente;
			s = "[";
			while(aux != null) {
				// Agrega el texto del elemento y avanza
				s += aux.getElemento();
				aux = aux.getEnlace();
				if(aux != null) {
					s += ", ";
				}
			}
			s += "]";			
		}
		return s;		
	}
	
}

