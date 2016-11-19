/*
 * Package location for Model concepts.
 */
package controller;

import java.util.Set;
import model.Gas;
import model.Laser;
import model.Material;
import model.Simulator;

/**
 * The controller to generate the laser.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class GenerateLaserController {

    /**
     * The simulator with all data.
     */
    private final Simulator simulator;

    /**
     * The selected wavelength.
     */
    private Double wavelength;

    /**
     * The selected gas.
     */
    private Gas gas;

    /**
     * The selected material.
     */
    private Material material;

    /**
     * Material thickness.
     */
    private Double materialThickness;
    
    /**
     * The selected focal point area.
     */
    private Double focalPointArea;

    /**
     * The laser to generate.
     */
    private Laser laser;

    /**
     * Creates a generate laser controller.
     *
     * @param simulator the simulator with all data
     */
    public GenerateLaserController(Simulator simulator) {
        this.simulator = simulator;
    }

    /**
     * Sets the wavelength to use.
     *
     * @param wavelength wavelength to use
     */
    public void setWavelength(Double wavelength) {
        this.wavelength = wavelength;
    }

    /**
     * Gets the gases by the wavelength.
     *
     * @return gases by wavelength
     */
    public Set<Gas> getGasesByWavelength() {
        return this.simulator.getGasesByWavelength(this.wavelength);
    }

    /**
     * Sets the gas to use.
     *
     * @param gas gas to use
     */
    public void setGas(Gas gas) {
        this.gas = gas;
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
     * Sets the material to use.
     *
     * @param material material to use
     */
    public void setMaterial(Material material) {
        this.material = material;
    }
    
    /**
     * Sets the matrial's thickness to use.
     *
     * @param materialThickness  the selected material thickness
     */
    public void setMaterialThickness(Double materialThickness) {
        this.materialThickness = materialThickness;
    }

    /**
     * Sets the focal point area to cut.
     *
     * @param focalPointArea focal point area to cut
     */
    public void setFocalPointArea(Double focalPointArea) {
        this.focalPointArea = focalPointArea;
    }

    /**
     * Creates the laser for the experience.
     */
    public void newLaser() {
        laser = simulator.newLaser(wavelength, gas, focalPointArea, material, materialThickness);
    }

    public void initiateCut() {
        // TODO create the controller to calculate the laser cut.
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
