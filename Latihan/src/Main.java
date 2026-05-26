import java.util.*;
class Main {
    public static void main(String[] args) {
        Map<String, Buku> koleksi = new HashMap<>();

        koleksi.put("B001", new Buku("B001", "PBO untuk Pemula"));
        koleksi.put("B002", new Buku("B002", "ASD untuk Pemula"));
        koleksi.put("B003", new Buku("B003", "Struktur Data untuk Pemula"));

        Set<Anggota> a = new HashSet<>();
        a.add(new Anggota("A001", "Ade", "Dosen"));
        a.add(new Anggota("A002", "kia", "Mahasiswa"));
        a.add(new Anggota("A003", "Zaki", "Dosen"));
        //test duplikat
        a.add(new Anggota("A003", "Zaki", "Dosen"));

        System.out.println("Jumlah anggota: " + a.size());
        //no 3
        LinkedList<String> antrian = new LinkedList<>();

        List<String[]> test = new ArrayList<>();
        test.add(new String[]{"A002", "B001", "Mahasiswa"});
        test.add(new String[]{"A001", "B002", "Dosen"});
        test.add(new String[]{"A003", "B003", "Dosen"});
        test.add(new String[]{"A002", "B002", "Mahasiswa"});

        for(String[] i : test){
            String idAnggota = i[0];
            String ISBN = i[1];
            String tipe = i[2];
            String key = idAnggota + "#" + ISBN;
            
            if (tipe.equals("Dosen")){
                antrian.addFirst(key);
            } else if (tipe.equals("Mahasiswa")){
                antrian.addLast(key);
            } 
        }

        for (int i = 0; i< antrian.size(); i++){
            System.out.println((i + 1) + ". " + antrian.get(i));
        }
        
        List<Buku> bukuDipinjam = new ArrayList<>();
        while (!antrian.isEmpty()) {
            String dataPeminjaman = antrian.removeFirst();
            String[] bagian  = dataPeminjaman.split("#");
            String idAnggota = bagian[0];
            String isbn      = bagian[1];

            boolean isAnggotaValid = false;
            String namaAnggota = "";
            for (Anggota anggota : a) {
                if (anggota.idAnggota.equals(idAnggota)) {
                    isAnggotaValid = true;
                    namaAnggota = anggota.nama;
                    break;
                }
            }

            boolean isBukuValid = koleksi.containsKey(isbn);

            boolean isSedangDipinjam = false;
            for (Buku b : bukuDipinjam) {
                if (b.ISBN.equals(isbn)) {
                    isSedangDipinjam = true;
                    break;
                }
            }

            if (!isAnggotaValid) {
                System.out.println("Gagal: Anggota dengan ID (" + idAnggota + ") tidak terdaftar.");
            } else if (!isBukuValid) {
                System.out.println("Gagal: Buku dengan ISBN (" + isbn + ") tidak ditemukan di katalog.");
            } else if (isSedangDipinjam) {
                System.out.println("Gagal: Buku '" + koleksi.get(isbn).judul + "' sedang dipinjam oleh orang lain.");
            } else {
                Buku bukuDipinjamItem = koleksi.get(isbn);
                bukuDipinjam.add(bukuDipinjamItem);
                System.out.println("Berhasil: " + namaAnggota + " meminjam buku '" + bukuDipinjamItem.judul + "'.");
            }
        }
        

    }

} 