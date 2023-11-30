package ru.teamscore.java23.t1_05.rusname;

import static org.junit.jupiter.api.Assertions.*;
class RussianNameTest {

    @org.junit.jupiter.api.Test
    void hasPatronymicTrue() {
        var rusName = new RussianName("Тестов", "Тест", "Тестович");
        assertTrue(rusName.hasPatronymic());
    }

    @org.junit.jupiter.api.Test
    void hasPatronymicNull() {
        var rusName = new RussianName("Тестов", "Тест");
        assertFalse(rusName.hasPatronymic());
    }

    @org.junit.jupiter.api.Test
    void hasPatronymicEmpty() {
        var rusName = new RussianName("Тестов", "Тест", "");
        assertFalse(rusName.hasPatronymic());
    }

    @org.junit.jupiter.api.Test
    void hasPatronymicBlank() {
        var rusName = new RussianName("Тестов", "Тест", " ");
        assertFalse(rusName.hasPatronymic());
    }

    @org.junit.jupiter.api.Test
    void getFullNameWithPatronymic() {
        var rusName = new RussianName("Тестов", "Тест", "Тестович");
        assertEquals("Тест Тестович Тестов", rusName.getFullName());
    }
    @org.junit.jupiter.api.Test
    void getFullNameWithoutPatronymic() {
        var rusName = new RussianName("Тестов", "Тест");
        assertEquals("Тест Тестов", rusName.getFullName());
    }

    @org.junit.jupiter.api.Test
    void getFullAlphabeticNameWithPatronymic() {
        var rusName = new RussianName("Тестов", "Тест", "Тестович");
        assertEquals("Тестов Тест Тестович", rusName.getFullAlphabeticName());
    }
    @org.junit.jupiter.api.Test
    void getFullAlphabeticNameWithoutPatronymic() {
        var rusName = new RussianName("Тестов", "Тест");
        assertEquals("Тестов Тест", rusName.getFullAlphabeticName());
    }

    @org.junit.jupiter.api.Test
    void getAbbreviatedNameWithPatronymic() {
        var rusName = new RussianName("Тестов", "Тест", "Тестович");
        assertEquals("Т. Т. Тестов", rusName.getAbbreviatedName());
    }

    @org.junit.jupiter.api.Test
    void getAbbreviatedNameWithoutPatronymic() {
        var rusName = new RussianName("Тестов", "Тест");
        assertEquals("Т. Тестов", rusName.getAbbreviatedName());
    }

    @org.junit.jupiter.api.Test
    void getAbbreviatedAlphabeticNameWithPatronymic() {
        var rusName = new RussianName("Тестов", "Тест", "Тестович");
        assertEquals("Тестов Т.Т.", rusName.getAbbreviatedAlphabeticName());
    }
    @org.junit.jupiter.api.Test
    void getAbbreviatedAlphabeticNameWithoutPatronymic() {
        var rusName = new RussianName("Тестов", "Тест");
        assertEquals("Тестов Т.", rusName.getAbbreviatedAlphabeticName());
    }
}