import java.util.*;

public class Game {
    private List<Kartu> deck;
    private Stack<Kartu> buang;
    private List<Player> daftarPlayer;
    private Map<String, Runnable> efekKartu;
    private Queue<Integer> giliran;
    private Kartu kartuUtama;
    private boolean selesai;
    private int indexPlayer;

    public Game(List<Player> player) {
        this.daftarPlayer = player;
        this.buang = new Stack<>();
        this.giliran = new LinkedList<>();
        this.selesai = false;

        for (int i = 0; i < player.size(); i++) {
            giliran.offer(i);
        }

        susunDeckKartu();
        bagikanKartu();
        EfekKartuSpesial();

        kartuUtama = ambilKartu();
        while (kartuUtama.getNilai().equals("+") || kartuUtama.getNilai().equals("-")) {
            buang.push(kartuUtama);
            kartuUtama = ambilKartu();
        }
        buang.push(kartuUtama);
    }

    private void susunDeckKartu() {
        deck = new ArrayList<>();
        String[] warna = {"M", "H", "K", "B"};
        String[] nilai = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-"};

        for (String w : warna) {
            for (String n : nilai) {
                deck.add(new Kartu(n, w));
                if (!n.equals("0")) {
                    deck.add(new Kartu(n, w));
                }
            }
        }
        Collections.shuffle(deck);
    }

    private void bagikanKartu() {
        for (Player p : daftarPlayer) {
            for (int i = 0; i < 5; i++) {
                p.tambahKartu(ambilKartu());
            }
        }
    }

    private Kartu ambilKartu() {
        if (deck.isEmpty()) acakKartu();
        if (deck.isEmpty()) susunDeckKartu(); 
        return deck.remove(deck.size() - 1);
    }

    private void acakKartu() {
        Kartu atas = buang.isEmpty() ? null : buang.pop();
        while (!buang.isEmpty()) {
            deck.add(buang.pop());
        }
        Collections.shuffle(deck);
        if (atas != null) {
            buang.push(atas);
            kartuUtama = atas;
        }
    }

    private void EfekKartuSpesial() {
        efekKartu = new HashMap<>();
        efekKartu.put("+", this::efekTambahDua);
        efekKartu.put("-", this::efekSkip);
    }

    public void start() {
        while (!selesai) {
            indexPlayer = giliran.poll();
            Player player = daftarPlayer.get(indexPlayer);
            giliran.offer(indexPlayer);

            UI.loading(player.getNama());

            if (player.isBot()) giliranBot(player);
            else giliranPlayer(player);

            if (player.menang()) {
                UI.clearScreen();
                UI.teks(player.getNama() + " MENANG! Semua kartu habis!");
                selesai = true;
            } else if (player.kalah()) {
                UI.clearScreen();
                UI.teks(player.getNama() + " KALAH! Melebihi batas 20 kartu.");
                selesai = true;
            }

            if (!selesai) {
                if (player.isBot()) UI.delay(1500);
                else UI.pressEnter();
            }
        }
    }

    private void giliranPlayer(Player player) {
        UI.judul("UNO : Java Edition");
        UI.printKartuUtama(kartuUtama);
        UI.printJumlahKartu(daftarPlayer, indexPlayer);
        UI.teks("Giliran " + player.getNama());
        UI.printKartuPlayer(player);

        List<Kartu> pilihan = new ArrayList<>(player.getSetKartu());

        int pilihanKartu = UI.inputAngka("Pilih kartu (1-" + pilihan.size() + "), atau 0 untuk ambil kartu: ", 0, pilihan.size());

        if (pilihanKartu == 0) {
            Kartu baru = ambilKartu();
            player.tambahKartu(baru);
            UI.teks("Kamu mengambil kartu:");
            UI.printSatuKartu(baru);

            if (baru.isEquals(kartuUtama)) {
                int mainkan = UI.inputAngka("Kartu cocok! Mainkan sekarang? (1: Ya, 0: Tidak): ", 0, 1);
                if (mainkan == 1) {
                    player.buangKartu(baru);
                    buang.push(baru);
                    kartuUtama = baru;
                    jalankanEfek(baru);
                }
            }
        } else {
            Kartu dipilih = pilihan.get(pilihanKartu - 1);
            if (dipilih.isEquals(kartuUtama)) {
                player.buangKartu(dipilih);
                buang.push(dipilih);
                kartuUtama = dipilih;
                jalankanEfek(dipilih);
            } else {
                UI.teks("Kartu tidak valid! Harus sesuai warna atau nilai.");
                UI.delay(1000);
                UI.clearScreen();
                giliranPlayer(player);
            }
        }
    }

    private void giliranBot(Player bot) {
        UI.teks("Giliran " + bot.getNama());

        Kartu gerakan = bot.botPlay(kartuUtama);
        if (gerakan != null) {
            bot.buangKartu(gerakan);
            buang.push(gerakan);
            kartuUtama = gerakan;
            UI.teks(bot.getNama() + " memainkan kartu:");
            UI.printSatuKartu(gerakan);
            jalankanEfek(gerakan);
        } else {
            Kartu baru = ambilKartu();
            bot.tambahKartu(baru);
            UI.teks(bot.getNama() + " mengambil kartu:");

            if (baru.isEquals(kartuUtama)) {
                bot.buangKartu(baru);
                buang.push(baru);
                kartuUtama = baru;
                UI.teks(bot.getNama() + " langsung memainkan kartu tersebut!");
                UI.printSatuKartu(baru);
                jalankanEfek(baru);
            }
        }
    }

    private void jalankanEfek(Kartu kartu) {
        if (efekKartu.containsKey(kartu.getNilai())) {
            efekKartu.get(kartu.getNilai()).run();
        }
    }

    private void efekTambahDua() {
        int target = giliran.peek();
        Player korban = daftarPlayer.get(target);
        UI.teks(korban.getNama() + " harus mengambil 2 kartu!");
        for (int i = 0; i < 2; i++) korban.tambahKartu(ambilKartu());
    }

    private void efekSkip() {
        int dilewati = giliran.poll();
        giliran.offer(dilewati);
        UI.teks(daftarPlayer.get(dilewati).getNama() + " dilewati!");
    }
}