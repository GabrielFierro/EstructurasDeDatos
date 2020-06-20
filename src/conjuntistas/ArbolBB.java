package conjuntistas;

import jerarquicas.NodoArbol;
import lineales.dinamicas.Lista;

public class ArbolBB {

    // Zona de declaracion de atributos
    private NodoABB raiz;

    public boolean insertar(Comparable elemento) {
        /* Recibe por parametro un elemento y lo agrega en el arbol de manera ordenada. Si el elemento ya se encuentra
         * en el arbol no se realiza la insercion. Devuelve verdadero si el elemento se agrega a la estructura y falso
         * en caso contrario.
         */
        // Zona de declaracion de variables
        boolean exito;
        // Zona de inicializacion de variables
        exito = true;

        if (this.raiz == null) {
            this.raiz = new NodoABB(elemento);
        } else {
            exito = insertarAux(this.raiz, elemento);
        }
        return exito;
    }

    private boolean insertarAux(NodoABB n, Comparable elemento) {
        // Precondicion: n no es nulo
        // Zona de declaracion de variables
        boolean exito;
        // Zona de inicializacion de variables
        exito = true;

        if ((elemento.compareTo(n.getElem()) == 0)) {
            // Reportar error: Elemento repetido
            exito = false;
        } else if (elemento.compareTo(n.getElem()) < 0) {
            // elemento es menor que n.getElem()
            // si tiene HI baja a la izquierda, sino agrega elemento
            if (n.getIzquierdo() != null) {
                exito = insertarAux(n.getIzquierdo(), elemento);
            } else {
                n.setIzquierdo(new NodoABB(elemento));
            }
        } else { // elemento es mayor que n.getElem()
            // si tiene HD baja a la derecha, sino agrega elemento
            if (n.getDerecho() != null) {
                exito = insertarAux(n.getDerecho(), elemento);
            } else {
                n.setDerecho(new NodoABB(elemento));
            }
        }

        return exito;
    }

    public boolean eliminar1(Comparable elemento) {
        /* Recibe por parametro el elemento que se desea eliminar y llama al metodo eliminar1Aux. Retorna verdadero si
        * el elemento se pudo eliminar y falso en caso contrario y se procede a removerlo del arbol. Si no se encuentra
        * el elemento no se puede realizar la eliminacion. Devuelve verdadero si el elemento se elimina de la estructura
        * y falso en caso contrario.
        */
        // Zona de declaracion de variables
        boolean exito;
        // Zona de inicializacion de variables
        exito = false;

        if (this.raiz != null) {
            if((this.raiz.getElem().compareTo(elemento) == 0) && this.raiz.getIzquierdo()!=null || this.raiz.getDerecho()!=null){
                exito = eliminar1Aux(this.raiz, elemento);
            }
        }
        return exito;
    }

    private boolean eliminar1Aux(NodoABB nodo, Comparable elemento) {
        /* Algoritmo que recibe por parametro el elemento que se desea eliminar y se procede a removerlo del arbol.
         * Contemplando el caso en el que el nodo a eliminar es nodo hoja.
         */
        // Zona de declaracion de variables
        boolean exito;
        NodoABB nodoPadre, nodoHijo;
        // Zona de inicializacion de variables
        exito = false;

        if (nodo != null && !exito) {

            if (nodo.getDerecho() != null && nodo.getDerecho().getElem().compareTo(elemento) <= 0) {  // Recorre rama derecha
                nodoPadre = nodo;
                nodoHijo = nodo.getDerecho();
                exito = eliminar1Aux(nodoHijo, elemento);

                if (nodoHijo.getIzquierdo() == null && nodoHijo.getDerecho() == null) {
                    if (nodoHijo.getElem().compareTo(elemento) == 0) {  // Si encontre el elemento lo elimino
                        nodoPadre.setDerecho(null);
                        exito = true;
                    }
                }
            } else {
                if (nodo.getIzquierdo() != null && nodo.getIzquierdo().getElem().compareTo(elemento) >= 0) { // Recorre rama izquierda
                    nodoPadre = nodo;
                    nodoHijo = nodo.getIzquierdo();
                    exito = eliminar1Aux(nodoHijo, elemento);

                    if (nodoHijo.getIzquierdo() == null && nodoHijo.getDerecho() == null) {
                        if (nodoHijo.getElem().compareTo(elemento) == 0) { // Si encontre el elemento lo elimino
                            nodoPadre.setIzquierdo(null);
                            exito = true;
                        }
                    }
                }
            }
        }
        return exito;
    }

    public boolean eliminar2(Comparable elemento) {
        /* Recibe por parametro el elemento que se desea eliminar y llama al metodo eliminar2Aux. Se procede a removerlo
         * del arbol. Si no se encuentra el elemento no se puede eliminar. Devuelve verdadero si el elemento se elimina
         * de la estructura y falso en caso contrario.
        */
        // Zona de declaracion de variables
        boolean exito;
        // Zona de inicializacion de variables
        exito = false;

        if (this.raiz != null) {
            if((this.raiz.getElem().compareTo(elemento) == 0) || this.raiz.getIzquierdo()!=null || this.raiz.getDerecho()!=null){
                exito = eliminar2Aux(this.raiz, elemento);
            }
        }
        return exito;
    }

    private boolean eliminar2Aux(NodoABB nodo, Comparable elemento) {
        /* Algoritmo que recibe por parametro el elemento que se desea eliminar y se procede a removerlo del arbol.
         * Contemplando el caso donde el nodo que se desea eliminar posee un hijo. Por lo que el nodo hijo, debe tomar
         * el lugar del nodo padre.
         */
        // Zona de declaracion de variables
        boolean exito;
        NodoABB nodoPadre, nodoHijo;
        // Zona de inicializacion de variables
        exito = false;

        if(nodo != null){
            if(nodo.getDerecho() != null && nodo.getDerecho().getElem().compareTo(elemento) <= 0){  // Recorre rama derecha
                nodoPadre = nodo;
                nodoHijo = nodo.getDerecho();
                exito = eliminar1Aux(nodoHijo, elemento);
                if(nodoHijo.getElem().compareTo(elemento) == 0){    // Si encontre el elemento lo elimino
                    nodoPadre.setDerecho(nodoHijo.getDerecho());
                    exito = true;
                }
            } else{
                if(nodo.getIzquierdo() != null && nodo.getIzquierdo().getElem().compareTo(elemento) >= 0){ // Recorre rama izquierda
                    nodoPadre = nodo;
                    nodoHijo = nodo.getIzquierdo();
                    exito = eliminar1Aux(nodoHijo, elemento);
                    if(nodoHijo.getElem().compareTo(elemento) == 0){ // Si encontre el elemento lo elimino
                        nodoPadre.setIzquierdo(nodoHijo.getIzquierdo());
                        exito = true;
                    }
                }
            }
        }
        return exito;
    }

    public boolean pertenece(Comparable elemento) {
        // Devuelve verdadero si el elemento recibido por parametro esta en el arbol y falso en caso contrario.
        // Zona de declaracion de variables
        boolean pertenece;
        // Zona de inicializacion de variables
        pertenece = false;

        if (this.raiz != null) {
            pertenece = perteneceAux(elemento, this.raiz);
        }
        return pertenece;
    }

    private boolean perteneceAux(Comparable elemento, NodoABB nodo) {
        /* Algoritmo que recibe por parametro un elemento junto a un nodo y recorre el arbol en busca de dicho
         * elemento. Retorna verdadero si encontro el elemento y falso en caso contrario.
         */
        // Zona de declaracion de variables
        boolean pertenece;
        Comparable elem;
        // Zona de inicializacion de variables
        pertenece = false;

        if(nodo != null) {
            if (elemento.compareTo(nodo.getElem()) == 0) {
                pertenece = true;
            } else {
                if (elemento.compareTo(nodo.getElem()) < 0) {
                    pertenece = perteneceAux(elemento, nodo.getIzquierdo());
                }
                if (elemento.compareTo(nodo.getElem()) > 0) {
                    pertenece = perteneceAux(elemento, nodo.getDerecho());
                }
            }
        }
        return pertenece;
    }

    public Lista listar() {
        // Recorre el arbol completo,y devuelve una lista ordenada con los elementos que se encuentran almacenados en el
        // Zona de declaraci�n de variables
        Lista listaNueva;
        // Zona de inicializaci�n de variables
        listaNueva = new Lista();

        if (this.raiz != null) {
            listarAux(this.raiz, listaNueva);
        }
        return listaNueva;
    }

    private void listarAux(NodoABB nodo, Lista l) {
        /*
         */
        // Zona de declaraci�n de variables
        NodoABB nodoActual;

        if (nodo != null) {
            nodoActual = new NodoABB(nodo.getElem());

            listarAux(nodo.getDerecho(), l);
            l.insertar(nodoActual.getElem(), 1);
            listarAux(nodo.getIzquierdo(), l);
        }
    }

    public Lista listarRango(Comparable elemMin, Comparable elemMax) {
        /* Recorre parte del arbol (solo lo necesario) y devuelve una lista ordenada con los elementos que se encuentran
         *en el intervalo [elemMinimo, elemMaximo]
         */
        // Zona de declaracion de variables
        Lista lis;
        // Zona de declaracion de variables
        lis = new Lista();

        if (this.raiz != null) {
            listarRangoAux(elemMin, elemMax, this.raiz, lis);
        }
        return lis;
    }

    private void listarRangoAux(Comparable elemMin, Comparable elemMax, NodoABB nodo, Lista lis) {
        /* Algoritmo que recibe por parametro un elemento minimo, un elemento maximo y el nodo raiz de un arbol.
         * A partir del nodo recorre el arbol entre los valores dados, y retorna una lista con el camino que va desde
         * el menor elemento hasta el maximo elemento.
         */
        // Zona de declaracion de variables
        Comparable elem;

        if (nodo != null) {
            elem = nodo.getElem();

            listarRangoAux(elemMin, elemMax, nodo.getDerecho(), lis);
            if (elemMax.compareTo(elem) >= 0 && elemMin.compareTo(elem) <= 0) {
                lis.insertar(elem, 1);
            }
            listarRangoAux(elemMin, elemMax, nodo.getIzquierdo(), lis);
        }
    }


    public Comparable minimoElem() {
        // Recorre la rama correspondiente y devuelve el elemento m�s peque�o almacenado en el �rbol
        // Zona de declaracion de variables
        NodoABB nodo;
        Comparable elemento;
        boolean encontrado;
        // Zona de inicializacion de variables
        nodo = this.raiz;
        elemento = null;
        encontrado = false;

        while (this.raiz != null && !encontrado) {

            if (nodo.getIzquierdo() != null) {
                nodo = nodo.getIzquierdo();
            } else {
                elemento = nodo.getElem();
                encontrado = true;
            }
        }
        return elemento;
    }

    public Comparable maximoElem() {
        // Recorre la rama correspondiente y devuelve el elemento m�s grande almacenado en el arbol
        // Zona de declaracion de variables
        NodoABB nodo;
        Comparable elemento;
        boolean encontrado;
        // Zona de inicializacion de variables
        nodo = this.raiz;
        elemento = null;
        encontrado = false;

        while (this.raiz != null && !encontrado) {

            if (nodo.getDerecho() != null) {
                nodo = nodo.getDerecho();
            } else { // Encontro el elemento
                elemento = nodo.getElem();
                encontrado = true;
            }
        }
        return elemento;
    }

    public boolean eliminarMinimo() {
        /* Recorre la rama correspondiente y elimina el minimo elemento almacenado en el arbol.
         *Retorna verdadero si pudo eliminarlo y falso en caso contrario.
         */
        // Zona de declaracion de variables
        NodoABB nodo, nodoPadre;
        boolean exito;
        // Zona de inicializacion de variables
        nodo = this.raiz;
        exito = false;
        nodoPadre = null;

        while (this.raiz != null && !exito) {

            if (nodo.getIzquierdo() != null) {    // Busca el elemento minimo hacia la izquierda
                nodoPadre = nodo;
                nodo = nodo.getIzquierdo();
            } else {
                nodoPadre.setIzquierdo(null);  // Como es nodo hoja (no tiene elementos mas chicos) cambio su enlace a null
                exito = true;
            }
        }
        return exito;
    }

    public boolean eliminarMaximo() {
        /* Recorre la rama correspondiente y elimina el maximo elemento almacenado en el arbol.
         *Retorna verdadero si pudo eliminarlo y falso en caso contrario.
         */
        // Zona de declaracion de variables
        NodoABB nodo, nodoPadre;
        boolean exito;
        // Zona de inicializacion de variables
        nodo = this.raiz;
        exito = false;
        nodoPadre = null;

        while (this.raiz != null && !exito) {

            if (nodo.getDerecho() != null) {    // Busca el elemento maximo hacia la derecha
                nodoPadre = nodo;
                nodo = nodo.getDerecho();
            } else {
                nodoPadre.setDerecho(null);  // Como es nodo hoja (no tiene elementos mas grandes) cambio su enlace a null
                exito = true;
            }
        }
        return exito;
    }

    public boolean esVacio() {
        /* Algoritmo que verifica si la estructura de tipo Arbol Binario de Busqueda no posee elementos.
         * En caso de no poseer retorna true, caso contrario, retorna false.
         */
        // Zona de declaraci�n de variables
        boolean exito;
        // Zona de inicializaci�n de variables
        exito = false;

        if (this.raiz == null) {
            exito = true;
        }
        return exito;
    }

    public void vaciar() {
        /* Algoritmo que quita todos los elementos de la estructura de tipo Arbol Binario de Busqueda
         */
        if (this.raiz != null) {
            this.raiz = null;
        }
    }

    public ArbolBB clone() {
        /* Crea el arbol clon vacio, si this.raiz no es vac�o llama al m�todo privado clone con su raiz
         */
        // Zona de declaraci�n de variables
        ArbolBB clon;
        // Zona de inicializaci�n de variables
        clon = new ArbolBB();

        if (this.raiz != null) {
            clon.raiz = cloneAux(this.raiz);
        }
        return clon;
    }

    private NodoABB cloneAux(NodoABB raiz) {
        // Zona de declaraci�n de variables
        NodoABB nuevo;
        // Zona de inicializaci�n de variables
        nuevo = raiz;

        if (raiz.getIzquierdo() != null) {
            nuevo.setIzquierdo(cloneAux(raiz.getIzquierdo()));
        } else {
            if (raiz.getDerecho() != null) {
                nuevo.setDerecho(cloneAux(raiz.getDerecho()));
            }
        }
        return nuevo;
    }

    @Override
    public String toString() {
        /* Algoritmo que muestra por pantalla, los elementos de una estructura de tipo Arbol.
         */
        // Zona de declaraci�n de variables
        String s;
        // Zona de inicializaci�n de variables
        s = "Arbol binario vacio";

        if (this.raiz != null) {
            s = toStringAux(this.raiz, "");
        }
        return s;
    }

    private String toStringAux(NodoABB original, String s) {
        // Zona de declaraci�n de variables
        NodoABB izqAux, derAux;

        if (original != null) {
            s = s + "\n" + original.getElem() + "\t";

            izqAux = original.getIzquierdo();
            derAux = original.getDerecho();

            if (izqAux != null && derAux != null) {
                s = s + "HI: " + izqAux.getElem() + "\t\t" + "HD: " + derAux.getElem();
            } else {
                if (izqAux == null && derAux != null) {
                    s = s + "HI: null" + "\t" + "HD: " + derAux.getElem();
                } else {
                    if (derAux == null && izqAux != null) {
                        s = s + "HI: " + izqAux.getElem() + "\t\t" + "HD: null";
                    } else {
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
