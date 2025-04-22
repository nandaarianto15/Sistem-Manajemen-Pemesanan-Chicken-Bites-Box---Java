import model.Makanan;
import model.Menu;
import model.Minuman;
import model.Pesanan;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<Menu> daftarMenu = new ArrayList<>();
    private static ArrayList<Pesanan> daftarPesanan = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextIdMenu = 1;
    private static int nextIdPesanan = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Selamat Datang di Chicken Bites Box ===");
            System.out.println("1. Admin");
            System.out.println("2. Pesan");
            System.out.print("Pilih: ");
            String opsi = scanner.nextLine();

            switch (opsi) {
                case "1":
                    if (loginAdmin()) {
                        menuAdmin();
                    }
                    break;
                case "2":
                    prosesPesanan();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static boolean loginAdmin() {
        System.out.print("Masukkan Username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine();

        if (username.equals("admin123") && password.equals("admin123")) {
            System.out.println("Login berhasil.");
            return true;
        } else {
            System.out.println("Username atau password salah!");
            return false;
        }
    }

    private static void menuAdmin() {
        while (true) {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Tampilkan Menu");
            System.out.println("3. Perbarui Menu");
            System.out.println("4. Hapus Menu");
            System.out.println("5. Lihat Semua Pesanan");
            System.out.println("6. Keluar Admin");
            System.out.print("Pilih menu: ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    tambahMenu();
                    break;
                case "2":
                    tampilkanMenu();
                    break;
                case "3":
                    perbaruiMenu();
                    break;
                case "4":
                    hapusMenu();
                    break;
                case "5":
                    tampilkanSemuaPesanan();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void tambahMenu() {
        System.out.println("\n=== Tambah Menu ===");
        System.out.println("1. Makanan");
        System.out.println("2. Minuman");
        System.out.print("Pilihan: ");
        int jenis;
        try {
            jenis = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Masukkan angka yang valid!");
            return;
        }

        System.out.print("Masukkan Nama Menu: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan Ukuran (Small/Large): ");
        String ukuran = scanner.nextLine();

        System.out.print("Masukkan Harga: ");
        double harga;
        try {
            harga = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Harga harus berupa angka!");
            return;
        }

        if (jenis == 1) {
            System.out.print("Masukkan Bumbu Bubuk: ");
            String bumbu = scanner.nextLine();
            daftarMenu.add(new Makanan(nextIdMenu++, nama, ukuran, harga, bumbu));
        } else if (jenis == 2) {
            System.out.print("Apakah dingin? (ya/tidak): ");
            String jawaban = scanner.nextLine();
            boolean dingin = jawaban.equalsIgnoreCase("ya");
            daftarMenu.add(new Minuman(nextIdMenu++, nama, ukuran, harga, dingin));
        } else {
            System.out.println("Jenis menu tidak valid!");
            return;
        }

        System.out.println("Menu berhasil ditambahkan!");
    }

    private static void tampilkanMenu() {
        System.out.println("\n=== Daftar Menu ===");
        if (daftarMenu.isEmpty()) {
            System.out.println("Belum ada menu.");
        } else {
            for (Menu menu : daftarMenu) {
                String jenis = (menu instanceof Makanan) ? "Makanan" : "Minuman";
                String detail = "Jenis: " + jenis + " | " + menu.getId() + " | " + menu.getNama() + " | " + menu.getUkuran()
                        + " | Rp" + String.format("%,.0f", menu.getHarga());
    
                if (menu instanceof Makanan) {
                    Makanan mkn = (Makanan) menu;
                    detail += " | Bumbu: " + mkn.getBumbuBubuk();
                } else if (menu instanceof Minuman) {
                    Minuman mnm = (Minuman) menu;
                    detail += " | Dingin: " + (mnm.isDingin() ? "Iya" : "Tidak");
                }
    
                if (menu.getHarga() > 30000) {
                    detail += " | Catatan: Menu premium";
                }
    
                System.out.println(detail);
            }
        }
    }
    

    private static void perbaruiMenu() {
        tampilkanMenu();
        System.out.print("\nMasukkan ID Menu yang ingin diperbarui: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Menu menu : daftarMenu) {
            if (menu.getId() == id) {
                System.out.print("Masukkan Nama Baru: ");
                menu.setNama(scanner.nextLine());

                System.out.print("Masukkan Ukuran Baru: ");
                menu.setUkuran(scanner.nextLine());

                System.out.print("Masukkan Harga Baru: ");
                menu.setHarga(Double.parseDouble(scanner.nextLine()));

                if (menu instanceof Makanan) {
                    System.out.print("Masukkan Bumbu Baru: ");
                    ((Makanan) menu).setBumbuBubuk(scanner.nextLine());
                }

                System.out.println("Menu berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Menu tidak ditemukan.");
    }

    private static void hapusMenu() {
        tampilkanMenu();
        System.out.print("\nMasukkan ID Menu yang ingin dihapus: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Menu menu : daftarMenu) {
            if (menu.getId() == id) {
                daftarMenu.remove(menu);
                System.out.println("Menu berhasil dihapus!");
                return;
            }
        }
        System.out.println("Menu tidak ditemukan.");
    }

    private static void prosesPesanan() {
        tampilkanMenu();
        if (daftarMenu.isEmpty()) {
            System.out.println("Belum ada menu untuk dipesan.");
            return;
        }

        System.out.println("\n=== Form Pemesanan ===");
        System.out.print("Masukkan Nomor Telepon: ");
        String telp = scanner.nextLine();

        System.out.print("Masukkan Email: ");
        String email = scanner.nextLine();

        System.out.print("Masukkan ID Menu yang dipesan: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Masukkan Jumlah Pesanan: ");
        int jumlah = Integer.parseInt(scanner.nextLine());

        for (Menu menu : daftarMenu) {
            if (menu.getId() == id) {
                daftarPesanan.add(new Pesanan(nextIdPesanan++, telp, email, menu, jumlah));
                System.out.println("Pesanan berhasil dibuat!");
                return;
            }
        }

        System.out.println("ID Menu tidak ditemukan.");
    }

    private static void tampilkanSemuaPesanan() {
        System.out.println("\n=== Daftar Semua Pesanan ===");
        if (daftarPesanan.isEmpty()) {
            System.out.println("Belum ada pesanan.");
        } else {
            for (Pesanan p : daftarPesanan) {
                System.out.println(p);
            }
        }
    }
}
