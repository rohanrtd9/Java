package ccJan21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Starter_3 {
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
			if (n==2)
				out.println("NO");
			else if((n&1)==0)
			{
				out.println("YES");
				for (int i = n/2; i >0 ; i--) {
					out.print(i+" ");
				}
				out.print(n+" ");
				for (int i = (n/2)+1; i < n; i++) {
					out.print(i+" ");
				}
				out.print("\n");
			}
			else
			{
				out.println("YES");
				for (int i = 1; i <= n; i+=2) 
				{
					out.print(i+" ");
					
				}
				for (int i = n-1; i >2; i-=2) 
				{
					out.print(i+" ");
				}
				out.print("2\n");
			}
		}
		out.flush();
	}
}
