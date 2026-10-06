package model;

public class PengirimanUdara extends Pengiriman implements LayananPengiriman {

    private String nomorPenerbangan;

    public PengirimanUdara(String idPengiriman, String idPelanggan, String idBarang,
            String kotaAsal, String kotaTujuan, String statusPengiriman,
            String nomorPenerbangan) {

        super(idPengiriman, idPelanggan, idBarang,
                kotaAsal, kotaTujuan, statusPengiriman);

        this.nomorPenerbangan = nomorPenerbangan;
    }

    public String getNomorPenerbangan() {
        return nomorPenerbangan;
    }

    public void setNomorPenerbangan(String nomorPenerbangan) {
        this.nomorPenerbangan = nomorPenerbangan;
    }

    @Override
    public void tampilkanJenisPengiriman() {
        System.out.println("Jenis Pengiriman: Udara");
        System.out.println("Nomor Penerbangan: " + nomorPenerbangan);
    }

    @Override
    public void prosesPengiriman() {
        System.out.println("Pengiriman udara sedang diproses.");
    }
}