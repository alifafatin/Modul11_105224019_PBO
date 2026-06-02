public class BatasTransferHarianException extends Exception {
    public BatasTransferHarianException(double limit){
        super("Batas transfer harian telah tercapai. Limit: " + limit);
    }
}
