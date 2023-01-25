package com.daw.gfigueras;

public class Galeria {
    // !ATRIBUTOS
    final static private String FORMATO_VISUALIZAR = "Nombre: %s \nAutor: %s \nPrecio(€): %f \nAltura(m): %f \nPeso(t): %f \nNumero de piezas: %d \nDescripcion: %s";
    final static private String FORMATO_ETIQUETA = "Nombre: %s \nAltura(m): %.2f \nPeso(t): %.2f \nNumero de Piezas: %d \nPrecio(€): %.2f \nComision Galeria(€): %.2f \nImporte por peso(€) %d \nImporte por altura(m): %d \n%sPrecio venta(€): %.2f \nDescuento(%d %s €) %f \nPrecio final de venta(€): %.2f";
    final static private int COMISION_GALERIA = 25;
    final static private int DESCUENTO = 10;

    private static int importe_peso;
    private static int importe_altura;

    public static void main(String[] args) {
        ObraDeArte guernica = new ObraDeArte(001, 100.0, 5.0, 2.0, 5, "oleo", "El Guernica", "Picasso",
                "Obra de arte pintada por Pablo Picasso");
        System.out.println(obtenerPrecioVentaEtiqueta(guernica));
    }// *MAIN

    // ?METODOS
    public static String mostrarObra(ObraDeArte obra) {
        return String.format(FORMATO_VISUALIZAR, obra.getNombre(), obra.getAutor(), obra.getPrecio(), obra.getAltura(),
                obra.getPeso(), obra.getnPiezas(), obra.getDescripcion());

    }

    public static String obtenerPrecioVentaEtiqueta(ObraDeArte obra) {
        return String.format(FORMATO_ETIQUETA, obra.getNombre(), obra.getAltura(), obra.getPeso(), obra.getnPiezas(),
                obra.getPrecio(), (obra.getPrecio() * COMISION_GALERIA) / 100, obra.pesaMasde1Kg(obra),
                alturaMasDe2m(obra),
                importeAdiccional(obra), obtenerPrecioVenta(obra), DESCUENTO, obra.getNombre(), calcularDescuento(obra),
                precioFinalVenta(obra));
    }

    public static double obtenerPrecioVenta(ObraDeArte obra) {
        double precio = obra.getPrecio();
        precio += ((obra.getPrecio() * COMISION_GALERIA) / 100); // INCREMENTO COMISION
        precio += obra.pesaMasde1Kg(obra);
        precio += obra.alturaMasDe2m(obra);
        precio += obra.plusNpiezas(obra);
        return precio;
    }

    public static String importeAdiccional(ObraDeArte obra) {
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

    public static double precioFinalVenta(ObraDeArte obra) {
        return obtenerPrecioVenta(obra) - calcularDescuento(obra);
    }

    public static int pesaMasde1Kg(ObraDeArte obra) { // METODO QUE DEVUELVE BOOLEAN SEGUN PESO
        if ((obra.getPeso() * 1000) >= 1) { // PESA MAS DE 1KG
            importe_peso = 100;
            return importe_peso;
        } else {
            importe_peso = 20;
            return importe_peso;
        }
    }

    public static int alturaMasDe2m(ObraDeArte obra) {
        if ((obra.getAltura() >= 2.0)) {
            importe_altura = 100;
            return importe_altura;
        } else {
            importe_altura = 20;
            return importe_altura;
        }
    }

    public static int plusNpiezas(ObraDeArte obra) {
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

}
