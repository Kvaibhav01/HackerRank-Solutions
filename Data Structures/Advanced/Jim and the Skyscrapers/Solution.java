import java.io.*;
import java.util.*;

public class Solution {

    // Complete the solve function below.
    static int H = 1_000_000+1;

    static long solve(int[] arr) {

        int[] h = new int[H];

        long k = 0;

        for (int i = 0; i < arr.length; ++i) {
            int a = arr[i];

            // 1) close own strarted
            k+=h[a];
            ++h[a];

            // 2) kill smallers
            if(i>0 && arr[i-1] < a) {
                for (int j = 0; j < a; ++j)
                    h[j] = 0;
            }

        }

        return 2*k;
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
