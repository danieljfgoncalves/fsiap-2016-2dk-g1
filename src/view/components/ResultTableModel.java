/*
 * Package location for UI components.
 */
package view.components;

import javax.swing.table.AbstractTableModel;

/**
 * Represents the results table model.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class ResultTableModel extends AbstractTableModel {

    private final static String[] RESULT_COLUMN_NAMES = {"Results", "Values"};

    private String[][] results;
    
    public ResultTableModel(String[][] results) {
        this.results = results;
    }
    
    @Override
    public String getColumnName(int column) {
        return RESULT_COLUMN_NAMES[column];
    }
    
    @Override
    public int getRowCount() {
        
        return this.results.length;
    }

    @Override
    public int getColumnCount() {
        return RESULT_COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.results[rowIndex][columnIndex];
    }
}
