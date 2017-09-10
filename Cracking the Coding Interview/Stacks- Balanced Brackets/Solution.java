import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{ public static boolean isBalanced(String expression) 
  {
    Stack<Character> openBrackets = new Stack<Character>();

    for( Character c : expression.toCharArray()) 
    {
      if (isOpen(c)) 
      {
        openBrackets.push(c);
      } 
      else if(openBrackets.isEmpty()) 
      {
        return false;
      } 
      else 
      {
        Character open = openBrackets.pop();

        if (!isPair(open,c)) 
        {
          return false;
        }
      }
    }

    
    if (openBrackets.size() > 0) 
    {
      return false;
    }
    return true;
  }

    private static boolean isOpen(Character c) 
    {
    return c != null && (c.equals('(') || c.equals('[') || c.equals('{'));
  }

  private static boolean isPair(Character open, Character close) 
  {
    if (open == null || close == null) 
    {
      return false;
    } 
    else if (open.equals('(') && close.equals(')')) 
    {
      return true;
    } 
    else if (open.equals('[') && close.equals(']')) 
    { 
      return true;
    } 
    else if (open.equals('{') && close.equals('}')) 
    {
      return true;
    } 
    else 
    {
      return false;
    }
  }

  public static void main(String[] args) 
  {

    Scanner in = new Scanner(System.in);

    int t = in.nextInt();

    for(int a0 = 0; a0 < t; a0++) 
    {
      String expression = in.next();
      boolean answer = isBalanced(expression);

      if(answer)
        System.out.println("YES");
      else System.out.println("NO");
    }
  }
}
