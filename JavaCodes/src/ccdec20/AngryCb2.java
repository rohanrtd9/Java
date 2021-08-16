package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AngryCb2 {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
				BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer st= new StringTokenizer(br.readLine());
				PrintWriter out = new PrintWriter(System.out);
				
				//this is number of test cases
				int tc=Integer.parseInt(st.nextToken());
				
				//loop for doing coding 
				while(tc-->0)
				{
					st= new StringTokenizer(br.readLine());
					
					int n=Integer.parseInt(st.nextToken());
					int q=Integer.parseInt(st.nextToken());
					int arr[]= new int[n+3];
					while (q-->0) {
						st= new StringTokenizer(br.readLine());
						
						int l=Integer.parseInt(st.nextToken());
						int r=Integer.parseInt(st.nextToken());
						arr[l]++;
						arr[r+1]-=(r-l)+2;
						arr[r+2]+=(r-l)+1;
					}
					for (int i = 1; i < arr.length; i++) 
						arr[i]+=arr[i-1];
					for (int i = 1; i < arr.length; i++) 
						arr[i]+=arr[i-1];
					for (int i = 1; i < arr.length-2; i++) {
						out.print(arr[i]+" ");
					}
					out.println();
					
				}
			out.flush();
	}
}
