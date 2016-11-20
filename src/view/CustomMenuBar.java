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
    private final JFrame parentFrame;

    public CustomMenuBar(JFrame parentFrame) {

        this.parentFrame = parentFrame;

        JMenu menu = new JMenu("Options");
        menu.setMnemonic(KeyEvent.VK_O);
        menu.add(createItemCuriosities());
        menu.add(createSubMenuList());
        menu.add(createItemExit());
        add(menu);
    }

    private void createComponents() {
        JMenuBar menuBar = createMenuBar();
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createMenuOptions());

        return menuBar;
    }

    private JMenu createMenuOptions() {
        JMenu menu = new JMenu("Options");
        menu.setMnemonic(KeyEvent.VK_O);
        menu.add(createItemCuriosities());
        menu.add(createSubMenuList());
        menu.add(createItemExit());
        return menu;
    }

    private JMenu createSubMenuList() {
        JMenu menu = new JMenu("Export");
        menu.setMnemonic(KeyEvent.VK_E);
        menu.add(createItemExportHTML());
        return menu;
    }

    private JMenuItem createItemExportHTML() {
        JMenuItem item = new JMenuItem("HTML", 'H');
        item.setAccelerator(KeyStroke.getKeyStroke("ctrl H"));

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MyJFileChooser fileChooser = new MyJFileChooser();
                int resposta = fileChooser.showSaveDialog(CustomMenuBar.this);
                if (resposta == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    if (!file.getName().endsWith(".html")) {
                        file = new File(file.getPath().trim() + ".html");
                    }
                    if (!true) {
                        JOptionPane.showMessageDialog(CustomMenuBar.this,
                                "Impossível gravar o ficheiro: "
                                + file.getPath() + " !",
                                "Exportar",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(CustomMenuBar.this,
                                "Ficheiro gravado com sucesso.",
                                "Exportar",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        return item;
    }

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
    private void exit() {
    }
}
