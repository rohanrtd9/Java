package ccJul22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class guessingNumbers {

	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		int primes[]=new int[200000];
		
		returnPrimes(primes);
		//loop for doing coding 
		while(tc-->0)
		{
			int a=0,b=0;
			st= new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			while(primes[n]!=0)
			{
				n++;
			}
			if (n>m)
			{
				a=m;
				b=m;
				
			}
			else
			{
				a=n;
				b=m/n;
				b*=a;
			}
			//now we look for smallest prime which is greater than n
			
			//what we can use is a sieve for filtering numbers that are prime upto 2*n
			
			//i.e 2*10^5
			
			
			out.println(a+" "+b);
		}
		out.flush();
	}
	private static void returnPrimes(int n[])
	{
		//this function will return primes after marking non primes with 1
		
		
		// ie primes are marked with 1
		n[0]=1;
		n[1]=1;
		for (int i = 2; 2*i < n.length; i++) {
			n[i*2]=1;
			
		}
		for (int i = 3; 3*i < n.length; i+=2) {
			n[i*3]=1;
		
		}
		for (int i = 6; i < n.length; i+=6) 
		{
			if (n[i-1]==0)
			{for (int j = 2; (i-1)*j< n.length ; j++) {
				n[(i-1)*j]=1;}
			
			}
			if (n[i+1]==0)
			{for (int j = 2; (i+1)*j< n.length ; j++) 
				{
				n[(i+1)*j]=1;
				}
			
			}
			
		}
	}
}
