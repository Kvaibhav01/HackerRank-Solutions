import java.util.*;

public class Solution
{
  private static Map<Integer, Integer> fibonacciNumbers;

  public static int fibonacci(int n)
  {
    if (n==0)
    {
      return 0;
    }
    else if (n==1)
    {
      return 1;
    }
    else if (fibonacciNumbers.get(n)!=null)
    {
      return fibonacciNumbers.get(n);

    }
    else
    {
      Integer thisNumber = fibonacci(n-1) + fibonacci(n-2);
      fibonacciNumbers.put(n,thisNumber);
      return thisNumber;
    }
  }

  public static void main(String[] args) {
    fibonacciNumbers = new HashMap<>();
    fibonacciNumbers.put(0,0);
    fibonacciNumbers.put(1,1);
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.close();
    System.out.println(fibonacci(n));
  }
}
