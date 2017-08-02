import java.util.Scanner;

public class Exception 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        String string = in.next();
        in.close();
        
        try 
        {
            Integer integer = Integer.parseInt(string);
            System.out.println(integer);
        } 
        catch (NumberFormatException numberException) 
        {
            System.out.println("Bad String");
        }
    }
}
