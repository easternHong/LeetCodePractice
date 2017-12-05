package offer;


/**
 * 抽象出来
 * 0,n = 0
 * 1,n = 1
 * f(n) = f(n-1)+f(n-2)
 */
public class Fibonacci {

    public
    static void main(String[] args) {
        System.out.println(fibonacci_(3));
        System.out.println(fibonacci(3));
    }

    private static int level = 0;

    public static long fibonacci_(int n) {
        System.out.println("level:" + level++);
        if (n <= 1) {
            return n;
        } else {
            return fibonacci_(n - 1) + fibonacci_(n - 2);
        }
    }

    public static long fibonacci(int n) {

        if (n <= 1) {
            return n;
        }
        long one = 0;
        long two = 1;
        long res = 0;

        for (int i = 2; i <= n; i++) {
            res = one + two;
            one = two;
            two = res;
        }
        return res;
    }
}
