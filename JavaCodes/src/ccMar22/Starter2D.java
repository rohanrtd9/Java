package ccMar22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Starter2D {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		Starter2D stc=new Starter2D();
		//loop for doing coding 
		while(tc-->0)
		{
			st= new StringTokenizer(br.readLine());
			//this is n
			int n=Integer.parseInt(st.nextToken());
			int a[]=new int[n];
			String s[]=br.readLine().split(" ");
			for (int i = 0; i < s.length; i++) 
				a[i]=Integer.parseInt(s[i]);
			
			int b[]=new int[n];
			s=br.readLine().split(" ");
			for (int i = 0; i < s.length; i++) 
				b[i]=Integer.parseInt(s[i]);
			stc.quickSort(b, a, 0, n-1);
		
			out.println();
		}
		out.flush();
	}
	static int gcd(int a, int b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }
	private int partition(int arr[],int arr1[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
  
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                int temp1 = arr1[i];
                arr1[i] = arr1[j];
                arr1[j] = temp1;
                
                
            }
        }
  
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        int temp1 = arr1[i+1];
        arr1[i+1] = arr1[high];
        arr1[high] = temp1;
        
        return i+1;
    }
  
  
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    private void quickSort(int arr[],int arr1[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is 
              now at right place */
            int pi = partition(arr,arr1, low, high);
  
            // Recursively sort elements before
            // partition and after partition
            quickSort(arr,arr1, low, pi-1);
            quickSort(arr,arr1, pi+1, high);
        }
    }
}
