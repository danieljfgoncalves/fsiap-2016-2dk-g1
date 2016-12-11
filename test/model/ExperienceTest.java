/*
 * Package location for model tests concepts.
 */
package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests of experience class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class ExperienceTest {

    /**
     * The instance to be tested.
     */
    private Experience instance;

    /**
     * Laser to be used on tests.
     */
    private Laser laser;

    @Before
    public void setUp() {
        laser = new Laser(10600e-9, new Gas("CO2", 9200E-9, 11400E-9), 2e-3,
                new Material("Gold", 63000.0, 130.0, 19320.0, 2800.0, 1063.0, true), 4e-3);
        instance = new Experience(laser);
    }

    /**
     * Test of getCuttingTimeLimit method, of class Experience.
     */
    @Test
    public void testGetCuttingTimeLimit() {
        System.out.println("getCuttingTimeLimit");

        Double expResult = 30d;
        Double result = instance.getCuttingTimeLimit();

        assertEquals(expResult, result);
    }

    /**
     * Test of setCuttingTimeLimit method, of class Experience.
     */
    @Test
    public void testSetCuttingTimeLimit() {
        System.out.println("setCuttingTimeLimit");

        Double cuttingTimeLimit = 15d;
        instance.setCuttingTimeLimit(cuttingTimeLimit);

        assertEquals(instance.getCuttingTimeLimit(), cuttingTimeLimit);
    }

    /**
     * Test of isCut method, of class Experience.
     */
    @Test
    public void testIsCut() {
        System.out.println("isCut");
        assertFalse(instance.isCut());
    }

    /**
     * Test of setCut method, of class Experience.
     */
    @Test
    public void testSetCut() {
        System.out.println("setCut");

        instance.setCut();

        assertTrue(instance.isCut());
    }

    /**
     * Test of getPenetrationVelocity method, of class Experience.
     */
    @Test
    public void testGetPenetrationVelocity() {
        System.out.println("getPenetrationVelocity");

        Double expResult = 0d;
        Double result = instance.getPenetrationVelocity();

        assertEquals(expResult, result);
    }

    /**
     * Test of setPenetrationVelocity method, of class Experience.
     */
    @Test
    public void testSetPenetrationVelocity() {
        System.out.println("setPenetrationVelocity");

        Double penetrationVelocity = 22d;
        instance.setPenetrationVelocity(penetrationVelocity);

        assertEquals(instance.getPenetrationVelocity(), penetrationVelocity);
    }

    /**
     * Test of getCuttingSpeed method, of class Experience.
     */
    @Test
    public void testGetCuttingSpeed() {
        System.out.println("getCuttingSpeed");

        Double expResult = Double.NaN;
        Double result = instance.getCuttingSpeed();

        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of setCuttingSpeed method, of class Experience.
     */
    @Test
    public void testSetCuttingSpeed() {
        System.out.println("setCuttingSpeed");

        Double cuttingSpeed = 33d;
        instance.setCuttingSpeed(cuttingSpeed);

        assertEquals(instance.getCuttingSpeed(), cuttingSpeed);
    }

    /**
     * Test of getLaser method, of class Experience.
     */
    @Test
    public void testGetLaser() {
        System.out.println("getLaser");

        Laser expResult = laser;
        Laser result = instance.getLaser();

        assertEquals(expResult, result);
    }

    /**
     * Test of setLaser method, of class Experience.
     */
    @Test
    public void testSetLaser() {
        System.out.println("setLaser");

        Laser laserToSet = new Laser(1d, new Gas("abc", 1d, 1d), 1d,
                new Material("a", 1d, 1d, 1d, 1d, 1d, true), 1d);
        instance.setLaser(laserToSet);

        assertEquals(instance.getLaser(), laserToSet);
    }

    /**
     * Test of calculatePenetrationVelocity method, of class Experience.
     */
    @Test
    public void testCalculatePenetrationVelocity_0args() {
        System.out.println("calculatePenetrationVelocity");

        instance.calculatePenetrationVelocity();

        Double result = instance.getPenetrationVelocity();
        Double expResult = 0.01d;

        assertEquals(expResult, result, 0.1d);
    }

    /**
     * Test of calculatePenetrationVelocity method, of class Experience.
     */
    @Test
    public void testCalculatePenetrationVelocity_Float() {
        System.out.println("calculatePenetrationVelocity");

        Float factor = 23f;
        instance.calculatePenetrationVelocity(factor);

        Double result = instance.getPenetrationVelocity();
        Double expResult = 0.15d;

        assertEquals(expResult, result, 0.1d);
    }

    /**
     * Test of generateResults method, of class Experience.
     */
    @Test
    public void testGenerateResults() {
        System.out.println("generateResults");

        String[][] expResult = {{"Gás do laser", "CO2"},
        {"Poder do laser", "8,0000E+01 W"},
        {"Área afectada", "3,1416E+00 mm2"},
        {"Material", "Gold"},
        {"Espessura do material", "4,0000E+00 mm"},
        {"Método de corte", "Corte por fusão"},
        {"Velocidade de penetração", "0,0000E+00 mm/s"},
        {"Tempo para cortar", "Infinity s"},
        {"Corta?", "Não"},
        {"Velocidade do corte", "N/A"}};
        String[][] result = instance.generateResults();

        assertArrayEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Experience.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        Object obj = new Experience(new Laser(1d, new Gas("abc", 1d, 1d), 1d,
                new Material("a", 1d, 1d, 1d, 1d, 1d, true), 1d));

        assertFalse(instance.equals(obj));

        obj = new Experience(new Laser(10600e-9, new Gas("CO2", 9200E-9, 11400E-9), 2e-3,
                new Material("Gold", 63000.0, 130.0, 19320.0, 2800.0, 1063.0, true), 4e-3));

        assertTrue(instance.equals(obj));
    }

}
