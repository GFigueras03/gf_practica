package com.daw.gfigueras;

import java.util.Scanner;

public class Galeria {
    // !CONSTANTES
    final static private String BLANCO              = "\u001B[37m";
    final static private String VERDE               = "\u001B[32m";
    final static private String ROJO                = "\u001B[31m";
    final static private String MORADO                = "\u001B[35m";

    final static private String FORMATO_VISUALIZAR  = "Nombre: %s \nAutor: %s \nPrecio(€): %f \nAltura(m): %f \nPeso(t): %f \nNumero de piezas: %d \nDescripcion: %s";
    final static private String FORMATO_ETIQUETA    = "Nombre: %s \nAltura(m): %.2f \nPeso(t): %.2f \nNumero de Piezas: %d \nPrecio(€): %.2f \nComision Galeria(€): %.2f \nImporte por peso(€) %d \nImporte por altura(m): %d \n%sPrecio venta(€): %.2f \nDescuento(%d %s €) %f \nPrecio final de venta(€): %.2f";
    final static private String TEXTO_NOMBRE        = "Introduce el nombre de la obra: ";
    final static private String TEXTO_ID            = "Introduce el ID de la obra: ";
    final static private String TEXTO_PRECIO        = "Introduce el precio de la obra(€): ";
    final static private String TEXTO_ALTURA        = "Introduce la altura de la obra(m): ";
    final static private String TEXTO_PESO          = "Introduce el peso de la obra(t): ";
    final static private String TEXTO_NºPIEZAS      = "Introduce el numero de piezas de la obra: ";
    final static private String TEXTO_TIPO          = "Introduce el tipo("+ROJO+"Escultura"+BLANCO+" o "+ROJO+"Pintura"+BLANCO+"): ";
    final static private String TEXTO_AUTOR         = "Introduce el nombre del autor: ";
    final static private String TEXTO_DESCRIPCION   = "Introduce la descripcion de la obra: ";
    final static private String TEXTO_ERROR         = "El tipo de obra es incorrecta, intentalo de nuevo. ";
    final static private String TEXTO_PREGUNTA      = "Vuelve a introducir el tipo ("+ROJO+"Escultura"+BLANCO+" o "+ROJO+"Pintura"+BLANCO+"): ";
    final static private String TEXTO_CORRECTO      = "Tipo introducido correctamente. ";

    final static private int COMISION_GALERIA       = 25;
    final static private int DESCUENTO_PINTURA      = 10;
    final static private int DESCUENTO_ESCULTURA       = 20;

    public static ObraDeArte[] obrasGuardadas = new ObraDeArte[5];
    // !ATRIBUTOS
    private static int importe_peso;
    private static int importe_altura;

    public static void main(String[] args) {
        for(int i = 0; i< obrasGuardadas.length; i++){
            obrasGuardadas[i] = darAltaObra();
        }
        for(int i = 0; i<obrasGuardadas.length; i++){
            System.out.println(obrasGuardadas[i].getId());
        }
        
    }// *MAIN

    // ?METODOS
    public static String mostrarObra(ObraDeArte obra) { //MOSTRAR OBRA
        return "Mostrando Obra: \n" + String.format(FORMATO_VISUALIZAR, obra.getNombre(), obra.getAutor(), obra.getPrecio(), obra.getAltura(),
                obra.getPeso(), obra.getnPiezas(), obra.getDescripcion());
    }

    public static String obtenerPrecioVentaEtiqueta(ObraDeArte obra, int descuento) { //MOSTAR ETIQUETA VENTA
        return String.format(FORMATO_ETIQUETA, obra.getNombre(), obra.getAltura(), obra.getPeso(), obra.getnPiezas(),
            obra.getPrecio(), (obra.getPrecio() * COMISION_GALERIA) / 100, calcularPrecioPeso(obra), calcularPrecioAltura(obra),
            imprimirImporteAdiccional(obra), obtenerPrecioVenta(obra), DESCUENTO_ESCULTURA, obra.getNombre(), calcularDescuento(obra,DESCUENTO_ESCULTURA),
            calcularPrecioFinalVenta(obra));
    }
    public static String obtenerTicket(ObraDeArte obra){
        return "Nombre: " + obra.getNombre() + "\nAutor: " + obra.getAutor() + "\nDescripcion: " + obra.getDescripcion();
    }
    public static double obtenerPrecioVenta(ObraDeArte obra) { //OBTENER PRECIO DE VENTA SIN PORCENTAJES FINALES
        double precio = obra.getPrecio();
        precio += ((obra.getPrecio() * COMISION_GALERIA) / 100); // INCREMENTO COMISION
        precio += calcularPrecioPeso(obra);
        precio += calcularPrecioAltura(obra);
        precio += calcularPlusPiezas(obra);
        return precio;
    }

    public static String imprimirImporteAdiccional(ObraDeArte obra) {//Imprimir n veces importe x piezas
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
    //CALCULOS
    public static double calcularDescuento(ObraDeArte obra, int descuento) {
        return ((obtenerPrecioVenta(obra) * DESCUENTO_ESCULTURA) / 100);
    }

    public static double calcularPrecioFinalVenta(ObraDeArte obra) {
        return obtenerPrecioVenta(obra) - calcularDescuento(obra, DESCUENTO_ESCULTURA);
    }

    public static int calcularPrecioPeso(ObraDeArte obra) { // METODO QUE DEVUELVE BOOLEAN SEGUN PESO
        if ((obra.getPeso() * 1000) >= 1) { // PESA MAS DE 1KG
            importe_peso = 100;
            return importe_peso;
        } else {
            importe_peso = 20;
            return importe_peso;
        }
    }

    public static int calcularPrecioAltura(ObraDeArte obra) {
        if ((obra.getAltura() >= 2.0)) {
            importe_altura = 100;
            return importe_altura;
        } else {
            importe_altura = 20;
            return importe_altura;
        }
    }

    public static int calcularPlusPiezas(ObraDeArte obra) {
        int precio = 0;
        if (obra.getnPiezas() > 2) { // INCREMENTO NºPIEZAS
            precio = (precio + ((obra.getnPiezas() - 2) * 10));
        }
        return precio;
    }

    public static String importeAdiccional(int nPiezas) {
        String texto = "";
        if (nPiezas > 2) {
            for (int i = 3; i < nPiezas + 1; i++) {
                texto += "Importe adicional - Pieza " + i + " (€): 10\n";
            }
        } else {
            texto = "";
        }
        return texto;
    }
    //METODOS SCANNER OBRA
    public static String imprimirString(String texto){
        Scanner textSc = new Scanner(System.in);
        System.out.print(BLANCO +texto + MORADO);
        String resultado = textSc.nextLine();
        return resultado;
    }
    public static int imprimirInteger(String texto){
        Scanner numberSc = new Scanner(System.in);
        System.out.print(BLANCO + texto + MORADO);
        int resultado = numberSc.nextInt();
        return resultado;
    }
    public static double imprimirDouble(String texto){
        Scanner doubleSc = new Scanner(System.in);
        System.out.print(BLANCO + texto + MORADO );
        double resultado = doubleSc.nextDouble();
        return resultado;
    }

    //DAR DE ALTA
    public static ObraDeArte darAltaObra(){
        int id              = imprimirInteger(TEXTO_ID);
        int piezas          = imprimirInteger(TEXTO_NºPIEZAS);
        double precio       = imprimirDouble(TEXTO_PRECIO);
        double altura       = imprimirDouble(TEXTO_ALTURA);
        double peso         = imprimirDouble(TEXTO_PESO);
        String tipo         = imprimirString(TEXTO_TIPO);
        String nombre       = imprimirString(TEXTO_NOMBRE);
        String autor        = imprimirString(TEXTO_AUTOR);
        String descripcion  = imprimirString(TEXTO_DESCRIPCION);

        ObraDeArte obra = new ObraDeArte(id,precio,altura,peso,piezas,tipo,nombre,autor,descripcion);
        checkTipos(obra);
        return obra;
    }
    //CHECKEAR TIPO
    public static void checkTipos(ObraDeArte obra){
        if(!(obra.getTipo().equals("Escultura")) && !(obra.getTipo().equals("Pintura"))){
            String tipo = imprimirString(ROJO + TEXTO_ERROR + BLANCO + "\n" + TEXTO_PREGUNTA);
            obra.setTipo(tipo);
            checkTipos(obra);
        }else{
            System.out.println(VERDE + TEXTO_CORRECTO + BLANCO);
        }
    } 
}
