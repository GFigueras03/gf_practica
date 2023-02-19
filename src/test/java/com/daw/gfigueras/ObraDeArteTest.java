package com.daw.gfigueras;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObraDeArteTest {

    public int ALTURA_PIEZAS_TOPE   = 2;
    public int ALTURA_PRECIO_MAX    = 100;
    public int ALTURA_PRECIO_MIN    = 20;
    public int PESO_PRECIO_MAX      = 100;
    public int PESO_PRECIO_MIN      = 20;

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
    void testCalcularDescuento() {
        ObraDeArte obra = obra1;
        double descuento = 0.10;
        double expexted = obra.getPrecio() * descuento;

        assertEquals(expexted, obra.calcularDescuento(obra.getPrecio()));
    }

    @Test
    void testCalcularPlusPiezas() {
        ObraDeArte obra = obra1;
        int plusPiezas = 0;
        if (obra.getnPiezas() > ALTURA_PIEZAS_TOPE) { // INCREMENTO NºPIEZAS
            plusPiezas += (plusPiezas + ((obra.getnPiezas() - 2) * 10));
        }
        int expexted = plusPiezas;
        assertEquals(expexted, obra.calcularPlusPiezas());
        
    }

    @Test
    void testCalcularPrecioAltura() {
        ObraDeArte obra = obra1;
        int expected = 0;
            if ((obra.getAltura() >= ALTURA_PIEZAS_TOPE)) {
                expected =  ALTURA_PRECIO_MAX * obra.getnPiezas();
            } else {
                int expexted =  ALTURA_PRECIO_MIN;
            }

        assertEquals(expected, obra.calcularPrecioAltura());
    }

    @Test
    void testCalcularPrecioPeso() {
        ObraDeArte obra = obra1;
        int expected = 0;
        if ((obra.getPeso() * 1000) >= 1) {
           expected = PESO_PRECIO_MAX;
        } else {
            expected = PESO_PRECIO_MIN;
        }
        assertEquals(expected, obra.calcularPrecioPeso());
    }
}

