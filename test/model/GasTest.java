/*
 * Package location for model tests concepts.
 */
package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests of gas class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class GasTest {

    /**
     * The instance to be tested.
     */
    private Gas instance;

    @Before
    public void setUp() {
        instance = new Gas("CO2", 9200E-9, 11400E-9);
    }

    /**
     * Test of getName method, of class Gas.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");

        String expResult = "CO2";
        String result = instance.getName();

        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Gas.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");

        String name = "CO2 gas";

        instance.setName(name);

        assertEquals(instance.getName(), name);
    }

    /**
     * Test of getMaxWavelength method, of class Gas.
     */
    @Test
    public void testGetMaxWavelength() {
        System.out.println("getMaxWavelength");

        Double expResult = 11400E-9;
        Double result = instance.getMaxWavelength();

        assertEquals(expResult, result);
    }

    /**
     * Test of setMaxWavelength method, of class Gas.
     */
    @Test
    public void testSetMaxWavelength() {
        System.out.println("setMaxWavelength");

        Double maxWavelength = 12500E-9;

        instance.setMaxWavelength(maxWavelength);

        assertEquals(instance.getMaxWavelength(), maxWavelength);
    }

    /**
     * Test of getMinWavelength method, of class Gas.
     */
    @Test
    public void testGetMinWavelength() {
        System.out.println("getMinWavelength");

        Double expResult = 9200E-9;
        Double result = instance.getMinWavelength();

        assertEquals(expResult, result);
    }

    /**
     * Test of setMinWavelength method, of class Gas.
     */
    @Test
    public void testSetMinWavelength() {
        System.out.println("setMinWavelength");

        Double minWavelength = 8000E-9;

        instance.setMinWavelength(minWavelength);

        assertEquals(instance.getMinWavelength(), minWavelength);
    }

    /**
     * Test of isCompatible method, of class Gas.
     */
    @Test
    public void testIsCompatible() {
        System.out.println("isCompatible");

        Double wavelength = 7000E-9;

        assertFalse(instance.isCompatible(wavelength));

        wavelength = 10600E-9;

        assertTrue(instance.isCompatible(wavelength));
    }

    /**
     * Test of equals method, of class Gas.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        Object obj = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);

        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Gas.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");

        Gas otherGas = new Gas("Alexandrite", 700E-9, 800E-9);

        assertTrue(instance.compareTo(otherGas) > 0);
    }

}
