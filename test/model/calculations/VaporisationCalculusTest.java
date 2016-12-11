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
     * test Material
     */
    private Material testMaterial;

    /**
     * vaporisation calculus instance
     */
    private VaporisationCalculus calculus;

    public VaporisationCalculusTest() {

        testMaterial = new Material("Graphit (carbon)", 5.95303E7, 7.20000E2, 2.23000E3, 4200.0, null, false);
        calculus = new VaporisationCalculus(199.90, 7.85E-7, testMaterial);
    }

    /**
     * Test of calculate method, of class VaporisationCalculus.
     */
    @Test
    public void testCalculate() {
        System.out.println("calculate");
        double expResult = 1.83E-3;
        double result = calculus.calculate();
        System.out.printf("%n**%nExpected Result: %.4E%nResult: %.4E%n**%n", expResult, result);
        assertEquals(expResult, result, 0.00001);
    }

    /**
     * Test of getPowerDensity method, of class VaporisationCalculus.
     */
    @Test
    public void testGetPowerDensity() {
        System.out.println("getPowerDensity");
        Double expResult = 2.546496815286624E8;
        Double result = calculus.getPowerDensity();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of setPowerDensity method, of class VaporisationCalculus.
     */
    @Test
    public void testSetPowerDensity() {
        System.out.println("setPowerDensity");
        Double power = 199.90;
        Double focalPoint = 7.85E-7;
        Double expResult = (power / focalPoint);
        calculus.setPowerDensity(power, focalPoint);
        assertEquals(expResult, calculus.getPowerDensity());
    }

    /**
     * Test of getMaterial method, of class VaporisationCalculus.
     */
    @Test
    public void testGetMaterial() {
        System.out.println("getMaterial");
        Material expResult = testMaterial;
        Material result = calculus.getMaterial();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMaterial method, of class VaporisationCalculus.
     */
    @Test
    public void testSetMaterial() {
        System.out.println("setMaterial");
        Material material = new Material();
        calculus.setMaterial(material);
        assertEquals(material, calculus.getMaterial());
    }

    /**
     * Test of getInicialTemp method, of class VaporisationCalculus.
     */
    @Test
    public void testGetInicialTemp() {
        System.out.println("getInicialTemp");
        Double expResult = 20.0;
        Double result = calculus.getInicialTemp();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInicialTemp method, of class VaporisationCalculus.
     */
    @Test
    public void testSetInicialTemp() {
        System.out.println("setInicialTemp");
        Double inicialTemp = 30.0;
        calculus.setInicialTemp(inicialTemp);
        assertEquals(inicialTemp, calculus.getInicialTemp());
    }

}
