
class UangKurangException extends Exception {
    public UangKurangException(String pesan) {
        super(pesan);
    }
}

class MesinKasir {
    

    public void bayar(int totalBelanja, int uangDiberikan) throws UangKurangException {
        if (uangDiberikan < totalBelanja) {
            int kurang = totalBelanja - uangDiberikan;
            throw new UangKurangException("Uang kurang Rp " + kurang);
        }
        int kembalian = uangDiberikan - totalBelanja;
        System.out.println("Pembayaran berhasil! Kembalian: Rp " + kembalian);
    }
    
    public void cetakStruk(boolean statusPrinter) throws Exception {
        if (!statusPrinter) {
            throw new Exception("Printer error: Kertas struk habis!");
        }
        System.out.println("Struk sedang dicetak...");
    }
}