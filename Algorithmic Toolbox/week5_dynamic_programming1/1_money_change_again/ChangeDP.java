import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {

        int size = m+1;
        int[] coins = new int[size];
        coins[0] = 0;

       
        for( int i = 1; i < size; i++ ) {

            if ( i%4 == 0 ) {
                if( coins[i] == 0 ) {
                    coins[i] = i/4;
                } else {
                    coins[i] = min( coins[i], i/4 );
                }
            } else if ( i%3 == 0 ) {
                if( coins[i] == 0 ) {
                    coins[i] = i/3;
                } else {
                    coins[i] = min( coins[i], i/3 );
                }
            } else {
                if ( coins[i] == 0 ) {
                    coins[i] = 1 + coins[i-1];
                } else {
                    coins[i] = min( coins[i], (1+coins[i-1]) );
                }
            }

            if ( i + i < size ) {
                if( coins[i+i] == 0 ) {
                    coins[i+i] = coins[i]*2;
                } else {
                    coins[i+i] = min( coins[i+i], (coins[i]*2) );
                }
            }

            if ( i + (i-1) < size ) {
                if( coins[i+(i-1)] == 0 ) {
                    coins[i+(i-1)] = coins[i] + coins[i-1];
                } else {
                    coins[i+(i-1)] = min(coins[i+(i-1)],coins[i] + coins[i-1]);
                }
            }

            if( i > m/2 ) {
                if ( coins[m] == 0 ) {
                    coins[m] = coins[m-i] + coins[i];
                } else {
                    coins[m] = min(coins[m], ( coins[m-i] + coins[i] ));
                }
            }

        }

        return coins[m];

    }



    private static int min(int x, int y) {
        return (x < y) ? x : y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

