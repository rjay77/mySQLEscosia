package com.example.mysqlescosia;

import java.time.LocalDate;

public class Supply {
    private String name;
    private int quantity;
    private LocalDate date;

    public Supply(String name, int quantity, LocalDate date) {
        this.name = name;
        this.quantity = quantity;
        this.date = date;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Supply{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", date='" + date + '\'' +
                '}';
    }
}
