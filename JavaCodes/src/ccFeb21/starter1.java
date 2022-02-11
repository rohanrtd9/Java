package ccFeb21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class starter1 {
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
			//this is number of test cases
			int n=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken());
			int res=0;
			if(x==0)
				res=n;
			else if(x==1 && n==1)
				res=1;
			else
			{
				res+=2*x-1;
				if(n-x>0)
				{
					res+=(n-x)+1;
				}
			}
			out.println(res);
		}
		out.flush();
	}
}
