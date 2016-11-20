/*
 * Package location for Model concepts.
 */
package controller;

import java.util.Set;
import model.Curiosity;
import model.Simulator;

/**
 * The controller to show curiosities.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class ShowCuriositiesController {

    /**
     * The simulator with all data.
     */
    private final Simulator simulator;

    /**
     * Creates a show Curiosities Controller.
     *
     * @param simulator the simulator with all data
     */
    public ShowCuriositiesController(Simulator simulator) {
        this.simulator = simulator;
    }

    /**
     * Gets the curiosities.
     *
     * @return curiosities
     */
    public Set<Curiosity> getCuriosities() {
        return this.simulator.getCuriosities();
    }
}
