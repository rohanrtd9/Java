package ccMarch21GuessingNumbers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CCMar0202 {
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
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			if(n>m)
			{
				int t=n;
				n=m;
				m=t;
			}
			int k=Integer.parseInt(st.nextToken());
			int a[]=new int[m+n+2];
			for (int i = 2; i <=m+1; i++) 
			{
				a[i]+=1;
				a[i+n]-=1;
			}
			for (int i = 1; i < a.length; i++) {
				a[i]=a[i-1]+a[i];
			}
			int res=2+k;
			for (int i = 3; i < a.length; i++) {
				if((a[i]&1)==1)
				{
					res=res ^(i+k);
				}
			}
			out.println(res);
		}
		out.flush();
	}
}


