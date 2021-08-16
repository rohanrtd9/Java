package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class prime10002 {
	public static void main(String[] args) {
		prime10002 pp= new prime10002();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        int t;
			try {
				t = Integer.parseInt(br.readLine());
				for(int a0 = 0; a0 < t; a0++){
		            int n = Integer.parseInt(br.readLine());
		            int primes[]=new int[n];
		            long startTime =  System.currentTimeMillis();
		            System.out.println(pp.getNthPrime(n, primes));
		            // At the end
		            long endTime = System.currentTimeMillis();
		            System.out.println("It took " + (endTime - startTime) + " milliseconds");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 	
	}
	private int getNthPrime(int n, int a[])
	{
		if (n==1)
			return 2;
		if (n==2)
			return 3;
		a[0]=2;
		a[1]=3;
		int currentPrime=a[1];
		for (int i = 2; i < a.length; i++) {
			currentPrime+=2;
			currentPrime=this.nextPrime(currentPrime,a);
			a[i]=currentPrime;
			
		}
		return a[n-1];
	}
	private int nextPrime(int n,int a[])
	{
		while(!this.isPrime(n,a))
		{
			n+=2;
		}
		return n;
	}
	private boolean isPrime(int n,int a[])
	{
		for (int i = 0; a[i]<=Math.sqrt(n); i++) {
			if(n%a[i]==0)
				return false;
		}
		return true;
	}
}
