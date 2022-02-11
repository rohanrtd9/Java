package Utility;

import java.util.Arrays;

public class LIS {

    /*
    * lis() returns the length of the longest
    * increasing subsequence in arr[] of size n
    */
    static int lis(int[] arr, int n)
    {
        int max = 0;
        int[] lst = new int[n];
 
        // initialize LIS values for all indexes
        Arrays.fill(lst, 1);
 
        /* Compute optimized LIS values
        in bottom up manner */
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (arr[i] > arr[j] &&
                    lst[i] < lst[j] + 1)
                    lst[i] = lst[j] + 1;
            }
        }
 
        /* Pick maximum of all LIS values */
        for (int i = 0; i < n; i++)
            if (max < lst[i])
                max = lst[i];
 
        return max;
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        int[] arr = {7,6,5,7,1,2,3,4};
        int n = arr.length;
        System.out.println("Length of lis is " +
                                   lis(arr, n));
    }
}