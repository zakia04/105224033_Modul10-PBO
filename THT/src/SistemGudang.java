import java.util.*;
public class SistemGudang {
    Map<String, Barang> gudang = new HashMap<>();
    Set<String> kategori = new HashSet<>();
    List<String> riwayat = new ArrayList<>();
    public void tambahBarangBaru(Barang barang) {
        gudang.put(barang.idBarang, barang);
        kategori.add(barang.kategori);
    }
    public void tambahStok(String idBarang, int jumlah) {
        riwayat.add("Barang masuk: " + idBarang + " ditambah " + jumlah + " unit.");
        if (gudang.containsKey(idBarang)) {
            Barang barang = gudang.get(idBarang);
            barang.stok += jumlah;
        } else {
            System.out.println("Barang dengan ID " + idBarang + " tidak ditemukan.");
        }
    }
    public void kurangiStok(String idBarang, int jumlah) {
        if (gudang.containsKey(idBarang)) {
            Barang barang = gudang.get(idBarang);
            if (barang.stok >= jumlah) {
                barang.stok -= jumlah;
            } else {
                System.out.println("Stok tidak cukup untuk mengurangi " + jumlah + " dari " + barang.namaBarang);
            }
        } else {
            System.out.println("Barang dengan ID " + idBarang + " tidak ditemukan.");
        }
    }
    public void cetakLaporan() {
        for (String i : gudang.keySet()) {
            Barang barang = gudang.get(i);
            System.out.println("Kategori: " + barang.kategori + ", Sisa Stok: " + barang.stok + ", " + riwayat.get(0));
        }
    }   
}
