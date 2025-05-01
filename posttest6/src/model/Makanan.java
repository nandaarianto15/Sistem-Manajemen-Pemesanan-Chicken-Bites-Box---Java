package model;

public class Makanan extends Menu {
    private String bumbuBubuk;

    public Makanan(int id, String nama, String ukuran, double harga, String bumbuBubuk) {
        super(id, nama, ukuran, harga); // Memanggil konstruktor dari class Menu
        this.bumbuBubuk = bumbuBubuk;
    }

    public String getBumbuBubuk() {
        return bumbuBubuk;
    }

    public void setBumbuBubuk(String bumbuBubuk) {
        this.bumbuBubuk = bumbuBubuk; // Setter untuk update bumbu
    }

    @Override
    public String toString() {
        return super.toString() + " | Bumbu: " + bumbuBubuk;
    }

    @Override
    public String getJenisMenu() {
        return "Makanan";
    }

    @Override
    public void validateData() throws IllegalArgumentException {
        super.validateData();  // Panggil validasi dari parent class
        if (bumbuBubuk == null || bumbuBubuk.trim().isEmpty()) {
            throw new IllegalArgumentException("Bumbu tidak boleh kosong");
        }
    }
}