package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ccjan01 {
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
					int k=Integer.parseInt(st.nextToken());
					int d=Integer.parseInt(st.nextToken());
					//int a[]=new int [n];
					
					st= new StringTokenizer(br.readLine());
					int sum=0;
					for (int i = 0; i < n; i++) {
						sum+=Integer.parseInt(st.nextToken());
					}
					int probPerDay=sum/k;
					System.out.println(Math.min(probPerDay, d));
					
				}
	}

}
