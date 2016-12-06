/*
 * Package location for view concepts.
 */
package view;

import controller.RemoveMaterialController;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Material;
import model.Simulator;

/**
 * Creates the Remove Material UI.
 *
 * @author Eric Amaral 1141570
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class RemoveMaterialUI extends JDialog {

    /**
     * Inner class to render the material.
     */
    private static class MaterialRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value != null) {
                value = ((Material) value).getName();
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    }

    /**
     * The materials.
     */
    private final Set<Material> materials;

    /**
     * The selected material.
     */
    private Material material;

    /**
     * The confirm button.
     */
    private JButton confirmButton;

    /**
     * The cancel button.
     */
    private JButton cancelButton;

    /**
     * The remove material controller.
     */
    private RemoveMaterialController controller;

    /**
     * Padding border.
     */
    private final static EmptyBorder PADDING_BORDER = new EmptyBorder(10, 10, 10, 10);

    /**
     * Window title.
     */
    private static final String WINDOW_TITLE = "Remove Material";

    public RemoveMaterialUI(Simulator simulator, JFrame parentFrame) {
        super(parentFrame, WINDOW_TITLE, true);

        controller = new RemoveMaterialController(simulator);
        materials = controller.getMaterials();

        createComponents();

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setResizable(true);
        setLocationRelativeTo(parentFrame);
        setVisible(true);
    }

    /**
     * Creates the UI components for the remove material window
     */
    private void createComponents() {
        JPanel componentsPanel = new JPanel(new BorderLayout(10, 10));
        componentsPanel.add(createMaterialPanel(), BorderLayout.CENTER);
        componentsPanel.add(createButtonsPanel(), BorderLayout.SOUTH);
        componentsPanel.setBorder(PADDING_BORDER);
        add(componentsPanel);
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
     * Creates the panel for material.
     *
     * @return material panel
     */
    private JPanel createMaterialPanel() {
        JPanel materialPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JComboBox<Material> materialComboBox = new JComboBox<>();
        materialComboBox.setPreferredSize(new Dimension(150, 20));
        materials.stream().forEach((material) -> {
            materialComboBox.addItem(material);
        });
        materialComboBox.setRenderer(new RemoveMaterialUI.MaterialRenderer());

        materialComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                material = (Material) materialComboBox.getSelectedItem();
                controller.setMaterial(material);
            }
        });

        materialPanel.add(new JLabel("Select the material to remove:"));
        materialPanel.add(materialComboBox);

        return materialPanel;
    }

    /**
     * Creates the cancel button.
     *
     * @return cancel button
     */
    private JButton createCancelButton() {
        this.cancelButton = new JButton("Cancel");

        this.cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        return cancelButton;
    }

    /**
     * Creates the confirm data button.
     *
     * @return confirm data button
     */
    private JButton createConfirmButton() {
        this.confirmButton = new JButton("Confirm");

        this.confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isRemoved;
                isRemoved = controller.removeMaterial(material);
                if (isRemoved) {
                    JOptionPane.showMessageDialog(rootPane,
                            "Material removed sucessfully!",
                            "Remove Material",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                dispose();
            }
        }
        );
        return confirmButton;
    }
}
