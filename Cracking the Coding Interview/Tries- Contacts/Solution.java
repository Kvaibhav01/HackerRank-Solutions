import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  private static class Node {
    int numberOfEntries;
    Map<Character, Node> entries;

    public Node() {
      numberOfEntries = 0;
      entries = new HashMap<Character,Node>();
    }

    public void incrementCount() {
      numberOfEntries++;
    }

    public int getNumberOfEntries() {
      return numberOfEntries;
    }

    public Map<Character,Node> getEntries() {
      return entries;
    }
  }

  public static void insert(String toInsert, Node root) {
    if ((toInsert == null) || (toInsert.length() == 0)) {
      return;
    }

    Character nextChar = toInsert.charAt(0);
    String remainingString = toInsert.substring(1);

    if(root.getEntries().get(nextChar) == null) {
      root.getEntries().put(nextChar, new Node());
    }

    root.getEntries().get(nextChar).incrementCount();

    insert(remainingString, root.getEntries().get(nextChar));
  }

  public static int find(String toFind, Node root) {

    if ((toFind == null) || (toFind.length() == 0)) {
      return root.getNumberOfEntries();
    }

    Character nextChar = toFind.charAt(0);
    String remainingString = toFind.substring(1);

    if(root.getEntries().get(nextChar) == null) {
      return 0;
    }
    return find(remainingString, root.getEntries().get(nextChar));
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Node root = new Node();
    int n = in.nextInt();

    for(int a0 = 0; a0 < n; a0++){
      String op = in.next();
      String contact = in.next();

      if ("add".equals(op)) {
        insert(contact,root);
      }
      else if("find".equals(op)) {

      int count = find(contact, root);
      System.out.printf("%d\n", count);
      }
    }
  }
}
