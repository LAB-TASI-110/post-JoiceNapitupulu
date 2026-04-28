package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int orderCounter = 1; // Untuk generate nomor pesanan otomatis
    
    private String orderNumber;
    private List<MenuItem> items;
    private double totalPrice;
    private int totalWaitTime;
    private String paymentMethod;

    public Order(String paymentMethod) {
        this.orderNumber = "ORD-" + String.format("%03d", orderCounter++);
        this.items = new ArrayList<>();
        this.totalPrice = 0.0;
        this.totalWaitTime = 0;
        this.paymentMethod = paymentMethod;
    }

    public void addItem(MenuItem item) {
        this.items.add(item);
        this.totalPrice += item.getPrice();
        this.totalWaitTime += item.getPrepTimeMinutes();
    }

    // Getters
    public String getOrderNumber() { return orderNumber; }
    public List<MenuItem> getItems() { return items; }
    public double getTotalPrice() { return totalPrice; }
    public int getTotalWaitTime() { return totalWaitTime; }
    public String getPaymentMethod() { return paymentMethod; }
}