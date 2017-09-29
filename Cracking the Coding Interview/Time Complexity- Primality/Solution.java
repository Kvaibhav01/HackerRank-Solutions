import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  static List<Integer> primes;

  private static List<Integer> populatePrimeList() {
    List<Boolean> sieve = new ArrayList<Boolean>();
    List<Integer> primes = new ArrayList<Integer>();
    double maxInt = Math.ceil(Math.sqrt(2000000000));

    // Make a sieve
    for (int i = 0; i <= maxInt; i++ ) {
      sieve.add(true);
    }

    for (int i = 2; i <= maxInt; i++ ) {
      if(sieve.get(i) == true) {
        primes.add(i);
        for (int j = i; j <= maxInt ; j += i) {
          sieve.set(j,false);
        }
      }
    }

    return primes;
  }

  private static boolean isPrime(int valueToCheck) {

    if (valueToCheck == 1) {
      return false;
    }

    for (Integer i : primes) {
      if (i >= valueToCheck) {
        return true;
      } else if (valueToCheck % i == 0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {

    primes = populatePrimeList();

    Scanner in = new Scanner(System.in);
    int p = in.nextInt();
    for(int a0 = 0; a0 < p; a0++){
      int n = in.nextInt();
      if (isPrime(n)) {
        System.out.printf("%s\n", "Prime" );
      } else {
        System.out.printf("%s\n", "Not prime");
      }
    }
  }
}
