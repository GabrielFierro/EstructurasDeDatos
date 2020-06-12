package lineales.estaticas;

public class Cola {
	/* Algoritmo perteneciente a la estructura Cola est�tica
	 * 
	 */
	// Zona de declaraci�n de Atributos
	private static final int TAMANIO = 13;
	private Object[] array;
	private int frente;
	private int fin;
	
	// Constructor
	
	public Cola() {
		this.array = new Object[TAMANIO]; // Se crea un arreglo de tama�o fijo
		this.frente = 0;	
		this.fin = 0;
		
	}
	
	public boolean poner(Object unElemento) {
		/* Algoritmo que recibe un elemento de tipo Object por par�metro y coloca el mismo,
		 * por detras de la estructura. Retorna un valor booleano, true en caso de poder colocarse
		 * y falso en caso de que la estructura est� completa.
		 */
		// Zona de declaraci�n de variables
		boolean exito;
		// Zona de inicializaci�n de variables
		exito = false;
		if ((this.fin + 1) % TAMANIO != this.frente) {
            this.array[fin] = unElemento;
            this.fin = (this.fin + 1) % TAMANIO;
            exito = true;
        }
		return exito;
	}
	
	public boolean sacar() {
		/* Algoritmo que saca elementos de la estructura Cola, retornando un valor booleano.
		 * Para ello, si la pila est� vac�a retorna false, en caso contrario retorna true.
		 */
		// Zona de declaraci�n de variables
		boolean exito;
		// Zona de inicializaci�n de variables
		exito = false;
		
		if(this.frente != this.fin) {
			this.array[this.frente] = null;
			this.frente = (this.frente + 1) % this.TAMANIO;
			exito = true;
		}
		return exito;
	}
	
	public Object obtenerFrente() {
		/* Algoritmo que retorna el primer elemento de la estructura cola. En caso de que la misma
		 * posea un elemento lo retorna, en caso de que no halle ninguno retorna el valor null.
		 */
		return this.array[frente];
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
		
		if(this.frente == this.fin) {
			exito = true;
		}
		return exito;
	}
	
	public void vaciar() {
		/* Algoritmo que elimina los elementos de una estructura de tipo Cola.
		 */
		this.array = new Object[this.TAMANIO];
		this.frente = this.fin;
	}
	
	public Cola clone() {
		/* Algoritmo recursivo que copia exactamente los valores de una estructura de tipo Cola en otra.
		 */
		// Zona de declaraci�n de variables
		Cola clon;
		// Zona de inicializaci�n de variables
		clon = new Cola();

		clon.frente = this.frente;
		clon.fin = this.fin;
		clon.array = this.array.clone();

		return clon;
		}
	
	@Override
	public String toString() {
		/* Algoritmo que sobreescribe al m�todo toString de la clase padre Object,
		 * utilizado para la etapa de testing.
		 */
		// Zona de declaraci�n de variables
		int i;
		String resultado;
		// Zona de inicializaci�n de variables
		resultado = "[";
		
		for(i=0; i<this.TAMANIO; i++) {
			resultado = resultado + this.array[i] + ", ";
		}
		resultado+="]";
		return resultado;
	}
}
