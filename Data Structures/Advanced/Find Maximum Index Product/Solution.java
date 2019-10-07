import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the solve function below.
    // here a bug on Hackerrank:
    // test case 0 produces 2500100000L, but (int)2500100000L = -1794867296
    // so solve function must be declared long, not int !!!
    static long solve(int[] arr) {
        long max = 0;

        for (int i = 0; i < arr.length; i++) {
            long m = indexProduct(arr, i);
            if (m > max)
                max = m;
        }

        return max;
    }

    private static long indexProduct(int[] arr, int i) {
        int left = 0;
        int right = 0;
        int a = arr[i];


        // left
        for (int j = i - 1; j >= 0; --j) {
            if (arr[j] > a) {
                left = j+1;
                break;
            }
        }

        if (left == 0)
            return 0;

        // right
        for (int j = i + 1; j < arr.length; ++j) {
            if (arr[j] > a) {
                right = j+1;
                break;
            }
        }

        if (right == 0)
            return 0;

        return (long)left * (long)right;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int arrItr = 0; arrItr < arrCount; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr]);
            arr[arrItr] = arrItem;
        }

        long result = solve(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
