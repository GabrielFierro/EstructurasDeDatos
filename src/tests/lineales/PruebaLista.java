package tests.lineales;
 
import lineales.dinamicas.*;
 
public class PruebaLista {
 
    public static void main(String[] args) {
        // Zona de declaración de variables
        Lista l1, l2, listaConcat, listaInvert;
        int i;
        boolean valor;
       
        System.out.println("***************COMIENZO A CARGAR LA LISTA 1***************");
        l1 = new Lista();
        /*generarLista(l1);
        System.out.println("\nMuestro la lista previamente cargada: " + l1.toString());
        */
        /*System.out.println("Inserta 2 en posicion 1: " + l1.insertar(2, 1));
        System.out.println("Inserta 4 en posicion 2: " + l1.insertar(4, 2));
        System.out.println("Inserta 6 en posicion 3: " + l1.insertar(6, 3));
        */
       
        System.out.println("Inserta 9 en posicion 1: " + l1.insertar(9, 1));
        System.out.println("Inserta 6 en posicion 2: " + l1.insertar(6, 2));
        System.out.println("Inserta 5 en posicion 3: " + l1.insertar(5, 3));
        System.out.println("Inserta 0 en posicion 4: " + l1.insertar(0, 4));
        System.out.println("Inserta 9 en posicion 5: " + l1.insertar(9, 5));
        System.out.println("Inserta 6 en posicion 6: " + l1.insertar(6, 6));
        System.out.println("Inserta 5 en posicion 7: " + l1.insertar(5, 7));
        System.out.println("Inserta 0 en posicion 8: " + l1.insertar(0, 8));
        System.out.println("Inserta 5 en posicion 9: " + l1.insertar(5, 9));
        System.out.println("Inserta 6 en posicion 10: " + l1.insertar(6, 10));
        System.out.println("Inserta 9 en posicion 11: " + l1.insertar(9, 11));
       
       
        /*
       
        System.out.println("\n***************COMIENZO A CARGAR LA LISTA 2***************");
        l2 = new Lista();
        System.out.println("Inserta 5 en posicion 1: " + l2.insertar(5, 1));
        System.out.println("Inserta 1 en posicion 2: " + l2.insertar(1, 2));
        System.out.println("Inserta 6 en posicion 3: " + l2.insertar(6, 3));
        System.out.println("Inserta 7 en posicion 4: " + l2.insertar(7, 4));
       
        System.out.println("\n***************EJECUTO EL METODO CONCATENAR***************");
       
        listaConcat = concatenar(l1,l2);
       
        System.out.println("\nMuestro la lista concatenada: " + listaConcat.toString());
       
       
        System.out.println("\n***************EJECUTO EL METODO INVERTIR***************");
       
        listaInvert = invertir(l2);
       
        System.out.println("\nLista original: " + l2.toString());
        System.out.println("\nLista invertida: " + listaInvert.toString());
       
        */
       
       
        valor = comprobar(l1);
       
        if(valor) {
            System.out.println("La lista está ordenada");
        }
        else {
            System.out.println("La lista no está ordenada");
        }
    }
public static void generarLista(Lista lis) {
    /* Algoritmo que recibe una estructura de tipo Lista por parametro, y carga la misma
     *
     */
    // Zona de declaración de variables
    int i;
   
    for(i=0; i<10; i++) {
        lis.insertar(i * 3 + 1, i);
    }
}
public static Lista concatenar(Lista l1, Lista l2) {
    /* Algoritmo que recibe dos estructuras de tipo Lista por parámetro y devuelve una lista invertida con
     * los elementos de ambas listas mencionadas, con sus valores concatenados.
     */
    // Zona de declaración de variables
    Lista clon1, clon2, listaNueva;
    int i;
    Object elemento;
    Pila p;
    // Zona de inicializacion de variables
    clon1 = l1.clone();
    clon2 = l2.clone();
    listaNueva = new Lista();
    p = new Pila();
    i = 1;
   
    while(!clon1.esVacia()) {
        elemento = clon1.recuperar(1);  // Obtengo el primer elemento de clon1
        p.apilar(elemento); // Apilo el elemento obtenido de clon1 (LIFO)
        clon1.eliminar(1);  // Elimino de la lista clonada el elemento
       
        if(!p.esVacia()) {  // Si la pila no esta vacia carga los elementos en la lista nueva y desapila
            listaNueva.insertar(p.obtenerTope(),i);
            p.desapilar();
            i++;
        }
    }
    while(!clon2.esVacia()) {
        elemento = clon2.recuperar(1);  // Obtengo el primer elemento de clon2
        p.apilar(elemento); // Apilo el elemento obtenido de clon2 (LIFO)
        clon2.eliminar(1);  // Elimino de la lista clonada el elemento
       
        if(!p.esVacia()) {  // Si la pila no esta vacia carga los elementos en la lista nueva y desapila
            listaNueva.insertar(p.obtenerTope(),i);
            p.desapilar();
            i++;
        }
    }
    return listaNueva;
}
public static Lista invertir(Lista unaLista) {
    /* Algoritmo que recibe una estructura de tipo Lista por parámetro, crea una nueva lista, en la cual
     * inserta los elementos de la lista recibida por parametro y luego la retorna.
     */
    // Zona de declaracion de variables
    Lista clon, nuevaLista;
    Pila nuevaPila;
    Object elemento;
    // Zona de inicializacion de variables
    clon = unaLista.clone();
    nuevaLista = new Lista();
    nuevaPila = new Pila();
   
    while(!clon.esVacia()) {
        elemento = clon.recuperar(1);
        nuevaPila.apilar(elemento);
        clon.eliminar(1);
       
        if(!nuevaPila.esVacia()) {
            nuevaLista.insertar(nuevaPila.obtenerTope(), 1);
            nuevaPila.desapilar();
        }
    }
    return nuevaLista;
}
public static boolean comprobar(Lista l1) {
    /* Algoritmo que recibe una estructura de tipo Lista por parámetro con una cadena de digitos del 0 al 9,
     * verifica que cumpla con el orden "cadena0cadena0cadena'", donde cadena' es la inversa y retorna un
     * valor booleano.
     */
    // Zona de declaracion de variables
    boolean exito;
    int longitud, cant;
    Lista clon;
    Cola nuevaCola;
    Pila nuevaPila;
    Object elemento;
    // Zona de inicializacion de variables
    exito = false;	// Establezco que la lista inicialmente no esta ordenada
    longitud = 0;
    clon = l1.clone();
    nuevaCola = new Cola();
    nuevaPila = new Pila();
    elemento = clon.recuperar(1);
   
    while(!elemento.equals(0)) {
       
        elemento = clon.recuperar(1);
       
        if(elemento.equals(0)) {
            clon.eliminar(1);
        }
        else {
            nuevaCola.poner(elemento);
            nuevaPila.apilar(elemento);
            clon.eliminar(1);
            longitud++;
            exito = true; 
        }
    }
    cant = longitud;
   
    while(exito && longitud>0) {
        elemento = clon.recuperar(1);
        clon.eliminar(1);
        if(elemento.equals(0)) {
            clon.eliminar(1);
        }
        if(elemento.equals(nuevaCola.obtenerFrente())) {
            exito = true;	// Si el elemento coincide con el de la Cola considero que cumple el orden
        }
        nuevaCola.sacar();
        longitud--;
        if(longitud == 0) { // Elimina el elemento 0 de la lista clonada
            clon.eliminar(1);
        }
    }
    while(exito && cant > 0) {
        elemento = clon.recuperar(1);
        clon.eliminar(1);
        if(elemento.equals(0)) {
            clon.eliminar(1);
        }
        if(elemento.equals(nuevaPila.obtenerTope())) {
            exito = true;	// Si el elemento coincide con el de la Pila considero que cumple el orden
        }
        nuevaPila.desapilar();
        cant--;
        if(cant == 0) { // Elimina el elemento 0 de la lista clonada
            clon.eliminar(1);
        }
    }
    return exito;
}
}