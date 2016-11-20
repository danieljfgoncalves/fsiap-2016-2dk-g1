/*
 * Package location for UI classes.
 */
package view;

import controller.CalculateLaserCutController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
     * Panel that represents the calculate laser cut.
     */
    private CalculateLaserCutPanel calculateCutPanel;

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
        CustomMenuBar mb = new CustomMenuBar(this, this.simulator);
        setJMenuBar(mb);

        // calls exit method from menu bar to save simulator in binary file
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mb.exit();
            }
        });

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

        add(new GenerateLaserPanel(this, simulator), BorderLayout.WEST);
        
        this.calculateCutPanel = new CalculateLaserCutPanel(this);
        add(this.calculateCutPanel, BorderLayout.CENTER);
    }

    /**
     * Initiate the laser cut panel.
     *
     * @param calculateLaserCutController calculate laser cut controller
     */
    public void initiateCutPanel(CalculateLaserCutController calculateLaserCutController) {
        
        calculateCutPanel.setController(calculateLaserCutController);
    }
}
