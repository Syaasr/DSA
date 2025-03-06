import java.util.Scanner;

public class Do_While {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int angka;

        do {
            System.out.print("Masukkan angka bilangan kuadrat sempurna : ");
            angka = scanner.nextInt();

            int akar = (int) Math.sqrt(angka); 
            if (akar * akar == angka) { 
                System.out.println(angka + " adalah bilangan kuadrat sempurna dari " + akar);
                break;
            } else {
                System.out.println(angka + " bukan bilangan kuadrat sempurna. Coba lagi.");
            }
        } while (true);

        scanner.close();
    }
}
