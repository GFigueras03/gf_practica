package com.daw.gfigueras;
import java.util.Scanner;

public class Galeria {
    //CONSTANTES
        //*COLORES ANSI & CONSOLEOPTIONS
        //?PROTECTED
    final static protected String TEXTO_BLANCO          = "\u001B[37m";
    final static protected String TEXTO_VERDE           = "\u001B[32m";     
    final static protected String TEXTO_ROJO            = "\u001B[31m";
    final static protected String TEXTO_MORADO          = "\u001B[35m";
    final static protected String TEXTO_AMARILLO		= "\u001B[33m";
    final static protected String TEXTO_CYAN		    = "\u001B[36m";
    final static protected String FILTER_INVISIBLE	    = "\u001B[8m";
    final static protected String TEXTO_POR_DEFECTO	    = "\u001B[0m";
    final static protected String CLEAR_CONSOLE         = "\033[H\033[2J";

    final static protected String CHECK_ESCULTURA       = "ESCULTURA";
    final static protected String CHECK_PINTURA         = "PINTURA";
    
        //!PRIVATE
    final static private String GFIGUERAS               = "  ___ ___ ___ ___ _   _ ___ ___    _   ___ "+
                                                        "\n / __| __|_ _/ __| | | | __| _ \\  /_\\ / __|"+
                                                        "\n| (_ | _| | | (_ | |_| | _||   / / _ \\\\__ \\"+
                                                        "\n \\___|_| |___\\___|\\___/|___|_|_\\/_/ \\_\\___/\n";

    final static private String FORMATO_VISUALIZAR      = TEXTO_CYAN+"Nombre:"+TEXTO_BLANCO+" %s \n"+TEXTO_CYAN+"ID:"+TEXTO_BLANCO+" %d \n"+TEXTO_CYAN+"Autor:"+TEXTO_BLANCO+" %s \n"+TEXTO_CYAN+"Precio(EUR):"+TEXTO_BLANCO+" %.2f \n"+TEXTO_CYAN+"Altura(m):"+TEXTO_BLANCO+" %.2f \n"+TEXTO_CYAN+"Peso(t):"+TEXTO_BLANCO+" %.2f \n"+TEXTO_CYAN+"Numero de piezas:"+TEXTO_BLANCO+" %d \n"+TEXTO_CYAN+"Descripcion:"+TEXTO_BLANCO+" %s\n"+TEXTO_CYAN+"Tipo:"+TEXTO_BLANCO+" %s";
    final static private String FORMATO_ETIQUETA        = TEXTO_CYAN + "Nombre:"+TEXTO_BLANCO+" %s \n"+TEXTO_CYAN+"Altura(m):"+TEXTO_BLANCO+" %.2f \n"+TEXTO_CYAN+"Peso(t):"+TEXTO_BLANCO+" %.2f \n"+TEXTO_CYAN+"Numero de Piezas:"+TEXTO_BLANCO+" %d \n"+TEXTO_CYAN+"Precio(EUR):"+TEXTO_BLANCO+" %.2f \n"+TEXTO_CYAN+"Comision Galeria(EUR):"+TEXTO_BLANCO+" %.2f \n"+TEXTO_CYAN+"Importe por peso(EUR):"+TEXTO_BLANCO+" %d \n"+TEXTO_CYAN+"Importe por altura(m):"+TEXTO_BLANCO+" %d \n%s"+TEXTO_CYAN+"Precio venta(EUR):"+TEXTO_BLANCO+" %.2f \n"+TEXTO_CYAN+"Descuento(%.0f%% %s (EUR)):"+TEXTO_BLANCO+" %f \n"+TEXTO_CYAN+"Precio final de venta(USD):"+TEXTO_BLANCO+" %.2f";
    final static private String TEXTO_NOMBRE            = "Introduce el nombre de la obra: ";
    final static private String TEXTO_ID                = "Introduce el ID de la obra: ";
    final static private String TEXTO_PRECIO            = "Introduce el precio de la obra(€): ";
    final static private String TEXTO_ALTURA            = "Introduce la altura de la obra(m): ";
    final static private String TEXTO_PESO              = "Introduce el peso de la obra(t): ";
    final static private String TEXTO_NºPIEZAS          = "Introduce el numero de piezas de la obra: ";
    final static private String TEXTO_TIPO              = "Introduce el tipo(" + TEXTO_ROJO + "Escultura" + TEXTO_BLANCO + " o " + TEXTO_ROJO+ "Pintura" + TEXTO_BLANCO + "): ";
    final static private String TEXTO_AUTOR             = "Introduce el nombre del autor: ";
    final static private String TEXTO_DESCRIPCION       = "Introduce la descripcion de la obra: ";
    final static private String TEXTO_ERROR             = "El tipo de obra es incorrecta, intentalo de nuevo. ";
    final static private String TEXTO_TIPO_INCORRECTO   = "Vuelve a introducir el tipo (" + TEXTO_ROJO + "Escultura" + TEXTO_BLANCO + " o "+ TEXTO_ROJO + "Pintura" + TEXTO_BLANCO + "): ";
    final static private String TEXTO_MATERIAL          = "Introduce el Material de la escultura:(" + TEXTO_ROJO + "Hierro" + TEXTO_BLANCO+ " , " + TEXTO_ROJO + "Acero" + TEXTO_BLANCO + " o " + TEXTO_ROJO + "Cobre" + TEXTO_BLANCO + "): ";
    final static private String TEXTO_TECNICA           = "Introduce la Tecnica de la pintura:(" + TEXTO_ROJO + "Óleo" + TEXTO_BLANCO + " , "+ TEXTO_ROJO + "Acuarela" + TEXTO_BLANCO + " o " + TEXTO_ROJO + "Carboncillo" + TEXTO_BLANCO + "): ";
    final static private String BIENVENIDO_GALERIA      = CLEAR_CONSOLE +TEXTO_CYAN + GFIGUERAS +TEXTO_BLANCO+ "\n"+TEXTO_BLANCO+ "Bienvenido al menu de la galeria"+ TEXTO_CYAN+ " JWD"+ TEXTO_BLANCO +", ¿Que desea?:"+ TEXTO_BLANCO + "\n\n- "+ TEXTO_CYAN + "[0]" + TEXTO_BLANCO +" - Visualizar todas las obras de arte: \n- "+TEXTO_CYAN+"[1]"+TEXTO_BLANCO +" - Dar de alta una obra: \n- "+TEXTO_CYAN+"[2]"+TEXTO_BLANCO +" - Modificar los datos de una obra \n- "+TEXTO_CYAN +"[3]"+TEXTO_BLANCO +" - Visualizar los datos de una obra: \n- "+TEXTO_CYAN +"[4]"+ TEXTO_BLANCO+" - Obtener el Precio de venta de una obra: \n- "+TEXTO_CYAN +"[5]"+TEXTO_BLANCO +" - Imprimir etiqueta de una obra: \n- "+TEXTO_CYAN+"[6]"+TEXTO_BLANCO+" - Salir: \n\n";
    final static private String ESCULTURA_TRUE          = TEXTO_VERDE + "La escultura ha sido dada de alta correctamente: " + TEXTO_BLANCO;
    final static private String PINTURA_TRUE            = TEXTO_VERDE + "La pintura ha sido dada de alta correctamente: " + TEXTO_BLANCO;
    final static private String MODIFICAR_OBRA_ID       = "Introduce el ID de la obra que quieres modificar: ";
    final static private String ERROR_ID_SOLCITADO      = TEXTO_ROJO+"El ID solicitado no existe o esta fuera de rango " + TEXTO_BLANCO;
    final static private String MENU_MODIFICAR          = TEXTO_MORADO+ "¿Qué campo deseas modificar?\n\n" + TEXTO_BLANCO + "- "+TEXTO_CYAN + "[0]"+TEXTO_BLANCO +"  - Nombre:\n- " + TEXTO_CYAN + "[1]"+ TEXTO_BLANCO+ "  - ID:\n-"+ TEXTO_CYAN + " [2]"+ TEXTO_BLANCO+"  - Autor:\n- "+ TEXTO_CYAN + "[3]"+ TEXTO_BLANCO +"  - Precio:\n- "+ TEXTO_CYAN +"[4]"+TEXTO_BLANCO +"  - Altura:\n- " + TEXTO_CYAN + "[5]"+TEXTO_BLANCO +"  - Peso:\n- " + TEXTO_CYAN + "[6]"+ TEXTO_BLANCO+ "  - NºPiezas:\n- "+ TEXTO_CYAN + "[7]"+ TEXTO_BLANCO + "  - Tipo:\n- "+ TEXTO_CYAN + "[8]"+TEXTO_BLANCO + "  - Material/Técnica:\n- "+ TEXTO_CYAN + "[9]"+ TEXTO_BLANCO + "  - Descripcio:\n- " + TEXTO_CYAN + "[10]"+ TEXTO_BLANCO + " - Salir: \n";
    final static private String CAMBIAR_ID              = "Introduce el nuevo ID que quieres modificar: \n";
    final static private String CAMBIAR_NOMBRE          = "Introduce el nuevo Nombre que quieres modificar :\n";
    final static private String CAMBIAR_AUTOR           = "Introduce el nuevo Autor que quieres modificar :\n";
    final static private String CAMBIAR_PRECIO          = "Introduce el nuevo Precio que quieres modificar :\n";
    final static private String CAMBIAR_ALTURA          = "Introduce la nueva Altura que quieres modificar :\n";
    final static private String CAMBIAR_PESO            = "Introduce el nuevo Peso que quieres modificar :\n";
    final static private String CAMBIAR_NºPIEZAS        = "Introduce el nuevo NºPiezas que quieres modificar :\n";
    final static private String CAMBIAR_DESCRIPCION     = "Introduce la nueva Descripcion que quieres modificar :\n";
    final static private String OPCION0_MENU            = "¿Qué obra quieres visualizar?, Introduce su ID : ";
    final static private String OPCION4_MENU            = "¿De qué obra quieres saber precio?, Introduce su ID : ";
    final static private String OPCION5_MENU            = "¿Qué obra quieres imprimir?, Introduce su ID : ";
    final static private String VOLVER_MENU             = TEXTO_VERDE + "Pulsa 'ENTER' para volver al menu..."+  TEXTO_BLANCO + FILTER_INVISIBLE;
    final static private String SALIR                   = "\nGRACIAS POR UTILIZAR NUESTRA APLICACION!!";
    final static private String ERROR_MENU              = TEXTO_ROJO+"\nLA OPCION ESCOGIDA ES INCORRECTA, PRUEBA A ESCOGER DEL (0-6)";
    final static private String TEX_MOSTRAR_TODAS_OBRAS = "\n=====> Mostrando Obras <======\n";
    final static private String MOSTRAR_OBRA_STRING     = "\n=====> MOSTRANDO OBRA <====== \n\n";
    final static private String ETIQUETA_STRING         = "\n===>ETIQUETA<===\n\n";
    final static private String PRECIO_VENTA_STRING     = "\n===>PRECIO DE VENTA<===\n\n";
    

    final static private int COMISION_GALERIA_PERCENT   = 25;

    //*CASOS SWITCH MODIFICAR OBRAS

    final static private int CASE_MOD_NOMBRE            = 0;
    final static private int CASE_MOD_ID                = 1;
    final static private int CASE_MOD_AUTOR             = 2;
    final static private int CASE_MOD_PRECIO            = 3;
    final static private int CASE_MOD_ALTURA            = 4;
    final static private int CASE_MOD_PESO              = 5;
    final static private int CASE_MOD_NPIEZAS           = 6;
    final static private int CASE_MOD_TIPO              = 7;
    final static private int CASE_MOD_TEC_MAT           = 8;
    final static private int CASE_MOD_DESCRIPCION       = 9;
    final static private int CASE_MOD_CERRAR_MENU       = 10;

    //*CASOS SWITCH MENU

    final static private int CASE_MENU_TODAS_OBRAS      = 0;
    final static private int CASE_MENU_DAR_ALTA_OBRA    = 1;
    final static private int CASE_MENU_MOD_DATOS        = 2;
    final static private int CASE_MENU_VIS_DATOS        = 3;
    final static private int CASE_MENU_OBT_PRECIO       = 4;
    final static private int CASE_MENU_IMPR_ETIQUETA    = 5;
    final static private int CASE_MENU_SALIR            = 6;
    
    final static private double CONVERSOR_DOLARES      = 0.99;

    //ATRIBUTOS
    private static ArrayObras obrasGuardadas            = new ArrayObras();
    private static boolean menu                         = true;


    public static void main(String[] args) {
        Pintura obra1       = new Pintura(001, 1000.0, 5.0, 2.0, 5, "Pintura", "Guernica","P.Picasso", "Cuadro Guerra civil", "Oleo"); 
        Pintura obra2       = new Pintura(002, 200.0, 1.0, 1.0, 1, "Pintura",  "La Vie","P.Picasso", "Pintura de Oleo", "Oleo"); 
        Pintura obra3       = new Pintura(003, 300.0, 1.4, 1.0, 1, "Pintura",  "El Sueño","P.Picasso", "Pintura de Acuarela", "Acuarela"); 
        Pintura obra4       = new Pintura(004, 400.0, 1.0, 1.0, 1, "Pintura",  "Retrato de Dora Maar","P.Picasso", "Pintura de Carboncillo", "Carboncillo"); 
        Escultura obra5     = new Escultura(005, 350.0, 1.0, 0.8, 1, "Escultura",  "El Piel roja","U.Checa", "Escultura de Acero", "Acero"); 

        obrasGuardadas.push(obra1);
        obrasGuardadas.push(obra2);
        obrasGuardadas.push(obra3);
        obrasGuardadas.push(obra4);
        obrasGuardadas.push(obra5);

        ejecutarMenu();
        
            
    }// *MAIN

    // ?METODOS

    //MENU
    public static void ejecutarMenu() {
        while (menu == true) {
            int option = imprimirInteger(BIENVENIDO_GALERIA);
            switch (option) {
                case CASE_MENU_TODAS_OBRAS:
                    menuMostrarTodasLasObras();
                    volverAlMenu();
                    break;

                case CASE_MENU_DAR_ALTA_OBRA:
                    obrasGuardadas.push(darAltaObra());
                    volverAlMenu();
                    break;

                case CASE_MENU_MOD_DATOS:
                    modificarDatos();
                    break;

                case CASE_MENU_VIS_DATOS:
                    menuVisualizarDatos();
                    break;

                case CASE_MENU_OBT_PRECIO:
                   menuObtenerPrecio();
                   break;

                case CASE_MENU_IMPR_ETIQUETA:
                    menuMostrarEtiqueta();
                    break;

                case CASE_MENU_SALIR:
                    System.out.println(TEXTO_AMARILLO + SALIR + TEXTO_BLANCO);
                    menu = false;
                    break;

                default:
                    System.out.println(ERROR_MENU);
                    volverAlMenu();
                    break;
            }
        }
    }

    // DAR DE ALTA UNA OBRA
    public static ObraDeArte darAltaObra() {
        boolean tipoEsCorrecto  = false;
        int id                  = imprimirInteger(TEXTO_ID);
        int piezas              = imprimirInteger(TEXTO_NºPIEZAS);
        double precio           = imprimirDouble(TEXTO_PRECIO);
        double altura           = imprimirDouble(TEXTO_ALTURA);
        double peso             = imprimirDouble(TEXTO_PESO);
        String tipo             = imprimirString(TEXTO_TIPO);
        String nombre           = imprimirString(TEXTO_NOMBRE);
        String autor            = imprimirString(TEXTO_AUTOR);
        String descripcion      = imprimirString(TEXTO_DESCRIPCION);

        ObraDeArte obra = null;

        do{
            switch (tipo.toUpperCase()) {
                case CHECK_ESCULTURA:
                    String material = imprimirString(TEXTO_MATERIAL);
                    obra = new Escultura(id, precio, altura, peso, piezas, tipo, nombre, autor, descripcion,material);
                    System.out.println(ESCULTURA_TRUE);
                    tipoEsCorrecto = true;
                    break;

                case CHECK_PINTURA:
                    String tecnica = imprimirString(TEXTO_TECNICA);
                    obra = new Pintura(id, precio, altura, peso, piezas, tipo, nombre, autor, descripcion, tecnica);
                    System.out.println(PINTURA_TRUE);
                    tipoEsCorrecto = true;
                    break;

                default:
                    tipoEsCorrecto = false;
                    tipo = imprimirString(TEXTO_TIPO_INCORRECTO);
                    break;
            }
        }while(!tipoEsCorrecto);
        
        return obra;
    }
   
    //METODOS DEL MENU

    public static void volverAlMenu(){
        imprimirString("\n" + VOLVER_MENU);
        System.out.println(TEXTO_POR_DEFECTO);
        ejecutarMenu();
    }

    public static void menuMostrarTodasLasObras() { // MOSTRAR OBRAS PARA EL MENU
        System.out.println(TEXTO_VERDE + TEX_MOSTRAR_TODAS_OBRAS);
        for (int i = 0; i < obrasGuardadas.getTam(); i++) {
            System.out.println(TEXTO_BLANCO + obrasGuardadas.getObra(i).getNombre());
        }
    }

    public static void menuVisualizarDatos(){
        int obraEscogida = imprimirInteger(CLEAR_CONSOLE + OPCION0_MENU);
        for (int i = 0; i < obrasGuardadas.getTam(); i++) {
            if (obrasGuardadas.getObra(i).getId() == obraEscogida) {
                System.out.println(mostrarObra(obrasGuardadas.getObra(i)));
                volverAlMenu();
            } 
        }
    }
    public static void menuObtenerPrecio(){
        int obraEscogidaDos = imprimirInteger(CLEAR_CONSOLE + OPCION4_MENU);
        for (int i = 0; i < obrasGuardadas.getTam(); i++) {
            if (obrasGuardadas.getObra(i).getId() == obraEscogidaDos) {
                System.out.println(obtenerPrecioVentaEtiqueta(obrasGuardadas.getObra(i), obrasGuardadas.getObra(i).getDescuento()));
               volverAlMenu();
            }
        }
    }
    
    public static void menuMostrarEtiqueta(){
        int obraEscogidaTres = imprimirInteger(CLEAR_CONSOLE + OPCION5_MENU);
        for (int i = 0; i < obrasGuardadas.getTam(); i++) {
            if (obrasGuardadas.getObra(i).getId() == obraEscogidaTres) {
                System.out.println(obtenerTicket(obrasGuardadas.getObra(i)));
                volverAlMenu();
            }
        }
    }

    //METODO OBTENER PRECIO VENTA

    public static double obtenerPrecioVenta(ObraDeArte obra) { // OBTENER PRECIO DE VENTA SIN PORCENTAJES FINALES
        double comisionGaleriaEuros = ((obra.getPrecio() * COMISION_GALERIA_PERCENT) / 100);
        int importePeso             = obra.calcularPrecioPeso();
        int importeAltura           = obra.calcularPrecioAltura();
        int importePlusPiezas       = obra.calcularPlusPiezas();

        double precio = obra.getPrecio();
        precio += comisionGaleriaEuros;
        precio += importeAltura;
        precio += importePeso;
        precio += importePlusPiezas;
        return precio;
    }

    public static double calcularPrecioFinalVenta(ObraDeArte obra) {
        double precio = obtenerPrecioVenta(obra) - obra.calcularDescuento(obtenerPrecioVenta(obra));
        return precio * CONVERSOR_DOLARES;
    }

    //METODO MODIFICAR DATOS

    public static void modificarDatos() {
        boolean menu = true;
        int idPedido = imprimirInteger(CLEAR_CONSOLE + MODIFICAR_OBRA_ID);

        if (idPedido > obrasGuardadas.getTam() - 1) {
            System.out.println(ERROR_ID_SOLCITADO);
        } else {
            System.out.println(mostrarObra(obrasGuardadas.getObra(idPedido)));
            int idCampoelegido = imprimirInteger(MENU_MODIFICAR);
            while (menu == true) {
                switch (idCampoelegido) {
                    case CASE_MOD_NOMBRE:
                        obrasGuardadas.getObra(idPedido).setNombre(imprimirString(CAMBIAR_NOMBRE));
                        menu = false;
                        break;

                    case CASE_MOD_ID:
                        obrasGuardadas.getObra(idPedido).setId(imprimirInteger(CAMBIAR_ID));
                        menu = false;
                        break;

                    case CASE_MOD_AUTOR:
                        obrasGuardadas.getObra(idPedido).setAutor(imprimirString(CAMBIAR_AUTOR));
                        menu = false;
                        break;

                    case CASE_MOD_PRECIO:
                        obrasGuardadas.getObra(idPedido).setPrecio(imprimirDouble(CAMBIAR_PRECIO));
                        menu = false;
                        break;

                    case CASE_MOD_ALTURA:
                        obrasGuardadas.getObra(idPedido).setAltura(imprimirDouble(CAMBIAR_ALTURA));
                        menu = false;
                        break;

                    case CASE_MOD_PESO:
                        obrasGuardadas.getObra(idPedido).setPeso(imprimirDouble(CAMBIAR_PESO));
                        menu = false;
                        break;

                    case CASE_MOD_NPIEZAS:
                        obrasGuardadas.getObra(idPedido).setnPiezas(imprimirInteger(CAMBIAR_NºPIEZAS));
                        menu = false;
                        break;

                    case CASE_MOD_TIPO:
                        if (obrasGuardadas.getObra(idPedido).getTipo().toUpperCase().equals(CHECK_ESCULTURA) || 
                            obrasGuardadas.getObra(idPedido).getTipo().toUpperCase().equals(CHECK_PINTURA)) {
                                
                            String tipo = imprimirString(TEXTO_TIPO);
                            if (tipo.toUpperCase().equals(CHECK_PINTURA)) {
                                String tecnica = imprimirString(TEXTO_TECNICA);

                                Pintura obraTemp = (Pintura)obrasGuardadas.getObra(idPedido);
                                obraTemp.setTecnica(tecnica);
                                
                                menu = false;
                                break;

                            } else if (tipo.toUpperCase().equals(CHECK_ESCULTURA)) {
                                String material = imprimirString(TEXTO_MATERIAL);

                                Escultura obraTemp = (Escultura)obrasGuardadas.getObra(idPedido);
                                obraTemp.setMaterial(material);

                                menu = false;
                                break;

                            } else {
                                System.out.println(TEXTO_ERROR);

                            }
                        }
                    case CASE_MOD_TEC_MAT:
                        if (obrasGuardadas.getObra(idPedido).getTipo().toUpperCase().equals(CHECK_ESCULTURA)) {
                            Escultura escTemp = (Escultura)obrasGuardadas.getObra(idPedido);
                            String material = imprimirString(TEXTO_MATERIAL);
                            escTemp.setMaterial(material);
                            menu = false;

                        } else {
                            Pintura pintTemp = (Pintura)obrasGuardadas.getObra(idPedido);
                            String tecnica = imprimirString(TEXTO_TECNICA);
                            pintTemp.setTecnica(tecnica);
                            menu = false;
                        }
                        break;
                    case CASE_MOD_DESCRIPCION:
                        imprimirString(CAMBIAR_DESCRIPCION);
                        obrasGuardadas.getObra(idPedido).setDescripcion(imprimirString(CAMBIAR_DESCRIPCION));
                        menu = false;
                        break;

                    case CASE_MOD_CERRAR_MENU:
                        menu = false;
                        break;
                }
                System.out.println(mostrarObra(obrasGuardadas.getObra(idPedido)));
            }
        }
    }

    //METODOS MOSTRAR OBRAS Y STRINGS 
    public static String mostrarObra(ObraDeArte obra) { // MUESTRA OBRA POR FORMATO CORTO
        return TEXTO_VERDE + MOSTRAR_OBRA_STRING + TEXTO_BLANCO + String.format(FORMATO_VISUALIZAR,
                obra.getNombre(), obra.getId(), obra.getAutor(), obra.getPrecio(), obra.getAltura(), obra.getPeso(),
                obra.getnPiezas(), obra.getDescripcion(), obra.getTipo() );
    }

    public static String obtenerTicket(ObraDeArte obra) {
        return TEXTO_VERDE + ETIQUETA_STRING + TEXTO_BLANCO + "Nombre: " + obra.getNombre() + "\nAutor: " + obra.getAutor()
                + "\nDescripcion: " +
                obra.getDescripcion() + "\n";
    }

    public static String obtenerPrecioVentaEtiqueta(ObraDeArte obra, double descuento) { // MUESTRA OBRA POR FORMATO
        return  TEXTO_VERDE + PRECIO_VENTA_STRING + TEXTO_BLANCO + String.format(FORMATO_ETIQUETA, obra.getNombre(),
            obra.getAltura(), obra.getPeso(), obra.getnPiezas(), obra.getPrecio(),
            (obra.getPrecio() * COMISION_GALERIA_PERCENT) / 100, obra.calcularPrecioPeso(),
            obra.calcularPrecioAltura(),
            obra.imprimirImporteAdiccional(), obtenerPrecioVenta(obra), descuento, obra.getTipo(),
            obra.calcularDescuento(obtenerPrecioVenta(obra)),
            calcularPrecioFinalVenta(obra));
    }

    //METODOS SCANNER CON TEXTO PERSONALIZADO

     public static String imprimirString(String texto) {
        Scanner textSc = new Scanner(System.in);
        System.out.print(TEXTO_BLANCO + texto + TEXTO_MORADO);
        String resultado = textSc.nextLine();

        return resultado;
    }

    public static int imprimirInteger(String texto) {
        Scanner numberSc = new Scanner(System.in);
        System.out.print(TEXTO_BLANCO + texto + TEXTO_MORADO);
        int resultado = numberSc.nextInt();

        return resultado;
    }

    public static double imprimirDouble(String texto) {
        Scanner doubleSc = new Scanner(System.in);
        System.out.print(TEXTO_BLANCO + texto + TEXTO_MORADO);
        double resultado = doubleSc.nextDouble();

        return resultado;
    }
}

