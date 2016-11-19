/*
 * Package location for Model concepts.
 */
package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a simulator for the experiences.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class Simulator {

    /**
     * The materials.
     */
    private Set<Material> materials;

    /**
     * The gases.
     */
    private Set<Gas> gases;

    /**
     * The curiosities related to laser cutting.
     */
    private Set<Curiosity> curiosities;

    /**
     * Creates an empty simulator.
     */
    public Simulator() {
        this.materials = new HashSet<>();
        this.gases = new HashSet<>();
        this.curiosities = new HashSet<>();
    }

    /**
     * Creates a simulator receiving his attributes.
     *
     * @param materials materials
     * @param gases gases
     * @param curiosities curiosities
     */
    public Simulator(Set<Material> materials, Set<Gas> gases, Set<Curiosity> curiosities) {
        this.materials = materials;
        this.gases = gases;
        this.curiosities = curiosities;
    }

    /**
     * Gets the materials.
     *
     * @return the materials
     */
    public Set<Material> getMaterials() {
        return materials;
    }

    /**
     * Sets the materials.
     *
     * @param materials the materials to set
     */
    public void setMaterials(Set<Material> materials) {
        this.materials = materials;
    }

    /**
     * Gets the gases.
     *
     * @return the gases
     */
    public Set<Gas> getGases() {
        return gases;
    }

    /**
     * Sets the gases.
     *
     * @param gases the gases to set
     */
    public void setGases(Set<Gas> gases) {
        this.gases = gases;
    }

    /**
     * Gets the curiosities.
     *
     * @return the curiosities
     */
    public Set<Curiosity> getCuriosities() {
        return curiosities;
    }

    /**
     * Sets the curiosities.
     *
     * @param curiosities the curiosities to set
     */
    public void setCuriosities(Set<Curiosity> curiosities) {
        this.curiosities = curiosities;
    }

    /**
     * Gets all gases compatible with a given wavelength.
     *
     * @param wavelength wavelength to check
     * @return all gases compatible with the wavelength
     */
    public Set<Gas> getGasesByWavelength(int wavelength) {
        Set<Gas> compatibleGases = new HashSet<>();

        for (Gas gas : gases) {
            if (gas.isCompatible(wavelength)) {
                compatibleGases.add(gas);
            }
        }

        return compatibleGases;
    }

    public Laser newLaser(int wavelength, Gas gas, Double focalPointArea) {
        return new Laser(wavelength, gas, focalPointArea);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.materials);
        hash = 17 * hash + Objects.hashCode(this.gases);
        hash = 17 * hash + Objects.hashCode(this.curiosities);
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

        final Simulator other = (Simulator) obj;

        return this.materials.equals(other.materials)
                && this.gases.equals(other.gases)
                && this.curiosities.equals(other.curiosities);
    }

    @Override
    public String toString() {
        return String.format("Simulator{materials=%s, gases=%s, curiosities=%s}",
                materials, gases, curiosities);
    }

}
