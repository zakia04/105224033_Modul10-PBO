import java.util.*;
public class Main {
    public static void main(String[] args) {
        Map<String, JadwalFilm> Jadwal = new HashMap<>();
        Jadwal.put("F01", new JadwalFilm("Spiderman", 50000));
        Jadwal.put("F02", new JadwalFilm("Batman", 45000));
        Jadwal.put("F03", new JadwalFilm("Superman", 55000));

        Set<String> KursiBooked = new HashSet<>();

        List<Transaksi> Trans = new ArrayList<>();

        pesan(Trans, KursiBooked, Jadwal, "Kia", "F01", "A1"); 
        pesan(Trans, KursiBooked, Jadwal, "Kei", "F02", "B2"); 
        pesan(Trans, KursiBooked, Jadwal, "Rio", "F03", "C3"); 
        pesan(Trans, KursiBooked, Jadwal, "Dio", "F01", "A1"); 
        
        for(int i = 0; i < Trans.size(); i++) {
            System.out.println("===== Transaksi " + (i+1) + " =====");
            Trans.get(i).cetakPemesanan();
        }
    }
    static void pesan(List<Transaksi> Trans, Set<String> KursiBooked, Map<String, JadwalFilm> Jadwal, String namaPemesan, String kodeFilm, String nomorKursi) {
        JadwalFilm film = Jadwal.get(kodeFilm);
        if (film == null) {
            System.out.println("Kode film tidak ditemukan.");
            return;
        }
        if(!KursiBooked.add(nomorKursi)) {
            System.out.println("Kursi " + nomorKursi + " sudah dipesan.");
            return;
        }
        
        Trans.add(new Transaksi(namaPemesan, film, nomorKursi));
        System.out.println("Tiket berhasil dipesan." );
    
    }
}
