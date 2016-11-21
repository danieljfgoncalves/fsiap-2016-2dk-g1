/*
 * Package location for UI components.
 */
package view.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Represents a image panel.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class ImagePanel extends JPanel {

    /**
     * Laser Process Diagram.
     */
    private static final ImageIcon LASER_IMG
            = new ImageIcon("laserImage.jpg");

    public ImagePanel() {
        super();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Dimension dimensaoPainel = getSize();
        double largura = dimensaoPainel.getWidth();
        double altura = dimensaoPainel.getWidth();

        Image img2 = LASER_IMG.getImage().getScaledInstance(
                (int) largura,
                (int) altura,
                Image.SCALE_SMOOTH);

        Image img3 = new ImageIcon(img2).getImage();

        g.drawImage(img3, 0, 0, this);

    }

}
