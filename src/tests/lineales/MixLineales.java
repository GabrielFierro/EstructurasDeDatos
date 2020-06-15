package tests.lineales;

import lineales.dinamicas.*;

import java.util.Scanner;

public class MixLineales {

	public static void main(String[] args) {
		/* Algoritmo que invoca al metodo testGenerarLista, el cual presenta diferentes casos de una estructura
		 * de tipo lista compuesto de caracteres. La consigna ademas estable que entre medio de ellos debe haber
		 * un caracter *.
		 */
		// Invocación del método testGenerarLista() que prueba distintos casos para el metodo generarLista.
        testGenerarLista();

	}
	public static Lista generarLista(Lista lis) {
	    /* Algoritmo que recibe una estructura de tipo Lista por parametro con elementos de tipo Char
	     * de la forma "caracter*caracter" y retorna una lista de la forma "Caracter Caracter CaracterInvertido".
	     * En caso de que la lista sea más extensa, el formato es separado por el caracter '*'.
	     */
	    // Zona de declaracion de variables
	    Lista clon, nuevaLista;
	    Pila nuevaPila;
	    Cola nuevaCola;
	    Object elemento;
		int i, ultPos;
		boolean exito;
	    // Zona de inicializacion de variables
	    clon = lis.clone();
	    nuevaLista = new Lista();
	    nuevaPila = new Pila();
	    nuevaCola = new Cola();
		i = 1;
		ultPos = clon.longitud();
		exito = true;

		if(!clon.esVacia()) {
			if (!clon.recuperar(1).equals('*') && !clon.recuperar(ultPos).equals('*')) {
				// Si en la primer o ultima posicion no encuentra el caracter '*' cumple la condición y ejecuta el
				// algoritmo siguiente
				while (!clon.esVacia()) {

					elemento = clon.recuperar(1); // Recupero el primer elemento de la estructura de tipo lista

					if (!elemento.equals('*')) {    // Si el elemento es distinto a '*'
						nuevaPila.apilar(elemento);
						nuevaCola.poner(elemento);
						nuevaLista.insertar(elemento, i);
						clon.eliminar(1);
						i++;
					} else {    // Si me encuentro con el caracter '*'
						exito = false;
						clon.eliminar(1);    // Elimino el caracter '*'
						while (!nuevaPila.esVacia()) {//Mientras la pila no este vacia inserto sus elementos en la lista
							elemento = nuevaPila.obtenerTope();
							nuevaLista.insertar(elemento, i);
							nuevaPila.desapilar();
							i++;
						}
						while (!nuevaCola.esVacia()) {    // Mientras la cola no este vacia, inserto sus elementos
							// en la lista
							elemento = nuevaCola.obtenerFrente();
							nuevaLista.insertar(elemento, i);
							nuevaCola.sacar();
							i++;
						}
						nuevaLista.insertar('*', i);
						i++;
					}
				}
			}
			if (!exito) {
				while (!nuevaCola.esVacia()) {
					if (!nuevaPila.esVacia()) {
						elemento = nuevaPila.obtenerTope();
						nuevaLista.insertar(elemento, i);
						nuevaPila.desapilar();
						i++;
					} else {
						elemento = nuevaCola.obtenerFrente();
						nuevaLista.insertar(elemento, i);
						nuevaCola.sacar();
						i++;
					}
				}
			} else {
				nuevaLista.vaciar();
			}
		}
	    return nuevaLista;
	}
	public static void testGenerarLista(){
		/* Algoritmo que presenta un menu de opciones. El cual realiza pruebas para determinar si una estructura
		 * de tipo Lista cumple con la condicion de estar compuesta de caracteres y entre medio poseer algun *.
		 * En caso de cumplirse dicha consigna se emite un cartel mostrando por pantalla la estructura generada.
		 * En caso contrario, emite un cartel que dice "La lista original no cumple con la consigna".
		 */
		// Zona de declaracion de variables
		int num;
		Scanner sc = new Scanner(System.in);
		Lista lista, l1;
		// Zona de inicializacion de variables
		lista = new Lista();
		l1 = new Lista();

		System.out.println("\nIngrese un numero para operar con el menu de opciones");
		System.out.println("\n0) Finalizar la ejecucion");
		System.out.println("\n1) Cargar lista de la forma \"*ABCDEF\"");
		System.out.println("\n2) Cargar lista de la forma \"ABCDEF*\"");
		System.out.println("\n3) Cargar lista de la forma \"AB*C*DEF\"");
		System.out.println("\n4) Cargar lista de la forma \"ABCDEF\"");
		System.out.println("\n5) Probar con lista vacia");
		System.out.print("\n");
		num = sc.nextInt();

		while(num < 0 || num > 5 ){
			System.out.println("\nIngreso mal el valor.Ingrese nuevamente un numero para operar con el menu de opciones");
			System.out.println("\n0) Finalizar la ejecucion");
			System.out.println("\n1) Cargar lista de la forma \"*ABCDEF\"");
			System.out.println("\n2) Cargar lista de la forma \"ABCDEF*\"");
			System.out.println("\n3) Cargar lista de la forma \"AB*C*DEF\"");
			System.out.println("\n4) Cargar lista de la forma \"ABCDEF\"");
			System.out.println("\n5) Probar con lista vacia");
			System.out.print("\n");
			num = sc.nextInt();
		}

		while(num != 0) {
			switch (num) {
				case 1:
					System.out.print("\n");
					System.out.println("************ COMIENZA LA CARGA DE LA LISTA \"*ABCDEF\" ************\n");
					System.out.println("Insertar el elemento *: " + lista.insertar('*', 1));
					System.out.println("Insertar el elemento A: " + lista.insertar('A', 2));
					System.out.println("Insertar el elemento B: " + lista.insertar('B', 3));
					System.out.println("Insertar el elemento C: " + lista.insertar('C', 4));
					System.out.println("Insertar el elemento D: " + lista.insertar('D', 5));
					System.out.println("Insertar el elemento E: " + lista.insertar('E', 6));
					System.out.println("Insertar el elemento F: " + lista.insertar('F', 7));

					l1 = generarLista(lista);	// Invocacion del metodo generarLista(lista)

					System.out.println("\nMuestro la lista original: " + lista.toString());

					if(l1.esVacia()){	// Si la lista esta vacia muestro un cartel indicandolo
						System.out.println("\nLa lista original no cumple con la consigna");
					} else{		// Muestro por pantalla la lista generada
						System.out.println("\nLa lista generada es: " + l1.toString());
					}

					System.out.println("Vacio la lista para que pueda probar las demas opciones");
					lista.vaciar();	// Vacia la estructura de tipo lista cargada previamente
					l1.vaciar();	// Vacia la estructura de tipo lista cargada previamente

					break;
				case 2:
					System.out.print("\n");
					System.out.println("************ COMIENZA LA CARGA DE LA LISTA \"ABCDEF*\" ************\n");
					System.out.println("Insertar el elemento A: " + lista.insertar('A', 1));
					System.out.println("Insertar el elemento B: " + lista.insertar('B', 2));
					System.out.println("Insertar el elemento C: " + lista.insertar('C', 3));
					System.out.println("Insertar el elemento D: " + lista.insertar('D', 4));
					System.out.println("Insertar el elemento E: " + lista.insertar('E', 5));
					System.out.println("Insertar el elemento F: " + lista.insertar('F', 6));
					System.out.println("Insertar el elemento *: " + lista.insertar('*', 7));

					l1 = generarLista(lista);	// Invocacion del metodo generarLista(lista)

					System.out.println("\nMuestro la lista original: " + lista.toString());

					if(l1.esVacia()){	// Si la lista esta vacia muestro un cartel
						System.out.println("\nLa lista original no cumple con la consigna");
					}else{
						System.out.println("\nLa lista generada es: " + l1.toString());
					}

					System.out.println("Vacio la lista para que pueda probar las demas opciones");
					lista.vaciar();	// Vacia la estructura de tipo lista cargada previamente
					l1.vaciar();	// Vacia la estructura de tipo lista cargada previamente

					break;
				case 3:
					System.out.print("\n");
					System.out.println("************ COMIENZA LA CARGA DE LA LISTA \"AB*C*DEF\" ************\n");
					System.out.println("Insertar el elemento A: " + lista.insertar('A', 1));
					System.out.println("Insertar el elemento B: " + lista.insertar('B', 2));
					System.out.println("Insertar el elemento *: " + lista.insertar('*', 3));
					System.out.println("Insertar el elemento C: " + lista.insertar('C', 4));
					System.out.println("Insertar el elemento *: " + lista.insertar('*', 5));
					System.out.println("Insertar el elemento D: " + lista.insertar('D', 6));
					System.out.println("Insertar el elemento F: " + lista.insertar('E', 7));
					System.out.println("Insertar el elemento E: " + lista.insertar('F', 8));

					l1 = generarLista(lista);	// Invocacion del metodo generarLista(lista)

					System.out.println("\nMuestro la lista original: " + lista.toString());

					if(l1.esVacia()){	// Si la lista esta vacia muestro un cartel
						System.out.println("\nLa lista original no cumple con la consigna");
					}else{
						System.out.println("\nLa lista generada es: " + l1.toString());
					}

					System.out.println("Vacio la lista para que pueda probar las demas opciones");
					lista.vaciar();	// Vacia la estructura de tipo lista cargada previamente
					l1.vaciar();	// Vacia la estructura de tipo lista cargada previamente

					break;
				case 4:
					System.out.print("\n");
					System.out.println("************ COMIENZA LA CARGA DE LA LISTA \"ABCDEF\" ************\n");
					System.out.println("Insertar el elemento A: " + lista.insertar('A', 1));
					System.out.println("Insertar el elemento B: " + lista.insertar('B', 2));
					System.out.println("Insertar el elemento C: " + lista.insertar('C', 3));
					System.out.println("Insertar el elemento D: " + lista.insertar('D', 4));
					System.out.println("Insertar el elemento E: " + lista.insertar('E', 5));
					System.out.println("Insertar el elemento F: " + lista.insertar('F', 6));

					l1 = generarLista(lista);	// Invocacion del metodo generarLista(lista)

					System.out.println("\nMuestro la lista original: " + lista.toString());

					if(l1.esVacia()){	// Si la lista esta vacia muestro un cartel
						System.out.println("\nLa lista original no cumple con la consigna");
					}else{
						System.out.println("\nLa lista generada es: " + l1.toString());
					}

					System.out.println("Vacio la lista para que pueda probar las demas opciones");
					lista.vaciar();	// Vacia la estructura de tipo lista cargada previamente
					l1.vaciar();	// Vacia la estructura de tipo lista cargada previamente

					break;
				case 5:
					System.out.print("\n");
					System.out.println("************ LISTA VACIA ************\n");

					l1 = generarLista(lista);	// Invocacion del metodo generarLista(lista)

					System.out.println("\nMuestro la lista original: " + lista.toString());

					if(l1.esVacia()){	// Si la lista esta vacia muestro un cartel
						System.out.println("\nLa lista original no cumple con la consigna");
					}else{
						System.out.println("\nLa lista generada es: " + l1.toString());
					}
					break;
				default:
					break;
			}

			System.out.println("\nNuevamente, ingrese un valor para operar con el menu");
			System.out.println("\n0) Finalizar la ejecucion");
			System.out.println("\n1) Cargar lista de la forma \"*ABCDEF\"");
			System.out.println("\n2) Cargar lista de la forma \"ABCDEF*\"");
			System.out.println("\n3) Cargar lista de la forma \"AB*C*DEF\"");
			System.out.println("\n4) Cargar lista de la forma \"ABCDEF\"");
			System.out.println("\n5) Probar con lista vacia");
			System.out.print("\n");
			num = sc.nextInt();
		}
	}
}
