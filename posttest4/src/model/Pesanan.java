package model;

public class Pesanan {
    private int id;
    private String telp;
    private String email;
    private Menu menu;
    private int jumlah;

    public Pesanan(int id, String telp, String email, Menu menu, int jumlah) {
        this.id = id;
        this.telp = telp;
        this.email = email;
        this.menu = menu;
        this.jumlah = jumlah;
    }

    @Override
    public String toString() {
        return "ID Pesanan: " + id +
               " | Telp: " + telp +
               " | Email: " + email +
               " | Menu: " + menu.getNama() +
               " | Jumlah: " + jumlah +
               " | Total: Rp" + String.format("%,.0f", jumlah * menu.getHarga());
    }
}