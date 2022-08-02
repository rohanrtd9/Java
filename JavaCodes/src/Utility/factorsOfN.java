package Utility;

import java.util.HashMap;

public class factorsOfN {
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
