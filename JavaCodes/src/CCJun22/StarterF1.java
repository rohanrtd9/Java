package CCJun22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StarterF1 {
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
			boolean canBeformed=false;
			st= new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			
			int b[]=new int[n];
			String s[]=br.readLine().split(" ");
			for (int i = 0; i < b.length; i++) {
				b[i]=Integer.parseInt(s[i]);
			}
			int a[]=new int[n];
		
			//we can assume that index 1 is odd
			a[0]=1;
			//we build our array accordingly
			for (int i = 0; i < s.length-1; i++) {
				if(b[i]==0)
					a[i+1]=a[i];
				else
					a[i+1]= ( (a[i]+1) & 1 );
			}
			//now we check for last index
			if(b[n-1]==1)
				//if last bit is inverted then we are good
				if (a[n-1]==0)
					canBeformed=true;
			if (b[n-1]==0)
				if (a[n-1]==1)
					canBeformed=true;
			//or is even
			a[0]=0;
			for (int i = 0; i < s.length-1; i++) {
				if(b[i]==0)
					a[i+1]=a[i];
				else
					a[i+1]= ( (a[i]+1) & 1 );
			}
			if(b[n-1]==1)
				//if last bit is inverted then we are good
				if (a[n-1]==1)
					canBeformed=true;
			if (b[n-1]==0)
				if (a[n-1]==0)
					canBeformed=true;
			if (canBeformed)
				out.println("YES");
			else
				out.println("NO");
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