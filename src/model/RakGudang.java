package model;

import java.util.ArrayList;
import java.util.List;

public class RakGudang {
    // Encapsulation: menggunakan private modifier
    private List<Integer> daftarStok;

    // Constructor
    public RakGudang() {
        this.daftarStok = new ArrayList<>();
    }

    // Setter untuk memasukkan seluruh deret stok
    public void setDaftarStok(List<Integer> daftarStok) {
        this.daftarStok = daftarStok;
    }

    /**
     * Method untuk menghitung total stok berdasarkan kode kategori
     * Kode 1 = Kategori posisi ganjil (indeks 0, 2, 4...)
     * Kode 2 = Kategori posisi genap (indeks 1, 3, 5...)
     */
    public int hitungTotalKategori(int kodeKategori) {
        int total = 0;
        
        for (int i = 0; i < daftarStok.size(); i++) {
            // Jika Kategori 1 diminta dan indeksnya genap (posisi ke-1, 3, 5...)
            if (kodeKategori == 1 && i % 2 == 0) {
                total += daftarStok.get(i);
            } 
            // Jika Kategori 2 diminta dan indeksnya ganjil (posisi ke-2, 4, 6...)
            else if (kodeKategori == 2 && i % 2 != 0) {
                total += daftarStok.get(i);
            }
        }
        
        return total;
    }
}