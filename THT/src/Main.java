import java.util.Scanner; //input user
import java.util.InputMismatchException; // exception saat user input angka salah

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner inputUser = new Scanner(System.in);
        Reservasi reservasi = new Reservasi(); //buat objek reservasi untuk akses method pemesanan tiket
        boolean keluar = false; //variabel untuk kontrol loop

        try {
            while (!keluar) { //loop untuk memilih menu
                try {
                    System.out.println("====================================="); //tampilan menu
                    System.out.println("1. Lihat Jadwal Kereta");
                    System.out.println("2. Pesan Kereta");
                    System.out.println("3. Keluar");
                    System.out.println("====================================="); //tampilan menu
                    System.out.print("Pilih menu (1-3): ");

                    //ambil input dari pilihan menu dari inputan user
                    int pilihan = inputUser.nextInt();
                    inputUser.nextLine(); //bersihkan buffer input

                    switch (pilihan) {
                        case 1:
                            reservasi.jadwalKereta(); //method untuk lihat jadwal kereta
                            break;

                        case 2:
                            System.out.print("Masukkan kode kereta: ");
                            String kodeKereta = inputUser.nextLine(); //input kode kereta

                            System.out.print("Masukkan NIK penumpang (16 digit): ");
                            String nikPenumpang = inputUser.nextLine(); //input nik penumpang

                            System.out.print("Masukkan nama penumpang: ");
                            String namaPenumpang = inputUser.nextLine(); //input nama penumpang

                            System.out.print("Masukkan jumlah tiket yang ingin dipesan: ");
                            int jumlahTiket = inputUser.nextInt(); //input jumlah tiket
                            inputUser.nextLine(); //bersihkan buffer input

                            try {
                                reservasi.pesanTiket(kodeKereta, nikPenumpang, namaPenumpang, jumlahTiket); //method untuk pesan tiket
                            } catch (RuteTidakDitemukanException e) { //jika terjadi exception RuteTidakDitemukanException
                                System.out.println("Error: " + e.getMessage()); //tampilkan pesan error ke user
                            } catch (TiketHabisException e) { //jika terjadi exception TiketHabisException
                                System.out.println("Error: " + e.getMessage()); //tampilkan pesan error ke user
                                System.out.println("Nama Kereta: " + e.getNamaKereta()); //tampilkan nama kereta yang tiketnya habis
                                System.out.println("Sisa Kursi: " + e.getSisaKursi()); //tampilkan sisa kursi yang tersedia
                            } catch (DataPenumpangTidakValidException e) { //jika terjadi exception DataPenumpangTidakValidException
                                System.out.println("Error: " + e.getMessage()); //tampilkan pesan error ke user
                            }
                            break;

                        case 3:
                            keluar = true; //keluar dari loop
                            System.out.println("Terima kasih telah menggunakan layanan kami ahay.");
                            break;

                        default:
                            System.out.println("Pilihan tidak valid. Silakan pilih menu yang tersedia."); //tampilkan pesan error ke user
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Input harus berupa angka!"); //tampilkan pesan error
                    inputUser.nextLine(); //bersihkan buffer input
                }
            }
        } finally {
            inputUser.close(); //tutup scanner
        }
    }
}