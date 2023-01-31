package com.daw.gfigueras;

import java.util.Scanner;


public class Galeria {
    // !CONSTANTES
    final static private String BLANCO                  = "\u001B[37m";     
    final static private String VERDE                   = "\u001B[32m";     
    final static private String ROJO                    = "\u001B[31m";
    final static private String MORADO                  = "\u001B[35m";

    final static private String FORMATO_VISUALIZAR      = "Nombre: %s \nID: %d \nAutor: %s \nPrecio(€): %.2f \nAltura(m): %.2f \nPeso(t): %.2f \nNumero de piezas: %d \nDescripcion: %s\nTipo: %s";
    final static private String FORMATO_ETIQUETA        = "Nombre: %s \nAltura(m): %.2f \nPeso(t): %.2f \nNumero de Piezas: %d \nPrecio(€): %.2f \nComision Galeria(€): %.2f \nImporte por peso(€) %d \nImporte por altura(m): %d \n%sPrecio venta(€): %.2f \nDescuento(%d%% %s (€) %f \nPrecio final de venta(€): %.2f";
    final static private String TEXTO_NOMBRE            = "Introduce el nombre de la obra: ";
    final static private String TEXTO_ID                = "Introduce el ID de la obra: ";
    final static private String TEXTO_PRECIO            = "Introduce el precio de la obra(€): ";
    final static private String TEXTO_ALTURA            = "Introduce la altura de la obra(m): ";
    final static private String TEXTO_PESO              = "Introduce el peso de la obra(t): ";
    final static private String TEXTO_NºPIEZAS          = "Introduce el numero de piezas de la obra: ";
    final static private String TEXTO_TIPO              = "Introduce el tipo(" + ROJO + "Escultura" + BLANCO + " o " + ROJO+ "Pintura" + BLANCO + "): ";
    final static private String TEXTO_AUTOR             = "Introduce el nombre del autor: ";
    final static private String TEXTO_DESCRIPCION       = "Introduce la descripcion de la obra: ";
    final static private String TEXTO_ERROR             = "El tipo de obra es incorrecta, intentalo de nuevo. ";
    final static private String TEXTO_PREGUNTA          = "Vuelve a introducir el tipo (" + ROJO + "Escultura" + BLANCO + " o "+ ROJO + "Pintura" + BLANCO + "): ";
    final static private String TEXTO_CORRECTO          = "Tipo introducido correctamente. ";
    final static private String TEXTO_MATERIAL          = "Introduce el Material de la escultura:(" + ROJO + "Hierro" + BLANCO+ " , " + ROJO + "Acero" + BLANCO + " o " + ROJO + "Cobre" + BLANCO + "): ";
    final static private String TEXTO_TECNICA           = "Introduce la Tecnica de la pintura:(" + ROJO + "Óleo" + BLANCO + " , "+ ROJO + "Acuarela" + BLANCO + " o " + ROJO + "Carboncillo" + BLANCO + "): ";
    final static private String BIENVENIDO_GALERIA      = "Bienvenido al menu de la galeria JWD, ¿Que desea?:";
    final static private String ESCULTURA_TRUE          = VERDE + "La escultura ha sido dada de alta correctamente: " + BLANCO;
    final static private String PINTURA_TRUE            = VERDE + "La pintura ha sido dada de alta correctamente: " + BLANCO;
    final static private String MODIFICAR_OBRA_ID       = "Introduce el ID de la obra que quieres modificar: ";
    final static private String ERROR_ID_SOLCITADO      = ROJO+"El ID solicitado no existe o esta fuera de rango " + BLANCO;
    final static private String MENU_MODIFICAR          = MORADO+ "¿Qué campo deseas modificar?\n"+BLANCO+ "[0] Nombre:\n[1] ID:\n[2] Autor:\n[3] Precio:\n[4] Altura:\n[5] Peso:\n[6] NºPiezas:\n[7] Tipo:\n[8] Material/Técnica:\n[9] Descripcio:\n[10] Salir: \n";
    final static private String CAMBIAR_ID              = "Introduce el nuevo ID que quieres modificar: \n";
    final static private String CAMBIAR_NOMBRE          = "Introduce el nuevo Nombre que quieres modificar :\n";
    final static private String CAMBIAR_AUTOR           = "Introduce el nuevo Autor que quieres modificar :\n";
    final static private String CAMBIAR_PRECIO          = "Introduce el nuevo Precio que quieres modificar :\n";
    final static private String CAMBIAR_ALTURA          = "Introduce la nueva Altura que quieres modificar :\n";
    final static private String CAMBIAR_PESO            = "Introduce el nuevo Peso que quieres modificar :\n";
    final static private String CAMBIAR_NºPIEZAS        = "Introduce el nuevo NºPiezas que quieres modificar :\n";
    final static private String CAMBIAR_DESCRIPCION     = "Introduce la nueva Descripcion que quieres modificar :\n";
    final static private String CAMBIAR_TIPO            = "Introduce el nuevo Tipo que quieres modificar :\n";
    final static private String CAMBIAR_TEC             = "Introduce la nueva Tecnica que quieres modificar :\n";
    final static private String CAMBIAR_MAT             = "Introduce el nuevo Material que quieres modificar :\n";

    final static private String CHECK_ESCULTURA         = "ESCULTURA";
    final static private String CHECK_PINTURA           = "PINTURA";

    final static private int COMISION_GALERIA_PERCENT   = 25;
    final static private int DESCUENTO_PINTURA          = 10;
    final static private int DESCUENTO_ESCULTURA        = 20;
    final static private int PESO_PRECIO_MAX            = 100;
    final static private int PESO_PRECIO_MIN            = 20;
    final static private int ALTURA_PRECIO_MAX          = 100;
    final static private int ALTURA_PRECIO_MIN          = 20;
    final static private int ALTURA_PIEZAS_TOPE         = 2;

    // final static private double DOLLAR                  = 0.99;


    

    // !ATRIBUTOS
   
    public static ObraDeArte[] obrasGuardadas           = new ObraDeArte[5];
    public static Escultura[] esculturasGuardadas       = new Escultura[1];
    public static Pintura[] PinturasGuardadas       = new Pintura[1];
    public static String[][] obrasMatrix                = new String[6][5];

    public static void main(String[] args) {
        obrasGuardadas[0] = new Pintura(001, 1000.0, 5.0, 2.0, 5, "Pintura", "Guernica","P.Picasso", "Cuadro Guerra civil", "Oleo"); 
        obrasGuardadas[1] = new Pintura(002, 200.0, 1.0, 1.0, 1, "Pintura",  "La Vie","P.Picasso", "Pintura de Oleo", "Oleo"); 
        obrasGuardadas[2] = new Pintura(003, 300.0, 1.4, 1.0, 1, "Pintura",  "El Sueño","P.Picasso", "Pintura de Acuarela", "Acuarela"); 
        obrasGuardadas[3] = new Pintura(004, 400.0, 1.0, 1.0, 1, "Pintura",  "Retrato de Dora Maar","P.Picasso", "Pintura de Carboncillo", "Carboncillo"); 
        obrasGuardadas[4] = new Escultura(005, 550.0, 1.0, 0.8, 1, "Escultura",  "El Piel roja","U.Checa", "Escultura de Acero", "Acero"); 
        for (int i = 0; i < obrasGuardadas.length; i++) {
            // System.out.println(obtenerPrecioVentaEtiqueta(obrasGuardadas[i], darDescuento(obrasGuardadas[i])));
            darAltaObra();
         }
        //  modificarDatos();
        //  obrasGuardadas[0] = darAltaObra();
        // System.out.println(obtenerPrecioVentaEtiqueta(obrasGuardadas[0], darDescuento(obrasGuardadas[0])));
    }// *MAIN

    // ?METODOS
    // RETORNAR DESCUENTO
    public static int darDescuento(ObraDeArte obra) {
        if (obra.getTipo().equals("Pintura")) {
            return DESCUENTO_PINTURA;
        } else {
            return DESCUENTO_ESCULTURA;
        }
    }

    // MOSTRAR OBRAS
    public static String mostrarObra(ObraDeArte obra) {                     //MUESTRA OBRA POR FORMATO CORTO 
        return ROJO+ "=====> Mostrando Obra <====== \n" + BLANCO + String.format(FORMATO_VISUALIZAR, 
        obra.getNombre(),obra.getId(), obra.getAutor(),obra.getPrecio(), obra.getAltura(),obra.getPeso(), obra.getnPiezas(), obra.getDescripcion(),obra.getTipo());
    }
    public static String obtenerTicket(ObraDeArte obra) {
        return ROJO+ "============\n" + BLANCO + "Nombre: " + obra.getNombre() + "\nAutor: " + obra.getAutor() + "\nDescripcion: " +
         obra.getDescripcion();
    }

    public static String obtenerPrecioVentaEtiqueta(ObraDeArte obra, int descuento) { //MUESTRA OBRA POR FORMATO ETIQUETA 
        return ROJO+  "==================\n"+ BLANCO+ String.format(FORMATO_ETIQUETA, obra.getNombre(), 
            obra.getAltura(), obra.getPeso(), obra.getnPiezas(),obra.getPrecio(), 
            (obra.getPrecio() * COMISION_GALERIA_PERCENT) / 100, calcularPrecioPeso(obra),calcularPrecioAltura(obra),
            imprimirImporteAdiccional(obra), obtenerPrecioVenta(obra), descuento, obra.getTipo(),
            calcularDescuento(obra, descuento),
            calcularPrecioFinalVenta(obra));
    }

    public static double obtenerPrecioVenta(ObraDeArte obra) { // OBTENER PRECIO DE VENTA SIN PORCENTAJES FINALES
        double comisionGaleriaEuros = ((obra.getPrecio() * COMISION_GALERIA_PERCENT) / 100);
        int importePeso = calcularPrecioPeso(obra);
        int importeAltura = calcularPrecioAltura(obra);
        int importePlusPiezas = calcularPlusPiezas(obra);

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
    public static double calcularDescuento(ObraDeArte obra, int descuento) { //CALCULAR DESCUENTO SEGUN TIPO DE OBRA
        return ((obtenerPrecioVenta(obra) * descuento) / 100);
    }

    public static double calcularPrecioFinalVenta(ObraDeArte obra) {
        return obtenerPrecioVenta(obra) - calcularDescuento(obra, darDescuento(obra));
    }

    public static int calcularPrecioPeso(ObraDeArte obra) { // METODO QUE DEVUELVE BOOLEAN SEGUN PESO
        if ((obra.getPeso() * 1000) >= 1) {
            return PESO_PRECIO_MAX;
        } else {
            return PESO_PRECIO_MIN;
        }
    }

    public static int calcularPrecioAltura(ObraDeArte obra) { //METODO QUE DEVUELVE BOOLEAN SEGUN ALTURA
        if ((obra.getAltura() >= ALTURA_PIEZAS_TOPE)) {
            return ALTURA_PRECIO_MAX;
        } else {
            return ALTURA_PRECIO_MIN;
        }
    }

    public static int calcularPlusPiezas(ObraDeArte obra) { //METODO QUE CALCULA PRECIO EXTRA POR MAS DE 2 PIEZAS
        int plusPiezas = 0;
        if (obra.getnPiezas() > ALTURA_PIEZAS_TOPE) { // INCREMENTO NºPIEZAS
            plusPiezas+= (plusPiezas + ((obra.getnPiezas() - 2) * 10));
        }
        return plusPiezas;
    }

    // METODOS SCANNER OBRA
    public static String imprimirString(String texto) {
        Scanner textSc = new Scanner(System.in);
        System.out.print(BLANCO + texto + MORADO);
        String resultado = textSc.nextLine();

        return resultado;
    }

    public static int imprimirInteger(String texto) {
        Scanner numberSc = new Scanner(System.in);
        System.out.print(BLANCO + texto + MORADO);
        int resultado = numberSc.nextInt();

        return resultado;
    }

    public static double imprimirDouble(String texto) {
        Scanner doubleSc = new Scanner(System.in);
        System.out.print(BLANCO + texto + MORADO);
        double resultado = doubleSc.nextDouble();

        return resultado;
    }
    
    // DAR DE ALTA UNA OBRA
    public static ObraDeArte darAltaObra() {
        int id              = imprimirInteger(TEXTO_ID);
        int piezas          = imprimirInteger(TEXTO_NºPIEZAS);
        double precio       = imprimirDouble(TEXTO_PRECIO);
        double altura       = imprimirDouble(TEXTO_ALTURA);
        double peso         = imprimirDouble(TEXTO_PESO);
        String tipo         = imprimirString(TEXTO_TIPO);
        String nombre       = imprimirString(TEXTO_NOMBRE);
        String autor        = imprimirString(TEXTO_AUTOR);
        String descripcion  = imprimirString(TEXTO_DESCRIPCION);
        
        while(!(tipo.toUpperCase().equals(CHECK_ESCULTURA)) && !(tipo.toUpperCase().equals(CHECK_PINTURA))){
            String tipoErroneo = imprimirString(ROJO + TEXTO_ERROR + BLANCO + "\n" + TEXTO_PREGUNTA);
            tipo = tipoErroneo;
        }
        System.out.println(VERDE+TEXTO_CORRECTO+BLANCO);

        switch(tipo.toUpperCase()){
            case CHECK_ESCULTURA:
                String material = imprimirString(TEXTO_MATERIAL);
                Escultura escultura = new Escultura(id, precio, altura, peso, piezas, tipo, nombre, autor, descripcion, material);
                System.out.println(ESCULTURA_TRUE);
                return escultura;
            case CHECK_PINTURA:
                String tecnica = imprimirString(TEXTO_TECNICA);
                Pintura pintura =  new Pintura(id, precio, altura, peso, piezas, tipo, nombre, autor, descripcion, tecnica);
                System.out.println(PINTURA_TRUE);
                return pintura;
            default: 
                return null;
        }
    }

    public static void modificarDatos(){
        boolean menu = true;
        int idPedido = imprimirInteger(MODIFICAR_OBRA_ID);

        if(idPedido > obrasGuardadas.length -1 ){
            System.out.println(ERROR_ID_SOLCITADO);
        }
        else{
            System.out.println(mostrarObra(obrasGuardadas[idPedido]));
            int idCampoelegido = imprimirInteger(MENU_MODIFICAR);
            while(menu == true){
                switch(idCampoelegido){
                    case 0:
                        obrasGuardadas[idPedido].setNombre(imprimirString(CAMBIAR_NOMBRE));
                        menu = false;
                        break;
                    case 1:
                        obrasGuardadas[idPedido].setId(imprimirInteger(CAMBIAR_ID));
                        menu = false;
                        break;
                    case 2:
                        obrasGuardadas[idPedido].setAutor(imprimirString(CAMBIAR_AUTOR));
                        menu = false;
                        break;
                    case 3:
                        obrasGuardadas[idPedido].setPrecio(imprimirDouble(CAMBIAR_PRECIO));
                        menu = false;
                        break;
                    case 4:
                        obrasGuardadas[idPedido].setAltura(imprimirDouble(CAMBIAR_ALTURA));
                        menu = false;
                        break;
                    case 5:
                        obrasGuardadas[idPedido].setPeso(imprimirDouble(CAMBIAR_PESO));
                        menu = false;
                        break;
                    case 6:
                        obrasGuardadas[idPedido].setnPiezas(imprimirInteger(CAMBIAR_NºPIEZAS));
                        menu = false;
                        break;
                    case 7:
                        if(obrasGuardadas[idPedido].getTipo().toUpperCase().equals(CHECK_ESCULTURA) ||obrasGuardadas[idPedido].getTipo().toUpperCase().equals(CHECK_PINTURA) ){
                            String tipo = imprimirString(TEXTO_TIPO);
                            if(tipo.toUpperCase().equals(CHECK_PINTURA)){
                                String tecnica = imprimirString(TEXTO_TECNICA);
                                Pintura pintura = new Pintura(obrasGuardadas[idPedido].getId(), obrasGuardadas[idPedido].getPrecio(), obrasGuardadas[idPedido].getAltura(), obrasGuardadas[idPedido].getPeso(), obrasGuardadas[idPedido].getnPiezas(), tipo, obrasGuardadas[idPedido].getNombre(), obrasGuardadas[idPedido].getAutor(), obrasGuardadas[idPedido].getDescripcion(), tecnica);
                                obrasGuardadas[idPedido] = pintura;
                                menu = false;
                                break;
                            }else if(tipo.toUpperCase().equals(CHECK_ESCULTURA)){
                                String material = imprimirString(TEXTO_MATERIAL);
                                Escultura escultura = new Escultura(obrasGuardadas[idPedido].getId(), obrasGuardadas[idPedido].getPrecio(), obrasGuardadas[idPedido].getAltura(), obrasGuardadas[idPedido].getPeso(), obrasGuardadas[idPedido].getnPiezas(), tipo, obrasGuardadas[idPedido].getNombre(), obrasGuardadas[idPedido].getAutor(), obrasGuardadas[idPedido].getDescripcion(), material);
                                obrasGuardadas[idPedido] = escultura;
                                menu = false;
                                break;
                            }else{
                                System.out.println(TEXTO_ERROR);

                            } 
                        }
                    case 8:
                        if(obrasGuardadas[idPedido].getTipo().toUpperCase().equals(CHECK_ESCULTURA)){
                            String material = imprimirString(CAMBIAR_TEC);
                            Escultura escultura = new Escultura(obrasGuardadas[idPedido].getId(), obrasGuardadas[idPedido].getPrecio(), obrasGuardadas[idPedido].getAltura(), obrasGuardadas[idPedido].getPeso(), obrasGuardadas[idPedido].getnPiezas(), obrasGuardadas[idPedido].getNombre(), obrasGuardadas[idPedido].getAutor(), obrasGuardadas[idPedido].getDescripcion(), obrasGuardadas[idPedido].getTipo(), material);
                            obrasGuardadas[idPedido] = escultura;
                            menu = false;

                        }else{
                            String tecnica = imprimirString(CAMBIAR_TEC);
                            Pintura pintura = new Pintura(obrasGuardadas[idPedido].getId(), obrasGuardadas[idPedido].getPrecio(), obrasGuardadas[idPedido].getAltura(), obrasGuardadas[idPedido].getPeso(), obrasGuardadas[idPedido].getnPiezas(), obrasGuardadas[idPedido].getNombre(), obrasGuardadas[idPedido].getAutor(), obrasGuardadas[idPedido].getDescripcion(), obrasGuardadas[idPedido].getTipo(), tecnica);
                            obrasGuardadas[idPedido] = pintura;
                            menu = false;
                        }
                        break;
                    case 9:
                        imprimirString(CAMBIAR_DESCRIPCION);
                        obrasGuardadas[idPedido].setDescripcion(imprimirString(CAMBIAR_DESCRIPCION));
                        menu = false;
                        break;
                    case 10:
                        menu = false;
                        break;
                }
                System.out.println(mostrarObra(obrasGuardadas[idPedido]));
            }
        }
    }

    // CHECKEAR TIPO

    // MENU
    public static void ejecutarMenu(){
    }
}
