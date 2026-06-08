//membawa informasi tambahan sepeerti nama kereta dan sisa kursi
public class TiketHabisException extends Exception {
    private String namaKereta; //simpan nama kereta
    private int sisaKursi; //simpan sisa kursi
    public TiketHabisException(String pesan, String namaKereta, int sisaKursi) {
        super(pesan); //kirim pesan ke Exception
        this.namaKereta = namaKereta; //inisialisasi nama kereta
        this.sisaKursi = sisaKursi; //inisialisasi sisa kursi
    }

    //getter untuk nama kreta
    public String getNamaKereta() {
        return namaKereta;
    }

    //getter untuk sisa kursi
    public int getSisaKursi() {
        return sisaKursi;
    }
}
