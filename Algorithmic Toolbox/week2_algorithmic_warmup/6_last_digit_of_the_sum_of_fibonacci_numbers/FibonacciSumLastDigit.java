import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    public static int getFibonacciLastDigitEfficient(int n) {
        if (n <= 1)
            return n;

        int[] fibArray = new int[n + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            fibArray[i] = (fibArray[i - 1] + fibArray[i - 2]) % 10;
        }
        return fibArray[n];
    }

    public static int getFibonacciSumEfficient(long n) {
        int new_n = (int) ((n + 2) % 60);
        int new_last = getFibonacciLastDigitEfficient(new_n);
        if (new_last == 0) {
            return 9;
        } else {
            return new_last - 1;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
//        long s = getFibonacciSumNaive(n);
        long s = getFibonacciSumEfficient(n);
        System.out.println(s);
    }
}

