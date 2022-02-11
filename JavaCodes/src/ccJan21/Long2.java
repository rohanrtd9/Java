package ccJan21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.util.StringTokenizer;

public class Long2 {
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
			int x=Integer.parseInt(st.nextToken());
			
			int res[]= new int[n];
			int resXor=0;
			
			//we go till second last element and calculate their xor
			for (int i = 0; i < n-1; i++) {
				resXor=resXor^i;
				res[i]=i;
				
			}
			if((x^resXor)>=n-1)
			{
				res[n-1]=x^resXor;
				
			}
			else
			{
				int a=1;
				a=a<<19;
				res[n-1]=a|x^resXor;
				if( (x^resXor)==0)
				
					res[1]=res[1]^a;
				
				else
					res[0]=res[0]^a;
			}
			//then our alog
			//if taking xor with second last element takes xor above n-1
			//then good
			//however 
			for (int i = 0; i < res.length; i++) {
				out.print(res[i]+" ");
			}
			out.print("\n");
		}
		out.flush();
	}
	
}