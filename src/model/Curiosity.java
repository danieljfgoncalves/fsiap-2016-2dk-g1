/*
 * Package location for Model concepts.
 */
package model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a curiosity related to the laser cutting.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class Curiosity implements Serializable {

    /**
     * Curiosity's description
     */
    private String curiosityDescription;

    /**
     * Curiosity's description by default
     */
    private static final String DEFAULT_CURIOSITY = "undefined";

    /**
     * builds up an instance of Curiosity with parameters by default
     */
    public Curiosity() {
        this.curiosityDescription = DEFAULT_CURIOSITY;
    }

    /**
     * builds up an instance of CUriosity from another instance of Curiosity
     *
     * @param otherCity City to copy
     */
    public Curiosity(Curiosity otherCuriosity) {
        this.curiosityDescription = otherCuriosity.curiosityDescription;
    }

    /**
     * builds up an instance of Curiosity with parameter curiosity
     *
     * @param curiosity Curiosity's description
     */
    public Curiosity(String curiosityDescription) {
        this.curiosityDescription = curiosityDescription;
    }

    /**
     * @return the curiosity
     */
    public String getCuriosityString() {
        return curiosityDescription;
    }

    /**
     * @param curiosity the curiosity to set
     */
    public void setCuriosity(String curiosity_description) {
        this.curiosityDescription = curiosity_description;
    }

    /**
     * Return the textual representation of a Curiosity.
     *
     * @return the textual representation of a Curiosity
     */
    @Override
    public String toString() {
        return String.format("%nCuriosity: %s %n",
                this.getCuriosityString());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.curiosityDescription);
        return hash;
    }

    /**
     * Compares two Curiosities objects.
     *
     * @param otherObject Object to compare
     * @return true if the objects are equals.
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }

        final Curiosity otherCuriosity = (Curiosity) otherObject;

        return this.getCuriosityString().equals(otherCuriosity.getCuriosityString());
    }

}
