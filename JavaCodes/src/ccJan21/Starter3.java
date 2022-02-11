package ccJan21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Starter3 {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		int primes[]=new int[100];
		Starter3 s3=new Starter3();
		
		
		//loop for doing coding 
		while(tc-->0)
		{
			st= new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			
			
			int res=0;
			int primeFactorCountM= s3.returnPrimeFactorsCount(m);
			
			
			for (int i = 1; i <=primeFactorCountM; i++) {
				if (n%i==0)
					res=i;
			}
			
			out.println(res);
		}
		out.flush();
	}
	
	private int returnPrimeFactorsCount(int n)
	{
		return 0;
	}
}