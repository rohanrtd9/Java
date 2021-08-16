package cses;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MinimizeCoins {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		int x=Integer.parseInt(st.nextToken());
		st= new StringTokenizer(br.readLine());
		int a[]=new int[tc];

		for (int i = 0; i < a.length; i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		int n[]=new int[x+1];
		//seed the base cases
		for (int ix : a) {
			if (ix<=x)
			n[ix]=1;
		}
		
		for (int i = 0; i < n.length; i++) {
			if(n[i]>=1)
			{
				for (int ix : a) {
					if(i+ix<n.length)
						if(n[i+ix]==0 )
							n[i+ix]=(n[i]+1);
						else if (n[i+ix]>n[i])
							n[i+ix]=(n[i]+1);
		
				}
			}
		}
		out.println(n[x]==0?-1:n[x]);
		out.flush();
	}
}
