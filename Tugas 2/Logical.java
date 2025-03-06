public class Logical {
    public static void main(String[] args) {
        boolean isTrue = true;
        boolean benar = true;
        boolean isFalse = false;
        boolean salah = false;

        System.out.println( isTrue + " AND " + benar + " = " + (isTrue && benar));
        System.out.println( isTrue + " AND " + salah + " = " + (isTrue && salah));
        System.out.println( isFalse + " AND " + salah + " = " + (isFalse && salah));

        System.out.println( isTrue + " OR " + benar + " = " + (isTrue || benar));
        System.out.println( isTrue + " OR " + salah + " = " + (isTrue || salah));
        System.out.println( isFalse + " OR " + salah + " = " + (isFalse || salah));

        System.out.println("NOT " + benar + " = " + (!benar));
        System.out.println("NOT " + salah + " = " + (!salah));
    }
}
