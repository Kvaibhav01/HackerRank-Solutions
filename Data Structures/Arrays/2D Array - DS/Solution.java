import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static int getHourGlassSum( int arr[][], int x, int y) {
    int sum = -999;
    if (x == 0 || x == 5) {
      return sum;
    } else if (y == 0 || y == 5) {
      return sum;
    } else {
      sum = arr[x-1][y-1];
      sum += arr[x][y-1];
      sum += arr[x+1][y-1];
      sum += arr[x][y];
      sum += arr[x-1][y+1];
      sum += arr[x][y+1];
      sum += arr[x+1][y+1];

      return sum;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int arr[][] = new int[6][6];
    for(int y=0; y < 6; y++){
      for(int x=0; x < 6; x++){
        arr[x][y] = in.nextInt();
      }
    }

    int maxSum = -999;
    for(int x = 0; x < 6; x++) {
      for(int y = 0; y < 6; y++) {
        int tempSum = getHourGlassSum(arr, x, y);
        if (tempSum > maxSum) {
          maxSum = tempSum;
        }
      }
    }
    System.out.printf("%d", maxSum);
  }
}
