/*
 * Package location for Application model concepts.
 */
package model;

import java.util.Objects;
import model.calculations.MaximumPowerCalculus;
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

        // TODO: replace null when both calculus are implemented.
        this.calculus = (material.isMeltable())
                ? null
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.wavelength);
        hash = 97 * hash + Objects.hashCode(this.gas);
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
                && this.gas.equals(other.gas);
    }

    @Override
    public String toString() {
        return String.format("Laser{" + "wavelength=%d, gas=%s, focalPointArea=%.2f}",
                this.wavelength, this.gas, this.focalPointArea);
    }
}
