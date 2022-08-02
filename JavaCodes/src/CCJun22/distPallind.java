package CCJun22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class distPallind {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		distPallind dp=new distPallind();
		//loop for doing coding 
		while(tc-->0)
		{
			st= new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			
			int count=0;
			HashMap<Integer,Integer> facts=dp.getFactors(n);
			Set <Integer> dv=new HashSet<>();
			int num=0;
			dv.add(1);
			for (Integer key : facts.keySet())
			{
				num = ( facts.get( key ) );
				while(num>0)
				{
					Set <Integer> dv1=new HashSet<>();
					for (Integer val:dv)
					{
						dv1.add(val*key);
					}
					dv.add(key);
					dv.addAll(dv1);
					num--;
				}
			}
			dv.remove((Integer) n);
			
			//in this we have the factors of the given number;
			count=dv.size()*2;
			if(n%2==0)
				count--;
			out.println(count);
		}
		out.flush();
	}
	static int gcd(int a, int b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
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
}