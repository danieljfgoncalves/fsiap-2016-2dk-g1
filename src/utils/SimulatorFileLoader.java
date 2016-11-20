/*
 * Package location for Utils concepts.
 */
package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.Simulator;

/**
 * Class that provides methods to write and read from binary files.
 *
 * @author Eric Amaral 1141570
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class SimulatorFileLoader {

    /**
     * Name of the file to save/load.
     */
    public static final String DEFAULT_FILE_NAME = "Simulator.bin";

    /**
     * Reads from a simulator from a specified binary file.
     *
     * @param fileName file to read from
     * @return simulator with data or null if there is some error reading the
     * file
     */
    public static Simulator read(String fileName) {
        Simulator simulator;
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(fileName));
            try {
                simulator = (Simulator) in.readObject();
            } finally {
                in.close();
            }
            return simulator;
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }

    /**
     * Saves the simulator data in a binary file.
     *
     * @param fileName name of the file to be saved
     * @param simulator simulator to be saved
     * @return true if it is successful saved, false otherwise
     */
    public static boolean save(String fileName, Simulator simulator) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(fileName));
            try {
                out.writeObject(simulator);
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
