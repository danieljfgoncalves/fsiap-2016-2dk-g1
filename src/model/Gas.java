/*
 * Package location for Model concepts.
 */
package model;

import java.util.Objects;

/**
 * Represents a gas.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class Gas {

    /**
     * The name of the gas.
     */
    private String name;

    /**
     * The maximum wavelength in nanometers.
     */
    private Double maxWavelength;

    /**
     * The minimum wavelength in nanometers.
     */
    private Double minWavelength;

    /**
     * The epsilon value to calculate the error.
     */
    private final static double EPSILON = 0.0001;

    /**
     * Creates an instance of gas.
     *
     * @param name name of the gas
     * @param minWavelength the minimum wave length
     * @param maxWavelength the maximum wave length
     */
    public Gas(String name, Double minWavelength, Double maxWavelength) {
        this.name = name;
        this.minWavelength = minWavelength;
        this.maxWavelength = maxWavelength;
    }

    /**
     * Gets the name of the gas.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the gas.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the maximum wavelength.
     *
     * @return the maxWavelength
     */
    public Double getMaxWavelength() {
        return maxWavelength;
    }

    /**
     * Sets the maximum wavelength.
     *
     * @param maxWavelength the maxWavelength to set
     */
    public void setMaxWavelength(Double maxWavelength) {
        this.maxWavelength = maxWavelength;
    }

    /**
     * Gets the minimum wavelength.
     *
     * @return the minWavelength
     */
    public Double getMinWavelength() {
        return minWavelength;
    }

    /**
     * Sets the minimum wavelength.
     *
     * @param minWavelength the minWavelength to set
     */
    public void setMinWavelength(Double minWavelength) {
        this.minWavelength = minWavelength;
    }

    /**
     * Verify if wavelength is compatible with this gas.
     *
     * @param wavelength wavelength to verify
     * @return true if the wavelength lies in the allowed range, false otherwise
     */
    public boolean isCompatible(Double wavelength) {
        return wavelength >= this.minWavelength
                && wavelength <= this.maxWavelength;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.name);
        hash = 19 * hash + Objects.hashCode(this.maxWavelength);
        hash = 19 * hash + Objects.hashCode(this.minWavelength);
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

        final Gas other = (Gas) obj;

        return this.name.equals(other.name)
                && Math.abs(this.maxWavelength - other.maxWavelength) < EPSILON
                && Math.abs(this.minWavelength - other.minWavelength) < EPSILON;
    }

    @Override
    public String toString() {
        return String.format("Gas{name=%s, maxWavelength=%f, minWavelength=%f}",
                name, maxWavelength, minWavelength);
    }

}
