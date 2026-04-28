package driver;

import model.Kota;
import model.Pengiriman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pengiriman> daftarPengiriman = new ArrayList<>();

        System.out.println("======================================");
        System.out.println("  Sistem Kasir Del-Express CLI");
        System.out.println("======================================");
        System.out.println("Ketik 'END' pada kode kota untuk selesai.\n");

        while (true) {
            System.out.print("Masukkan Kode Kota Tujuan (MDN/BLG/JKT/SBY): ");
            String inputKode = scanner.nextLine().trim().toUpperCase();

            if (inputKode.equals("END")) {
                break;
            }

            Kota kotaTujuan = null;
            try {
                kotaTujuan = Kota.valueOf(inputKode);
            } catch (IllegalArgumentException e) {
                System.out.println("[Error] Kode kota tidak valid. Silakan coba lagi.\n");
                continue;
            }

            System.out.print("Masukkan Berat Paket Butet (kg): ");
            double beratButet = 0;
            try {
                beratButet = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("[Error] Format berat harus angka. Ulangi input.\n");
                continue;
            }

            daftarPengiriman.add(new Pengiriman(kotaTujuan, beratButet));
            System.out.println("-> Data berhasil ditambahkan!\n");
        }

        System.out.println("\n===========================================================");
        System.out.println("                 STRUK PEMBAYARAN DEL-EXPRESS                ");
        System.out.println("===========================================================");
        
        for (int i = 0; i < daftarPengiriman.size(); i++) {
            Pengiriman p = daftarPengiriman.get(i);
            
            System.out.printf("Transaksi #%d\n", (i + 1));
            System.out.printf("Kota Tujuan          : %s\n", p.getTujuan().getNamaKota());
            System.out.printf("Berat Paket Butet    : %.2f kg\n", p.getBeratButet());
            System.out.printf("Berat Paket Ucok     : %.2f kg\n", p.getBeratUcok());
            System.out.printf("Total Berat          : %.2f kg\n", p.getTotalBerat());
            System.out.printf("Total Ongkos Kirim   : Rp%,.0f\n", p.hitungTotalOngkir());
            System.out.printf("Info Promo           : %s\n", p.getInfoPromo());
            System.out.println("-----------------------------------------------------------");
        }
        
        System.out.println("Terima kasih telah menggunakan layanan Del-Express!");
        scanner.close();
    }
}