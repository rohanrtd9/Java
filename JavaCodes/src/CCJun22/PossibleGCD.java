package CCJun22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import java.util.StringTokenizer;

public class PossibleGCD {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		PossibleGCD ps=new PossibleGCD();
		//loop for doing coding 
		while(tc-->0)
		{
			st= new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());

			int m=Integer.parseInt(st.nextToken());
			int diff=Math.abs(n-m);
			out.println(ps.getFactorCount(diff));
		}
		out.flush();
	}
	int getFactorCount(int n)
	{
		//this function returns the count of factors of n
		if ( n == 1)
			return 1;
		HashMap<Integer,Integer> factors=this.getFactors(n);
		int result=1;
		for (Integer key : factors.keySet())
		{
			result *= ( factors.get( key ) + 1 );
		}
		return result;
	}
	HashMap<Integer,Integer> getFactors (int n)
	{
		HashMap<Integer,Integer> mp=new HashMap<>();

		int df=2;
		while(n>1 && df<=Math.sqrt(n))
		{
			int count=0;
			while ( ( n % df ) == 0 )
			{
				count++;
				n/=df;
			}
			if( count > 0 )
				mp.put( df, count );
			df++;
		}
		if(n>1)
			mp.put( n , 1 );
	return mp;
}
static int gcd(int a, int b)
{
	if (b == 0)
		return a;
	return gcd(b, a % b);
}
}