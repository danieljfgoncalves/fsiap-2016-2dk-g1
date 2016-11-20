package model.calculations;

import model.Material;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests a VaporisationCalculus class.
 *
 * @author Eric Amaral 1141570
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class VaporisationCalculusTest {

    /**
     *
     */
    private Material testMaterial;

    public VaporisationCalculusTest() {

        testMaterial = new Material("Graphit (carbon)", 5.95303E7, 7.20000E2, 2.23000E3, 4200.0 , null, false);
    }

    /**
     * Test of calculate method, of class VaporisationCalculus.
     */
    @Test
    public void testCalculate() {
        System.out.println("calculate");
        VaporisationCalculus calculus = new VaporisationCalculus(180.0, 5.027E-5, testMaterial);
        double expResult = 2.56745E-5;
        double result = calculus.calculate();
        System.out.printf("%n**%nExpected Result: %.4E%nResult: %.4E%n**%n", expResult, result);
        assertEquals(expResult, result, 0.00001);
    }

}
