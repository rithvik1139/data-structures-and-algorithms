// Incorrect
import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int minStops = 0;
        for (int index = 1, start = 0, previous = 0 ; index < stops.length ; index++) {
            if (stops[index] - start > tank) {
                if (previous == start && index != 1 || previous - start > tank) {
                    return -1;
                }
                minStops++;
                start = previous;
            }
            previous = stops[index];
        }

        return stops[stops.length - 1] - stops[stops.length - 2] <= tank ? minStops : -1;
    }
    public static void main(String[] args) {
        int distance = scanner.nextInt();
        int tank = scanner.nextInt();
        int[] stops = getArray(scanner.nextInt(), distance);
        System.out.println(computeMinRefills(tank, stops));
    }

    private static int[] getArray(int length, int distance) {
        int[] array = new int[length + 2];
        for (int index = 1 ; index <= length ; index++) {
            array[index] = scanner.nextInt();
        }
        array[length + 1] = distance;
        return array;
    }
}
