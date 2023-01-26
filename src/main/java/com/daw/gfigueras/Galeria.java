package com.daw.gfigueras;

import java.util.Scanner;

public class Galeria {
    // !CONSTANTES
    final static private String BLANCO                  = "\u001B[37m";
    final static private String VERDE                   = "\u001B[32m";
    final static private String ROJO                    = "\u001B[31m";
    final static private String MORADO                  = "\u001B[35m";

    final static private String FORMATO_VISUALIZAR      = "Nombre: %s \nAutor: %s \nPrecio(€): %f \nAltura(m): %f \nPeso(t): %f \nNumero de piezas: %d \nDescripcion: %s";
    final static private String FORMATO_ETIQUETA        = "Nombre: %s \nAltura(m): %.2f \nPeso(t): %.2f \nNumero de Piezas: %d \nPrecio(€): %.2f \nComision Galeria(€): %.2f \nImporte por peso(€) %d \nImporte por altura(m): %d \n%sPrecio venta(€): %.2f \nDescuento(%d %s (€) %f \nPrecio final de venta(€): %.2f";
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

    final static private int COMISION_GALERIA           = 25;
    final static private int DESCUENTO_PINTURA          = 10;
    final static private int DESCUENTO_ESCULTURA        = 20;

    public static ObraDeArte[] obrasGuardadas = new ObraDeArte[2];

    // !ATRIBUTOS

    private static int importe_peso;
    private static int importe_altura;

    public static void main(String[] args) {
        ObraDeArte elPielRoja = new ObraDeArte(005, 350.0, 1.5, 0.05, 1, "Escultura", "El Piel Roja", "U.Checa",
                "Escultura de U.Checa");
        ObraDeArte elPielVerde = new ObraDeArte(006, 350.0, 1.5, 0.05, 1, "Pintura", "El Piel Verde", "U.Checa",
                "Escultura de U.Checa");

        obrasGuardadas[0] = elPielRoja;
        obrasGuardadas[1] = elPielVerde;

        for (int i = 0; i < obrasGuardadas.length; i++) {
            hacerHerencia(obrasGuardadas[i], i);
            System.out.println(obtenerPrecioVentaEtiqueta(obrasGuardadas[i], darDescuento(obrasGuardadas[i])));
        }

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

   
    public static void hacerHerencia(ObraDeArte obra, int numero) {         //PASAS UNA OBRA Y UN NUMERO Y TE LA TRANSFORMA SEGUN SU TIPO Y LA METE EN EL ARRAY 
        switch (obra.getTipo()) {
            case "Pintura":
                System.out.println("La obra es una pintura");
                obrasGuardadas[numero] = crearPintura(obra);
                break;
            case "Escultura":
                System.out.println("La obra es una escultura");
                obrasGuardadas[numero] = crearEscultura(obra);
                break;
        }
    }

    public static Escultura crearEscultura(ObraDeArte obra) {               //CREA UN OBJETO ESCULTURA A TRAVES DE UN OBJETO OBRA Y PREGUNTA POR MATERIAL
        String material = imprimirString(TEXTO_MATERIAL);
        Escultura escultura = new Escultura(obra.getId(), obra.getPrecio(), obra.getAltura(), obra.getPeso(),
                obra.getnPiezas(), obra.getTipo(), obra.getNombre(), obra.getAutor(), obra.getDescripcion(), material);
        return escultura;
    }

    public static Pintura crearPintura(ObraDeArte obra) {                   //CREA UN OBJETO PINTURA A TRAVES DE UN OBJETO OBRA Y PREGUNTA POR TECNICA
        String tecnica = imprimirString(TEXTO_TECNICA);
        Pintura pintura = new Pintura(obra.getId(), obra.getPrecio(), obra.getAltura(), obra.getPeso(),
                obra.getnPiezas(), obra.getTipo(), obra.getNombre(), obra.getAutor(), obra.getDescripcion(), tecnica);
        return pintura;
    }

    // MOSTRAR OBRAS
    public static String mostrarObra(ObraDeArte obra) {                     //MUESTRA OBRA POR FORMATO CORTO 
        return "Mostrando Obra: \n" + String.format(FORMATO_VISUALIZAR, obra.getNombre(), obra.getAutor(),
                obra.getPrecio(), obra.getAltura(),
                obra.getPeso(), obra.getnPiezas(), obra.getDescripcion());
    }

    public static String obtenerPrecioVentaEtiqueta(ObraDeArte obra, int descuento) { //MUESTRA OBRA POR FORMATO ETIQUETA 
        return BLANCO
                + String.format(FORMATO_ETIQUETA, obra.getNombre(), obra.getAltura(), obra.getPeso(), obra.getnPiezas(),
                        obra.getPrecio(), (obra.getPrecio() * COMISION_GALERIA) / 100, calcularPrecioPeso(obra),
                        calcularPrecioAltura(obra),
                        imprimirImporteAdiccional(obra), obtenerPrecioVenta(obra), descuento, obra.getTipo(),
                        calcularDescuento(obra, descuento),
                        calcularPrecioFinalVenta(obra));
    }

    public static String obtenerTicket(ObraDeArte obra) {
        return "Nombre: " + obra.getNombre() + "\nAutor: " + obra.getAutor() + "\nDescripcion: "
                + obra.getDescripcion();
    }

    public static double obtenerPrecioVenta(ObraDeArte obra) { // OBTENER PRECIO DE VENTA SIN PORCENTAJES FINALES
        double precio = obra.getPrecio();
        precio += ((obra.getPrecio() * COMISION_GALERIA) / 100);
        precio += calcularPrecioPeso(obra);
        precio += calcularPrecioAltura(obra);
        precio += calcularPlusPiezas(obra);
        return precio;
    }

    public static String imprimirImporteAdiccional(ObraDeArte obra) {// IMPRIMIR N VECES TEXTO PIEZAS PARA ETIQUETA
        String texto = "";
        if (obra.getnPiezas() > 2) {
            for (int i = 3; i < obra.getnPiezas() + 1; i++) {
                texto += "Importe adicional - Pieza " + i + " (€): 10\n";
            }
        } else {
            texto = "";
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
            importe_peso = 100;
            return importe_peso;
        } else {
            importe_peso = 20;
            return importe_peso;
        }
    }

    public static int calcularPrecioAltura(ObraDeArte obra) { //METODO QUE DEVUELVE BOOLEAN SEGUN ALTURA
        if ((obra.getAltura() >= 2.0)) {
            importe_altura = 100;
            return importe_altura;
        } else {
            importe_altura = 20;
            return importe_altura;
        }
    }

    public static int calcularPlusPiezas(ObraDeArte obra) { //METODO QUE CALCULA PRECIO EXTRA POR MAS DE 2 PIEZAS
        int precio = 0;
        if (obra.getnPiezas() > 2) { // INCREMENTO NºPIEZAS
            precio = (precio + ((obra.getnPiezas() - 2) * 10));
        }
        return precio;
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

        ObraDeArte obra = new ObraDeArte(id, precio, altura, peso, piezas, tipo, nombre, autor, descripcion);
        checkTipos(obra);
        return obra;
    }

    // CHECKEAR TIPO
    public static void checkTipos(ObraDeArte obra) {
        if (!(obra.getTipo().equals("Escultura")) && !(obra.getTipo().equals("Pintura"))) {
            String tipo = imprimirString(ROJO + TEXTO_ERROR + BLANCO + "\n" + TEXTO_PREGUNTA);
            obra.setTipo(tipo);
            checkTipos(obra);
        } else {
            System.out.println(VERDE + TEXTO_CORRECTO + BLANCO);
        }
    }
}
