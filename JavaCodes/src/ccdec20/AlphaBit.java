package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AlphaBit {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
				BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer st= new StringTokenizer(br.readLine());
				PrintWriter out = new PrintWriter(System.out);
				//this is number of test cases
				int tc=Integer.parseInt(st.nextToken());
				int pow2[]= {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432};
				
				//loop for doing coding 
				while(tc-->0)
				{
					st= new StringTokenizer(br.readLine());
					int n=Integer.parseInt(st.nextToken());
					int k=Integer.parseInt(st.nextToken());
					if (k<n)
					{
						System.out.println(-1);
						continue;
					}
					int diff=k-n;
					int sp=0;
					while(diff!=0)
					{
						
					}
					
					String s[]= new String[n+1];
					
					if(s[n]!=null)
						System.out.println(s[n]);
					else
						System.out.println(-1);
				}
	}
}
