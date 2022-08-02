package CCJun22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class permAnd {
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
			if( ( n & 1 ) ==1 )
			{
				if( n == 1)
				{
					out.println(1);
					out.println(1);
				}
				else
					out.println(-1);
				continue;
			}
			int a[]=new int[n];
			//this array contains descending values
			for (int i = 0; i < a.length; i++) 
			{
				a[i]=a.length-i;
				out.print(a[i]+" ");
			}
			out.print("\n");
			//this is other array
			int b[]=new int[n];
			Map<Integer,Integer> mp=new HashMap<>();
			for (int i = 0; i < b.length; i++) {
				
				if(mp.containsKey(a[i]))
				{
					out.print(mp.get(a[i])+" ");
				}
				else
				{
					int highestBitA=Integer.highestOneBit(a[i]);
					highestBitA=(highestBitA-1)+highestBitA;
					b[i]=a[i] ^ highestBitA;
					mp.put(b[i],a[i]);
					out.print(b[i]+" ");
					mp.put(b[i], a[i]);
				}
				
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