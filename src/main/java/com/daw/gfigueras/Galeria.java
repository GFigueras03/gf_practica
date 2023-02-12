package com.daw.gfigueras;
import java.util.Scanner;

public class Galeria {
    // !CONSTANTES
    final static private String TEXTO_BLANCO            = "\u001B[37m";
    final static private String TEXTO_VERDE             = "\u001B[32m";     
    final static private String TEXTO_ROJO              = "\u001B[31m";
    final static private String TEXTO_MORADO            = "\u001B[35m";
    final static private String TEXTO_AMARILLO		    = "\u001B[33m";
    final static private String	TEXTO_CYAN				= "\u001B[36m";
    final static private String	FILTER_INVISIBLE	    = "\u001B[8m";
    final static private String CLEAR_CONSOLE           = "\033[H\033[2J";

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
    final static private String TEXTO_CORRECTO          = "Tipo introducido correctamente. ";
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
    final static private String ERROR_ID_OBRA_ESCO      = TEXTO_ROJO+ "El id de la obra escogida es incorrecto"+ TEXTO_BLANCO;
    final static private String VOLVER_MENU             = TEXTO_VERDE + "Pulsa 'ENTER' para volver al menu..."+  TEXTO_BLANCO + FILTER_INVISIBLE;
    final static private String DAR_DE_ALTA_CORR        = TEXTO_VERDE + "La obra ha sido dada de alta correctamente...";
    final static private String SALIR                   = "\nGRACIAS POR UTILIZAR NUESTRA APLICACION!!";
    final static private String ERROR_MENU              = TEXTO_ROJO+"\nLA OPCION ESCOGIDA ES INCORRECTA, PRUEBA A ESCOGER DEL (0-6)";

    final static private String CHECK_ESCULTURA         = "ESCULTURA";
    final static private String CHECK_PINTURA           = "PINTURA";

    final static private int COMISION_GALERIA_PERCENT   = 25;
    final static private int PESO_PRECIO_MAX            = 100;
    final static private int PESO_PRECIO_MIN            = 20;
    final static private int ALTURA_PRECIO_MAX          = 100;
    final static private int ALTURA_PRECIO_MIN          = 20;
    final static private int ALTURA_PIEZAS_TOPE         = 2;
    final static private double CONVERSOR_DOLARES       = 0.99;

    //ATRIBUTES
    public static AlmacenObras obrasGuardadas           = new AlmacenObras();
    public static Escultura[] esculturasGuardadas       = new Escultura[1];
    public static Pintura[] PinturasGuardadas           = new Pintura[1];
    public static String[][] obrasMatrix                = new String[6][5];
    public static boolean menu                          = true;


    public static void main(String[] args) {
        Pintura obra1 = new Pintura(001, 1000.0, 5.0, 2.0, 5, "Pintura", "Guernica","P.Picasso", "Cuadro Guerra civil", "Oleo"); 
        Pintura obra2 = new Pintura(002, 200.0, 1.0, 1.0, 1, "Pintura",  "La Vie","P.Picasso", "Pintura de Oleo", "Oleo"); 
        Pintura obra3 = new Pintura(003, 300.0, 1.4, 1.0, 1, "Pintura",  "El Sueño","P.Picasso", "Pintura de Acuarela", "Acuarela"); 
        Pintura obra4 = new Pintura(004, 400.0, 1.0, 1.0, 1, "Pintura",  "Retrato de Dora Maar","P.Picasso", "Pintura de Carboncillo", "Carboncillo"); 
        Escultura obra5 = new Escultura(005, 350.0, 1.0, 0.8, 1, "Escultura",  "El Piel roja","U.Checa", "Escultura de Acero", "Acero"); 

        obrasGuardadas.push(obra1);
        obrasGuardadas.push(obra2);
        obrasGuardadas.push(obra3);
        obrasGuardadas.push(obra4);
        obrasGuardadas.push(obra5);
        ejecutarMenu();
        
            
    }// *MAIN

    // ?METODOS
    // RETORNAR DESCUENTO

    // MOSTRAR OBRAS
    public static String mostrarObra(ObraDeArte obra) { // MUESTRA OBRA POR FORMATO CORTO
        return TEXTO_VERDE + "\n=====> MOSTRANDO OBRA <====== \n\n" + TEXTO_BLANCO + String.format(FORMATO_VISUALIZAR,
                obra.getNombre(), obra.getId(), obra.getAutor(), obra.getPrecio(), obra.getAltura(), obra.getPeso(),
                obra.getnPiezas(), obra.getDescripcion(), obra.getTipo() );
    }

    public static String obtenerTicket(ObraDeArte obra) {
        return TEXTO_VERDE + "\n===>ETIQUETA<===\n\n" + TEXTO_BLANCO + "Nombre: " + obra.getNombre() + "\nAutor: " + obra.getAutor()
                + "\nDescripcion: " +
                obra.getDescripcion() + "\n";
    }

    public static String obtenerPrecioVentaEtiqueta(ObraDeArte obra, double descuento) { // MUESTRA OBRA POR FORMATO
                                                                                      // ETIQUETA
        return  TEXTO_VERDE + "\n===>PRECIO DE VENTA<===\n\n" + TEXTO_BLANCO + String.format(FORMATO_ETIQUETA, obra.getNombre(),
                obra.getAltura(), obra.getPeso(), obra.getnPiezas(), obra.getPrecio(),
                (obra.getPrecio() * COMISION_GALERIA_PERCENT) / 100, calcularPrecioPeso(obra),
                calcularPrecioAltura(obra),
                imprimirImporteAdiccional(obra), obtenerPrecioVenta(obra), descuento, obra.getTipo(),
                obra.calcularDescuento(obtenerPrecioVenta(obra)),
                calcularPrecioFinalVenta(obra));
    }

    public static double obtenerPrecioVenta(ObraDeArte obra) { // OBTENER PRECIO DE VENTA SIN PORCENTAJES FINALES
        double comisionGaleriaEuros = ((obra.getPrecio() * COMISION_GALERIA_PERCENT) / 100);
        int importePeso             = calcularPrecioPeso(obra);
        int importeAltura           = calcularPrecioAltura(obra);
        int importePlusPiezas       = calcularPlusPiezas(obra);

        double precio = obra.getPrecio();
        precio += comisionGaleriaEuros;
        precio += importeAltura;
        precio += importePeso;
        precio += importePlusPiezas;
        return precio;
    }

    public static String imprimirImporteAdiccional(ObraDeArte obra) {// IMPRIMIR N VECES TEXTO PIEZAS PARA ETIQUETA
        String texto = "";
        int comienzoPlusPiezas = 3;
        if (obra.getnPiezas() > 2) {
            for (int i = comienzoPlusPiezas; i < obra.getnPiezas() + 1; i++) {
                texto += "Importe adicional - Pieza " + i + " (€): 10\n";
            }
        }
        return texto;
    }

    // CALCULOS

    public static double calcularPrecioFinalVenta(ObraDeArte obra) {
        double precio = obtenerPrecioVenta(obra) - obra.calcularDescuento(obtenerPrecioVenta(obra));
        return precio * CONVERSOR_DOLARES;
    }

    public static int calcularPrecioPeso(ObraDeArte obra) { // METODO QUE DEVUELVE BOOLEAN SEGUN PESO
        if ((obra.getPeso() * 1000) >= 1) {
            return PESO_PRECIO_MAX;
        } else {
            return PESO_PRECIO_MIN;
        }
    }

    public static int calcularPrecioAltura(ObraDeArte obra) { // METODO QUE DEVUELVE BOOLEAN SEGUN ALTURA
        if ((obra.getAltura() >= ALTURA_PIEZAS_TOPE)) {
            return ALTURA_PRECIO_MAX * obra.getnPiezas();
        } else {
            return ALTURA_PRECIO_MIN;
        }
    }

    public static int calcularPlusPiezas(ObraDeArte obra) { // METODO QUE CALCULA PRECIO EXTRA POR MAS DE 2 PIEZAS
        int plusPiezas = 0;
        if (obra.getnPiezas() > ALTURA_PIEZAS_TOPE) { // INCREMENTO NºPIEZAS
            plusPiezas += (plusPiezas + ((obra.getnPiezas() - 2) * 10));
        }
        return plusPiezas;
    }

    // METODOS SCANNER OBRA
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

    // DAR DE ALTA UNA OBRA
    public static ObraDeArte darAltaObra() {
        boolean tipoEsCorrecto = false;

        int id              = imprimirInteger(TEXTO_ID);
        int piezas          = imprimirInteger(TEXTO_NºPIEZAS);
        double precio       = imprimirDouble(TEXTO_PRECIO);
        double altura       = imprimirDouble(TEXTO_ALTURA);
        double peso         = imprimirDouble(TEXTO_PESO);
        String tipo         = imprimirString(TEXTO_TIPO);
        String nombre       = imprimirString(TEXTO_NOMBRE);
        String autor        = imprimirString(TEXTO_AUTOR);
        String descripcion  = imprimirString(TEXTO_DESCRIPCION);

        ObraDeArte obra = null;

        do{
            switch (tipo.toUpperCase()) {
                case CHECK_ESCULTURA:
                    String material = imprimirString(TEXTO_MATERIAL);
                    obra = new Escultura(id, precio, altura, peso, piezas, tipo, nombre, autor, descripcion,
                            material);
                    System.out.println(ESCULTURA_TRUE);
                    tipoEsCorrecto = true;
                    break;
                case CHECK_PINTURA:
                    String tecnica = imprimirString(TEXTO_TECNICA);
                    obra = new Pintura(id, precio, altura, peso, piezas, tipo, nombre, autor, descripcion,
                            tecnica);
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
                    case 0:
                        obrasGuardadas.getObra(idPedido).setNombre(imprimirString(CAMBIAR_NOMBRE));
                        menu = false;
                        break;
                    case 1:
                        obrasGuardadas.getObra(idPedido).setId(imprimirInteger(CAMBIAR_ID));
                        menu = false;
                        break;
                    case 2:
                        obrasGuardadas.getObra(idPedido).setAutor(imprimirString(CAMBIAR_AUTOR));
                        menu = false;
                        break;
                    case 3:
                        obrasGuardadas.getObra(idPedido).setPrecio(imprimirDouble(CAMBIAR_PRECIO));
                        menu = false;
                        break;
                    case 4:
                        obrasGuardadas.getObra(idPedido).setAltura(imprimirDouble(CAMBIAR_ALTURA));
                        menu = false;
                        break;
                    case 5:
                        obrasGuardadas.getObra(idPedido).setPeso(imprimirDouble(CAMBIAR_PESO));
                        menu = false;
                        break;
                    case 6:
                        obrasGuardadas.getObra(idPedido).setnPiezas(imprimirInteger(CAMBIAR_NºPIEZAS));
                        menu = false;
                        break;
                    case 7:
                        if (obrasGuardadas.getObra(idPedido).getTipo().toUpperCase().equals(CHECK_ESCULTURA) || obrasGuardadas.getObra(idPedido).getTipo().toUpperCase().equals(CHECK_PINTURA)) {
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
                    case 8:
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
                    case 9:
                        imprimirString(CAMBIAR_DESCRIPCION);
                        obrasGuardadas.getObra(idPedido).setDescripcion(imprimirString(CAMBIAR_DESCRIPCION));
                        menu = false;
                        break;
                    case 10:
                        menu = false;
                        break;
                }
                System.out.println(mostrarObra(obrasGuardadas.getObra(idPedido)));
            }
        }
    }

    // CHECKEAR TIPO

    public static void volverAlMenu(){
        String limpiar = imprimirString("\n" + VOLVER_MENU);
        System.out.println("\u001B[0m");
        ejecutarMenu();

    }
    // MENU
    public static void ejecutarMenu() {
        while (menu == true) {
            int option = imprimirInteger(BIENVENIDO_GALERIA);
            switch (option) {
                case 0:
                    mostrarTodasLasObras();
                    volverAlMenu();
                    break;
                case 1:
                    obrasGuardadas.push(darAltaObra());
                    volverAlMenu();
                    break;
                case 2:
                    modificarDatos();
                    break;

                case 3:
                    int obraEscogida = imprimirInteger(CLEAR_CONSOLE + OPCION0_MENU);
                    for (int i = 0; i < obrasGuardadas.getTam(); i++) {
                        if (obrasGuardadas.getObra(i).getId() == obraEscogida) {
                            System.out.println(mostrarObra(obrasGuardadas.getObra(i)));
                            volverAlMenu();
                        } 
                    }
                    break;
                case 4:
                    int obraEscogidaDos = imprimirInteger(CLEAR_CONSOLE + OPCION4_MENU);
                    for (int i = 0; i < obrasGuardadas.getTam(); i++) {
                        if (obrasGuardadas.getObra(i).getId() == obraEscogidaDos) {
                            System.out.println(
                                    obtenerPrecioVentaEtiqueta(obrasGuardadas.getObra(i), obrasGuardadas.getObra(i).getDescuento()));
                           volverAlMenu();
                        }
                    }
                    break;
                case 5:
                    int obraEscogidaTres = imprimirInteger(CLEAR_CONSOLE + OPCION5_MENU);
                    for (int i = 0; i < obrasGuardadas.getTam(); i++) {
                        if (obrasGuardadas.getObra(i).getId() == obraEscogidaTres) {
                            System.out.println(obtenerTicket(obrasGuardadas.getObra(i)));
                            volverAlMenu();
                        }
                    }
                    break;
                case 6:
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

    public static void mostrarTodasLasObras() { // MOSTRAR OBRAS PARA EL MENU
        System.out.println(TEXTO_VERDE+"\n=====> Mostrando Obras <======\n");
        for (int i = 0; i < obrasGuardadas.getTam(); i++) {
            System.out.println(TEXTO_BLANCO + obrasGuardadas.getObra(i).getNombre());
        }
    }
}
