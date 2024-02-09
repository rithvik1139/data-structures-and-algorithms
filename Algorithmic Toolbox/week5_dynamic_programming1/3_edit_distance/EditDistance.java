import java.util.*;

class EditDistance {
  public static int editDistance(String s, String t) {
    int m = s.length(), n = t.length();
    int[][] table = new int[m + 1][n + 1];
    for(int j = 1; j <= n; j++) table[0][j] = j;
    for(int i = 1; i <= m; i++) table[i][0] = i;
    for(int i = 1; i <= m; i++) {
      for(int j = 1; j <= n; j++) {
        int insertion = table[i][j - 1] + 1,
                deletion  = table[i - 1][j] + 1,
                mismatch  = table[i - 1][j - 1] +
                        (s.charAt(i - 1) == t.charAt(j - 1) ? 0 : 1);
        table[i][j] = Math.min(insertion,
                Math.min(deletion, mismatch));
      }
    }
    return table[m][n];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(editDistance(s, t));
    scan.close();
  }

}
