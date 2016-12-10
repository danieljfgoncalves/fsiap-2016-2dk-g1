/*
 * Package location for Application calculus model concepts.
 */
package model.calculations;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Tests the maximum power calculus class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class MaximumPowerCalculusTest {

    /**
     * The maximum power calculus instance to be tested.
     */
    private MaximumPowerCalculus instance;

    @Before
    public void setUp() throws Exception {
        instance = new MaximumPowerCalculus(1.064e-6, 7.85e-7);
    }

    /**
     * Test of calculate method, of class MaximumPowerCalculus.
     */
    @Test
    public void testCalculate() {
        System.out.println("calculate");

        double expResult = 199.1471;
        double result = instance.calculate();

        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of getWavelength method, of class MaximumPowerCalculus.
     */
    @Test
    public void testGetWavelength() {
        System.out.println("getWavelength");

        Double expResult = 1.064e-6;
        Double result = instance.getWavelength();

        assertEquals(expResult, result);
    }

    /**
     * Test of setWavelength method, of class MaximumPowerCalculus.
     */
    @Test
    public void testSetWavelength() {
        System.out.println("setWavelength");

        Double wavelength = 10060E-9;
        instance.setWavelength(10060E-9);

        assertEquals(instance.getWavelength(), wavelength, 0.0001);
    }

    /**
     * Test of getFocalPointArea method, of class MaximumPowerCalculus.
     */
    @Test
    public void testGetFocalPointArea() {
        System.out.println("getFocalPointArea");

        Double expResult = 7.85e-7;
        Double result = instance.getFocalPointArea();

        assertEquals(expResult, result);
    }

    /**
     * Test of setFocalPointArea method, of class MaximumPowerCalculus.
     */
    @Test
    public void testSetFocalPointArea() {
        System.out.println("setFocalPointArea");

        Double focalPointArea = 8E-3;
        instance.setFocalPointArea(focalPointArea);

        assertEquals(instance.getFocalPointArea(), focalPointArea);
    }

}
