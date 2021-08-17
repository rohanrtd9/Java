package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class sumPrimes3 {
	public static void main(String[] args) {
		sumPrimes3 ps= new sumPrimes3();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int tc = Integer.parseInt(br.readLine());
            long sum[]=ps.sumPrimes(20);
            while(tc-->0)
                {
                    int n= Integer.parseInt(br.readLine());
                   
                    System.out.println(sum[n]);
                    
                }
            } 
        catch (Exception e) 
            {
        	e.printStackTrace();
            } 
    }
	private long[] sumPrimes(int N)
	{
		//this function returns the sum of primes upto in an array where index is sum of primes
		//upto that index
		long sum[]=new long[N+1];
		short primes[]= new short[N+1];
		sum[2]=2;
		for (int i = 3; i <=Math.sqrt(N); i+=2) {
			if(primes[i]==0)
			{	
				for (int j = i*i; j < N; j+=(2*i)) {
					primes[j]=1;
				}
			}
		}
		for (int i = 3; i <=N ; i++) {
			if((i&1)==0)
			{
				sum[i]=sum[i-1];
			}
			else
			{
				sum[i]=sum[i-1];
				if(primes[i]==0)
				{
					sum[i]+=i;
				}
			}
			
		}
		
		return sum;
	}

}
