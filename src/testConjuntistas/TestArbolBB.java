package testConjuntistas;

import conjuntistas.ArbolBB;
import jerarquicas.ArbolBin;

public class TestArbolBB {
    /* Algoritmo que testea el funcionamiento del algoritmo ArbolBB.
     *
     */
    static String sOk = "\u001B[32m OK! \u001B[0m", sErr = " \u001B[31m ERROR \u001B[0m";
    public static final String NEGRO = "\u001B[30m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";


    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {

        // Zona de declaración de variables
        ArbolBB a = new ArbolBB();
        ArbolBB b = new ArbolBB();

        System.out.println(ANSI_YELLOW_BACKGROUND + "--------------------------------------------------------------------------------------------------------"
                + "----------------------------------------" + RESET);
        System.out.println("\n\n");

        System.out.println("********************************");
        System.out.println("*      Insercion basica        *");
        System.out.println("********************************");

        System.out.println("Checkeo si es vacio. Tiene que dar" + sOk + " --> " + ((a.esVacio()) ? sOk : sErr));
        System.out.println("Intento vaciar arbol vacio ");
        a.vaciar();
        System.out.println("Checkeo si es vacio. Tiene que dar" + sOk + " --> " + ((a.esVacio()) ? sOk : sErr));

        System.out.println("***********SE INSERTAN ELEMENTOS EN EL ARBOL***********");
        System.out.println("\nSe agrega el elemento 15: " + a.insertar(15));
        System.out.println("\nSe agrega el elemento 9: " + a.insertar(9));
        System.out.println("\nSe agrega el elemento 19: " + a.insertar(19));
        System.out.println("\nSe agrega el elemento 4: " + a.insertar(4));
        System.out.println("\nSe agrega el elemento 12: " + a.insertar(12));
        System.out.println("\nSe agrega el elemento 18: " + a.insertar(18));
        System.out.println("\nSe agrega el elemento 22: " + a.insertar(22));

        System.out.println("Se listan los elementos " + a.listar());

        System.out.println("\n toString()  deberia dar: \n\n \t \t         15"
                + " \n \t \t 9 \t \t \t \t 19"
                + " \n \t 4 \t \t 12 \t18 \t \t  22"
                + a.toString());
        System.out.println("\n");

        System.out.println("Checkeo si es vacio. Tiene que dar" + sErr + " --> " + ((a.esVacio()) ? sOk : sErr));

        System.out.println(ANSI_YELLOW_BACKGROUND + "--------------------------------------------------------------------------------------------------------"
                + "----------------------------------------" + RESET);
        System.out.println("\n\n");

        System.out.println("*******************************************");
        System.out.println("*      Busco elementos en el arbol        *");
        System.out.println("*******************************************");

        System.out.println("Busco si pertenece el elemento 15" + " --> " + a.pertenece(15));
        System.out.println("Busco si pertenece el elemento 19" + " --> " + a.pertenece(19));
        System.out.println("Busco si pertenece el elemento 9" + " --> " + a.pertenece(9));
        System.out.println("Busco si pertenece el elemento 4" + " --> " + a.pertenece(4));
        System.out.println("Busco si pertenece el elemento 12" + " --> " + a.pertenece(12));
        System.out.println("Busco si pertenece el elemento 18" + " --> " + a.pertenece(18));
        System.out.println("Busco si pertenece el elemento 22" + " --> " + a.pertenece(22));
        System.out.println("Busco si pertenece el elemento 0" + " --> " + a.pertenece(0));
        System.out.println("Busco si pertenece el elemento 1" + " --> " + a.pertenece(1));
        System.out.println("Busco si pertenece el elemento 55" + " --> " + a.pertenece(55));

        System.out.println("\nSe agrega el elemento 55: " + a.insertar(55));
        System.out.println("Busco si pertenece el elemento 55" + " --> " + a.pertenece(55));

        System.out.println("Checkeo si es vacio. Tiene que dar" + sErr + " --> " + ((a.esVacio()) ? sOk : sErr));

        System.out.println(ANSI_YELLOW_BACKGROUND + "--------------------------------------------------------------------------------------------------------"
                + "----------------------------------------" + RESET);
        System.out.println("\n\n");

        System.out.println("\n toString()  deberia dar: \n\n \t \t         15"
                + " \n \t \t 9 \t \t \t \t 19"
                + " \n \t 4 \t \t 12 \t18 \t \t  22"
                + " \n \t \t \t \t \t \t \t      55"
                + a.toString());
        System.out.println("\n");

        System.out.println("*************************************");
        System.out.println("*      Clono el arbol actual        *");
        System.out.println("*************************************");

        b = a.clone();

        System.out.println("Muestro el arbol original");
        System.out.println("\n toString()  deberia dar: \n\n \t \t         15"
                + " \n \t \t 9 \t \t \t \t 19"
                + " \n \t 4 \t \t 12 \t18 \t \t  22"
                + " \n \t \t \t \t \t \t \t      55"
                + a.toString());
        System.out.println("\n");

        System.out.println("Muestro el arbol clonado");
        System.out.println("\n toString()  deberia dar: \n\n \t \t         15"
                + " \n \t \t 9 \t \t \t \t 19"
                + " \n \t 4 \t \t 12 \t18 \t \t  22"
                + " \n \t \t \t \t \t \t \t      55"
                + b.toString());
        System.out.println("\n");


        System.out.println("**********************************************");
        System.out.println("*      Listar los elementos del arbol        *");
        System.out.println("**********************************************");

        System.out.println("Se listan los elementos " + a.listar());
        System.out.println("Listar los elementos con el rango [9,18]: " + a.listarRango(9, 18));
        System.out.println("\nCheckeo si es vacio. Tiene que dar" + sErr + " --> " + ((a.esVacio()) ? sOk : sErr));
        System.out.println("\nListar los elementos con el rango [4,22]: " + a.listarRango(4, 22));
        System.out.println("Listar los elementos con el rango [-5,18]: " + a.listarRango(-5, 18));
        System.out.println("\nCheckeo si es vacio. Tiene que dar" + sErr + " --> " + ((a.esVacio()) ? sOk : sErr));
        System.out.println("\nListar los elementos con el rango [0,1]: " + a.listarRango(0, 1));
        System.out.println("Listar los elementos con el rango [0,56]: " + a.listarRango(0, 56));
        System.out.println("Listar los elementos con el rango [66,88]: " + a.listarRango(66, 88));
        System.out.println("\nCheckeo si es vacio. Tiene que dar" + sErr + " --> " + ((a.esVacio()) ? sOk : sErr));
        /*

        System.out.println("\nVacio el arbol");
        a.vaciar();
        System.out.println("\nListar los elementos con el rango [-5,18]: " + a.listarRango(-5, 18));
        System.out.println("Checkeo si es vacio. Tiene que dar" + sOk + " --> " + ((a.esVacio()) ? sOk : sErr));


        System.out.println(ANSI_YELLOW_BACKGROUND + "--------------------------------------------------------------------------------------------------------"
                + "----------------------------------------" + RESET);
        System.out.println("\n\n");

        System.out.println("***************************************");
        System.out.println("*      Pruebo el arbol clonado        *");
        System.out.println("***************************************");

        System.out.println("Checkeo si es vacio. Tiene que dar" + sErr + " --> " + ((b.esVacio()) ? sOk : sErr));
        System.out.println("Se listan los elementos " + b.listar());
        System.out.println("\n*********Se eliminan minimo y maximo*********");
        System.out.println("Se elimina el minimo elemento que es 4. " + b.eliminarMinimo());
        System.out.println("Se elimina el maximo elemento que es 55. " + b.eliminarMaximo());
        System.out.println("Se listan los elementos " + b.listar());
        System.out.println("\n toString()  deberia dar: \n\n \t \t         15"
                + " \n \t \t 9 \t \t \t \t 19"
                + " \n \t   \t \t 12 \t18 \t \t  22"
                + " \n \t \t \t \t \t \t \t        "
                + b.toString());
        System.out.println("\n");
        System.out.println("Checkeo si es vacio. Tiene que dar" + sErr + " --> " + ((b.esVacio()) ? sOk : sErr));*/

        System.out.println("\n\n");
        System.out.println(ANSI_YELLOW_BACKGROUND + "--------------------------------------------------------------------------------------------------------"
                + "----------------------------------------" + RESET);
        System.out.println("\n\n");

        System.out.println("**********************************************************");
        System.out.println("*      Elimino elementos con el caso 1: Nodo hoja        *");
        System.out.println("*      Se eliminan casos especiales                      *");
        System.out.println("**********************************************************");

        System.out.println("\n");
        System.out.println("Se listan los elementos " + a.listar());
        System.out.println("Elimino el elemento 55 " + a.eliminar1(55));
        System.out.println("Se listan los elementos " + a.listar());
        System.out.println("\n toString()  deberia dar: \n\n \t \t         15"
                + " \n\n \t \t 9 \t \t \t \t 19"
                + " \n\n \t 4 \t \t 12 \t18 \t \t  22"
                + " \n \t \t \t \t \t \t \t        "
                + a.toString());
        System.out.println("\n");

        System.out.println("Intento eliminar nuevamente el elemento 55 " + a.eliminar1(55));
        System.out.println("Se listan los elementos " + a.listar());
        System.out.println("\n toString()  deberia dar: \n\n \t \t         15"
                + " \n\n \t \t 9 \t \t \t \t 19"
                + " \n\n \t 4 \t \t 12 \t18 \t \t  22"
                + " \n \t \t \t \t \t \t \t        "
                + a.toString());
        System.out.println("\n");

        System.out.println("Se listan los elementos " + a.listar());
        System.out.println("Elimino el elemento 15 " + a.eliminar1(15));
        System.out.println("Se listan los elementos " + a.listar());
        System.out.println("\n toString()  deberia dar: \n\n \t \t         15"
                + " \n\n \t \t 9 \t \t \t \t 19"
                + " \n\n \t 4 \t \t 12 \t18 \t \t  22"
                + " \n \t \t \t \t \t \t \t        "
                + a.toString());
        System.out.println("\n");

        System.out.println("Elimino el elemento 0 " + a.eliminar1(0));
        System.out.println("Se listan los elementos " + a.listar());
        System.out.println("\n toString()  deberia dar: \n\n \t \t         15"
                + " \n\n \t \t 9 \t \t \t \t 19"
                + " \n\n \t 4 \t \t 12 \t18 \t \t  22"
                + " \n \t \t \t \t \t \t \t        "
                + a.toString());
        System.out.println("\n");

        System.out.println("Se listan los elementos " + a.listar());
        System.out.println("Elimino el elemento 4 " + a.eliminar1(4));
        System.out.println("Se listan los elementos " + a.listar());
        System.out.println("\n toString()  deberia dar: \n\n \t \t         15"
                + " \n\n \t \t 9 \t \t \t \t 19"
                + " \n\n \t \t \t 12 \t18 \t \t  22"
                + " \n\t \t \t \t \t \t \t        "
                + a.toString());
        System.out.println("\n");

        System.out.println("Se listan los elementos " + a.listar());
        System.out.println("Elimino el elemento 9 " + a.eliminar1(9));
        System.out.println("Se listan los elementos " + a.listar());
        System.out.println("\n toString()  deberia dar: \n\n \t \t         15"
                + " \n\n \t \t 9 \t \t \t \t 19"
                + " \n\n \t \t \t 12 \t18 \t \t  22"
                + " \n\t \t \t \t \t \t \t         "
                + a.toString());
        System.out.println("\n");

        System.out.println("*******************************************************************");
        System.out.println("*      Elimino elementos con el caso 1: Nodo hoja                 *");
        System.out.println("*      Elimino los nodos restantes si son hoja                    *");
        System.out.println("*******************************************************************");

        System.out.println("Se listan los elementos " + a.listar());
        System.out.println("\n toString()  deberia dar: \n\n \t \t         15"
                + " \n\n \t \t 9 \t \t \t \t 19"
                + " \n\n \t \t \t 12 \t18 \t \t  22"
                + " \n\t \t \t \t \t \t \t        "
                + a.toString());
        System.out.println("\n");

        System.out.println("Elimino el elemento 12 " + a.eliminar1(12));
        System.out.println("Se listan los elementos " + a.listar());
        System.out.println("\n");

        System.out.println("Elimino el elemento 18 " + a.eliminar1(18));
        System.out.println("Se listan los elementos " + a.listar());
        System.out.println("\n");

        System.out.println("Elimino el elemento 22 " + a.eliminar1(22));
        System.out.println("Se listan los elementos " + a.listar());
        System.out.println("\n");

        System.out.println("Elimino el elemento 19 " + a.eliminar1(19));
        System.out.println("Se listan los elementos " + a.listar());
        System.out.println("\n");

        System.out.println("Elimino el elemento 9 " + a.eliminar1(12));
        System.out.println("Se listan los elementos " + a.listar());
        System.out.println("\n");

        System.out.println("Elimino el elemento 15 " + a.eliminar1(15));
        System.out.println("Se listan los elementos " + a.listar());
        System.out.println("\n");

        System.out.println("\nCheckeo si es vacio. Tiene que dar" + sOk + " --> " + ((a.esVacio()) ? sOk : sErr));



        /*
        System.out.println("\n\n");
        System.out.println(ANSI_YELLOW_BACKGROUND+"-------------------------------------------------------------------------------------------------------"
                + "---------------------------------------------------------------------------------"+RESET);


        System.out.println("************************************");
        System.out.println("*      Test de clonado             *");
        System.out.println("************************************");

        System.out.println("\n");
        b = a.clone();
        System.out.println("Altura de arbol clon:  "+b.altura());
        System.out.println("\n clon toString()  deberia dar: \n\n \t \t \t      10"
                + " \n \t \t 9 \t \t \t 15"
                + " \n \t 7 \t \t 3 \t 12 \t \t 20"
                + " \n \t \t 10 \t \t \t"
                +"\t \t --> \t \t"+ b.toString());
        System.out.println("\n");
        System.out.println("Inserto el 25 como hijo D de 20 en CLON" + ((  b.insertar(25, 20, 'D')) ? sOk : sErr));
        System.out.println("Inserto el 35 como hijo I de 20 en CLON" + ((  b.insertar(35, 20, 'I')) ? sOk : sErr));
        System.out.println("\n"+AZUL+"CLON toString() \t\t\t"+b.toString()+"\n\n");
        System.out.println(VERDE+"ORIGINAL toString()\t\t\t "+a.toString()+"\n\n");

        System.out.println("Vacio el CLON");
        b.vaciar();
        System.out.println("Busco al padre 20 en Arbol vacio. Tiene que dar " + sOk+" --> "  + (( b.padre(20)==null ) ? sOk : sErr));


        System.out.println("\n\n");
        System.out.println(ANSI_YELLOW_BACKGROUND+"----------------------------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------------"+RESET);
        System.out.println("\n\n********************************");
        System.out.println("*      Test de Busqueda         *");
        System.out.println("********************************\n");
        System.out.println("Busco al padre de 3. Tiene que dar " + sOk+" --> "  + (((int) a.padre(3) == 9) ? sOk : sErr));
        System.out.println("Busco al padre de 20. Tiene que dar " + sOk+" --> "  + (((int) a.padre(20) == 15) ? sOk : sErr));
        System.out.println("Busco al padre de raiz. Tiene que dar " + sOk+" --> "  + ((a.padre(10) == null) ? sOk : sErr));
        System.out.println("Busco al padre de elemento inexistente. Tiene que dar " + sErr+" --> "  + ((a.padre(1011) != null) ? sOk : sErr));


        System.out.println("\n\n");
        System.out.println(ANSI_YELLOW_BACKGROUND+"----------------------------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------------"+RESET);
        System.out.println("\n\n**********************************");
        System.out.println("*        Test de Niveles         *");
        System.out.println("**********************************\n");

        System.out.println("Busco el nivel de raiz. Tiene que dar " + sOk+" --> "  + (((int) a.nivel(10) == 0) ? sOk : sErr));
        System.out.println("Busco el nivel 3. Tiene que dar " + sOk+" --> "  + (((int) a.nivel(3) == 2) ? sOk : sErr));
        System.out.println("Busco el nivel 20. Tiene que dar " + sOk+" --> "  + (((int) a.nivel(20) == 2) ? sOk : sErr));
        System.out.println("Busco el nivel 9. Tiene que dar " + sOk+" --> "  + (((int) a.nivel(9) == 1) ? sOk : sErr));
        System.out.println("Busco nivel de elemento inexistente: " + a.nivel(1000));



        System.out.println("\n\n");
        System.out.println(ANSI_YELLOW_BACKGROUND+"----------------------------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------------"+RESET);
        System.out.println("\n\n**********************************");
        System.out.println("*      Test de Recorridos        *");
        System.out.println("**********************************\n");

        System.out.println("Recorrido en preOrden.\n Tiene que dar: [ 10 - 9 - 7 - 3 - 10 - 15 - 12 - 20 ]  " + a.listarPreorden().toString());
        System.out.println("\n");
        System.out.println("Recorrido en posOrden.\n Tiene que dar: [ 7 - 10 - 3 - 9 - 12 - 20 - 15 - 10 ]  " + a.listarPosorden().toString());
        System.out.println("\n");
        System.out.println("Recorrido en InOrden.\n Tiene que dar: [ 7 - 9 - 10 - 3 - 10 - 12 - 15 - 20 ]  " + a.listarInorden().toString());
        */


    }

}