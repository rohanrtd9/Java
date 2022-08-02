package HiringChallenges;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class rebel2 {
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
			
			
			char s[]=br.readLine().toCharArray();
			
			int zc=0;
			int oc=0;
			int res=0;
			int adjOnes=0;
			for (int i = s.length-1; i >=0 ; i--) 
			{
				if (s[i]=='0')
					zc++;
				else
				{
					if (zc==0)
						continue;
					if(i<s.length-1 && s[i]==s[i+1])
					{
						adjOnes+=1;
					}
					else
					{
						adjOnes=0;
					}
					if(oc>zc)
						res+=oc-zc;
					res=zc+adjOnes;
				}
				
			}
			
			out.println(res);
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
