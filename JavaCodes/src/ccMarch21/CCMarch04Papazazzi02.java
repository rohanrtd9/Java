package ccMarch21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CCMarch04Papazazzi02 {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		CCMarch04Papazazzi02 cc = new CCMarch04Papazazzi02();

		//loop for doing coding 
		while(tc-->0)
		{
			st= new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int a[]=new int[n];
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i < a.length; i++) {
				a[i]=Integer.parseInt(st.nextToken());
			}
			out.println(cc.maxView(a, n));
		}
		out.flush();
	}
	private int maxView(int a[],int n)
	{
		
		int res=1;
		int d[]=new int[n];
		for (int i = a.length-res;i>=res;) 
		{
			double maxRec=Integer.MIN_VALUE;
			int dist=0;
			for (int j = 0; j < a.length-(a.length-i); j++) 
			{
				double rec=a[i-j-1]-a[i];
				rec/=(j+1);
				if(rec>=maxRec)
					{dist=j+1;
					maxRec=rec;}
					
			}
			if(dist>res)
				res=dist;
			i-=dist;
		}
		
		return res;
	}
}
