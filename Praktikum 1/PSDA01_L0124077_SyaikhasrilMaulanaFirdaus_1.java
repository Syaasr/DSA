// Syaikhasril Maulana Firdaus - L0124077

// Import library yang akan digunakan
import java.util.ArrayList;

public class PSDA01_L0124077_SyaikhasrilMaulanaFirdaus_1 {
  public static void main(String[] args) {
    // Deklarasi dan mengisi ArrayList utama
    ArrayList<String> list = new ArrayList<String>();
    list.add("Rambutan");
    list.add("Jambu");
    list.add("Jeruk");
    list.add("Melon");
    list.add("Semangka");
    list.add("Durian");

    // Deklarasi 2 list baru
    ArrayList<String> list_1 = new ArrayList<String>();
    ArrayList<String> list_2 = new ArrayList<String>();

    // Mengisi list pertama dengan isi dari list utama index 0 sampai 2
    for (int i = 0; i < 3; i++) {
      list_1.add(list.get(i));
    }

    // Mengisi list pertama dengan isi dari list utama index 3 sampai 5
    for (int i = 3; i < 6; i++) {
      list_2.add(list.get(i));
    }
    
    // Menghapus isi list 1 dan 2
    list_1.remove("Jambu");
    list_2.remove("Durian");

    // Print isi list
    System.out.println("Seluruh List:");
    for (String buah : list) {
      System.out.println(buah);
    }
    System.out.println("List 1:");
    for (String buah : list_1) {
      System.out.println(buah);
    }
    System.out.println("List 2:");
    for (String buah : list_2) {
      System.out.println(buah);
    }
  }
}
