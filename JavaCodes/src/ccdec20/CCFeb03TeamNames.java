package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CCFeb03TeamNames {
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
			int count=0;
			st= new StringTokenizer(br.readLine());
			//this is number of test cases
			int n=Integer.parseInt(st.nextToken());
			String s[]=br.readLine().split(" ");
			//prefix has value of prefix and its number 
			//starting from 0
			Map<String,Integer> prefix=new HashMap<>();
			//suffix has number suffix and its bitset which contains value
			//of prefixes that lead to a funny words when combined
			Map<String,BitSet> suffix=new HashMap<>();
			int id=0;
			for (int i = 0; i < s.length; i++) 
			{
				String prefx=s[i].substring(0,1);
				if(! prefix.containsKey(prefx))
				{
					
					prefix.put(prefx, id++);
				}
				String suffx=s[i].substring(1);
				int val=prefix.get(prefx);
				if(suffix.containsKey(suffx))
				{
					
					suffix.get(suffx).set(val);
				}
				else
				{
					BitSet bs= new BitSet();
					bs.set(val);
					suffix.put(suffx, bs);
				}
			}
			//now we iterate for each prefix
			for (String pre1 : prefix.keySet()) 
			{
				
				for (String suf2 : suffix.keySet()) 
				{
					//if word is funny then it'll have suffix set
					//for the given prefix
					if(suffix.get(suf2).get(prefix.get(pre1)))
					{
						continue;
					}
					else
					{
						
					}
				}
			}
			System.out.println(count*(count-1));
		}
		out.flush();
	}
}
