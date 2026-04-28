package model;

import java.util.ArrayList;
import java.util.List;

public class Cafeteria {
    private List<MenuItem> menuList;
    private List<Order> orderHistory;

    public Cafeteria() {
        this.menuList = new ArrayList<>();
        this.orderHistory = new ArrayList<>();
        seedMenu(); // Inisialisasi data dummy saat objek dibuat
    }

    // Menambahkan data awal ke dalam list
    private void seedMenu() {
        menuList.add(new MenuItem("M01", "Nasi Goreng Spesial", 15000, 20, 10));
        menuList.add(new MenuItem("M02", "Mie Ayam Pangsit", 12000, 15, 8));
        menuList.add(new MenuItem("B01", "Es Teh Manis", 5000, 50, 2));
        menuList.add(new MenuItem("B02", "Kopi Susu Aren", 10000, 10, 5));
    }

    public void displayMenu() {
        System.out.println("\n=== DAFTAR MENU KAFETARIA IT DEL ===");
        System.out.printf("%-5s | %-20s | %-10s | %-5s\n", "ID", "Nama Menu", "Harga", "Stok");
        System.out.println("-----------------------------------------------------");
        for (MenuItem item : menuList) {
            System.out.printf("%-5s | %-20s | Rp%-8.0f | %-5d\n", 
                item.getId(), item.getName(), item.getPrice(), item.getStock());
        }
        System.out.println("-----------------------------------------------------");
    }

    public MenuItem findMenuById(String id) {
        for (MenuItem item : menuList) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null; // Jika menu tidak ditemukan
    }

    public void placeOrder(Order order) {
        orderHistory.add(order);
        System.out.println("\n✅ Pesanan Berhasil Dibuat!");
        System.out.println("Nomor Pesanan  : " + order.getOrderNumber());
        System.out.println("Metode Bayar   : " + order.getPaymentMethod());
        System.out.println("Total Tagihan  : Rp" + order.getTotalPrice());
        System.out.println("Estimasi Waktu : " + order.getTotalWaitTime() + " menit");
        System.out.println("Mohon tunggu dan ambil pesanan Anda sesuai waktu estimasi.");
    }
}