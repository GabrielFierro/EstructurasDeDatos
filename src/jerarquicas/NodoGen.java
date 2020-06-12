package jerarquicas;

public class NodoGen {
	
	// Zona de declaración de atributos
	Object tipoElemento;
	NodoGen hijoIzquierdo;
	NodoGen hermanoDerecho;
	
	// Constructores
	
	public NodoGen(Object tipoElemento) {
		this.tipoElemento = tipoElemento;
		this.hijoIzquierdo = null;
		this.hermanoDerecho = null;
	}
	
	public NodoGen (Object tipoElemento, NodoGen hijoIzquierdo, NodoGen hermanoDerecho) {
		this.tipoElemento = tipoElemento;
		this.hijoIzquierdo = hijoIzquierdo;
		this.hermanoDerecho = hermanoDerecho;
	}
	
	// Observadores
	
	public Object getElem() {
		return tipoElemento;
	}
	
	public NodoGen getHijoIzquierdo() {
		return hijoIzquierdo;
	}
	
	public NodoGen getHermanoDerecho() {
		return hermanoDerecho;
	}
	
	// Modificadores
	
	public void setElemento(Object tipoElemento) {
		this.tipoElemento = tipoElemento;
	}
	
	public void setHijoIzquierdo(NodoGen hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}
	
	public void setHermanoDerecho(NodoGen hermanoDerecho) {
		this.hermanoDerecho = hermanoDerecho;
	}
	
}
