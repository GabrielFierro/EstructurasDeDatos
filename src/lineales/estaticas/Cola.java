package lineales.estaticas;

public class Cola {
	/* Algoritmo perteneciente a la estructura Cola estática
	 * 
	 */
	// Zona de declaración de Atributos
	private static final int TAMANIO = 13;
	private Object[] array;
	private int frente;
	private int fin;
	
	// Constructor
	
	public Cola() {
		this.array = new Object[TAMANIO]; // Se crea un arreglo de tamaño fijo
		this.frente = 0;	
		this.fin = 0;
		
	}
	
	public boolean poner(Object unElemento) {
		/* Algoritmo que recibe un elemento de tipo Object por parámetro y coloca el mismo,
		 * por detras de la estructura. Retorna un valor booleano, true en caso de poder colocarse
		 * y falso en caso de que la estructura esté completa.
		 */
		// Zona de declaración de variables
		boolean exito;
		// Zona de inicialización de variables
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
		 * Para ello, si la pila está vacía retorna false, en caso contrario retorna true.
		 */
		// Zona de declaración de variables
		boolean exito;
		// Zona de inicialización de variables
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
		// Zona de declaración de variables
		boolean exito;
		// Zona de inicialización de variables
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
		// Zona de declaración de variables
		Cola clon;
		// Zona de inicialización de variables
		clon = new Cola();

		clon.frente = this.frente;
		clon.fin = this.fin;
		clon.array = this.array.clone();

		return clon;
		}
	
	@Override
	public String toString() {
		/* Algoritmo que sobreescribe al método toString de la clase padre Object,
		 * utilizado para la etapa de testing.
		 */
		// Zona de declaración de variables
		int i;
		String resultado;
		// Zona de inicialización de variables
		resultado = "[";
		
		for(i=0; i<this.TAMANIO; i++) {
			resultado = resultado + this.array[i] + ", ";
		}
		resultado+="]";
		return resultado;
	}
}
