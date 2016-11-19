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

        int wavelength = 500;
        int focalPointDiameter = 4;

        MaximumPowerCalculus instance = new MaximumPowerCalculus(wavelength, focalPointDiameter);
        double expResult = 0.954;
        double result = instance.calculate();
        assertEquals(expResult, result, 0.0001);
    }

}
