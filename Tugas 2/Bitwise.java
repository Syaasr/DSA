public class Bitwise {
    public static void main(String[] args) {
        int a = 2; 
        int b = 3; 
        int c = 4;

        System.out.println("a = " + a + " (biner : " + Integer.toBinaryString(a) + ")");
        System.out.println("b = " + b + " (biner : " + Integer.toBinaryString(b) + ")");

        int and = a & b;
        System.out.println("a & b = " + and + " (biner : " + Integer.toBinaryString(and) + ")");

        int or = a | b;
        System.out.println("a | b = " + or + " (biner : " + Integer.toBinaryString(or) + ")");

        int xor = a ^ b;
        System.out.println("a ^ b = " + xor + " (biner : " + Integer.toBinaryString(xor) + ")");

        int not = ~a;
        System.out.println("~a = " + not + " (biner : " + Integer.toBinaryString(not) + ")");

        int leftShift = a << 2;
        System.out.println("a << 2 = " + leftShift + " (biner : " + Integer.toBinaryString(leftShift) + ")");

        int rightShift = a >> 1;
        System.out.println("a >> 1 = " + rightShift + " (biner : " + Integer.toBinaryString(rightShift) + ")");

        int unsignedRightShift = a >>> 3;
        System.out.println("a >>> 3 = " + unsignedRightShift + " (biner : " + Integer.toBinaryString(unsignedRightShift) + ")");
    }
}
