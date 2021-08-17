package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GBPrimes {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());

		int primes[]=new int[1000000+2];
		primes[0]=1;
		primes[1]=1;

		for (int j = 4; j < primes.length; j+=2) {
			primes[j]=1;
		}

		for (int i = 3; i <= 1000; i+=2) {
			for (int j = i*i; j < primes.length; j+=(2*i)) {
				primes[j]=1;
			}
		}
		int count[]=new int[1000000+2];
		for (int i = 3; i < count.length; i++) 
		{
			if (primes[i]==1)
				continue;
			if(i+2<count.length)
				if (primes[i+2]==0)
					count[i+2]=1;
		}
		for (int i = 1; i < count.length; i++) {
			count[i]=count[i]+count[i-1];
		}
		//loop for doing coding 
		while(tc-->0)
		{
			int n=Integer.parseInt(br.readLine());




			out.println(count[n]);
		}
		out.flush();
	}

}
