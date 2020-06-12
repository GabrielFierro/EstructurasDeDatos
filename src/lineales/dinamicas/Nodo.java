package lineales.dinamicas;

public class Nodo {
	
	// Zona de declaración de atributos
	private Object unElemento;
	private Nodo unEnlace;
	
	// Constructores
	public Nodo(Object elemento, Nodo enlace) {
		this.unElemento = elemento;
		this.unEnlace = enlace;
	}
	public Nodo() {
		this.unElemento = null;
		this.unEnlace = null;
	}
	
	// Observadores
	public Object getElemento() {
		return this.unElemento;
	}
	
	public Nodo getEnlace() {
		return this.unEnlace;
	}
	
	// Modificadores
	public void setElemento(Object elemento) {
		this.unElemento = elemento;
	}
	
	public void setEnlace(Nodo enlace) {
		this.unEnlace = enlace;
	}
	
	public Nodo Nodo() {
		return this.Nodo();
	}
	
	
}
