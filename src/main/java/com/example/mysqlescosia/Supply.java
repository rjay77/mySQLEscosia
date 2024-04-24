package com.example.mysqlescosia;

public class Supply {
    private String name;
    private int quantity;
    private String date;

    public Supply(String name, int quantity, String date) {
        this.name = name;
        this.quantity = quantity;
        this.date = date;
    }
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDate() {
        return date;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDate(String date) {
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
