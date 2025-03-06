public class While {
    public static void main(String[] args) {
        int angka = 7;
        int hasil = 0;

        System.out.print("Jumlah dari angka 1 sampai " + angka + " adalah : ");

        while (angka > 0) {
            hasil += angka;
            angka--;
        }

        System.out.print(hasil);
    }
}
