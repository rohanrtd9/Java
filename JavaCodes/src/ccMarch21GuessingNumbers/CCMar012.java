package ccMarch21GuessingNumbers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CCMar012 {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		

		//loop for doing coding 
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		while(tc-->0)
		{
			for (int i=1;i<=1000;i++)
			{
				System.out.println(i*i);
				st= new StringTokenizer(br.readLine());
				//this is number of test cases
				int n=Integer.parseInt(st.nextToken());
				if(n!=0)
					break;	
			}
		}

	}
}


