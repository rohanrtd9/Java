package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class sumPrimes2 {
	public static void main(String[] args) {
		sumPrimes2 ps= new sumPrimes2();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int tc = Integer.parseInt(br.readLine());
            while(tc-->0)
                {
                    int n= Integer.parseInt(br.readLine());
                    if(n==1)
                        System.out.println(0);
                    else if(n==2)
                        System.out.println(2);
                    else 
                    {
                        System.out.println(ps.calcPrime(n));
                    }
                    
                    
                }
            } 
        catch (Exception e) 
            {
        	e.printStackTrace();
            } 
    }
    private long calcPrime(int N)
    {
    	long sum=2;
    	sum+=this.oddSum(N);
        int arr[]= new int[N+1];
        int sqrt=(int)Math.sqrt(N);
        for (int i = 3; i <=sqrt; i+=2) {
        	
            if (arr[i]==0)
            {	int mf=2*i;
                for (int j =i*i; j <= N; j+=mf) {
                	if(arr[ j]==0)
                		sum-= j;
                    arr[ j]=1;
                }
            }            
        }
        return sum;
    }
    private long oddSum(int n)
	{
		long nmbr=(long)((n-1)/2);
		return (long )(	(nmbr/2.0)	*	(	6	+(	(nmbr-1)*2	)	)	);
	}
}