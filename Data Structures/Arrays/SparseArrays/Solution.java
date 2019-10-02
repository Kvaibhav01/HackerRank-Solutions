import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Problem on usage of HashMap
    // Find the number of occurences of every string in the strings array, and then just retrieve 
    // this value for every string in queries, and 0 if there is no such string in the hashmap
    // Complexity: O(N)
    static int[] matchingStrings(String[] strings, String[] queries) {
        Map<String, Integer> map = new HashMap();
        // NOTICE THIS LINE BREAK
        for(String s: strings)
        {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        // NOTICE THIS LINE BREAK
        int[] res = new int[queries.length];
        // NOTICE THIS LINE BREAK
        for(int i = 0; i<queries.length; i++)
        {
            if(map.containsKey(queries[i]))
            {
                res[i] = map.get(queries[i]);
            }
            // NOTICE THIS LINE BREAK
            else {
                res[i] = 0;
            }
        }
        return res;
        // NOTICE THIS LINE BREAK

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException 
    {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) 
        {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++)
        {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) 
        {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}



