/*
 * Package location for Application calculus model concepts.
 */
package model.calculations;

import model.Calculable;

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
    private int wavelength;

    /**
     * The focal point diameter.
     */
    private double focalPointDiameter;

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
     * @param focalPointDiameter the focal point diameter for calculus
     */
    public MaximumPowerCalculus(int wavelength, int focalPointDiameter) {
        this.wavelength = wavelength;
        this.focalPointDiameter = focalPointDiameter;
    }

    /**
     * Gets the wavelength.
     *
     * @return wavelength
     */
    public int getWavelength() {
        return wavelength;
    }

    /**
     * Sets the wavelength.
     *
     * @param wavelength wavelength
     */
    public void setWavelength(int wavelength) {
        this.wavelength = wavelength;
    }

    /**
     * Gets the focal point diameter.
     *
     * @return focal point diameter
     */
    public double getFocalPointDiameter() {
        return focalPointDiameter;
    }

    /**
     * Sets the focal point diameter.
     *
     * @param focalPointDiameter focal point diameter
     */
    public void setFocalPointDiameter(double focalPointDiameter) {
        this.focalPointDiameter = focalPointDiameter;
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
        Double beamArea = Math.PI * Math.pow((focalPointDiameter / 2), 2);
        Double photonNumberOnArea = calculatePhotonNumberPerSquareMetre() * beamArea;

        return (photonNumberOnArea * PLANK_CONSTANT * SPEED_OF_LIGHT) / wavelength;
    }
}
