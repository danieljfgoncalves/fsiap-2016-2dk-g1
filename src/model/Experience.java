/*
 * Package location for Application model concepts.
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

    private final static String[] DEFAULT_RESULTS_TITLES
            = {"Laser Gas", "Laser Power", "Affected Area", "Material", "Material Thickness",
                "Cutting Method", "Penetration Velocity", "Cutting Time Limit", "Does it Cut?"};

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
     *
     * @return the penetrationVelocity
     */
    public Double getPenetrationVelocity() {
        return penetrationVelocity;
    }

    /**
     * Sets Penetration Velocity (in m/s).
     *
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

    /**
     * Calculates and stores the penetration velocity of the laser.
     */
    public void calculatePenetrationVelocity() {

        this.penetrationVelocity = this.laser.getCalculus().calculate();
    }

    /**
     * Calculates and stores the penetration velocity of the laser (with the new
     * factor).
     *
     * @param factor the power factor
     */
    public void calculatePenetrationVelocity(Float factor) {

        this.laser.setFactor(factor);
        this.laser.updateCalculus();
        Experience.this.calculatePenetrationVelocity();
    }

    /**
     * Verifies if the laser cuts the material in the selected limit (cutting time)
     * 
     * @return true if it cuts, false otherwise
     */
    private boolean doesCut() {
        
        Double cuttingTime = (this.laser.getMaterialThickness() / this.penetrationVelocity);
        
        return cuttingTime < this.cuttingTimeLimit;
    }
    
    /**
     * Obtains the result table of the laser cut.
     * 
     * @return a table with the results.
     */
    public String[][] generateResults() {
        String[][] results = new String[2][DEFAULT_RESULTS_TITLES.length];
        
        // [ Gas | Power | Focal Point Area | Material | Thickness | Cut Method |P Vel | Time Limit | Cuts? ]
        results[1][0] = this.laser.getGas().getName();
        results[1][1] = String.format("%.2d W", this.laser.getMaxPower() * this.laser.getFactor());
        results[1][2] = String.format("%.2d m2", this.laser.getFocalPointArea());
        results[1][3] = this.laser.getMaterial().getName();
        results[1][4] = String.format("%.2d m", this.laser.getMaterialThickness());
        results[1][5] = (this.laser.getMaterial().isMeltable() ? "Fusion Cutting" : "Vaporisation Cutting");
        results[1][6] = String.format("%.2d m/s", this.laser.getFocalPointArea());
        results[1][7] = String.format("%.2d s", this.cuttingTimeLimit);
        results[1][8] = (doesCut() ? "Yes" : "No");

        return results;
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
