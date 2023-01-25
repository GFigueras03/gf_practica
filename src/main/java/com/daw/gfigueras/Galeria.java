package com.daw.gfigueras;

import java.util.Scanner;

public class Galeria {
    // !CONSTANTES
    final static private String FORMATO_VISUALIZAR  = "Nombre: %s \nAutor: %s \nPrecio(€): %f \nAltura(m): %f \nPeso(t): %f \nNumero de piezas: %d \nDescripcion: %s";
    final static private String FORMATO_ETIQUETA    = "Nombre: %s \nAltura(m): %.2f \nPeso(t): %.2f \nNumero de Piezas: %d \nPrecio(€): %.2f \nComision Galeria(€): %.2f \nImporte por peso(€) %d \nImporte por altura(m): %d \n%sPrecio venta(€): %.2f \nDescuento(%d %s €) %f \nPrecio final de venta(€): %.2f";
    final static private String TEXTO_NOMBRE        = "Introduce el nombre de la obra: ";
    final static private String TEXTO_ID            = "Introduce el ID de la obra: ";
    final static private String TEXTO_PRECIO        = "Introduce el precio de la obra: ";
    final static private String TEXTO_ALTURA        = "Introduce la altura de la obra: ";
    final static private String TEXTO_PESO          = "Introduce el peso de la obra: ";
    final static private String TEXTO_NºPIEZAS      = "Introduce el numero de piezas de la obra: ";
    final static private String TEXTO_TIPO          = "Introduce el tipo: ";
    final static private String TEXTO_AUTOR         = "Introduce el nombre del autor: ";
    final static private String TEXTO_DESCRIPCION   = "Introduce la descripcion de la obra: ";

    final static private int COMISION_GALERIA = 25;
    final static private int DESCUENTO = 10;
    // !ATRIBUTOS
    private static int importe_peso;
    private static int importe_altura;

    public static void main(String[] args) {
        System.out.println(mostrarObra(darAltaObra()));
        
    }// *MAIN

    // ?METODOS
    public static String mostrarObra(ObraDeArte obra) { //MOSTRAR OBRA
        return String.format(FORMATO_VISUALIZAR, obra.getNombre(), obra.getAutor(), obra.getPrecio(), obra.getAltura(),
                obra.getPeso(), obra.getnPiezas(), obra.getDescripcion());
    }

    public static String obtenerPrecioVentaEtiqueta(ObraDeArte obra) { //MOSTAR ETIQUETA VENTA
        return String.format(FORMATO_ETIQUETA, obra.getNombre(), obra.getAltura(), obra.getPeso(), obra.getnPiezas(),
            obra.getPrecio(), (obra.getPrecio() * COMISION_GALERIA) / 100, calcularPrecioPeso(obra), calcularPrecioAltura(obra),
            imprimirImporteAdiccional(obra), obtenerPrecioVenta(obra), DESCUENTO, obra.getNombre(), calcularDescuento(obra),
            calcularPrecioFinalVenta(obra));
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

    public static double calcularDescuento(ObraDeArte obra) {
        return ((obtenerPrecioVenta(obra) * DESCUENTO) / 100);
    }

    public static double calcularPrecioFinalVenta(ObraDeArte obra) {
        return obtenerPrecioVenta(obra) - calcularDescuento(obra);
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
        Scanner text = new Scanner(System.in);
        System.out.println(texto);
        String resultado = text.nextLine();
        return resultado;
    }
    public static int imprimirInteger(String texto){
        Scanner number = new Scanner(System.in);
        System.out.println(texto);
        int resultado = number.nextInt();
        return resultado;
    }
    public static double imprimirDouble(String texto){
        Scanner doubleSrc = new Scanner(System.in);
        System.out.println(texto);
        double resultado = doubleSrc.nextDouble();
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
        return obra;

    }

}
