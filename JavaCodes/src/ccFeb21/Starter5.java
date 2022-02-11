package ccFeb21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Starter5 {
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
			int s=Integer.parseInt(st.nextToken());
		
			int a=Integer.parseInt(st.nextToken());
			
			int b=Integer.parseInt(st.nextToken());
			//if sum more than 1 and a b is one then not possible
			if (     (a==1 && b==1 && s!=1) || (b>a) ||(s%a!=0))
				out.println("-1");
			else
				out.println((s*(long)b)/a);
		}
		out.flush();
	}
}
