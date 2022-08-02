package ccMar22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Starter1D {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		
		
			//this is n
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		String s[]=br.readLine().split(" ");
		for (int i = 0; i < s.length; i++) 
			a[i]=Integer.parseInt(s[i]);
		
		//next 2 m lines give equation details
		while(m-->0)
		{
			st= new StringTokenizer(br.readLine());
			//this is n
			int comp=Integer.parseInt(st.nextToken());
			int quantComp=a[comp-1];
			a[comp-1]=0;
			int quant=Integer.parseInt(st.nextToken());
			st= new StringTokenizer(br.readLine());
			while(quant-->0)
			{
				int quant1=Integer.parseInt(st.nextToken());
				int comp1=Integer.parseInt(st.nextToken());
				
				long res=(long)quantComp*quant1;
				res=res%1000000007;
				a[comp1-1]+=res;
				a[comp1-1]=a[comp1-1]%1000000007;
			}
		}
		for (int i = 0; i < a.length; i++) {
			out.println(a[i]);
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
