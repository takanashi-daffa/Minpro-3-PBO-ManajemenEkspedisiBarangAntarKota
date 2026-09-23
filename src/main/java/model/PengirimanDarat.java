package model;

public class PengirimanDarat extends Pengiriman {

    public PengirimanDarat(String idPengiriman, String idPelanggan, String idBarang,
            String kotaAsal, String kotaTujuan, String statusPengiriman) {

        super(idPengiriman, idPelanggan, idBarang,
                kotaAsal, kotaTujuan, statusPengiriman);
    }
}