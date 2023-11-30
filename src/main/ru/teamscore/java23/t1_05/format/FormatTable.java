package ru.teamscore.java23.t1_05.format;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FormatTable {
    public FormatTable(Item[] items) {
        this.items = items;
    }

    private final Item[] items;

    @Override
    public String toString() {
        var dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        StringBuilder sb = new StringBuilder();
        String pattern = "│ %-16s │ %s │ %6d │ %9.2f │\n";
        sb.append("┌──────────────────┬────────────┬────────┬───────────┐\n");
        sb.append("│ Title            │ Deadline   │Quantity│ Price     │\n");
        sb.append("├──────────────────┼────────────┼────────┼───────────┤\n");
        for (Item item : items) {
            sb.append(String.format(pattern,
                    item.getTitle(),
                    dateFormatter.format(item.getDeadline()),
                    item.getQuantity(),
                    item.getPrice()));
        }
        sb.append("└──────────────────┴────────────┴────────┴───────────┘\n");
        return sb.toString();
    }
}
