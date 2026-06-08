//data penumpang tidak valiid merupakan unchecked exception
//karena tidaj wajib  ditangani makanya menggunakan runtime exception
//sesuai modul: Tidak wajib ditangani, digunakan untuk programming error.
public class DataPenumpangTidakValidException extends RuntimeException{
    public DataPenumpangTidakValidException(String pesan){
        super(pesan); //kirim pesan ke class runtime exception
    }
}
