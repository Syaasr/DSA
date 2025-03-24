// Syaikhasril Maulana Firdaus - L0124077

// import library yang akan digunakan
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PSDA01_L0124077_SyaikhasrilMaulanaFirdaus_3 {     
  public static void main (String[] args) {   
    // Mendeklarasi Queue dan Stack
    Queue<String> input = new LinkedList<>();
    Stack<Integer> komputer = new Stack<>();

    // Mengisi Queue dengan perintah yang akan dijalankan
    input.add("PUSH 0");
    input.add("PUSH 0");
    input.add("TOP");
    input.add("PUSH 1");
    input.add("TOP");
    input.add("POP");
    input.add("POP");
    input.add("TOP");

    // loop untuk menjalankan semua perintah di queue
    while (!input.isEmpty()) {
      String inputPerintah = input.poll();
      if (inputPerintah.equals("PUSH 0")) {
        komputer.push(0);
      } else if (inputPerintah.equals("PUSH 1")) {
        komputer.push(1);
      } else if (inputPerintah.equals("TOP")) {
        if (!komputer.isEmpty()) {
          System.out.print(komputer.peek());
        }
      } else if (inputPerintah.equals("POP")) {
        if (!komputer.isEmpty()) {
          komputer.pop();
        }
      }
    }
  }
}
