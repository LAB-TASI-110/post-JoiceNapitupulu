package model;

public class MenuItem {
    private String id;
    private String name;
    private double price;
    private int stock;
    private int prepTimeMinutes; // Waktu persiapan per item

    public MenuItem(String id, String name, double price, int stock, int prepTimeMinutes) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.prepTimeMinutes = prepTimeMinutes;
    }

    // Getters and Setters (Encapsulation)
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public int getPrepTimeMinutes() { return prepTimeMinutes; }

    public void reduceStock(int quantity) {
        if (this.stock >= quantity) {
            this.stock -= quantity;
        }
    }

    public boolean isAvailable() {
        return this.stock > 0;
    }
}