package ccFeb21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class StarterB5 {
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
			//this is number of test cases
			int n=Integer.parseInt(st.nextToken());
			Set <Integer> s1= new HashSet<>();
			Set <Integer> s2= new HashSet<>();
			while(n-->0)
			{
				st= new StringTokenizer(br.readLine());
				//this is number of test cases
				s1.add(Integer.parseInt(st.nextToken()));
				s2.add(Integer.parseInt(st.nextToken()));
				
			}
			out.println(s1.size()+ s2.size());
		}
		out.flush();
	}
}
