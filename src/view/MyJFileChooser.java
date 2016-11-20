/*
 * Package location for UI concepts.
 */
package view;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 * Creates a JFileChooser for HTML files.
 * 
 * @author Eric Amaral 1141570
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class MyJFileChooser extends JFileChooser {
    
    public MyJFileChooser() {
        super();
        extensionHTML();
    }

    private void extensionHTML() {
        setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                String extension = extension(f);
                if (extension != null) {
                    return extension.equals("html");
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "*.html";
            }

            private String extension(File f) {
                String ext = null;
                String s = f.getName();
                int i = s.lastIndexOf(".");
                if (i != -1) {
                    ext = s.substring(i + 1).toLowerCase();
                }
                return ext;
            }
        });
    }
}
