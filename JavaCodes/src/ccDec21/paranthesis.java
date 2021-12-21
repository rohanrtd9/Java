package ccDec21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.StringTokenizer;

public class paranthesis {
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
			char c[]=br.readLine().toCharArray();
			
			//first we scan to find balanced parenthesis end points
			
			//this is balance factor
			//it is zero initially
			int bf=0;
			int ptrClose=0;
			int min=c.length;
			
			for (int i = 0; i < c.length; i++) {
				if(c[i]=='(')
				{
					bf++;
					while(c[++ptrClose]!=')');
					if	( (ptrClose-i) < min)
						min=ptrClose-i;
				}
				else
				{
					bf--;
				}
				
				
			}
			out.println(min);
		}
		out.flush();
	}
}
