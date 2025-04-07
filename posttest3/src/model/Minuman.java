package model;

public class Minuman extends Menu {
    private boolean isDingin;

    public Minuman(int id, String nama, String ukuran, double harga) {
        super(id, nama, ukuran, harga); // Memanggil konstruktor dari class Menu
        this.isDingin = true;
    }

    public boolean isDingin() {
        return isDingin;
    }

    public String toString() {
        return super.toString() + " | Dingin: " + (isDingin ? "Iya" : "Tidak");
    }
}
