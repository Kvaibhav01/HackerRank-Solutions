import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      double lambda = scan.nextDouble();
      int k = scan.nextInt();
      scan.close();

      System.out.println(poisson(k, lambda));
    }

    /* Calculate Poisson's Distribution */
    private static double poisson(int k, double lambda)
    {
      return (Math.pow(lambda, k) * Math.pow(Math.E, -1 * lambda)) / factorial(k);
    }

    private static Long factorial(int n)
    {
      if (n<0) {
        return null;
        }
      long res = 1; //Initialise result
      while (n>0) {
        res *= n--;
      }
      return res;
    }
}
