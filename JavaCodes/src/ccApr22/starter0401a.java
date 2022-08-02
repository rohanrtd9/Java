package ccApr22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class starter0401a {
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
			int a[]=new int[n];
			String s[]=br.readLine().split(" ");
			
			int oddCount=0,evenCount=0;
			
			for (int i = 0; i < s.length; i++) 
			{
				a[i]=Integer.parseInt(s[i]);
				if( (a[i]&1)==1)
					oddCount+=1;
				else
					evenCount+=1;
			}
			int res=0;
			if( ((oddCount)&1)==1)
				res=evenCount;
			else
			{
				if(oddCount/2<=evenCount)
					res=oddCount/2;
				else
					res=evenCount;
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