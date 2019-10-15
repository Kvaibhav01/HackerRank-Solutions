import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author michael.malevannyy@gmail.com, 16.10.2019
 */
public class Solution {

    // Complete the travelAroundTheWorld function below.
    private static int travelAroundTheWorld(final int[] a, final int[] b, final long c) {
        final int N = a.length;

        // pre calculated deltas
        int[] d = new int[N];
        // possible = 0, impossible =  -1
        int[] imp = new int[N];

        // format deltas and calc balance in one step
        boolean chocolate = true;
        long sigma = 0;
        for (int i = 0; i < N; i++) {
            int di = d[i] = ((int) (a[i] < c ? a[i] : c) - b[i]);  // delta(a[i], b[i], c);
            sigma += di;
            if(chocolate && di<0)
                chocolate = false;
        }

        // chocolate branch = all is fine
        if (chocolate)
            return N;

        // impossible at all
        if(sigma<0)
            return 0;

        // debt <=0 by design
        int borrow = 0;

        // run along the deltas in the opposite direction in search of holes,
        // p additionally accelerates to the smallest hole passed
        // if there is outstanding debt then you can go to the second round, but not the third!
        for (int p = N-1; (borrow < 0 || p >=0) && p > -N; --p) {
            // cyclic index
            int i = p >= 0 ? p : p + N;

            // current delta
            int di = d[i];

            if (borrow >= 0 && di >= 0)
                continue;

            // this debt will not be able to cross this point because its passage takes the entire fuel tank
            if(borrow < 0 && b[i] == c)
                return 0;


            // if there was no debt, then it can both appear and be lost and remain unchanged, but definitely borrow <= 0
            borrow += di;

            // by design borrow <=0
            if(borrow > 0)
                borrow = 0;

            // complete
            if(borrow < 0)
                imp[i] = 1;
        }

        int qu = 0;
        for (int i = 0; i < N; i++) {
            if(imp[i] == 0)
                qu++;
        }

        return qu;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nc = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nc[0].trim());

        long c = Long.parseLong(nc[1].trim());

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[n];

        String[] bItems = scanner.nextLine().split(" ");

        for (int bItr = 0; bItr < n; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        int result = travelAroundTheWorld(a, b, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
