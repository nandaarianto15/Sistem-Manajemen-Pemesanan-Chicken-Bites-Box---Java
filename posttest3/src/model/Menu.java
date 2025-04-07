package model;

// Penerapan Encapsulation dengan menggunakan Access Modifier Private & Public
public class Menu {
    private int id; // Private: hanya dapat diakses di dalam class ini
    private String nama;
    private String ukuran;
    private double harga;

    // Konstruktor untuk inisialisasi objek Menu
    public Menu(int id, String nama, String ukuran, double harga) {
        this.id = id;
        this.nama = nama;
        this.ukuran = ukuran;
        this.harga = harga;
    }

    // Getter untuk mengambil ID
    public int getId() {
        return id;
    }

    // Getter untuk mengambil nama menu
    public String getNama() {
        return nama;
    }

    // Setter untuk memperbarui nama menu
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter untuk mengambil ukuran menu
    public String getUkuran() {
        return ukuran;
    }

    // Setter untuk memperbarui ukuran menu
    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    // Getter untuk mengambil harga menu
    public double getHarga() {
        return harga;
    }

    // Setter untuk memperbarui harga menu
    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String toString() {
        return id + " | " + nama + " | " + ukuran + " | Rp" + String.format("%,.0f", harga);
    }
}
