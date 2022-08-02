package ccApr22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CCAPR22StarterC2 {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		CCAPR22StarterC2 c= new CCAPR22StarterC2();
		
		
		//loop for doing coding 
		while(tc-->0)
		{
			st= new StringTokenizer(br.readLine());
			//this is n
			int n=Integer.parseInt(st.nextToken());
			int r=Integer.parseInt(st.nextToken());
			int a[]=new int[n];
			String s[]=br.readLine().split(" ");
			for (int i = 0; i < s.length; i++) 
				a[i]=Integer.parseInt(s[i]);
			int b[]=new int[n];
			s=br.readLine().split(" ");
			for (int i = 0; i < s.length; i++) 
				b[i]=a[i]-Integer.parseInt(s[i]);
			c.quickSort(b, a, 0, n-1);
			int ptr=0;
			int res=0;
			while(ptr<n)
			{
				if(r>=a[ptr])
				
				{
					int nn=(r-a[ptr])/b[ptr];
					nn++;
					res+= nn;
					
					r-=nn*b[ptr];

				}
				ptr++;
			}
			out.println(res);
		}
		out.flush();
	}
	static int gcd(int a, int b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }
	private int partition(int arr[] , int brr[], int low, int high)
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
                int temp1 = brr[i];
                
                arr[i] = arr[j];
                brr[i] = brr[j];
                
                arr[j] = temp;
                brr[j] = temp1;
            }
        }
  
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        int temp1 = brr[i+1];
        
        arr[i+1] = arr[high];
        brr[i+1] = brr[high];
        
        arr[high] = temp;
        brr[high] = temp1;
  
        return i+1;
    }
  
  
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    private void quickSort(int arr[],int brr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is 
              now at right place */
            int pi = partition(arr,brr, low, high);
  
            // Recursively sort elements before
            // partition and after partition
            quickSort(arr,brr, low, pi-1);
            quickSort(arr,brr, pi+1, high);
        }
    }
	  
}
