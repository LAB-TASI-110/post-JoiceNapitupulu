package driver;

import model.RakGudang;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RakGudang rak = new RakGudang(); // Instansiasi objek model

        System.out.println("=== SISTEM PENGHITUNG STOK GUDANG ===");
        
        // 1. Input Jumlah Total Data (N)
        System.out.print("Masukkan jumlah total data (N): ");
        int n = scanner.nextInt();

        // 2. Input Deret Stok
        List<Integer> inputStok = new ArrayList<>();
        System.out.print("Masukkan deret stok (" + n + " angka dipisah spasi): ");
        for (int i = 0; i < n; i++) {
            inputStok.add(scanner.nextInt());
        }
        
        // Memasukkan data ke dalam model
        rak.setDaftarStok(inputStok);

        // 3. Input Kode Kategori
        System.out.println("\nPilih Kode Kategori Barang:");
        System.out.println("1 - Kategori Ganjil (Contoh: Dasi, Rok Pramuka)");
        System.out.println("2 - Kategori Genap (Contoh: Gula, Minyak)");
        System.out.print("Masukkan kode kategori (1/2): ");
        int kodeKategori = scanner.nextInt();

        // Validasi dan Eksekusi
        if (kodeKategori == 1 || kodeKategori == 2) {
            int total = rak.hitungTotalKategori(kodeKategori);
            System.out.println("\n>> Total stok untuk kategori " + kodeKategori + " adalah: " + total + " pcs");
        } else {
            System.out.println("\n>> Error: Kode kategori tidak valid! Masukkan angka 1 atau 2.");
        }

        scanner.close(); // Mencegah memory leak
    }
}