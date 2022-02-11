package ccJan21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Long1 {
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
			boolean flag=true;
			char c[]=br.readLine().toCharArray();
			for (int i = 0; i < c.length-1; i++) {
				if(c[i]=='1')
				{
					flag=false;
					break;
				}
			}
			if (flag==true)
				out.println("No");
			else
				out.println("Yes");
		}
		out.flush();
	}
}