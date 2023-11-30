package ru.teamscore.java23.t1_05.format;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;

public class FormatTable {
    private final Item[] items;

    public FormatTable(Item[] items) {
        this.items = items;
    }

    @Override
    public String toString() {
        var columnsTitles = new String[] {"Title", "Deadline", "Quantity", "Price"};
        var columnsAlign = new boolean[]{ false, false, true, true };
        return formatTable( getCells(), columnsAlign, columnsTitles );
    }

    final static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    final static NumberFormat quantityFormatter = new DecimalFormat("#,##0");
    final static NumberFormat priceFormatter = new DecimalFormat("#,##0.00");
    private String[][] getCells() {
        var cells = new String[items.length][];
        for (int r = 0; r < items.length; r++) {
            var item = items[r];
            var row = new String[] {
                    item.getTitle(),
                    dateFormatter.format(item.getDeadline()),
                    quantityFormatter.format(item.getQuantity()),
                    priceFormatter.format(item.getPrice()),
            };
            cells[r] = row;
        }
        return cells;
    }

    private String formatTable(String[][] cells, boolean[] columnsAlignRight, String[] titleRow) {
        var columnWidths = getColumnWidths(cells, titleRow);
        String[] horizontalLines = getHorizontalLines(columnWidths);
        String titleRowPattern = getRowFormat(columnWidths, new boolean[columnsAlignRight.length]);

        String rowPattern = getRowFormat(columnWidths, columnsAlignRight);
        var tableBuilder = new StringBuilder();
        appendHorizontalLine(tableBuilder, horizontalLines, "┌", "┬", "┐");
        appendFormattedRow(tableBuilder, titleRowPattern, titleRow);
        appendHorizontalLine(tableBuilder, horizontalLines, "├", "┼", "┤");
        for (String[] row : cells) {
            appendFormattedRow(tableBuilder, rowPattern, row);
        }
        appendHorizontalLine(tableBuilder, horizontalLines, "└", "┴", "┘");
        return tableBuilder.toString();
    }

    private static String[] getHorizontalLines(int[] columnWidths) {
        String[] horizontalLines = new String[columnWidths.length];
        for (int i = 0; i < columnWidths.length; i++) {
            horizontalLines[i] = "─".repeat(columnWidths[i]).intern();
        }
        return horizontalLines;
    }

    private static void appendFormattedRow(StringBuilder tableBuilder, String pattern, String[] row) {
        tableBuilder.append(String.format(pattern, (Object[]) row));
    }

    private static void appendHorizontalLine(StringBuilder tableBuilder, String[] horizontalLines,
            String startWith, String delimiter, String endWith) {
        tableBuilder
                .append(startWith)
                .append(String.join(delimiter, horizontalLines))
                .append(endWith)
                .append("\n");
    }

    private int[] getColumnWidths(String[][] cells, String[] titleRow) {
        int[] maxTextLengths = new int[cells[0].length];
        for (int c = 0; c < titleRow.length; c++) {
            maxTextLengths[c] = titleRow[c].length();
        }
        for (String[] row : cells) {
            for (int c = 0; c < row.length; c++) {
                if (row[c].length() > maxTextLengths[c]) {
                    maxTextLengths[c] = row[c].length();
                }
            }
        }
        return maxTextLengths;
    }

    private String getRowFormat(int[] columnWidths, boolean[] columnsAlignRight) {
        String[] cellFormats = new String[columnWidths.length];
        for (int c = 0; c < columnWidths.length; c++) {
            cellFormats[c] = ("%" + columnWidths[c] * (columnsAlignRight[c] ? 1 : -1) + "s").intern();
        }
        return "│" + String.join("│", cellFormats) + "│\n";
    }
}
