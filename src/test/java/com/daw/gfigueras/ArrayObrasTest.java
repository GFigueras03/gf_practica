package com.daw.gfigueras;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayObrasTest {
    private ArrayObras obrasGuardadas;

    Pintura obra1 = new Pintura(001, 1000.0, 5.0, 2.0, 5, "Pintura", "Guernica", "P.Picasso", "Cuadro Guerra civil","Oleo");
    Pintura obra2 = new Pintura(002, 200.0, 1.0, 1.0, 1, "Pintura", "La Vie", "P.Picasso", "Pintura de Oleo", "Oleo");
    Pintura obra3 = new Pintura(003, 300.0, 1.4, 1.0, 1, "Pintura", "El Sueño", "P.Picasso", "Pintura de Acuarela","Acuarela");
    Pintura obra4 = new Pintura(004, 400.0, 1.0, 1.0, 1, "Pintura", "Retrato de Dora Maar", "P.Picasso","Pintura de Carboncillo", "Carboncillo");
    Escultura obra5 = new Escultura(005, 350.0, 1.0, 0.8, 1, "Escultura", "El Piel roja", "U.Checa","Escultura de Acero", "Acero");

    @BeforeEach
    void crearObra() {
        obrasGuardadas = new ArrayObras();
    }

    @AfterEach
    void borrarObra() {
        obrasGuardadas = null;
    }

    @Test
    void testPush() {
        obrasGuardadas.push(obra1);
        ObraDeArte expected = obra1;
        assertEquals(expected, obrasGuardadas.getObra(0));
    }

    @Test
    void testCambiarTam() {
        obrasGuardadas.cambiarTam(1);
        int expected = obrasGuardadas.getTam();// 6
        assertEquals(expected, obrasGuardadas.getTam());
    }

    @Test
    void testGetObra() {
        obrasGuardadas.push(obra5);
        ObraDeArte expected = obra5;
        assertEquals(expected, obrasGuardadas.getObra(0));
    }

    @Test
    void testGetObrasGuardadas() {
        obrasGuardadas.push(obra1);
        obrasGuardadas.push(obra2);
        obrasGuardadas.push(obra3);
        obrasGuardadas.push(obra4);
        obrasGuardadas.push(obra5);
        String expected = "";
        for (int i = 0; i < obrasGuardadas.getTam(); i++) {
            expected += obrasGuardadas.getObra(i).getNombre() + "\n";
        }
        assertEquals(expected, obrasGuardadas.getObrasGuardadas());
    }

    @Test
    void testGetTam() {
        int expected = 5;
        assertEquals(expected, obrasGuardadas.getTam());
    }

}
