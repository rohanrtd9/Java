package cses;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DiceCombinations {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int n=Integer.parseInt(st.nextToken());
		
		int a[]=new int[n+1];
		
		a[0]=1;
		
		for (int i = 0; i < a.length; i++) 
		{
			
			for (int j = 1; j < 7; j++) 
			{
				if(i+j<a.length)
					{a[i+j]+=a[i];
					a[i+j]%=1000000007;}
			}
		}
		
		out.println(a[n]);
		
		out.flush();
	}
}

