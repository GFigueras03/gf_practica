package com.daw.gfigueras;
/**
 * Unit test for simple App.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;

public class AppTest {

    Pintura obra1    ;    
    Pintura obra2    ;   
    Pintura obra3    ;  
    Pintura obra4    ; 
    Escultura obra5  ;

    @BeforeEach
    void crearTiempo(){
       obra1 = new Pintura(001, 1000.0, 5.0, 2.0, 5, "Pintura", "Guernica","P.Picasso", "Cuadro Guerra civil", "Oleo"); 
       obra2 = new Pintura(002, 200.0, 1.0, 1.0, 1, "Pintura",  "La Vie","P.Picasso", "Pintura de Oleo", "Oleo"); 
       obra3 = new Pintura(003, 300.0, 1.4, 1.0, 1, "Pintura",  "El Sueño","P.Picasso", "Pintura de Acuarela", "Acuarela"); 
       obra4 = new Pintura(004, 400.0, 1.0, 1.0, 1, "Pintura",  "Retrato de Dora Maar","P.Picasso", "Pintura de Carboncillo", "Carboncillo"); 
       obra5 = new Escultura(005, 350.0, 1.0, 0.8, 1, "Escultura",  "El Piel roja","U.Checa", "Escultura de Acero", "Acero"); 
    }

    @AfterEach
    void borrarTiempo(){
        obra1 = null;
        obra2 = null;
        obra3 = null;
        obra4 = null;
        obra5 = null;
    }

    @Test 
    void getDescuentoPorAlturaTest(){
        int expexted = 100 * obra1.getnPiezas();
        assertEquals(expexted, obra1.calcularPrecioAltura());
    }

    @Test
    void calcularPrecio(){
        ObraDeArte obraExample = obra1;
        double comisionGaleriaEuros = ((obraExample.getPrecio() * Galeria.COMISION_GALERIA_PERCENT) / 100);
        int importePeso             = obraExample.calcularPrecioPeso();
        int importeAltura           = obraExample.calcularPrecioAltura();
        int importePlusPiezas       = obraExample.calcularPlusPiezas();

        double expected = obraExample.getPrecio();
        expected += comisionGaleriaEuros;
        expected += importeAltura;
        expected += importePeso;
        expected += importePlusPiezas;

        assertEquals(expected, Galeria.obtenerPrecioVenta(obraExample));
    }

    @Test
    void calcularPrecioFinalVentaTest(){
        double expexted = Galeria.obtenerPrecioVenta(obra1) - obra1.calcularDescuento(Galeria.obtenerPrecioVenta(obra1));
        expexted *= Galeria.CONVERSOR_DOLARES;

        assertEquals(expexted, Galeria.calcularPrecioFinalVenta(obra1));
    }

}
