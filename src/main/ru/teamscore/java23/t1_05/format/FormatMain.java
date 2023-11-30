package ru.teamscore.java23.t1_05.format;

import java.time.LocalDate;
import java.util.Random;

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

        Random rnd = new Random(1000);
        Item[] itemsRandom = new Item[10000];
        for (int i = 0; i <itemsRandom.length; i++) {
            // название - случайные русские буквы
            char[] charsRandom = new char[rnd.nextInt(5, 25)];
            for (int ch = 0; ch < charsRandom.length; ch++) {
                charsRandom[ch] = (char)rnd.nextInt('А', 'я');
            }
            itemsRandom[i] = new Item(
                    new String(charsRandom),
                    // гиперболическое распределение, чаще встречаются числа 1-50
                    1 + rnd.nextInt(1, 10000) / rnd.nextInt(1, 2000),
                    // экспоненциальное распределение, малые числа встречаются чаще больших
                    Math.exp(rnd.nextDouble(0.1, Math.log(100_000))),
                    // случайная дата за 2023-2024 годы
                    LocalDate.of(2024, 12, 31)
                            .minusDays(rnd.nextInt(365 * 2))
            );
        };

        FormatTable tableRandom = new FormatTable(itemsRandom);

        System.out.println(tableRandom);
    }
}
