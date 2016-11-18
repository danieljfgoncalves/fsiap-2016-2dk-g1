/*
 * Package location for Application Controllers concepts.
 */
package model;

import java.util.Objects;

/**
 * Represents an experience class.
 *
 * @author Eric Amaral 1141570
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class Experience {

    /**
     * time limit to cut material (in seconds).
     */
    private Double cuttingTimeLimit;

    /**
     * Laser used for the experience.
     */
    private Laser laser;
    
    /**
     * True if material is cutted, false otherwise.
     */
    private boolean cut;
    
    /**
     * Penetration Velocity (in m/s).
     */
    private Double penetrationVelocity;

    /**
     * Default time limit to cut material (in seconds).
     */
    private final static double DEFAULT_CUTTING_TIME_LIMIT = 30.0; 
    
    /**
     * Default penetration velocity (not calculated).
     */
    private final static double DEFAULT_PENETRATION_VELOCITY = 0.0;
    
    /**
     * Error margin for comparisons.
     */
    private final static double EPSILON = 0.0001;

    /**
     * Constructs a experience instance.
     *
     * @param laser laser used for experience.
     */
    public Experience(Laser laser) {

        this.cuttingTimeLimit = DEFAULT_CUTTING_TIME_LIMIT;
        this.laser = laser;
        this.penetrationVelocity = DEFAULT_PENETRATION_VELOCITY;
        this.cut = false;
    }

    /**
     * Obtains time necessary to cut material.
     *
     * @return the cuttingTimeLimit
     */
    public Double getCuttingTimeLimit() {
        return cuttingTimeLimit;
    }

    /**
     * Sets time limit to cut material.
     *
     * @param cuttingTimeLimit the cuttingTimeLimit to set
     */
    public void setCuttingTimeLimit(Double cuttingTimeLimit) {
        this.cuttingTimeLimit = cuttingTimeLimit;
    }

    /**
     * True if material is cut, false otherwise.
     *
     * @return true if material is cut, false otherwise.
     */
    public boolean isCut() {
        return cut;
    }

    /**
     * Sets true if lasers cuts material.
     */
    public void setCut() {
        this.cut = true;
    }

    /**
     * Obtains Penetration Velocity (in m/s).
     * @return the penetrationVelocity
     */
    public Double getPenetrationVelocity() {
        return penetrationVelocity;
    }

    /**
     * Sets Penetration Velocity (in m/s).
     * @param penetrationVelocity the penetrationVelocity to set
     */
    public void setPenetrationVelocity(Double penetrationVelocity) {
        this.penetrationVelocity = penetrationVelocity;
    }

    /**
     * Obtains Laser used for the experience.
     *
     * @return the laser
     */
    public Laser getLaser() {
        return laser;
    }

    /**
     * Sets Laser used for the experience.
     *
     * @param laser the laser to set
     */
    public void setLaser(Laser laser) {
        this.laser = laser;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.cuttingTimeLimit) ^ (Double.doubleToLongBits(this.cuttingTimeLimit) >>> 32));
        hash = 41 * hash + (this.cut ? 1 : 0);
        hash = 41 * hash + Objects.hashCode(this.laser);
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

        final Experience other = (Experience) obj;

        return this.laser.equals(other.laser)
                && Math.abs(this.cuttingTimeLimit - other.cuttingTimeLimit) < EPSILON
                && this.cut == other.cut;
    }

    @Override
    public String toString() {

        return String.format("Experience{timeToCut=%s, cuts=%s, laser=%s}",
                this.cuttingTimeLimit, this.cut ? "yes" : "no", this.laser);
    }
}
