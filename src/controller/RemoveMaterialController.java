/*
 * Package location for Controller concepts.
 */
package controller;

import java.util.Set;
import model.Material;
import model.Simulator;

/**
 * The controller to remove a material.
 *
 * @author Eric Amaral 1141570
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class RemoveMaterialController {

    /**
     * The selected material.
     */
    private Material material;

    /**
     * The simulator with all data.
     */
    private final Simulator simulator;

    /**
     * Constructs a controller to remove a material.
     * 
     * @param simulator 
     */
    public RemoveMaterialController(Simulator simulator) {
        this.simulator = simulator;
    }

    /**
     * Sets the material to use.
     *
     * @param material material to use
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * Gets the available materials.
     *
     * @return all available materials
     */
    public Set<Material> getMaterials() {
        return this.simulator.getMaterials();
    }
    
    /**
     * Removes a given material.
     * 
     * @param material the material to be removed
     * @return true if material is removed, false otherwise
     */
    public boolean removeMaterial(Material material){
        return this.simulator.removeMaterial(material);
    }

}
