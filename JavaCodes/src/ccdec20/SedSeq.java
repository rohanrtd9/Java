package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SedSeq {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
				BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer st= new StringTokenizer(br.readLine());
				
				//this is number of test cases
				int tc=Integer.parseInt(st.nextToken());
				
				//loop for doing coding 
				while(tc-->0)
				{
					st= new StringTokenizer(br.readLine());
					int n=Integer.parseInt(st.nextToken());
					int k=Integer.parseInt(st.nextToken());
					//int a[]= new int[n];
					int sum=0;
					st= new StringTokenizer(br.readLine());
					for (int i = 0; i < n; i++) {
						sum+=Integer.parseInt(st.nextToken());
					}
					if (sum%k==0)
						System.out.println(0);
					else
						System.out.println(1);
				}
	}

}
