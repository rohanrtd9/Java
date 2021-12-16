package ccDec21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.StringTokenizer;
//accepted
//Problem Code:LISTLIST
public class ListOfList {
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
			st= new StringTokenizer(br.readLine());
			//this array contains list of the numbers
			
			int dp[]=new int[n+1];
			for (int i = 0; i < n; i++) 
				dp[Integer.parseInt(st.nextToken())]++;
			
			int max=dp[0];
			for (int i = 1; i < dp.length; i++) {
				if (dp[i]>max)
					max=dp[i];
			}
			if (n==1 || max==n)
				System.out.println(0);
			else if (max>1)
				System.out.println(n-max+1);
			else System.out.println(-1);
			
			
			out.println();
		}
		out.flush();
	}
	
}
