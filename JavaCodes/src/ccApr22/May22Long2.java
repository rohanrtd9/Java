package ccApr22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class May22Long2 {
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
			int count=0;
			for (int i = 0; i < (n/2); i++) {
				if(s[i]!=s[n-i-1])
					count++;
			}
			int res=count/2;
			if( ( count & 1)==1)
				res++;
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
