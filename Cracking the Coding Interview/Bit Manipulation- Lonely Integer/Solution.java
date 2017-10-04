import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  public static int lonelyInteger(int a[], int counts[]) {
    for( int i = 0; i < a.length; i++) {
      int value = a[i];
      counts[value]++;
    }

    for( int i = 0; i < counts.length; i++) {
      if (counts[i] == 1) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int a[] = new int[n];
    int maxInt = 0;
    for(int a_i=0; a_i < n; a_i++){
      int nextInt = in.nextInt();
      a[a_i] = nextInt;
      if (nextInt > maxInt) {
        maxInt = nextInt;
      }
    }
    int counts[] = new int[maxInt+1];
    System.out.println(lonelyInteger(a, counts));
  }
}
