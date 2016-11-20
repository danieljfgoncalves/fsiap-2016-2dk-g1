/*
 * Package location for UI classes.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Simulator;

/**
 * Represents the main frame for the simulator.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class SimulatorFrame extends JFrame {

    /**
     * The simulator with all data.
     */
    private final Simulator simulator;

    /**
     * Title for the frame.
     */
    private static final String WINDOW_TITLE = "Simulador de corte de laser";

    /**
     * Window's dimension.
     */
    private static final Dimension WINDOW_DIMENSION = new Dimension(1280, 720);

    /**
     * Creates an instance of SimulatorFrame;
     *
     * @param simulator the simulator with all data
     */
    public SimulatorFrame(Simulator simulator) {

        super(WINDOW_TITLE);

        this.simulator = simulator;

        createComponents();
        // TODO set the menu bar
        // TODO save on binary file on close

        pack();
        setSize(WINDOW_DIMENSION);
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setLocationRelativeTo(null);
    }

    /**
     * Creates the window components.
     */
    private void createComponents() {
        setLayout(new BorderLayout(10, 10));
        
        JPanel laserCutPanelPlaceholder = new JPanel();
        laserCutPanelPlaceholder.setBackground(Color.GRAY);
        
        add(new GenerateLaserPanel(simulator), BorderLayout.WEST);
        add(laserCutPanelPlaceholder, BorderLayout.CENTER);
    }
}
