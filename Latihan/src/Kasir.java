import java.util.InputMismatchException;
import java.util.Scanner;

public class Kasir {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        double[] hargaMenu = new double[3];
        for(int i = 0; i <= 3; i++){
            try {
                System.out.print("Harga Menu Ke-" + (i+1) + " Rp." );
                hargaMenu[i] = input.nextDouble();

            } catch (InputMismatchException e) {
                System.out.println("Eror: Input harus berupa angka!");
                input.nextLine();
                i--;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Eror: Kapasitas Memori Harga Sudah Penuh!");
            } finally{
                System.out.println("Selesai");
            }
        }
    }
}
