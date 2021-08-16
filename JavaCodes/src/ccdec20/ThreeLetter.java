package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ThreeLetter {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
				BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer st= new StringTokenizer(br.readLine());
				
				//this is number of test cases
				int tc=Integer.parseInt(st.nextToken());
				
				//loop for doing coding 
				while(tc-->0)
				{
					String s=br.readLine();
					char c[]=s.toCharArray();
					Map<String,Integer> mp= new HashMap<String,Integer>();
					for (int i = 0; i < c.length; i++) {
						if(mp.containsKey(c[i]))
							continue;
					}
					
				}
	}

}
