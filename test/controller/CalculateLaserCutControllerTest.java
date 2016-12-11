/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Experience;
import model.Gas;
import model.Laser;
import model.Material;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel Goncalves <1151452@isep.ipp.pt>
 */
public class CalculateLaserCutControllerTest {

    /**
     * Controller instance
     */
    private CalculateLaserCutController controller;

    /**
     * Laser instance
     */
    private Laser testLaser;

    public CalculateLaserCutControllerTest() {

        testLaser = new Laser(10600e-9, new Gas("CO2", 9200E-9, 11400E-9), 2e-3,
                new Material("Gold", 63000.0, 130.0, 19320.0, 2800.0, 1063.0, true), 4e-3);
        controller = new CalculateLaserCutController(testLaser);
    }

    /**
     * Test of getExperience method, of class CalculateLaserCutController.
     */
    @Test
    public void testGetExperience() {
        System.out.println("getExperience");
        Experience expResult = new Experience(testLaser);
        Experience result = controller.getExperience();
        assertEquals(expResult, result);
    }

    /**
     * Test of updateExperience method, of class CalculateLaserCutController.
     */
    @Test
    public void testUpdateExperience() {
        System.out.println("updateExperience");
        Float factor = 0.5f;
        Double cuttingTime = 30.0;
        Experience testExperience = new Experience(testLaser);
        testExperience.calculatePenetrationVelocity(factor);
        testExperience.setCuttingSpeed(cuttingTime);

        controller.updateExperience(factor, cuttingTime);

        assertEquals(testExperience, controller.getExperience());
    }

    /**
     * Test of getResults method, of class CalculateLaserCutController.
     */
    @Test
    public void testGetResults() {
        System.out.println("getResults");
        String[][] expResult = {{"Gás do laser", "CO2"},
        {"Poder do laser", "8,0000E+01 W"},
        {"Área afectada", "3,1416E+00 mm2"},
        {"Material", "Gold"},
        {"Espessura do material", "4,0000E+00 mm"},
        {"Método de corte", "Corte por fusão"},
        {"Velocidade de penetração", "6,6371E+00 mm/s"},
        {"Tempo para cortar", "0,60 s"},
        {"Corta?", "Sim"},
        {"Velocidade do corte", "2,6064E+00 mm/s"}};
        String[][] result = controller.getResults();
        assertArrayEquals(expResult, result);
    }

}
