/*
 * Package location for Application calculus model concepts.
 */
package model.calculations;

import model.Material;

/**
 * Represents a class that calculates the melting process of a laser.
 *
 * @author Eric Amaral 1141570
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class MeltingCalculus implements Calculable {

    /**
     * The absorved power (W).
     */
    private Double power;

    /**
     * The focal point area (m2).
     */
    private Double focalPointArea;

    /**
     * The selected material (with the needed variables).
     */
    private Material material;

    /**
     * The selected height of cut (material's thickness or the cut length).
     */
    private Double height;

    /**
     * Enviromental Temperature (ºC).
     */
    private Double inicialTemp;

    /**
     * Default enviromental Temperature (ºC).
     */
    private final static Double DEFAULT_INICIAL_TEMP = 20.0; // ºC 
    
    /**
     * Default enviromental Temperature (ºC).
     */
    private final static Double DEFAULT_CUT = 1E-2; // m 

    /**
     * Constructs an instance of a melting calculus.
     *
     * @param power the emitting power (W).
     * @param focalPointArea the focal point area (m^2).
     * @param material the selected material (contains all necessary variables).
     * @param materialThickness the selected material's thickness.
     */
    public MeltingCalculus(Double power, Double focalPointArea, Material material, Double materialThickness) {

        this.power = power;
        this.focalPointArea = focalPointArea;
        this.material = material;
        this.height = materialThickness;
        this.inicialTemp = DEFAULT_INICIAL_TEMP;
    }
    
    /**
     * Constructs an instance of a melting calculus for a transversal cut (Default value - e.g. 1cm).
     *
     * @param power the emitting power (W).
     * @param effectedArea  the effected area by the laser - thickness x beam diameter - (m^2).
     * @param material the selected material (contains all necessary variables).
     */
    public MeltingCalculus(Double power, Double effectedArea, Material material) {

        this.power = power;
        this.focalPointArea = effectedArea;
        this.material = material;
        this.height = DEFAULT_CUT;
        this.inicialTemp = DEFAULT_INICIAL_TEMP;
    }

    /**
     * Obtains the absorved power (W).
     *
     * @return the power
     */
    public Double getPower() {
        return power;
    }

    /**
     * Sets the absorved power (W).
     *
     * @param power the power to set
     */
    public void setPower(Double power) {
        this.power = power;
    }

    /**
     * Obtains the focal point area (m2).
     *
     * @return the focalPointArea
     */
    public Double getFocalPointArea() {
        return focalPointArea;
    }

    /**
     * Sets the focal point area (m2).
     *
     * @param focalPointArea the focalPointArea to set
     */
    public void setFocalPointArea(Double focalPointArea) {
        this.focalPointArea = focalPointArea;
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
     * Obtains the selected heigth (material's thickness or the cut length).
     *
     * @return the height
     */
    public Double getHeight() {
        return height;
    }

    /**
     * Sets the selected heigth (material's thickness or the cut length).
     *
     * @param heigth the height to set
     */
    public void setHeight(Double heigth) {
        this.height = heigth;
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
     * Calculates the mass from the effected volume and the material density.
     *
     * @return the mass effected by the laser
     */
    private double calculateMass() {

        // Volume: πr^2 (base area) * h (m^3)
        Double volume = this.focalPointArea * this.height;

        // Mass (kg) =  density (kg/m^3) * volume (m^3)
        return this.material.getDensity() * volume;
    }

    /**
     * Calculates the necessay heat to change phase (heat + latent heat)
     *
     * @return required heat to change phase
     */
    private double calculateRequiredHeat() {

        Double mass = calculateMass();

        Double changeFaseTemp = (this.material.getFusionTemperature().isNaN()) 
                ? this.material.getVaporizationTemperature() : this.material.getFusionTemperature();
        // Q = mc∆T (J)
        Double heat = mass * material.getHeatCapacity() * (changeFaseTemp - this.inicialTemp);

        // Q = mL (J)
        Double latentHeat = mass * this.material.getLatentHeat();

        // heat + latentHeat (required heat to change phase)
        return heat + latentHeat;
    }

    /**
     * Calculates the velocity (penetration or aprox. cut) of the melting process.
     *
     * @return the pener velocity (m/s)
     */
    @Override
    public double calculate() {

        Double requiredHeat = calculateRequiredHeat();
        
        Double timeToCut = requiredHeat / power;
        
        // Penetration velocity = material thickness / timeToCut
        return this.height / timeToCut;
    }
}
