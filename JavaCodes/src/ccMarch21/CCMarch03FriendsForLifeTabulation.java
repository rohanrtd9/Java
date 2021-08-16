package ccMarch21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.util.StringTokenizer;

public class CCMarch03FriendsForLifeTabulation {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		CCMarch03FriendsForLifeTabulation cs=new CCMarch03FriendsForLifeTabulation();
		

		//loop for doing coding 
		while(tc-->0)
		{	st= new StringTokenizer(br.readLine());
			int n =Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
			long res=cs.makeOrderz(n, e, h,a,b,c);
			out.println(res);
		}
		out.flush();
	}
	public long makeOrderz(int n,int e,int h, int a,int b,int c)
	{
		long min=-1 ;
		boolean flag=true;
		if(e<n && h<n)
			//if both are less than n then we cant make the order sorry
			return -1;
		
		int limit=(h)/3;
		if(limit>n)
			limit=n;
				
		//we vary number of shake from 0-N
		for (int i = 0; i <= limit; i++) 
		{
			long temp=((long)i*b);
			long remRes=this.minCost(a, c, e, h-(3*i), n-i);
			if(remRes>=0)
			{
				if (flag)
					{
						min=temp+remRes;
						flag=false;
					}
				else
				{
					if (min>(temp+remRes))
						min=temp+remRes;
				}
			}
		}
		
		
		return min;
	}
	private long minCost(int a,int c, int e, int h, int n)
	{
		//this function in linear time returns the minimum cost with which we can order the given stuffs
		int cakesCount=0, omletteCount=0;
		if (c<a)
		{
			//check later if it causes error coz of greedy approach
			cakesCount=Math.min(e, h);
			cakesCount=Math.min(cakesCount, n);
			if(e>h)
			{
				e=e-h;
				h=0;
			}
			else
			{
				h=h-e;
				e=0;
			}
			int rem=n-cakesCount;
			if(rem>0)
			{
				int eNeeded=2*rem;
				if(e<eNeeded )
					return -1;
				else
					omletteCount=rem;
			}
		}
		else
		{
			int extraEggs=e-n;
			if(extraEggs<0)
				return -1;
			if(extraEggs>n)
				extraEggs=n;
			omletteCount=extraEggs;
			cakesCount=n-extraEggs;
			if(h<cakesCount)
				return -1;
		}
		return ( ((long)cakesCount*c) + ((long)omletteCount*a) );
	}
		
}


