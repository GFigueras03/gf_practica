package com.daw.gfigueras;

public class Constantes {
            //*COLORES ANSI & CONSOLEOPTIONS
        //?PROTECTED
        final static public String TEXTO_BLANCO          = "\u001B[37m";
        final static public String TEXTO_VERDE           = "\u001B[32m";     
        final static public String TEXTO_ROJO            = "\u001B[31m";
        final static public String TEXTO_MORADO          = "\u001B[35m";
        final static public String TEXTO_AMARILLO		 = "\u001B[33m";
        final static public String TEXTO_CYAN		     = "\u001B[36m";
        final static public String FILTER_INVISIBLE	     = "\u001B[8m";
        final static public String TEXTO_POR_DEFECTO	 = "\u001B[0m";
        final static public String CLEAR_CONSOLE         = "\033[H\033[2J";
    
        final static public String CHECK_ESCULTURA       = "ESCULTURA";
        final static public String CHECK_PINTURA         = "PINTURA";
        
            //!PRIVATE
        final static private String GFIGUERAS               = "  ___ ___ ___ ___ _   _ ___ ___    _   ___ "+
                                                            "\n / __| __|_ _/ __| | | | __| _ \\  /_\\ / __|"+
                                                            "\n| (_ | _| | | (_ | |_| | _||   / / _ \\\\__ \\"+
                                                            "\n \\___|_| |___\\___|\\___/|___|_|_\\/_/ \\_\\___/\n";
    
        final static public String FORMATO_VISUALIZAR      = TEXTO_CYAN+"Nombre:"+TEXTO_BLANCO+" %s \n"+TEXTO_CYAN+"ID:"+TEXTO_BLANCO+" %d \n"+TEXTO_CYAN+"Autor:"+TEXTO_BLANCO+" %s \n"+TEXTO_CYAN+"Precio(EUR):"+TEXTO_BLANCO+" %.2f \n"+TEXTO_CYAN+"Altura(m):"+TEXTO_BLANCO+" %.2f \n"+TEXTO_CYAN+"Peso(t):"+TEXTO_BLANCO+" %.2f \n"+TEXTO_CYAN+"Numero de piezas:"+TEXTO_BLANCO+" %d \n"+TEXTO_CYAN+"Descripcion:"+TEXTO_BLANCO+" %s\n"+TEXTO_CYAN+"Tipo:"+TEXTO_BLANCO+" %s";
        final static public String FORMATO_ETIQUETA        = TEXTO_CYAN + "Nombre:"+TEXTO_BLANCO+" %s \n"+TEXTO_CYAN+"Altura(m):"+TEXTO_BLANCO+" %.2f \n"+TEXTO_CYAN+"Peso(t):"+TEXTO_BLANCO+" %.2f \n"+TEXTO_CYAN+"Numero de Piezas:"+TEXTO_BLANCO+" %d \n"+TEXTO_CYAN+"Precio(EUR):"+TEXTO_BLANCO+" %.2f \n"+TEXTO_CYAN+"Comision Galeria(EUR):"+TEXTO_BLANCO+" %.2f \n"+TEXTO_CYAN+"Importe por peso(EUR):"+TEXTO_BLANCO+" %d \n"+TEXTO_CYAN+"Importe por altura(m):"+TEXTO_BLANCO+" %d \n%s"+TEXTO_CYAN+"Precio venta(EUR):"+TEXTO_BLANCO+" %.2f \n"+TEXTO_CYAN+"Descuento(%.0f%% %s (EUR)):"+TEXTO_BLANCO+" %f \n"+TEXTO_CYAN+"Precio final de venta(USD):"+TEXTO_BLANCO+" %.2f";
        final static public String TEXTO_NOMBRE            = "Introduce el nombre de la obra: ";
        final static public String TEXTO_PRECIO            = "Introduce el precio de la obra(€): ";
        final static public String TEXTO_ALTURA            = "Introduce la altura de la obra(m): ";
        final static public String TEXTO_PESO              = "Introduce el peso de la obra(t): ";
        final static public String TEXTO_NºPIEZAS          = "Introduce el numero de piezas de la obra: ";
        final static public String TEXTO_TIPO              = "Introduce el tipo(" + TEXTO_ROJO + "Escultura" + TEXTO_BLANCO + " o " + TEXTO_ROJO+ "Pintura" + TEXTO_BLANCO + "): ";
        final static public String TEXTO_AUTOR             = "Introduce el nombre del autor: ";
        final static public String TEXTO_DESCRIPCION       = "Introduce la descripcion de la obra: ";
        final static public String TEXTO_ERROR             = "El tipo de obra es incorrecta, intentalo de nuevo. ";
        final static public String TEXTO_TIPO_INCORRECTO   = "Vuelve a introducir el tipo (" + TEXTO_ROJO + "Escultura" + TEXTO_BLANCO + " o "+ TEXTO_ROJO + "Pintura" + TEXTO_BLANCO + "): ";
        final static public String TEXTO_MATERIAL          = "Introduce el Material de la escultura:(" + TEXTO_ROJO + "Hierro" + TEXTO_BLANCO+ " , " + TEXTO_ROJO + "Acero" + TEXTO_BLANCO + " o " + TEXTO_ROJO + "Cobre" + TEXTO_BLANCO + "): ";
        final static public String TEXTO_TECNICA           = "Introduce la Tecnica de la pintura:(" + TEXTO_ROJO + "Óleo" + TEXTO_BLANCO + " , "+ TEXTO_ROJO + "Acuarela" + TEXTO_BLANCO + " o " + TEXTO_ROJO + "Carboncillo" + TEXTO_BLANCO + "): ";
        final static public String TEXTO_TECNICA_ERR       = "Tecnica Incorrecta introduce:(" + TEXTO_ROJO + "Oleo" + TEXTO_BLANCO + " , "+ TEXTO_ROJO + "Acuarela" + TEXTO_BLANCO + " o " + TEXTO_ROJO + "Carboncillo" + TEXTO_BLANCO + "): ";
        final static public String TEXTO_MATERIAL_ERR      = "Material Incorrecta introduce:(" + TEXTO_ROJO + "Hierro" + TEXTO_BLANCO + " , "+ TEXTO_ROJO + "Cobre" + TEXTO_BLANCO + " o " + TEXTO_ROJO + "Acero" + TEXTO_BLANCO + "): ";
        final static public String BIENVENIDO_GALERIA      = CLEAR_CONSOLE +TEXTO_CYAN + GFIGUERAS +TEXTO_BLANCO+ "\n"+TEXTO_BLANCO+ "Bienvenido al menu de la galeria"+ TEXTO_CYAN+ " JWD"+ TEXTO_BLANCO +", ¿Que desea?:"+ TEXTO_BLANCO + "\n\n- "+ TEXTO_CYAN + "[0]" + TEXTO_BLANCO +" - Visualizar todas las obras de arte: \n- "+TEXTO_CYAN+"[1]"+TEXTO_BLANCO +" - Dar de alta una obra: \n- "+TEXTO_CYAN+"[2]"+TEXTO_BLANCO +" - Modificar los datos de una obra \n- "+TEXTO_CYAN +"[3]"+TEXTO_BLANCO +" - Visualizar los datos de una obra: \n- "+TEXTO_CYAN +"[4]"+ TEXTO_BLANCO+" - Obtener el Precio de venta de una obra: \n- "+TEXTO_CYAN +"[5]"+TEXTO_BLANCO +" - Imprimir etiqueta de una obra: \n- "+TEXTO_CYAN+"[6]"+TEXTO_BLANCO+" - Salir: \n\n";
        final static public String ESCULTURA_TRUE          = TEXTO_VERDE + "La escultura ha sido dada de alta correctamente: " + TEXTO_BLANCO;
        final static public String PINTURA_TRUE            = TEXTO_VERDE + "La pintura ha sido dada de alta correctamente: " + TEXTO_BLANCO;
        final static public String MODIFICAR_OBRA_ID       = "Introduce el ID de la obra que quieres modificar: ";
        final static public String ERROR_ID_SOLCITADO      = TEXTO_ROJO+"El ID solicitado no existe o esta fuera de rango " + TEXTO_BLANCO;
        final static public String MENU_MODIFICAR          = TEXTO_MORADO+ "¿Qué campo deseas modificar?\n\n" + TEXTO_BLANCO + "- "+TEXTO_CYAN + "[0]"+TEXTO_BLANCO +"  - Nombre:\n- " + TEXTO_CYAN + "[1]"+ TEXTO_BLANCO+"  - Autor:\n- "+ TEXTO_CYAN + "[2]"+ TEXTO_BLANCO +"  - Precio:\n- "+ TEXTO_CYAN +"[3]"+TEXTO_BLANCO +"  - Altura:\n- " + TEXTO_CYAN + "[4]"+TEXTO_BLANCO +"  - Peso:\n- " + TEXTO_CYAN + "[5]"+ TEXTO_BLANCO+ "  - NºPiezas:\n- "+ TEXTO_CYAN + "[6]"+ TEXTO_BLANCO + "  - Tipo:\n- "+ TEXTO_CYAN + "[7]"+TEXTO_BLANCO + "  - Material/Técnica:\n- "+ TEXTO_CYAN + "[8]"+ TEXTO_BLANCO + "  - Descripción:\n- " + TEXTO_CYAN + "[9]"+ TEXTO_BLANCO + "  - Salir: \n";
        final static public String CAMBIAR_ID              = "Introduce el nuevo ID que quieres modificar: \n";
        final static public String CAMBIAR_NOMBRE          = "Introduce el nuevo Nombre que quieres modificar :\n";
        final static public String CAMBIAR_AUTOR           = "Introduce el nuevo Autor que quieres modificar :\n";
        final static public String CAMBIAR_PRECIO          = "Introduce el nuevo Precio que quieres modificar :\n";
        final static public String CAMBIAR_ALTURA          = "Introduce la nueva Altura que quieres modificar :\n";
        final static public String CAMBIAR_PESO            = "Introduce el nuevo Peso que quieres modificar :\n";
        final static public String CAMBIAR_NºPIEZAS        = "Introduce el nuevo NºPiezas que quieres modificar :\n";
        final static public String CAMBIAR_DESCRIPCION     = "Introduce la nueva Descripcion que quieres modificar :\n";
        final static public String OPCION0_MENU            = "¿Qué obra quieres visualizar?, Introduce su ID : ";
        final static public String OPCION4_MENU            = "¿De qué obra quieres saber precio?, Introduce su ID : ";
        final static public String OPCION5_MENU            = "¿Qué obra quieres imprimir?, Introduce su ID : ";
        final static public String VOLVER_MENU             = TEXTO_VERDE + "Pulsa 'ENTER' para volver al menu..."+  TEXTO_BLANCO + FILTER_INVISIBLE;
        final static public String SALIR                   = "\nGRACIAS POR UTILIZAR NUESTRA APLICACION!!";
        final static public String ERROR_MENU              = TEXTO_ROJO+"\nLA OPCION ESCOGIDA ES INCORRECTA, PRUEBA A ESCOGER DEL (0-6)";
        final static public String TEX_MOSTRAR_TODAS_OBRAS = "\n=====> Mostrando Obras <======\n";
        final static public String MOSTRAR_OBRA_STRING     = "\n=====> MOSTRANDO OBRA <====== \n\n";
        final static public String ETIQUETA_STRING         = "\n===>ETIQUETA<===\n\n";
        final static public String PRECIO_VENTA_STRING     = "\n===>PRECIO DE VENTA<===\n\n";
        final static public String NOMBRE_TODAS_OBRAS      = TEXTO_CYAN + "Nombre: " + TEXTO_BLANCO;
        final static public String ID_TODAS_OBRAS          = TEXTO_AMARILLO+"\nID: " + TEXTO_BLANCO + "🔒";
        final static public String HIERRO                  = "HIERRO";
        final static public String COBRE                   = "COBRE";
        final static public String ACERO                   = "ACERO";
        final static public String CARBONCILLO             = "CARBONCILLO";
        final static public String ACUARELA                = "ACUARELA";
        final static public String OLEO                    = "OLEO";
        
        
        final static protected int COMISION_GALERIA_PERCENT   = 25;
    
        //*CASOS SWITCH MODIFICAR OBRAS
    
        final static public int CASE_MOD_NOMBRE            = 0;
        final static public int CASE_MOD_AUTOR             = 1;
        final static public int CASE_MOD_PRECIO            = 2;
        final static public int CASE_MOD_ALTURA            = 3;
        final static public int CASE_MOD_PESO              = 4;
        final static public int CASE_MOD_NPIEZAS           = 5;
        final static public int CASE_MOD_TIPO              = 6;
        final static public int CASE_MOD_TEC_MAT           = 7;
        final static public int CASE_MOD_DESCRIPCION       = 8;
        final static public int CASE_MOD_CERRAR_MENU       = 9 ;
    
        //*CASOS SWITCH MENU
    
        final static public int CASE_MENU_TODAS_OBRAS      = 0;
        final static public int CASE_MENU_DAR_ALTA_OBRA    = 1;
        final static public int CASE_MENU_MOD_DATOS        = 2;
        final static public int CASE_MENU_VIS_DATOS        = 3;
        final static public int CASE_MENU_OBT_PRECIO       = 4;
        final static public int CASE_MENU_IMPR_ETIQUETA    = 5;
        final static public int CASE_MENU_SALIR            = 6;
        
        final static public double CONVERSOR_DOLARES      = 0.99;
}
