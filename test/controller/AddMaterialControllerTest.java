/*
 * Package location for controller tests concepts.
 */
package controller;

import model.Material;
import model.Simulator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.DefaultInstantiator;

/**
 * Tests the add material controller class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class AddMaterialControllerTest {

    public AddMaterialControllerTest() {
    }

    /**
     * The generate laser controller instance to be tested.
     */
    private AddMaterialController instance;

    /**
     * The simulator to be used on tests.
     */
    private Simulator simulator;

    @Before
    public void setUp() {
        simulator = DefaultInstantiator.createSimulator();
        instance = new AddMaterialController(simulator);
    }

    /**
     * Test of addNewMaterial method, of class AddMaterialController.
     */
    @Test
    public void testAddNewMaterial() {
        System.out.println("addNewMaterial");
        Material material = new Material("Acrylic", 10000.0, 100.0, 1000.0, 500.0, 100.0, true);
        instance.addNewMaterial();
        instance.setMaterialData("Acrylic", 10000.0, 100.0, 1000.0, 500.0, 100.0, true);
        instance.registerMaterial();

        //if it removes, it is because it added to the set of materials in the simulator
        RemoveMaterialController removeC = new RemoveMaterialController(simulator);
        boolean result = removeC.removeMaterial(material);
        boolean expResult = true;

        assertEquals(expResult, result);
    }

    /**
     * Test of setMaterialData method, of class AddMaterialController.
     */
    @Test
    public void testSetMaterialData() {
        System.out.println("setMaterialData");

        String name = "Acrylic";
        Double latentHeat = 10000.0;
        Double heatCapacity = 100.0;
        Double density = 1000.0;
        Double vaporizationTemperature = 500.0;
        Double fusionTemperature = 100.0;
        boolean meltable = true;
        boolean expResult = true;
        instance.addNewMaterial();
        boolean result = instance.setMaterialData(name, latentHeat, heatCapacity, density, vaporizationTemperature, fusionTemperature, meltable);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerMaterial method, of class AddMaterialController.
     */
    @Test
    public void testRegisterMaterial() {
        System.out.println("registerMaterial");

        instance.addNewMaterial();
        instance.setMaterialData("Acrylic", 10000.0, 100.0, 1000.0, 500.0, 100.0, true);
        boolean result = instance.registerMaterial();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of registerMaterial method, of class AddMaterialController.
     */
    @Test
    public void testRegisterMaterial1() {
        System.out.println("addNewMaterial");
        Material material = new Material("Acrylic", 10000.0, 100.0, 1000.0, 500.0, 100.0, true);
        instance.addNewMaterial();
        instance.setMaterialData("Acrylic", 10000.0, 100.0, 1000.0, 500.0, 100.0, true);
        instance.registerMaterial();

        //if it removes, it is because it registered in the set of materials in the simulator
        RemoveMaterialController removeC = new RemoveMaterialController(simulator);
        boolean result = removeC.removeMaterial(material);
        boolean expResult = true;

        assertEquals(expResult, result);
    }

}
