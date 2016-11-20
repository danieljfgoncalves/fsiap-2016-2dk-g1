/*
 * Package location for Application calculus model concepts.
 */
package model.calculations;

/**
 * Represents a class that calculates the max power that a laser can emit.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class MaximumPowerCalculus implements Calculable {

    /**
     * The wavelength.
     */
    private Double wavelength;

    /**
     * The focal point diameter.
     */
    private Double focalPointArea;

    /**
     * The pank's constant.
     */
    private final static Double PLANK_CONSTANT = 6.62607004e-34;

    /**
     * The speed of light.
     */
    private final static Double SPEED_OF_LIGHT = 299792458d;

    /**
     * Constructs an instance of MaximumPowerCalculus.
     *
     * @param wavelength the wavelength for calculus
     * @param focalPointArea the focal point diameter for calculus
     */
    public MaximumPowerCalculus(Double wavelength, Double focalPointArea) {
        this.wavelength = wavelength;
        this.focalPointArea = focalPointArea;
    }

    /**
     * Gets the wavelength.
     *
     * @return wavelength
     */
    public Double getWavelength() {
        return wavelength;
    }

    /**
     * Sets the wavelength.
     *
     * @param wavelength wavelength
     */
    public void setWavelength(Double wavelength) {
        this.wavelength = wavelength;
    }

    /**
     * Gets the focal point diameter.
     *
     * @return focal point diameter
     */
    public Double getFocalPointArea() {
        return focalPointArea;
    }

    /**
     * Sets the focal point diameter.
     *
     * @param focalPointArea focal point diameter
     */
    public void setFocalPointArea(Double focalPointArea) {
        this.focalPointArea = focalPointArea;
    }

    /**
     * Calculates the photon number per square metre, using a sealed CO2 laser
     * PX180 as a base.
     *
     * @return photon number per square metre
     */
    private Double calculatePhotonNumberPerSquareMetre() {
        // using sealed CO2 laser PX180 to get a photon number as a base
        Double baseWavelength = 10600e-9;
        Double baseMaxPower = 180d;
        Double baseFocalPointRadius = 4e-3;

        Double photonNumberPer8mm = (baseMaxPower * baseWavelength) / (PLANK_CONSTANT * SPEED_OF_LIGHT);
        Double beamArea = Math.PI * Math.pow(baseFocalPointRadius, 2);

        return photonNumberPer8mm / beamArea;
    }

    /**
     * Calculates de maximum power that the laser can emit.
     *
     * @return the maximum power that the laser can emit (W)
     */
    @Override
    public double calculate() {
        Double photonNumberOnArea = calculatePhotonNumberPerSquareMetre() * focalPointArea;

        return (photonNumberOnArea * PLANK_CONSTANT * SPEED_OF_LIGHT) / wavelength;
    }
}
