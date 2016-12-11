/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.calculations;

import model.Material;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel Goncalves <1151452@isep.ipp.pt>
 */
public class MeltingCalculusTest {
    
    /**
     * test Material
     */
    private Material testMaterial;

    /**
     * vaporisation calculus instance
     */
    private MeltingCalculus calculus;
    
    public MeltingCalculusTest() {
        
        testMaterial = new Material("Copper", 205000.0, 390.0, 8940.0, 2575.0, 1084.0, true);
        calculus = new MeltingCalculus(199.90, 7.85E-7, testMaterial, 20E-3);
    }

    /**
     * Test of getPower method, of class MeltingCalculus.
     */
    @Test
    public void testGetPower() {
        System.out.println("getPower");
        Double expResult = 199.90;
        Double result = calculus.getPower();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of setPower method, of class MeltingCalculus.
     */
    @Test
    public void testSetPower() {
        System.out.println("setPower");
        Double power = 200.0;
        calculus.setPower(power);
        assertEquals(power, calculus.getPower());
    }

    /**
     * Test of getFocalPointArea method, of class MeltingCalculus.
     */
    @Test
    public void testGetFocalPointArea() {
        System.out.println("getFocalPointArea");
        Double expResult = 7.85E-7;
        Double result = calculus.getFocalPointArea();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFocalPointArea method, of class MeltingCalculus.
     */
    @Test
    public void testSetFocalPointArea() {
        System.out.println("setFocalPointArea");
        Double focalPointArea = 1.0;
        calculus.setFocalPointArea(focalPointArea);
        assertEquals(focalPointArea, calculus.getFocalPointArea());
    }

    /**
     * Test of getMaterial method, of class MeltingCalculus.
     */
    @Test
    public void testGetMaterial() {
        System.out.println("getMaterial");
        Material expResult = testMaterial;
        Material result = calculus.getMaterial();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMaterial method, of class MeltingCalculus.
     */
    @Test
    public void testSetMaterial() {
        System.out.println("setMaterial");
        Material material = new Material();
        calculus.setMaterial(material);
        assertEquals(material, calculus.getMaterial());
    }

    /**
     * Test of getHeight method, of class MeltingCalculus.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        Double expResult = 20E-3;
        Double result = calculus.getHeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHeight method, of class MeltingCalculus.
     */
    @Test
    public void testSetHeight() {
        System.out.println("setHeight");
        Double heigth = 1.0;
        calculus.setHeight(heigth);
        assertEquals(heigth, calculus.getHeight());
    }

    /**
     * Test of getInicialTemp method, of class MeltingCalculus.
     */
    @Test
    public void testGetInicialTemp() {
        System.out.println("getInicialTemp");
        Double expResult = 20.0;
        Double result = calculus.getInicialTemp();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInicialTemp method, of class MeltingCalculus.
     */
    @Test
    public void testSetInicialTemp() {
        System.out.println("setInicialTemp");
        Double inicialTemp = 30.0;
        calculus.setInicialTemp(inicialTemp);
        assertEquals(inicialTemp, calculus.getInicialTemp());
    }

    /**
     * Test of calculate method, of class MeltingCalculus.
     */
    @Test
    public void testCalculate() {
        System.out.println("calculate");
        double expResult = 0.05;
        double result = calculus.calculate();
        assertEquals(expResult, result, 0.01);
    }
    
}
