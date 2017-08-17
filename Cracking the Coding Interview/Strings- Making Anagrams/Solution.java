import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution 
{
  
  public static int numberNeeded(String first, String second) {
    

    int offset        = (int) 'a';
    int firstArray[]  = new int[26];
    int secondArray[] = new int[26];
    int numberNeeded  = 0;

    for (char value : first.toCharArray()) 
    {
      int characterValue = (int) value - offset;
      firstArray[characterValue]++;
    }

    for (char value : second.toCharArray()) 
    {
      int characterValue = (int) value - offset;
      secondArray[characterValue]++;
    }

    for (int i = 0 ; i < 26; i++) {
      numberNeeded += Math.abs(firstArray[i] - secondArray[i]);
    }

    return numberNeeded;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String a = in.next();
    String b = in.next();
    System.out.println(numberNeeded(a, b));
  }
}
