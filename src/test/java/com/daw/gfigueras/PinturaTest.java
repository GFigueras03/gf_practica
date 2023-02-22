package com.daw.gfigueras;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PinturaTest {
    private final double DESCUENTO = 0.10;
    Pintura pintura;

    @BeforeEach
    void crearpintura(){
        pintura = new Pintura(001, 1000.0, 5.0, 2.0, 5, "Pintura", "Guernica","P.Picasso", "Cuadro Guerra civil", "Oleo"); 
    }
    @AfterEach
    void borrarObra(){
        pintura = null;
    }
    @Test
    void testCalcularDescuento() {
        double expected = (pintura.getPrecio() * DESCUENTO);
        assertEquals(expected, pintura.calcularDescuento(pintura.getPrecio()));
    }

    @Test
    void testGetDescuento() {
        double expected = (DESCUENTO * 100);
        assertEquals(expected, pintura.getDescuento());
    }

    @Test
    void testGetTecnica() {
        String expected = "Oleo";
        assertEquals(expected, pintura.getTecnica());
    }

    @Test
    void testSetTecnica() {
        String expected = "Carboncillo";
        pintura.setTecnica("Carboncillo");
        assertEquals(expected, pintura.getTecnica());
    }

    @Test
    void testToString() {
        String expected = "ObraDeArte id=" + pintura.getId() + ", nPiezas=" + pintura.getnPiezas() + ", precio=" + pintura.getPrecio() + ", altura=" + pintura.getAltura() + ", peso="
        + pintura.getPeso() + ", nombre=" + pintura.getNombre() + ", autor=" + pintura.getAutor() + ", descripcion=" + pintura.getDescripcion() + ", Tipo: " + pintura.getTipo() + ", Técnica: " + pintura.getTecnica();
        assertEquals(expected, pintura.toString());
    }
}
