package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Pelanggan;
import model.Barang;
import model.Pengiriman;
import model.PengirimanDarat;
import model.PengirimanUdara;
import view.Menu;

public class PengelolaEkspedisi {

    private final Scanner scanner = new Scanner(System.in);

    private final ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    private final ArrayList<Barang> daftarBarang = new ArrayList<>();
    private final ArrayList<Pengiriman> daftarPengiriman = new ArrayList<>();

    private final Menu menu = new Menu();

    public PengelolaEkspedisi() {

        daftarPelanggan.add(new Pelanggan(
                "PPU1024",
                "A",
                "081234567890",
                "Penajam"));

        daftarBarang.add(new Barang(
                "BRG2048",
                "B",
                "Elektronik",
                2.5));

        daftarPengiriman.add(new PengirimanDarat(
                "KRM3072",
                "PPU1024",
                "BRG2048",
                "Penajam",
                "Balikpapan",
                "Diproses",
                "Truk"));
    }

    public void jalankanProgram() {

        int pilihan = 0;

        do {
            menu.tampilkanMenuUtama();

            try {

                System.out.print("Pilih Menu (1-5): ");
                pilihan = scanner.nextInt();
                scanner.nextLine();

                if (pilihan < 1 || pilihan > 5) {
                    System.out.println("Pilihan tidak valid!");
                    continue;
                }

                switch (pilihan) {

                    case 1:
                        tambahData();
                        break;

                    case 2:
                        lihatData();
                        break;

                    case 3:
                        ubahData();
                        break;

                    case 4:
                        hapusData();
                        break;

                    case 5:
                        System.out.println("Program selesai.");
                        break;
                }

            } catch (Exception e) {

                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }

        } while (pilihan != 5);

        scanner.close();
    }

    void tambahData() {

        menu.tampilkanMenuData();

        try {

            System.out.print("Pilih Data: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {

                case 1:

                    System.out.print("ID Pelanggan: ");
                    String idPelanggan = scanner.nextLine();

                    if (idPelangganSudahAda(idPelanggan)) {
                        System.out.println("ID Pelanggan sudah digunakan!");
                        return;
                    }

                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();

                    System.out.print("No Telepon: ");
                    String noTelepon = scanner.nextLine();

                    System.out.print("Alamat: ");
                    String alamat = scanner.nextLine();

                    daftarPelanggan.add(new Pelanggan(
                            idPelanggan,
                            nama,
                            noTelepon,
                            alamat));

                    System.out.println("Data pelanggan berhasil ditambahkan.");
                    break;

                case 2:

                    System.out.print("ID Barang: ");
                    String idBarang = scanner.nextLine();

                    if (barangSudahAda(idBarang)) {
                        System.out.println("ID Barang sudah digunakan!");
                        return;
                    }

                    System.out.print("Nama Barang: ");
                    String namaBarang = scanner.nextLine();

                    System.out.print("Jenis Barang: ");
                    String jenisBarang = scanner.nextLine();

                    System.out.print("Berat (ton): ");
                    double berat = scanner.nextDouble();
                    scanner.nextLine();

                    if (berat <= 0) {
                        System.out.println("Berat harus lebih dari 0!");
                        return;
                    }

                    daftarBarang.add(new Barang(
                            idBarang,
                            namaBarang,
                            jenisBarang,
                            berat));

                    System.out.println("Data barang berhasil ditambahkan.");
                    break;

                case 3:

                    System.out.println("1. Pengiriman Darat");
                    System.out.println("2. Pengiriman Udara");

                    System.out.print("Pilih Jenis Pengiriman: ");
                    int jenisPengiriman = scanner.nextInt();
                    scanner.nextLine();

                    if (jenisPengiriman < 1 || jenisPengiriman > 2) {
                        System.out.println("Pilihan tidak valid!");
                        return;
                    }

                    System.out.print("ID Pengiriman: ");
                    String idPengiriman = scanner.nextLine();

                    if (pengirimanSudahAda(idPengiriman)) {
                        System.out.println("ID Pengiriman sudah digunakan!");
                        return;
                    }

                    System.out.print("ID Pelanggan: ");
                    String idPelangganKirim = scanner.nextLine();

                    if (!idPelangganSudahAda(idPelangganKirim)) {
                        System.out.println("ID Pelanggan tidak ditemukan!");
                        return;
                    }

                    System.out.print("ID Barang: ");
                    String idBarangKirim = scanner.nextLine();

                    if (!barangSudahAda(idBarangKirim)) {
                        System.out.println("ID Barang tidak ditemukan!");
                        return;
                    }

                    System.out.print("Kota Asal: ");
                    String kotaAsal = scanner.nextLine();

                    System.out.print("Kota Tujuan: ");
                    String kotaTujuan = scanner.nextLine();

                    System.out.print("Status Pengiriman: ");
                    String statusPengiriman = scanner.nextLine();

                    if (jenisPengiriman == 1) {

                        System.out.print("Jenis Kendaraan: ");
                        String jenisKendaraan = scanner.nextLine();

                        daftarPengiriman.add(new PengirimanDarat(
                                idPengiriman,
                                idPelangganKirim,
                                idBarangKirim,
                                kotaAsal,
                                kotaTujuan,
                                statusPengiriman,
                                jenisKendaraan));

                    } else {

                        System.out.print("Nomor Penerbangan: ");
                        String nomorPenerbangan = scanner.nextLine();

                        daftarPengiriman.add(new PengirimanUdara(
                                idPengiriman,
                                idPelangganKirim,
                                idBarangKirim,
                                kotaAsal,
                                kotaTujuan,
                                statusPengiriman,
                                nomorPenerbangan));
                    }

                    System.out.println("Data pengiriman berhasil ditambahkan.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } catch (Exception e) {

            System.out.println("Input tidak valid!");
            scanner.nextLine();
        }
    }

    void lihatData() {

        menu.tampilkanMenuData();

        try {

            System.out.print("Pilih Data: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {

                case 1:

                    for (Pelanggan p : daftarPelanggan) {

                        System.out.println("ID Pelanggan: " + p.getIdPelanggan());
                        System.out.println("Nama: " + p.getNama());
                        System.out.println("No Telepon: " + p.getNoTelepon());
                        System.out.println("Alamat: " + p.getAlamat());
                        System.out.println();
                    }

                    break;

                case 2:

                    for (Barang b : daftarBarang) {

                        System.out.println("ID Barang: " + b.getIdBarang());
                        System.out.println("Nama Barang: " + b.getNamaBarang());
                        System.out.println("Jenis Barang: " + b.getJenisBarang());
                        System.out.println("Berat: " + b.getBerat() + " ton");
                        System.out.println();
                    }

                    break;

                case 3:

                    for (Pengiriman p : daftarPengiriman) {

                        System.out.println("ID Pengiriman: " + p.getIdPengiriman());
                        System.out.println("ID Pelanggan: " + p.getIdPelanggan());
                        System.out.println("ID Barang: " + p.getIdBarang());
                        System.out.println("Kota Asal: " + p.getKotaAsal());
                        System.out.println("Kota Tujuan: " + p.getKotaTujuan());
                        System.out.println("Status Pengiriman: " + p.getStatusPengiriman());

                        p.tampilkanJenisPengiriman();

                        System.out.println();
                    }

                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } catch (Exception e) {

            System.out.println("Input tidak valid!");
            scanner.nextLine();
        }
    }

    void ubahData() {

        menu.tampilkanMenuData();

        try {

            System.out.print("Pilih Data: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {

                System.out.print("Masukkan ID Pelanggan: ");
                String id = scanner.nextLine();

                for (Pelanggan p : daftarPelanggan) {

                    if (p.getIdPelanggan().equals(id)) {

                        System.out.print("Nama: ");
                        p.setNama(scanner.nextLine());

                        System.out.print("No Telepon: ");
                        p.setNoTelepon(scanner.nextLine());

                        System.out.print("Alamat: ");
                        p.setAlamat(scanner.nextLine());

                        System.out.println("Data pelanggan berhasil diubah.");
                        return;
                    }
                }

            } else if (pilihan == 2) {

                System.out.print("Masukkan ID Barang: ");
                String id = scanner.nextLine();

                for (Barang b : daftarBarang) {

                    if (b.getIdBarang().equals(id)) {

                        System.out.print("Nama Barang: ");
                        b.setNamaBarang(scanner.nextLine());

                        System.out.print("Jenis Barang: ");
                        b.setJenisBarang(scanner.nextLine());

                        System.out.print("Berat (ton): ");
                        double berat = scanner.nextDouble();
                        scanner.nextLine();

                        if (berat <= 0) {
                            System.out.println("Berat harus lebih dari 0!");
                            return;
                        }

                        b.setBerat(berat);

                        System.out.println("Data barang berhasil diubah.");
                        return;
                    }
                }

            } else if (pilihan == 3) {

                System.out.print("Masukkan ID Pengiriman: ");
                String id = scanner.nextLine();

                for (Pengiriman p : daftarPengiriman) {

                    if (p.getIdPengiriman().equals(id)) {

                        System.out.print("Kota Asal: ");
                        p.setKotaAsal(scanner.nextLine());

                        System.out.print("Kota Tujuan: ");
                        p.setKotaTujuan(scanner.nextLine());

                        System.out.print("Status Pengiriman: ");
                        p.setStatusPengiriman(scanner.nextLine());

                        System.out.println("Data pengiriman berhasil diubah.");
                        return;
                    }
                }

            } else {

                System.out.println("Pilihan tidak tersedia.");
                return;
            }

            System.out.println("Data tidak ditemukan.");

        } catch (Exception e) {

            System.out.println("Input tidak valid!");
            scanner.nextLine();
        }
    }

    void hapusData() {

        menu.tampilkanMenuData();

        try {

            System.out.print("Pilih Data: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Masukkan ID: ");
            String id = scanner.nextLine();

            if (pilihan == 1) {

                for (int i = 0; i < daftarPelanggan.size(); i++) {

                    if (daftarPelanggan.get(i).getIdPelanggan().equals(id)) {

                        daftarPelanggan.remove(i);

                        System.out.println("Data pelanggan berhasil dihapus.");
                        return;
                    }
                }

            } else if (pilihan == 2) {

                for (int i = 0; i < daftarBarang.size(); i++) {

                    if (daftarBarang.get(i).getIdBarang().equals(id)) {

                        daftarBarang.remove(i);

                        System.out.println("Data barang berhasil dihapus.");
                        return;
                    }
                }

            } else if (pilihan == 3) {

                for (int i = 0; i < daftarPengiriman.size(); i++) {

                    if (daftarPengiriman.get(i).getIdPengiriman().equals(id)) {

                        daftarPengiriman.remove(i);

                        System.out.println("Data pengiriman berhasil dihapus.");
                        return;
                    }
                }

            } else {

                System.out.println("Pilihan tidak tersedia.");
                return;
            }

            System.out.println("Data tidak ditemukan.");

        } catch (Exception e) {

            System.out.println("Input tidak valid!");
            scanner.nextLine();
        }
    }

    boolean idPelangganSudahAda(String id) {

        for (Pelanggan p : daftarPelanggan) {

            if (p.getIdPelanggan().equals(id)) {
                return true;
            }
        }

        return false;
    }

    boolean barangSudahAda(String id) {

        for (Barang b : daftarBarang) {

            if (b.getIdBarang().equals(id)) {
                return true;
            }
        }

        return false;
    }

    boolean pengirimanSudahAda(String id) {

        for (Pengiriman p : daftarPengiriman) {

            if (p.getIdPengiriman().equals(id)) {
                return true;
            }
        }

        return false;
    }

    Pengiriman cariPengiriman(String idPengiriman) {

        for (Pengiriman p : daftarPengiriman) {

            if (p.getIdPengiriman().equals(idPengiriman)) {
                return p;
            }
        }

        return null;
    }

    Pengiriman cariPengiriman(String kotaAsal, String kotaTujuan) {

        for (Pengiriman p : daftarPengiriman) {

            if (p.getKotaAsal().equals(kotaAsal)
                    && p.getKotaTujuan().equals(kotaTujuan)) {

                return p;
            }
        }

        return null;
    }
}