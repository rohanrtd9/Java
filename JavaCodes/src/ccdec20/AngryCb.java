package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AngryCb {

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
					int arr[]= new int[n+1];
					int l[]= new int[q];
					int r[]= new int[q];
					for (int i = 0; i < q; i++) {
						st= new StringTokenizer(br.readLine());
						l[i]=Integer.parseInt(st.nextToken());
						r[i]=Integer.parseInt(st.nextToken());
					}
					for (int i = 1; i < arr.length; i++) {
						for (int j = 0; j < q; j++) {
							if(i>=l[j] && i<=r[j])
								arr[i]+=(1-l[j]+i);
						}
					}
					
					for (int i = 1; i < arr.length; i++) 
					        out.print(arr[i]+" ");
					    out.println();
					//System.out.println(arr[arr.length-1]);
				}
				out.flush();
	}
}
