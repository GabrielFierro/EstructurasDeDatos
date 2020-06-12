package jerarquicas;

import lineales.dinamicas.*;

public class ArbolGen {
	
	// Zona de declaraci�n de atributos
	NodoGen raiz;
	
	// Constructor 
	
	public ArbolGen() {
		this.raiz = null;
	}

	public boolean insertar(Object elemNuevo, Object elemPadre) {
		/* Dado un elemento elemNuevo y un elemento elemPadre, agrega elemNuevo como
		 * como hijo de la primer aparici�n de elemPadre. Para poder agregarse dicho elemNuevo
		 * el �rbol debe poseer un nodo elemento = elemPadre. Si se pudo agregar el elemento
		 * se devuelve verdadero. En caso contrario, se devuele falso.
		 */
		// Zona de declaraci�n de variables
		boolean exito;
		// Zona de inicializaci�n de variables
		exito = true;
		
		if(this.raiz == null) {
			// Si el �rbol est� vac�o, ponemos el elemNuevo en la ra�z
			this.raiz = new NodoGen(elemNuevo);
		}
		else {
			// Si no est� vac�o se busca al padre
			NodoGen nodoPadre = obtenerNodo(this.raiz, elemPadre);
			if(nodoPadre != null) {
				NodoGen hijo = nodoPadre.getHijoIzquierdo();
				NodoGen nuevo = new NodoGen(elemNuevo);
				if(hijo != null) {
					while(hijo.getHermanoDerecho() != null)  
						hijo = hijo.getHermanoDerecho();
						hijo.setHermanoDerecho(nuevo);
				}
				else {
					nodoPadre.setHijoIzquierdo(nuevo);
				}
			}
			else {
				exito = false;
			}
		}
		return exito;
	}
	
	private NodoGen obtenerNodo(NodoGen n, Object buscado) {
		/* M�todo privado que busca un elemento y devuelve el nodo que lo contiene.
		 * Si no se encuentra el buscado devuelve null
		 */
		// Zona de declaraci�n de variables
		NodoGen resultado;
		// Zona de inicializaci�n de variables
		resultado = null;
		
		if(n != null) {
			if(n.getElem().equals(buscado)) {
				// Si el buscado es n, lo devuelve 
				resultado = n;
			}
			else {
				// No es el buscado: busca el primero en el HI
				resultado = obtenerNodo(n.getHijoIzquierdo(), buscado);
				// Si no lo encuentra en el HI, busca en HD
				if(resultado == null) {
					resultado = obtenerNodo(n.getHermanoDerecho(), buscado);
				}
			}
		}
		return resultado;
	}
	
	public boolean pertenece(Object elemento) {
		/* Devuelve verdadero si el elemento pasado por par�metro est� en el �rbol, y falso en caso contrario. 
		 */
		// Zona de declaraci�n de variables
		boolean resultado;
		// Zona de inicializaci�n de variables
		resultado = false;
		
		resultado = perteneceAux(this.raiz, elemento); 
		
		return resultado;
	}
	
	private boolean perteneceAux(NodoGen nodo, Object elem) {
		// Zona de declaraci�n de variables
		boolean encontrado;
		// Zona de inicializaci�n de variables
		encontrado = false;
		
		if(nodo != null) {
			if (nodo.getElem().equals(elem)) {
				encontrado = true;
			}
			else {
				encontrado = perteneceAux(nodo.getHijoIzquierdo(), elem);
				
				if(encontrado == false) {
					encontrado = perteneceAux(nodo.getHermanoDerecho(), elem);
				}
			}
		}
		return encontrado;
	}
	
	public Lista ancestros(Object elemento) {
		/* Si el elemento se encuentra en el �rbol, devuelve una lista 
		 * con el camino desde la ra�z hasta dicho elemento.
		 * Si el elemento no est� en el �rbol devuelve la lista vac�a.
		 */
		// Zona de declaraci�n de variables
		Lista l;
		boolean valor;
		// Zona de inicializaci�n de variables
		l = new Lista();
		valor = false;
		
		// Si el arbol posee nodos y la raiz no es el elemento a buscar
		if(this.raiz != null && !this.raiz.getElem().equals(elemento)) { 
			valor = ancestrosAux(this.raiz, elemento, l);
		}
		return l;
	}

	private boolean ancestrosAux(NodoGen nodo, Object elemento, Lista lista) {
		/* Si el elemento se encuentra en el �rbol, devuelve una lista con el camino desde la ra�z hasta dicho elemento
		*(es decir, con los ancestros del elemento). Si el elemento no est� en el �rbol devuelve la lista vac�a.
		*/
		// Zona de declaraci�n de variables
		boolean exito;
		// Zona de inicializaci�n de variables
		exito = false;
		
		if (nodo != null) {
	           if (nodo.getElem().equals(elemento)) {
	               exito = true;
	           } else {
	               exito = ancestrosAux(nodo.getHijoIzquierdo(), elemento, lista);
	               if (exito) {
	                   lista.insertar(nodo.getElem(), 1);
	               } else {
	                   exito = ancestrosAux(nodo.getHermanoDerecho(), elemento, lista);
	               }
	           }
	       }
		return exito;
	}
	public boolean esVacio() {
		/* Devuelve falso si hay al menos un elemento cargado en el �rbol y verdadero en caso contrario. 
		 */
		// Zona de declaraci�n de variables
		boolean exito;
		// Zona de inicializaci�n de variables
		exito = false;
		
		if(this.raiz == null) {
			exito = true;
		}
		return exito;
	}
	
	public int altura() {
		/* Devuelve la altura del �rbol, es decir la longitud del camino m�s largo desde la ra�z hasta una hoja.
		 * Un �rbol vac�o tiene altura -1, y una hoja tiene altura 0.
		 */
		// Zona de declaraci�n de variables
		int longitud;
		// Zona de inicializaci�n de variables
		longitud = 0;
		
		if(this.raiz == null) {
			longitud = -1;
		}
		else {
			longitud = alturaAux(this.raiz) - 1;
		}
		return longitud;
	}
	
	private int alturaAux(NodoGen nodo){
		
		// Zona de declaraci�n de variables
		int res;
		// Zona de inicializaci�n de variables
		res = 0;
		
		if(nodo != null) {
			
			res = alturaAux(nodo.getHijoIzquierdo()) + 1; // Recorre los HEI
			if(nodo.getHermanoDerecho() != null) {
				res = alturaAux(nodo.getHermanoDerecho()); // Recorre los hermanos derechos 
			}
		}
		return res;
	}	
	
	public int nivel(Object elemento) {
		/* Devuelve el nivel de la ra�z hasta un elemento en el �rbol pasado por par�metro. Si el elemento no existe
		 * en el �rbol devuelve -1. 
		 */
		// Zona de declaraci�n de variables
		int longitud;
		// Zona de inicializaci�n de variables
		longitud = 0;
		
		if(this.raiz != null) {
			longitud = nivelAux(this.raiz, elemento, -1);
		}
		return longitud;
	}
	public int nivelAux(NodoGen nodo, Object buscado, int nivel) {
		
		if(nodo != null) {
			if(nodo.getElem().equals(buscado)) {
				// Si el buscado es n, incrementa en una unidad el nivel
				nivel++;
			}
			else {
				nivel = nivelAux(nodo.getHijoIzquierdo(), buscado, nivel);	
				
				if(nivel == -1) {
					nivel = nivelAux(nodo.getHermanoDerecho(), buscado, nivel);
				}
				else {
					nivel++;
				}
			}	
		}
		return nivel;
	}
	
	
	public Object padre(Object elemento) {
		/* Dado un elemento recibido por par�metro devuelve el valor almacenado en su nodo padre, busca la primer aparici�n.
		 */
		// Zona de declaraci�n de variables
		Object resultado;
		// Zona de inicializaci�n de variables
		resultado = null;
		
		if(this.raiz != null) {
			if(this.raiz.equals(elemento)) {
				resultado = this.raiz.getElem();
			}
			else {
				resultado = padreAux(this.raiz, elemento);
			}
		}
		return resultado;
		
	}

	private Object padreAux(NodoGen nodo, Object elem) {
		// Zona de declaraci�n de variables
		Object resultado;
		// Zona de inicializaci�n de variables
		resultado = null;

		if (nodo != null) {
			NodoGen nodoAux = nodo.getHijoIzquierdo();
			
			while(nodoAux != null && nodoAux.getElem().equals(elem) == false) {
				nodoAux = nodoAux.getHermanoDerecho();
			}
			if(nodoAux != null) {
				resultado = nodo.getElem();
			}
			else {
				resultado = padreAux(nodo.getHijoIzquierdo(), elem);
				if(resultado == null) {
					resultado = padreAux(nodo.getHermanoDerecho(), elem);
				}
			}
		}
		return resultado;
	}
	
	
	
	public Lista listarPreorden() {
		/* Devuelve una lista con elementos del �rbol en el recorrido en preorden
		 * 
		 */
		// Zona de declaraci�n de variabls
		Lista salida;
		// Zona de inicializaci�n de variables
		salida = new Lista();
		
		listarPreordenAux(this.raiz, salida);
		
		return salida.invertir();
	}
	private void listarPreordenAux(NodoGen n, Lista ls) {
		/* Algoritmo que recibe por par�metro la raiz de una estructura de tipo arbol junto a una lista vac�a,
		 * y carga la estructura de tipo Lista con los elementos de la estructura Arbol en preorden
		 */
		
		if(n != null) {	
			// visita del nodo n
			ls.insertar(n.getElem(), 1);
			// llamado recursivo con primer hijo de n
			if(n.getHijoIzquierdo() != null) {
				listarPreordenAux(n.getHijoIzquierdo(), ls);
			}
			// llamados recursivos con los otros hijos de n
			if(n.getHijoIzquierdo() != null) {
				NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
				while(hijo != null) { // Mientras nodo hijo tenga hermanos, los busca
					listarPreordenAux(hijo, ls);
					hijo = hijo.getHermanoDerecho(); 
				}
			}
		}
	}
	
	public Lista listarInorden() {
		/* Devuelve una lista con elementos del �rbol en el recorrido inorden
		 */
		// Zona de declaraci�n de variables
		Lista salida;
		// Zona de inicializaci�n de variables
		salida = new Lista();
		
		listarInordenAux(this.raiz, salida);
		
		return salida.invertir();
	}
	
	private void listarInordenAux(NodoGen n, Lista ls) {
		/* Algoritmo que recibe por par�metro la raiz de una estructura de tipo arbol junto a una lista vac�a,
		 * y carga la estructura de tipo Lista con los elementos de la estructura Arbol en inorden
		 */
		
		if(n != null) {
			// llamado recursivo con primer hijo de n
			if(n.getHijoIzquierdo() != null) {
				listarInordenAux(n.getHijoIzquierdo(), ls);
			}
			// visita del nodo n
			ls.insertar(n.getElem(), 1);

			// llamados recursivos con los otros hijos de n
			if(n.getHijoIzquierdo() != null) {
				NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
				while(hijo != null) { // Mientras nodo hijo tenga hermanos, los busca
					listarInordenAux(hijo, ls);
					hijo = hijo.getHermanoDerecho(); 
				}
			}
		}
	}
	
	public Lista listarPosorden() {
		/* Devuelve una lista con elementos del �rbol en el recorrido posorden
		 */
		// Zona de declaraci�n de variables
		Lista salida;
		// Zona de inicializaci�n de variables
		salida = new Lista();
		
		listarPosordenAux(this.raiz, salida);
		
		return salida.invertir();
		
	}
	
	private void listarPosordenAux(NodoGen n, Lista ls) {
		/* Algoritmo que recibe por par�metro la raiz de una estructura de tipo arbol junto a una lista vac�a,
		 * y carga la estructura de tipo Lista con los elementos de la estructura Arbol en posorden
		 */
		
		if(n != null) {
			
			// llamado recursivo con primer hijo de n
			if(n.getHijoIzquierdo() != null) {
				listarPosordenAux(n.getHijoIzquierdo(), ls);
			}
			
			// llamados recursivos con los otros hijos de n
			if(n.getHijoIzquierdo() != null) {
				NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
				while(hijo != null) { // Mientras nodo hijo tenga hermanos, los busca
					listarPosordenAux(hijo, ls);
					hijo = hijo.getHermanoDerecho(); 
				}
			}
			// visita del nodo n
			ls.insertar(n.getElem(), 1);
		}
	}
	
	public Lista listarNiveles() {
		/* Devuelve una lista con los elementos del �rbol en el recorrido por niveles
		 * 
		 */
		// Zona de declaraci�n de variables
		Lista salida;
		// Zona de inicializaci�n de variables
		salida = new Lista();
		
		listarNivelesAux(this.raiz, salida);
		
		return salida.invertir();
	}

	private void listarNivelesAux(NodoGen n, Lista ls) {
		
		// Zona de declaraci�n de variables
		Cola cola;
		NodoGen nodo;
		// Zona de inicializaci�n de variables
		cola = new Cola();
		cola.poner(this.raiz);
		
		if(n != null) {
			
			while(!cola.esVacia()) {
				
				nodo = (NodoGen)cola.obtenerFrente();
				cola.sacar();
				ls.insertar(nodo.getElem(), 1);
				
				nodo = nodo.getHijoIzquierdo();
				while(nodo != null) {
						cola.poner(nodo);
						nodo = nodo.getHermanoDerecho();
				}
			}	
		}
	}
	
	public ArbolGen clone() {
		/* Genera y devuelve un �rbol gen�rico que es equivalente que el �rbol original
		 */
		// Zona de declaraci�n de variables
		ArbolGen arbol;
		// Zona de declaraci�n de variables
		arbol = new ArbolGen();
		
		if(this.raiz != null) {
			arbol.raiz = cloneAux(this.raiz);
		}
		else {
			arbol.raiz = null;
		}
		return arbol;
	}
	
	private NodoGen cloneAux(NodoGen nodo) {
		/*
		 */
		// Zona de declaraci�n de variables
		NodoGen nuevo;
		// Zona de inicializaci�n de variables
		nuevo = nodo;
	
		if (nuevo != null) {
			
			if (nuevo.getHijoIzquierdo() != null) {
				nuevo.setHijoIzquierdo(cloneAux(nuevo.getHijoIzquierdo()));
				if (nuevo.getHermanoDerecho() != null) {
					nuevo.setHermanoDerecho(cloneAux(nuevo.getHermanoDerecho()));
				}
			}
		}
	    return nuevo;
	}
	
	public void vaciar() {
		/* Quita todos los elementos de la estructura de tipo arbol generico
		 */
		this.raiz = null;
	}
	
	public String toString() {
		/* Genera y devuelve una cadena de caracteres que indica cu�l es la ra�z del �rbol y quienes son
		 * los hijos de cada nodo.
		 */
		return toStringAux(this.raiz);
	}
	
	private String toStringAux(NodoGen n) {
		/* 
		 */
		String s = "";
		if(n != null) {
			// visita del nodo n
			s += n.getElem().toString() + " -> ";
			NodoGen hijo = n.getHijoIzquierdo();
			while(hijo != null) {
				s += hijo.getElem().toString() + ", ";
				hijo = hijo.getHermanoDerecho();
			}
			
			// comienza recorrido de los hijos de n llamando recursivamente
			// para que cada hijo agregue su subcadena a la general
			hijo = n.getHijoIzquierdo();
			while(hijo != null) {
				s += "\n" + toStringAux(hijo);
				hijo = hijo.getHermanoDerecho();
			}			
		}
		return s;
	}	
}
