package jerarquicas;

public class NodoArbol {
    // Zona de declaración de variables
    private Object elem;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    // Constructores

    public NodoArbol(Object elem, NodoArbol izquierdo, NodoArbol derecho) {
        this.elem = elem;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }
    public NodoArbol(Object elem) {
        this.elem = elem;
    }
    // Observadores

    public Object getElem() {
        return this.elem;
    }

    public NodoArbol getIzquierdo() {
        return this.izquierdo;
    }

    public NodoArbol getDerecho() {
        return this.derecho;
    }

    // Modificadores

    public void setElem(Object elemento) {
        this.elem = elemento;
    }

    public void setIzquierdo(NodoArbol izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(NodoArbol derecho) {
        this.derecho = derecho;
    }
}
