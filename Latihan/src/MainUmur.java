public class MainUmur {
    public static void main(String[] args){
        Umur umur = new Umur();

        try{
            umur.daftarMember(16);//nolak harusnya kan ya
        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
