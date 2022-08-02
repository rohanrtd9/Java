package ccMar22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Starter1C {
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
			int smallestPos=Integer.MAX_VALUE;
			int largestNeg=0;
			long sumP=0;
			long sumN=0;
			long sum=0;
			for (int i = 0; i < s.length; i++) 
			{
				a[i]=Integer.parseInt(s[i]);
				if((i&1)==0)
				{
					sumP+=(int)Math.abs(a[i]);
					if((int)Math.abs(a[i])<smallestPos)
						smallestPos=(int)Math.abs(a[i]);
						
				}
				else
				{	sumN+=(int)Math.abs(a[i]);
					if((int)Math.abs(a[i])>largestNeg)
						largestNeg=(int)Math.abs(a[i]);
				}
			}
			if(largestNeg>smallestPos)
			{
				sumN=sumN-largestNeg+smallestPos;
				sumP=sumP+largestNeg-smallestPos;
			}
			sum=sumP-sumN;
			out.println(sum);
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
