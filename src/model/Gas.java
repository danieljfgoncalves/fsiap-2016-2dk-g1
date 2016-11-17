/*
 * Package location for Model concepts.
 */
package model;

import java.util.Objects;

/**
 * Represents a gas.
 *
 * @author Eric Amaral 1141570
 * @author Daniel Gonçalves 1151452
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
    private int maxWavelength;

    /**
     * The minimum wavelength in nanometers.
     */
    private int minWavelength;

    /**
     * The epsilon value to calculate the error.
     */
    private final static double EPSILON = 0.0001;

    /**
     * Creates an instance of gas.
     *
     * @param name name of the gas
     * @param maxWavelength the maximum wave length
     * @param minWavelength the minimum wave length
     */
    public Gas(String name, int maxWavelength, int minWavelength) {
        this.name = name;
        this.maxWavelength = maxWavelength;
        this.minWavelength = minWavelength;
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
    public int getMaxWavelength() {
        return maxWavelength;
    }

    /**
     * Sets the maximum wavelength.
     *
     * @param maxWavelength the maxWavelength to set
     */
    public void setMaxWavelength(int maxWavelength) {
        this.maxWavelength = maxWavelength;
    }

    /**
     * Gets the minimum wavelength.
     *
     * @return the minWavelength
     */
    public int getMinWavelength() {
        return minWavelength;
    }

    /**
     * Sets the minimum wavelength.
     *
     * @param minWavelength the minWavelength to set
     */
    public void setMinWavelength(int minWavelength) {
        this.minWavelength = minWavelength;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.name);
        hash = 73 * hash + this.maxWavelength;
        hash = 73 * hash + this.minWavelength;
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
        return String.format("Gas{name=%s, maxWavelength=%d, minWavelength=%d}",
                name, maxWavelength, minWavelength);
    }

}
