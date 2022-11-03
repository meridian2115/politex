package org.politex.models.logic;

import junit.framework.TestCase;

import java.io.File;

public class KramerTest extends TestCase {

    public void testCalculate1() {
        File file = new File("src/test/resources/kramer_test1.txt");
        Kramer kramer = new Kramer(file);
        assertEquals(0.0, kramer.getX1());
        assertEquals(2.0, kramer.getX2());
        assertEquals(3.0, kramer.getX3());
        assertEquals(42.0, kramer.getD());
    }

    public void testCalculate2() {
        File file = new File("src/test/resources/kramer_test2.txt");
        Kramer kramer = new Kramer(file);
        assertEquals(0.0, kramer.getX1());
        assertEquals(0.0, kramer.getX2());
        assertEquals(0.0, kramer.getX3());
        assertEquals(0.0, kramer.getD());
    }

    public void testCalculate3() {
        File file = new File("src/test/resources/kramer_test3.txt");
        Kramer kramer = new Kramer(file);
        assertEquals(-1.0, kramer.getX1());
        assertEquals(2.0, kramer.getX2());
        assertEquals(1.0, kramer.getX3());
        assertEquals(26.0, kramer.getD());
    }
}