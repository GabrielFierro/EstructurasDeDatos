package conjuntistas;

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
    */
}
