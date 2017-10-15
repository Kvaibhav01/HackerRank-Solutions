import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int [] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scan.nextInt();
        }
        scan.close();

        Arrays.sort(array); //Sort the array

        int total = 0; //Mean calculation
        for (int num : array) {
            total += num;
        }
        double mean = (double) total / size;


        double median; //Median calculation
        if (size % 2 == 0) {
            median = (array[size / 2 - 1] + array[size / 2]) / 2.0;
        } else {
            median = array[size / 2];
        }


        HashMap<Integer, Integer> map = new HashMap<>(); //Mode calculation
        int maxOccurrences = 0;
        int mode = Integer.MAX_VALUE;
        for (int num : array) {
            map.merge(num, 1, Integer::sum);
            int occurrences = map.get(num);
            if (occurrences > maxOccurrences || (occurrences == maxOccurrences && num < mode)) {
                maxOccurrences = occurrences;
                mode = num;
            }
        }

    
        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
    }
}
