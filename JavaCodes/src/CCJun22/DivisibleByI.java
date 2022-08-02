package CCJun22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DivisibleByI {
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
			int start=n/2;
			int sign=1;
			//odd case
			if ( ( n & 1 ) == 1 )
			{
				start++;
				sign=sign*-1;
			}
			out.print(start+" ");
			
			int startVal=1;
			int incrementVal=startVal*sign;
			for (int i = 1; i < n; i++) {
				incrementVal=startVal*sign;
				start= start+incrementVal;
				out.print(start+" ");
				sign=sign*-1;
				startVal++;
			}
			
			out.print("\n");
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
