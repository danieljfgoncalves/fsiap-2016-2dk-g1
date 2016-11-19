/*
 * Package location for Application calculus model concepts.
 */
package model.calculations;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ivo Ferro
 */
public class MaximumPowerCalculusTest {

    /**
     * Test of calculate method, of class MaximumPowerCalculus.
     */
    @Test
    public void testCalculate() {
        System.out.println("calculate");

        Double wavelength = 500e-9;
        Double focalPointArea = 200e-6;

        MaximumPowerCalculus instance = new MaximumPowerCalculus(wavelength, focalPointArea);
        double expResult = 15.1833815e3;
        double result = instance.calculate();
        assertEquals(expResult, result, 0.0001);
    }

}
