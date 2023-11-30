package ru.teamscore.java23.t1_05.format;

import java.time.LocalDate;

public class Item {
    public Item(String title, int quantity, double price, LocalDate deadline) {
        this.title = title;
        this.quantity = quantity;
        this.price = price;
        this.deadline = deadline;
    }

    public Item(String title, int quantity, double price, String deadline) {
        this(title, quantity, price, LocalDate.parse(deadline));
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    private String title;
    private int quantity;
    private double price;
    private LocalDate deadline;
}
