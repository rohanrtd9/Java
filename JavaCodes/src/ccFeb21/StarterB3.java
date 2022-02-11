package ccFeb21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.StringTokenizer;

public class StarterB3 {
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
			long k=Long.parseLong(st.nextToken());
			

			
			long last=1;
			k-=n;
			out.print(last+" ");
			for (int i = 1; i < n; i++) {
				if(k==0)
					out.print(last+" ");
				else if (k>=last)
				{
					k-=last;
					out.print(++last+" ");
				}
				else
				{out.print((last-k)+" ");
				last-=k;
				k=0;}
			}
		
			out.print("\n");
		}
		out.flush();
	}
}
