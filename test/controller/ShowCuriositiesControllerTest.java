/*
 * Package location for controller tests concepts.
 */
package controller;

import java.util.HashSet;
import java.util.Set;
import model.Curiosity;
import model.Simulator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.DefaultInstantiator;

/**
 * Tests the show curiosities controller class.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class ShowCuriositiesControllerTest {

    public ShowCuriositiesControllerTest() {
    }

    /**
     * The show curiosities laser controller instance to be tested.
     */
    private ShowCuriositiesController instance;

    /**
     * The simulator to be used on tests.
     */
    private Simulator simulator;

    @Before
    public void setUp() {
        simulator = DefaultInstantiator.createSimulator();
        instance = new ShowCuriositiesController(simulator);
    }

    /**
     * Test of getCuriosities method, of class ShowCuriositiesController.
     */
    @Test
    public void testGetCuriosities() {
         System.out.println("getCuriosities");
        
        Set curiosities = new HashSet<Curiosity>();
        curiosities.add(new Curiosity("Curiosity1"));
        curiosities.add(new Curiosity("Curiosity2"));
        curiosities.add(new Curiosity("Curiosity3"));
        
        simulator.setCuriosities(curiosities);
 
        Set<Curiosity> expResult = curiosities;
        Set<Curiosity> result = instance.getCuriosities();
        assertEquals(expResult, result);
    }
}
