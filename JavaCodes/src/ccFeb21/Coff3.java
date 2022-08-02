package ccFeb21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Coff3 {
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
			char s[]=br.readLine().toCharArray();
			if (s[0]=='0')
			{
				out.println("No");
				continue;
			}
			out.println("Yes");
			//initiate the array with descending order numbers
			int res[]=new int[n+1];
			for (int i = 0; i < res.length; i++) 
				res[i]=i;
			for (int i = 0; i < s.length; i++) {
				//if we encounter a zero then we swap it with next element
				if (s[i]=='0')
				{
					int t=res[0];
					res[0]=res[i];
					res[i]=t;
				}
			}
			for (int i = 0; i < res.length-1; i++) 
				out.print(res[i]+" ");
			out.print("\n");
		}
		out.flush();
	}
}
