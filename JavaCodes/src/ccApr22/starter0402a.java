package ccApr22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class starter0402a {
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

			int a[]=new int[n];
			String s[]=br.readLine().split(" ");
			for (int i = 0; i < s.length; i++) 
			{
				a[i]=(Integer.parseInt(s[i])&1);	
			}

			int dist[]=new int[n];
			//we can switch parity 
			//or stay on same for each step
			int sameParityIdxAsAnswer=n-1;
			int diffParityIdxAsAnswer=n-1;
			for (int i = n-2; i >=0 ; i--) 
			{
				//we have same parity as answer
				if(a[i]==a[n-1])
				{
					dist[i]=dist[sameParityIdxAsAnswer];
					dist[i]++;
					sameParityIdxAsAnswer=i;
				}
				else
				{
					if(diffParityIdxAsAnswer==n-1)
						dist[i]=dist[sameParityIdxAsAnswer];
					//we can make the parity shift
					else
						dist[i]=Math.min(dist[sameParityIdxAsAnswer], dist[diffParityIdxAsAnswer]);
					dist[i]++;
					diffParityIdxAsAnswer=i;
				}
			}	
			out.println(dist[0]);
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