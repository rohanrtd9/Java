package CCJun22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class reduceToZero {
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
			long n=Long.parseLong(st.nextToken());
			long m=Long.parseLong(st.nextToken());
			
			int addStep=0;
			long max=n>=m?n:m;
			long min=n<m?n:m;
			long result=max;
			//if both elements
			if(max==0)
				result=0;
			//if minimum is zero then it isn't possible
			else if (max==min)
				result=min;
			else if ( min == 0 )
				result=-1;
			else
			{
				//now we calculate the difference between max and min
				long diff=max-min;
				while(min<diff)
				{
					min*=2;
					result++;
					diff=max-min;
				}
				result++;
			}
			out.println(result);
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