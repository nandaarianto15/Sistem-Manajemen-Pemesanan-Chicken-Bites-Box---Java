package model;

// Penerapan Encapsulation dengan menggunakan Access Modifier Private & Public
public abstract class Menu implements MenuOperation { // ABSTRACT CLASS - berfungsi sebagai dasar bagi class turunan
    // Private: hanya dapat diakses di dalam class ini
    private final int id; // FINAL VARIABLE - agar nilainya tidak bisa diubah setelah di set pertama kali
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
        return this.harga;
    }

    // Setter untuk memperbarui harga menu
    public void setHarga(double harga) {
        this.harga = harga;
    }

    // Override
    @Override
    public String toString() {
        return id + " | " + nama + " | " + ukuran + " | Rp" + String.format("%,.0f", harga);
    }

    // Overloading method tampilkanDetail()
    // Menampilkan detail dasar (tanpa parameter)
    public void tampilkanDetail() {
        System.out.println(this.toString());
    }
    // Menampilkan detail dengan catatan tambahan
    public void tampilkanDetail(String catatan) {
        System.out.println(this.toString() + " | Catatan: " + catatan);
    }

    // FINAL METHOD - tidak bisa di override oleh class turunan 
    public final void infoJenis() {
        System.out.println("Ini adalah menu makanan/minuman.");
    }

    // ABSTRACT METHOD - harus di implementasikan di subclass
    public abstract String getJenisMenu();    

    // Variabel static
    private static double DISKON = 0.1;  // Diskon 10% untuk semua menu
    
    // Method static
    public static double hitungDiskon(double harga) {
        return harga * DISKON;
    }
    
    @Override
    public void displayInfo() {
        System.out.print(id + " | " + nama + " | " + ukuran + " | Rp" + String.format("%,.0f", harga));
    }
    
    @Override
    public void validateData() throws IllegalArgumentException {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama menu tidak boleh kosong");
        }
        if (harga <= 0) {
            throw new IllegalArgumentException("Harga harus lebih dari 0");
        }
    }
}
