package CCJun22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class makeThemEqual {
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
			int a=Integer.parseInt(st.nextToken());
			
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			out.println();
		}
		out.flush();
	}
	static int gcd(int a, int b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }
}