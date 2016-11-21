/*
 * Package location for view concepts.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import model.Experience;
import model.Simulator;
import utils.SimulatorFileLoader;

/**
 * Creates a custom JMenuBar.
 *
 * @author Eric Amaral 1141570
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class CustomMenuBar extends JMenuBar {

    /**
     * The parent JFrame.
     */
    private final SimulatorFrame parentFrame;

    /**
     * The simulator with all data.
     */
    private final Simulator simulator;

    private JMenu menuExport;

    /**
     * Creates an instance of the CustomMenuBar.
     *
     * @param parentFrame the main frame
     * @param simulator simulator with all data
     */
    public CustomMenuBar(SimulatorFrame parentFrame, Simulator simulator) {

        this.parentFrame = parentFrame;
        this.simulator = simulator;

        add(createMenuOptions());
    }

    /**
     * Creates the Options menu
     *
     * @return menu Options
     */
    private JMenu createMenuOptions() {
        JMenu menu = new JMenu("Options");
        menu.setMnemonic(KeyEvent.VK_O);
        menu.add(createItemCuriosities());
        menu.add(createItemAddMaterial());
        menu.add(createSubMenuList());
        menu.add(createItemExit());
        return menu;
    }

    /**
     * Creates the sub menu list for Export.
     *
     * @return the submenu list
     */
    private JMenu createSubMenuList() {
        this.menuExport = new JMenu("Export");
        this.menuExport.setMnemonic(KeyEvent.VK_E);
        this.menuExport.setEnabled(false);
        this.menuExport.add(createItemExportHTML());
        return this.menuExport;
    }

    /**
     * Creates the Add New Material item.
     *
     * @return the Add New Material item
     */
    private JMenuItem createItemAddMaterial() {
        JMenuItem item = new JMenuItem("Add New Material", 'M');
        item.setAccelerator(KeyStroke.getKeyStroke("ctrl M"));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });
        return item;
    }

    /**
     * Creates the HTML item.
     *
     * @return item
     */
    private JMenuItem createItemExportHTML() {
        JMenuItem item = new JMenuItem("HTML", 'H');
        item.setAccelerator(KeyStroke.getKeyStroke("ctrl H"));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MyJFileChooser fileChooser = new MyJFileChooser();
                int resposta = fileChooser.showSaveDialog(parentFrame);
                if (resposta == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    if (!file.getName().endsWith(".html")) {
                        file = new File(file.getPath().trim() + ".html");
                    }
                    parentFrame.getExperience().exportHTML(file);
                }
            }
        });
        return item;
    }

    /**
     * Creates the Exit item.
     *
     * @return Exit item
     */
    private JMenuItem createItemExit() {
        JMenuItem item = new JMenuItem("Exit", 'x');
        item.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });

        return item;
    }

    /**
     * Creates the Curiosities item.
     *
     * @return Curiosities item
     */
    private JMenuItem createItemCuriosities() {
        JMenuItem item = new JMenuItem("Curiosities", 'C');
        item.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });
        return item;
    }

    /**
     * Closes the program.
     */
    public void exit() {
        boolean isSaved = SimulatorFileLoader.save(SimulatorFileLoader.DEFAULT_FILE_NAME, this.simulator);

        if (isSaved) {
            System.exit(0);
        } else {
            System.exit(1);
        }
    }

    public void enableExportMenu() {
        menuExport.setEnabled(true);
    }
}