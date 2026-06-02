
public class Umur {
 public void daftarMember(int umur){
    if(umur < 17){
        throw new IllegalArgumentException("Maaf umur anda belum mencukupi untuk menjadi member VIP");
    }
    System.out.println("Selamat datang di member VIP!");
 }
}
