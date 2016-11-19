/*
 * Package location for Application calculus model concepts.
 */
package model.calculations;

import model.Calculable;
import model.Material;

/**
 * Represents a class that calculates the vaporisation process of a laser.
 *
 * @author Eric Amaral 1141570
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class VaporisationCalculus implements Calculable {

    /**
     * The absorved power density (W/m^2).
     */
    private Double powerDensity;

    /**
     * The selected material (with the needed variables).
     */
    private Material material;

    /**
     * Enviromental Temperature (ºC).
     */
    private Double inicialTemp;

    /**
     * Default enviromental Temperature (ºC).
     */
    private final static Double DEFAULT_INICIAL_TEMP = 20.0; // ºC 

    /**
     * Constructs an instance of a vaporisation calculus.
     *
     * @param power the emitting power (W).
     * @param focalPointArea the focal point area (m^2).
     * @param material the selected material (contains all necessary variables).
     */
    public VaporisationCalculus(Double power, Double focalPointArea, Material material) {

        this.powerDensity = power / focalPointArea; // Calculates the density (W/m^2)
        this.material = material;
        this.inicialTemp = DEFAULT_INICIAL_TEMP;
    }

    /**
     * Obtains the absorved power density (W/m^2).
     *
     * @return the powerDensity
     */
    public Double getPowerDensity() {
        return powerDensity;
    }

    /**
     * Sets the absorved power density (W/m^2).
     *
     * @param powerDensity the powerDensity to set
     */
    public void setPowerDensity(Double powerDensity) {
        this.powerDensity = powerDensity;
    }

    /**
     * Obtains the selected material (with the needed variables).
     *
     * @return the material
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Sets the selected material (with the needed variables).
     *
     * @param material the material to set
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * Obtains the enviromental Temperature (ºC).
     *
     * @return the inicialTemp
     */
    public Double getInicialTemp() {
        return inicialTemp;
    }

    /**
     * Sets the enviromental Temperature (ºC).
     *
     * @param inicialTemp the inicialTemp to set
     */
    public void setInicialTemp(Double inicialTemp) {
        this.inicialTemp = inicialTemp;
    }

    /**
     * Calculates the penetration velocity of the vaporisation process.
     *
     * @return the pener velocity (m/s)
     */
    @Override
    public double calculate() {

        return powerDensity
                / (material.getDensity()
                * (material.getLatentHeat() + material.getHeatCapacity()
                * (material.getVaporisationTemperature() - inicialTemp)));
    }
}
