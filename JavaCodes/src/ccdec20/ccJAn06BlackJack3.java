package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ccJAn06BlackJack3 {

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
					int x=Integer.parseInt(st.nextToken());
					int y=Integer.parseInt(st.nextToken());
					
					int nums[]=new int [n];
					
					st= new StringTokenizer(br.readLine());
					
					int sum=0;
					int sn[]=new int[y+1];
					for (int i = 0; i < n; i++) {
						int s=Integer.parseInt(st.nextToken());
						nums[i]=s;
						sum+=s;
						if(s<sn.length)
							sn[s]=1;
					}
					
					//in this case it is not possible as sum is less than range
					if(sum<y)
					{
						System.out.println(-1);
						continue;
					}
					//check for case where no swap needed
					if (checkDone(sn,x,y))
					{
						System.out.println(0);
						continue;
					}	
					sn[0]=1;
					int aPtr=0;
					for (int i = 0; i < sn.length; i++) {
						if(sn[i]==0)
							continue;
						
					}
					
				}
	}
	static boolean checkDone(int arr[], int l,int u)
	{
		//this function checks whether the bits form l to u inclusive
		//have 1 set
		for (int i = l; i <=u; i++) {
			if(arr[i]==1)
				return true;
		}
		return false;
	}
}


