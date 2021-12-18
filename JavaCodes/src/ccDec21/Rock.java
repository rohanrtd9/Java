package ccDec21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import java.util.Map;
import java.util.StringTokenizer;

public class Rock {
	public static void main(String[] args)throws Exception 
	{	Rock rc= new Rock();
	
		//importing i/o functions
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
			char c[]=br.readLine().toCharArray();
			
			Map<String,Character> mp=new HashMap<>();
			char output[]=new char[n];
			for (int i = 0; i < c.length; i++) {
				String key=c[i]+"_"+i;
				if( mp.containsKey(key))
					output[i]=mp.get(key);
				else
					output[i]=rc.getWinner(c, i, mp, c[i]);
					
			}
			
			out.println(new String(output));
		}
		out.flush();
	}
	private char getWinner(char c[],int i, Map<String,Character> mp,char crr)
	{
		if(i==c.length-1)
			return crr;
		String key=crr+"_"+i;
		if(mp.containsKey(key))
			return mp.get(key);
		else
		{
			char curWinner;
			if (this.computeWinner(crr, c[i+1]))
				curWinner=crr;
			else
				curWinner=c[i+1];
			String key1=curWinner+"_"+(i+1);
			
			
			char c1;
			if(mp.containsKey(key1))
			{
				c1=mp.get(key1);
				mp.put(crr+"_"+i, c1);
				return c1;
			}
			else 
			{
				c1=this.getWinner(c, i+1, mp, curWinner);
				
				mp.put(crr+"_"+i, c1);
				return c1;
			}
			
		}
		
	}
		
		
	
	private boolean computeWinner(char c1,char c)
	{
		//this fucntion returns true if c1 beats c
		if(c1=='R' && c=='P')
			return false;
		if(c1=='P' && c=='S')
			return false;
		if(c1=='S' && c=='R')
			return false;
			
		return true;
	}
}
