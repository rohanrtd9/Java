package GoogleKickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Ks1 {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		int cnt=0;
		//loop for doing coding 
		while(cnt++<tc)
		{
			st= new StringTokenizer(br.readLine());
			//this is n
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			long sum=0;
			String s[]=br.readLine().split(" ");
			for (int i = 0; i < s.length; i++) 
				{sum+=Integer.parseInt(s[i]);
				sum%=m;}
			
			out.println("Case #"+cnt+": "+sum);
		}
		out.flush();
	}
}
