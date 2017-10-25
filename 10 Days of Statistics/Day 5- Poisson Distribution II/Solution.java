import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    double A = scan.nextDouble();
    double B = scan.nextDouble();

    scan.close();

    /* The formula used below is E[x^2] = lambda + lambda^2 */
    double costA = 160 + 40 * (A + (A * A));
    double costB = 128 + 40 * (B + (B * B));

    System.out.format("%.3f%n", costA);
    System.out.format("%.3f%n", costB);
  }
}
