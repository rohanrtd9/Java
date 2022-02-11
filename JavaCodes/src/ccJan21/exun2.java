package ccJan21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class exun2 {
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
			int a=Integer.parseInt(st.nextToken());
			if (n==1)
			{
				if ((a&1)==1)
					out.println("ODD");
				else
					out.println("EVEN");
			}
			else
			{
				//if last bit is 1
				if((a&1)==1)
				{
					if ((n&1)==1)
						out.println("ODD");
					else
						out.println("EVEN");
				}
				else
				{
					out.println("IMPOSSIBLE");
				}
			}
		}
		out.flush();
	}
}