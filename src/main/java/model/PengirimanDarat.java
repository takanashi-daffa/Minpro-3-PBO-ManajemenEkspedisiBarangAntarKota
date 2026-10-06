package model;

public class PengirimanDarat extends Pengiriman implements LayananPengiriman {

    private String jenisKendaraan;

    public PengirimanDarat(String idPengiriman, String idPelanggan, String idBarang,
            String kotaAsal, String kotaTujuan, String statusPengiriman,
            String jenisKendaraan) {

        super(idPengiriman, idPelanggan, idBarang,
                kotaAsal, kotaTujuan, statusPengiriman);

        this.jenisKendaraan = jenisKendaraan;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    @Override
    public void tampilkanJenisPengiriman() {
        System.out.println("Jenis Pengiriman: Darat");
        System.out.println("Jenis Kendaraan: " + jenisKendaraan);
    }

    @Override
    public void prosesPengiriman() {
        System.out.println("Pengiriman darat sedang diproses.");
    }
}