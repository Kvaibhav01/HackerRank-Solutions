import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution
{

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    int money = in.nextInt();
    int numberOfCoins = in.nextInt();
    int coins[] = new int[numberOfCoins];

    for(int coins_i=0; coins_i < numberOfCoins; coins_i++)
    {
      coins[coins_i] = in.nextInt();
    }

    Arrays.sort(coins);
    long totalCombinations = 0;

    long combinations[] = new long[money+1];
    combinations[0] = 1;

    for( int i = 0; i < coins.length ; i++)
    {
      int coin = coins[i];

      for( int j = coin; j <= money; j++ )
      {
        combinations[j] += combinations[j-coin];
      }
    }

    System.out.println(combinations[money]);

  }
}
