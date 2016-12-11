/*
 * Package location for controller concepts.
 */
package controller;

import java.io.File;
import view.SimulatorFrame;

/**
 * Represents a panel with the fields to generate the laser.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class ExportHTMLController {

    /**
     * The simulator frame.
     */
    private final SimulatorFrame parentFrame;

    /**
     * The export file.
     */
    private final File file;

    /**
     * Creates an ExportHTMLController.
     * 
     * @param parentFrame the simulator frame
     * @param file the export file
     */
    public ExportHTMLController(SimulatorFrame parentFrame, File file) {
        this.parentFrame = parentFrame;
        this.file = file;
    }

    /**
     * Export the experience data to an HTML file.
     */
    public void export() {
        parentFrame.getExperience().exportHTML(file);
    }
}
