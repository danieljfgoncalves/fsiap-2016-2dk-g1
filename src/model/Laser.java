/*
 * Package location for Application Controllers concepts.
 */
package model;

import java.util.Objects;

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
    private int wavelength;

    /**
     * Selected gas object.
     */
    private Gas gas;

    /**
     * Area of selected focal point.
     */
    private Double focalPointArea;

    /**
     * Laser's power.
     */
    private Double power;

    /**
     * Error margin for comparisions.
     */
    private final static Double EPSILON = 0.0001;

    /**
     * Constructs a Laser instance.
     *
     * @param wavelength selected wavelength
     * @param gas selected gas
     * @param focalPointArea selected focal point area
     */
    public Laser(int wavelength, Gas gas, Double focalPointArea) {
        this.wavelength = wavelength;
        this.gas = gas;
        this.focalPointArea = focalPointArea;

        // TODO: calculate max power
        this.power = null;
    }

    /**
     * Obtains the laser's wavelength.
     *
     * @return the wavelength
     */
    public int getWavelength() {
        return wavelength;
    }

    /**
     * Sets the laser's wavelength.
     *
     * @param wavelength the wavelength to set
     */
    public void setWavelength(int wavelength) {
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
     * Obtains the laser's power.
     *
     * @return the power
     */
    public Double getPower() {
        return power;
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
