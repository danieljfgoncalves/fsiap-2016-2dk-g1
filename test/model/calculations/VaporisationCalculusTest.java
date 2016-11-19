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
        
    }

    /**
     * Test of calculate method, of class VaporisationCalculus.
     */
    @Test
    public void testCalculate() {
        System.out.println("calculate");
        VaporisationCalculus instance = null;
        double expResult = 0.0;
        double result = instance.calculate();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
