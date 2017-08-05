import java.util.Scanner;

public class Sorting 
{

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) 
        {
            arr[i] = in.nextInt();
        }


        int numOfSwaps = 0;
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n - 1; j++) 
            {
                if (arr[j] > arr[j + 1]) 
                {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    numOfSwaps++;
                }
            }

            if (numOfSwaps == 0) 
            {
                break;
            }
        }

        System.out.println("Array is sorted in " + numOfSwaps + " swaps.");
        System.out.println("First Element: " + arr[0]);
        System.out.println("Last Element: " + arr[arr.length - 1]);
    }
}
