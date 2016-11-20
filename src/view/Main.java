/*
 * Package location for UI classes.
 */
package view;

import java.awt.Frame;
import java.util.HashSet;
import java.util.Set;
import model.Gas;
import model.Material;
import model.Simulator;
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

    public static void main(String[] args) {

        Simulator simulator = SimulatorFileLoader.read(SimulatorFileLoader.DEFAULT_FILE_NAME);
        if (simulator == null) {
            simulator = getMokcupDataForTesting();
        }

        Frame simulatorFrame = new SimulatorFrame(simulator);
        simulatorFrame.setVisible(true);
    }

    private static Simulator getMokcupDataForTesting() {
        Gas g1 = new Gas("gas1", 200e-9, 12000e-9);
        Gas g2 = new Gas("gas2", 800e-9, 30000e-9);
        Set<Gas> gases = new HashSet<>();
        Material m1 = new Material("Wood", 1e100, 1e100, 1e100, 1e100, 1e100, true);
        Material m2 = new Material("Iron", 1e200, 1e200, 1e200, 1e200, 1e200, false);
        Set<Material> materials = new HashSet<>();
        materials.add(m1);
        materials.add(m2);
        gases.add(g1);
        gases.add(g2);
        Simulator simulator = new Simulator();
        simulator.setGases(gases);
        simulator.setMaterials(materials);
        return simulator;
    }
}

