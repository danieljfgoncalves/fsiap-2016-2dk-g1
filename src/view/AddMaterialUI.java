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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.Simulator;

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
     * The radio button for is meltable
     */
    private JRadioButton jrbIsMeltable;

    /**
     * The radio button for not meltable
     */
    private JRadioButton jrbNotMeltable;

    /**
     * The meltable boolean
     */
    private boolean isMeltable;

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
    private static final String WINDOW_TITLE = "Adicionar Material";

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

        controller = new AddMaterialController(simulator);

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

    /**
     * Create the labels Panel.
     *
     * @return the Labels Panel.
     */
    private JPanel labelsPanel() {
        JPanel labelPanel = new JPanel(new GridLayout(0, 1));
        JTextArea jta1 = new JTextArea("Nome");
        jta1.setEditable(false);
        JTextArea jta2 = new JTextArea("Calor latente (J/Kg)");
        jta2.setEditable(false);
        JTextArea jta3 = new JTextArea("Capacidade térmica (J/(KgºC)");
        jta3.setEditable(false);
        JTextArea jta4 = new JTextArea("Densidade (kg/m^3)");
        jta4.setEditable(false);
        JTextArea jta5 = new JTextArea("Temperatura de vaporização(ºC)");
        jta5.setEditable(false);
        JTextArea jta6 = new JTextArea("Temperatura de fusão(ºC)");
        jta6.setEditable(false);
        JTextArea jta7 = new JTextArea("Fundível");
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

    /**
     * Creates the fields Panel.
     *
     * @return the fields Panel.
     */
    private JPanel fieldsPanel() {
        final int FIELD_WIDTH = 20;
        JPanel fieldPanel = new JPanel(new GridLayout(0, 1));
        jtfName = new JTextField(FIELD_WIDTH);
        jtfLatentHeat = new JTextField(FIELD_WIDTH);
        jtfHeatCapacity = new JTextField(FIELD_WIDTH);
        jtfDensity = new JTextField(FIELD_WIDTH);
        jtfVaporizationTemperature = new JTextField(FIELD_WIDTH);
        jtfFusionTemperature = new JTextField(FIELD_WIDTH);

        fieldPanel.add(jtfName);
        fieldPanel.add(jtfLatentHeat);
        fieldPanel.add(jtfHeatCapacity);
        fieldPanel.add(jtfDensity);
        fieldPanel.add(jtfVaporizationTemperature);
        fieldPanel.add(jtfFusionTemperature);
        fieldPanel.add(createRbPanel());

        return fieldPanel;
    }

    /**
     * Creates the radio button panel.
     *
     * @return radio button panel
     */
    private JPanel createRbPanel() {
        JPanel rbPanel = new JPanel(new GridLayout(0, 2));
        jrbIsMeltable = new JRadioButton("Sim");
        jrbNotMeltable = new JRadioButton("Não");
        ButtonGroup bG = new ButtonGroup();
        bG.add(jrbIsMeltable);
        bG.add(jrbNotMeltable);

        jrbIsMeltable.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrbIsMeltable.isSelected()) {
                    isMeltable = true;
                } else {
                    isMeltable = false;
                }
            }
        });

        jrbNotMeltable.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrbNotMeltable.isSelected()) {
                    isMeltable = false;
                } else {
                    isMeltable = true;
                }
            }
        });

        rbPanel.add(jrbIsMeltable);
        rbPanel.add(jrbNotMeltable);

        return rbPanel;
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
        this.cancelAddMaterial = new JButton("Cancelar");

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
        this.confirmDataButton = new JButton("Confirmar");

        this.confirmDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedOption = JOptionPane.showConfirmDialog(null, "Adicionar " + jtfName.getText() + " aos materiais?", "Adicionar material", JOptionPane.OK_CANCEL_OPTION);
                if (selectedOption == JOptionPane.OK_OPTION) {
                    try {
                        if (jtfName.getText().length() < 1 || jtfLatentHeat.getText().length() < 1 || jtfHeatCapacity.getText().length() < 1
                                || jtfDensity.getText().length() < 1 || jtfVaporizationTemperature.getText().length() < 1) {
                            throw new IllegalArgumentException("Campo em branco! . Tente novamente.");
                        }

                        if (jtfFusionTemperature.getText().isEmpty()) {
                            jtfFusionTemperature.setText("0");
                        }

                        boolean flag;
                        controller.addNewMaterial();
                        flag = controller.setMaterialData(jtfName.getText(), Double.parseDouble(jtfLatentHeat.getText()),
                                Double.parseDouble(jtfHeatCapacity.getText()), Double.parseDouble(jtfDensity.getText()),
                                Double.parseDouble(jtfVaporizationTemperature.getText()),
                                Double.parseDouble(jtfFusionTemperature.getText()), isMeltable);

                        if (!flag) {
                            throw new IllegalArgumentException("A densidade tem de ser positiva!");
                        }

                        boolean addedMaterial;
                        addedMaterial = controller.registerMaterial();

                        if (!addedMaterial) {
                            throw new IllegalArgumentException("O material já existe! Insira um novo.");
                        } else {
                            JOptionPane.showMessageDialog(rootPane,
                                    "Material adicionado com sucesso!",
                                    "Adicionar material",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }

                        dispose();

                    } catch (IllegalArgumentException ex) {

                        JOptionPane.showMessageDialog(
                                parentFrame,
                                ex.getMessage(),
                                "Designação inválida",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
        );
        return confirmDataButton;

    }
}
