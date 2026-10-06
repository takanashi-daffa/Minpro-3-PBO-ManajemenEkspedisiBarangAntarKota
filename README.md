# Mini Project 3 PBO - Manajemen Ekspedisi Barang Antar Kota

Nama: Daffa Arkhabista

NIM: 2509116018

## Deskripsi Singkat Program

Program ini dibuat untuk mengelola data ekspedisi barang antar kota. Data yang dikelola terdiri dari data pelanggan, barang, dan pengiriman.

Program memiliki fitur CRUD (Create, Read, Update, Delete), sehingga pengguna dapat menambah, melihat, mengubah, dan menghapus data. Pada data pengiriman terdapat dua jenis pengiriman, yaitu pengiriman darat dan pengiriman udara.

## Struktur Package

Struktur package yang digunakan dalam program:

```text
controller
└── PengelolaEkspedisi.java

main
└── MinproPBO.java

model
├── Barang.java
├── LayananPengiriman.java
├── Pelanggan.java
├── Pengiriman.java
├── PengirimanDarat.java
└── PengirimanUdara.java

view
└── Menu.java
```

## Alur Program

Saat program dijalankan, `MinproPBO` menjalankan `PengelolaEkspedisi`, kemudian pengguna masuk ke menu utama.

**Menu Utama → Tambahkan Data / Lihat Data / Ubah Data / Hapus Data / Keluar**

Pada menu tambah, pengguna dapat memilih data pelanggan, barang, atau pengiriman. Untuk pengiriman, pengguna dapat memilih jenis pengiriman darat atau udara.

Program akan terus berjalan sampai pengguna memilih menu `Keluar`.

## Penerapan Encapsulation

Encapsulation diterapkan dengan membuat atribut pada class model menjadi `private` dan menggunakan getter serta setter untuk mengakses atau mengubah data.

Contohnya pada `Pelanggan.java`:

```java
private String idPelanggan;
private String nama;
private String noTelepon;
private String alamat;
```

Getter dan setter digunakan untuk mengakses dan mengubah atribut tersebut:

```java
public String getNama() {
    return nama;
}

public void setNama(String nama) {
    this.nama = nama;
}
```

Penerapan yang sama juga terdapat pada class `Barang` dan `Pengiriman`.

## Penerapan Inheritance

Inheritance diterapkan pada class `PengirimanDarat` dan `PengirimanUdara` yang merupakan turunan dari class `Pengiriman`.

```java
public class PengirimanDarat extends Pengiriman
```

```java
public class PengirimanUdara extends Pengiriman
```

Kedua subclass menggunakan data dan method dari `Pengiriman` serta memiliki atribut tambahan masing-masing.

`PengirimanDarat` memiliki:

```java
private String jenisKendaraan;
```

Sedangkan `PengirimanUdara` memiliki:

```java
private String nomorPenerbangan;
```

## Penerapan Polymorphism

Polymorphism diterapkan melalui overriding dan overloading.

### Overriding

Overriding diterapkan pada method `tampilkanJenisPengiriman()`.

Pada class `Pengiriman` terdapat abstract method:

```java
public abstract void tampilkanJenisPengiriman();
```

Method tersebut kemudian diimplementasikan pada `PengirimanDarat`:

```java
@Override
public void tampilkanJenisPengiriman() {
    System.out.println("Jenis Pengiriman: Darat");
    System.out.println("Jenis Kendaraan: " + jenisKendaraan);
}
```

Dan pada `PengirimanUdara`:

```java
@Override
public void tampilkanJenisPengiriman() {
    System.out.println("Jenis Pengiriman: Udara");
    System.out.println("Nomor Penerbangan: " + nomorPenerbangan);
}
```

### Overloading

Overloading diterapkan pada method `cariPengiriman()` di `PengelolaEkspedisi`.

Method pertama menggunakan satu parameter:

```java
Pengiriman cariPengiriman(String idPengiriman)
```

Sedangkan method kedua menggunakan dua parameter:

```java
Pengiriman cariPengiriman(String kotaAsal, String kotaTujuan)
```

Kedua method memiliki nama yang sama tetapi parameter yang berbeda.

## Penerapan Abstraction

Abstraction diterapkan menggunakan abstract class dan abstract method pada class `Pengiriman`.

### Abstract Class

Class `Pengiriman` dibuat sebagai abstract class:

```java
public abstract class Pengiriman {
```

Class tersebut menjadi dasar untuk `PengirimanDarat` dan `PengirimanUdara`.

### Abstract Method

Pada class `Pengiriman` terdapat abstract method:

```java
public abstract void tampilkanJenisPengiriman();
```

Method tersebut tidak memiliki isi pada class `Pengiriman` dan kemudian diimplementasikan oleh subclass menggunakan `@Override`.

## Penerapan MVC

Program menggunakan struktur MVC untuk memisahkan bagian data, tampilan, dan proses program.

**Model →** `Pelanggan`, `Barang`, `Pengiriman`, `PengirimanDarat`, `PengirimanUdara`, dan `LayananPengiriman`  
Berisi class yang berkaitan dengan data dan objek dalam program.

**View →** `Menu`  
Digunakan untuk menampilkan menu kepada pengguna.

**Controller →** `PengelolaEkspedisi`  
Mengatur proses utama program, seperti menerima input dan menjalankan proses CRUD.

**Main →** `MinproPBO`  
Menjadi titik awal program dan menjalankan `PengelolaEkspedisi`.

Hubungan antarbagian secara sederhana:

**Main → Controller → Model**  
**Controller → View**

## Value-Add: Interface

Interface digunakan sebagai value-add pada program. Interface yang digunakan adalah `LayananPengiriman`.

```java
public interface LayananPengiriman {

    void prosesPengiriman();

}
```

Interface tersebut diimplementasikan oleh `PengirimanDarat` dan `PengirimanUdara`.

```java
public class PengirimanDarat extends Pengiriman implements LayananPengiriman
```

```java
public class PengirimanUdara extends Pengiriman implements LayananPengiriman
```

Keduanya memiliki implementasi `prosesPengiriman()` masing-masing.

Dengan adanya interface, `PengirimanDarat` dan `PengirimanUdara` memiliki method `prosesPengiriman()` sesuai dengan jenis pengirimannya.
