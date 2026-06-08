import java.util.ArrayList;
import java.util.List;

public class Reservasi { //puisat kontrol untuk pemesanan tiket nantinya
    //list untuk simpan semua kereta yang teerdaftar
    //List<kereta> diambil dari class kereta yang sudah dibuat sebelumnya
    private List<Kereta> daftarKereta;

    //list untuk menyimpan riwayat pemesanan kereta yang berhasil oleh oenumoang
    private List<String> riwayatPemesanan;

    //constructor 
    public Reservasi() {
        this.daftarKereta = new ArrayList<>(); //inisialisasi daftar kereta
        this.riwayatPemesanan = new ArrayList<>(); //inisialisasi riwayat pemesanan

        //menambahkan data kereta 
        daftarKereta.add(new Kereta("KA01", "Argo Bromo", 100));
        daftarKereta.add(new Kereta("KA02", "Solo Balapan", 80));
    }

    //method untuk pesan tiket dengan menggunakan throws untuk mengdeklarasikan exception yang mungkin terjadi
    public void pesanTiket(String kodeKereta, String nikPenumpang, String namaPenumpang, int jumlahTiket) throws RuteTidakDitemukanException, TiketHabisException {
        //validasi untuk ngecek nik
        //pada kasus ini nik harus pas 16 maka kita memanfaatkan length
        if(nikPenumpang.length() != 16){

            throw new DataPenumpangTidakValidException("NIK penumpang tidak valid. NIK harus 16 digit!"); //jika nik tidak valid maka lempar exception dengan pesan yang sesuai
        }

        //ngecek apakah kereta ada atau tidak
        Kereta keretas = null; //keretas null karena kita belum tahu kereta mana yang sesuai dengan kode yang dimasukkan
        for (Kereta k : daftarKereta) { //looping untuk cari kereta yang sesuai dengan kode yang dimasukkan
            if (k.getKodeKereta().equals(kodeKereta)) { //jika kode kereta cocok
                keretas = k; //simpan kereta yang ditemukan
                break; //keluar dari loop karena sudah ketemu
            }
        }

        if (keretas == null) { //jika kereta tidak ditemukan
            throw new RuteTidakDitemukanException("Rute kereta dengan kode " + kodeKereta + " tidak ditemukan!!"); //lempar exception dengan pesan yang sesuai
        }

        //cek apakah kursi masih tersedia atau tidak
        //jika jumlah tiket yang di pesan lebih gede dari sisa kursi yang ada maka 
        if(jumlahTiket > keretas.getSisaKursi()){
            throw new TiketHabisException("Tiket untuk kereta " + keretas.getNamaKereta() + " sudah habis!", keretas.getNamaKereta(), keretas.getSisaKursi()); //lempar exception dengan pesan yang sesuai dan informasi tambahan nama kereta dan sisa kursi
        }  
        
        //memproses pesanan jika sukses 
        //jika semua valid lolos, maka otomtis mengurasi kursi sesuai dengan jumlah tiket

        keretas.kurangiKursi(jumlahTiket); //mengurangi kursi sesuai dengan jumlah tiket yang dipesan
        //buat pesan untuk pemesanan
        String pemesanan = "pemesanan berhasil untuk " + namaPenumpang + " dengan NIK " + nikPenumpang + " pada kereta " + keretas.getNamaKereta() + " sebanyak " + jumlahTiket + " tiket.";
        //simpan pemesanan ke riwayat pemesanan
        riwayatPemesanan.add(pemesanan); //menambahkan pemesanan ke riwayat pemesanan
        //menampilkan pesan ke user 
        System.out.println(pemesanan); //tampilkan pesan pemesanan ke user
    }

    //method untuk menampilkan jadwal untuk semua kereta yang tersedia 
    public void jadwalKereta(){
        System.out.println("=====================================================");
        System.out.println("Jadwal Kereta Api tutututut");
        System.out.println("=====================================================");
        for(Kereta k : daftarKereta){ //looping untuk tampilkan semua kereta yang ada di daftar kereta
            System.out.println("Kode Kereta: " + k.getKodeKereta() + " | Nama Kereta: " + k.getNamaKereta() + " | Kapasitas: " + k.getKapasitas() + " | Sisa Kursi: " + k.getSisaKursi()); //tampilkan informasi kereta ke user
        }
        System.out.println("=====================================================");
    }

}
