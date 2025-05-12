import java.util.*;

public class UNO {
    public static void main(String[] args) {
        UI.clearScreen();
        menuUtama();
    }

    private static void menuUtama() {
        boolean keluar = false;

        while (!keluar) {
            UI.clearScreen();
            UI.judul("UNO : Java Edition");
            System.out.println("[1] Player vs Bot");
            System.out.println("[2] Player vs Player (Multiplayer)");
            System.out.println("[3] Tutorial");
            System.out.println("[4] Keluar");

            int pilihan = UI.inputAngka("Pilih opsi (1-4): ", 1, 4);

            switch (pilihan) {
                case 1:
                    playVsBot();
                    break;
                case 2:
                    playMultiplayer();
                    break;
                case 3:
                    tampilkanTutorial();
                    break;
                case 4:
                    keluar = true;
                    UI.clearScreen();
                    System.out.println("Terima kasih telah bermain!\nKasih nilai 100 yaa");
                    break;
            }
        }
    }

    private static void playVsBot() {
        UI.clearScreen();
        String nama = UI.inputTeks("Masukkan nama Anda: ");

        List<Player> player = new ArrayList<>();
        player.add(new Player(nama, false));
        player.add(new Player("Bot", true));

        Game game = new Game(player);
        game.start();

        UI.pressEnter();
    }

    private static void playMultiplayer() {
        UI.clearScreen();
        int jumlah = UI.inputAngka("Jumlah player (2-4): ", 2, 4);

        List<Player> player = new ArrayList<>();
        for (int i = 1; i <= jumlah; i++) {
            String nama = UI.inputTeks("Masukkan nama player " + i + ": ");
            player.add(new Player(nama, false));
        }

        Game game = new Game(player);
        game.start();

        UI.pressEnter();
    }

    private static void tampilkanTutorial() {
        UI.clearScreen();
        UI.judul("TUTORIAL UNO");

        System.out.println("1. Setiap player mendapat 5 kartu acak di awal.");
        System.out.println("2. Kartu harus cocok warna atau nilainya dengan kartu di tengah.");
        System.out.println("3. Jika tidak bisa mainkan kartu, ambil 1 kartu.");
        System.out.println("4. Batas maksimal kartu di tangan adalah 20.");
        System.out.println("5. Kartu spesial:");
        System.out.println("   +   Player selanjutnya ambil 2 kartu.");
        System.out.println("   -   Player selanjutnya dilewati.");
        System.out.println("6. Player pertama yang habis kartunya MENANG!");
        System.out.println("7. Player yang melebihi 20 kartu KALAH!");
        System.out.println();

        UI.pressEnter();
    }
}
