package model;

public class Barang {

    private String idBarang;
    private String namaBarang;
    private String jenisBarang;
    private double berat;

    public Barang(String idBarang, String namaBarang, String jenisBarang, double berat) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.jenisBarang = jenisBarang;
        this.berat = berat;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public double getBerat() {
        return berat;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }
}