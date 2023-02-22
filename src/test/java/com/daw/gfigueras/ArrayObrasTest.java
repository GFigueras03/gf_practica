package com.daw.gfigueras;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayObrasTest {
    private ObraDeArte[] obrasGuardadas;
    private final int TAM_INICIAL   = 1;
    
    private int tamAlmacen          = TAM_INICIAL;
    private int ultimaObraGuardada  = 0;

    Pintura obra1 = new Pintura(001, 1000.0, 5.0, 2.0, 5, "Pintura", "Guernica","P.Picasso", "Cuadro Guerra civil", "Oleo"); 
    Pintura obra2 = new Pintura(002, 200.0, 1.0, 1.0, 1, "Pintura",  "La Vie","P.Picasso", "Pintura de Oleo", "Oleo"); 
    Pintura obra3 = new Pintura(003, 300.0, 1.4, 1.0, 1, "Pintura",  "El Sueño","P.Picasso", "Pintura de Acuarela", "Acuarela"); 
    Pintura obra4 = new Pintura(004, 400.0, 1.0, 1.0, 1, "Pintura",  "Retrato de Dora Maar","P.Picasso", "Pintura de Carboncillo", "Carboncillo"); 
    Escultura obra5 = new Escultura(005, 350.0, 1.0, 0.8, 1, "Escultura",  "El Piel roja","U.Checa", "Escultura de Acero", "Acero"); 
    @BeforeEach
    void crearObra(){
      obrasGuardadas = new ObraDeArte[TAM_INICIAL];
    }
    @AfterEach
    void borrarObra(){
      obrasGuardadas = null;
    }

    @Test
    void testPush() {

    }

    @Test
    void testCambiarTam() {
        
    }

    @Test
    void testGetObra() {

    }

    @Test
    void testGetObrasGuardadas() {

    }

    @Test
    void testGetTam() {
    }

  
}
