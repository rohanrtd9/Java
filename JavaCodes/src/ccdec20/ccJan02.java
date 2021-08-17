package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ccJan02 {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
				BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				PrintWriter out = new PrintWriter(System.out);
				StringTokenizer st= new StringTokenizer(br.readLine());
				//this is number of test cases
				int tc=Integer.parseInt(st.nextToken());
				int b1=0,b2=0,b3=0,b4=0;
				Map<String,String> mp= new HashMap<>();
				mp.put("0000", "a");
				mp.put("0001", "b");
				mp.put("0010", "c");
				mp.put("0011", "d");
				mp.put("0100", "e");
				mp.put("0101", "f");
				mp.put("0110", "g");
				mp.put("0111", "h");
				mp.put("1000", "i");
				mp.put("1001", "j");
				mp.put("1010", "k");
				mp.put("1011", "l");
				mp.put("1100", "m");
				mp.put("1101", "n");
				mp.put("1110", "o");
				mp.put("1111", "p");
				
				
				
				
				//loop for doing coding 
				while(tc-->0)
				{
					String rs="";
					st= new StringTokenizer(br.readLine());
					int n=Integer.parseInt(st.nextToken());
					String s= br.readLine();
					n/=4;
					while(n-->0)
					{
						String ss=s.substring((n*4),(n*4)+4);
						rs=mp.get(ss)+rs;
					}
					System.out.println(rs);
				}
	}
}
