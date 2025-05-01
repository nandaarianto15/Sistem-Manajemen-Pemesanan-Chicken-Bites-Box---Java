package model;

public interface MenuOperation {
    void displayInfo();  // Method untuk menampilkan informasi menu
    void validateData() throws IllegalArgumentException;  // Method untuk validasi data dengan throws exception
    double getHarga();
}