import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  private static void swap(int a[], int elt1, int elt2 ) {
    int temp = a[elt1];
    a[elt1] = a[elt2];
    a[elt2] = temp;
  }

  private static int bubbleSort(int a[], int n) {
    int totalSwaps = 0;
    for (int i = 0; i < n; i++) {

      int numberOfSwaps = 0;

      for (int j = 0; j < n - 1; j++) {
        if (a[j] > a[j + 1]) {
          swap(a, j, j + 1);
          numberOfSwaps++;
        }
      }

      totalSwaps += numberOfSwaps;


      if (numberOfSwaps == 0) {
        break;
      }
    }
    return totalSwaps;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int a[] = new int[n];
    for(int a_i=0; a_i < n; a_i++){
      a[a_i] = in.nextInt();
    }

    int swapCount = bubbleSort(a,n);
    System.out.printf("Array is sorted in %d swaps.\n", swapCount);
    System.out.printf("First Element: %d\n", a[0]);
    System.out.printf("Last Element: %d\n", a[n-1]);
  }
}
