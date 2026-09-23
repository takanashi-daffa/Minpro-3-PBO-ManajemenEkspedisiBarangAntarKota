package model;

public class PengirimanUdara extends Pengiriman {

    public PengirimanUdara(String idPengiriman, String idPelanggan, String idBarang,
            String kotaAsal, String kotaTujuan, String statusPengiriman) {

        super(idPengiriman, idPelanggan, idBarang,
                kotaAsal, kotaTujuan, statusPengiriman);
    }
}