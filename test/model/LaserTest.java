/*
 * Package location for Application model concepts.
 */
package model;

import model.calculations.Calculable;
import model.calculations.MeltingCalculus;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests of laser class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class LaserTest {
    
    /**
     * Instance to be tested
     */
    private Laser instance;
    
    @Before
    public void setUp() {
        instance = new Laser(10600e-9, new Gas("CO2", 9200E-9, 11400E-9), 2e-3,
                new Material("Gold", 63000.0, 130.0, 19320.0, 2800.0, 1063.0, true), 4e-3);
    }

    /**
     * Test of getWavelength method, of class Laser.
     */
    @Test
    public void testGetWavelength() {
        System.out.println("getWavelength");
        
        Double expResult = 10600e-9;
        Double result = instance.getWavelength();
        
        assertEquals(expResult, result, 0.01d);
    }

    /**
     * Test of setWavelength method, of class Laser.
     */
    @Test
    public void testSetWavelength() {
        System.out.println("setWavelength");
        
        Double wavelength = 10000e-9;
        instance.setWavelength(wavelength);
        
        assertEquals(instance.getWavelength(), wavelength, 0.01d);
    }

    /**
     * Test of getGas method, of class Laser.
     */
    @Test
    public void testGetGas() {
        System.out.println("getGas");
        
        Gas expResult = new Gas("CO2", 9200E-9, 11400E-9);
        Gas result = instance.getGas();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setGas method, of class Laser.
     */
    @Test
    public void testSetGas() {
        System.out.println("setGas");
        
        Gas gas = new Gas("abc", 1d, 10d);
        instance.setGas(gas);
        
        assertEquals(instance.getGas(), gas);
    }

    /**
     * Test of getMaterial method, of class Laser.
     */
    @Test
    public void testGetMaterial() {
        System.out.println("getMaterial");
        
        Material expResult = new Material("Gold", 63000.0, 130.0, 19320.0, 2800.0, 1063.0, true);
        Material result = instance.getMaterial();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setMaterial method, of class Laser.
     */
    @Test
    public void testSetMaterial() {
        System.out.println("setMaterial");
        
        Material material = new Material();
        instance.setMaterial(material);
        
        assertEquals(instance.getMaterial(), material);
    }

    /**
     * Test of getMaterialThickness method, of class Laser.
     */
    @Test
    public void testGetMaterialThickness() {
        System.out.println("getMaterialThickness");
        
        Double expResult = 4e-3;
        Double result = instance.getMaterialThickness();
        
        assertEquals(expResult, result, 0.01d);
    }

    /**
     * Test of setMaterialThickness method, of class Laser.
     */
    @Test
    public void testSetMaterialThickness() {
        System.out.println("setMaterialThickness");
        
        Double materialThickness = 2e-3;
        instance.setMaterialThickness(materialThickness);
        
        assertEquals(instance.getMaterialThickness(), materialThickness, 0.01d);
    }

    /**
     * Test of getBeamDiameter method, of class Laser.
     */
    @Test
    public void testGetBeamDiameter() {
        System.out.println("getBeamDiameter");
        
        Double expResult = 2e-3;
        Double result = instance.getBeamDiameter();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setBeamDiameter method, of class Laser.
     */
    @Test
    public void testSetBeamDiameter() {
        System.out.println("setBeamDiameter");
        
        Double beamDiameter = 6e-3;
        instance.setBeamDiameter(beamDiameter);
        
        assertEquals(instance.getBeamDiameter(), beamDiameter, 0.01d);
    }

    /**
     * Test of getFocalPointArea method, of class Laser.
     */
    @Test
    public void testGetFocalPointArea() {
        System.out.println("getFocalPointArea");
        
        Double expResult = 3.14e-6d;
        Double result = instance.getFocalPointArea();
        
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of setFocalPointArea method, of class Laser.
     */
    @Test
    public void testSetFocalPointArea() {
        System.out.println("setFocalPointArea");
        
        Double focalPointArea = 4.25e-6d;
        instance.setFocalPointArea(focalPointArea);
        
        assertEquals(instance.getFocalPointArea(), focalPointArea, 0.01d);
    }

    /**
     * Test of getMaxPower method, of class Laser.
     */
    @Test
    public void testGetMaxPower() {
        System.out.println("getMaxPower");
        
        Double expResult = 80d;
        Double result = instance.getMaxPower();
        
        assertEquals(expResult, result, 0.01d);
    }

    /**
     * Test of getFactor method, of class Laser.
     */
    @Test
    public void testGetFactor() {
        System.out.println("getFactor");
        
        Float expResult = 1f;
        Float result = instance.getFactor();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setFactor method, of class Laser.
     */
    @Test
    public void testSetFactor() {
        System.out.println("setFactor");
        
        Float factor = 3f;
        instance.setFactor(factor);
        
        assertEquals(instance.getFactor(), factor, 0.01);
    }

    /**
     * Test of equals method, of class Laser.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        
        Object obj = null;
        assertFalse(instance.equals(obj));
        
        obj = new Laser(1d, new Gas("a", 1d, 1d), 1d, new Material(), 1d);
        assertFalse(instance.equals(obj));
        
        obj = new Laser(10600e-9, new Gas("CO2", 9200E-9, 11400E-9), 2e-3,
                new Material("Gold", 63000.0, 130.0, 19320.0, 2800.0, 1063.0, true), 4e-3);
        assertTrue(instance.equals(obj));
    }
    
}
