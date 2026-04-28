package model;

public class Pengiriman {
    private Kota tujuan;
    private double beratButet;

    public Pengiriman(Kota tujuan, double beratButet) {
        this.tujuan = tujuan;
        this.beratButet = beratButet;
    }

    // Menghitung berat Ucok (3/2 dari berat Butet)
    public double getBeratUcok() {
        return 1.5 * beratButet;
    }

    // Menghitung total berat
    public double getTotalBerat() {
        return beratButet + getBeratUcok();
    }

    // Mengecek apakah memenuhi syarat promo Lebaran
    public boolean isDapatPromo() {
        return getTotalBerat() > 10 && !tujuan.isDalamPulau();
    }

    // Menghitung total ongkos kirim (setelah diskon jika ada promo)
    public double hitungTotalOngkir() {
        double ongkirDasar = getTotalBerat() * tujuan.getTarifPerKg();
        
        if (isDapatPromo()) {
            double diskon = ongkirDasar * 0.10; // Diskon 10%
            return ongkirDasar - diskon;
        }
        
        return ongkirDasar;
    }

    // Mendapatkan teks keterangan promo
    public String getInfoPromo() {
        if (isDapatPromo()) {
            return "Diskon 10% & Asuransi Gratis";
        }
        return "-";
    }

    public Kota getTujuan() {
        return tujuan;
    }
    
    public double getBeratButet() {
        return beratButet;
    }
}