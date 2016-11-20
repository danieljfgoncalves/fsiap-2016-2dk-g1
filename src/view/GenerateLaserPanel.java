/*
 * Package location for UI classes.
 */
package view;

import controller.GenerateLaserController;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.Gas;
import model.Material;
import model.Simulator;
import view.components.DoubleJTextField;

/**
 * Represents a panel with the fields to generate the laser.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class GenerateLaserPanel extends JPanel {

    /**
     * Inner class to render the gas.
     */
    private static class GasRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            value = ((Gas) value).getName();
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    }

    /**
     * Inner class to render the gas.
     */
    private static class MaterialRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            value = ((Material) value).getName();
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    }

    /**
     * The simulator with all data.
     */
    private final Simulator simulator;

    /**
     * The controller to generate the laser.
     */
    private final GenerateLaserController controller;

    /**
     * The selected wavelength.
     */
    private Double wavelength;

    /**
     * The gases.
     */
    private Set<Gas> gases;

    /**
     * The selected gas.
     */
    private Gas gas;

    /**
     * The combo box for gases.
     */
    private JComboBox<Gas> gasesComboBox;

    /**
     * The selected focal point diameter.
     */
    private Double focalPointDiameter;

    /**
     * The materials.
     */
    private Set<Material> materials;

    /**
     * The selected material.
     */
    private Material material;

    /**
     * The sselected material thickness.
     */
    private Double materialThickness;

    /**
     * The materialThicknessTextField.
     */
    private JTextField materialThicknessTextField;

    /**
     * The button to calculate maximum power.
     */
    private JButton calculateMaxPowerButton;

    /**
     * The max power.
     */
    private Double maxPower;

    /**
     * The label with maximum power.
     */
    private JLabel maxPowerLabel;

    /**
     * Creates an instance of GenerateLaserPanel.
     *
     * @param simulator the simulator with all data
     */
    public GenerateLaserPanel(Simulator simulator) {
        super();

        this.simulator = simulator;
        this.controller = new GenerateLaserController(simulator);
        setDefaultValues();

        createComponents();
    }

    /**
     * Creates the UI components.
     */
    private void createComponents() {
        setLayout(new GridLayout(7, 1, 0, 10));

        add(createWavelengthPanel());
        add(createGasPanel());
        add(createFocalPointPanel());
        add(createMaterialPanel());
        add(createMaterialThickness());
        add(createCalculateButtonPanel());
        add(createMaxPowerPanel());
    }

    /**
     * Creates the panel for wavelength.
     *
     * @return wavelength panel
     */
    private JPanel createWavelengthPanel() {
        JPanel wavelengthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel wavelengthLabel = new JLabel(String.format("Comprimento de onda:   %-5.0f nm", wavelength));

        JSlider wavelengthSlider = new JSlider(200, 27000, 10600);
        wavelengthSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                wavelength = (double) wavelengthSlider.getValue();
                controller.setWavelength(wavelength * 1e-9);
                wavelengthLabel.setText(String.format("Comprimento de onda:   %-5.0f nm", wavelength));
                gases = controller.getGasesByWavelength();
                updateGasComboBox();
            }
        });

        wavelengthPanel.add(wavelengthLabel);
        wavelengthPanel.add(wavelengthSlider);

        return wavelengthPanel;
    }

    /**
     * Creates the panel for gas.
     *
     * @return gas panel
     */
    private JPanel createGasPanel() {
        JPanel gasPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        gasesComboBox = new JComboBox<>();
        updateGasComboBox();

        gasesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                gas = (Gas) gasesComboBox.getSelectedItem();
                controller.setGas(gas);
            }
        });

        gasPanel.add(new JLabel("Gás:"));
        gasPanel.add(gasesComboBox);

        return gasPanel;
    }

    /**
     * Creastes the panel for focal point.
     *
     * @return focal point panel
     */
    private JPanel createFocalPointPanel() {
        JPanel focalPointPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        focalPointDiameter = 4d;
        JLabel focalPointLabel = new JLabel(String.format("Diâmetro do corte:   %.0f mm", focalPointDiameter));

        JSlider focalPointSlider = new JSlider(1, 8, 4);
        focalPointSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                focalPointDiameter = (double) focalPointSlider.getValue();
                controller.setFocalPointArea(focalPointDiameter);
                focalPointLabel.setText(String.format("Diâmetro do corte:   %.0f mm", focalPointDiameter));
            }
        });

        focalPointPanel.add(focalPointLabel);
        focalPointPanel.add(focalPointSlider);

        return focalPointPanel;
    }

    /**
     * Creates the panel for material.
     *
     * @return material panel
     */
    private JPanel createMaterialPanel() {
        JPanel materialPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JComboBox<Material> materialComboBox = new JComboBox<>();
        materials.stream().forEach((material) -> {
            materialComboBox.addItem(material);
        });
        materialComboBox.setRenderer(new MaterialRenderer());

        materialComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                material = (Material) materialComboBox.getSelectedItem();
                controller.setMaterial(material);
            }
        });

        materialPanel.add(new JLabel("Material:"));
        materialPanel.add(materialComboBox);

        return materialPanel;
    }

    /**
     * Creates the panel for material thickness.
     *
     * @return material tickness panel
     */
    private JPanel createMaterialThickness() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        materialThicknessTextField = new DoubleJTextField(6);
        materialThicknessTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try {
                    double testValue = Double.parseDouble(materialThicknessTextField.getText() + e.getKeyChar());
                    if (testValue > 0) {
                        materialThickness = testValue;
                        controller.setMaterialThickness(materialThickness);
                        calculateMaxPowerButton.setEnabled(true);
                    } else {
                        calculateMaxPowerButton.setEnabled(false);
                    }
                } catch (NumberFormatException exception) {
                    calculateMaxPowerButton.setEnabled(false);
                }
            }
        });

        buttonPanel.add(new JLabel("Espessura do material:"));
        buttonPanel.add(materialThicknessTextField);
        buttonPanel.add(new JLabel("m"));

        return buttonPanel;
    }

    /**
     * Creates the panel for calculate button.
     *
     * @return calculate button panel
     */
    private JPanel createCalculateButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        calculateMaxPowerButton = new JButton("Calcular corte");
        calculateMaxPowerButton.setEnabled(false);
        calculateMaxPowerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                controller.newLaser();
                // TODO
                //controller.initiateCut();
                maxPower = controller.getMaxPower();
                maxPowerLabel.setText(String.format("Poder máximo:   %.4e W", maxPower));
            }
        });

        buttonPanel.add(calculateMaxPowerButton);

        return buttonPanel;
    }

    /**
     * Creates the panel for max power.
     *
     * @return max power panel
     */
    private JPanel createMaxPowerPanel() {
        JPanel maxPowerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        maxPowerLabel = new JLabel("Poder máximo:");

        maxPowerPanel.add(maxPowerLabel);

        return maxPowerPanel;
    }

    /**
     * Sets all fields with default values.
     */
    private void setDefaultValues() {
        this.wavelength = 10600d;
        this.controller.setWavelength(wavelength * 1e-9);
        this.gases = this.controller.getGasesByWavelength();
        this.gas = this.gases.iterator().next();
        this.controller.setGas(gas);
        this.materials = this.controller.getMaterials();
        this.material = this.materials.iterator().next();
        this.controller.setMaterial(material);
        this.focalPointDiameter = 4d;
        this.controller.setFocalPointArea(focalPointDiameter);
    }

    /**
     * Updates the fas combo box.
     */
    private void updateGasComboBox() {
        gasesComboBox.removeAllItems();

        Iterator<Gas> gasesIterator = gases.iterator();
        while (gasesIterator.hasNext()) {
            gasesComboBox.addItem(gasesIterator.next());
        }

        gasesComboBox.setRenderer(new GasRenderer());
        gas = (Gas) gasesComboBox.getSelectedItem();
        controller.setGas(gas);
    }
}
