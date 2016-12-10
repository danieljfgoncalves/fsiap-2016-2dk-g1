/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.calculations;

import model.Material;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel Goncalves <1151452@isep.ipp.pt>
 */
public class MeltingCalculusTest {
    
    public MeltingCalculusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPower method, of class MeltingCalculus.
     */
    @Test
    public void testGetPower() {
        System.out.println("getPower");
        MeltingCalculus instance = null;
        Double expResult = null;
        Double result = instance.getPower();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPower method, of class MeltingCalculus.
     */
    @Test
    public void testSetPower() {
        System.out.println("setPower");
        Double power = null;
        MeltingCalculus instance = null;
        instance.setPower(power);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFocalPointArea method, of class MeltingCalculus.
     */
    @Test
    public void testGetFocalPointArea() {
        System.out.println("getFocalPointArea");
        MeltingCalculus instance = null;
        Double expResult = null;
        Double result = instance.getFocalPointArea();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFocalPointArea method, of class MeltingCalculus.
     */
    @Test
    public void testSetFocalPointArea() {
        System.out.println("setFocalPointArea");
        Double focalPointArea = null;
        MeltingCalculus instance = null;
        instance.setFocalPointArea(focalPointArea);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaterial method, of class MeltingCalculus.
     */
    @Test
    public void testGetMaterial() {
        System.out.println("getMaterial");
        MeltingCalculus instance = null;
        Material expResult = null;
        Material result = instance.getMaterial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaterial method, of class MeltingCalculus.
     */
    @Test
    public void testSetMaterial() {
        System.out.println("setMaterial");
        Material material = null;
        MeltingCalculus instance = null;
        instance.setMaterial(material);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeight method, of class MeltingCalculus.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        MeltingCalculus instance = null;
        Double expResult = null;
        Double result = instance.getHeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeight method, of class MeltingCalculus.
     */
    @Test
    public void testSetHeight() {
        System.out.println("setHeight");
        Double heigth = null;
        MeltingCalculus instance = null;
        instance.setHeight(heigth);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInicialTemp method, of class MeltingCalculus.
     */
    @Test
    public void testGetInicialTemp() {
        System.out.println("getInicialTemp");
        MeltingCalculus instance = null;
        Double expResult = null;
        Double result = instance.getInicialTemp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInicialTemp method, of class MeltingCalculus.
     */
    @Test
    public void testSetInicialTemp() {
        System.out.println("setInicialTemp");
        Double inicialTemp = null;
        MeltingCalculus instance = null;
        instance.setInicialTemp(inicialTemp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculate method, of class MeltingCalculus.
     */
    @Test
    public void testCalculate() {
        System.out.println("calculate");
        MeltingCalculus instance = null;
        double expResult = 0.0;
        double result = instance.calculate();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
