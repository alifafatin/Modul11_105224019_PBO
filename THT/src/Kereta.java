public class Kereta { //anggaplah ini merepresentasikann satu kereta api
    private String kodeKereta; //kode kereta
    private String namaKereta; //nama kereta
    private int kapasitas; //kapasitas kereta
    private int sisaKursi; //kursi yang tersisa atau masih kosong

    //konstruktor 
    public Kereta(String kodeKereta, String namaKereta, int kapasitas) {
        this.kodeKereta = kodeKereta; //inisialisasi kode kereta
        this.namaKereta = namaKereta; //inisialisasi nama kereta
        this.kapasitas = kapasitas; //inisialisasi kapasitas kereta
        this.sisaKursi = kapasitas; //sisa kursi awalnya sama dengan kapasitas
    }

    //getter untuk kode kereta
    public String getKodeKereta() {
        return kodeKereta;
    }

    //getter untuk nama kereta
    public String getNamaKereta() {
        return namaKereta;
    }

    //getter untuk kapasitas kereta
    public int getKapasitas() {
        return kapasitas;
    }

    //getter untuk sisa kursi
    public int getSisaKursi() {
        return sisaKursi;
    }

    public void kurangiKursi(int jumlah){
        this.sisaKursi -= jumlah; //mengurangi sisa kursi sesuai jumlah tiket yang dipesan 
    }

}
