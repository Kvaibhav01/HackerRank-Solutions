import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution
{
  private static Map<Integer,Integer> staircaseCount;

  private static int stepsCount (int numberOfStairs)
  {
    if (staircaseCount.get(numberOfStairs) != null)
    {
      return staircaseCount.get(numberOfStairs);
    }
    else if (numberOfStairs == 0)
    {
      return 1;
    }
    else if (numberOfStairs < 0)
    {
      return 0;
    }
    else
    {
      int currentCount = 0;
      currentCount += stepsCount(numberOfStairs-3);
      currentCount += stepsCount(numberOfStairs-2);
      currentCount += stepsCount(numberOfStairs-1);

      staircaseCount.put(numberOfStairs,currentCount);
      return currentCount;
  }

}

public static void main(String[] args)
{
    staircaseCount = new HashMap<Integer,Integer>();
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();

    for(int a0 = 0; a0 < s; a0++)
    {
      int n = in.nextInt();
      int staircaseCount = stepsCount(n);
      System.out.printf("%d\n", staircaseCount);
    }
  }
}
