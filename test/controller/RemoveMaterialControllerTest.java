/*
 * Package location for controller tests concepts.
 */
package controller;

import java.util.Set;
import model.Material;
import model.Simulator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.DefaultInstantiator;

/**
 * Tests the remove material controller class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class RemoveMaterialControllerTest {

    /**
     * The generate laser controller instance to be tested.
     */
    private RemoveMaterialController instance;

    /**
     * The simulator to be used on tests.
     */
    private Simulator simulator;

    @Before
    public void setUp() {
        simulator = DefaultInstantiator.createSimulator();
        instance = new RemoveMaterialController(simulator);
    }

    /**
     * Test of getMaterials method, of class RemoveMaterialController.
     */
    @Test
    public void testGetMaterials() {
        System.out.println("getMaterials");

        Set<Material> expResult = simulator.getMaterials();
        Set<Material> result = instance.getMaterials();

        assertEquals(expResult, result);
    }

    /**
     * Test of removeMaterial method, of class RemoveMaterialController.
     */
    @Test
    public void testRemoveMaterial() {
        System.out.println("removeMaterial");

        // material exists, so the method should return true
        Material material1 = new Material("Zinc", 113000.0, 390.0, 7135.0, 910.0, 419.5, true);
        boolean result1 = instance.removeMaterial(material1);
        boolean expResult1 = true;
        assertEquals(expResult1, result1);

        // material does not exist, so the method should return false
        Material material2 = new Material("test", 10000.0, 100.0, 1000.0, 100.0, 100.5, true);
        boolean result2 = instance.removeMaterial(material2);
        boolean expResult2 = false;
        assertEquals(expResult2, result2);
    }

}
