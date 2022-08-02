package ccApr22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CCAPR22StarterC3 {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		CCAPR22StarterC3 cc= new CCAPR22StarterC3();
		
		//loop for doing coding 
		while(tc-->0)
		{
			st= new StringTokenizer(br.readLine());
			//this is n
			long n=Long.parseLong(st.nextToken());
			out.println(cc.isItReducible(n));
				
			
		}
		out.flush();
	}
	private int isItReducible(long n)
	{
		if(n==1)
			return 0;
		
		if(n%2==1)
			return 1;
		long a= (long)Math.sqrt(n);
		if(a*(long)a == n)
			return 1;
		int powe2=0;
		while(n%2==0)
		{
			n/=2;
			powe2++;
		}
		if(powe2%2==0)
			return 2;
		return -1;
	}
	
	static int gcd(int a, int b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }

}
