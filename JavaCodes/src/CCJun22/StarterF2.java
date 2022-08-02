package CCJun22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StarterF2 {

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
			
			long a[]=new long[n];
			String s[]=br.readLine().split(" ");
			long min=30000000000L;
			int minIdx=0;
			long sumArr=0;
			for (int i = 0; i < a.length; i++) {
				
				a[i]=Long.parseLong(s[i]);
				sumArr+=a[i];
				if(a[i]<min)
				{
					//we find min here
					min=a[i];
					minIdx=i;
				}
			}
			sumArr-= n*min;
			long off=0;
			off=(a[minIdx]-sumArr)/((long)n+1);
			for (int i = 0; i < s.length; i++) {
				
				out.print(a[i]-min+off+" ");
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
