package Nium_CodeChef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Query {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		
			
			int n=Integer.parseInt(st.nextToken());
			int q=Integer.parseInt(st.nextToken());
			st= new StringTokenizer(br.readLine());
			
			int nums[]=new int[n];
			for (int i = 0; i < nums.length; i++) {
				nums[i]=Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < q; i++) {
				st= new StringTokenizer(br.readLine());
				
				int l=Integer.parseInt(st.nextToken());
				int r=Integer.parseInt(st.nextToken());
				int x=Integer.parseInt(st.nextToken());
				int count =0;
				
				//optimizations
				if(x<nums[l-1])
				{
					count=r-l+1;
				}
				else if(x>nums[r-1])
				{}
				else
				{
					for (int j = r-1; j >= l-1 && nums[j]>=x; j--) {
						count++;
					}
				}
				
				out.println(count);
			}
			
		
		out.flush();
	}
}
