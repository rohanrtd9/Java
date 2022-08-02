package CCJun22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StarterF4 {
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
			int n=Integer.parseInt(st.nextToken());
			
			int a[]=new int[n*2];
			String s[]=br.readLine().split(" ");
		
			int oddCount=0;
			for (int i = 0; i < a.length; i++) {
				a[i]=Integer.parseInt(s[i]);
				if( ( a[i]&1) == 1 )
					oddCount++;
			}
			int result=0;
			if(oddCount>=n)
			{
				result=oddCount-n;
			}
			else
			{
				int evenCount=2*n-oddCount;
				//we need an array of even elements first
				int arrEven[]=new int[evenCount];
				int ptr=0;
				int count=0;
				for (int i = 0; i < a.length; i++) {
					if( (a[i]&1)==0)
					{
						count=0;
						while((a[i]&1)==0)
						{
							count++;
							a[i]=a[i]>>1;
						}
						arrEven[ptr++]=count;
					}
				}
				sort(arrEven,0,arrEven.length-1);
				ptr=0;
				while(evenCount-->n)
					result+=arrEven[ptr++];
				
				
			}
			out.println(result);
		}
		out.flush();
	}
	static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        
  
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
  
    // Main function that sorts arr[l..r] using
    // merge()
    static void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
  
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}