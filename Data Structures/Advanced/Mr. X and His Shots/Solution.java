import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author michael.malevannyy@gmail.com, 10.10.2019
 */
@SuppressWarnings("ForLoopReplaceableByForEach")
public class Solution {

    // Complete the solve function below.
    static long solve(int[][] shots0, int[][] players) {
        // presort array
        Arrays.sort(shots0, (o1, o2) -> Integer.compare(o2[0], o1[0]));

        // presort mirror array
        int[][] shots1 = Arrays.copyOf(shots0, shots0.length);
        Arrays.sort(shots1, Comparator.comparingInt(o -> o[1]));

        // essence
        int[] ints1 = Arrays.stream(shots1).mapToInt(value -> value[1]).toArray();
        int[] ints0 = Arrays.stream(shots0).mapToInt(value -> value[0]).toArray();

        // max available
        int n = shots0.length;

        // summarize
        int sum = 0;
        for (int i = 0; i < players.length; ++i) {
            int s = players[i][0];
            int e = players[i][1];

            // int j = (int) Arrays.stream(ints1).filter(value -> value < s).count();
            int j = lesser(ints1, s);

            // int k = (int) Arrays.stream(ints0).filter(value -> value > e).count();
            int k = grater(ints0, e);

            int x = n - j - k;

            sum += x;
        }

        return sum;
    }

    // array is presorted
    private static int lesser(int[] a, int x) {
        // bloody enterprise solution is a bit slower than needed :(
        // return (int) Arrays.stream(a).filter(value -> value < x).count();

        // hackerranky brainfuck solution is a bit faster, yea :)
        if (x <= a[0])
            return 0;
        if (a[a.length - 1] < x)
            return a.length;

        int i = 0;
        int j = a.length;

        while (j - i > 1) {
            int f = i + (j - i) / 2;
            if (a[f] < x)
                i = f;
            else
                j = f;
        }

        // NB: [i,j)
        if(a[i] < x)
            return i+1;
        else
            return i;
    }

    // array is presorted
    private static int grater(int[] a, int x) {
        // return (int) Arrays.stream(a).filter(value -> value > x).count();
        if(a[a.length-1] > x)
            return a.length-1;
        if(x >= a[0])
            return 0;

        int i = 0;
        int j = a.length;

        while (j - i > 1) {
            int f = i + (j - i) / 2;
            if (a[f] > x)
                i = f;
            else
                j = f;
        }

        // NB: [i,j)
        if(a[i] > x)
            return i+1;
        else
            return i;
    }

    // aggressively rewrite slow hackerrank boilerplate code
    public static void main(String[] args) throws IOException {
        final Scanner scanner = new Scanner(System.in);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        Object[] o = load(scanner);
        int[][] shots = (int[][]) o[0];
        int[][] players = (int[][]) o[1];
        long result = solve(shots, players);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }

    static Object[] load(Scanner scanner) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] shots = new int[n][2];
        for (int i = 0; i < n; ++i) {
            shots[i][0] = scanner.nextInt();
            shots[i][1] = scanner.nextInt();
        }
        int[][] players = new int[m][2];
        for (int i = 0; i < m; ++i) {
            players[i][0] = scanner.nextInt();
            players[i][1] = scanner.nextInt();
        }
        return new Object[]{shots, players};
    }
}
