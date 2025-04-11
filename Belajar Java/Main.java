public class Main {
    public static void main(String args[]) {
        // System.out.println("Hello " + args[0] + "!");
        int age = 18;
        double IPK = 3.91;
        boolean isSingle = true;
        String name = "Syaikhasril Maulana Firdaus";
        int nilai:
        
        System.out.println("Nama : " + name + "\nUmur : " + age + "\nIPK : " + IPK);

        int a = 10, b = 20;
        int c = a + b;
        System.out.println(a + " + " + b + " = " + c);

        if (isSingle) {
            System.out.println("Jomblo : iya");
        } else {
            System.out.println("Jomblo : tidak");
        }

        for (int i = 1; i <= 10; i++) {
            System.out.println("Count : " + i);
        }

        a = 0;
        while (a < 5) {
            System.out.println(a + 1);
            a++;
        }
    }
}
