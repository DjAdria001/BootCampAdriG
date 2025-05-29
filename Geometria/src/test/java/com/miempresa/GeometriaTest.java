package com.miempresa;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GeometriaTest {

    Geometria geo = new Geometria();

    @Test
    public void testAreaCuadrado() {
        assertEquals(25, geo.areacuadrado(5));
    }

    @Test
    public void testAreaCirculo() {
        assertEquals(Math.PI * 4 * 4, geo.areacirculo(4), 0.01);
    }

    @Test
    public void testAreaTriangulo() {
        assertEquals(10, geo.areatriangulo(5, 4));
    }

    @Test
    public void testAreaRectangulo() {
        assertEquals(20, geo.arearectangulo(5, 4));
    }

    @Test
    public void testAreaPentagono() {
        assertEquals(30, geo.areapentagono(6, 10));
    }
}
