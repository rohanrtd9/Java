package ccApr22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class starter0401b {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		int b=(int) Math.sqrt(tc);
		//loop for doing coding 
		while(tc-->0)
		{
			st= new StringTokenizer(br.readLine());
			//this is n
			
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			char s[]=br.readLine().toCharArray();
			char t[]=br.readLine().toCharArray();
			//thhen fill question mark with any thing
			if(m>n)
			{
				for (int i = 0; i < s.length; i++) 
					if(s[i]=='?')
						s[i]='a';
					out.println(new String(s));
				
			}
			else
			{
				int i=0,j=0;
				while(i<s.length && j < t.length)
				{
					//if we find same character assault
					if(s[i]==t[j])
					{
						j++;
					}
					else if (s[i]=='?')
					{
						char curChar='e';
						if (t[j]=='e')
							curChar='d';
						s[i]=curChar;	
					}
					i++;
				}
				if(j==t.length)
					out.println(-1);
				else
					out.println(new String (s));
					
			}
			
		}
		out.flush();
	}
	static int gcd(int a, int b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }
}