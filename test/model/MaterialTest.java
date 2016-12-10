/*
 * Package location for Application model concepts.
 */
package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests of material class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class MaterialTest {

    /**
     * The instance to be tested.
     */
    private Material instance;

    @Before
    public void setUp() {
        instance = new Material("Nickel", 297000d, 440d, 8908d, 2800d, 1453d, true);
    }

    /**
     * Test of getName method, of class Material.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");

        String expResult = "Nickel";
        String result = instance.getName();

        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Material.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");

        String name = "nickel mat";
        instance.setName(name);

        assertEquals(instance.getName(), name);
    }

    /**
     * Test of getLatentHeat method, of class Material.
     */
    @Test
    public void testGetLatentHeat() {
        System.out.println("getLatentHeat");

        Double expResult = 297000d;
        Double result = instance.getLatentHeat();

        assertEquals(expResult, result, 0.01d);
    }

    /**
     * Test of setLatentHeat method, of class Material.
     */
    @Test
    public void testSetLatentHeat() {
        System.out.println("setLatentHeat");

        Double latentHeat = 4e5;
        instance.setLatentHeat(latentHeat);

        assertEquals(instance.getLatentHeat(), latentHeat, 0.01d);
    }

    /**
     * Test of getHeatCapacity method, of class Material.
     */
    @Test
    public void testGetHeatCapacity() {
        System.out.println("getHeatCapacity");

        Double expResult = 440d;
        Double result = instance.getHeatCapacity();

        assertEquals(expResult, result, 0.01d);
    }

    /**
     * Test of setHeatCapacity method, of class Material.
     */
    @Test
    public void testSetHeatCapacity() {
        System.out.println("setHeatCapacity");

        Double heatCapacity = 333d;
        instance.setHeatCapacity(heatCapacity);

        assertEquals(instance.getHeatCapacity(), heatCapacity, 0.01d);
    }

    /**
     * Test of getDensity method, of class Material.
     */
    @Test
    public void testGetDensity() {
        System.out.println("getDensity");

        Double expResult = 8908d;
        Double result = instance.getDensity();

        assertEquals(expResult, result, 0.01d);
    }

    /**
     * Test of setDensity method, of class Material.
     */
    @Test
    public void testSetDensity() {
        System.out.println("setDensity");

        Double density = 7000d;
        assertTrue(instance.setDensity(density));

        assertEquals(instance.getDensity(), density, 0.01d);
    }

    /**
     * Test of getVaporizationTemperature method, of class Material.
     */
    @Test
    public void testGetVaporizationTemperature() {
        System.out.println("getVaporizationTemperature");

        Double expResult = 2800d;
        Double result = instance.getVaporizationTemperature();

        assertEquals(expResult, result, 0.01d);
    }

    /**
     * Test of setVaporizationTemperature method, of class Material.
     */
    @Test
    public void testSetVaporizationTemperature() {
        System.out.println("setVaporizationTemperature");

        Double vaporizationTemperature = 2000d;
        instance.setVaporizationTemperature(vaporizationTemperature);

        assertEquals(instance.getVaporizationTemperature(), vaporizationTemperature, 0.01d);
    }

    /**
     * Test of getFusionTemperature method, of class Material.
     */
    @Test
    public void testGetFusionTemperature() {
        System.out.println("getFusionTemperature");

        Double expResult = 1453d;
        Double result = instance.getFusionTemperature();

        assertEquals(expResult, result, 0.01d);
    }

    /**
     * Test of setFusionTemperature method, of class Material.
     */
    @Test
    public void testSetFusionTemperature() {
        System.out.println("setFusionTemperature");

        Double fusionTemperature = 2222d;
        instance.setFusionTemperature(fusionTemperature);

        assertEquals(instance.getFusionTemperature(), fusionTemperature, 0.01d);
    }

    /**
     * Test of isMeltable method, of class Material.
     */
    @Test
    public void testIsMeltable() {
        System.out.println("isMeltable");

        assertTrue(instance.isMeltable());
    }

    /**
     * Test of setMeltable method, of class Material.
     */
    @Test
    public void testSetMeltable() {
        System.out.println("setMeltable");

        boolean meltable = false;
        instance.setMeltable(meltable);

        assertFalse(instance.isMeltable());
    }

    /**
     * Test of equals method, of class Material.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        Object obj = null;
        assertNotEquals(instance, obj);

        obj = new Material();
        assertNotEquals(instance, obj);

        obj = new Material("Nickel", 297000d, 440d, 8908d, 2800d, 1453d, true);
        assertEquals(instance, obj);
    }

    /**
     * Test of compareTo method, of class Material.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");

        Material otherMaterial = new Material("Aluminium", 398000.0, 910.0, 2712.0, 2467.0, 660.0, true);

        assertTrue(instance.compareTo(otherMaterial) > 0);
    }

}
