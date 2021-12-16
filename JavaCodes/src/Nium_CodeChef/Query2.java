package Nium_CodeChef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Query2 {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int n=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());
		
		st= new StringTokenizer(br.readLine());
		
		int nums[]=new int[n];
		for (int i = 0; i < nums.length; i++) 
		{
			nums[i]=Integer.parseInt(st.nextToken());
		}
		int dp[]=new int[n];
		int max=nums[n-1];
		int min=nums[0];
		for (int i = 0; i < q; i++) 
		{
			st= new StringTokenizer(br.readLine());
			
			int l=Integer.parseInt(st.nextToken());
			int r=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken());
			int count =0;
			for (int j = r-1; j >= l-1 && nums[j]>=x; j--) {
				count++;
			}
			out.println(count);
		}
		
		out.flush();
	}
}
