public class Solution {
    public static void main(String[] args) {
        /* Initialise and declare the given values */ 
        double mean      = 205;
        double std       = 15;
        double maxWeight = 9800;
        int    n         = 49;
        
        /* Apply formulae given in tutorial */
        double samplesMean = n * mean;
        double samplesSTD  = Math.sqrt(n) * std;
        
        System.out.format("%.4f", cumulative(samplesMean, samplesSTD, maxWeight));
    }
    
    /* Calculate cumulative probability */
    public static double cumulative(double mean, double std, double x) {
        double parameter = (x - mean) / (std * Math.sqrt(2));
        return (0.5) * (1 + erf(parameter));
    }
    
    public static double erf(double z) {
        double t = 1.0 / (1.0 + 0.5 * Math.abs(z));

        // using Horner's method
        double ans = 1 - t * Math.exp( -z*z   -   1.26551223 +
                                            t * ( 1.00002368 +
                                            t * ( 0.37409196 + 
                                            t * ( 0.09678418 + 
                                            t * (-0.18628806 + 
                                            t * ( 0.27886807 + 
                                            t * (-1.13520398 + 
                                            t * ( 1.48851587 + 
                                            t * (-0.82215223 + 
                                            t * ( 0.17087277))))))))));
        if (z >= 0) return  ans;
        else        return -ans;
    }
}
