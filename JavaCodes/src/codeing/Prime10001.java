package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prime10001 {
	public static void main(String[] args) {
		Prime10001 pp= new Prime10001();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        int t;
			try {
				t = Integer.parseInt(br.readLine());
				for(int a0 = 0; a0 < t; a0++){
		            int n = Integer.parseInt(br.readLine());
		            System.out.println(pp.nthPrime(n));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 	        
	        
	}
	private int nthPrime(int n)
	{
		if (n==1)
			return 2;
		if (n==2)
			return 3;
		int currentPrime=3;
		int count=2;
		while (count<n)
		{
			currentPrime+=2;
			currentPrime=this.nextPrime(currentPrime);
			count+=1;
		}
		return currentPrime;
	}
	private int nextPrime(int n)
	{
		while(!this.isPrime(n))
		{
			n+=2;
		}
		return n;
	}
	private boolean isPrime(int n)
	{
		for (int i = 3; i <=(int ) Math.sqrt(n)+1; i+=2) {
			if(n%i==0)
				return false;
		}
		return true;
	}

}
