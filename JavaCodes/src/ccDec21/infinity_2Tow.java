package ccDec21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class infinity_2Tow {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		infinity_2Tow its= new infinity_2Tow();
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());

		//loop for doing coding 
		while(tc-->0)
		{
			st= new StringTokenizer(br.readLine());
			//this is number of test cases
			int n=Integer.parseInt(st.nextToken());
			char[] s1=br.readLine().toCharArray();
			char[] s2=br.readLine().toCharArray();
			
			Set<Character>c= new HashSet<>();
			for (int i = 0; i < s1.length; i++) {
				
				if(s1[i]=='?' && s2[i]!='?')
				{
					c.add(s2[i]);
				}
				if(s1[i]!='?' && s2[i]=='?')
				{
					c.add(s1[i]);
				}
			}
			int min=Integer.MAX_VALUE;
			c.add('u');
			c.add('g');
			for (Character cha : c) {
				int iterCount=0;
				for (int i = 0; i < s2.length; i++) {
					
					
					char s1c=s1[i];
					char s2c=s2[i];
					if(s1[i]=='?')
						s1[i]=cha;
					if(s2[i]=='?')
						s2[i]=cha;
					
					if(s1[i]==s2[i])
					{
						s1[i]=s1c;
						s2[i]=s2c;
						continue;
					}
						
					
					if (its.isVowel(s1[i]))
					{
						if(its.isVowel(s2[i]))
							iterCount+=2;
						else
							iterCount+=1;
					}
					else
					{
						if(its.isVowel(s2[i]))
							iterCount+=1;
						else
							iterCount+=2;
					}
					s1[i]=s1c;
					s2[i]=s2c;
				}
				if (iterCount<min)
					min=iterCount;
			}
			out.println(min);
		}
		out.flush();
	}
	private boolean isVowel(char c)
	{
		if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
			return true;
		return false;
	}
}
