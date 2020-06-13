package conjuntistas;

public class NodoABB {

    // Zona de Atributos
    private Comparable elemento;
    private NodoABB izquierdo;
    private NodoABB derecho;

    // Constructores
    public NodoABB (Comparable elem, NodoABB izq, NodoABB der){
        this.elemento = elem;
        this.izquierdo = izq;
        this.derecho = der;
    }
    public NodoABB (Comparable elem){
        this.elemento = elem;
        this.izquierdo = null;
        this.derecho = null;
    }

    // Observadores

    public Comparable getElem(){
        return this.elemento;
    }

    public NodoABB getIzquierdo(){
        return this.izquierdo;
    }

    public NodoABB getDerecho(){
        return this.derecho;
    }

    // Modificadores

    public void setElem(Comparable elem){
        this.elemento = elem;
    }

    public void setIzquierdo(NodoABB izq){
        this.izquierdo = izq;
    }

    public void setDerecho(NodoABB der){
        this.derecho = der;
    }

}
