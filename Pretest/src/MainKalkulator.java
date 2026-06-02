import java.util.Scanner;
import java.util.InputMismatchException;

public class MainKalkulator {
    public static void main(String[] args) {

        Scanner input = null;
            
        try {
            //input
            input = new Scanner(System.in);
            System.out.println("Input angka pertama (pembilang)");
            int pembilang = input.nextInt();
            System.out.println("Input angka kedua (penyebut)");
            int penyebut = input.nextInt();
            //hasil
            int hasil = pembilang / penyebut;
            System.out.println("Hasil dari pembagian: " + hasil);
        } catch (ArithmeticException e) {
            System.out.println("Eror " + e.getMessage() + " gabisa bagi dengan 0"); //kalau input 0
        } catch (InputMismatchException e) {
            System.out.println("Eror " + e.getMessage() + " harus angka bulat "); //kalau input selain angka
        } finally {
            if (input != null) {
                input.close();
                System.out.println("Selesai");
            }
        }

    }
}