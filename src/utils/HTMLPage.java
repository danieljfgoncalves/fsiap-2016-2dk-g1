/*
 * Package location for Utils concepts.
 */
package utils;

import java.util.Calendar;

/**
 * Class that provides methods to create the structure and insert elements in a
 * HTML page.
 *
 * @author Eric Amaral 1141570
 * @author Daniel Gonçalves 1151452
 * @author Ivo Ferro 1151159
 * @author Tiago Correia 1151031
 */
public class HTMLPage {

    /**
     * Starts the HTML page.
     *
     * @param page - page file
     * @param title - title of the page
     */
    public static void pageStart(StringBuffer page, String title) {
        page.append("<!DOCTYPE html>\n");
        page.append("<html>\n");
        page.append("<head>\n");
        page.append("<meta charset='utf-8'>\n");
        page.append(String.format("<title>%s</title>\n", title));
        page.append("</head>\n");
        page.append("<body>\n");
    }

    /**
     * Closes the page.
     *
     * @param page - page file
     */
    public static void pageClose(StringBuffer page) {
        page.append("</body>\n</html>");
    }

    /**
     * Closes the page adding a final paragraph with current date.
     *
     * @param page - page file
     */
    public static void pageCloseWithDate(StringBuffer page) {
        Calendar today = Calendar.getInstance();
        int day = today.get(Calendar.DAY_OF_MONTH);
        int month = today.get(Calendar.MONTH) + 1;
        int year = today.get(Calendar.YEAR);
        paragraph(page, "Date: " + day + "/" + month + "/" + year);
        page.append("</body>\n</html>");
    }

    /**
     * Creates a paragraph in the page.
     *
     * @param page - page file
     * @param content - paragraph's content
     */
    public static void paragraph(StringBuffer page, String content) {
        page.append(String.format("<p>%s</p>\n", content));
    }

    /**
     * Creates a main header in the page.
     * 
     * @param page - page file
     * @param content - header content
     */
    public static void header(StringBuffer page, String content) {
        page.append(String.format("<h1>%s</h1>\n", content));
    }

    /**
     * Starts the creation of a table.
     *
     * @param page - page file
     */
    public static void startTable(StringBuffer page) {
        page.append("<table>\n");
    }

    /**
     * Closes a created table.
     *
     * @param page
     */
    public static void closeTable(StringBuffer page) {
        page.append("</table>\n");
    }

    /**
     * Inserts a line of headers in the table.
     *
     * @param page - page file
     * @param info - headers of the table
     */
    public static void insertTableHeaders(StringBuffer page, String[] headers) {
        page.append("<tr>");
        for (int i = 0; i < headers.length; i++) {
            page.append(String.format("<th>%s</th>", headers[i]));
        }
        page.append("</tr>\n");
    }

    /**
     * Inserts multiple lines with content in the table.
     *
     * @param page - page file
     * @param info - table content matrix
     * @param numLines - number of information lines in the table
     */
    public static void insertTableBody(StringBuffer page, String[][] info, int numLines) {
        for (int i = 0; i < numLines; i++) {
            page.append("<tr>");
            for (int j = 0; j < info[i].length; j++) {
                page.append(String.format("<td>%s</td>", info[i][j]));
            }
            page.append("</tr>\n");
        }
    }

    /**
     * Creates a table without header titles.
     *
     * @param page - page file
     * @param info - table content matrix
     * @param numLines - number of lines in the table
     */
    public static void createTableWithoutHeaders(StringBuffer page, String[][] info, int numLines) {
        startTable(page);
        insertTableBody(page, info, numLines);
        closeTable(page);
    }

    /**
     * Creates a table with header titles.
     *
     * @param page - page file
     * @param headers - titles of the table
     * @param info - table content matrix
     * @param numLines - number of lines in the table
     */
    public static void createTableWithHeaders(StringBuffer page, String[] headers, String[][] info, int numLines) {
        startTable(page);
        insertTableHeaders(page, headers);
        insertTableBody(page, info, numLines);
        closeTable(page);
    }

    /**
     * Adds layouts to the content of the page.
     * 
     * @param page - page file
     */
    public static void insertTableStyle(StringBuffer page) {
        page.append("<style>\ntable, p {\n  "
                + "font-family: arial, sans-serif;\n"
                + "     border-collapse: collapse;\n"
                + "     width: 100%;}\n"
                + "td, th {\n"
                + "     border: 1px solid #dddddd;\n"
                + "     text-align: left;\n"
                + "     padding: 8px;}\n tr:nth-child(even) {\n"
                + "     background-color: #dddddd;}\n"
                + " h1 {\n  "
                + "font-family: arial, sans-serif;\n}"
                + "font-size:x-small;"
                + "text-align: left;"
                + "}\n"
                + "</style>\n");
    }
}
