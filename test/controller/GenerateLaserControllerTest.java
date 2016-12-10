/*
 * Package location for controller tests concepts.
 */
package controller;

import java.util.HashSet;
import java.util.Set;
import model.Gas;
import model.Material;
import model.Simulator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.DefaultInstantiator;

/**
 * Tests the generate laser controller class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class GenerateLaserControllerTest {

    /**
     * The generate laser controller instance to be tested.
     */
    private GenerateLaserController instance;

    /**
     * The simulator to be used on tests.
     */
    private Simulator simulator;

    @Before
    public void setUp() {
        simulator = DefaultInstantiator.createSimulator();
        instance = new GenerateLaserController(simulator);
    }

    /**
     * Test of getGasesByWavelength method, of class GenerateLaserController.
     */
    @Test
    public void testGetGasesByWavelength() {
        System.out.println("getGasesByWavelength");

        Set<Gas> expResult = new HashSet<>();
        expResult.add(new Gas("CO2", 9200E-9, 11400E-9));
        expResult.add(new Gas("Pb salts", 3300E-9, 27000E-9));

        instance.setWavelength(10600E-9);
        Set<Gas> result = instance.getGasesByWavelength();

        assertEquals(expResult, result);
    }

    /**
     * Test of getMaterials method, of class GenerateLaserController.
     */
    @Test
    public void testGetMaterials() {
        System.out.println("getMaterials");

        Set<Material> expResult = simulator.getMaterials();
        Set<Material> result = instance.getMaterials();

        assertEquals(expResult, result);
    }

    /**
     * Test of getMaxPower method, of class GenerateLaserController.
     */
    @Test
    public void testGetMaxPower() {
        System.out.println("getMaxPower");

        instance.setWavelength(10600E-9);
        instance.setGas(new Gas("CO2", 9200E-9, 11400E-9));
        instance.setFocalPointDiameter(4E-3);
        instance.setMaterial(new Material("Iron", 272000.0, 450.0, 7850.0, 2870.0, 1149.0, true));
        instance.setMaterialThickness(8E-3);
        instance.newLaser();
        instance.initiateCut();

        Double expResult = 320d;
        Double result = instance.getMaxPower();

        assertEquals(expResult, result);
    }

}
