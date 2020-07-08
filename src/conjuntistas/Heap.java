package conjuntistas;

@SuppressWarnings("rawtypes")

public class Heap{
	/* Algoritmo que representa la estructura de datos de tipo Heap Minimo
	 *
	 */
	// Zona de declaracion de atributos
	private Comparable[] heap; 
	private static final int TAMANIO=10;
	private int ultimo;
	
	public Heap() {
		this.heap = new Comparable[TAMANIO];
		this.ultimo = 0; // La posicion 0 nunca es utilizada
	}
	
	public boolean insertar(Comparable elemento) {
		/* Recibe un elemento y lo inserta en el arbol. Devuelve true si se pudo
		 * insertar el elemento, y falso en caso contrario.
		 */
		// Zona de declaracion de variables
		boolean exito;
		// Zona de inicializacion de variables
		exito = false;

		if(this.ultimo+1 < TAMANIO) {
			this.ultimo++;
			this.heap[this.ultimo] = elemento;
			hacerSubir(this.ultimo);
			exito = true;
		}
		return exito;
	}

	private void hacerSubir(int posHijo) {
		// Zona de declaracion de variables
		int posP;
		Comparable temp;
		boolean salir;
		// Zona de inicializacion de variables
		temp = this.heap[posHijo];
		salir = true;

		while (salir) {
			posP = posHijo / 2;
			if (posP >= 1) {
				if (this.heap[posP].compareTo(temp) > 0) {
					this.heap[posHijo] = this.heap[posP];
					this.heap[posP] = temp;
					posHijo = posP;
				} else {
					salir = false;
				}
			} else {
				salir = false;
			}
		}
	}

	public boolean eliminarCima() {
		/* Elimina el elemento de la raiz. Devuelve true si tuvo exito y false en cas contrario
		 */
		// Zona de declaracion de variables
		boolean exito;
		if (this.ultimo == 0) {
			// Estructura vacia
			exito = false;
		} else {
			// Saca la raiz y pone la ultima hoja en su lugar
			this.heap[1] = this.heap[ultimo];
			this.ultimo--;
			// Restablece la propiedad de heap minimo
			hacerBajar(1);
			exito = true;
		}
		return exito;
	}

	private void hacerBajar(int posPadre) {
		// Zona de declaracion de variables
		int posH;
		Comparable temp = this.heap[posPadre];
		boolean salir = false;
		
		while(!salir) {
			posH = posPadre * 2;
			if(posH <= this.ultimo) {
				// temp tiene al menos un hijo (izq) y lo considera menor
				
				if(posH < this.ultimo) {
					// hijoMenor tiene hermano derecho
					
					if(this.heap[posH + 1].compareTo(this.heap[posH]) < 0) {
						// El hijo derecho es el menor de los dos
						posH++;
					}
				}
				// Compara al hijo menor con el padre
				if(this.heap[posH].compareTo(temp) < 0) {
					// El hijo es menor que el padre, los intercambia
					this.heap[posPadre] = this.heap[posH];
					this.heap[posH] = temp;
					posPadre = posH;
				}
				else {
					// el padre es menor que sus hijos, esta bien ubicado
					salir = true;
				}
			}
			else {
				// el temp es hoja, esta bien ubicado
				salir = true;
			}
		}
	}
	
	public Object recuperarCima() {
		/* Algoritmo que devuelve el elemento que esta en la raiz.
		 */
		Object aux;
		aux = null;

		if(this.heap[1] != null) {
			aux = this.heap[1];
		}
		return aux;
	}
	
	public boolean esVacio() {
		/* Algoritmo que verifica si una estructura de tipo arbol heap minimo posee elementos.
		 * Retorna false si posee al menos un elemento, o true si no posee ninguno
		 */
		// Zona de declaracion de variables
		boolean exito;
		// Zona de inicializacion de variables
		exito = true;
		if(this.heap[1] != null) { // Verifica si tiene elementos
			exito = false;
		}
		return exito;
	}
	
	public Heap clone() {
		/* Algoritmo que hace una copia exacta de un arbol de tipo Heap Minimo
		 */
		// Zona de declaracion de variables
		Heap clon;
		int longitud, i;
		// Zona de inicializacion de variables
		clon = new Heap();
		longitud = this.heap.length;
		
		for(i=1; i<longitud; i++) {
			clon.heap[i] = this.heap[i];
		}
		return clon;
	}
	@Override
	public String toString() {
		/* Algoritmo que muestra los elementos que posee la estructura arbol Heap Minimo
		 */
		// Zona de declaracion de varibles
		String res;
		int i, longitud;
		// Zona de inicializacion de variables
		res = "[";
		longitud = this.heap.length;
		
		for(i=1; i<longitud; i++) {
			res += "-" + this.heap[i];
		}
		res += "]";
		return res;
	}
}
