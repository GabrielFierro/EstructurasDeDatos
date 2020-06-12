package jerarquicas;

import lineales.dinamicas.*;

public class ArbolBin {
	// Zona de declaración de Atributos 
	private NodoArbol raiz;
	
	// Constructor
	
	public ArbolBin() {
		this.raiz = null;
	}
	
	public boolean insertar(Object elementoNuevo, Object elementoPadre, char lugar) {
		/* Inserta el valor de elemNuevo como hijo del primer nodo encontrado en preorden 
		 * igual a elemPadre, como hijo izquierdo (I) o derecho (D), segun lo indique 
		 * el parametro lugar
		 */
		// Zona de declaración de variables
		boolean exito;
		// Zona de inicialización de variables 
		exito = true;
		
		if (this.raiz == null) {
            this.raiz = new NodoArbol(elementoNuevo);
        } else {
            NodoArbol nodoPadre = obtenerNodo(this.raiz, elementoPadre);
            if (nodoPadre != null) {
                if (lugar == 'I' && nodoPadre.getIzquierdo() == null) {
                    nodoPadre.setIzquierdo(new NodoArbol(elementoNuevo));
                } else if (lugar == 'D' && nodoPadre.getDerecho() == null) {
                    nodoPadre.setDerecho(new NodoArbol(elementoNuevo));
                } else {
                    exito = false;
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }
	private NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
		/* Método privado que busca un elemento y devuelve el nodo que lo contiene.
		 * Si no se encuentra el buscado devuelve null
		 */
		// Zona de declaración de variables
		NodoArbol resultado;
		// Zona de inicialización de variables
		resultado = null;
		
		if(n != null) {
			if(n.getElem().equals(buscado)) {
				// Si el buscado es n, lo devuelve 
				resultado = n;
			}
			else {
				// No es el buscado: busca el primero en el HI
				resultado = obtenerNodo(n.getIzquierdo(), buscado);
				// Si no lo encuentra en el HI, busca en HD
				if(resultado == null) {
					resultado = obtenerNodo(n.getDerecho(), buscado);
				}
			}
		}
		return resultado;
	}
	public boolean esVacio() {
		/* Algoritmo que verifica si la estructura de tipo ArbolBinario no posee elementos.
		 * En caso de no poseer retorna true, caso contrario, retorna false.
		 */
		// Zona de declaración de variables
		boolean exito;
		// Zona de inicialización de variables
		exito = false;
		
		if(this.raiz == null) {
			exito = true;
		}
		return exito;
	}
	
	public Object padre(Object elem) {
		/* Dado un elemento de tipo Object recibido por parámetro devuelve el valor almacenado en su nodo padre, es decir,
		 * busca la primer aparición de elemento.
		 */
		// Zona de declaración de variables 
		Object resultado;
		// Zona de inicialización de variables
		resultado = null;
		//aux = new NodoArbol(this.raiz.getElem());
		
		if(this.raiz != null) {
			if(this.raiz.equals(elem)) {
				resultado = this.raiz.getElem();
			}
			else {
				resultado = obtenerPadre(this.raiz, elem);
			}
		}
		return resultado;
	}
	private Object obtenerPadre(NodoArbol nodo, Object elem) {
		/* Método privado que busca un elemento y devuelve el nodo que lo contiene.
		 * Si no se encuentra el buscado devuelve null
		 */
		// Zona de declaración de variables
		Object resultado;
		NodoArbol nodoIzq, nodoDer;
		// Zona de inicialización de variables
		resultado = null;
		
		if(nodo != null) {
			
			nodoIzq = nodo.getIzquierdo();
			nodoDer = nodo.getDerecho();
			
			if((nodoIzq != null && nodoIzq.getElem().equals(elem)) || (nodoDer != null && nodoDer.getElem().equals(elem))) {
				resultado = nodo.getElem();
			}
			else {
				resultado = obtenerPadre(nodo.getIzquierdo(), elem);
				
				if(resultado == null) {
					resultado = obtenerPadre(nodo.getDerecho(), elem);
				}
			}
		}
		return resultado;
	}
	
	public int altura(){
		/* Algoritmo que devuelve la altura de un árbol, es decir la longitud del camino más largo desde la raíz de hasta una hoja.
		 * Un árbol vacío tiene altura -1 y una hoja tiene altura 0
		 */
		// Zona de declaración de variables
		int resultado;
		// Zona de inicialización de variables
		resultado = 0;
		
		resultado = alturaAux(this.raiz, -1);

		return resultado;
	}
	
	private int alturaAux(NodoArbol nodo, int altura) {
		/*
		 */
		int res1, res2;
		
		if(nodo != null) {
			res1 = alturaAux(nodo.getIzquierdo(), altura+1);
			res2 = alturaAux(nodo.getDerecho(), altura+1);
			if(res1 > res2) {
				altura = res1;
			}
			else {
				altura = res2;
			}
		}
		return altura;
	}
	
	public int nivel(Object elemento) {
		// Zona de declaración de variables
		int res;
		// Zona de inicialización de variables
		res = 0;
		
		if(this.raiz != null) {
			res = nivelAux(this.raiz, elemento, -1);
		}
		return res;
	}
	public int nivelAux(NodoArbol nodo, Object elemento, int nivel) {
		
		if(nodo != null) {
			if(nodo.getElem().equals(elemento)) {
				nivel = 0;
			}
			else {
				nivel = nivelAux(nodo.getIzquierdo(), elemento, nivel++);
				if(nivel != -1) {
					nivel ++; 
				}
				else {
					nivel = nivelAux(nodo.getDerecho(), elemento, nivel); 
					if(nivel != -1) {
						nivel++;
					}
				}
			}
		}
		return nivel;
	}
	
	public void vaciar() {
		/* Algoritmo que quita todos los elementos de la estructura
		 */
		if(this.raiz != null) {
			this.raiz = null;
		}
	}
	
	public ArbolBin clone() {
		/* Crea el arbol clon vacio, si this.raiz no es vacío llama al método privado clone con su raiz 
		 */
		// Zona de declaración de variables
		ArbolBin clon;
		// Zona de inicialización de variables
		clon = new ArbolBin();
		
		if(this.raiz != null) {
			clon.raiz = cloneAux(this.raiz);
		}
		return clon;
	}
	private NodoArbol cloneAux(NodoArbol raiz) {
		/* 
		 */
		// Zona de declaración de variables
		NodoArbol nuevo;
		// Zona de inicialización de variables
		nuevo = raiz; 
		
		if(raiz.getIzquierdo() != null) {
			nuevo.setIzquierdo(cloneAux(raiz.getIzquierdo()));
		}
		else {
			if(raiz.getDerecho() != null) {
				nuevo.setDerecho(cloneAux(raiz.getDerecho()));
			}
		}
		return nuevo;
	}
	
	public void preorden() {
		// Imprime los elementos por consola en preorden
		// Invoca a un método recursivo privado a la clase 
		preordenAux(this.raiz);
	}
	
	private void preordenAux(NodoArbol nodo) {
		// Método recursivo es PRIVADO porque su parámetro es de tipo NodoArbol
		
		if(nodo != null) {
			// Visita el elemento en el nodo
			System.out.println(nodo.getElem()); // (1)
			
			// recorre a sus hijos en preorden
			preordenAux(nodo.getIzquierdo()); // (2)
			preordenAux(nodo.getDerecho());	// (3)
		}
	}
	
	public String toString() {
		/* Algoritmo que muestra por pantalla, los elementos de una estructura de tipo Arbol.
		 */
		// Zona de declaración de variables
		String s;
		// Zona de inicialización de variables
		s = "Arbol binario vacio";
		
		if(this.raiz != null) {
			s = toStringAux(this.raiz, "");
		}
		return s;
	}
	
	private String toStringAux(NodoArbol original, String s) {
		/*
		 * 
		 */
		// Zona de declaración de variables
		NodoArbol izqAux, derAux;
		
		if(original != null) {
			s = s + "\n" + original.getElem() + "\t";
			
			izqAux = original.getIzquierdo();
			derAux = original.getDerecho();
			
			if(izqAux != null && derAux != null) {
				s = s + "HI: " + izqAux.getElem() + "\t\t" + "HD: " + derAux.getElem();
			}
			else {
				if(izqAux == null && derAux != null) {
					s = s + "HI: null" + "\t\t" + "HD: " + derAux.getElem();// + izqAux.getElem() + "HD: null";
				}
				else {
					if(derAux == null && izqAux != null) {
						s = s + "HI: " + izqAux.getElem() + "\t\t" + "HD: null";// + derAux.getElem();
					}
					else {
						s = s + "HI: null" + "\t" + "HD: null"; 
					}
				}
			}
			s = toStringAux(original.getIzquierdo(), s);
			s = toStringAux(original.getDerecho(), s);
		}
		return s;
	}
	
	public Lista listarPreorden() {
		/*
		 * 
		 */
		// Zona de declaración de variables
		Lista listaNueva;
		// Zona de inicialización de variables
		listaNueva = new Lista();
		
		if(this.raiz != null) {
			preordenAuxiliar(this.raiz, listaNueva);
		}
		return listaNueva;
	}
	private void preordenAuxiliar(NodoArbol n, Lista l) {
		// Método recursivo es PRIVADO porque su parámetro es de tipo NodoArbol
		// Zona de declaración de variables
		NodoArbol elem;
		
		if(n != null) {
			elem = new NodoArbol(n.getElem());
			// Comienza a recorrer en preorden
			
			preordenAuxiliar(n.getDerecho(), l);
			preordenAuxiliar(n.getIzquierdo(), l);
			l.insertar(elem.getElem(),1);
		}
	}	
	public Lista listarPosorden() {
		/*
		 */
		// Zona de declaración de variables
		Lista listaNueva;
		// Zona de inicialización de variables
		listaNueva = new Lista();
		
		if(this.raiz != null) {
			posOrdenAux(this.raiz, listaNueva);
		}
		return listaNueva;
	}
	
	private void posOrdenAux(NodoArbol n, Lista l) {
		/*
		 */
		// Zona de declaración de variables
		NodoArbol elem;

		// Zona de inicialización de variables

		if(n != null) {
			elem = new NodoArbol(n.getElem());
			// Comienza a recorrer en posorden
			l.insertar(elem.getElem(), 1);
			posOrdenAux(n.getDerecho(), l);
			posOrdenAux(n.getIzquierdo(), l);
		}
		
	}
	
	
	public Lista listarInorden() {
		/*
		 */
		// Zona de declaración de variables
		Lista  listaNueva;
		// Zona de inicialización de variables
		listaNueva = new Lista();
		
		if(this.raiz != null) {
			inOrdenAux(this.raiz, listaNueva);
		}
		return listaNueva;
	}
	
	private void inOrdenAux(NodoArbol n, Lista l) {
		/*
		 */
		// Zona de declaración de variables
		NodoArbol nodoActual;
		
		if(n != null) {
			nodoActual = new NodoArbol(n.getElem());			
			
			inOrdenAux(n.getDerecho(), l);
			l.insertar(nodoActual.getElem(), 1);
			inOrdenAux(n.getIzquierdo(), l);
		}
		
	}
	
	public Lista listarPorNiveles() {
		/*
		 * 
		 */
		// Zona de declaración de variables
		Lista  listaNueva;
		Cola cola;
		NodoArbol nodoActual;
		// Zona de inicialización de variables
		listaNueva = new Lista();
		cola = new Cola();
		cola.poner(this.raiz);
		
		if(this.raiz != null) {
			
			while(cola.esVacia() == false ) {
				
				nodoActual = (NodoArbol)cola.obtenerFrente();
				cola.sacar();
				listaNueva.insertar(nodoActual.getElem(), 1);
				
				if(nodoActual.getIzquierdo() != null) {
					cola.poner(nodoActual.getIzquierdo());
					
					if(nodoActual.getDerecho() != null) {
						cola.poner(nodoActual.getDerecho());
						
					}
				}
			}
		}
		listaNueva.invertir();
		return listaNueva;
	}
}
