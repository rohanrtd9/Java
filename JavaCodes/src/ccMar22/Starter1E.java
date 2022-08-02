package ccMar22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Starter1E {
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
			int m=Integer.parseInt(st.nextToken());
			
			int a[]=new int[n];
			char s[]=br.readLine().toCharArray();
			char t[]=br.readLine().toCharArray();
			
			
			int sumOdd[]=new int[n+1];
			int sumEven[]=new int[n+1];
			
			for (int i = 0; i < n; i++) 
			{
				int steps=0;
				//s gets converted to t
				if((int)s[i]>(int)t[i])
				{
					//like if s =y and t = a
					// y needs to be converted to a
					//so steps for y= z-y +1 to conver to a and we will 
					steps=(int)'z'-(int)s[i]+1;
					//next we will count steps from a to t
					steps+=t[i]-(int)'a';
					
				}
				else
				{
					steps=(int)t[i]-(int)s[i];
				}
				if((i&1)==0)
					sumEven[i]=steps;
				else
					sumOdd[i]=steps;
				
					
			}
			for (int i = 1; i <=n ; i++) {
				sumEven[i]+=sumEven[i-1];
				sumOdd[i]+=sumOdd[i-1];
			}
			while(m-->0)
			{
				st= new StringTokenizer(br.readLine());
				//this is n
				int p=Integer.parseInt(st.nextToken());
				int q=Integer.parseInt(st.nextToken());
				
				int sum=0;
				
					sum+=sumEven[q-1]-sumEven[p-2];
					sum-=sumOdd[q-1]-sumEven[p-2];
					
				
				
				if(sum==0)
					out.println("Yes");
				else
					out.println("No");
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
