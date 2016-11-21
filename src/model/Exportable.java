/*
 * Package location for Model concepts.
 */
package model;

import java.io.File;

/**
 * Interface for file exportation.
 *
 * @author Eric Amaral 1141570
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public interface Exportable {
    
    /**
     * Exports data.
     */
    public abstract void exportHTML(File file);
    
}
