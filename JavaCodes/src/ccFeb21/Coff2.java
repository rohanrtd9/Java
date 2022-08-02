package ccFeb21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

//accepted
public class Coff2 {
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
			//this is n
			int n=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			
			
			for (int i = 0; i < n-k; i++) 
				out.print(i+2+" ");
			out.print(1+" ");
			for (int i = n-k+1; i < n; i++) 
				out.print(i+1+" ");
			out.print("\n");
			
		}
		out.flush();
	}
}
