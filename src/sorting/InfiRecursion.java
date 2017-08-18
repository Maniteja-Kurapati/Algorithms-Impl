package sorting;

public class InfiRecursion {

    public static void main(final String[] args) {
        System.out.println(InfiRecursion.factorial(20));
    }

    public static long factorial(final long n) {
        if (n == 0) {
            return 1;
        }
        return n * (factorial(n - 1));
    }
}
