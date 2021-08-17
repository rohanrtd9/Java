package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class largestPrime {
	public static void main(String[] args) {
		largestPrime lp = new largestPrime();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		try {
			int tc= Integer.parseInt(br.readLine());
			while(tc-->0)
			{
				long n=Long.parseLong(br.readLine());
				System.out.println(lp.returnMaxFactor(n));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	private long returnMaxFactor(long n)
	{	
		long primeFactor=0;
		int sqrt= (int) Math.sqrt(n);
		int currentDiv=2;
		//this function returns the max prime factor of given number
		while(n>0 && currentDiv<=sqrt)
		{
			while(n%currentDiv==0)
			{
				n=n/currentDiv;
			}
			if (n==1)
				primeFactor=currentDiv;
			currentDiv+=1;
		}
		return primeFactor==0?n:primeFactor;
	}

}
