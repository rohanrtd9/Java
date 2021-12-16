package Nium_CodeChef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SolutionTemplate {
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
			
			//this is number of test cases
			st= new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			if(n>=12)
			{
				///we read all numbers in this array
				
				st= new StringTokenizer(br.readLine());
				Map <Integer,Integer> mp= new HashMap<>();
				for (int i = 0; i < n; i++) 
				{
					int t=Integer.parseInt(st.nextToken());
					
					if (mp.containsKey(t))
						mp.put(t,mp.get(t)+1);
					else 
						mp.put(t, 1);
				}
				if (mp.size()>12)
					out.println("no");
				else
					out.println("yes");
			}
			else
			{//this is number of test cases
				st= new StringTokenizer(br.readLine());
				out.println("no");
			}

			
		}
		out.flush();
	}
}
