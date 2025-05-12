import java.util.*;

public class Kartu {
    private String nilai;
    private String warna;
    private String kodeWarna;

    public static final String RESET = "\u001B[0m";
    public static final String MERAH = "\u001B[31m";
    public static final String HIJAU = "\u001B[32m";
    public static final String KUNING = "\u001B[33m";
    public static final String BIRU = "\u001B[34m";

    public Kartu(String nilai, String warna) {
        this.nilai = nilai;
        this.warna = warna;

        switch (warna) {
            case "M":
                this.kodeWarna = MERAH;
                break;
            case "H":
                this.kodeWarna = HIJAU;
                break;
            case "K":
                this.kodeWarna = KUNING;
                break;
            case "B":
                this.kodeWarna = BIRU;
                break;
            default:
                this.kodeWarna = RESET;
        }
    }

    public String getNilai() {
        return nilai;
    }

    public String getWarna() {
        return warna;
    }

    public String getKodeWarna() {
        return kodeWarna;
    }

    public String printKartu() {
        return kodeWarna + nilai + RESET;
    }

    public boolean isEquals(Kartu lain) {
        return this.warna.equals(lain.warna) || this.nilai.equals(lain.nilai);
    }

    @Override
    public String toString() {
        return kodeWarna + nilai + warna + RESET;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Kartu kartu = (Kartu) obj;
        return nilai.equals(kartu.nilai) && warna.equals(kartu.warna);
    }

    @Override
    public int hashCode() {
        return 31 * nilai.hashCode() + warna.hashCode();
    }
}