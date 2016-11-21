/*
 * Package location for UI classes.
 */
package view;

import controller.AddMaterialController;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.Simulator;
import utils.DefaultInstantiator;

/**
 * The UI to add material.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class AddMaterialUI extends JDialog {

    /**
     * The confirm data button
     */
    private JButton confirmDataButton;

    /**
     * The cancel add material button
     */
    private JButton cancelAddMaterial;

    /**
     * The text field for name
     */
    private JTextField jtfName;
    
    /**
     * The text field for latent heat
     */
    private JTextField jtfLatentHeat;
    
    /**
     * The text field for heat capacity
     */
    private JTextField jtfHeatCapacity;
    
    /**
     * The text field for density
     */
    private JTextField jtfDensity;
    
    /**
     * The text field for vaporization temperature
     */
    private JTextField jtfVaporizationTemperature;
    
    /**
     * The text field for fusion temperature
     */
    private JTextField jtfFusionTemperature;
    
    /**
     * The text field for meltable
     */
    private JTextField jtfMeltable;

    /**
     * The add material controller
     */
    private AddMaterialController controller;

    /**
     * The parent frame
     */
    private SimulatorFrame parentFrame;

    /**
     * Window title.
     */
    private static final String WINDOW_TITLE = "ADD MATERIAL";

    /**
     * Padding border.
     */
    private final static EmptyBorder PADDING_BORDER = new EmptyBorder(10, 10, 10, 10);

    /**
     * Creates an instance of AddMaterialUI.
     *
     * @param simulator the simulator
     * @param parentFrame the parent frame
     */
    public AddMaterialUI(Simulator simulator, JFrame parentFrame) {
        super(parentFrame, WINDOW_TITLE, true);

        AddMaterialController controller = new AddMaterialController(simulator);

        createComponents();

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setResizable(true);
        setLocationRelativeTo(parentFrame);
        setVisible(true);
    }

    /**
     * Creates the UI components.
     */
    private void createComponents() {
        JPanel componentsPanel = new JPanel(new BorderLayout(10, 10));
        componentsPanel.add(addMaterialPanel(), BorderLayout.CENTER);
        componentsPanel.add(createButtonsPanel(), BorderLayout.SOUTH);
        componentsPanel.setBorder(PADDING_BORDER);
        add(componentsPanel);
    }

    /**
     * Creates the add material panel.
     *
     * @return the add material panel
     */
    private JPanel addMaterialPanel() {
        JPanel setMaterialPanel = new JPanel(new BorderLayout());
        setMaterialPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setMaterialPanel.add(labelsPanel(), BorderLayout.CENTER);
        setMaterialPanel.add(fieldsPanel(), BorderLayout.LINE_END);

        return setMaterialPanel;
    }

    private JPanel labelsPanel() {
        JPanel labelPanel = new JPanel(new GridLayout(0, 1));
        JTextArea jta1 = new JTextArea("Name");
        jta1.setEditable(false);
        JTextArea jta2 = new JTextArea("Latent Heat (J/Kg)");
        jta2.setEditable(false);
        JTextArea jta3 = new JTextArea("Heat Capacity (J/(KgºC)");
        jta3.setEditable(false);
        JTextArea jta4 = new JTextArea("Density (kg/m^3)");
        jta4.setEditable(false);
        JTextArea jta5 = new JTextArea("Vaporisation Temperature (ºC)");
        jta5.setEditable(false);
        JTextArea jta6 = new JTextArea("Fusion Temperature (ºC)");
        jta6.setEditable(false);
        JTextArea jta7 = new JTextArea("Meltable");
        jta7.setEditable(false);
        labelPanel.add(jta1);
        labelPanel.add(jta2);
        labelPanel.add(jta3);
        labelPanel.add(jta4);
        labelPanel.add(jta5);
        labelPanel.add(jta6);
        labelPanel.add(jta7);

        return labelPanel;
    }

    private JPanel fieldsPanel() {
        final int FIELD_WIDTH = 20;
        JPanel fieldPanel = new JPanel(new GridLayout(0, 1));
        jtfName = new JTextField(FIELD_WIDTH);
        jtfLatentHeat = new JTextField(FIELD_WIDTH);
        jtfHeatCapacity = new JTextField(FIELD_WIDTH);
        jtfDensity = new JTextField(FIELD_WIDTH);
        jtfVaporizationTemperature = new JTextField(FIELD_WIDTH);
        jtfFusionTemperature = new JTextField(FIELD_WIDTH);
        jtfMeltable = new JTextField(FIELD_WIDTH);
        fieldPanel.add(jtfName);
        fieldPanel.add(jtfLatentHeat);
        fieldPanel.add(jtfHeatCapacity);
        fieldPanel.add(jtfDensity);
        fieldPanel.add(jtfVaporizationTemperature);
        fieldPanel.add(jtfFusionTemperature);
        fieldPanel.add(jtfMeltable);

        return fieldPanel;
    }

    /**
     * Creates the buttons panel.
     *
     * @return buttons panel
     */
    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        buttonsPanel.add(createConfirmButton());
        buttonsPanel.add(createCancelButton());

        return buttonsPanel;
    }

    /**
     * Creates the cancel button.
     *
     * @return cancel button
     */
    private JButton createCancelButton() {
        this.cancelAddMaterial = new JButton("Cancel");

        this.cancelAddMaterial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        return cancelAddMaterial;
    }

    /**
     * Creates the confirm data button.
     *
     * @return confirm data button
     */
    private JButton createConfirmButton() {
        this.confirmDataButton = new JButton("Confirm");

        this.confirmDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addNewMaterial();
                controller.setMaterialData(jtfName.getText(), Double.parseDouble(jtfLatentHeat.getText()), Double.parseDouble(jtfHeatCapacity.getText()), Double.parseDouble(jtfDensity.getText()), Double.parseDouble(jtfVaporizationTemperature.getText()),
                        Double.parseDouble(jtfFusionTemperature.getText()), Boolean.parseBoolean(jtfMeltable.getText()));

                try {
                    String designation = jtfName.getText();
                    if (designation.length() < 1) {
                        throw new IllegalArgumentException("Empty field! . Try again.");
                    }

                    boolean addedMaterial;
                    addedMaterial = controller.registerMaterial();

                    if (!addedMaterial) {
                        throw new IllegalArgumentException("The material already exists. Insert a new one!");
                    } else {
                        JOptionPane.showMessageDialog(rootPane,
                                "Material added sucessfully!",
                                "Add material",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    dispose();

                } catch (IllegalArgumentException ex) {

                    JOptionPane.showMessageDialog(
                            parentFrame,
                            ex.getMessage(),
                            "Invalid designation",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        );
        return confirmDataButton;

    }


}
