/*
 * Package location for Application model concepts.
 */
package model;

import model.calculations.Calculable;
import java.util.Objects;
import model.calculations.MaximumPowerCalculus;
import model.calculations.MeltingCalculus;
import model.calculations.VaporisationCalculus;

/**
 * Represents a laser class.
 *
 * @author Eric Amaral 1141570
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class Laser {

    /**
     * Selected wavelength.
     */
    private Double wavelength;

    /**
     * Selected gas object.
     */
    private Gas gas;

    /**
     * Area of selected focal point.
     */
    private Double focalPointArea;

    /**
     * Laser's max power.
     */
    private Double maxPower;

    /**
     * Power factor (ex. half of max power 0.5)
     */
    private Float factor;

    /**
     * Selected material.
     */
    private Material material;

    /**
     * Material thickness.
     */
    private Double materialThickness;

    /**
     * The calculus necessary (depends on the selected material).
     */
    private Calculable calculus;

    /**
     * Default power factor
     */
    private final static Float DEFAULT_FACTOR = 1.0f;

    /**
     * Error margin for comparisons.
     */
    private final static Double EPSILON = 0.0001;

    /**
     * Constructs a Laser instance.
     *
     * @param wavelength selected wavelength
     * @param gas selected gas
     * @param focalPointDiameter selected focal point diameter
     * @param material selected material
     * @param materialThickness material's thickness
     */
    public Laser(Double wavelength, Gas gas, Double focalPointDiameter, Material material, Double materialThickness) {
        this.wavelength = wavelength;
        this.gas = gas;
        this.focalPointArea = Math.PI * Math.pow((focalPointDiameter / 2), 2);
        this.factor = DEFAULT_FACTOR;
        this.material = material;
        this.materialThickness = materialThickness;

        this.calculus = (material.isMeltable())
                ? new MeltingCalculus(maxPower * factor, focalPointArea, material, materialThickness)
                : new VaporisationCalculus(maxPower * factor, focalPointArea, material);

        MaximumPowerCalculus maximumPowerCalculus = new MaximumPowerCalculus(wavelength, focalPointArea);
        this.maxPower = maximumPowerCalculus.calculate();
    }

    /**
     * Obtains the laser's wavelength.
     *
     * @return the wavelength
     */
    public Double getWavelength() {
        return wavelength;
    }

    /**
     * Sets the laser's wavelength.
     *
     * @param wavelength the wavelength to set
     */
    public void setWavelength(Double wavelength) {
        this.wavelength = wavelength;
    }

    /**
     * Obtain selected gas object.
     * @return the gas
     */
    public Gas getGas() {
        return gas;
    }

    /**
     * Sets selected gas object.
     * @param gas the gas to set
     */
    public void setGas(Gas gas) {
        this.gas = gas;
    }

    /**
     * Obtains selected material.
     * @return the material
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Sets selected material.
     * @param material the material to set
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * Obtains the Material thickness.
     * @return the materialThickness
     */
    public Double getMaterialThickness() {
        return materialThickness;
    }

    /**
     * Sets the Material thickness.
     * @param materialThickness the materialThickness to set
     */
    public void setMaterialThickness(Double materialThickness) {
        this.materialThickness = materialThickness;
    }

    /**
     * Obtains the area of selected focal point.
     *
     * @return the focalPointArea
     */
    public Double getFocalPointArea() {
        return focalPointArea;
    }

    /**
     * Sets the area of selected focal point.
     *
     * @param focalPointArea the focalPointArea to set
     */
    public void setFocalPointArea(Double focalPointArea) {
        this.focalPointArea = focalPointArea;
    }

    /**
     * Obtains the laser's max power.
     *
     * @return the power
     */
    public Double getMaxPower() {
        return maxPower;
    }

    /**
     * Obtains power factor (ex. half of max power 0.5)
     *
     * @return the factor
     */
    public Float getFactor() {
        return factor;
    }

    /**
     * Sets power factor (ex. half of max power 0.5)
     *
     * @param factor the factor to set
     */
    public void setFactor(Float factor) {
        this.factor = factor;
    }

    /**
     * Obtains the calculus necessary (depends on the selected material).
     * @return the calculus
     */
    public Calculable getCalculus() {
        return calculus;
    }

    /**
     * Updates the calculus necessary (depends on the selected material).
     */
    public void updateCalculus() {
        
        this.calculus = (getMaterial().isMeltable())
                ? new MeltingCalculus(maxPower * factor, focalPointArea, getMaterial(), getMaterialThickness())
                : new VaporisationCalculus(maxPower * factor, focalPointArea, getMaterial());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.wavelength);
        hash = 97 * hash + Objects.hashCode(this.getGas());
        hash = 97 * hash + Objects.hashCode(this.focalPointArea);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final Laser other = (Laser) obj;

        return Math.abs(this.wavelength - other.wavelength) < EPSILON
                && Math.abs(this.focalPointArea - other.focalPointArea) < EPSILON
                && this.getGas().equals(other.getGas());
    }

    @Override
    public String toString() {
        return String.format("Laser{" + "wavelength=%d, gas=%s, focalPointArea=%.2f}",
                this.wavelength, this.getGas(), this.focalPointArea);
    }
}
