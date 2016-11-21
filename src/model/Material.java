/*
 * Package location for Model concepts.
 */
package model;

import java.util.Objects;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a solid material.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class Material implements Serializable, Comparable<Material> {

    /**
     * Material name.
     */
    private String name;

    /**
     * The latent heat necessary to melt or evaporise (J/Kg).
     */
    private Double latentHeat;

    /**
     * The material's heat capacity (J/(KgºC)).
     */
    private Double heatCapacity;

    /**
     * The material's density (kg/m^3).
     */
    private Double density;

    /**
     * The material's vaporisation temperature (ºC).
     */
    private Double vaporisationTemperature;
    
    /**
     * The material's fusion temperatura (ºC).
     */
    private Double fusionTemperature;

    /**
     * Tells if the material can melt. If it does, the field must be true.
     * Otherwise, the material can only sublimate.
     */
    private boolean meltable;

    /**
     * The epsilon value to calculate the error.
     */
    private final static double EPSILON = 0.0001;
    
    private final static double DENSITY_BY_DEFAULT = 0.0;
    private final static double HEAT_CAPACITY_BY_DEFAULT = 0.0;
    private final static double LATENT_HEAT_BY_DEFAULT = 0.0;
    private final static boolean MELTABLE_BY_DEFAULT = true;
    private final static String NAME_BY_DEFAULT = "New Material";
    private final static double VAPORISATION_TEMPERATURE_BY_DEFAULT = 0.0;
    private final static double FUSION_TEMPERATURE_BY_DEFAULT = 0.0;

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
    public Material(String name, Double latentHeat, Double heatCapacity, Double density, Double vaporisationTemperature, Double fusionTemperature, boolean meltable) {
        this.name = name;
        this.latentHeat = latentHeat;
        this.heatCapacity = heatCapacity;
        this.density = density;
        this.vaporisationTemperature = vaporisationTemperature;
        this.fusionTemperature = fusionTemperature;
        this.meltable = meltable;
    }
    
    /**
     * Constructs a instance of material using it's parameters by default.
     */
    public Material(){
        this.density = DENSITY_BY_DEFAULT;
        this.heatCapacity = HEAT_CAPACITY_BY_DEFAULT;
        this.latentHeat = LATENT_HEAT_BY_DEFAULT;
        this.meltable = MELTABLE_BY_DEFAULT;
        this.name = NAME_BY_DEFAULT;
        this.vaporisationTemperature = VAPORISATION_TEMPERATURE_BY_DEFAULT;
        this.fusionTemperature = FUSION_TEMPERATURE_BY_DEFAULT;
    }

    /**
     * Gets the material's name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the material's name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the latent heat.
     *
     * @return the latentHeat
     */
    public Double getLatentHeat() {
        return latentHeat;
    }

    /**
     * Sets the latent heat.
     *
     * @param latentHeat the latentHeat to set
     */
    public void setLatentHeat(Double latentHeat) {
        this.latentHeat = latentHeat;
    }

    /**
     * Gets the heat capacity.
     *
     * @return the heatCapacity
     */
    public Double getHeatCapacity() {
        return heatCapacity;
    }

    /**
     * Sets the heat capacity.
     *
     * @param heatCapacity the heatCapacity to set
     */
    public void setHeatCapacity(Double heatCapacity) {
        this.heatCapacity = heatCapacity;
    }

    /**
     * Gets the density.
     *
     * @return the density
     */
    public Double getDensity() {
        return density;
    }

    /**
     * Sets the density.
     *
     * @param density the density to set
     */
    public void setDensity(Double density) {
        this.density = density;
    }

    /**
     * Gets the vaporization temperature.
     *
     * @return the vaporisationTemperature
     */
    public Double getVaporisationTemperature() {
        return vaporisationTemperature;
    }

    /**
     * Sets the vaporization temperature.
     *
     * @param vaporisationTemperature the vaporisationTemperature to set
     */
    public void setVaporisationTemperature(Double vaporisationTemperature) {
        this.vaporisationTemperature = vaporisationTemperature;
    }
    
    /**
     * Gets the fusion temperature.
     *
     * @return the fusionTemperature
     */
    public Double getFusionTemperature() {
        return fusionTemperature;
    }

    /**
     * Sets the fusion temperature.
     *
     * @param fusionTemperature the fusionTemperature to set
     */
    public void setFusionTemperature(Double fusionTemperature) {
        this.fusionTemperature = fusionTemperature;
    }

    /**
     * Gets the meltable state.
     *
     * @return true if the material is meltable, false otherwise.
     */
    public boolean isMeltable() {
        return meltable;
    }

    /**
     * Sets the meltable state.
     *
     * @param meltable the meltable state
     */
    public void setMeltable(boolean meltable) {
        this.meltable = meltable;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.latentHeat);
        hash = 47 * hash + Objects.hashCode(this.heatCapacity);
        hash = 47 * hash + Objects.hashCode(this.density);
        hash = 47 * hash + Objects.hashCode(this.vaporisationTemperature);
        hash = 47 * hash + Objects.hashCode(this.fusionTemperature);
        hash = 47 * hash + (this.meltable ? 1 : 0);
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
                && Math.abs(this.fusionTemperature - other.fusionTemperature) < EPSILON
                && Math.abs(this.vaporisationTemperature - other.vaporisationTemperature) < EPSILON;
    }

    @Override
    public String toString() {
        return String.format("Material{name=%s, meltable=%s, latentHeat=%4f, "
                + "heatCapacity=%4f, density=%4f, fusionTemperature=&4f, vaporisationTemperature=%4f}",
                name, meltable, latentHeat, heatCapacity,
                density, fusionTemperature, vaporisationTemperature);
    }

    @Override
    public int compareTo(Material otherMaterial) {
        return this.name.compareTo(otherMaterial.name);
    }

}