public class For {
    public static void main(String[] args) {
        int ukuran = 5;
        for (int i = 0; i < ukuran; i++) {
            for (int j = 0; j < ukuran; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }

        int[] angka = {10, 20, 30, 40, 50};

        for (int no : angka) {
            System.out.println(no);
        }
    }
}