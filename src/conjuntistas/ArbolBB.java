package conjuntistas;

import jerarquicas.ArbolBin;
import jerarquicas.NodoArbol;
import lineales.dinamicas.Lista;

public class ArbolBB {

    // Zona de declaracion de atributos
    private NodoABB raiz;


    /*
    public boolean pertenece (Comparable elemento){

    }
    */
    public boolean insertar (Comparable elemento){
        /* Algoritmo que recibe un elemento de tipo Comparable por parametro, y
         * lo inserta en la estructura de tipo Arbol Binario de Busqueda
         */
        // Zona de declaracion de variables
        boolean exito;
        // Zona de inicializacion de variables
        exito = true;

        if(this.raiz == null){
            this.raiz = new NodoABB(elemento);
        } else{
            exito = insertarAux(this.raiz, elemento);
        }
        return exito;
    }

    private boolean insertarAux(NodoABB n, Comparable elemento){
        // Precondicion: n no es nulo
        // Zona de declaracion de variables
        boolean exito;
        // Zona de inicializacion de variables
        exito = true;

        if((elemento.compareTo(n.getElem()) == 0)){
            // Reportar error: Elemento repetido
            exito = false;
        } else if(elemento.compareTo(n.getElem()) < 0){
            // elemento es menor que n.getElem()
            // si tiene HI baja a la izquierda, sino agrega elemento
            if(n.getIzquierdo() != null){
                exito = insertarAux(n.getIzquierdo(), elemento);
            }else{
                n.setIzquierdo(new NodoABB(elemento));
            }
        } else{ // elemento es mayor que n.getElem()
            // si tiene HD baja a la derecha, sino agrega elemento
            if(n.getDerecho() != null){
                exito = insertarAux(n.getDerecho(), elemento);
            } else{
                n.setDerecho(new NodoABB(elemento));
            }
        }

        return exito;
    }

    /*
    public boolean eliminar(Comparable elemento){

    }

    public Lista listar(){

    }

    public Lista listarRango(Comparable elemMin, Comparable elemMax){

    }

    public Comparable minimoElem(){

    }

    public Comparable maximoElem(){

    }

    public boolean vacio(){

    }

    public boolean eliminarMinimo(){

    }

    public boolean eliminarMaximo(){

    }

     */


    public ArbolBB clone() {
        /* Crea el arbol clon vacio, si this.raiz no es vacío llama al método privado clone con su raiz
         */
        // Zona de declaración de variables
        ArbolBB clon;
        // Zona de inicialización de variables
        clon = new ArbolBB();

        if(this.raiz != null) {
            clon.raiz = cloneAux(this.raiz);
        }
        return clon;
    }
    private NodoABB cloneAux(NodoABB raiz) {
        // Zona de declaración de variables
        NodoABB nuevo;
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

    private String toStringAux(NodoArbol original, String s) {
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
                    s = s + "HI: null" + "\t\t" + "HD: " + derAux.getElem();// + izqAux.getElem() + "HD: null";
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

}
