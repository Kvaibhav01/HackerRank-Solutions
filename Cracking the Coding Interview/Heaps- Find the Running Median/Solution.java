import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  // We use the concept of Comparators to create our min/max heaps

  private static Comparator<Integer> minComparator = new Comparator<Integer>() {
    @Override
    public int compare(Integer first, Integer second) {
      return first.compareTo(second);
    }
  };

  private static Comparator<Integer> maxComparator = new Comparator<Integer>() {
    @Override
    public int compare(Integer first, Integer second) {
      return second.compareTo(first);
    }
  };

  private static PriorityQueue<Integer> minSortedQueue = new PriorityQueue<Integer>(100,minComparator);
  private static PriorityQueue<Integer> maxSortedQueue = new PriorityQueue<Integer>(100,maxComparator);

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    ArrayList<Integer> foundValues;
    int n = in.nextInt();

    for(int currentIndex=1; currentIndex <= n; currentIndex++){
      Integer value = Integer.valueOf(in.nextInt());
      double median = -1;

      // Code to balance the tree
      if (currentIndex % 2 == 0) {
        maxSortedQueue.add(value);
      } else {
        minSortedQueue.add(value);
      }

    
      if (minSortedQueue.size() > 0 && maxSortedQueue.size() > 0) {
        if (minSortedQueue.peek() < maxSortedQueue.peek()) {
          Integer maxSortedValue = maxSortedQueue.poll();
          Integer minSortedValue = minSortedQueue.poll();
          minSortedQueue.add(maxSortedValue);
          maxSortedQueue.add(minSortedValue);
        }
      }

      // Extracting the medium
      if (currentIndex == 1) {
        median = value;
      } else if (currentIndex % 2 != 0) {
        median = minSortedQueue.peek();
      } else {
        double sum = (minSortedQueue.peek() + maxSortedQueue.peek());
        median = sum/2.0;
      }

      System.out.printf("%.1f\n", median);
    }
  }
}

