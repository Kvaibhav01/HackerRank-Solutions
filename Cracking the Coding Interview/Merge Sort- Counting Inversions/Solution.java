import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  static long globalSwapCount;
  static long globalInversionCount;

  public static int[] mergeSort(int arr[]){

    if ((arr.length == 0) || (arr.length == 1)) {
      return arr;
    }

    int half = arr.length/2;

    // Split the array in half
    int leftSide[] = new int[half];
    int rightSide[] = new int[arr.length - half];

    for (int i = 0; i < half; i++) {
      leftSide[i] = arr[i];
    }

    for (int i = half ; i < arr.length; i++ ) {
      rightSide[i-half] = arr[i];
    }

    // Sort the array
    leftSide = mergeSort(leftSide);
    rightSide = mergeSort(rightSide);
    int result[] = merge(leftSide, rightSide);
    return result;
  }

  public static int[] merge(int left[], int right[]) {
    int totalLength = left.length + right.length;
    int result[] = new int[totalLength];
    int currentIndex = 0;
    int leftIndex = 0;
    int rightIndex = 0;

    // Sort beginning
    while (leftIndex < left.length && rightIndex < right.length) {

      if (right[rightIndex] < left[leftIndex]) {
        result[currentIndex] = right[rightIndex];

        globalSwapCount += left.length - leftIndex;
        rightIndex++;
      } else {
        result[currentIndex] = left[leftIndex];
        leftIndex++;
      }
      currentIndex++;
    }

    while (leftIndex < left.length) {
      result[currentIndex] = left[leftIndex];
      leftIndex++;
      currentIndex++;
    }

    while (rightIndex < right.length) {
      result[currentIndex] = right[rightIndex];
      rightIndex++;
      currentIndex++;
    }

    return result;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int a0 = 0; a0 < t; a0++){
      globalSwapCount = 0;
      int n = in.nextInt();
      int arr[] = new int[n];
      for(int arr_i=0; arr_i < n; arr_i++){
        int nextInt = in.nextInt();
        arr[arr_i] = nextInt;
      }
      arr = mergeSort(arr);
      System.out.printf("%s\n", globalSwapCount);
    }
  }
}
