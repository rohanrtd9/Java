package CCJun22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Stack;
import java.util.StringTokenizer;

public class StarterF5 {

	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());


		int n=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());
		int dp[]=new int[n+2];
		int l=0,r=0;
		Random rr = new Random();
		int t=0;
		while(q>0)
		{
			st= new StringTokenizer(br.readLine());
			l=Integer.parseInt(st.nextToken());
			r=Integer.parseInt(st.nextToken());
			t=rr.nextInt(10000000);
			dp[l]+=t;
			dp[r+1]-=t;
			q--;
		}
		long result=1;
		int mod=998244353;
		Stack <Integer> stk=new Stack<>();
		for (int i = 1; i < dp.length-1; i++) {
			dp[i]=dp[i-1]+dp[i];
			//if(dp[i]==0)
				//continue;
			if(dp[i]!=dp[i-1])
			{
				if (stk.empty())
				{
					result=result*2;
					result=result%mod;
					stk.push(dp[i-1]);
				}
					
				else if (stk.peek()!= dp[i])
				{
					result=result*2;
					result=result%mod;
					stk.push(dp[i-1]);
				}
				
				
			}
		}
		out.println(result);

		out.flush();
	}
	static int gcd(int a, int b)
	{
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}