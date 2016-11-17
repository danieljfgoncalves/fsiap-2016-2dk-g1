/*
 * Package location for Model concepts.
 */
package model;

import java.util.Objects;

/**
 * Represents a solid material.
 *
 * @author Eric Amaral 1141570
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class Material {

    /**
     * Material name.
     */
    private String name;

    /**
     * The temperature to melt or evaporise.
     */
    private Double latentHeat;

    /**
     * The material's heat capacity.
     */
    private Double heatCapacity;

    /**
     * The material's density.
     */
    private Double density;

    /**
     * The material's vaporisation temperature.
     */
    private Double vaporisationTemperature;

    /**
     * Tells if the material can melt. If it does, the field must be true.
     * Otherwise, the mearial can only evaporise.
     */
    private boolean meltable;

    /**
     * The epsilon value to calculate the error.
     */
    private final static double EPSILON = 0.0001;

    /**
     * Constructs an instance of material receiving their properties.
     *
     * @param name the material's name
     * @param latentHeat the material's latent heat
     * @param heatCapacity the material's heat capacity
     * @param density the material's density
     * @param vaporisationTemperature the material's vaporisation temperature
     * @param meltable tells if the material is either meltable or not
     */
    public Material(String name, Double latentHeat, Double heatCapacity, Double density, Double vaporisationTemperature, boolean meltable) {
        this.name = name;
        this.latentHeat = latentHeat;
        this.heatCapacity = heatCapacity;
        this.density = density;
        this.vaporisationTemperature = vaporisationTemperature;
        this.meltable = meltable;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the latentHeat
     */
    public Double getLatentHeat() {
        return latentHeat;
    }

    /**
     * @param latentHeat the latentHeat to set
     */
    public void setLatentHeat(Double latentHeat) {
        this.latentHeat = latentHeat;
    }

    /**
     * @return the heatCapacity
     */
    public Double getHeatCapacity() {
        return heatCapacity;
    }

    /**
     * @param heatCapacity the heatCapacity to set
     */
    public void setHeatCapacity(Double heatCapacity) {
        this.heatCapacity = heatCapacity;
    }

    /**
     * @return the density
     */
    public Double getDensity() {
        return density;
    }

    /**
     * @param density the density to set
     */
    public void setDensity(Double density) {
        this.density = density;
    }

    /**
     * @return the vaporisationTemperature
     */
    public Double getVaporisationTemperature() {
        return vaporisationTemperature;
    }

    /**
     * @param vaporisationTemperature the vaporisationTemperature to set
     */
    public void setVaporisationTemperature(Double vaporisationTemperature) {
        this.vaporisationTemperature = vaporisationTemperature;
    }

    /**
     * @return the meltable
     */
    public boolean isMeltable() {
        return meltable;
    }

    /**
     * @param meltable the meltable to set
     */
    public void setMeltable(boolean meltable) {
        this.meltable = meltable;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.latentHeat);
        hash = 23 * hash + Objects.hashCode(this.heatCapacity);
        hash = 23 * hash + Objects.hashCode(this.density);
        hash = 23 * hash + Objects.hashCode(this.vaporisationTemperature);
        hash = 23 * hash + (this.meltable ? 1 : 0);
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

        final Material other = (Material) obj;

        return this.name.equals(other.name)
                && Math.abs(this.density - other.density) < EPSILON
                && Math.abs(this.heatCapacity - other.heatCapacity) < EPSILON
                && Math.abs(this.latentHeat - other.latentHeat) < EPSILON
                && Math.abs(this.vaporisationTemperature - other.vaporisationTemperature) < EPSILON;
    }

}
