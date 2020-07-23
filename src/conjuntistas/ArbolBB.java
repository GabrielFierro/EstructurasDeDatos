package conjuntistas;

import jerarquicas.NodoArbol;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Nodo;

import java.util.concurrent.ConcurrentMap;

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

    public boolean eliminar(Comparable elem) {
        /* Algoritmo que dado un elemento de tipo Comparable, verifica que la raiz de la estructura de tipo Arbol
         * Binario de Busqueda tenga un nodo. En caso de que sea verdadero llama al metodo eliminarAux con dicho elem,
         * junto a la raiz del mencionado arbol, y procede a eliminar dicho elemento. Luego, si pudo eliminar el
         * elemento retorna true, y, en caso contrario, retorna false.
         */
        // Zona de declaracion de variables
        boolean exito;
        // Zona de inicializacion de variables
        exito = false;

        if (this.raiz != null) {
            exito = eliminarAux(elem, this.raiz, null);
        }
        return exito;
    }

    private boolean eliminarAux(Comparable elem, NodoABB nodo, NodoABB padre) {
        /* Algoritmo que recibe por parametro un elemento de tipo Comparable, un nodo de tipo NodoABB junto a otro nodo
         * de tipo ABB. Identifica el nodo que se desea eliminar, es decir, puede ser un nodo hoja o un nodo que tenga
         * un solo hijo. Luego, invoca el metodo eliminarNodoHoja o eliminarHijo respectivamente, y procede a eliminar
         * el elemento deseado. Retorna true si pudo eliminar y falso en caso contrario.
         */
        // Zona de declaracion de variables
        boolean exito;
        // Zona de inicializacion de variables
        exito = true;

        if (nodo != null) {
            Comparable elemento = nodo.getElem();

            if (elem.compareTo(elemento) < 0) {   // Analizo la rama izquierda
                exito = eliminarAux(elem, nodo.getIzquierdo(), nodo);
            } else {
                if (elem.compareTo(elemento) > 0) {   // Analizo la rama derecha
                    exito = eliminarAux(elem, nodo.getDerecho(), nodo);
                } else {
                    if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {   // No tiene hijos
                        exito = eliminarNodoHoja(nodo, padre);
                    } else {
                        if (nodo.getIzquierdo() == null || nodo.getDerecho() == null) {   // Tiene un solo hijo
                            exito = eliminarHijo(nodo, padre);
                        }
                    }
                }
            }
        } else {
            exito = false;  // En caso de que el elemento no se encuentre en la estructura
        }
        return exito;
    }

    private boolean eliminarNodoHoja(NodoABB hijo, NodoABB padre) {
        /* Recibe por parametro el elemento que se desea eliminar y llama al metodo eliminar1Aux. Retorna verdadero si
         * el elemento se pudo eliminar y falso en caso contrario y se procede a removerlo del arbol. Si no se encuentra
         * el elemento no se puede realizar la eliminacion. Devuelve verdadero si el elemento se elimina de la estructura
         * y falso en caso contrario.
         */
        // Zona de declaracion de variables
        boolean exito, esHoja;
        // Zona de inicializacion de variables
        exito = true;

        if (padre == null) {  // Caso raiz
            this.raiz = null;
        } else {
            if (padre.getIzquierdo() != null && padre.getIzquierdo().getElem().compareTo(hijo.getElem()) == 0) {
                padre.setIzquierdo(null);
            } else if (padre.getDerecho() != null && padre.getDerecho().getElem().compareTo(hijo.getElem()) == 0) {
                padre.setDerecho(null);
            }
        }
        return exito;
    }

    private boolean eliminarHijo(NodoABB hijo, NodoABB padre) {
        /* Algoritmo que recibe por parametro un nodo hijo de tipo NodoABB junto a otro nodo padre de tipo NodoABB,
         * y busca al hijo por la rama del arbol correspondiente. Una vez encontrado, se elimina el nodo hijo.
         * El algoritmo retorna true, dado que siempre es posible eliminar en esta instancia.
         */
        // Zona de declaracion de variables
        boolean exito;
        // Zona de inicializacion de variables
        exito = true;

        if (hijo.getElem().compareTo(padre.getElem()) < 0) {  // Pregunto si el hijo esta del lado izquierdo
            if (hijo.getDerecho() != null) {  // Tiene hijo derecho
                NodoABB aux = hijo.getDerecho();
                padre.setDerecho(aux);
            } else {   // Tiene hijo izquierdo
                NodoABB aux = hijo.getIzquierdo();
                padre.setIzquierdo(aux);
            }
        } else {
            if (hijo.getElem().compareTo(padre.getElem()) > 0) {  // Pregunto si el hijo esta del lado derecho
                if (hijo.getDerecho() != null) {  // Tiene hijo derecho
                    NodoABB aux = hijo.getDerecho();
                    padre.setDerecho(aux);
                } else {   // Tiene hijo izquierdo
                    NodoABB aux = hijo.getIzquierdo();
                    padre.setIzquierdo(aux);
                }
            }
        }
        return exito;
    }

    private NodoABB obtenerNodo(NodoABB nodo, Object buscado) {
        /* M�todo privado que busca un elemento y devuelve el nodo que lo contiene.
         * Si no se encuentra el buscado devuelve null
         */
        // Zona de declaraci�n de variables
        NodoABB resultado;
        // Zona de inicializaci�n de variables
        resultado = null;

        if (nodo != null) {
            if (nodo.getElem().equals(buscado)) {
                // Si el buscado es n, lo devuelve
                resultado = nodo;
            } else {
                // No es el buscado: busca el primero en el HI
                resultado = obtenerNodo(nodo.getIzquierdo(), buscado);
                // Si no lo encuentra en el HI, busca en HD
                if (resultado == null) {
                    resultado = obtenerNodo(nodo.getDerecho(), buscado);
                }
            }
        }
        return resultado;
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

        if (nodo != null) {
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
        /* Algoritmo que recibe por parametro un nodo de tipo NodoABB junto a una lista de tipo Lista, y carga la misma
         * con el elemento nodo y su/s hijo/s si los tuviese.
         */
        // Zona de declaraci�n de variables
        NodoABB nodoActual;

        if (nodo != null) {
            nodoActual = new NodoABB(nodo.getElem());

            listarAux(nodo.getDerecho(), l);    // Llamado recursivo por la rama derecha
            l.insertar(nodoActual.getElem(), 1);
            listarAux(nodo.getIzquierdo(), l);  // Llamado recursivo por la rama izquierda
        }
    }

    public Lista listarPorRango(Comparable elemMin, Comparable elemMax) {
        /* Recorre parte del arbol (solo lo necesario) y devuelve una lista ordenada con los elementos que se encuentran
         *en el intervalo [elemMinimo, elemMaximo]
         */
        // Zona de declaracion de variables
        Lista lis;
        // Zona de declaracion de variables
        lis = new Lista();

        if (this.raiz != null && (elemMin.compareTo(elemMax) < 0)) {
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
         * Retorna verdadero si pudo eliminarlo y falso en caso contrario.
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
        s = "Arbol vacio";

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

    public int cantidadDeHojas() {
        // Zona de declaracion de variables
        int resultado;
        // Zona de inicializacion de variables
        resultado = 0;

        if (this.raiz != null) {
            resultado = cantidadDeHojasAux(this.raiz);
        }
        return resultado;
    }

    private int cantidadDeHojasAux(NodoABB nodo) {
        // Zona de declaracion de variables
        int cant;
        // Zona de inicializacion de variables
        cant = 0;
        if (nodo != null) {
            cant += cantidadDeHojasAux(nodo.getIzquierdo());
            cant += cantidadDeHojasAux(nodo.getDerecho());
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                cant++;
            }
        }
        return cant;
    }

    public int contarNodosEnUnRango(int min, int max) {
        /* Algoritmo que recibe por parametro dos valores de tipo entero que representan un rango numerico. Verifica que
         * la estructura tenga por lo menos un elemento y que el rango sea correcto. Si se cumple invoca al metodo
         * contarNodosEnUnRangoAux. Por ultimo retorna la cantidad de elementos que se encuentran dentro de dicho rango,
         * en caso de no haber elementos se retorna -1.
         */
        // Zona de inicializacion de variables
        int resultado;
        // Zona de declaracion de variables
        resultado = -1;

        if (this.raiz != null && min < max) {
            resultado = contarNodosEnUnRangoAux(this.raiz, min, max);
        }
        return resultado;
    }

    private int contarNodosEnUnRangoAux(NodoABB nodo, int min, int max) {
        /* Algoritmo que dado un nodo de tipo NodoABB junto a dos valores de tipo entero que representan un rango de
         * valores, determina la cantidad de nodos que se encuentran dentro de dicho rango, retornando el resultado.
         */
        // Zona de declaracion de variables
        Comparable elem;
        NodoABB izq, der;
        int cant;
        // Zona de inicializacion de variables
        cant = 0;

        if (nodo != null) {
            elem = nodo.getElem();

            cant += contarNodosEnUnRangoAux(nodo.getDerecho(), min, max);
            cant += contarNodosEnUnRangoAux(nodo.getIzquierdo(), min, max);
            if (elem.compareTo(max) <= 0 && elem.compareTo(min) >= 0) {
                cant++;
            }
        }
        return cant;
    }

    public Comparable mejorCandidato(Comparable elem){
        /* Algoritmo que recibe un elemento de tipo Comparable por par�metro, obtiene el nodo de dicho elemento y si,
        * tal nodo no es nulo invoca al m�todo mejorCandidatoAux().
        * En caso de que el nodo sea nulo, retorna el elemento 0.
        */
        // Zona de declaraci�n de variables
        Comparable elemento;
        NodoABB nodo;
        // Zona de inicializaci�n de variables
        elemento = 0;

        nodo = obtenerNodo(this.raiz, elem);    // Obtengo el nodo del elemento recibido por par�metro

        if (nodo != null) {
            elemento = mejorCandidatoAux(nodo, elem);
        }
        return elemento;
    }

  /*  private Comparable mejorCandidatoAux(NodoABB nodo, Comparable elem){
        /* Algoritmo que recibe un nodo de tipo NodoABB junto a un elemento de tipo Comparable por par�metro y determina
         * el elemento candidato que se encuentre m�s cerca de elem.
         * Si el nodo no tiene ning�n hijo, retorna el valor -1.
         * Sino, si tiene hijo izquierdo �nicamente, �ste se considera como el candidato.
         * Ahora, si tiene hijo derecho �nicamente, �ste se considera como el candidato.
         */
  /*      // Zona de declaraci�n de variables
        Comparable candidato, candidatoIzq, candidatoDer;
        int diferenciaIzq, diferenciaDer;
        NodoABB izquierdo, derecho;
        // Zona de inicializaci�n de variables
        candidato = 0;
        candidatoIzq = 0;
        candidatoDer = 0;
        diferenciaIzq = 0;
        diferenciaDer = 0;
        izquierdo = nodo.getIzquierdo();
        derecho = nodo.getDerecho();

        if (izquierdo == null && derecho == null) {   // Cubro el caso de que el nodo no tenga hijos
            candidato = -1;
        } else {
            if (izquierdo != null) {
                System.out.println("izquierdo: " + izquierdo.getElem());
                candidatoIzq = obtenerCandidato(izquierdo, false);  // Busca el mayor por el lado izquierdo
                diferenciaIzq = obtenerDiferencia(candidatoIzq, elem);  // Calcula la diferencia entre candidatoIzq y elem
            }
            if (derecho != null) {
                System.out.println("derecho: " + derecho.getElem());
                candidatoDer = obtenerCandidato(derecho, true); // Busca el menor por el lado derecho
                diferenciaDer = obtenerDiferencia(candidatoDer, elem);  // Calcula la diferencia entre candidatoDer y elem
            }
            // Determina el mejor candidato
            System.out.println("\ndiferenciaIzq: " + diferenciaIzq + "\tdiferenciaDer: " + diferenciaDer);
            System.out.println("\ncandidatoIzq: " + candidatoIzq + "\tcandidatoDer: " + candidatoDer);
            if (diferenciaIzq < diferenciaDer) {
                if (derecho != null) {
                   // System.out.println("Entro con candidatoIzq");
                 //   candidato = candidatoIzq;   // Cubro el caso de que el nodo tenga solamente rama izquierda
                //}
                //else {
                    candidato = candidatoDer;   // Cubro el caso de que el nodo tenga solamente rama derecha
                }
            } else {
                if (derecho == null) {
                    candidato = candidatoIzq;   // Cubro el caso de que tenga solo hijo izquierdo
                } else {
                    candidato = candidatoDer;   // Cubro el caso de que tenga solo hijo derecho
                }
            }
        }
        return candidato;
    }*/

    private Comparable mejorCandidatoAux(NodoABB nodo, Comparable elem){
        /* Algoritmo que recibe un nodo de tipo NodoABB junto a un elemento de tipo Comparable por par�metro y determina
         * el elemento candidato que se encuentre m�s cerca de elem.
         * Si el nodo no tiene ning�n hijo, retorna el valor -1.
         * Sino, si tiene hijo izquierdo �nicamente, �ste se considera como el candidato.
         * Ahora, si tiene hijo derecho �nicamente, �ste se considera como el candidato.
         */
        // Zona de declaraci�n de variables
        Comparable candidato, candidatoIzq, candidatoDer;
        int diferenciaIzq, diferenciaDer;
        NodoABB izquierdo, derecho;
        // Zona de inicializaci�n de variables
        candidato = 0;
        candidatoIzq = 0;
        candidatoDer = 0;
        diferenciaIzq = 0;
        diferenciaDer = 0;
        izquierdo = nodo.getIzquierdo();
        derecho = nodo.getDerecho();

        if (izquierdo == null && derecho == null) {   // Cubro el caso de que el nodo no tenga hijos
            candidato = -1;
        } else {
            if (izquierdo != null) {
                candidatoIzq = obtenerCandidato(izquierdo, false);  // Busca el mayor por el lado izquierdo
                diferenciaIzq = obtenerDiferencia(candidatoIzq, elem);  // Calcula la diferencia entre candidatoIzq y elem
            }
            if (derecho != null) {
                candidatoDer = obtenerCandidato(derecho, true); // Busca el menor por el lado derecho
                diferenciaDer = obtenerDiferencia(candidatoDer, elem);  // Calcula la diferencia entre candidatoDer y elem
            }

            if(izquierdo == null){
                candidato = candidatoDer;   // Cubro el caso de que tenga solo HD
            }else{
                if(derecho == null){
                    candidato = candidatoIzq;   // Cubro el caso de que tenga solO HI
                }else{
                    if(diferenciaIzq < diferenciaDer){  // Si tiene HI y HD, determino que elemento se encuentra m�s cerca
                        candidato = candidatoIzq;
                    }else{
                        candidato = candidatoDer;
                    }
                }
            }
        }
        return candidato;
    }


    private Comparable obtenerCandidato(NodoABB nodo, boolean recorrido){
        /* Algoritmo que recibe un nodo de tipo NodoABB junto a una variable booleana por par�metro, y determina el
         * candidato de dicho nodo teniendo en cuenta el valor de dicha variable booleana.
         * Si el valor de la variable booleana es true, recorre por la rama izquierda hasta encontrar el menor elemento.
         * En caso contrario, recorre por la rama derecha hasta encontrar el mayor elemento.
         */
        // Zona de declaraci�n de variables
        NodoABB izquierdo, derecho;
        // Zona de inicializaci�n de variables
        Comparable elemento;
        boolean encontrado;
        // Zona de inicializacion de variables
        elemento = null;
        encontrado = false;

        while (nodo != null && !encontrado) {

            if(recorrido) { // Recorrido por la izquierda con el nodo que recibe por par�metro
                if (nodo.getIzquierdo() != null) {
                    nodo = nodo.getIzquierdo();
                } else {
                    elemento = nodo.getElem();
                    encontrado = true;
                }
            }else{  // Recorrido por la derecha con el nodo que recibe por par�metro
                if (nodo.getDerecho() != null) {
                    nodo = nodo.getDerecho();
                } else { // Encontro el elemento
                    elemento = nodo.getElem();
                    encontrado = true;
                }
            }
        }
        return elemento;
    }

    private int obtenerDiferencia(Comparable candidato, Comparable elem){
        /* Algoritmo que dados dos elementos de tipo Comparable, calcula la diferencia absoluta entre ambos, y
         * retorna el resultado
         */
        // Zona de declaraci�n de variables
        int resultado;

        resultado = Math.abs((int) candidato - (int) elem);

        return resultado;
    }

    private boolean verificarNodoHoja(NodoABB nodo) {
        /* Algoritmo que dado un elemento que recibe por par�metro, determina si el mismo se encuentra en la estructura
         * de tipo arbol binario de busqueda, y verifica si no posee hojas. En caso afirmativo retorna true, en caso
         * contrario retorna false.
         */
        // Zona de declaracion de variables
        boolean exito;
        // Zona de inicializacion de variables
        exito = true;

        if (nodo != null) {
            if (nodo.getIzquierdo() != null && nodo.getDerecho() != null) {
                exito = false;
            }
        }
        return exito;
    }
}