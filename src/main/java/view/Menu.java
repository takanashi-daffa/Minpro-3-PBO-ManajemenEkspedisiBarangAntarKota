package view;

public class Menu {

    public void tampilkanMenuUtama() {
        System.out.println("\n=== MENU UTAMA ===");
        System.out.println("1. Tambahkan Data");
        System.out.println("2. Lihat Data");
        System.out.println("3. Ubah Data");
        System.out.println("4. Hapus Data");
        System.out.println("5. Keluar");
    }

    public void tampilkanMenuData() {
        System.out.println("\n=== PILIH DATA ===");
        System.out.println("1. Pelanggan");
        System.out.println("2. Barang");
        System.out.println("3. Pengiriman");
    }
}