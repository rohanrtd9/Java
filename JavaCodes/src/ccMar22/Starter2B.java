package ccMar22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Starter2B {
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
			//this is n
			int n=Integer.parseInt(st.nextToken());
			
			char s[]=br.readLine().toCharArray();
			
			int ptr=n-1;
			LinkedList<String> str=new LinkedList<>();
		
			while(ptr>=0)
			{
				if(s[ptr]=='1')
					ptr--;
				else
				{
					//we flip
					int j=ptr;
					boolean oneExist=false;
					while(--j>=0)
						if(s[j]=='0')
							s[j]='1';
						else
							{s[j]='0';
							oneExist=true;
							}
					if(oneExist)
					str.add(0+" "+(ptr+1));
				ptr--;
				}
			}
			out.println(str.size());
			for (String st1 : str) {
				out.println(st1);
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
