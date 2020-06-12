package conjuntistas;

@SuppressWarnings("rawtypes")

public class Heap{
	
	// Zona de declaraci�n de atributos
	private Comparable[] heap; 
	private static final int TAMANIO=10;
	private int ultimo;
	
	public Heap() {
		this.heap = new Comparable[TAMANIO];
		this.ultimo = 0; // La posici�n 0 nunca es utilizada
	}
	
	public boolean insertar(Comparable elemento) {
		/* Recibe un elemento y lo inserta en el arbol. Devuelve true si se pudo
		 * insertar el elemento, y falso en caso contrario.
		 */
		// Zona de declaraci�n de variables
		boolean exito;
		// Zona de inicializaci�n de variables
		exito = false;

		if(this.ultimo+1 < this.TAMANIO) {
			
			this.ultimo++;
			this.heap[this.ultimo] = elemento;
			hacerSubir(this.ultimo);
			exito = true;
		}
		return exito;
	}
	
	public boolean eliminarCima() {
		/* Elimina el elemento de la raiz. Devuelve true si tuvo exito y false en cas contrario
		 */
		// Zona de declaraci�n de variables
		boolean exito;
		if(this.ultimo == 0) {
			// Estructura vac�a
			exito = false;
		}
		else {
			// Saca la ra�z y pone la �ltima hoja en su lugar
			this.heap[1] = this.heap[ultimo-1];
			this.ultimo--;
			// Restablece la propiedad de heap minimo
			hacerBajar(1);
			exito = true;
		}
		return exito;
	}
	
	private void hacerSubir(int posPadre) {
		// Zona de declaraci�n de variables 
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
					// el padre es menor que sus hijos, est� bien ubicado
					salir = true;
				}
			}
			else {
				// el temp es hoja, est� bien ubicado
				salir = true;
			}
		}
	}

	private void hacerBajar(int posPadre) {
		// Zona de declaraci�n de variables 
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
					// el padre es menor que sus hijos, est� bien ubicado
					salir = true;
				}
			}
			else {
				// el temp es hoja, est� bien ubicado
				salir = true;
			}
		}
	}
	
	public Object recuperarCima() {
		/* Algoritmo que devuelve el elemento que est� en la ra�z. 
		 */
		Object aux;
		aux = null;

		if(this.heap[1] != null) {
			aux = (Comparable) this.heap[1];
		}
		return aux;
	}
	
	public boolean esVacio() {
		/* Algoritmo que verifica si una estructura de tipo �rbol heap m�nimo posee elementos.
		 * Retorna false si posee al menos un elemento, o true si no posee ninguno
		 */
		// Zona de declaraci�n de variables
		boolean exito;
		// Zona de inicializaci�n de variables
		exito = true;
		if(this.heap[1] != null) { // Tiene elementos
			exito = false;
		}
		return exito;
	}
	
	public Heap clone() {
		/* Algoritmo que hace una copia exacta de un arbol heap minimo
		 * 
		 */
		// Zona de declaraci�n de variables
		Heap clon;
		int longitud, i;
		// Zona de inicializaci�n de variables
		clon = new Heap();
		longitud = this.heap.length;
		
		for(i=1; i<longitud; i++) {
			clon.heap[i] = this.heap[i];
		}
		return clon;
	}
	@Override
	public String toString() {
		/* Algoritmo que muestra los elementos que posee la estructura �rbol Heap M�nimo
		 */
		// Zona de declaraci�n de varibles
		String res;
		int i, longitud;
		// Zona de inicializaci�n de variables
		res = "[";
		longitud = this.heap.length;
		
		for(i=1; i<longitud; i++) {
			res += "-" + this.heap[i];
		}
		res += "]";
		return res;
	}
	
}
