//rute tidak ditemukan, checked extends wajib ditangaani karena merupaka kondisi yang mungkin terjadi 
//sesuai modul: Extends Exception. Wajib ditangani oleh pemanggil (try-catch atau throws).
public class RuteTidakDitemukanException extends Exception {
    public RuteTidakDitemukanException(String pesan) {
        super(pesan); //kirim pesan ke Execption
    }

}
