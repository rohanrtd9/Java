package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CCFeb05MultipleGame {
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
			int q=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			
			st= new StringTokenizer(br.readLine());
			int a[]= new int[n];
			for (int i = 0; i < n; i++) {
				a[i]=Integer.parseInt(st.nextToken());
			}
			int qq[][]=new int[q][2];
			for (int i = 0; i < a.length; i++) 
			{
				st= new StringTokenizer(br.readLine());
				qq[i][0]=Integer.parseInt(st.nextToken());
				qq[i][1]=Integer.parseInt(st.nextToken());
			}
			out.println();
		}
		out.flush();
	}
}
