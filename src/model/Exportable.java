/*
 * Package location for Model concepts.
 */
package model;

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
    public abstract void exportHTML(String url);
    
}
