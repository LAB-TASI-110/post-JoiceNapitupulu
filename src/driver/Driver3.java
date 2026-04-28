package driver;

import model.Cafeteria;
import model.MenuItem;
import model.Order;
import java.util.Scanner;

public class Driver3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cafeteria kafetaria = new Cafeteria();
        boolean isRunning = true;

        System.out.println("Selamat Datang di Sistem Pemesanan Kafetaria IT Del!");

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Lihat Ketersediaan Menu & Harga");
            System.out.println("2. Buat Pesanan Baru");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi (1-3): ");
            
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    kafetaria.displayMenu();
                    break;
                case "2":
                    handleNewOrder(scanner, kafetaria);
                    break;
                case "3":
                    System.out.println("Terima kasih telah menggunakan layanan kami. Horas!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
        scanner.close();
    }

    private static void handleNewOrder(Scanner scanner, Cafeteria kafetaria) {
        kafetaria.displayMenu();
        
        System.out.println("\nPilih metode pembayaran:");
        System.out.println("1. Cash");
        System.out.println("2. Transfer Bank / Qris");
        System.out.print("Pilih (1/2): ");
        String paymentInput = scanner.nextLine();
        String paymentMethod = paymentInput.equals("1") ? "CASH" : "TRANSFER";

        Order currentOrder = new Order(paymentMethod);
        boolean ordering = true;

        while (ordering) {
            System.out.print("\nMasukkan ID Menu yang ingin dipesan (atau 'Selesai' untuk proses): ");
            String idMenu = scanner.nextLine();

            if (idMenu.equalsIgnoreCase("Selesai")) {
                if (currentOrder.getItems().isEmpty()) {
                    System.out.println("Pesanan dibatalkan karena kosong.");
                } else {
                    kafetaria.placeOrder(currentOrder);
                }
                ordering = false;
                break;
            }

            MenuItem selectedItem = kafetaria.findMenuById(idMenu);

            if (selectedItem == null) {
                System.out.println("❌ Menu tidak ditemukan.");
            } else if (!selectedItem.isAvailable()) {
                System.out.println("❌ Maaf, stok " + selectedItem.getName() + " habis.");
            } else {
                // Kurangi stok dan tambahkan ke pesanan
                selectedItem.reduceStock(1);
                currentOrder.addItem(selectedItem);
                System.out.println("✅ " + selectedItem.getName() + " ditambahkan ke keranjang.");
            }
        }
    }
}