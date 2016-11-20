/*
 * Package location for UI classes.
 */
package view;

import controller.CalculateLaserCutController;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import view.components.DoubleJTextField;

/**
 * Represents a panel with the laser cut results.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class CalculateLaserCutPanel extends JPanel {

    private static final ImageIcon LASER_IMG
            = new ImageIcon(CalculateLaserCutPanel.class.getResource("/view/components/laserImage.jpg"));

    /**
     * The controller to calculate the laser cut.
     */
    private CalculateLaserCutController controller;

    /**
     * Slider component for the power.
     */
    private JSlider powerSlider;

    /**
     * TextField component for the cutting time limit.
     */
    private DoubleJTextField cutTimeLimitTxt;

    /**
     * Table component for the results.
     */
    private JTable resultsTable;

    private final static String[] RESULT_COLUMN_NAMES = {"Results", "Values"};

    /**
     * Creates an instance of Calculate Laser Cut Panel.
     *
     */
    public CalculateLaserCutPanel() {
        super();
        this.controller = null;
    }

    /**
     * Sets the controller.
     *
     * @param controller the controller to set
     */
    public void setController(CalculateLaserCutController controller) {
        this.controller = controller;
        createComponents();
    }

    /**
     * Creates the UI components.
     */
    private void createComponents() {
        setLayout(new BorderLayout());

        add(createImagePanel(), BorderLayout.CENTER);
        add(createDataPanel(), BorderLayout.WEST);
    }

    /**
     * Creates a panel with the laser image.
     *
     * @return the image panel
     */
    private JPanel createImagePanel() {

        JPanel imagePanel = new JPanel(new GridBagLayout());

        JLabel img = new JLabel(LASER_IMG, JLabel.CENTER);
        imagePanel.add(img);

        return imagePanel;
    }

    /**
     * Creates the panel where the data.
     *
     * @return the data panel
     */
    private JPanel createDataPanel() {

        JPanel dataPanel = new JPanel(new BorderLayout());

        dataPanel.add(createVariablesPanel(), BorderLayout.NORTH);
        dataPanel.add(createResultsPanel(), BorderLayout.CENTER);

        return dataPanel;
    }

    /**
     * Creates a panel with the variables fields.
     *
     * @return variables panel
     */
    private JPanel createVariablesPanel() {

        JPanel varPanel = new JPanel(new BorderLayout());

        varPanel.add(createPowerPanel(), BorderLayout.EAST);
        varPanel.add(createCuttingTimePanel(), BorderLayout.WEST);

        return varPanel;
    }

    /**
     * Creates a panel with power field.
     *
     * @return
     */
    private JPanel createPowerPanel() {

        JPanel powPanel = new JPanel(new BorderLayout());

        JLabel powerLabel = new JLabel("Power:", JLabel.RIGHT);
        powPanel.add(powerLabel, BorderLayout.NORTH);

        this.powerSlider = new JSlider(0, 100, 100);
        this.powerSlider.setSnapToTicks(true);

        powerSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateCalculus();
            }
        });
        powPanel.add(this.powerSlider, BorderLayout.CENTER);

        return powPanel;
    }

    /**
     * Creates a panel with cutting time limit field.
     *
     * @return
     */
    private JPanel createCuttingTimePanel() {

        JPanel cutPanel = new JPanel(new BorderLayout());

        JLabel cutLabel = new JLabel("Cutting Time Limit:", JLabel.RIGHT);
        cutPanel.add(cutLabel, BorderLayout.NORTH);

        String limitStr = String.format("%.2d", this.controller.getExperience().getCuttingTimeLimit());
        this.cutTimeLimitTxt = new DoubleJTextField(limitStr, 6);
        this.cutTimeLimitTxt.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updateCalculus();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCalculus();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCalculus();
            }
        });

        cutPanel.add(this.cutTimeLimitTxt, BorderLayout.CENTER);

        return cutPanel;
    }

    /**
     * Creates the results panel.
     *
     * @return the results panel
     */
    private JPanel createResultsPanel() {

        JPanel panel = new JPanel(new GridBagLayout());

        this.resultsTable = new JTable(this.controller.getResults(), RESULT_COLUMN_NAMES);
        JScrollPane scroll = new JScrollPane(this.resultsTable);
        panel.add(scroll);

        return panel;
    }

    /**
     * Updates the calculus.
     */
    private void updateCalculus() {

        this.controller.updateExperience((float) this.powerSlider.getValue() / 100, this.cutTimeLimitTxt.getDouble());
        this.resultsTable = new JTable(this.controller.getResults(), RESULT_COLUMN_NAMES);
    }
}
