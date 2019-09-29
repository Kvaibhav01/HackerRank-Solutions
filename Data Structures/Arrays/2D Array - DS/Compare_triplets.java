import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        //For iterating over the lists
        Iterator itr1 = a.iterator();
        Iterator itr2 = b.iterator();

        //For storing the points
        int suma=0;
        int sumb=0;

        //For storing the current value of the list
        int check1=0;
        int check2=0;

        while(itr1.hasNext() && itr2.hasNext()){
            check1 = (int)itr1.next();
            check2 = (int)itr2.next();

            if(check1>check2){
                suma++;
            } else if(check1<check2){
                sumb++;
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        result.add(suma);
        result.add(sumb);
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );
        bufferedReader.close();
        bufferedWriter.close();
    }
}
