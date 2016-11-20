/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Set;
import model.Curiosity;
import model.Simulator;

/**
 *
 * @author Eric Jorge Schipper Ferreira do Amaral 1141570@isep.ipp.pt TurmaDN
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
