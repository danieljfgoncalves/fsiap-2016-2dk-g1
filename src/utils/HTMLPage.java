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
     * @param title - title of the page
     */
    public static String pageStart(String title) {

        StringBuilder page = new StringBuilder();

        page.append("<!DOCTYPE html>\n");
        page.append("<html>\n");
        page.append("<head>\n");
        page.append("<meta charset='utf-8'>\n");
        page.append(String.format("<title>%s</title>\n", title));
        page.append(insertTableStyle());
        page.append("</head>\n");
        page.append("<body>\n");

        return page.toString();
    }

    /**
     * Closes the page.
     *
     */
    public static String pageClose() {
        return "</body>\n</html>";
    }

    /**
     * Closes the page adding a final paragraph with current date.
     *
     */
    public static String pageCloseWithDate() {
        Calendar today = Calendar.getInstance();
        int day = today.get(Calendar.DAY_OF_MONTH);
        int month = today.get(Calendar.MONTH) + 1;
        int year = today.get(Calendar.YEAR);
        return paragraph("Date: " + day + "/" + month + "/" + year) + "</body>\n</html>";
    }

    /**
     * Creates a paragraph in the page.
     *
     * @param content - paragraph's content
     */
    public static String paragraph(String content) {
        return String.format("<p>%s</p>\n", content);
    }

    /**
     * Creates a main header in the page.
     *
     * @param content - header content
     */
    public static String header(String content) {
        return String.format("<h1>%s</h1>\n", content);
    }

    /**
     * Starts the creation of a table.
     *
     */
    public static String startTable() {
        return "<table>\n";
    }

    /**
     * Closes a created table.
     *
     */
    public static String closeTable() {
        return "</table>\n";
    }

    /**
     * Inserts a line of headers in the table.
     *
     * @param headers - headers of the table
     */
    public static String insertTableHeaders(String[] headers) {

        StringBuilder page = new StringBuilder();

        page.append("<tr>");
        for (int i = 0; i < headers.length; i++) {
            page.append(String.format("<th>%s</th>", headers[i]));
        }
        page.append("</tr>\n");

        return page.toString();
    }

    /**
     * Inserts multiple lines with content in the table.
     *
     * @param info - table content matrix
     * @param numLines - number of information lines in the table
     */
    public static String insertTableBody(String[][] info, int numLines) {

        StringBuilder page = new StringBuilder();

        for (int i = 0; i < numLines; i++) {
            page.append("<tr>");
            for (int j = 0; j < info[i].length; j++) {
                page.append(String.format("<td>%s</td>", info[i][j]));
            }
            page.append("</tr>\n");
        }

        return page.toString();
    }

    /**
     * Creates a table without header titles.
     *
     * @param info - table content matrix
     * @param numLines - number of lines in the table
     */
    public static String createTableWithoutHeaders(String[][] info, int numLines) {

        return startTable()
                + insertTableBody(info, numLines)
                + closeTable();

    }

    /**
     * Creates a table with header titles.
     *
     * @param headers - titles of the table
     * @param info - table content matrix
     * @param numLines - number of lines in the table
     */
    public static String createTableWithHeaders(String[] headers, String[][] info, int numLines) {
        
        return startTable()
                + insertTableHeaders(headers)
                + insertTableBody(info, numLines)
                + closeTable();
    }

    /**
     * Adds layouts to the content of the page.
     *
     */
    private static String insertTableStyle() {
        return "<style>\ntable, p {\n  "
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
                + "</style>\n";
    }
}