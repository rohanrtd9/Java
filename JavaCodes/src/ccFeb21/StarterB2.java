package ccFeb21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StarterB2 {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());

		//loop for doing coding 
		while(tc-->0)
		{
			st= new StringTokenizer(br.readLine());
			//this is number of test cases
			int n=Integer.parseInt(st.nextToken());
			int a[]=new int[2*n];
			String s[]=br.readLine().split(" ");
			//we sort the array
			for (int i = 0; i < a.length; i++) {
				a[i]=Integer.parseInt(s[i]);
			}
			StarterB2 sb2= new StarterB2();
			sb2.quickSort(a, 0, a.length-1);
			
			int counter=0;
			int i=0;
			boolean flag=true;
			
			while(i<(2*n)-1)
			{
				//if there is an element which isnt equal to current a[i ]
				//then we can break the array into two parts
				if(counter++ != a[i])
				{
					
					break;
				}
				int counterElement=1;
				while( (i<(2*n)-1) && (a[i]==a[i+1]) )
				{
					counterElement++;
					i++;
				}
				//if odd then we break
				if((counterElement)==1)
				{
					flag=false;
					break;
				}
				i++;
				
			}
			if(flag==true)
				out.println("YES");
			else
				out.println("NO");
			
		}
		out.flush();
	}
	private int partition(int arr[], int low, int high)
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
            }
        }
  
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
  
        return i+1;
    }
  
  
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    private void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is 
              now at right place */
            int pi = partition(arr, low, high);
  
            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
}
