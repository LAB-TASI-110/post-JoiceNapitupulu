package model;

public enum Kota {
    MDN("Medan", 8000, true),
    BLG("Balige", 5000, true),
    JKT("Jakarta", 12000, false),
    SBY("Surabaya", 13000, false);

    private final String namaKota;
    private final double tarifPerKg;
    private final boolean isDalamPulau; // true jika Dalam Pulau, false jika Luar Pulau

    Kota(String namaKota, double tarifPerKg, boolean isDalamPulau) {
        this.namaKota = namaKota;
        this.tarifPerKg = tarifPerKg;
        this.isDalamPulau = isDalamPulau;
    }

    public String getNamaKota() {
        return namaKota;
    }

    public double getTarifPerKg() {
        return tarifPerKg;
    }

    public boolean isDalamPulau() {
        return isDalamPulau;
    }
}