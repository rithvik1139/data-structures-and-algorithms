import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static int getMaxPairwiseProduct(int[] numbers) {
        int max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
                    numbers[first] * numbers[second]);
            }
        }

        return max_product;
    }

    static long getMaxPairwiseProduct2(int[] numbers) {
        int numberSize = numbers.length;

        int max_index1 = -1;
        for (int i = 0; i < numberSize; i++) {
            if ((max_index1 == -1) || (numbers[i] > numbers[max_index1]))
                max_index1 = i;
        }

        int max_index2 = -1;
        for (int j = 0; j < numberSize; j++) {
            if ((j != max_index1) && ((max_index2 == -1) || (numbers[j] > numbers[max_index2])))
                max_index2 = j;
        }

        return (long)numbers[max_index1] * numbers[max_index2];
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct2(numbers));
    }

    /*
// stress test
while (true) {

Random ran = new Random();
int max = 5;
int min = 2;
int randomNum = ran.nextInt((max - min) + 1) + min;

System.out.println("Random number: " + randomNum);

int[] list = new int[randomNum];

for (int i = 0; i < randomNum; i++) {
    list[i] = ran.nextInt((10) + 1);
    System.out.println(list[i]);
}
System.out.println("");

double result1 = getMaxPairwiseProduct(list);
double result2 = getMaxPairwiseProductFast(list);

if (result1 != result2) {
    System.out.println("Error! slow:  " + result1 + " fast: " + result2);
    break;
} else {
    System.out.println("OK");
}
}
*/
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
