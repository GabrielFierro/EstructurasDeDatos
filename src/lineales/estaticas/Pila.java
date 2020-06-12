package lineales.estaticas;

public class Pila {
	/* Creación de la clase Pila de tipo estática con un tamaño fijo no determinado por el usuario
	 */
	// Zona de declaración de atributos
	private int tope;
	private static final int TAMANIO=10;
	private Object[] array;
	
	// Método Constructor
	public Pila() {
		this.tope = -1;	// En caso de que la pila esté vacía se le asigna -1
		this.array = new Object[TAMANIO];	// Se crea un arreglo de tamaño fijo
	}
	
	public boolean apilar(Object unElemento) {
		/* Metodo que recibe un elemento de tipo Object por parámetro, evalúa si puede colocar en el tope
		 * dicho elemento. En caso de ser posible, retorna true, caso contrario donde la pila esta llena retorna false.
		 */
		// Zona de declaración de variables
		boolean exito;
		
		if(this.tope+1>=TAMANIO) {
			exito = false; // La pila esta llena
		}
		else {
			this.tope++; // Incrementa el tope
			this.array[tope] = unElemento;	// Almacena en el tope del arreglo, un elemente de tipo Object recibido por parámetro
			exito = true;
		}
		return exito;
	}
	
	public boolean desapilar() {
		/* Algoritmo que evalua si la pila posee elementos. Luego si posee elementos procede a desapilar y retorna true.
		 * En caso contrario, es decir, la pila no posee elementos, retorna false.
		 */
		// Zona de declaración de variables
		boolean exito;
		
		if(this.tope < 0) {	
			exito = false;	// La pila esta vacia
		}
		else {
			array[this.tope] = null;	// El valor del elemento que se encuentra en el tope ahora es null
			this.tope--;	// Resta en una unidad el valor del toe
			exito = true;
		}
		return exito;
	}
	
	public Object obtenerTope() {
		/* Algoritmo que retorna el elemento que se encuentra en el tope de la Pila. En caso de hallarse retorna tal elemento,
		 * en caso contrario retorna el valor null, dado que la pila está vacía.
		 */
		// Zona de declaración de variables
		Object unElemento;
		
		if(this.tope < 0) {
			unElemento = null;	// Si no se encuentra ningún elemento en la pila retorna null
		}
		else {
			unElemento = array[this.tope];	// Si la pila posee elementos, se retorna el elemento que se encuentra en el tope de la misma
		}
		return unElemento;
	}
	
	public boolean esVacia() {
		/* Algoritmo que verifica si una Pila no posee elementos. En caso de suceder ésto, retorna true.
		 * En caso contrario retorna false, es decir, que la pila posee elementos.
		 */
		// Zona de declaración de variables
		boolean valor;
		// Zona de inicialización de variables
		valor = false;
		
		if(this.tope < 0) {
			valor = true;
		}
		
		return valor;
	}
	
	public void vaciar() {
		/* Algoritmo que dada una Pila, la vacía. Recorre todo el array, reemplazando por null el valor de los elementos de tipo Object.
		 * A su vez, disminuye en una unidad el valor del tope.
		 */
		while(this.tope >= 0) {
			array[this.tope] = null;
			this.tope--;
		}
		
	}
	
	public Pila clone() {
		/* Metodo que dada una Pila, clona sus valores en una nueva pila y retorna ésta última.
		 * Mientras la pila posea elementos, recorre todo el arreglo y copia los valores de una pila hacia otra nueva.
		 * Por último retorna ésta última pila.
		 */
		// Zona de declaración de variables
		Pila unaPila;
		int i;
		
		unaPila = new Pila();	// Creación de un objeto de tipo Pila
		
		if(this.tope != -1) {
			for(i=0; i<=this.tope; i++) {
				unaPila.array[i] = this.array[i];	
			}
		}
		unaPila.tope = this.tope;	// Al atributo tope del objeto actual se le asigna el valor actual del tope 
		
		return unaPila;
	}
	
	@Override 
	public String toString() {
		// Zona de declaración de variables
		String resultado;
		int i;
		resultado = "";
		
		for(i=0; i<=this.tope;i++) {
			resultado = resultado + this.array[i] + ",";
		}
		return resultado;
	}
	
}