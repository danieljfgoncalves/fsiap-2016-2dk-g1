/*
 * Package location for Model concepts.
 */
package controller;

import model.Material;
import model.Simulator;

/**
 * The controller to add material.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class AddMaterialController {
    
    /**
     * The simulator with all data.
     */
    private final Simulator simulator;
    
    /**
     * The material.
     */
    private Material material;

    /**
     * Creates a addMaterialController 
     * 
     * @param simulator the simulator with all data
     */
    public AddMaterialController(Simulator simulator) {
        this.simulator = simulator;
    }
 
    /**
     * Adds new material.
     */
    public void addNewMaterial(){
        this.material = this.simulator.newMaterial();
    }
    
    /**
     * Sets the data of the new material.
     * 
     * @param name the new name
     * @param latentHeat the new latent heat
     * @param heatCapacity the new heat capacity 
     * @param density the new density
     * @param vaporizationTemperature the new vaporization temperature
     * @param fusionTemperature the new fusion temperature
     * @param meltable the new meltable 
     */
    public void setMaterialData(String name, Double latentHeat, Double heatCapacity, Double density, Double vaporizationTemperature, Double fusionTemperature, boolean meltable){
        this.material.setName(name);
        this.material.setLatentHeat(latentHeat);
        this.material.setHeatCapacity(heatCapacity);
        this.material.setDensity(density);
        this.material.setVaporisationTemperature(vaporizationTemperature);
        this.material.setFusionTemperature(fusionTemperature);
        this.material.setMeltable(meltable);
    }
    
    /**
     * Registers the new material.
     * 
     * @return true if the material was added to the set of material, false otherwise.
     */
    public boolean registerMaterial(){
        return this.simulator.registerMaterial(this.material);
    }
}
