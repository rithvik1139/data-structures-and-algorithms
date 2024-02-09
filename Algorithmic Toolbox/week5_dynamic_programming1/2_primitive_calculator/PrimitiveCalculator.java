import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        int[] arr = new int[n+1]; // Array to hold the amount of operations for each i'th number up to n
        int minOps = 0; // used to count the minimum # of operations 

        // first build the table of operation counts
        for( int i = 1; i < n+1; i++ ) {
            // run checks on the i'th number and compare how many operations it took to reach it. Store the lowest one.
            if( i%3 == 0 ) {
                if( arr[i] == 0 || arr[i] > arr[i/3]+1 ) {
                    arr[i] = arr[i/3]+1;
                }
            }
            if( i%2 == 0 ) {
                if( arr[i] == 0 || arr[i] > arr[i/2]+1 ) {
                    arr[i] = arr[i/2]+1;
                }
            }
            if( arr[i] == 0 || arr[i-1]+1 < arr[i]) {
                arr[i] = arr[i-1]+1;
            }
        }

        minOps = arr[n];    // minOps == to the number of ops it took to get to our number n
        sequence.add(n);   // add n to the list
        int choice = 0;    // current choice of either 3, 2 or 1

        // go back through our array and now compare the number of operations at the n'th number
        // to the next lowest given our choices of either /3 /2 or -1;
        while ( n > 1 ) {
            choice = 0;
            if( n%3 == 0 ) {
                if( arr[n/3] < minOps ) {
                    minOps = arr[n/3];
                    choice = 3;
                }
            }
            if( n%2 == 0 ) {
                if( arr[n/2] < minOps ) {
                    minOps = arr[n/2];
                    choice = 2;
                }
            }
            if( arr[n-1] < minOps || choice == 0 ) {
                choice = 1;
                minOps = arr[n];
            }
            // determine which of our 3 choices was the optimal at the current step and decrement n accordingly.
            if( choice > 1 ) {
                sequence.add(n/choice);
                n /= choice;
            } else {
                sequence.add(n-choice);
                n-=choice;
            }
        }

        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

