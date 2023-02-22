package com.daw.gfigueras;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObraDeArteTest {
    private final double DESCUENTO_PINTURA      = 0.10;


    private double alturaObra1                  = 5.0;
    private double precioObra1                  = 1000.0;
    private double pesoObra1                    = 2.0;
    private int idObra1                         = 001;
    private int nPiezasObra1                    = 5;
    private String tipoObra1                    = "Pintura";
    private String nombreObra1                  = "Guernica";
    private String autorObra1                   = "P.Picasso";
    private String descripcionObra1             = "Cuadro Guerra civil";


    private int PIEZAS_TOPE                     = 2;
    private int ALTURA_PRECIO_MAX               = 100;
    private int ALTURA_PRECIO_MIN               = 20;
    private int PESO_PRECIO_MAX                 = 100;
    private int PESO_PRECIO_MIN                 = 20;

    Pintura obra1    ;    
    Pintura obra2    ;   
    Pintura obra3    ;  
    Pintura obra4    ; 
    Escultura obra5  ;

    @BeforeEach
    void crearObra(){
       obra1 = new Pintura(001, 1000.0, 5.0, 2.0, 5, "Pintura", "Guernica","P.Picasso", "Cuadro Guerra civil", "Oleo"); 
       obra2 = new Pintura(002, 200.0, 1.0, 1.0, 1, "Pintura",  "La Vie","P.Picasso", "Pintura de Oleo", "Oleo"); 
       obra3 = new Pintura(003, 300.0, 1.4, 1.0, 1, "Pintura",  "El Sueño","P.Picasso", "Pintura de Acuarela", "Acuarela"); 
       obra4 = new Pintura(004, 400.0, 1.0, 1.0, 1, "Pintura",  "Retrato de Dora Maar","P.Picasso", "Pintura de Carboncillo", "Carboncillo"); 
       obra5 = new Escultura(005, 350.0, 1.0, 0.8, 1, "Escultura",  "El Piel roja","U.Checa", "Escultura de Acero", "Acero"); 
    }

    @AfterEach
    void borrarObra(){
        obra1 = null;
        obra2 = null;
        obra3 = null;
        obra4 = null;
        obra5 = null;
    }
    @Test
    void testCalcularDescuento() {
        ObraDeArte obra = obra1;
        double descuento = DESCUENTO_PINTURA;
        double expexted = obra.getPrecio() * descuento;

        assertEquals(expexted, obra.calcularDescuento(obra.getPrecio()));
    }

    @Test
    void testCalcularPlusPiezasMasDeDos() {
        ObraDeArte obra = obra1;
        obra.setnPiezas(4);
        int resta = obra.getnPiezas() - PIEZAS_TOPE;
        int expexted = resta * 10;
        assertEquals(expexted, obra.calcularPlusPiezas());
        
    }
    @Test
    void testCalcularPlusPiezasMenosDeDos() {
        ObraDeArte obra = obra1;
        obra.setnPiezas(1);
        int expexted = 0;
        assertEquals(expexted, obra.calcularPlusPiezas());
        
    }

    @Test
    void testCalcularPrecioAlturaBajo() {
      obra1.setAltura(1);
      int expected = ALTURA_PRECIO_MIN;
      assertEquals(expected, obra1.calcularPrecioAltura());
    }

    @Test
    void testCalcularPrecioAlturaAlto() {
      obra1.setAltura(4);
      int expected = (obra1.getnPiezas() * ALTURA_PRECIO_MAX);
      assertEquals(expected, obra1.calcularPrecioAltura());
    }

    @Test
    void testCalcularPrecioPesoConPesoBajo() {
        ObraDeArte obra = obra1;
        obra.setPeso(0.000001);
        int expected = PESO_PRECIO_MIN;
        assertEquals(expected, obra.calcularPrecioPeso());
    }
    @Test
    void testCalcularPrecioPesoConPesoAlto() {
        ObraDeArte obra = obra1;
        obra.setPeso(1);
        int expected = PESO_PRECIO_MAX;
        assertEquals(expected, obra.calcularPrecioPeso());
    }



    @Test
    void testGetAltura() {
        double expected = alturaObra1;
        assertEquals(expected, obra1.getAltura());
    }

    @Test
    void testGetAutor() {
        String expected = autorObra1;
        assertEquals(expected, obra1.getAutor());
    }

    @Test
    void testGetId() {
        int expected = idObra1;
        assertEquals(expected, obra1.getId());
    }

    @Test
    void testGetNombre() {
        String expected = nombreObra1;
        assertEquals(expected, obra1.getNombre());
    }

    @Test
    void testGetPeso() {
        double expected = pesoObra1;
        assertEquals(expected, obra1.getPeso());
    }

    @Test
    void testGetPrecio() {
        double expected = precioObra1;
        assertEquals(expected, obra1.getPrecio());
    }

    @Test
    void testGetTipo() {
        String expected = tipoObra1;
        assertEquals(expected, obra1.getTipo());
    }
    @Test
    void testGetDescripcion() {
        String expected = descripcionObra1;
        assertEquals(expected, obra1.getDescripcion());
    }

    @Test
    void testGetnPiezas() {
        double expected = nPiezasObra1;
        assertEquals(expected, obra1.getnPiezas());
    }

    @Test
    void testSetAltura() {
        obra1.setAltura(4.0);
        double expected = 4.0;
        assertEquals(expected, obra1.getAltura());
    }

    @Test
    void testSetAutor() {
        obra1.setAutor("Juan");
        String expected = "Juan";
        assertEquals(expected, obra1.getAutor());
    }

    @Test
    void testSetDescripcion() {
        obra1.setDescripcion("descripcion");
        String expected = "descripcion";
        assertEquals(expected, obra1.getDescripcion());
    }

    @Test
    void testSetNombre() {
        obra1.setNombre("obra1");
        String expected = "obra1";
        assertEquals(expected, obra1.getNombre());
    }

    @Test
    void testSetPeso() {
        obra1.setPeso(0.0001);
        double expected = 0.0001;
        assertEquals(expected, obra1.getPeso());
    }

    @Test
    void testSetPrecio() {
        obra1.setPrecio(500.0);
        double expected = 500.0;
        assertEquals(expected, obra1.getPrecio());
    }

    @Test
    void testSetTipo() {
        obra1.setTipo("Escultura");
        String expected = "Escultura";
        assertEquals(expected, obra1.getTipo());
    }

    @Test
    void testSetnPiezas() {
        obra1.setnPiezas(12);
        int expected = 12;
        assertEquals(expected, obra1.getnPiezas());
    }

}

