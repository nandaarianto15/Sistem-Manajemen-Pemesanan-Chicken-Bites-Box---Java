import model.Menu;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<Menu> daftarMenu = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextId = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Sistem Manajemen Chicken Bites Box ===");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Tampilkan Menu");
            System.out.println("3. Perbarui Menu");
            System.out.println("4. Hapus Menu");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            
            int pilihan;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid!");
                continue;
            }

            switch (pilihan) {
                case 1:
                    tambahMenu();
                    break;
                case 2:
                    tampilkanMenu();
                    break;
                case 3:
                    perbaruiMenu();
                    break;
                case 4:
                    hapusMenu();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem ini!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    // Menggunakan Setter untuk mengisi data objek Menu
    private static void tambahMenu() {
        clearScreen();
        System.out.println("\n=== Tambah Menu ===");

        System.out.print("Masukkan Nama Menu: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan Ukuran (Small/Medium/Large): ");
        String ukuran = scanner.nextLine();

        System.out.print("Masukkan Harga: ");
        double harga;
        try {
            harga = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Harga harus berupa angka!");
            return;
        }

        Menu menu = new Menu(nextId++, nama, ukuran, harga);
        daftarMenu.add(menu);
        System.out.println("Menu berhasil ditambahkan!");
    }

    // Menggunakan Getter untuk menampilkan informasi menu
    private static void tampilkanMenu() {
        clearScreen();
        System.out.println("\n=== Daftar Menu ===");
        if (daftarMenu.isEmpty()) {
            System.out.println("Belum ada menu yang tersedia.");
        } else {
            for (Menu menu : daftarMenu) {
                System.out.println(menu);
            }
        }
    }

    private static void perbaruiMenu() {
        clearScreen();
        tampilkanMenu();
        System.out.print("\nMasukkan ID Menu yang ingin diperbarui: ");
        
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID harus berupa angka!");
            return;
        }

        for (Menu menu : daftarMenu) {
            if (menu.getId() == id) {
                System.out.print("Masukkan Nama Baru: ");
                menu.setNama(scanner.nextLine()); // Menggunakan Setter untuk memperbarui nama

                System.out.print("Masukkan Ukuran Baru: ");
                menu.setUkuran(scanner.nextLine()); // Menggunakan Setter untuk memperbarui ukuran

                System.out.print("Masukkan Harga Baru: ");
                try {
                    menu.setHarga(Double.parseDouble(scanner.nextLine())); // Menggunakan Setter untuk memperbarui harga
                } catch (NumberFormatException e) {
                    System.out.println("Harga harus berupa angka!");
                    return;
                }

                System.out.println("Menu berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Menu dengan ID tersebut tidak ditemukan.");
    }

    private static void hapusMenu() {
        clearScreen();
        tampilkanMenu();
        System.out.print("\nMasukkan ID Menu yang ingin dihapus: ");
        
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID harus berupa angka!");
            return;
        }

        for (Menu menu : daftarMenu) {
            if (menu.getId() == id) {
                daftarMenu.remove(menu);
                System.out.println("Menu berhasil dihapus!");
                return;
            }
        }
        System.out.println("Menu dengan ID tersebut tidak ditemukan.");
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Tidak dapat membersihkan layar.");
        }
    }
}
