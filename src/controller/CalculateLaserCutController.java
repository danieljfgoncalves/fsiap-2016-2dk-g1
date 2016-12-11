/*
 * Package location for Model concepts.
 */
package controller;

import model.Experience;
import model.Laser;

/**
 * The controller to calculate the laser cut.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class CalculateLaserCutController {
    
    /**
     * The experience to manipulate.
     */
    private Experience experience;

    /**
     * Constructs a calculate laser cut controller.
     *
     * @param simulator the simulator with all data
     */
    public CalculateLaserCutController(Laser laser) {

        this.experience = new Experience(laser);
        this.experience.calculatePenetrationVelocity();
    }

    /**
     * Obtains the experience to manipulate.
     * @return the experience
     */
    public Experience getExperience() {
        return experience;
    }

    /**
     * Updates the experience.
     *
     * @param factor new factor value
     * @param cuttingTime new cutting time value.
     */
    public void updateExperience(Float factor, Double cuttingTime) {

        this.getExperience().setCuttingTimeLimit(cuttingTime);
        this.getExperience().calculatePenetrationVelocity(factor);
    }

    /**
     * Obtains the results of the experience.
     *
     * @return the results of the experience
     */
    public String[][] getResults() {

        return this.getExperience().generateResults();
    }

}
