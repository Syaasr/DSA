import java.util.*;

public class Player {
    private String nama;
    private Set<Kartu> setKartu;
    private boolean bot;

    public Player(String nama, boolean bot) {
        this.nama = nama;
        this.setKartu = new LinkedHashSet<>();
        this.bot = bot;
    }

    public String getNama() {
        return nama;
    }

    public Set<Kartu> getSetKartu() {
        return setKartu;
    }

    public boolean isBot() {
        return bot;
    }

    public int jumlahKartu() {
        return setKartu.size();
    }

    public void tambahKartu(Kartu kartu) {
        setKartu.add(kartu);
    }

    public void buangKartu(Kartu kartu) {
        setKartu.remove(kartu);
    }

    public boolean playerValid(Kartu kartuUtama) {
        for (Kartu k : setKartu) {
            if (k.isEquals(kartuUtama)) {
                return true;
            }
        }
        return false;
    }

    public Kartu botPlay(Kartu kartuUtama) {
        for (Kartu k : setKartu) {
            if (k.isEquals(kartuUtama)) {
                return k;
            }
        }
        return null;
    }

    public boolean menang() {
        return setKartu.isEmpty();
    }

    public boolean kalah() {
        return setKartu.size() > 20;
    }
}