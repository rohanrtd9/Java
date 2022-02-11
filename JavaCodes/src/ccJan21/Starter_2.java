package ccJan21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Starter_2 {
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
			int arr[]= {3,15,64,255,1023,4095};
			
			for (int i = 0; n>0; i++) {
				char c[]=Integer.toBinaryString(i).toCharArray();
				int count=0;
				for (int j = 0; j < c.length; j++) {
					if(c[j]=='1')
					{
						count++;
					}
				}
				if((count &1)==0)
				{
					out.print(i+" ");
					n--;
				}
			}
			
			out.print("\n");
		}
		out.flush();
	}
}
