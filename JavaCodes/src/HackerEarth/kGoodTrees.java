package HackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class kGoodTrees {
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
			int result=1;
			if(n!=2)
			{
				HashMap<Integer,Integer> mp=getFactors(n-1);
				for (Integer k : mp.keySet()) 
		            result*=( mp.get(k) + 1 );
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
	static HashMap<Integer,Integer> getFactors (int n)
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
}