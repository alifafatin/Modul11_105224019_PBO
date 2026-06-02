
class KopiHabisException extends RuntimeException {
    public KopiHabisException(String pesan) {
        super(pesan);
    }
}

class Pelanggan {
    private String nama;
    private int stokKopi = 5; 
    
    public Pelanggan(String nama) {
        this.nama = nama;
    }
    
    public void pesanKopi(int jumlahPesanan) {
        if (jumlahPesanan > stokKopi) {
            throw new KopiHabisException("Maaf, stok kopi hanya " + stokKopi + " gelas. Anda pesan " + jumlahPesanan);
        }
        stokKopi -= jumlahPesanan;
        System.out.println(nama + " berhasil memesan " + jumlahPesanan + " gelas. Sisa stok: " + stokKopi);
    }
}