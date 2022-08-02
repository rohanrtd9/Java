package ccApr22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CCAPR22STARTERC {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		CCAPR22STARTERC cc=new CCAPR22STARTERC();
		//loop for doing coding 
		while(tc-->0)
		{
			st= new StringTokenizer(br.readLine());
			//this is n
			int n=Integer.parseInt(st.nextToken());
			int evenParity[]=new int[n];
			int oddParity[]=new int[n];
			int j=0,k=0;
			String s[]=br.readLine().split(" ");
			for (int i = 0; i < s.length; i++) 
				if ((Integer.parseInt(s[i])&1)==0)
					evenParity[j++]=Integer.parseInt(s[i]);
				else
					oddParity[k++]=Integer.parseInt(s[i]);
			cc.quickSortDesc(evenParity, 0, j-1);
			cc.quickSortDesc(oddParity, 0, k-1);
			
			
			out.println(	Math.max	(	Math.max(cc.makeMaxScore(0, evenParity, j, oddParity, k),cc.makeMaxScore(1, evenParity, j, oddParity, k))
					,Math.max	(	cc.makeMaxScore(2, evenParity, j, oddParity, k),cc.makeMaxScore(3, evenParity, j, oddParity, k))));
		}
		out.flush();
	}
	private int makeMaxScore(int key, int evenParity[],int j,int oddParity[], int k)
	{
		int scoreAlice=0;
		//here key denotes the possible scenario
		//when we give 0 then 1 2 both pick even
		if(key==0)
		{
			boolean aliceCanMove=true,bobCanMove=true;
			int aliceTurn=0,bobTurn=0;
			int j1=0,k1=0;
			if(j1<j)
			{
				scoreAlice+=evenParity[j1++];
				if(j1<j)
					j1++;
				else
					bobCanMove=false;
			}
			else
			{
				aliceCanMove=false;
				bobCanMove=false;
			}
			while( aliceCanMove || bobCanMove)
			{
				if(aliceCanMove)
				{
					if(aliceTurn==0)
					{
						if(j1<j)
						{
							scoreAlice+=evenParity[j1++];
						}
						else
							aliceCanMove=false;
					}
					else
					{
						if(k1<k)
						{
							scoreAlice+=oddParity[k1++];
						}
						else
							aliceCanMove=false;
					}
				}
				if(bobCanMove)
				{
					if(bobTurn==0)
					{
						if(j1<j)
							j1++;
						else
							bobCanMove=false;
					}
					else
					{
						if(k1<k)
							k1++;
						else
							bobCanMove=false;
					}
				}
				
			}
			
		}
		//when we give 1 then 1 pick odd 2 pick even
		if(key==1)
		{
			boolean aliceCanMove=true,bobCanMove=true;
			int aliceTurn=1,bobTurn=0;
			int j1=0,k1=0;
			if(k1<k)
				scoreAlice+=oddParity[k1++];
			else
				aliceCanMove=false;
			
			if(j1<j)
				j1++;
			else
				bobCanMove=false;
			
			while( aliceCanMove || bobCanMove)
			{
				if(aliceCanMove)
				{
					if(aliceTurn==0)
					{
						if(j1<j)
						{
							scoreAlice+=evenParity[j1++];
						}
						else
							aliceCanMove=false;
					}
					else
					{
						if(k1<k)
						{
							scoreAlice+=oddParity[k1++];
						}
						else
							aliceCanMove=false;
					}
				}
				if(bobCanMove)
				{
					if(bobTurn==0)
					{
						if(j1<j)
							j1++;
						else
							bobCanMove=false;
					}
					else
					{
						if(k1<k)
							k1++;
						else
							bobCanMove=false;
					}
				}
				
			}
			
		}
		//when we give 2 then 1 2 both pick odd
		if(key==2)
		{
			boolean aliceCanMove=true,bobCanMove=true;
			int aliceTurn=1,bobTurn=1;
			int j1=0,k1=0;
			if(k1<k)
			{
				scoreAlice+=oddParity[k1++];
				if(k1<k)
					k1++;
				else
					bobCanMove=false;
			}
			else
			{
				aliceCanMove=false;
				bobCanMove=false;
			}
			
			while( aliceCanMove || bobCanMove)
			{
				if(aliceCanMove)
				{
					if(aliceTurn==0)
					{
						if(j1<j)
						{
							scoreAlice+=evenParity[j1++];
						}
						else
							aliceCanMove=false;
					}
					else
					{
						if(k1<k)
						{
							scoreAlice+=oddParity[k1++];
						}
						else
							aliceCanMove=false;
					}
				}
				if(bobCanMove)
				{
					if(bobTurn==0)
					{
						if(j1<j)
							j1++;
						else
							bobCanMove=false;
					}
					else
					{
						if(k1<k)
							k1++;
						else
							bobCanMove=false;
					}
				}
				
			}
			
		}
		//when we give 3 then 1 pick even 2 pick odd
		if(key==3)
		{
			boolean aliceCanMove=true,bobCanMove=true;
			int aliceTurn=0,bobTurn=1;
			int j1=0,k1=0;
			if(j1<j)
				scoreAlice+=evenParity[j1++];
			else
				aliceCanMove=false;
			
			if(k1<k)
				k1++;
			else
				bobCanMove=false;
			
			while( aliceCanMove || bobCanMove)
			{
				if(aliceCanMove)
				{
					if(aliceTurn==0)
					{
						if(j1<j)
						{
							scoreAlice+=evenParity[j1++];
						}
						else
							aliceCanMove=false;
					}
					else
					{
						if(k1<k)
						{
							scoreAlice+=oddParity[k1++];
						}
						else
							aliceCanMove=false;
					}
				}
				if(bobCanMove)
				{
					if(bobTurn==0)
					{
						if(j1<j)
							j1++;
						else
							bobCanMove=false;
					}
					else
					{
						if(k1<k)
							k1++;
						else
							bobCanMove=false;
					}
				}
				
			}
			
		}
		return scoreAlice;
		
	}
	static int gcd(int a, int b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }
	private void quickSortDesc(int arr[], int low, int high)
	  {
	      if (low < high)
	      {
	          /* pi is partitioning index, arr[pi] is 
	            now at right place */
	          int pi = partitionDesc(arr, low, high);

	          // Recursively sort elements before
	          // partition and after partition
	          quickSortDesc(arr, low, pi-1);
	          quickSortDesc(arr, pi+1, high);
	      }
	  	}
	  
	  private int partitionDesc(int arr[], int low, int high)
	  {
	      int pivot = arr[high]; 
	      int i = (low-1); // index of smaller element
	      for (int j=low; j<high; j++)
	      {
	          // If current element is greater than or
	          // equal to pivot
	          if (arr[j] >= pivot)
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
	  
}