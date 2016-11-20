/*
 * Package location for UI classes.
 */
package view;

import controller.ShowCuriositiesController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import model.Curiosity;
import model.Simulator;

/**
 * The UI to show curiosities.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class ShowCuriositiesUI extends JDialog {

    /**
     * The curiosities list.
     */
    private final ListIterator<Curiosity> curiositiesIterator;

    /**
     * The text area
     */
    private JTextArea jtextArea;

    /**
     * The previous button
     */
    private JButton previousButton;

    /**
     * The next button
     */
    private JButton nextButton;

    /**
     * The direction (boolean) (flag)
     */
    private boolean direction;

    /**
     * Window title.
     */
    private static final String WINDOW_TITLE = "CURIOSITIES";

    /**
     * Padding border.
     */
    private final static EmptyBorder PADDING_BORDER = new EmptyBorder(10, 10, 10, 10);

    /**
     * Creates an instance of ShowCuriositiesUI.
     *
     * @param simulator the simulator
     * @param parentFrame the parent frame
     */
    public ShowCuriositiesUI(Simulator simulator, JFrame parentFrame) {
        super(parentFrame, WINDOW_TITLE, true);

        this.direction = true;

        ShowCuriositiesController controller = new ShowCuriositiesController(simulator);
        this.curiositiesIterator = (new LinkedList<>(controller.getCuriosities())).listIterator();

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
        componentsPanel.add(createCuriositiesPanel(), BorderLayout.CENTER);
        componentsPanel.add(createButtonsPanel(), BorderLayout.SOUTH);
        componentsPanel.setBorder(PADDING_BORDER);
        add(componentsPanel);
    }

    /**
     * Creates the curiosities panel.
     *
     * @return the curiosities panel
     */
    private JPanel createCuriositiesPanel() {
        JPanel curiosityPanel = new JPanel(new BorderLayout());

        this.jtextArea = new JTextArea(this.curiositiesIterator.next().getCuriosityString());
        this.jtextArea.setEditable(false);
        this.jtextArea.setLineWrap(true);

        JScrollPane areaScrollPane = new JScrollPane(this.jtextArea);
        areaScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        areaScrollPane.setPreferredSize(new Dimension(500, 300));

        curiosityPanel.add(areaScrollPane);

        return curiosityPanel;
    }

    /**
     * Creates the buttons panel.
     *
     * @return buttons panel
     */
    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        buttonsPanel.add(createPreviousButton());
        buttonsPanel.add(createNextButton());

        return buttonsPanel;
    }

    /**
     * Creates the previous button.
     *
     * @return previous button
     */
    private JButton createPreviousButton() {
        this.previousButton = new JButton("Previous");
        this.previousButton.setEnabled(this.curiositiesIterator.previousIndex() > 0);

        this.previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (direction) {
                    jtextArea.setText(curiositiesIterator.previous().getCuriosityString());
                    jtextArea.setText(curiositiesIterator.previous().getCuriosityString());
                    direction = false;
                } else {
                    jtextArea.setText(curiositiesIterator.previous().getCuriosityString());
                }
                previousButton.setEnabled(curiositiesIterator.hasPrevious());
                nextButton.setEnabled(curiositiesIterator.hasNext());
            }
        });

        return previousButton;
    }

    /**
     * Creates the next button.
     *
     * @return the next button
     */
    public JButton createNextButton() {
        this.nextButton = new JButton("Next");
        this.nextButton.setEnabled(curiositiesIterator.hasNext());

        this.nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (direction) {
                    jtextArea.setText(curiositiesIterator.next().getCuriosityString());
                } else {
                    jtextArea.setText(curiositiesIterator.next().getCuriosityString());
                    jtextArea.setText(curiositiesIterator.next().getCuriosityString());
                    direction = true;
                }

                nextButton.setEnabled(curiositiesIterator.hasNext());
                previousButton.setEnabled(curiositiesIterator.hasPrevious());
            }
        });
        return nextButton;
    }

}
