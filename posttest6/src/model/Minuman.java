package model;

public class Minuman extends Menu {
    private boolean isDingin;

    public Minuman(int id, String nama, String ukuran, double harga, boolean isDingin) {
        super(id, nama, ukuran, harga); // Memanggil konstruktor dari class Menu
        this.isDingin = isDingin;
    }

    public boolean isDingin() {
        return isDingin;
    }

    // Override
    @Override
    public String toString() {
        return super.toString() + " | Dingin: " + (isDingin ? "Iya" : "Tidak");
    }

    @Override
    public String getJenisMenu() {
        return "Minuman";
    }

    @Override
    public void validateData() throws IllegalArgumentException {
        super.validateData();  // Panggil validasi dari parent class
    }
}