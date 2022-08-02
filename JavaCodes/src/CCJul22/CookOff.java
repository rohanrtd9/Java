package CCJul22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CookOff {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		int mod=1000000007;

		//loop for doing coding 
		while(tc-->0)
		{
			st= new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());

			int a[]=new int[n];
			String s[]=br.readLine().split(" ");
			Map<String,Integer> mp=new HashMap<>();
			for (int i = 0; i < s.length; i++) {
				if (mp.containsKey(s[i]))
					mp.put(s[i], mp.get(s[i])+1);
				else
					mp.put(s[i], 1);
			}
			long result=0;
			int k=0;
			long t=1;
			int p=0;
			for (String key:mp.keySet())
			{
				t=1;
				k=mp.get(key);
				p=k;
				while (k-->0)
				{
					t= ((long )2*t)%mod;
				}
				t-= ((long)p+1);
				t%=mod;
				result+=t;
				result%=mod;
			}
			out.println(result);
		}
		out.flush();
	}
	static long calc(int a)
	{
		return 0;
	}
	static int gcd(int a, int b)
	{
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}