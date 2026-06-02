public class AkunBank {
    private String nomorRekening;
    private double saldo;
    private double totalTransferHarian;
    private double limitHarian = 10000000;

    public AkunBank(String nomorRekening, double saldo) {
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
        this.totalTransferHarian = 0;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTotalTransferHarian() {
        return totalTransferHarian;
    }

    public void tarikTunai(double nominal) throws SaldoTidakMencukupiException {
        if(nominal > saldo){
            double kurang = nominal - saldo;
            throw new SaldoTidakMencukupiException(kurang);
        } saldo -= nominal;
        System.out.println("Penarikan tunai berhasil, saldo sisa: " + saldo);
    }

    public void transfer (AkunBank tujuan, double nominal) throws SaldoTidakMencukupiException, BatasTransferHarianException {
        if (nominal > saldo){
            double kurang = nominal - saldo;
            throw new SaldoTidakMencukupiException(kurang);
        } else if (totalTransferHarian + nominal > limitHarian){
            throw new BatasTransferHarianException(limitHarian);
        }
    }
}
