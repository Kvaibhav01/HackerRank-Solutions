import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class IceCream implements Comparable{
    int flavorCost;
    int index;

    public IceCream(int flavorCost, int index) {
      this.flavorCost = flavorCost;
      this.index = index;
    }

    @Override
    public int compareTo(Object o) {

       IceCream compareTo = (IceCream) o;

       if ( compareTo.flavorCost == flavorCost ) {
           return 0;
       } else if (compareTo.flavorCost < flavorCost) {
           return 1;
       } else  {
           return -1;
       }
    }

    @Override
    public boolean equals(Object o){
        IceCream compareTo = (IceCream) o;
        return( flavorCost == compareTo.flavorCost && index == compareTo.index );
    }

    @Override
    public String toString() {
        return "Flavor Cost: " + flavorCost +  " Index: " + index;
    }

}

public class Solution {

  public static int binarySearch(int first, int last, IceCream[] arr, int search) {

    int searchIndex = (first+last)/2;

    if (first > last ) {
      return -1;
    } else if (arr[searchIndex].flavorCost == search) {
      return searchIndex;
    } else {

      int searchLeft = binarySearch(first, searchIndex -1, arr, search);
      if (searchLeft != -1) {
        return searchLeft;
      }
      int searchRight = binarySearch(searchIndex + 1, last, arr, search);

      return searchRight;

    }
  }

  public static void main(String[] args) {

    int t;
    int n, m;

    Scanner in = new Scanner(System.in);
    t = in.nextInt();
    for(int test = 0; test < t; test++) {

      m = in.nextInt();
      n = in.nextInt();
      IceCream flavors[] = new IceCream[n];
      int currentIndex = 0;

      for (int i = 0; i < n; i++) {
        int costOfFlavor = in.nextInt();
        flavors[i] = new IceCream(costOfFlavor, i + 1);
      }

      Arrays.sort(flavors);

      for(int i = 0; i < n - 1 ; i++) {

        int search = m - flavors[i].flavorCost;

        if(search >= flavors[i].flavorCost) {
          int startLocation = i + 1;
          int endLocation   = n - 1;
          int foundLocation = binarySearch( startLocation, endLocation, flavors, search);

          if (foundLocation != -1) {
            int searchIndex = flavors[i].index;
            int foundIndex = flavors[foundLocation].index;

            //We need to print the lowest index first

            if (searchIndex < foundIndex) {
              System.out.printf("%d %d\n", searchIndex, foundIndex);
            } else {
              System.out.printf("%d %d\n", foundIndex, searchIndex);
            }
            break;
          }
        }

      }
    }
  }
}
