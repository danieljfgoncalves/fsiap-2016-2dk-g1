/*
 * Package location for Application model concepts.
 */
package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import model.calculations.MeltingCalculus;
import utils.HTMLPage;

/**
 * Represents an experience class.
 *
 * @author Eric Amaral 1141570
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class Experience implements Exportable {

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
     * Transversal Cutting Speed (in m/s).
     */
    private Double cuttingSpeed;

    /**
     * Default time limit to cut material (in seconds).
     */
    private final static double DEFAULT_CUTTING_TIME_LIMIT = 30.0;

    /**
     * Default penetration velocity (not calculated).
     */
    private final static double DEFAULT_PENETRATION_VELOCITY = 0.0;

    /**
     * Default cutting speed (not calculated).
     */
    private final static double DEFAULT_CUTTING_SPEED = Double.NaN;

    private final static String[] DEFAULT_RESULTS_TITLES
            = {"Laser Gas", "Laser Power", "Affected Area", "Material", "Material Thickness",
                "Cutting Method", "Penetration Velocity", "Time to cut", "Does it Cut?", "Cutting Speed"};

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
        this.cuttingSpeed = DEFAULT_CUTTING_SPEED;
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
     * Obtains the transversal Cutting Speed (in m/s).
     *
     * @return the cuttingSpeed
     */
    public Double getCuttingSpeed() {
        return cuttingSpeed;
    }

    /**
     * Sets the transversal Cutting Speed (in m/s).
     *
     * @param cuttingSpeed the cuttingSpeed to set
     */
    public void setCuttingSpeed(Double cuttingSpeed) {
        this.cuttingSpeed = cuttingSpeed;
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

        if (doesCut()) {
            // Calculate Cutting Speed
            Double emittedPower = this.laser.getMaxPower() * this.laser.getFactor();
            Double effectedArea = this.laser.getBeamDiameter() * this.laser.getMaterialThickness();

            this.cuttingSpeed = (new MeltingCalculus(emittedPower, effectedArea, this.laser.getMaterial())).calculate();
        }
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
        this.penetrationVelocity = this.laser.getCalculus().calculate();
    }

    /**
     * Verifies if the laser cuts the material in the selected limit (cutting
     * time)
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
        String[][] results = new String[DEFAULT_RESULTS_TITLES.length][2];

        for (int i = 0; i < DEFAULT_RESULTS_TITLES.length; i++) {
            results[i][0] = DEFAULT_RESULTS_TITLES[i];
        }

        // [ Gas | Power | Focal Point Area | Material | Thickness | Cut Method |P Vel | Time Limit | Cuts? ]
        results[0][1] = this.laser.getGas().getName();
        results[1][1] = String.format("%.4E W", this.laser.getMaxPower() * this.laser.getFactor());
        results[2][1] = String.format("%.4E mm2", (this.laser.getFocalPointArea() * 1E6));
        results[3][1] = this.laser.getMaterial().getName();
        results[4][1] = String.format("%.4E mm", (this.laser.getMaterialThickness() * 1E3));
        results[5][1] = (this.laser.getMaterial().isMeltable() ? "Fusion Cutting" : "Vaporisation Cutting");
        results[6][1] = String.format("%.4E mm/s", (this.penetrationVelocity * 1E3));
        results[7][1] = String.format("%.2f s", this.laser.getMaterialThickness() / this.penetrationVelocity);
        results[8][1] = doesCut() ? "Yes" : "No";
        results[9][1] = this.cuttingSpeed.isNaN() ? "N/A" : String.format("%.4E mm/s", (this.penetrationVelocity * 1E3));
        return results;
    }

    /**
     * Creates the structure of the exported HTML file.
     */
    @Override
    public void exportHTML(File file) {
        StringBuilder page = new StringBuilder();

        page.append(HTMLPage.pageStart("Experience Results"));
        page.append(HTMLPage.header("Experience Results:\n"));
        page.append(HTMLPage.createTableWithoutHeaders(generateResults(), generateResults().length));
        page.append(HTMLPage.pageCloseWithDate());

        try {
            try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {

                out.write(String.format("%s", page));
            }
        } catch (IOException ex) {
        }
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
