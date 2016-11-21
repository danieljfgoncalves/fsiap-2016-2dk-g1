/*
 * Package location for UI classes.
 */
package view;

import java.awt.Frame;
import model.Simulator;
import utils.DefaultInstantiator;
import utils.SimulatorFileLoader;

/**
 * The main class to launch the application.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class Main {

    /**
     * private constructor hides the public one.
     */
    private Main() {
    }

    /**
     * The main method to run the application.
     *
     * @param args arguments from command line
     */
    public static void main(String[] args) {

        Simulator simulator = SimulatorFileLoader.read(SimulatorFileLoader.DEFAULT_FILE_NAME);
        if (simulator == null) {
            simulator = DefaultInstantiator.createSimulator();
        }

        Frame simulatorFrame = new SimulatorFrame(simulator);
        simulatorFrame.setVisible(true);
    }
}
