import java.util.*;


public class Solution 
{
  Map<String, Integer> magMap;
  Map<String, Integer> noteMap;

  public Solution(String mag, String note) { 
    Collection<String> magStrings = Arrays.asList(mag.split(" "));
    Collection<String> noteStrings = Arrays.asList(note.split(" "));
    magMap = new HashMap<String,Integer>();
    noteMap = new HashMap<String,Integer>();

    for(String value : magStrings) 
    {
      if (magMap.get(value) == null) {
        magMap.put(value, 0);  
      }
      Integer currentValue = magMap.get(value);
      currentValue++;
      magMap.put(value,currentValue);
    }

    for(String value : noteStrings) {
      if (noteMap.get(value) == null) {
        noteMap.put(value, 0);  
      }
      Integer currentValue = noteMap.get(value);
      currentValue++;
      noteMap.put(value,currentValue);
    }
  }

  public boolean solve() 
  {
    for(String ransomWord : noteMap.keySet()) {
      Integer ransomValue   = noteMap.get(ransomWord);
      Integer magValue = magMap.get(ransomWord);

      if ((magValue == null) || (ransomValue > magValue)) 
      {
        return false;  
      }
    }
    return true;
  }

  public static void main(String[] args) 
  {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    int n = scanner.nextInt();
    
    scanner.nextLine();

    Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
    scanner.close();

    boolean answer = s.solve();
    
    if(answer)
      System.out.println("Yes");
    else 
      System.out.println("No");
  }
}
