package ccFeb21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LongChallenge1 {
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
			int a[]=new int[n];
			String s[]=br.readLine().split(" ");
			for (int i = 0; i < s.length; i++) 
				a[i]=Integer.parseInt(s[i]);
			
			for (int i = 0; i < s.length; i++) 
				a[i]=(i+1)-a[i];
			
			int count=0;
			for (int i = 0; i < s.length; i++) 
				if(a[i]<=0 && a[i]>=0-count)
					count++;
			out.println(count);
		}
		out.flush();
	}
}
