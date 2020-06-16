package lineales.dinamicas;

public class Lista {
	/* Algoritmo que define la interfaz de una estructura de datos de tipo Lista
	 */
	// Zona de declaración de atributos
	private Nodo cabecera;
	private int longitud;
	
	// Constructor
	
	public Lista() {
		this.cabecera = null;
		this.longitud = 0;
	}
	
	// Modificadores
	
	public boolean insertar(Object nuevoElemento, int pos) {
		/* Algoritmo que..
		 * 
		 */
		// Zona de declaración de variables
		boolean exito;
		// Zona de inicialización de variables
		exito = true;
		
		if(pos < 1 || pos > this.longitud+1) {
			exito = false;
		}
		else {
			if(pos == 1) {	// Crea un nuevo nodo y se enlaza en la cabecera 
				this.cabecera = new Nodo(nuevoElemento, this.cabecera);  // Como this.cabecera es null,entonces el primer elemento apunta a null
			}
			else {	// Avanza hasta el elemento en posicion pos-1
				Nodo aux = this.cabecera;
				int i = 1;
				while(i < pos-1) {
					aux = aux.getEnlace();
					i++;
				}
				// Crea el nodo y lo enlaza 
				Nodo nuevo = new Nodo(nuevoElemento, aux.getEnlace());
				aux.setEnlace(nuevo);
			}
			this.longitud++;
		}
		// Nunca hay error de lista llena, entonces devuelve true
		return exito;		
	}
	
	public boolean eliminar(int pos) {
		/* Algoritmp que
		 * 
		 */
		// Zona de declaración de variables
		boolean exito;
		Nodo aux;
		int i;
		// Zona de inicialización de variables
		exito = true;
		i = 1;
		
		if(pos < 1 || pos > longitud) {
			exito = false; // No hay elementos para eliminar de la lista
		}
		else {
			if(pos == 1) {
				if(this.cabecera != null) {
					aux = this.cabecera.getEnlace();
					this.cabecera = aux;
					this.longitud = this.longitud-1;
				}
				else {
					exito = false;
				}
			}
			else {
				aux = this.cabecera;
				
				while(i < pos-1) {
					aux = aux.getEnlace();
					i++;
				}
				aux.setEnlace(aux.getEnlace().getEnlace());
				this.longitud = this.longitud-1;
			}
		}
		return exito;
	}

	public void vaciar() {
		/* Algoritmo que quita todos los elementos de una estructura de tipo Lista
		 */
		if(this.cabecera != null) {
			this.cabecera = null;
			this.longitud = 0;
		}
	}
	
	// Observadores
	
	public Object recuperar(int pos) {
		/* Algoritmo que devuelve el elemento que se encuentra en la posición recibida por parámetro
		 */
		// Zona de declaración de variables 
		Object elemento;
		Nodo aux;
		int i;
		// Zona de inicialización de variables
		elemento = null;
		aux = new Nodo();
		i = 2;
		
		if(pos < 1 || pos > longitud) {
			elemento = null;
		}
		else {
			if(pos == 1) {
				elemento = this.cabecera.getElemento();
			}
			else {
				aux = this.cabecera.getEnlace();
				
				while(i <= pos) {
					if(i == pos) {
						elemento = aux.getElemento();
					}
					aux = aux.getEnlace();
					i++;
				}
			}
		}
		return elemento;
	}
	public int localizar(Object elem) {
		/* Algoritmo que devuelve la posición en la que se encuentra la primera ocurrencia de elem dentro de la estructura 
		 * de tipo Lista. En caso de no hallarlo, devuelve el valor -1
		 */
		// Zona de declaración de variables
		Nodo aux;
		int i, cont;
		// Zona de inicialización de variables
		i = 1;
		aux = new Nodo();
		cont = 1;
		if(this.cabecera == null) {
			i = -1;
		}
		else {
			aux = this.cabecera;
			
			while(cont <= this.longitud) {
				if(aux.getElemento() == elem) {
					i = cont;
					cont = this.longitud+1;
				}
				else {
					i = -1;
				}
				aux = aux.getEnlace();
				cont++;
			}
		}	
		return i;
	}
	
	public boolean esVacia() {
		/* Algoritmo que verifica si la estructura de tipo Lista posee no posee elementos. En caso de no poseerlos retorna true,
		 * en caso contrario retorna false.
		 */
		// Zona de declaración de variables
		boolean exito;
		// Zona de inicialización de variables
		exito = false;
		
		if(this.cabecera == null) {
			exito = true;
		}
		return exito;
	}

	public Lista clone() {
		/* Algoritmo que devuelve una copia exacta de los datos de la estructura original, y respetando el orden de los mismos,
		 * en otra estructura del mismo tipo
		 */
		// Zona de declaración de variables 
		Nodo auxClon, aux, nodoNuevo;
		Lista clon;
		int i;
		// Zona de inicialización de variables
		clon = new Lista();
		i = 1;
		
		if(this.cabecera != null) {
			nodoNuevo = new Nodo(this.cabecera.getElemento(), null);
			clon.cabecera = nodoNuevo;
			aux = this.cabecera;
			auxClon = clon.cabecera;
			clon.longitud = 1;
			
			while(i < this.longitud) {
				aux = aux.getEnlace();
				nodoNuevo = new Nodo(aux.getElemento(), null);
				auxClon.setEnlace(nodoNuevo);
				auxClon = auxClon.getEnlace();
				clon.longitud++;
				i++;
			}
		}	
		
		return clon;
	}
	
	public int longitud() {
		/* Algoritmo que devuelve la cantidad de elementos que posee una estructura de tipo Lista
		 */
		return this.longitud;
	}
	
	@Override
	public String toString() {
		// Zona de declaración de variables
		String s = "";
		
		if(this.cabecera == null) {
			s = "Lista vacia";
		}
		else {
			// Se ubica para recorrer la lista
			Nodo aux = this.cabecera;
			
			while(aux != null) {
				
				// Agrega el texto del elemento y avanza
				s = s + aux.getElemento();
				aux = aux.getEnlace();
				if(aux != null) {
					s = s + " - ";
				}
			}
			s = "[" + s + "]";			
		}
		return s;		
	}
	
	public Lista invertir() {
		// Zona de declaración de variables
		Lista l;
		Nodo n;
		// Zona de declaración de variables
		l = new Lista();
		n = new Nodo(this.cabecera.getElemento(), this.cabecera.getEnlace());
		
		if(this.longitud != 0) {
			invertirAux(l, n);
		}
		return l;
	}
	
	private void invertirAux(Lista l, Nodo n) {
		/* Algoritmo que recibe una estructura de tipo Lista por parámetro, crea una lista nueva y le asigna los elementos
		 * de la lista recibida por parámetro en orden inverso. Por lo que retorna una lista con los valores invertidos con respecto
		 * a la recibida por parámetro
		 */
		// Zona de declaración de variables
		int i;
		// Zona de inicialización de variables
		i = 1;
		
		if(n.getEnlace() != null && this.longitud > i) {
			l.insertar(n.getElemento(), 1);
			invertirAux(l, n.getEnlace());
			i++;
		}
		else {
			l.insertar(n.getElemento(), 1);
		}
	}
}
