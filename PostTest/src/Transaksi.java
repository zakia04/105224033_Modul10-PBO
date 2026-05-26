class Transaksi {
    String namaPemesan;
    JadwalFilm film;
    String kursi;
    Transaksi(String namaPemesan, JadwalFilm film, String kursi) {
        this.namaPemesan = namaPemesan;
        this.film = film;
        this.kursi = kursi;
    }

    public void cetakPemesanan() {
        System.out.println("Nama Pemesan: " + namaPemesan);
        System.out.println("Film        : " + film.judul);
        System.out.println("Harga Tiket : " + film.hargaTiket);
        System.out.println("Nomor Kursi : " + kursi);
    } 
}
