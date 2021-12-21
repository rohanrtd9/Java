package ccDec21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.util.StringTokenizer;

public class chair {
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
			//so we find factors of n-1
			int n=Integer.parseInt(st.nextToken());
			int n1=(n-1);
			int count=0;
			for (int i = 1; i < Math.sqrt(n1); i++) {
				if (n1%i==0)
					count+=2;
			}
			if(n1%Math.sqrt(n1)==0)
				count+=1;
			out.println(count);
		}
		out.flush();
	}
}
