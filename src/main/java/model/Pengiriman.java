package model;

public class Pengiriman {
    private String idPengiriman;
    private String idPelanggan;
    private String idBarang;
    private String kotaAsal;
    private String kotaTujuan;
    private String statusPengiriman;

    public Pengiriman(String idPengiriman, String idPelanggan, String idBarang, String kotaAsal, String kotaTujuan, String statusPengiriman) {
        this.idPengiriman = idPengiriman;
        this.idPelanggan = idPelanggan;
        this.idBarang = idBarang;
        this.kotaAsal = kotaAsal;
        this.kotaTujuan = kotaTujuan;
        this.statusPengiriman = statusPengiriman;
    }

    public String getIdPengiriman() {
        return idPengiriman;
    }

    public void setIdPengiriman(String idPengiriman) {
        this.idPengiriman = idPengiriman;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getKotaAsal() {
        return kotaAsal;
    }

    public void setKotaAsal(String kotaAsal) {
        this.kotaAsal = kotaAsal;
    }

    public String getKotaTujuan() {
        return kotaTujuan;
    }

    public void setKotaTujuan(String kotaTujuan) {
        this.kotaTujuan = kotaTujuan;
    }

    public String getStatusPengiriman() {
        return statusPengiriman;
    }

    public void setStatusPengiriman(String statusPengiriman) {
        this.statusPengiriman = statusPengiriman;
    }
}