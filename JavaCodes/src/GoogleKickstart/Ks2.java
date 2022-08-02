package GoogleKickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Ks2 {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		int cnt=0;
		char[] vowels= {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
		//loop for doing coding 
		while(cnt++<tc)
		{
			
			String ruler="Bob";
			
			String s=br.readLine();
			char end=s.charAt(s.length()-1);
			if(end=='y' || end=='Y')
				ruler="nobody";
			else 
				for (char c : vowels) 
					if(c==end)
						ruler="Alice";
			
				
			
			
			
			out.println("Case #"+cnt+": "+new String(s)+" is ruled by "+ruler+".");
		}
		out.flush();
	}
}
