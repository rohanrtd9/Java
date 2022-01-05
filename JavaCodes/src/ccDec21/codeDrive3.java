package ccDec21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class codeDrive3 {
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
			//this is number of test cases
			int n=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken()); 
			char c[]=br.readLine().toCharArray();
			
			int oneC=0;
			for (int i = 0; i < n-k+1; i++) {
				if(c[i]=='1')
					oneC+=1;
			}
			int res=0;
			res+=oneC&1;
			for (int i = 1; (n-k)+i<n; i++) {
				if (c[n-k+i]=='1')
					oneC+=1;
				if (c[i-1]=='1')
					oneC-=1;
				res+=oneC&1;
			}
			
			
			out.println(res);
		}
		out.flush();
	}
}
