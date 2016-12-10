/*
 * Package location for UI classes.
 */
package view;

import controller.CalculateLaserCutController;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.Experience;
import view.components.DoubleJTextField;
import view.components.ImagePanel;
import view.components.ResultTableModel;

/**
 * Represents a panel with the laser cut results.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class CalculateLaserCutPanel extends JPanel {

    /**
     * The simulator frame (Parent Frame).
     */
    private final SimulatorFrame simulatorFrame;

    /**
     * The controller to calculate the laser cut.
     */
    private CalculateLaserCutController controller;

    /**
     * Effective Power Label.
     */
    JLabel powLabel;

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

    /**
     * Creates an instance of Calculate Laser Cut Panel.
     *
     * @param simulatorFrame parent frame
     */
    public CalculateLaserCutPanel(SimulatorFrame simulatorFrame) {
        super();
        this.simulatorFrame = simulatorFrame;
        this.controller = null;

        createComponents();
        setVisible(false);
    }

    /**
     * Sets the controller.
     *
     * @param controller the controller to set
     */
    public void setController(CalculateLaserCutController controller) {
        this.controller = controller;
        setValues();
        setVisible(true);
    }

    /**
     * Obtains the current experience.
     *
     * @return the current experience
     */
    public Experience getExperience() {

        if (this.controller == null) {
            return null;
        }
        return this.controller.getExperience();
    }

    /**
     * Creates the UI components.
     */
    private void createComponents() {
        setLayout(new BorderLayout(20, 0));

        add(new ImagePanel(), BorderLayout.CENTER);
        add(createDataPanel(), BorderLayout.EAST);
    }

    /**
     * Creates the panel where the data.
     *
     * @return the data panel
     */
    private JPanel createDataPanel() {

        JPanel dataPanel = new JPanel(new BorderLayout(10, 10));

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

        JPanel varPanel = new JPanel(new BorderLayout(10, 10));

        varPanel.add(createPowerPanel(), BorderLayout.WEST);
        varPanel.add(createKeyholeTimePanel(), BorderLayout.EAST);

        return varPanel;
    }

    /**
     * Creates a panel with power field.
     *
     * @return
     */
    private JPanel createPowerPanel() {

        JPanel powPanel = new JPanel(new BorderLayout());

        // TODO: Label Power
        JLabel titleLabel = new JLabel("Power:", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        powLabel = new JLabel("", JLabel.CENTER);
        powLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel labelsPanel = new JPanel();
        GroupLayout layout = new GroupLayout(labelsPanel);
        labelsPanel.setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        // Align horizontally
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(titleLabel)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(powLabel)
                )
        );
        // Align vertically
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(titleLabel)
                        .addComponent(powLabel))
        );

        powPanel.add(labelsPanel, BorderLayout.NORTH);

        this.powerSlider = new JSlider(0, 100, 100);
        powerSlider.setFont(new Font("Arial", Font.BOLD, 14));
        this.powerSlider.setSnapToTicks(true);

        this.powerSlider.setMajorTickSpacing(25);
        this.powerSlider.setMinorTickSpacing(5);
        this.powerSlider.setPaintTicks(true);
        this.powerSlider.setPaintLabels(true);

        powerSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (!powerSlider.getValueIsAdjusting()) {

                    Double effectivePower = controller.getExperience().getLaser().getMaxPower()
                            * ((float) powerSlider.getValue() / 100);

                    powLabel.setText(String.format("  %d W", effectivePower.intValue()));
                    updateCalculus();
                }
            }
        });
        powPanel.add(this.powerSlider, BorderLayout.CENTER);

        return powPanel;
    }

    /**
     * Creates a panel with keyhole time limit field.
     *
     * @return
     */
    private JPanel createKeyholeTimePanel() {

        JPanel cutPanel = new JPanel(new BorderLayout());

        JLabel cutLabel = new JLabel("Keyhole Time Limit:", JLabel.CENTER);
        cutLabel.setFont(new Font("Arial", Font.BOLD, 16));
        cutPanel.add(cutLabel, BorderLayout.NORTH);

        this.cutTimeLimitTxt = new DoubleJTextField("", 6);
        cutTimeLimitTxt.setFont(new Font("Arial", Font.BOLD, 16));
        this.cutTimeLimitTxt.addFocusListener(new FocusListener() {

            public void focusGained(FocusEvent e) {
                cutTimeLimitTxt.setText("");
            }

            public void focusLost(FocusEvent e) {
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

        this.resultsTable = new JTable(new ResultTableModel(new String[9][2]));
        JScrollPane scroll = new JScrollPane(this.resultsTable);
        panel.add(scroll);

        return panel;
    }

    /**
     * Sets the values of the variables fields.
     */
    private void setValues() {

        Double effectivePower = controller.getExperience().getLaser().getMaxPower()
                * ((float) powerSlider.getValue() / 100);
        this.powLabel.setText(String.format("  %d W", effectivePower.intValue()));

        String txt = String.format("%.2f", this.controller.getExperience().getCuttingTimeLimit());
        this.cutTimeLimitTxt.setPredefiendText(txt);
        this.resultsTable.setModel(new ResultTableModel(this.controller.getResults()));
    }

    /**
     * Updates the calculus.
     */
    private void updateCalculus() {

        this.controller.updateExperience((float) this.powerSlider.getValue() / 100, this.cutTimeLimitTxt.getDouble());
        this.resultsTable.setModel(new ResultTableModel(this.controller.getResults()));
    }
}
