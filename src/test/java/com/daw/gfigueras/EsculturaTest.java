package com.daw.gfigueras;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EsculturaTest {
    private final double DESCUENTO = 0.20;
    private final double SOBRECOSTE_ESCULTURA = 50.0;
    Escultura escultura;

    @BeforeEach
    void crearEscultura(){
        escultura = new Escultura(005, 350.0, 1.0, 0.8, 1, "Escultura",  "El Piel roja","U.Checa", "Escultura de Acero", "Acero"); 
    }
    @AfterEach
    void borrarObra(){
        escultura = null;
    }
    @Test
    void testCalcularDescuento() {
        double expected = (escultura.getPrecio() * DESCUENTO) + SOBRECOSTE_ESCULTURA;
        assertEquals(expected, escultura.calcularDescuento(escultura.getPrecio()));
    }

    @Test
    void testGetDescuento() {
        double expected = (DESCUENTO * 100);
        assertEquals(expected, escultura.getDescuento());
    }

    @Test
    void testGetMaterial() {
        String expected = "Acero";
        assertEquals(expected, escultura.getMaterial());
    }

    @Test
    void testSetMaterial() {
        String expected = "Cobre";
        escultura.setMaterial("Cobre");
        assertEquals(expected, escultura.getMaterial());
    }

    @Test
    void testToString() {
        String expected = "ObraDeArte id=" + escultura.getId() + ", nPiezas=" + escultura.getnPiezas() + ", precio=" + escultura.getPrecio() + ", altura=" + escultura.getAltura() + ", peso="
        + escultura.getPeso() + ", nombre=" + escultura.getNombre() + ", autor=" + escultura.getAutor() + ", descripcion=" + escultura.getDescripcion() + ", Tipo: " + escultura.getTipo() + ", Material: " + escultura.getMaterial();
        assertEquals(expected, escultura.toString());
    }
}
