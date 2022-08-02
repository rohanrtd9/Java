package ccFeb21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.StringTokenizer;

public class StarterC3 {
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
			
			//this is n
			
			int count=0;
			String s1=br.readLine();
			char s[]=s1.toCharArray();
		
			
			char sr[]=new char[s.length];
			for (int i = 0; i < sr.length; i++) 
				sr[i]=s[s.length-i-1];
			
			
			for (int i = 0; i < sr.length; i++) 
				if(s[i]==sr[count])
					count++;
			
			
			
			
			out.println(s.length-count);
		}
		out.flush();
	}
}
