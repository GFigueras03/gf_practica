package com.daw.gfigueras;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.daw.gfigueras.Constantes.*;

import org.junit.jupiter.api.Test;

public class GaleriaTest {
    ArrayObras obrasGuardadas = new ArrayObras();
    Pintura obra1 = new Pintura(001, 1000.0, 5.0, 2.0, 5, "Pintura", "Guernica", "P.Picasso", "Cuadro Guerra civil","Oleo");
    Pintura obra2       = new Pintura(1, 200.0, 1.0, 1.0, 1, "Pintura",  "La Vie","P.Picasso", "Pintura de Oleo", "Oleo"); 
    Pintura obra3       = new Pintura(2, 300.0, 1.4, 1.0, 1, "Pintura",  "El Sueño","P.Picasso", "Pintura de Acuarela", "Acuarela"); 
    Pintura obra4       = new Pintura(3, 400.0, 1.0, 1.0, 1, "Pintura",  "Retrato de Dora Maar","P.Picasso", "Pintura de Carboncillo", "Carboncillo"); 
    Escultura obra5     = new Escultura(4, 350.0, 1.0, 0.8, 1, "Escultura",  "El Piel roja","U.Checa", "Escultura de Acero", "Acero"); 

    

    @Test
    void testCalcularId() {
        int expected = obrasGuardadas.getTam();
        assertEquals(expected, Galeria.calcularId());
    }

    @Test
    void testCalcularPrecioFinalVenta() {
        ObraDeArte obra = obra1;
        double precio = Galeria.obtenerPrecioVenta(obra) - obra.calcularDescuento(Galeria.obtenerPrecioVenta(obra));
        double expected = precio * CONVERSOR_DOLARES;
        assertEquals(expected, Galeria.calcularPrecioFinalVenta(obra));
    }


    @Test
    void testMostrarObra() {
        ObraDeArte obra = obra1;
        String expected = TEXTO_VERDE + MOSTRAR_OBRA_STRING + TEXTO_BLANCO + String.format(FORMATO_VISUALIZAR,
        obra.getNombre(), obra.getId(), obra.getAutor(), obra.getPrecio(), obra.getAltura(), obra.getPeso(),
        obra.getnPiezas(), obra.getDescripcion(), obra.getTipo() );
        assertEquals(expected, Galeria.mostrarObra(obra));
    }

    @Test
    void testObtenerPrecioVenta() {
        ObraDeArte obra = obra1;
        double comisionGaleriaEuros = ((obra.getPrecio() * COMISION_GALERIA_PERCENT) / 100);
        int importePeso             = obra.calcularPrecioPeso();
        int importeAltura           = obra.calcularPrecioAltura();
        int importePlusPiezas       = obra.calcularPlusPiezas();

        double expected = obra.getPrecio();
        expected += comisionGaleriaEuros;
        expected += importeAltura;
        expected += importePeso;
        expected += importePlusPiezas;

        assertEquals(expected, Galeria.obtenerPrecioVenta(obra));

    }

    @Test
    void testObtenerPrecioVentaEtiqueta() {
        ObraDeArte obra = obra1;
        String expected =TEXTO_VERDE + PRECIO_VENTA_STRING + TEXTO_BLANCO + String.format(FORMATO_ETIQUETA, obra.getNombre(),
        obra.getAltura(), obra.getPeso(), obra.getnPiezas(), obra.getPrecio(),
        (obra.getPrecio() * COMISION_GALERIA_PERCENT) / 100, obra.calcularPrecioPeso(),
        obra.calcularPrecioAltura(),
        obra.imprimirImporteAdiccional(), Galeria.obtenerPrecioVenta(obra), obra.getDescuento(), obra.getTipo(),
        obra.calcularDescuento(Galeria.obtenerPrecioVenta(obra)),
        Galeria.calcularPrecioFinalVenta(obra));

        assertEquals(expected, Galeria.obtenerPrecioVentaEtiqueta(obra, obra.getDescuento()));
    }

    @Test
    void testObtenerTicket() {
    ObraDeArte obra = obra1;
    String expected = TEXTO_VERDE + ETIQUETA_STRING + TEXTO_BLANCO + "Nombre: " + obra.getNombre() + "\nAutor: " + obra.getAutor()
    + "\nDescripcion: " + obra.getDescripcion() + "\n";

    assertEquals(expected, Galeria.obtenerTicket(obra));
    }

}
