class Person {
    private String nama;
    private int umur;

    public Person(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getNama() {
        return nama;
    }

    public int getUmur() {
        return umur;
    }

    public void printIdentitas() {
        System.out.println("Nama : " + nama);
        System.out.println("Umur : " + umur);
    }
}

class Mahasiswa extends Person {
    private String nim;
    private String jurusan;
    private char kelas;

    public Mahasiswa(String nama, int umur, String nim, String jurusan, char kelas) {
        super(nama, umur);
        this.nim = nim;
        this.jurusan = jurusan;
        this.kelas = kelas;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public void setKelas(char kelas) {
        this.kelas = kelas;
    }

    public String getNim() {
        return nim;
    }

    public String getJurusan() {
        return jurusan;
    }

    public char getKelas() {
        return kelas;
    }

    public void printIdentitas() {
        super.printIdentitas(); 
        System.out.println("NIM : " + nim);
        System.out.println("Jurusan : " + jurusan);
        System.out.println("Kelas : " + kelas);
    }
}

public class Class {
    public static void main(String[] args) {
        Mahasiswa mhs1 = new Mahasiswa("Syaikhasril", 18, "L0124077", "Informatika", 'B');

        System.out.println("Identitas Mahasiswa");
        mhs1.printIdentitas();

        mhs1.setNama("Asril");
        mhs1.setUmur(19);
        mhs1.setKelas('D');

        System.out.println("\nIdentitas setelah perubahan");
        System.out.println("Nama : " + mhs1.getNama());
        System.out.println("Umur : " + mhs1.getUmur());
        System.out.println("NIM : " + mhs1.getNim());
        System.out.println("Jurusan : " + mhs1.getJurusan());
        System.out.println("Kelas : " + mhs1.getKelas());
    }
}
