public class Main {
    public static void main(String[] args) {
        SistemGudang gudang = new SistemGudang();
        Barang barang1 = new Barang("B001", "Laptop", "Elektronik", 10);
        Barang barang2 = new Barang("B002", "Meja", "Furniture", 20);
        Barang barang3 = new Barang("B003", "Kursi", "Furniture", 15);
        gudang.tambahBarangBaru(barang1);
        gudang.tambahBarangBaru(barang2);
        gudang.tambahBarangBaru(barang3);
        gudang.tambahStok("B001", 5);
        gudang.kurangiStok("B002", 2);
        gudang.kurangiStok("B003", 20); 
        gudang.cetakLaporan();        
    }
}
