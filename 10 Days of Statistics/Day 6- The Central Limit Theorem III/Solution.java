public class Solution {
    public static void main(String[] args) {
        /* Initialised and declared the given values */
        double mean   = 500;
        double std    = 80;
        int    n      = 100;
        double zScore = 1.96; 
        
        double marginOfError = zScore * std / Math.sqrt(n);

        System.out.format("%.2f%n", mean - marginOfError);
        System.out.format("%.2f%n", mean + marginOfError);
    }
}
