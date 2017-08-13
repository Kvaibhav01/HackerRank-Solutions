import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Regex 
{

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        String[] str=new String[N];
        
        int i=0;
        
        Pattern p = Pattern.compile("[a-z]+@gmail.com"); 
        
        ArrayList<String> arr=new ArrayList();
        
        Matcher m;
        
        for(int a0 = 0; a0 < N; a0++)
        {
            String firstName = in.next();
            String emailID = in.next();
            m=p.matcher(emailID);
            
            if(m.find())
              arr.add(firstName.toLowerCase());        
        }
        
        Collections.sort(arr);
        
        for(String s:arr)
        {
            System.out.println(s);    
        
        }
    }
}
