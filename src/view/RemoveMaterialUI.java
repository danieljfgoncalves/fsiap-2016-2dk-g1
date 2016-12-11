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
    private JButton removeButton;

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
    private static final String WINDOW_TITLE = "Remover Material";

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

        buttonsPanel.add(createRemoveButton());
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
            }
        });

        materialPanel.add(new JLabel("Selecione o material a remover:"));
        materialPanel.add(materialComboBox);

        return materialPanel;
    }

    /**
     * Creates the cancel button.
     *
     * @return cancel button
     */
    private JButton createCancelButton() {
        this.cancelButton = new JButton("Cancelar");

        this.cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        return cancelButton;
    }

    /**
     * Creates the remove button.
     *
     * @return remove button
     */
    private JButton createRemoveButton() {
        this.removeButton = new JButton("Remover");

        this.removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (material == null) {
                        throw new IllegalArgumentException("Por favor selecione um material!");
                    }
                    int selectedOption = JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende remover  " + material.toStringName() + "?", "Remover Material", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_OPTION) {
                        boolean isRemoved;
                        isRemoved = controller.removeMaterial(material);
                        if (isRemoved) {
                            JOptionPane.showMessageDialog(rootPane,
                                    "Material removido com sucesso!",
                                    "Remover Material",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        dispose();
                    }
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            ex.getMessage(),
                            "Erro",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        );
        return removeButton;
    }
}
