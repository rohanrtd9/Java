package ProjectEuler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Euler27QuadraticPrimes {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this value of n
		int n=Integer.parseInt(st.nextToken());
		int primes[]=new int[n*n*2+2002];
		popPrimes(primes);
		int maxPrimeCount=-1;
		int maxA=0,maxB=0;
		for (int a = n*-1; a <=n; a++) 
		{
			for (int b = n*-1; b <=n; b++) 
			{
				int nn=0;
				while(isPrime(a,b,nn,primes))
				{
					nn++;
					
				}
				if (nn>maxPrimeCount)
				{
					maxA=a;
					maxB=b;
					maxPrimeCount=nn;
				}
			}
		}
		System.out.println(maxA+" "+maxB);
		
	}
	private static boolean isPrime(int a,int b,int n,int primes[])
	{
		int val=n*n;
		val+=n*a;
		val+=b;
		if (val<0)
			return false;
		if (primes[val]==0)
			return true;
		return false;
	}
	private static void popPrimes(int primes[])
	
	{
		//this function seives the prime numbers
		int limit=(int) Math.sqrt(primes.length);
		primes[0]=1;
		primes[1]=1;
		for (int i = 4; i < primes.length; i+=2) 
		{
			primes[i]=1;
		}
		for (int i = 3; i <=Math.sqrt(primes.length); i+=2) {
			for (int j = i*i; j < primes.length; j+=2*i) 
			{
				primes[j]=1;
			}	
		}
	}
}