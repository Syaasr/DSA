// Syaikhasril Maulana Firdaus - L0124077

// import library yang akan digunakan
import java.util.Stack;

public class PSDA01_L0124077_SyaikhasrilMaulanaFirdaus_2 {
  // Fungsi untuk mengurutkan stack
  public static Stack<String> sortStack(Stack<String> input) {  
    // Deklarasi stack sementara
    Stack<String> tempStack = new Stack<>();

    // While loop sampai isi stack yang dimasukkan ke fungsi sort habis
    while (!input.isEmpty()) {
        // Deklarasi string sementara 
        String temp = input.pop();
        // Memindahkan elemen dari tempStack ke input jika urutannya lebih besar
        while (!tempStack.isEmpty() && tempStack.peek().compareTo(temp) > 0) {
            input.push(tempStack.pop());
        }
        // Menambahkan string sementara ke stack sementara
        tempStack.push(temp);
    }
    
    // Mengembalikan stack yang sudah diurutkan
    return tempStack;
}
  
  // Fungsi main
  public static void main (String[] args) {   
    // Deklarasi stack dengan nama kaset
    Stack<String> kaset = new Stack<>(); 

    // Mengisi stack dengan kaset
    kaset.push("Dora the Explorer");
    kaset.push("Paw Patrol");
    kaset.push("Peppa Pig");
    kaset.push("Thomas & Friends");
    kaset.push("Masha and the Bear");
    kaset.push("SpongeBob SquarePants");
    kaset.push("Shinchan");
    kaset.push("Doraemon");
    kaset.push("Upin & Ipin");
    kaset.push("BoBoiBoy");

    // Mengurutkan kaset sesuai abjad
    kaset = sortStack(kaset);

    // Mendeklarasi stack sementara dan tangan Piyu untuk mengambil kaset
    Stack<String> temp = new Stack<>();
    String tanganPiyu;

    // While loop sampai ketemu kaset Peppa Pig
    while(!kaset.isEmpty()) {
      // Mengambil kaset dari stack ke tangan piyu
      tanganPiyu = kaset.pop();
      // Cek jika kaset adalah Peppa Pig maka berhenti mengambil, jika tidak lanjutkan
      if (tanganPiyu.equals("Peppa Pig")) {
        break;
      } else {
        temp.push(tanganPiyu);
      }
    }

    // Mengembalikan kaset yang sudah diambil sebelumnya
    while (!temp.isEmpty()) {
      kaset.push(temp.pop());
    }

    // Print kaset
    for (String nama : kaset) {
      System.out.println(nama);
    }
  }
}