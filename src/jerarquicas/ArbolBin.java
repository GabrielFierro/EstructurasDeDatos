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
				resultado = nodo.getElem();	// Encontró el nodo padre
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
		/* Algoritmo que devuelve la altura de un árbol, es decir la longitud del camino más largo
		 * desde la raíz hasta una hoja. Un árbol vacío tiene altura -1 y una hoja tiene altura 0.
		 */
		int resultado;
		resultado = alturaAux(this.raiz, -1);
		return resultado;
	}
	private int alturaAux(NodoArbol nodo, int altura) {
		/* Algoritmo que dado un nodo de tipo NodoArbol y un valor de tipo int que recibe por parámetro, calcula la
		 * altura de una estructura de tipo ArbolBin en forma recursiva.
		 */
		// Zona de declaración de variables
		int res1, res2;

		if(nodo != null) {
			res1 = alturaAux(nodo.getIzquierdo(), altura+1);	// Recorre rama izquierda
			res2 = alturaAux(nodo.getDerecho(), altura+1);	// Recorre rama derecha
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
		/* Algoritmo que dado un elemento de tipo Object recibido por parámetro, verifica que la estructura de tipo
		 * ArbolBin tenga un nodo y en caso afirmativo, invoca al método nivelAux para calcular el nivel del árbol.
		 * Casos especiales: Retorna 0 si el árbol posee únicamente la raíz, retorna -1 si el árbol está vacío.
		 */
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
		/* Algoritmo que dado un nodo de tipo NodoArbol, un elemento de tipo Object y un valor de tipo int recibidos por
		 * parámetro, calcula en forma recursiva el nivel del elemento recibido por parámetro.
		 */
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
		/* Algoritmo que quita todos los elementos de la estructura de tipo ArbolBin
		 */
		if(this.raiz != null) {
			this.raiz = null;
		}
	}
	
	public ArbolBin clone() {
		/* Algoritmo que crea el arbol clon vacio, si el árbol posee al menos el nodo raíz, invoca al método cloneAux
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
		/* Algoritmo que dado un nodo de tipo NodoArbol recibido por parámetro, realiza una copia exacta de la estructu-
		 * del árbol original actual, en otro, y retorna los nodos que debe copiar en la nueva estructura, la cual se
		 * encuentra en el método clone().
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
	
	public String toString() {
		/* Algoritmo que verifica que la estructura de tipo ArbolBin posea al menos un nodo raiz, en caso afirmativo,
		 * invoca al método toStringAux(), y en caso contrario retorna "Arbol binario vacio".
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
		/* Algoritmo que dado un nodo de tipo NodoArbol y una cadena de caracteres, recibidos por parámetro, carga en
		 * la misma los elementos de cada nodo con sus respectivos hijos izquierdo e hijo derecho, si los tuviese.
		 * En caso de no tener hijos almacena la cadena "null".
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
					s = s + "HI: null" + "\t" + "HD: " + derAux.getElem();// + izqAux.getElem() + "HD: null";
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
		/* Algoritmo que verifica que la estructura de tipo ArbolBin posea al menos el nodo raíz, en caso afirmativo
		 * invoca al método preordenAuxiliar() y en caso contrario, retorna una lista vacía dado que el árbol no
		 * posee elementos y no hay elementos para listar.
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
		/* Algoritmo que dado un nodo de tipo NodoArbol y una lista de tipo Lista recibidos por parámetro, carga la
		 * lista con elementos a partir de dicho nodo, en forma de preorden.
		 * El recorrido es: Visitar nodo raíz, luego hijo izquierdo y por último el hijo derecho.
		 */
		// Zona de declaración de variables
		NodoArbol elem;
		
		if(n != null) {
			elem = new NodoArbol(n.getElem());
			// Comienza a recorrer en preorden
			// Inserta el hijo derecho, luego inserta el hijo izquierdo y por último inserta la raíz
			preordenAuxiliar(n.getDerecho(), l);	// Recorre rama derecha
			preordenAuxiliar(n.getIzquierdo(), l);	// Recorre rama izquierda
			l.insertar(elem.getElem(),1);	// Inserta siempre en primera posición
		}
	}	
	public Lista listarPosorden() {
		/* Algoritmo que verifica que la estructura de tipo ArbolBin posea al menos el nodo raíz, en caso afirmativo
		 * invoca al método posordenAux() y en caso contrario, retorna una lista vacía dado que el árbol no
		 * posee elementos y no hay elementos para listar.
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
		/* Algoritmo que dado un nodo de tipo NodoArbol y una lista de tipo Lista recibidos por parámetro, carga la
		 * lista con elementos a partir de dicho nodo, en forma de posorden.
		 * El recorrido es: Visitar hijo izquierdo, luego derecho y por último la raíz.
		 */
		// Zona de declaración de variables
		NodoArbol elem;

		// Zona de inicialización de variables
		if(n != null) {
			elem = new NodoArbol(n.getElem());
			// Comienza a recorrer en posorden
			// Inserta el elemento raiz en primera posición, luego el hijo derecho y por último el hijo izquierdo
			l.insertar(elem.getElem(), 1);	// Inserta los elementos en primera posición
			posOrdenAux(n.getDerecho(), l);	// Recorre rama derecha
			posOrdenAux(n.getIzquierdo(), l);	// Recorre rama izquierda
		}
		
	}

	public Lista listarInorden() {
		/* Algoritmo que verifica que la estructura de tipo ArbolBin posea al menos el nodo raíz, en caso afirmativo
		 * invoca al método inordenAux() y en caso contrario, retorna una lista vacía dado que el árbol no
		 * posee elementos y no hay elementos para listar.
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
		/* Algoritmo que dado un nodo de tipo NodoArbol y una lista de tipo Lista recibidos por parámetro, carga la
		 * lista con elementos a partir de dicho nodo, en forma de inorden.
		 * El recorrido es: Visitar hijo izquierdo, luego la raíz y por último el hijo derecho.
		 */
		// Zona de declaración de variables
		NodoArbol nodoActual;
		
		if(n != null) {
			nodoActual = new NodoArbol(n.getElem());
			// Comienza a recorrer en posorden
			// Inserta el hijo derecho en la lista, luego la raíz y por último el hijo izquierdo
			inOrdenAux(n.getDerecho(), l);
			l.insertar(nodoActual.getElem(), 1);
			inOrdenAux(n.getIzquierdo(), l);
		}
		
	}

    public Lista listarPorNiveles() {
	    /* Algoritmo que verifica que una estructura de tipo ArbolBin posea al menos un nodo, en caso afirmativo,
	     * invoca al método listarPorNivelesAux(), en caso contrario retorna una lista vacía.
	     */

        // Zona de declaración de variables
        Lista lista;
        // Zona de inicialización de variables
        lista = new Lista();

        if(this.raiz != null) {
            listarPorNivelesAux(this.raiz, lista);
        }
        return lista;
	}

    private void listarPorNivelesAux(NodoArbol nodo, Lista lista) {
        /* Algoritmo que dado un nodo de tipo NodoArbol y una lista de tipo Lista recibidos por parámetro, carga dicha
         * lista con el nodo y sus hijos, si los tuviese.
         * Para ello utiliza una estructura auxiliar de tipo Cola junto a una variable iteradora.
         */
        // Zona de declaración de variables
        Cola cola = new Cola();
        int i;
        // Zona de inicialización de variables
        cola.poner(nodo);
        i = 0;

        while (!cola.esVacia()) {

            nodo = (NodoArbol) cola.obtenerFrente();
            cola.sacar();
            lista.insertar(nodo.getElem(), i);
            i++;

            if (nodo.getIzquierdo() != null) {
                cola.poner(nodo.getIzquierdo());
            }
            if (nodo.getDerecho() != null) {
                cola.poner(nodo.getDerecho());

            }
        }
    }
}
