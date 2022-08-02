package cses;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CountingTowers {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		int mod=1000000007;
		int dp1[]=new int[1000001];
		dp1[1]=1;
		int dp2[]=new int[1000001];
		dp2[1]=1;
		
		for (int i = 2; i < dp2.length; i++) {
			dp1[i]+= (((long)2* dp1[i-1])+dp2[i-1])%mod;
			dp2[i]+= (dp1[i-1]+((long)4*dp2[i-1])%mod);
		}
		//loop for doing coding 
		while(tc-->0)
		{
			st= new StringTokenizer(br.readLine());
			//this is n
			int n=Integer.parseInt(st.nextToken());
			
			
			out.println((dp1[n]+dp2[n])%mod);
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