package ru.teamscore.java23.t1_05.format;

public class FormatMain {
    public static void main(String[] args) {
        Item[] items = {
                new Item("Елка", 1, 1000, "2023-12-25"),
                new Item("Мандарины", 100, 25.15, "2023-12-15"),
                new Item("Гирлянда", 5, 125.99, "2023-12-30"),
                new Item("Бенгальские огни", 2, 75.5, "2023-12-30"),
        };

        FormatTable table = new FormatTable(items);

        System.out.println(table);
    }
}
