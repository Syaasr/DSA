import java.util.*;

public class UI {
    private static final Scanner input = new Scanner(System.in);

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void judul(String judul) {
        System.out.println("==============================================");
        System.out.println("              " + judul);
        System.out.println("==============================================");
    }

    public static void printKartuUtama(Kartu kartu) {
        System.out.println("Kartu Utama:");
        printSatuKartu(kartu);
        System.out.println();
    }

    public static void printSatuKartu(Kartu kartu) {
        System.out.println("+-----+");
        System.out.println("|     |");
        System.out.printf("|  %s  |\n", kartu.printKartu());
        System.out.println("|     |");
        System.out.println("+-----+");
    }

    public static void printKartuPlayer(Player player) {
        Set<Kartu> kartu = player.getSetKartu();

        System.out.println("Kartu milik " + player.getNama() + ":");

        for (int j = 0; j < kartu.size(); j++) System.out.print("+-----+ ");
        System.out.println();

        for (int j = 0; j < kartu.size(); j++) System.out.print("|     | ");
        System.out.println();

        for (Kartu k : kartu) {
            System.out.print("|  " + k.printKartu() + "  | ");
        }
        System.out.println();

        for (int j = 0; j < kartu.size(); j++) System.out.print("|     | ");
        System.out.println();

        for (int j = 0; j < kartu.size(); j++) System.out.print("+-----+ ");
        System.out.println();

        for (int j = 1; j <= kartu.size(); j++) {
            System.out.printf("   %d    ", j);
        }
        System.out.println("\n");
    }

    public static void printJumlahKartu(List<Player> daftarPlayer, int index) {
        System.out.println("Jumlah kartu player:");
        for (int i = 0; i < daftarPlayer.size(); i++) {
            Player p = daftarPlayer.get(i);
            String pointer = (i == index) ? " <- Giliran sekarang" : "";
            System.out.println(p.getNama() + ": " + p.jumlahKartu() + " kartu" + pointer);
        }
        System.out.println();
    }

    public static void teks(String teks) {
        System.out.println(teks);
        System.out.println();
    }

    public static int inputAngka(String prompt, int min, int max) {
        int hasil = -1;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            try {
                hasil = Integer.parseInt(input.nextLine());
                if (hasil >= min && hasil <= max) {
                    valid = true;
                } else {
                    System.out.println("Masukkan angka antara " + min + " sampai " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }

        return hasil;
    }

    public static String inputTeks(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    public static void pressEnter() {
        System.out.print("Tekan ENTER untuk lanjut...");
        input.nextLine();
    }

    public static void loading(String nama) {
        clearScreen();
        System.out.println("Giliran " + nama + "...");
        System.out.println("Silakan tekan ENTER untuk melanjutkan");
        input.nextLine();
        clearScreen();
    }
}