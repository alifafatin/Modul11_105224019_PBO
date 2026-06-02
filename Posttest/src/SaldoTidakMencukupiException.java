public class SaldoTidakMencukupiException extends Exception {
    private double saldoKurang;

    public SaldoTidakMencukupiException(double saldoKurang) {
        super("Saldo tidak mencukupi. anda kekurangan: " + saldoKurang);
        this.saldoKurang = saldoKurang;
    }

    public double getSaldoKurang(){
        return saldoKurang;
    }
}
