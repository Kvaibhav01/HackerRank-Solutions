import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        
        int [] elt = new int[size];
        int [] freq = new int[size];
        
        for (int i = 0; i < size; i++) {
            elt[i] = scan.nextInt();
        }
        
        int numOfElements = 0;
        for (int i = 0; i < size; i++) {
            freq[i] = scan.nextInt();
            numOfElements += freq[i];
        }
        scan.close();
        
        
        int [] data = new int[numOfElements]; 
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < freq[i]; j++) {
                data[index] = elt[i];
                index++;
            }
        }
        Arrays.sort(data); //Sort the given data
        
        
        double q1 = findMedian(data, 0, data.length / 2 - 1);
        double q3 = findMedian(data, (data.length + 1) / 2, data.length - 1);
        System.out.println(q3 - q1); //Calculating interquartile
    }
    
    
    private static double findMedian(int [] array, int start, int end) {
        if ((end - start) % 2 == 0) { // odd number of elements
            return (array[(end + start) / 2]);
        } else { // even number of elements
            int value1 = array[(end + start) / 2];
            int value2 = array[(end + start) / 2 + 1];
            return (value1 + value2) / 2.0;
        }
    }
}
