// Incorrect
import java.io.*;
import java.util.*;

public class BinarySearch {
    static List<Integer> binarySearchWithDuplicates(int[] a, int x) {
        List<Integer> resultIndices = new ArrayList<>();
        int left = 0, right = a.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (x == a[mid]) {
                resultIndices.add(mid);

                // Search to the left of the found element
                int leftIndex = mid - 1;
                while (leftIndex >= 0 && a[leftIndex] == x) {
                    resultIndices.add(leftIndex);
                    leftIndex--;
                }

                // Search to the right of the found element
                int rightIndex = mid + 1;
                while (rightIndex < a.length && a[rightIndex] == x) {
                    resultIndices.add(rightIndex);
                    rightIndex++;
                }

                return resultIndices;
            } else if (x < a[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return resultIndices; // Empty list if not found
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            // Replace with the call to binarySearchWithDuplicates when implemented
            List<Integer> result = binarySearchWithDuplicates(a, b[i]);
            for (int index : result) {
                System.out.print(index + " ");
            }
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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
