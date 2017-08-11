import java.util.Scanner;

public class Nested 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);

        int days = in.nextInt();
        int months = in.nextInt();
        int years = in.nextInt();

        int da = in.nextInt();
        int mo = in.nextInt();
        int ye = in.nextInt();

        int fine = 0;

        if (years > ye) 
          fine = 10000;
        else if (years == ye) 
        {
            if (months > me) 
              fine = (months - me) * 500;
            else if ((months == me) && (days > de)) 
              fine = (days - de) * 15;
        }

        System.out.println(fine);
    }
}
